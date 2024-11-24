package com.mysite.sbb.product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerService;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/product")
@RequiredArgsConstructor
@Controller
public class ProductController {
	
	private final ProductService productService;
	
	// 상품 리스트
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
		List<Product> paging = this.productService.getList();
		model.addAttribute("paging", paging);
		return "";
	}
	
	// 상품 상세페이지
	@GetMapping("/product_detail")
	public String productDetail(Model model, @RequestParam("productId") int productId) {
	    Product product = productService.findProductById(productId); 
	    model.addAttribute("product", product);
	    return "product_detail";
	}

}
