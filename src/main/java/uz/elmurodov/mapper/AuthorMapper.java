package uz.elmurodov.mapper;

import uz.elmurodov.dto.author.AuthDto;
import uz.elmurodov.dto.BaseDto;
import uz.elmurodov.dto.BaseGenericDto;
import uz.elmurodov.dto.author.AuthorCreateDto;
import uz.elmurodov.model.Author;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Elmurodov Javohir, Tue 3:36 PM. 12/14/2021
 */
public class AuthorMapper implements BaseMapper<Author, AuthDto, BaseDto, BaseGenericDto> {
    public static AuthorMapper instance;

    @Override
    public AuthDto to(Author author) {
        return AuthDto.childBuilder()
                .id(author.getId())
                .fullName(author.getFullName())
                .birthdate(author.getBirthdate().toString())
                .build();
    }

    @Override
    public List<AuthDto> to(List<Author> e) {
        return e.stream().map(this::to).collect(Collectors.toList());
    }

    @Override
    public Author from(AuthDto authDto) {
        return null;
    }

    public static AuthorMapper getInstance() {
        if (instance == null) instance = new AuthorMapper();
        return instance;
    }

    public Author fromCreateDto(AuthorCreateDto dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Author.childBuilder()
                .fullName(dto.getFullName())
                .birthdate(dto.getBirthdate())
                .build();
    }
}
