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
import org.springframework.web.bind.annotation.RequestParam;
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
			return "redirect:/center/product/PT/list";
		} else if(product.getCategoryNo() == 30) {
			return "redirect:/center/product/locker/list";
		} else {
			return "redirect:/center/product/sportswear/list";
		}
		
	}
	
	@GetMapping("proModify")
	public ModelAndView modifyProductInfo(@RequestParam("no") int no, ModelAndView mv) {

		log.info("no:{}", no);
		
		ProductDTO modProduct = productService.findModifyProduct(no);
		
		log.info("modProduct: {}", modProduct);
		
		mv.addObject("modProduct",modProduct);
		mv.setViewName("center/product/proModify");
		
		return mv;
	}
	
	@PostMapping("proModify")
	public String modifyProduct(@ModelAttribute ProductDTO product, RedirectAttributes rttr, Locale locale) {
		
		int result = productService.updateProduct(product);
		
		log.info("product :{}", product);
		log.info("getCategoryNO : {}", product.getCategoryNo());
		
		if(result > 0 && product.getCategoryNo() == 10) {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("updateProduct", null, locale));
			return "redirect:/center/product/membership/list";
		} else if(result > 0 && product.getCategoryNo() == 20) {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("updateProduct", null, locale));
			return "redirect:/center/product/PT/list";
		} else if(result > 0 && product.getCategoryNo() == 30) {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("updateProduct", null, locale));
			return "redirect:/center/product/locker/list";
		} else {
			if(result > 0) {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("updateProduct", null, locale));
			return "redirect:/center/product/sportswear/list";
			} else {
				rttr.addFlashAttribute("successMessage", messageSource.getMessage("updateFailProduct", null, locale));
				return "redirect:/center/product/membership/list";
			}
		}
		
	}
	
	@GetMapping("membershipDelete")
	public String deleteMembership(@RequestParam("no") int no, RedirectAttributes rttr, Locale locale) {
		
		int result = productService.deleteProduct(no);
		
		if(result > 0) {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteProduct", null, locale));
		} else {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteFailProduct", null, locale));
		}
		
		return "redirect:/center/product/membership/list";
		
		
	}
	
	@GetMapping("/PT/list")
	public ModelAndView selectPTList(ModelAndView mv) {
		
		List<ProductDTO> selectPTList = productService.findAllPT();
		
		log.info("selectPTList : {}", selectPTList);
		
		/* addObject 키값 안넣어줘서 html로 값이 안넘어감 */
		mv.addObject("selectPTList",selectPTList);
		mv.setViewName("center/product/proPT");
		
		return mv;
		
	}
	
	@GetMapping("PTDelete")
	public String deletePT(@RequestParam("no") int no, RedirectAttributes rttr, Locale locale) {
		
		int result = productService.deleteProduct(no);
		
		if(result > 0) {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteProduct", null, locale));
			return "redirect:/center/product/PT/list";
		} else {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteFailProduct", null, locale));
			return "redirect:/center/product/PT/list";
		}
		
		
	}
	
	@GetMapping("/locker/list")
	public ModelAndView selectlockerList(ModelAndView mv) {
		
		List<ProductDTO> lockerList = productService.findAllLocker();
		
		log.info("lockerList : {}", lockerList);
		
		/* addObject 키값 안넣어줘서 html로 값이 안넘어감 */
		mv.addObject("lockerList",lockerList);
		mv.setViewName("center/product/proLocker");
		
		return mv;
		
	}
	
	@GetMapping("lockerDelete")
	public String deleteRocker(@RequestParam("no") int no, RedirectAttributes rttr, Locale locale) {
		
		int result = productService.deleteProduct(no);
		
		if(result > 0) {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteProduct", null, locale));
			return "redirect:/center/product/locker/list";
		} else {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteFailProduct", null, locale));
			return "redirect:/center/product/locker/list";
		}
		
		
	}
	
	@GetMapping("/sportswear/list")
	public ModelAndView selectSportswearList(ModelAndView mv) {
		
		List<ProductDTO> sportswearList = productService.findAllSportswear();
		
		log.info("sportswearList : {}", sportswearList);
		
		/* addObject 키값 안넣어줘서 html로 값이 안넘어감 */
		mv.addObject("sportswearList", sportswearList);
		mv.setViewName("center/product/proSportswear");
		
		return mv;
		
	}
	
	@GetMapping("sportswearDelete")
	public String deleteSportswear(@RequestParam("no") int no, RedirectAttributes rttr, Locale locale) {
		
		int result = productService.deleteProduct(no);
		
		if(result > 0) {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteProduct", null, locale));
			return "redirect:/center/product/sportswear/list";
		} else {
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("deleteFailProduct", null, locale));
			return "redirect:/center/product/sportswear/list";
		}
		
		
	}

	
	
	
}
