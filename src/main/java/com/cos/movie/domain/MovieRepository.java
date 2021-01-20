package com.cos.movie.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cos.movie.domain.dto.JoinReqDto;
import com.cos.movie.domain.dto.UpdateReqDto;

// 더미데이터
@Repository
public class MovieRepository {

	// 전체 영화 가져오기
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, 9.1, "어벤져스", null));
		movies.add(new Movie(2, 9.2, "어벤져스 : 에이지 오브 울트론", null));
		movies.add(new Movie(3, 9.3, "어벤져스 : 인피니티 워", null));
		movies.add(new Movie(4, 9.4, "어벤져스 : 엔드게임", null));
		movies.add(new Movie(5, 9.5, "캡틴 아메리카 : 윈터솔저", null));
		return movies;
	}

	// 영화 1건 가져오기
	public Movie findById(int id) { // 영화 한건 가져오기
		return new Movie(id, 0.0, "아무 영화", null);
	}

	// 영화 등록
	public Movie save(JoinReqDto dto) {
		if (dto.getTitle() != null) {
			System.out.println(dto.getTitle() + "가 추가되었습니다.");
			return new Movie(9, dto.getRating(), dto.getTitle(), null);
		}
		return null;
	}

	// 영화 삭제
	public void delete(int id) {
		System.out.println("id: " + id + "번 영화 삭제");
	}

	// 영화 수정
	public Movie update(int id, UpdateReqDto dto) {
		System.out.println(id + "번 영화 : " + dto.getTitle() + "평점 : " + dto.getRating() + "\n 수정");
		return new Movie(id, dto.getRating(), dto.getTitle(), null);
	}
}
