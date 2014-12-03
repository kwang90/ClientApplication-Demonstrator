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
	public String home() {
		return "redirect:index.html";
	}

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView index(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/dashboard.html", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView dashboardPage(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		return mv;
	}

	@RequestMapping(value = "/statistics.html", method = RequestMethod.GET)
	public ModelAndView statisticsPage(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("statistics");
		return mv;
	}

	/*
	 * @RequestMapping(value = "/home", method = RequestMethod.POST) public
	 * String login(@Validated User user, Model model) {
	 * model.addAttribute("userName", user.getUserName()); return "user"; }
	 */

}