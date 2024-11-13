package robocodekt

import robocode.JuniorRobot


class Loco(private var jr: JuniorRobot): Strategy {
	
	private var ok = true

	private fun move() {
		
		if(ok) {
			jr.turnAheadRight(300, 360)
			ok=false
		}
		else {
			jr.turnAheadLeft(300, 360)
			ok=true
		}
		
	}
	
	override fun run(){
		jr.setColors(JuniorRobot.orange, JuniorRobot.blue, JuniorRobot.white, JuniorRobot.yellow, JuniorRobot.black)
		move()
	}
	
	override fun onScannedRobot(){
		jr.fire(1.0)
	}
	
	override fun onHitByBullet(){
		move()
	}
	
	override fun onHitWall(){
		jr.back(200)
		jr.turnBackLeft(200, 180)
		move()
	}

	
}