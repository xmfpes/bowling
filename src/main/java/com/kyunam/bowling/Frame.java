package com.kyunam.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	protected int pin = 10;
	protected List<Integer> ballList;
	protected Type type;
	
	//스트라이크, 스페어 타입을 저장할 enum 생성
	public enum Type {
		STRIKE('X'), SPARE('/'), NORMAL('n');
		private char type;
		Type(char type) {
			this.type = type;
		}
		public char getType() {
			return type;
		}
		public void setType(char type) {
			this.type = type;
		}
	}

	//디폴트로 노말 타입 셋팅
	public Frame() {
		this.ballList = new ArrayList<Integer>();
		this.type = Type.NORMAL;
	}
	
	public int throwBall(int ball) {
		this.pin -= ball;
		//볼을 2번 이상 던진 경우 남은 핀과 상관없이 0을 반환해 현재 프레임 종료
		if(ballList.size() > 1) {
			return 0;
		}
		ballList.add(ball);
		//스트라이크인 경우 타입을 변경한 뒤에 pin 0를 리턴해 현재 프레임 종료
		//스페어인경우도 타입을 변경한 뒤 pin 0를 리턴해 현재 프레임 종료
		if(checkStrike(ball)) {
			this.type = Type.STRIKE;
		}else if(checkSpare(pin)) {
			this.type = Type.SPARE;
		}
		return pin;
	}
	
	//현재 프레임이 어떤 타입인지 판단해서 그에 맞는 스트링 값을 리턴한다.
	public String getFrameString() {
		StringBuilder st = new StringBuilder();
		if(this.type == Type.STRIKE) {
			st.append(this.type.getType());
			return st.toString();
		}else if(this.type == Type.SPARE) {
			st.append(ballList.get(0) + "|/");
			return st.toString();
		}
		st.append(ballList.get(0) + "|" + ballList.get(1));
		return st.toString();
	}
	
	//스페어 판별 메소드
	public boolean checkSpare(int pin) {
		if(pin==0) {
			return true;
		}
		return false;
	}
	
	//스트라이크 판별 메소드
	public boolean checkStrike(int ball) {
		if(ball==10) {
			return true;
		}
		return false;
	}
	
}
