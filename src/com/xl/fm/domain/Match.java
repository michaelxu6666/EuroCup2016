package com.xl.fm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Match implements Serializable {
	private Long id;
	private String name;
	private Date matchTime;
	private String matchPosition;
	private boolean win;
	private Set<Country> countries;
	private Set<Player> players; 
	
	
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
	public Date getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}
	public String getMatchPosition() {
		return matchPosition;
	}
	public void setMatchPosition(String matchPosition) {
		this.matchPosition = matchPosition;
	}
	
	public Set<Country> getCountries() {
		return countries;
	}
	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	
	
	
	
}
