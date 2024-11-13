package juanfer14;

import robocode.*;


public class Buscador implements Strategy  {
	private JuniorRobot jr;
	private int hitWall;
	private boolean ok;
	
	public Buscador(JuniorRobot jr) {
		this.jr = jr;
		hitWall=0;
		ok=true;
	}

	@Override
	public void run() {
		jr.setColors(jr.orange, jr.blue, jr.white, jr.yellow, jr.black);
		if(hitWall == 0) {
			jr.turnTo(0);
			jr.ahead(5000);
		} else if(hitWall == 1) {
			jr.turnTo(90);
			jr.ahead(5000);
		}
		else if(hitWall == 2) {
			if(ok) {
				jr.turnTo(jr.scannedBearing);
				ok=false;
			}
			else {
				jr.turnTo(jr.scannedBearing);
				ok=true;
			}
			
		}
		
	}
	@Override
	public void onScannedRobot() {
		if(hitWall == 2) {
			jr.fire(1);
			jr.fire(1);
			jr.doNothing(50);
		}
	}
	@Override
	public void onHitByBullet() {
		if(hitWall == 2) {
			//jr.turnBackRight(50, 360);
		}
	}
	@Override
	public void onHitWall() {
		if(hitWall < 2) {
			hitWall++;
			if(hitWall == 2) {
				jr.turnTo(270);
				jr.turnTo(180);
			}
		}
	}
}
