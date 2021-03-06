package ru.matevosyan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Practice with threads.
 * @author Matevosyan Vardan
 * @version 1.0
 * created on 06.08.2017
 */

public class StopThread {
    private volatile boolean timeIsOer = false;
    private volatile boolean exitFromRun = false;

    /**
     * Default constructor.
     */

    public StopThread() {
    }

    /**
     * CountChar class to count chars from String.
     */

    public final class CountChar extends Thread {

        private String sentences;
        private int countChar = 0;
        private static final String TEXT_PATTERN = "\\S";
        private long start = System.currentTimeMillis();
        private long delta;

        /**
         * Getter for delta time.
         * @return program working time.
         */

        public long getDelta() {
            return delta;
        }

        /**
         * Constructor that assign sentences value.
         * @param sentences passing string.
         */

        public CountChar(final String sentences) {
            this.sentences = sentences;
        }

        /**
         * default constructor.
         */

        public CountChar() {
        }

        /**
         * Getter for CountChar.
         * @return countWord.
         */

        public int getCountChar() {
            return this.countChar;
        }

        /**
         * Override run to run countChar thread.
         */

        @Override
        public void run() {
            if (this.sentences != null) {

                Matcher matcher = Pattern.compile(TEXT_PATTERN).matcher(this.sentences);
                while (matcher.find()) {
                    if (!CountChar.interrupted()) {
                        this.countChar++;
                    } else {
                        System.out.println("Time is over!!!");
                        break;
                    }
                    delta = System.currentTimeMillis() - this.start;
                }

                System.out.printf("%s chars \n", this.countChar);

            }
            exitFromRun = true;

        }

    }

    /**
     * Timer  class to check hole time working CountCheck thread.
     */

    public final class Timer extends Thread {
        private long timerD;
        private CountChar countCharRunnable;

        /**
         * Timer constructor.
         * @param timeWorking is working time.
         */
        public Timer(final long timeWorking) {
            this.timerD = timeWorking;
        }

        /**
         * Timer constructor.
         * @param timeWorking is working time.
         * @param countCharRunnable CounChar runnable.
         */
        public Timer(final long timeWorking, CountChar countCharRunnable) {
            this.timerD = timeWorking;
            this.countCharRunnable = countCharRunnable;
        }

        @Override
        public void run() {
            if (countCharRunnable.getDelta() > this.timerD) {
                countCharRunnable.interrupt();
            } else if (exitFromRun) {
                System.out.println("Program is finish faster than passing time\n");
            }
        }
    }

}
