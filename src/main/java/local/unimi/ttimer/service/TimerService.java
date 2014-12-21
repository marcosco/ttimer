package local.unimi.ttimer.service;

import java.util.List;

import local.unimi.ttimer.entity.Timer;
import local.unimi.ttimer.entity.User;
import local.unimi.ttimer.repository.TimerRepository;
import local.unimi.ttimer.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TimerService {
	
	@Autowired
	private TimerRepository timerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(Timer timer, String name) {
		User user = userRepository.findByName(name);
		timer.setUser(user);
		timerRepository.save(timer);
	}

	@PreAuthorize("#timer.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("timer") Timer timer) {
	  timerRepository.delete(timer);
  }


	public Timer findOne(int id) {
	  return timerRepository.findOne(id);
  }

}
