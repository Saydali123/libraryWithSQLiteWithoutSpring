package uz.elmurodov.service;

import uz.elmurodov.mapper.BaseMapper;
import uz.elmurodov.repository.BaseRepository;

/**
 * @author Elmurodov Javohir, Tue 3:25 PM. 12/14/2021
 */

/**
 * @param <R> -> Repository
 * @param <M> -> Mapper
 */


public class AbstractService<R extends BaseRepository, M extends BaseMapper> {
    protected R repository;
    protected M mapper;

    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
