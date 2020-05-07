package edu.miu.cs544.repository;


import org.springframework.stereotype.Repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs544.domain.Movie;

@Repository
public interface MyEntityRepository extends BaseRepository<Movie, Integer>{

}
