package com.mysite.sbb.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	private String provider; // 일반로그인 / 구글로그인
	
	private String providerId; // 외부로그인 시 제공하는 id값
	
	private String createDt; // 생성일
	
	private String modifyDt; // 마지막 수정일
	
	private String useYn; // 사용여부

}
