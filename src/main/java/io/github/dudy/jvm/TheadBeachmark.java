package io.github.dudy.jvm;

/**
 * @program: test
 * @description:
 * @author: dongyang.du
 * @create: 2018-09-30 11:47
 **/

public class TheadBeachmark {


    public static void main(String[] args) throws InterruptedException {
        for (int c = 0; c < 10000; c++) {
            Thread.sleep(  1000);

            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    for (; ; ) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

}
