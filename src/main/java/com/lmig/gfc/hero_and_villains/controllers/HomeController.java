package com.lmig.gfc.hero_and_villains.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.hero_and_villains.models.Hero;
import com.lmig.gfc.hero_and_villains.models.Monster;

@Controller
public class HomeController {
	
	private ArrayList<Monster> ourMonsters;
	private Hero ourHero;
	
	public HomeController() {

		initGame();
	}
	
	@RequestMapping("/")   
	public ModelAndView defaultPage() {
		initGame();
		ModelAndView mv = new ModelAndView();
		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		mv.addObject("isGameOver", isGameOver());
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/deathFight")
	public ModelAndView deathFight() {
		ModelAndView mv = new ModelAndView();
		for(int i=0; i < ourMonsters.size(); i++) {
			while(!isGameOver() && ourMonsters.get(i).getHealth()>0) {
				ourHero.attack(ourMonsters.get(i));
				mv.addObject("lastMonster", ourMonsters.get(i));
				System.out.println("Monster: "+ourMonsters.get(i).getName()+" has "+ourMonsters.get(i).getHealth() + " health");
				System.out.println("Hero: "+ourHero.getName()+" has "+ourHero.getHealth() + " health");
				System.out.println();
			}

		}

		mv.addObject("monsters", ourMonsters);
		mv.addObject("hero", ourHero);
		mv.addObject("isGameOver", isGameOver());
		mv.setViewName("home");
		return mv;
	}
	
	public boolean isGameOver() {
		
		return (!ourHero.isAlive() || (!ourMonsters.get(ourMonsters.size()-1).isAlive()));
	}
	
	public void initGame() {
		ourMonsters = new ArrayList<Monster>();
		Monster monster1 = new Monster("Olaf",68,"Zombie Snowman");
		Monster monster2 = new Monster("Scott Calvin",34,"Santa Claus");
		Monster monster3 = new Monster("Monster3",78,"Thanksgiving Turkey");
		Monster monster4 = new Monster("Monster4",92,"Christmas Ham");
		Monster monster5 = new Monster("Monster5",77,"Easter Bunny");
		Monster monster6 = new Monster("Monster6",10,"Easter Bunny");
		ourMonsters.add(monster1);
		ourMonsters.add(monster2);
		ourMonsters.add(monster3);
		ourMonsters.add(monster4);
		ourMonsters.add(monster5);
		ourMonsters.add(monster6);
		ourHero = new Hero("Daenerys Targarian",350,"Mother of Dragons");
	}

}
