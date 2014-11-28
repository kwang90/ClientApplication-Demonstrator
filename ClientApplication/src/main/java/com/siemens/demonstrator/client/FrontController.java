package com.siemens.demonstrator.client;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("landing-page");
		mv.addObject("loginNotification", "hidden");
		return mv;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView loginPage(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		return mv;
	}

	/*
	 * @RequestMapping(value = "/home", method = RequestMethod.POST) public
	 * String login(@Validated User user, Model model) {
	 * model.addAttribute("userName", user.getUserName()); return "user"; }
	 */

}