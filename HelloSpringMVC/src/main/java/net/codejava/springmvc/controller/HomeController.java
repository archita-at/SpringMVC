package net.codejava.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles request for the application home page.
 */

@CrossOrigin("*")
@Controller
public class HomeController {
	
	private Logger logger = Logger.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name
	 */
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("this is info message");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value="/test", method= RequestMethod.GET)
	public String test(Model model) {
		String greetings = "Greetings, Spring MVC!";
		model.addAttribute("message", greetings);
		
		return "test";
	}
	
	@RequestMapping(value="/doMath", method=RequestMethod.GET)
	public ModelAndView calculateSum(@RequestParam int a, @RequestParam int b) {
		ModelAndView model = new ModelAndView("MathResult");
		
		model.addObject("sum", (a + b));
        model.addObject("subtract", (a - b));
        model.addObject("multiply", (a * b));
        model.addObject("divide", (a / b));
         
        return model;
	}

}
