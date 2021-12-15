package uz.elmurodov.dto.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.dto.BaseDto;

/**
 * @author Elmurodov Javohir, Tue 4:38 PM. 12/14/2021
 */
@Getter
@Setter
@AllArgsConstructor
public class AuthorCreateDto implements BaseDto {
    private String fullName;
    private String birthdate;
}
