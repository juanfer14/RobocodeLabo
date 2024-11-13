package juanfer14;



public interface Strategy {
	public void run();
	public void onScannedRobot();
	public void onHitByBullet();
	public void onHitWall();
}
