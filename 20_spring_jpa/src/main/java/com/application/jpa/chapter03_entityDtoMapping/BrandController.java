package com.application.jpa.chapter03_entityDtoMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {

	@GetMapping("/brand/view")
	public String view() {
		return "brand";
	}
	
}
