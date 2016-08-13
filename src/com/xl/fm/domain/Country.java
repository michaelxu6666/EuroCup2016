package com.xl.fm.domain;

import java.io.Serializable;
import java.util.Set;

public class Country implements Serializable {
	private Long id;
	private String name;
	private int power;// int 类型的power表示能力值
	private Coach coach;
	private Set<Player> players;
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
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
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
