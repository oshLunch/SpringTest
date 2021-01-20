package com.cos.movie.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.dto.CommonDto;
import com.cos.movie.domain.dto.JoinReqDto;
import com.cos.movie.domain.dto.UpdateReqDto;

@RestController
public class MovieController {
	private MovieRepository movieRepository;

	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	// http://localhost:8000/movie
	@GetMapping("/movie")
	public CommonDto<List<Movie>> findAll() {
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findAll());
		// MessageConverter (JavaObject -> Json String)
	}

	// http://localhost:8000/movie/1
	@GetMapping("/movie/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) {
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findById(id));
	}

	@CrossOrigin
	@PostMapping("/movie")
	public CommonDto<String> save(@Valid @RequestBody JoinReqDto dto, BindingResult bindingResult) {
		movieRepository.save(dto);
		
		if (dto.getTitle().equals("") || dto.getTitle().equals(null)) {
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
		} 
		
		return new CommonDto<>(HttpStatus.OK.value(), "ok");
	}

	// http://localhost:8000/movie/1
	@DeleteMapping("/movie/{id}")
	public CommonDto delete(@PathVariable int id) {
		movieRepository.delete(id);
		
		if (id > 100 || id < 0) {
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
		}
		
		return new CommonDto<>(HttpStatus.OK.value(), "ok");
	}

	// http://localhost:8000/movie/1
	@PutMapping("/movie/{id}")
	public CommonDto update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		movieRepository.update(id, dto);

		if (dto.getTitle().equals("") || dto.getTitle().equals(null)) { // 제목데이터값이 없으면 BODY데이터 실패로 간주
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
		}

		return new CommonDto<>(HttpStatus.OK.value(), "ok");
	}
}
