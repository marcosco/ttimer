package local.unimi.ttimer.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import local.unimi.ttimer.entity.Role;
import local.unimi.ttimer.entity.Timer;
import local.unimi.ttimer.entity.User;
import local.unimi.ttimer.repository.RoleRepository;
import local.unimi.ttimer.repository.TimerRepository;
import local.unimi.ttimer.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private TimerRepository timerRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithTimers(int id) {
		User user = findOne(id);
		List<Timer> timers = timerRepository.findByUser(user);
		user.setTimers(timers);
		return user;
	}

	public User save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		return userRepository.save(user);		
	}

	public User findOneWithTimers(String name) {
		User user = userRepository.findByName(name);
		return findOneWithTimers(user.getId());
	}

	public void delete(int id) {
		userRepository.delete(id);
  }
}
