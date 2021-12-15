package uz.elmurodov.ui.author;

import uz.elmurodov.dto.author.AuthorCreateDto;
import uz.elmurodov.http.Data;
import uz.elmurodov.http.ResponseEntity;
import uz.elmurodov.model.Author;
import uz.elmurodov.service.author.AuthorService;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.List;

/**
 * @author Elmurodov Javohir, Tue 3:45 PM. 12/14/2021
 */
public class AuthorUI {
    private static AuthorService authorService = AuthorService.getInstance();

    public static void create() {
        String fullName = Input.getStr("Full Name : ");
        String birthDateAsString = Input.getStr("Please Your Birthdate(2021-01-23) : ");
        authorService.create(new AuthorCreateDto(fullName, birthDateAsString));
    }

    public static void getALL() {
        ResponseEntity<Data<List<Author>>> response = authorService.getAll();
        show(response);
    }

    private static void show(ResponseEntity<Data<List<Author>>> response) {
        Print.println(BaseUtils.withoutNulls().toJson(response.getBody()));
    }

    public static void get() {

    }

    public static void update() {

    }

    public static void delete() {

    }


    public static void back() {

    }
}

