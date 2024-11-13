package robocodekt;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import robocode.JuniorRobot;

@Metadata(
        mv = {1, 9, 0},
        k = 1,
        xi = 48,
        d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"},
        d2 = {"Lrobocodekt/Loco;", "Lrobocodekt/Strategy;", "jr", "Lrobocode/JuniorRobot;", "(Lrobocode/JuniorRobot;)V", "ok", "", "move", "", "onHitByBullet", "onHitWall", "onScannedRobot", "run", "robocodekt"}
)
public final class Loco implements Strategy {
    @NotNull
    private JuniorRobot jr;
    private boolean ok;

    public Loco(@NotNull JuniorRobot jr) {
        Intrinsics.checkNotNullParameter(jr, "jr");
        super();
        this.jr = jr;
        this.ok = true;
    }

    private final void move() {
        if (this.ok) {
            this.jr.turnAheadRight(300, 360);
            this.ok = false;
        } else {
            this.jr.turnAheadLeft(300, 360);
            this.ok = true;
        }

    }

    public void run() {
        this.jr.setColors(16753920, 255, 16777215, 16776960, 0);
        this.move();
    }

    public void onScannedRobot() {
        this.jr.fire(1.0);
    }

    public void onHitByBullet() {
        this.move();
    }

    public void onHitWall() {
        this.jr.back(200);
        this.jr.turnBackLeft(200, 180);
        this.move();
    }
}
