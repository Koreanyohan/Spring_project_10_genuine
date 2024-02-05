package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentDTO {
		int commentNo; // 댓글번호 .시스템이 자동처리
	
	int boardNo;	// 글번호 (화면에서 받아올것) [<=Board]
	
		String content; // 내용 (사용자가 입력)
	
	String writer;	// 작성자 (시큐리티 적용되어야. 나중에 학습) [<=Member]
	
		LocalDateTime regDate;	// 등록일 .시스템이 자동처리
	
		LocalDateTime modDate; // 수정일 .시스템이 자동처리
}




