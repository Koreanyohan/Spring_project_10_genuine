package com.example.demo.repository;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;

@SpringBootTest
public class CommentRepositoryTest {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Test
	void 게시물등록() {		
		Member member = Member.builder().id("user1").build();
		
		Board board = Board.builder().no(7).build();
		
		Comment comment = Comment.builder()
				.board(board).writer(member).build();
		
		commentRepository.save(comment);
	}
	
	@Test
	void 게시물별_댓글목록조회() {
		// 게시물 객체 생성
		Board board = Board.builder().no(6).build();
		
		// 6번 게시물을 기준으로 댓글 목록 조회
		List<Comment> list = commentRepository.findByBoard(board);
		
		
		for(Comment comment : list) {
			System.out.println(comment);
		}
		
	}
	
	@Test
	void 게시물별_댓글일괄삭제() {
		Board board = Board.builder().no(6).build();
		
		commentRepository.deleteByBoard(board);
	}
	
}










