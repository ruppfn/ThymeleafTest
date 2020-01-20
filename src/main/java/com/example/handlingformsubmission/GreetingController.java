package com.example.handlingformsubmission;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.handlingformsubmission.*;

@Controller
public class GreetingController implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/result").setViewName("result");
	}

	@GetMapping("/greeting")
	public String greetingForm(Model model){
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}
	
	@PostMapping("/greeting")
	public String checkMessage(@Valid @ModelAttribute Greeting greeting, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "greeting";
		} else {
			return "result";
		}
	}
	
}