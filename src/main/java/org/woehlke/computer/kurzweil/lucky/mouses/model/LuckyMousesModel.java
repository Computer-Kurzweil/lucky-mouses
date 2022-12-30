package org.woehlke.computer.kurzweil.lucky.mouses.model;

import lombok.extern.slf4j.Slf4j;
import org.woehlke.computer.kurzweil.lucky.mouses.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.lucky.mouses.model.fractal.GaussianNumberPlane;
import org.woehlke.computer.kurzweil.lucky.mouses.model.common.Point;
import org.woehlke.computer.kurzweil.lucky.mouses.view.state.ApplicationStateMachine;
import org.woehlke.computer.kurzweil.lucky.mouses.model.turing.LuckyMousesTuringMachine;
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
 * @see GaussianNumberPlane
 * @see LuckyMousesTuringMachine
 * @see ApplicationStateMachine
 *
 * @see ComputerKurzweilProperties
 * @see LuckyMousesFrame
 *
 * Created by tw on 16.12.2019.
 */
@Slf4j
public class LuckyMousesModel {

    private volatile GaussianNumberPlane gaussianNumberPlane;
    private volatile LuckyMousesTuringMachine luckyMousesTuringMachine;
    private volatile ApplicationStateMachine applicationStateMachine;

    private volatile ComputerKurzweilProperties config;
    private volatile LuckyMousesFrame frame;

    public LuckyMousesModel(ComputerKurzweilProperties config, LuckyMousesFrame frame) {
        this.config = config;
        this.frame = frame;
        this.gaussianNumberPlane = new GaussianNumberPlane(this);
        this.luckyMousesTuringMachine = new LuckyMousesTuringMachine(this);
        this.applicationStateMachine = new ApplicationStateMachine();
    }

    public synchronized boolean click(Point c) {
        applicationStateMachine.click();
        boolean repaint = true;
        switch (applicationStateMachine.getApplicationState()) {
            case MANDELBROT:
                luckyMousesTuringMachine.start();
                repaint = false;
                break;
            case JULIA_SET:
                gaussianNumberPlane.computeTheJuliaSetFor(c);
                break;
        }
        return repaint;
    }

    public synchronized boolean step() {
        boolean repaint = false;
        switch (applicationStateMachine.getApplicationState()) {
            case MANDELBROT:
                repaint = luckyMousesTuringMachine.step();
                break;
            case JULIA_SET:
                break;
        }
        return repaint;
    }

    public synchronized int getCellStatusFor(int x, int y) {
        return gaussianNumberPlane.getCellStatusFor(x, y);
    }

    public Point getWorldDimensions() {
        int scale = config.getLuckyMouses().getView().getScale();
        int width = scale * config.getLuckyMouses().getView().getWidth();
        int height = scale * config.getLuckyMouses().getView().getHeight();
        return new Point(width, height);
    }

    public GaussianNumberPlane getGaussianNumberPlane() {
        return gaussianNumberPlane;
    }

    public void runA() {
        System.out.println("run A");
    }

    public void runB() {
        System.out.println("run B");
    }

    public void runC() {
        System.out.println("run C");
    }

    public void runD() { System.out.println("run D"); }

    public void runE() {
        System.out.println("run E");
    }

    public void runF() {
        System.out.println("run F");
    }
}