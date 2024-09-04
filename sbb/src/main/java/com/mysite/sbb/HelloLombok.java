package com.mysite.sbb;

import lombok.Getter;
//import lombok.Setter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
//@Setter
public class HelloLombok {
	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		HelloLombok hl = new HelloLombok("ㅎㅇ", 5);
//		hl.setHello("ㅎㅇ");
//		hl.setLombok(5);
		
		System.out.println(hl.getHello());
		System.out.println(hl.getLombok());
	}
}
