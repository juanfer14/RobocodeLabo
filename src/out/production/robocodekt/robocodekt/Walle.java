package robocodekt;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import robocode.JuniorRobot;

@Metadata(
        mv = {1, 9, 0},
        k = 1,
        xi = 48,
        d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"},
        d2 = {"Lrobocodekt/Walle;", "Lrobocode/JuniorRobot;", "()V", "st", "Lrobocodekt/Strategy;", "onHitByBullet", "", "onHitWall", "onScannedRobot", "run", "robocodekt"}
)
public final class Walle extends JuniorRobot {
    @NotNull
    private Strategy st = (Strategy)(new Buscador((JuniorRobot)this));

    public void run() {
        this.st.run();
    }

    public void onScannedRobot() {
        this.st.onScannedRobot();
    }

    public void onHitByBullet() {
        this.st.onHitByBullet();
    }

    public void onHitWall() {
        this.st.onHitWall();
    }
}
