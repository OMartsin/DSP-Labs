package dev.martsin;

import java.util.function.Function;

public class MyFourierConfig {
    public static final Function<Double, Double> FUNCTION = x -> {
        x = x % (2 * Math.PI);
        if(x < - Math.PI) x += 2 * Math.PI;
        if(x > Math.PI) x -= 2 * Math.PI;

        if(x > - Math.PI && x <= 0) return -x;
        if(x > 0 && x <= Math.PI) return x;
        return x;
    };

    public static final int SIMPSON_N = 1000;
    public static final double A = -Math.PI + 0.001;
    public static final double B = Math.PI - 0.001;
}
