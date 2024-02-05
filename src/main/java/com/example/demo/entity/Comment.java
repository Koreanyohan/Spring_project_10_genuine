// 9장 p.8
package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Comment extends BaseEntity {
	@Id // pk지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increament옵션
	int commentNo; //번호
	
	@ManyToOne // 
	Board board; //게시물 - 하나의 게시물(one) 여러개 댓글(many) 가질 수 있음. 
	
	@Column(length=1500)
	String content; // 내용
	
	@ManyToOne
	Member writer; //작성자 - 하나의 작성자(one) 여러개 댓글(many) 가질 수 있음.
}






