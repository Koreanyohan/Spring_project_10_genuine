// 10장 p. 30~31

package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomUser;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

@Service // 이거 안붙였더니 로그인이 계속 안됬음. 자격 증명에 실패하였습니다. 뜨면서
public class UserDetailsServiceImpl implements UserDetailsService{ // 스프링 시큐리티의 UserDetailsService 인터페이스를 상속받는다.
//	스프링 시큐리티는 인증 처리시, UserDetailService라는 인증 서비스를 사용한다.
//	UserDetailService는 사용정보를 가지고 온다.

	@Autowired
	private MemberService service;

	/* 10장 p.32
	 * 사용자 커스텀 로그인 인증 서비스
	 * 상속받은 UserDetailsService의 loadUserByUsername를 오버라이드 하여 사용자 정보를 조회하고 인증객체를 생성한다
	 * 유저 인증서비스는 provider에 등록한다  */
	
	//사용자 아이디를 기반으로 인증객체를 생성하는 메서드
	@Override
	public UserDetails loadUserByUsername(String userName) {// userName는 아이디를 의미
		
		System.out.println("login id : " + userName);
		
		// MemberDTO아이디로 실제 회원정보 가져오기
		MemberDTO dto = service.read(userName); // userName에 해당하는 Member엔티티값 꺼내서 dto값으로 바꾸는 read메서드 이용
		
		if(dto==null) {
			throw new UsernameNotFoundException(""); // 사용자 정보가 없다면 에러를 발생시킴
		} else {
		return new CustomUser(dto); // dto를 인증객체로 변환하여 User상속받는 CustomUser를 UserDetails타입으로 인증객체로서 반환
	}
}
}
	
