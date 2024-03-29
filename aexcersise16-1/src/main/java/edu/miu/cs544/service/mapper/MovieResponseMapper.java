package edu.miu.cs544.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs544.domain.Movie;
import edu.miu.cs544.service.response.MovieResponse;
import ma.glasnost.orika.MapperFactory;


@Component
public class MovieResponseMapper extends BaseMapper<Movie, MovieResponse>{

	
	@Autowired
	public MovieResponseMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Movie.class, MovieResponse.class);
		// TODO Auto-generated constructor stub
	}

}
