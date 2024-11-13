package robocodekt;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import robocode.JuniorRobot;

@Metadata(
        mv = {1, 9, 0},
        k = 1,
        xi = 48,
        d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"},
        d2 = {"Lrobocodekt/Buscador;", "Lrobocodekt/Strategy;", "jr", "Lrobocode/JuniorRobot;", "(Lrobocode/JuniorRobot;)V", "hitWall", "", "ok", "", "onHitByBullet", "", "onHitWall", "onScannedRobot", "run", "robocodekt"}
)
public final class Buscador implements Strategy {
    @NotNull
    private final JuniorRobot jr;
    private int hitWall;
    private boolean ok;

    public Buscador(@NotNull JuniorRobot jr) {
        Intrinsics.checkNotNullParameter(jr, "jr");
        super();
        this.jr = jr;
        this.ok = true;
    }

    public void run() {
        this.jr.setColors(16753920, 255, 16777215, 16776960, 0);
        if (this.hitWall == 0) {
            this.jr.turnTo(0);
            this.jr.ahead(5000);
        } else if (this.hitWall == 1) {
            this.jr.turnTo(90);
            this.jr.ahead(5000);
        } else if (this.hitWall == 2) {
            if (this.ok) {
                this.jr.turnTo(this.jr.scannedBearing);
                this.ok = false;
            } else {
                this.jr.turnTo(this.jr.scannedBearing);
                this.ok = true;
            }
        }

    }

    public void onScannedRobot() {
        if (this.hitWall == 2) {
            this.jr.fire(1.0);
            this.jr.fire(1.0);
            this.jr.doNothing(50);
        }

    }

    public void onHitByBullet() {
        if (this.hitWall == 2) {
        }

    }

    public void onHitWall() {
        if (this.hitWall < 2) {
            int var1 = this.hitWall++;
            if (this.hitWall == 2) {
                this.jr.turnTo(270);
                this.jr.turnTo(180);
            }
        }

    }
}
