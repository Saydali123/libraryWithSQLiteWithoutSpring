package uz.elmurodov.ui.author;

import uz.elmurodov.dto.author.AuthDto;
import uz.elmurodov.dto.author.AuthorCreateDto;
import uz.elmurodov.http.Data;
import uz.elmurodov.http.HttpStatus;
import uz.elmurodov.http.ResponseEntity;
import uz.elmurodov.model.Author;
import uz.elmurodov.service.author.AuthorService;
import uz.elmurodov.utils.BaseUtils;
import uz.elmurodov.utils.Print;

import java.util.List;

import static uz.elmurodov.utils.Color.*;
import static uz.elmurodov.utils.Input.getNum;
import static uz.elmurodov.utils.Input.getStr;

/**
 * @author Elmurodov Javohir, Tue 3:45 PM. 12/14/2021
 */
public class AuthorUI {
    private static final AuthorService authorService = AuthorService.getInstance();

    public static void create() {
        String fullName = getStr("Full Name : ");
        String birthDateAsString = getStr("Please Your Birthdate(2021-01-23) : ");
        ResponseEntity<Data<HttpStatus>> response = authorService.
                create(new AuthorCreateDto(fullName, birthDateAsString));
//        show(response);
    }

    public static void getALL() {
        ResponseEntity<Data<List<Author>>> response = authorService.getAll();
        show(response);
    }

    private static void show(ResponseEntity<Data<List<Author>>> response) {
        Print.println(BaseUtils.withoutNulls().toJson(response.getBody()));
    }

    public static void get() {
        String str = getStr("Enter text to search: ");
        ResponseEntity<Data<List<AuthDto>>> response = authorService.search(str);
        response.getBody().getData().forEach(n -> Print.println(YELLOW, n));
    }

    public static void update() {
        authorService.getAll().getBody().getData().forEach(n -> Print.println(CYAN, n.getFullName()));
        String str = getStr("Enter fullName: ");
        if (authorService.checkNameForExisting(str)) {
            Print.println(GREEN, "Name fount");
            Print.println(GREEN, "-----------------------------------");
            String birth = getStr("Enter birthday to update: ");
            ResponseEntity<Data<String>> response = authorService.update(str, birth);

            return;
        } else {
            Print.println(RED, "Wrong name");
        }
        update();
    }

    public static void delete() {
        int i = authorService.getAll().getBody().getTotal();
        int id;
//        do {
        String str = String.format("Enter id(1-%d): ", i);
        id = getNum(str);
//        } while (id < 1 || id > i);

        ResponseEntity<Data<String>> response = authorService.delete(id);
    }


    public static void back() {

    }
}

