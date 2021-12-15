package uz.elmurodov.service.author;

import uz.elmurodov.dto.author.AuthorCreateDto;
import uz.elmurodov.http.Data;
import uz.elmurodov.http.HttpStatus;
import uz.elmurodov.http.ResponseEntity;
import uz.elmurodov.mapper.AuthorMapper;
import uz.elmurodov.model.Author;
import uz.elmurodov.repository.AuthorRepository;
import uz.elmurodov.service.AbstractService;

import java.util.List;

/**
 * @author Elmurodov Javohir, Tue 3:35 PM. 12/14/2021
 */
public class AuthorService extends AbstractService<AuthorRepository, AuthorMapper> {
    private static AuthorService instance;

    private AuthorService() {
        super(AuthorRepository.getInstance(), AuthorMapper.getInstance());
    }


    public ResponseEntity<Data<Integer>> create(AuthorCreateDto dto) {
        Author author = mapper.fromCreateDto(dto);
        repository.save(author);
        return new ResponseEntity<>(new Data<>(12));
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
}
