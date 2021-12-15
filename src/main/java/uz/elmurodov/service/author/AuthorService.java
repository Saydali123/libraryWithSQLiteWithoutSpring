package uz.elmurodov.service.author;

import uz.elmurodov.dto.author.AuthDto;
import uz.elmurodov.dto.author.AuthorCreateDto;
import uz.elmurodov.http.Data;
import uz.elmurodov.http.HttpStatus;
import uz.elmurodov.http.ResponseEntity;
import uz.elmurodov.mapper.AuthorMapper;
import uz.elmurodov.model.Author;
import uz.elmurodov.repository.AuthorRepository;
import uz.elmurodov.service.AbstractService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elmurodov Javohir, Tue 3:35 PM. 12/14/2021
 */
public class AuthorService extends AbstractService<AuthorRepository, AuthorMapper> {
    private static AuthorService instance;

    private AuthorService() {
        super(AuthorRepository.getInstance(), AuthorMapper.getInstance());
    }


    public ResponseEntity<Data<HttpStatus>> create(AuthorCreateDto dto) {
        Author author = mapper.fromCreateDto(dto);
        repository.save(author);
        return new ResponseEntity<>(new Data<>(HttpStatus.HTTP_OK));
    }

    public ResponseEntity<Data<List<Author>>> getAll() {
        List<Author> authors = repository.getAll();
        Integer total = authors.size();
        return new ResponseEntity<>(new Data<>(authors, total), HttpStatus.HTTP_OK);
    }

    public static AuthorService getInstance() {
        if (instance == null) instance = new AuthorService();
        return instance;
    }

    public ResponseEntity<Data<String>> delete(int id) {
        repository.delete(id);
        return new ResponseEntity<>(new Data<>("Deleted"));
    }

    public boolean checkNameForExisting(String str) {
        for (Author author : repository.getAll()) {
            if (author.getFullName().equalsIgnoreCase(str))
                return true;
        }
        return false;
    }

    public Author checkNameForExist(String str) {
        for (Author author : repository.getAll()) {
            if (author.getFullName().equalsIgnoreCase(str))
                return author;
        }
        return null;
    }

    public ResponseEntity<Data<String>> update(String auth, String birth) {
        Author author = checkNameForExist(auth);
        repository.update(author, birth);
        return new ResponseEntity<>(new Data<>("Updated"), HttpStatus.HTTP_OK);
    }

    public ResponseEntity<Data<List<AuthDto>>> search(String str) {
        List<Author> authors = repository.search(str);
        if (authors.size() == 0) {
            return new ResponseEntity<Data<List<AuthDto>>>(new Data<List<AuthDto>>(new
                    ArrayList<>(), HttpStatus.HTTP_NOT_FOUND.getCode()));
        } else {
            List<AuthDto> authDtos = mapper.to(authors);
            return new ResponseEntity<Data<List<AuthDto>>>(new Data<List<AuthDto>>(authDtos));
        }
    }
}
