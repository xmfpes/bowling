package com.kyunam.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingManager {
	private List<User> playerList;
	private int turn;
	public BowlingManager() {
		playerList = new ArrayList<User>();
	}
	public void startGame(String userString) {
		String users[] = userString.split(",");
		for(int i=0; i<users.length; i++) {
			createUser(users[i]);
		}
	}
	public void createUser(String name) {
		User user = new User(name);
		playerList.add(user);
	}
	public User getUser(int index) {
		return playerList.get(index);
	}
}
