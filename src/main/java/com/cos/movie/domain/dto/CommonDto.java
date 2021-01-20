package com.cos.movie.domain.dto;

import lombok.Data;

@Data
public class CommonDto<T> {
	private int statusCode;
	private T data;

	public CommonDto(int statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public CommonDto(int statusCode, T data) {
		super();
		this.statusCode = statusCode;
		this.data = data;
	}
}
