package org.sekka.api.util.math;

import java.util.Random;
import java.util.UUID;

public final class MathUtil {

    private static final float[] SIN_TABLE = new float[65536];
    private static final Random RANDOM = new Random();
    private static final int[] MULTIPLY_DE_BRUIJN_BIT_POSITION;
    private static final double FRAC_BIAS;
    private static final double[] ASINE_TAB;
    private static final double[] COS_TAB;

    public static final float SQRT_2 = sqrt(2.0F);

    static {
        for (int i = 0; i < 65536; ++i) {
            SIN_TABLE[i] = (float) Math.sin((double) i * Math.PI * 2.0D / 65536.0D);
        }

        MULTIPLY_DE_BRUIJN_BIT_POSITION = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
        FRAC_BIAS = Double.longBitsToDouble(4805340802404319232L);
        ASINE_TAB = new double[257];
        COS_TAB = new double[257];

        for (int j = 0; j < 257; ++j) {
            double d0 = (double) j / 256.0D;
            double d1 = Math.asin(d0);
            COS_TAB[j] = Math.cos(d1);
            ASINE_TAB[j] = d1;
        }
    }

    private MathUtil() {
    }

    public static float sin(float value) {
        return SIN_TABLE[(int) (value * 10430.378F) & 65535];
    }

    public static float cos(float value) {
        return SIN_TABLE[(int) (value * 10430.378F + 16384.0F) & 65535];
    }

    public static float sqrt(float value) {
        return (float) Math.sqrt((double) value);
    }

    public static float sqrt(double value) {
        return (float) Math.sqrt(value);
    }

    public static int floor(float value) {
        int i = (int) value;
        return value < (float) i ? i - 1 : i;
    }

    public static int floor(double value) {
        int i = (int) value;
        return value < (double) i ? i - 1 : i;
    }

    public static long lfloor(double value) {
        long i = (long) value;
        return value < (double) i ? i - 1L : i;
    }

    public static float abs(float value) {
        return value >= 0.0F ? value : -value;
    }

    public static int abs(int value) {
        return value >= 0 ? value : -value;
    }

    public static int ceil(float value) {
        int i = (int) value;
        return value > (float) i ? i + 1 : i;
    }

    public static int ceil(double value) {
        int i = (int) value;
        return value > (double) i ? i + 1 : i;
    }

    public static int clamp(int num, int min, int max) {
        if (num < min) {
            return min;
        } else {
            return num > max ? max : num;
        }
    }

    public static float clamp(float num, float min, float max) {
        if (num < min) {
            return min;
        } else {
            return num > max ? max : num;
        }
    }

    public static double clamp(double num, double min, double max) {
        if (num < min) {
            return min;
        } else {
            return num > max ? max : num;
        }
    }

    public static double clampedLerp(double lowerBnd, double upperBnd, double slide) {
        if (slide < 0.0D) {
            return lowerBnd;
        } else {
            return slide > 1.0D ? upperBnd : lowerBnd + (upperBnd - lowerBnd) * slide;
        }
    }

    public static double absMax(double p_76132_0_, double p_76132_2_) {
        if (p_76132_0_ < 0.0D) {
            p_76132_0_ = -p_76132_0_;
        }

        if (p_76132_2_ < 0.0D) {
            p_76132_2_ = -p_76132_2_;
        }

        return p_76132_0_ > p_76132_2_ ? p_76132_0_ : p_76132_2_;
    }

    public static int getInt(Random random, int minimum, int maximum) {
        return minimum >= maximum ? minimum : random.nextInt(maximum - minimum + 1) + minimum;
    }

    public static float nextFloat(Random random, float minimum, float maximum) {
        return minimum >= maximum ? minimum : random.nextFloat() * (maximum - minimum) + minimum;
    }

    public static double nextDouble(Random random, double minimum, double maximum) {
        return minimum >= maximum ? minimum : random.nextDouble() * (maximum - minimum) + minimum;
    }

    public static double average(long[] values) {
        long i = 0L;

        for (long j : values) {
            i += j;
        }

        return (double) i / (double) values.length;
    }

    public static float wrapDegrees(float value) {
        value = value % 360.0F;

        if (value >= 180.0F) {
            value -= 360.0F;
        }

        if (value < -180.0F) {
            value += 360.0F;
        }

        return value;
    }

    public static double wrapDegrees(double value) {
        value = value % 360.0D;

        if (value >= 180.0D) {
            value -= 360.0D;
        }

        if (value < -180.0D) {
            value += 360.0D;
        }

        return value;
    }

    public static int wrapDegrees(int angle) {
        angle = angle % 360;

        if (angle >= 180) {
            angle -= 360;
        }

        if (angle < -180) {
            angle += 360;
        }

        return angle;
    }

    public static int getInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Throwable var3) {
            return defaultValue;
        }
    }

    public static int getInt(String value, int defaultValue, int max) {
        return Math.max(max, getInt(value, defaultValue));
    }

    public static double getDouble(String value, double defaultValue) {
        try {
            return Double.parseDouble(value);
        } catch (Throwable var4) {
            return defaultValue;
        }
    }

    public static double getDouble(String value, double defaultValue, double max) {
        return Math.max(max, getDouble(value, defaultValue));
    }

    public static int smallestEncompassingPowerOfTwo(int value) {
        int i = value - 1;
        i = i | i >> 1;
        i = i | i >> 2;
        i = i | i >> 4;
        i = i | i >> 8;
        i = i | i >> 16;
        return i + 1;
    }

    private static boolean isPowerOfTwo(int value) {
        return value != 0 && (value & value - 1) == 0;
    }

    public static int log2DeBruijn(int value) {
        value = isPowerOfTwo(value) ? value : smallestEncompassingPowerOfTwo(value);
        return MULTIPLY_DE_BRUIJN_BIT_POSITION[(int) ((long) value * 125613361L >> 27) & 31];
    }

    public static int log2(int value) {
        return log2DeBruijn(value) - (isPowerOfTwo(value) ? 0 : 1);
    }

    public static int roundUp(int number, int interval) {
        if (interval == 0) {
            return 0;
        } else if (number == 0) {
            return interval;
        } else {
            if (number < 0) {
                interval *= -1;
            }

            int i = number % interval;
            return i == 0 ? number : number + interval - i;
        }
    }

    public static long getCoordinateRandom(int x, int y, int z) {
        long i = (long) (x * 3129871) ^ (long) z * 116129781L ^ (long) y;
        i = i * i * 42317861L + i * 11L;
        return i;
    }

    public static UUID getRandomUUID(Random rand) {
        long i = rand.nextLong() & -61441L | 16384L;
        long j = rand.nextLong() & 4611686018427387903L | Long.MIN_VALUE;
        return new UUID(i, j);
    }

    public static UUID getRandomUUID() {
        return getRandomUUID(RANDOM);
    }

    public static double pct(double p_181160_0_, double p_181160_2_, double p_181160_4_) {
        return (p_181160_0_ - p_181160_2_) / (p_181160_4_ - p_181160_2_);
    }

    public static int hash(int p_188208_0_) {
        p_188208_0_ = p_188208_0_ ^ p_188208_0_ >>> 16;
        p_188208_0_ = p_188208_0_ * -2048144789;
        p_188208_0_ = p_188208_0_ ^ p_188208_0_ >>> 13;
        p_188208_0_ = p_188208_0_ * -1028477387;
        p_188208_0_ = p_188208_0_ ^ p_188208_0_ >>> 16;
        return p_188208_0_;
    }
}
