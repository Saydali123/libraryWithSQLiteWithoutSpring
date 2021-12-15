package uz.elmurodov.mapper;

/**
 * @author Elmurodov Javohir, Tue 3:26 PM. 12/14/2021
 */

import uz.elmurodov.dto.BaseDto;
import uz.elmurodov.dto.BaseGenericDto;
import uz.elmurodov.model.BaseEntity;

import java.util.List;

/**
 * dto -> Data transfer object
 *
 * @param <E>  -> Entity(Model)
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UP> -> Update Dto
 */
public interface BaseMapper<
        E extends BaseEntity,
        D extends BaseGenericDto,
        CD extends BaseDto,
        UP extends BaseGenericDto> {

    D to(E e);

    List<D> to(List<E> e);

    E from(D d);
}
