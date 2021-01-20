package com.cos.movie.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class JoinReqDto {
	
	@NotNull(message = "fail")
	@NotBlank(message = "fail")
	private String title;

	@NotNull(message = "fail")
	private double rating;
}
