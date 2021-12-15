package uz.elmurodov.model;

import lombok.*;

/**
 * @author Elmurodov Javohir, Tue 3:20 PM. 12/14/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Auditable implements BaseEntity {
    private Long id;
}
