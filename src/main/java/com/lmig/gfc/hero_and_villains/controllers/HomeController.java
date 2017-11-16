package com.lmig.gfc.hero_and_villains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.hero_and_villains.models.Hero;
import com.lmig.gfc.hero_and_villains.models.Monster;

@Controller
public class HomeController {
	
	private Monster ourMonster;
	private Hero ourHero;
	
	public HomeController() {
		ourMonster = new Monster("Olaf",80,"Zombie Snowman");
		ourHero = new Hero("Daenerys Targarian",100,"Mother of Dragons");
	}
	
	@RequestMapping("/")  
	public ModelAndView defaultPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/attack")
	public ModelAndView attack() {
		ourHero.attack(ourMonster);
		ModelAndView mv = new ModelAndView();
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.setViewName("home");
		return mv;
	}

}
