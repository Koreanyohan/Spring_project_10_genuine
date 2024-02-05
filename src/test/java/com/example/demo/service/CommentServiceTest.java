// 9장 p.14 이후 테스트
package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CommentDTO;

@SpringBootTest
public class CommentServiceTest {

	@Autowired
	CommentService commentService;
	
	@Test
	void 댓글등록() {
		// Board, Member db에 있는 값 입력해야.
		CommentDTO dto = CommentDTO.builder()
						.boardNo(3).writer("JJanggu") //Board, Member pk 입력은 필수조건.
						.build();				
		// cf) CommentDTO의 commentNo, regDate, modDate는 시스템에서 자동 입력해줌 
		
		commentService.register(dto);			
	}
	
	@Test
	void 게시물별_댓글목록조회() {
		
		List<CommentDTO> list = commentService.getListByBoardNo(6);
		
		for(CommentDTO dto : list) {
			System.out.println(dto);
		}
	}	
	
	@Test
	void 댓글삭제() {
		
		commentService.remove(11);		
	}
	
}









