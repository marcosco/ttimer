package local.unimi.ttimer.controller;

import java.security.Principal;

import javax.validation.Valid;

import local.unimi.ttimer.entity.Timer;
import local.unimi.ttimer.entity.User;
import local.unimi.ttimer.service.TimerService;
import local.unimi.ttimer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TimerService timerService;

	@ModelAttribute("timer") // command name nella form
	public Timer constructTimer() {
		return new Timer();
	}
	
	@RequestMapping
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithTimers(name));
		return "account";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String doAddTimer(Model model, @Valid @ModelAttribute("timer") Timer timer, BindingResult result,Principal principal) {
		if(result.hasErrors()) {
			return account(model, principal);
		}
		String name = principal.getName();
		timerService.save(timer, name);
		return "redirect:/account.html";
	}

}
