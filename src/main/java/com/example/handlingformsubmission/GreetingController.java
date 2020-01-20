package com.example.handlingformsubmission;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.handlingformsubmission.*;

@Controller
public class GreetingController implements WebMvcConfigurer{

	@Autowired
	private GreetingRepository repository;

	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/result").setViewName("result");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/greeting").setViewName("greeting");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/greeting/find/").setViewName("find");
	}

	@GetMapping("/greeting")
	public String greetingForm(Model model){
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}
	
	@PostMapping("/greeting")
	public String checkMessage(@RequestParam int id, @RequestParam String content, @Valid @ModelAttribute Greeting greeting, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "greeting";
		} else {
			Greeting greet = new Greeting(id, content);
			repository.save(greet);
			return "result";
		}
	}
	
	@GetMapping("/greeting/find/{id}")
	public String findById(@PathVariable("id") Integer id, Model model){
		Optional<Greeting> greet = repository.findById(id);
		if(greet.isPresent()){
			model.addAttribute("greeting", greet.get());
		} else{
			model.addAttribute("greeting", new Greeting(0, ""));
		}
		return "find";
	}
	
	@GetMapping("/greeting/find/")
	public String findAll(Model model){
		model.addAttribute("greeting", repository.findAll());
		return "find";
	}
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
}