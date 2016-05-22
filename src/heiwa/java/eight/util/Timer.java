package heiwa.java.eight.util;

/**
 * 時間計測用のUtilクラス。
 */
public class Timer {
    static long startTime;
    static long startLapTime;
    static boolean started = false;
    static boolean laped = false;

    static public void start() {
        started = true;
        startTime = System.nanoTime();
    }

    static public long lap() {
        if (started) {
            long now = System.nanoTime();
            long lapTime = now - startTime;
            if (laped) {
                lapTime = now - startLapTime;
            }
            startLapTime = now;
            laped = true;
            return lapTime;
        }
        throw new NotPreparedException();
    }

    static public long stop() {
        if (!started) {
            throw new NotPreparedException();
        }
        started = false;
        laped = false;
        return System.nanoTime() - startTime;
    }

    static public class NotPreparedException extends RuntimeException {
        public NotPreparedException() {
            super("Call start() before lap() or stop().");
        }
    }
}
