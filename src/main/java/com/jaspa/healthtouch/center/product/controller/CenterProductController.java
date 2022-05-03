package com.jaspa.healthtouch.center.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.center.product.model.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/center/product")
public class CenterProductController {
	
	private ProductService productService;
	
	@Autowired
	public CenterProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/membership/list")
	public ModelAndView selectMembershipList(ModelAndView mv) {
		
		List<ProductDTO> membershipList = productService.findAllMembership();
		
		log.info("membershipList : {}", membershipList);
		
		/* addObject 키값 안넣어줘서 html로 값이 안넘어감 */
		mv.addObject("membershipList",membershipList);
		mv.setViewName("center/product/proMembership");
		
		return mv;
		
	}
	
}
