package com.mysite.sbb.payment;

import java.time.LocalDateTime;
import java.util.Set;

import com.mysite.sbb.product.Product;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId; // 결제 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private SiteUser user; // 결제한 사용자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product; // 결제한 상품

    private Integer paymentAmount; // 결제 금액

    private LocalDateTime paymentDate; // 결제 날짜

    private String paymentStatus; // 결제 상태 ('SUCCESS','FAIL','PENDING')

    private String transactionId; // 거래 ID(결제 시스템에서 제공하는 거래 ID)

    private String paymentMethod; // 결제 방법 (카드, 포인트 등)

    private String paymentType; // 결제 유형(일반 결제, 포인트 결제...)

    private LocalDateTime createDate = LocalDateTime.now(); // 생성일

    private LocalDateTime modifyDate; // 수정일
    
}