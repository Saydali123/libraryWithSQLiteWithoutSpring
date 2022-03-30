package uz.elmurodov.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Elmurodov Javohir, Tue 3:18 PM. 12/14/2021
 */
@Getter
@Setter
public class Author extends Auditable {
    private String fullName;
    private String birthdate;

    @Builder(builderMethodName = "childBuilder")
    public Author(Long id, String fullName, String birthdate) {
        super(id);
        this.fullName = fullName;
        this.birthdate = birthdate;
    }
}
