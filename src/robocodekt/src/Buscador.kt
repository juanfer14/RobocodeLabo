package robocodekt

import robocode.JuniorRobot

class Buscador(private val jr: JuniorRobot): Strategy {
	private var hitWall: Int = 0
	private var ok = true

	
	override fun run(){
		jr.setColors(JuniorRobot.orange, JuniorRobot.blue, JuniorRobot.white, JuniorRobot.yellow, JuniorRobot.black)
		if (hitWall == 0) {
			jr.turnTo(0)
			jr.ahead(5000)
		} else if (hitWall == 1) {
			jr.turnTo(90)
			jr.ahead(5000)
		} else if (hitWall == 2) {
			if (ok) {
				jr.turnTo(jr.scannedBearing)
				ok = false
			} else {
				jr.turnTo(jr.scannedBearing)
				ok = true
			}
		}
	}
	
	override fun onScannedRobot(){
		if (hitWall == 2) {
			jr.fire(1.0)
			jr.fire(1.0)
			jr.doNothing(50)
		}
	}
	
	override fun onHitByBullet(){
		if (hitWall == 2) {
			//jr.turnBackRight(50, 360);
		}
	}
	
	override fun onHitWall(){
		if (hitWall < 2) {
			hitWall++
			if (hitWall == 2) {
				jr.turnTo(270)
				jr.turnTo(180)
			}
		}
	}
}