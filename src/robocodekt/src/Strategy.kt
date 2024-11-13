package robocodekt

interface Strategy {
	fun run()
	fun onScannedRobot()
	fun onHitByBullet()
	fun onHitWall()
}