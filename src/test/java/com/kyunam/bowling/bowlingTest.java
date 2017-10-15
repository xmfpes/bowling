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
		for (int i = 0; i < 3; i++) {
			System.out.println(bowlingManager.getUser(i).getUserName());
		}
	}

	@Test
	public void frameManagerThrowBallTest() {
		// Spare Test
		FrameManager spareManager = new FrameManager();
		while (spareManager.checkFrameCount() < 10) {
			spareManager.throwBallInCurrentFrame(5);
		}
		spareManager.printFrameList();
		System.out.println();
		
		// Strike Test
		FrameManager strikeManager = new FrameManager();
		while (strikeManager.checkFrameCount() < 10) {
			strikeManager.throwBallInCurrentFrame(10);
		}
		strikeManager.printFrameList();
		System.out.println();
		
		// Normal Test
		FrameManager normalManager = new FrameManager();
		while (normalManager.checkFrameCount() < 10) {
			normalManager.throwBallInCurrentFrame(4);
		}
		normalManager.printFrameList();
		System.out.println();
	}

}
