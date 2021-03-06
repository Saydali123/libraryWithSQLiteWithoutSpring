package uz.elmurodov.dto;

import lombok.*;

/**
 * @author Elmurodov Javohir, Tue 3:51 PM. 12/14/2021
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BaseGenericDto implements BaseDto {
    private Long id;

}
