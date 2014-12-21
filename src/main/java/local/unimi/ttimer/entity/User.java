package local.unimi.ttimer.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import local.unimi.ttimer.entity.Timer;
import local.unimi.ttimer.annotation.UniqueUsername;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message = "Name must be at least 3 characters!")
	@Column(unique = true)
	@UniqueUsername(message="Such username already exists!")
	private String name;
	
	@Size(min=1, message = "Invalid email!")
	@Email(message = "Invalid email!")
	private String email;
	
	@Size(min = 5, message = "Password must be at least 5 characters!")
	private String password;
	
	private Boolean enabled;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
	private List<Timer> timers;
	
	public void setTimers(List<Timer> timers) {
		this.timers = timers;
	}

	public List<Timer> getTimers() {
		return timers;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
}
