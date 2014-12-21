package local.unimi.ttimer.controller;

import local.unimi.ttimer.entity.Timer;
import local.unimi.ttimer.service.TimerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimerController {
	@Autowired
	private TimerService timerService;
	
	@RequestMapping("/timer/remove/{id}")
	public String removeTimer(@PathVariable int id) {
		Timer timer = timerService.findOne(id);
		timerService.delete(timer);
		return "redirect:/account.html";
	}
}
