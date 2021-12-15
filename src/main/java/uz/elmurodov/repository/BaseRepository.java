package uz.elmurodov.repository;

import uz.elmurodov.model.BaseEntity;

/**
 * @author Elmurodov Javohir, Tue 3:27 PM. 12/14/2021
 */

/**
 * @param <E> -> Entity
 */
public interface BaseRepository<E extends BaseEntity> {
    void save(E entity);
}
