// 8장 p.58
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// 메인화면
	@GetMapping("/")  // 아무 url없는 메인창 만들기
	public String home() {
		
		return "/home/main";
		
	}
	
	// 10장 p.41 커스텀 로그인 페이지 반환하는 메서드
	// controller & view단만 만들어주면됨. 서비스, repository 필요 없음.
	@GetMapping("/customlogin")
	public String customLogin() {
		return "home/login";
	}
	
}






