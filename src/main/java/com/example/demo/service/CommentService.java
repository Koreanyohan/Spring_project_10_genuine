// 9장 p.13
package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;
 
public interface CommentService {
	// 댓글 등록 메서드
	int register (CommentDTO dto);
	
	// 게시물을 기준으로 댓글 목록을 조회하는 메서드
	List<CommentDTO> getListByBoardNo(int boardNo);
	
	/*
	 * // 댓글 삭제 메서드 void remove(int no);
	 */	
	
	// 댓글 삭제 메서드
		boolean remove(int no);
	
		
	// dto => Entity 반환
	default Comment dtoToEntity (CommentDTO dto ) {
		// CommentDTO에서 작성자 꺼내서 멤버(Member) entity 만들기
		Member member = Member.builder().id(dto.getWriter()).build();
		// CommentDTO에서 게시물번호 꺼내서 게시물(Board) entity 만들기		
		Board board = Board.builder().no(dto.getBoardNo()).build();
		
		// CommentDTO에서 값 꺼내서 댓글(Comment) entity 생성
		Comment entity = Comment.builder()
				.commentNo(dto.getCommentNo())
					.board(board)
				.content(dto.getContent())
					.writer(member)
				.build();
				
		return entity;		
	}
	
	// Entity => dto 반환
	default CommentDTO entityToDTO (Comment entity) {
		CommentDTO dto = CommentDTO.builder()
					.commentNo(entity.getCommentNo())
				.boardNo(entity.getBoard().getNo()) 
// entity의 멤변 Board(Board 타입)의 멤변 no(int) => CommentDTO의 멤변 boardNo(int)에 넣어줌
					.content(entity.getContent())
				.writer(entity.getWriter().getId()) 
// entity의 멤변 Writer(Member 타입)의 멤변 Id(string)=> CommentDTO의 멤변 writer (String)에 넣어줌
					.regDate(entity.getRegDate())
					.modDate(entity.getModDate())
				.build();				
		return dto;
	}
	
	
	
	
	
	
	
	/*
	 * 
	 * Page<CommentDTO> getList(int pageNumber); // ㄴ 회원 리스트+페이지 정보
	 * 
	 * // 엔티티를 DTO로 변환하는 메서드 (엔티티에서 dto추출해야 화면 view단에 넘겨줄 수 있으니까) default CommentDTO
	 * entityToDto(Comment entity) {
	 * 
	 * CommentDTO dto = CommentDTO.builder()
	 * .commentNo(entity.getCommentNo()).board(entity.getBoard().getNo())
	 * .content(entity.getContent()) .writer(entity.getWriter().getId())
	 * .regDate(entity.getRegDate()).modDate(entity.getModDate()) .build();
	 * 
	 * return dto; };
	 * 
	 * 
	 * // 2. 회원 단건 조회(상세조회) (8장 p.51) CommentDTO read(int commentNo);
	 * 
	 * 
	 * // 3. 회원 등록 (8장 p.42) boolean register(CommentDTO dto); // 회원등록시에 dto를 엔티티로
	 * 바꿔야 repository에 저장할 수 있지. ↓ // 회원등록 성공실패유무 알려주기 위해서 boolean으로 반환값 설정됨. //엔티티를
	 * DTO로 변환하는 메서드
	 * 
	 * 
	 * 
	 * default Member dtoToEntity (CommentDTO dto) { Comment comment =
	 * Comment.builder()
	 * .commentNo(dto.getCommentNo()).board(dto.getBoard()).writer(dto.getWriter())
	 * .build(); // cf) dto에서 입력받을때 regDate, modDate는 우리가 입력한 값이 아니므로 객체 생성시 넣지 않음.
	 * return comment; }
	 */
	
}
