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
	public int throwBallCurrentTurn(int ball) {
		int check = playerList.get(turn).throwBall(ball);
		if(check == 0) {
			turn = (playerList.size()-1 <= turn)?0:(turn+1);
			//턴이 종료됐을때 플레이어 사이즈를 넘는다면 0으로 다시 되돌아가고, 아니라면 1 증가
		}
		return check;
	}
	public boolean isEndGame() {
		//게임 종료 여부 반환
		//true면 마지막 세트까지 게임이 종료된 것
		return playerList.get(playerList.size()-1).isEndGame();
	}
}
