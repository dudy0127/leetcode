package io.github.dudy.leecode.vtemp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: leecode
 * @description:
 * @author: dongyang.du
 * @create: 2018-08-06 16:41
 **/
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }
}


