package juanfer14;
import robocode.*;


public class Walle extends JuniorRobot
{
	private Strategy st = new Loco(this);

	@Override	
	public void run() {
		st.run();
		
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		st.onScannedRobot();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		st.onHitByBullet();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		st.onHitWall();
	}	
}