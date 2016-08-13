package com.xl.fm.domain;

import java.io.Serializable;
import java.util.Set;

public class Player implements Serializable {
	private Long id;
	private String name;
	private int age;
	private int power; // int类型的 变量表示能力值
	
	private Country country;
	private Coach coach;
	private Set<Match> matches;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public Set<Match> getMatches() {
		return matches;
	}
	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	
	
	
}
