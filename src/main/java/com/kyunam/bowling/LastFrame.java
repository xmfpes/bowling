package com.kyunam.bowling;

import java.util.ArrayList;

import com.kyunam.bowling.Frame.Type;

public class LastFrame extends Frame {
	
	//디폴트로 노말 타입 셋팅
	public LastFrame() {
		super();
	}
	@Override
	public int throwBall(int ball) {
		this.pin -= ball;
		ballList.add(ball);
		if(checkStrike(ball)) {
			this.type = Type.STRIKE;
			pin = 10;
		}else if(checkSpare(pin)) {
			this.type = Type.SPARE;
			pin = 10;
		}
		//볼을 2번 이상 던졌고, 노말 타입인 경우 종료
		if(ballList.size() > 1 && this.type == Type.NORMAL) {
			return 0;
		}else if(ballList.size() > 2) {
			return 0;
		}
		return pin;
	}
}
