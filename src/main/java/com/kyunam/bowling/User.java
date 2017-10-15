package com.kyunam.bowling;

public class User {
	private String userName;
	private FrameManager frameManager;
	public User() {}
	public User(String name) {
		this.userName = name;
		frameManager = new FrameManager();
	}
	public String getUserName() {
		return userName;
	}
	public FrameManager getFrameManager() {
		return frameManager;
	}
	public int throwBall(int ball) {
		return frameManager.throwBallInCurrentFrame(ball);
		//0이면 턴 종료, 0이 아니라면 현재 남은 핀 갯수 반환
	}
	public boolean isEndGame() {
		if(frameManager.checkFrameCount() > 9) {
			return true;
		}
		return false;
	}
	
}
