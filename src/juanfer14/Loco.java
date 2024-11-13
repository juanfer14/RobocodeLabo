package juanfer14;

import robocode.JuniorRobot;

public class Loco implements Strategy {
	private JuniorRobot jr;
	private boolean ok;
	public Loco(JuniorRobot jr) {
		this.jr = jr;
		ok=true;

	}
	
	private void move() {
		if(ok) {
			jr.turnAheadRight(300, 360);
			ok=false;
		}
		else {
			jr.turnAheadLeft(300, 360);
			ok=true;
		}
	}

	
	@Override
	public void run() {
		jr.setColors(jr.orange, jr.blue, jr.white, jr.yellow, jr.black);
		this.move();
	}
	@Override
	public void onScannedRobot() {
		jr.fire(1);
	}
	@Override
	public void onHitByBullet() {
		this.move();
	}
	@Override
	public void onHitWall() {
		jr.back(200);
		jr.turnBackLeft(200, 180);
		this.move();
	}
}
