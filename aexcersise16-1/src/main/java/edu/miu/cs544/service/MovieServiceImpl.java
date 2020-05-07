package edu.miu.cs544.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadServiceImpl;
import edu.miu.cs544.domain.Movie;
import edu.miu.cs544.service.response.MovieResponse;


@Service
@Transactional
public class MovieServiceImpl extends BaseReadServiceImpl<MovieResponse, Movie, Integer> implements MovieService {



}
