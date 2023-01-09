package org.woehlke.computer.kurzweil.lucky.mouses.control;

import lombok.extern.slf4j.Slf4j;
import org.woehlke.computer.kurzweil.lucky.mouses.model.KochSnowflakeModel;
import org.woehlke.computer.kurzweil.lucky.mouses.model.LuckyMousesModel;
import org.woehlke.computer.kurzweil.lucky.mouses.view.LuckyMousesFrame;

/**
 * Mandelbrot Set drawn by a Turing Machine.
 * (C) 2006 - 2022 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/mandelbrot-julia">Github Repository</a>
 * @see <a href="https://java.woehlke.org/mandelbrot-julia/">Maven Project Repository</a>
 *
 * @see LuckyMousesModel
 * @see LuckyMousesFrame
 *
 * @see Thread
 * @see Runnable
 *
 * Date: 05.02.2006
 * Time: 00:36:20
 */
@Slf4j
public class ControllerThread extends Thread implements Runnable {

    private volatile KochSnowflakeModel model;
    private volatile LuckyMousesFrame view;

    private volatile Boolean goOn;
    private final int threadSleepTime;
    private final int maxIterations;

    public ControllerThread(KochSnowflakeModel model, LuckyMousesFrame frame) {
        this.view = frame;
        this.model = model;
        this.goOn = Boolean.TRUE;
        this.threadSleepTime = this.view.getConfig().getLuckyMouses().getControl().getThreadSleepTime();
        this.maxIterations = this.view.getConfig().getLuckyMouses().getControl().getMaxIterations();
    }

    public void run() {
        int i = 0;
        while (i < this.maxIterations) {
            i++;
            this.model.step();
            this.view.getCanvas().repaint();
            this.view.repaint();
            try {
                sleep( this.threadSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized boolean isRunning(){
        return goOn;
    }

    public synchronized void exit() {
        goOn = Boolean.FALSE;
    }

}
