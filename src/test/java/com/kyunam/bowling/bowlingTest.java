package com.kyunam.bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class bowlingTest {
	private static BowlingManager bowlingManager;
	@Before
	public void init() {
		bowlingManager = new BowlingManager();
	}
	@Test
	public void bowlingManagerStartGameTest() {
		String str = "PJS,KKN,KDS";
		bowlingManager.startGame(str);
		for(int i=0; i<3; i++) {
			System.out.println(bowlingManager.getUser(i).getUserName());
		}
	}

}
