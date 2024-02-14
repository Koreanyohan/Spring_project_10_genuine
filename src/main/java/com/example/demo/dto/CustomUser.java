package com.example.demo.dto;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

// 10장 p.28-29
public class CustomUser extends User { // 스프링 시큐리티의 User 클래스를 상속받는다.
	
	public CustomUser (MemberDTO dto) { 
		super(dto.getId(), dto.getPassword(), Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));
		// ㄴ 부모클래스(User)의 생성자를 호출하여 인증 객체를 생성한다. 권한은 시큐리티에서 사용하는 SimpleGrantedAuthority로 변환한다..
	
	}
}
