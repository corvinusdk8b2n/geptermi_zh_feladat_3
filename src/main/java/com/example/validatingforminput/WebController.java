package com.example.validatingforminput;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer
{

	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model)
	{

		if (bindingResult.hasErrors())
		{
			return "form";
		}
		if(!personForm.getPassword().equals(personForm.getPasswordConf()))
		{
			model.addAttribute("matchError", "A jelszavak nem egyeznek.");
			return "form";
		}
		else
		{
			return "redirect:/results";
		}
	}
}
