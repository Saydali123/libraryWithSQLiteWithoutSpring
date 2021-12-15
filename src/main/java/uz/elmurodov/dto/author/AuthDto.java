package uz.elmurodov.dto.author;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.elmurodov.dto.BaseGenericDto;
import uz.elmurodov.model.Book;

import java.util.List;

/**
 * @author Elmurodov Javohir, Tue 3:51 PM. 12/14/2021
 */

@Getter
@Setter
@ToString(callSuper = true)
public class AuthDto extends BaseGenericDto {
    private String fullName;
    private String birthdate;
    private List<Book> books;

    @Builder(builderMethodName = "childBuilder")
    public AuthDto(Long id, String fullName, String birthdate, List<Book> books) {
        super(id);
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.books = books;
    }
}
