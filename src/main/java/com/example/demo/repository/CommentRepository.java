// 9장 p.8
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;

import jakarta.transaction.Transactional;

@Transactional 	// 밑에서와 같이 이렇게 손수 만든 메서드 같은 경우, transactional해주어야 db에 반영된다. 조회의 경우 transaction 처리 필요없음. 등록수정삭제는 이거 달아줘야.
public interface CommentRepository extends JpaRepository<Comment, Integer>{ // 담을 entity 타입, entity의 pk타입(<-int commentNo)

	/* 쿼리메서드로 만든거임. 3장 참고 */	
	List<Comment> findByBoard (Board board);
	
	void deleteByBoard (Board board);	

}
































