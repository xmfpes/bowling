package com.kyunam.bowling;

import java.util.LinkedList;
import java.util.List;

public class FrameManager {

	//프레임 관리를 위해 리스트 보유
	private List<Frame> frameList;
	//현재 턴이 진행중인 프레임 보유
	private Frame currentFrame;
	
	public FrameManager() {
		frameList = new LinkedList<Frame>();
		createFrame();
	}

	//프레임을 생성하는데, 마지막 프레임이면 LastFrame으로 생성
	public void createFrame() {
		if (checkFrameCount() == 9) {
			currentFrame = new LastFrame();
		} else {
			currentFrame = new Frame();
		}
	}
	
	//현재 몇 프레임인지 체크를 위한 메소드
	public int checkFrameCount() {
		return frameList.size();
	}
	
	//현재 프레임에 대해 공을 던지고, 남은 핀의 갯수를 반환하는 메소드
	public int throwBallInCurrentFrame(int ball) {
		int remainPin = currentFrame.throwBall(ball);
		if (remainPin == 0) {
			frameList.add(currentFrame);
			createFrame();
			return remainPin;
		}
		return remainPin;
	}
	
	//현재 보유중이 프레임들에 대한 스트링 값을 반환한다.
	public void printFrameList() {
		for (Frame frame : frameList) {
			System.out.println(frame.getFrameString());
		}
	}
}
