package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	
	// 9장 p.15  게시물번호 -> 댓글목록조회
	@ResponseBody
	@GetMapping("/list")
	List<CommentDTO> list(@RequestParam(name="boardNo") int boardNo){
						  // ㄴ => http://localhost:8080/comment/list?boardNo=6 같이 가능.
		List<CommentDTO> commentlist = service.getListByBoardNo(boardNo);
		
		return commentlist; //이전과 다르게 url->순수자료형(must be 객체) 보내기(<-ResponseBody 이용 json으로 바꿔서 보냄(by 'jackson' libray)
		// 순수형태 => postman에서 테스트 okay
		
	}
	
	
	// 9장 p.18 댓글등록
	
	@ResponseBody
	@PostMapping("/register")
	public HashMap<String,Boolean> register(CommentDTO dto) {
		//맵 객체 생성		
		HashMap<String,Boolean> map = new HashMap<>();
		
		// 임시 아이디
		String id = "JJanggu"; // member table에 있는 값이어야.
		dto.setWriter(id); 
	 //  ㄴ 원래는 아이디를 security 기능으로 받아야 하는데, 아직 구현 안되었으니 임시로 이렇게 설정. cf)boardNo는 화면에서 boardNo받으면 됨.
		
		// 새로운 댓글 등록
		service.register(dto);

		// 처리결과 반환 - 원래 true인경우, false인경우 두가지 상정해야 하지만, 지금은 validation기능 구현 안해서 성공하는 경우밖에 생각못함.
		map.put("success", true); // key값, 실제value => "sucess" : true
		return map;
		
	}	
	
	
	// 9장 p.19 댓글삭제
	
	@ResponseBody
	@GetMapping("/remove")
	public HashMap<String,Boolean> remove(@RequestParam (name="commentNo") int commentNo){
		// 맵 객체 생성
		HashMap<String,Boolean> map = new HashMap<>();
		
		// 댓글 삭제
		boolean result = service.remove(commentNo);
		
		// 처리결과 반환
		map.put("success", result);
		
		return map;	
		
	}
}


































