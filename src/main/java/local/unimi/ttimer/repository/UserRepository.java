package local.unimi.ttimer.repository;

import local.unimi.ttimer.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
