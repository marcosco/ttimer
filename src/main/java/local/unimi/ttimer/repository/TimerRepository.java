package local.unimi.ttimer.repository;

import java.util.List;

import local.unimi.ttimer.entity.Timer;
import local.unimi.ttimer.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimerRepository extends JpaRepository<Timer, Integer>{
	List<Timer> findByUser(User user);
}
