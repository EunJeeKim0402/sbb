package com.mysite.sbb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.sbb.product.Product;
import com.mysite.sbb.product.ProductService;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.UserService;

@Controller
public class MainController {
	
	private final QuestionService questionService;
	private final UserService userService;
	private final ProductService productService;
	
    public MainController(QuestionService questionService, UserService userService, ProductService productService) {
        this.questionService = questionService;
        this.userService = userService;
        this.productService = productService;
    }
	
	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "ㅎㅇsbb";
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/main";
	}
	
	@GetMapping("/main")
	public String login(Model model, @RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value = "kw", defaultValue = "") String kw) {
		Page<Question> paging = this.questionService.getList(page, kw);
		List<Product> productPaging = this.productService.getList();
		List<Product> productLists = productPaging.stream().limit(4).collect(Collectors.toList());
		
		List<Product> topProducts = this.productService.findBySellCount();
		
		model.addAttribute("paging", paging);
		model.addAttribute("productLists", productLists);
		model.addAttribute("topProducts", topProducts);
		model.addAttribute("kw", kw);
	    return "main";
	}
}
