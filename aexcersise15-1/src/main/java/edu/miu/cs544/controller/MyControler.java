package edu.miu.cs544.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.common.controller.BaseReadController;
import edu.miu.cs544.domain.Movie;
import edu.miu.cs544.service.response.MovieResponse;

@RestController
@RequestMapping("/")
public class MyControler extends BaseReadController<MovieResponse, Movie, Integer> {
	
}
