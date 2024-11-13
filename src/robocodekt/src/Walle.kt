package robocodekt
import robocode.*

class Walle: JuniorRobot() {
	private var st: Strategy = Buscador(this)

		
	override fun run() {
		st.run()
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	override fun onScannedRobot() {
		st.onScannedRobot()
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	override fun onHitByBullet() {
		st.onHitByBullet()
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	override fun onHitWall() {
		st.onHitWall()
	}	
}
