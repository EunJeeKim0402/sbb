package com.mysite.sbb.customerOrder;

import java.time.LocalDateTime;
import java.util.Set;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderKey; // 주문번호
	
	private String userId; // 회원id
	
	private Integer totalPrice; // 총결제금액
	
	private LocalDateTime orderDate; // 주문일자
	
	private String card; // 결제 카드회사
	
	private String status; // 주문현황
	
	private String reason; // 환불사유
	
	private String toName; // 받는사람 이름
	
	private String zipcode; // 우편번호
	
	private String addr; // 받는사람 주소
	
	private String addrDetail; // 받는사람 주소 상세
	
	private String phone; // 받는사람 전화번호
	
	private String req; // 배송요청사항
	
	private int itemCnt; // 주문상품개수
	
}
