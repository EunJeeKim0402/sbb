package com.mysite.sbb.product;

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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(columnDefinition = "TEXT")
	private String productName;
	
	private String productType;
	
	private Integer productPrice;
	
	private String productImage;
	
	private LocalDateTime productCreateDt;
	
	private String productCreateId;
	
	private LocalDateTime productModifyDt;
	
	private Integer productSellCount;
	
}
