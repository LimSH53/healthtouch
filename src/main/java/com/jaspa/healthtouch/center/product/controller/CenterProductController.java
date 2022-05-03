package com.jaspa.healthtouch.center.product.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaspa.healthtouch.center.product.model.dto.ProductDTO;
import com.jaspa.healthtouch.center.product.model.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/center/product")
public class CenterProductController {
	
	private ProductService productService;
	private MessageSource messageSource;
	
	@Autowired
	public CenterProductController(ProductService productService, MessageSource messageSource) {
		this.productService = productService;
		this.messageSource = messageSource;
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
	
	@GetMapping("proRegist")
	public void registProduct() {}
	
	@PostMapping("proRegist")
	public String registProduct(@ModelAttribute ProductDTO product, RedirectAttributes rttr, Locale locale) {
		
		productService.registProduct(product);
		
		log.info("product :{}", product);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("registProduct", null, locale));
		
		if(product.getCategoryNo() == 10) {
			return "redirect:/center/product/membership/list";
		} else if(product.getCategoryNo() == 20) {
			return "redirect:/center/product/";
		} else if(product.getCategoryNo() == 30) {
			return "redirect:/center/product/";
		} else {
			return "redirect:/center/product/";
		}
		
	}
	
	
	
}
