package org.woehlke.computer.kurzweil.lucky.mouses.model;

import lombok.Getter;
import org.woehlke.computer.kurzweil.lucky.mouses.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.lucky.mouses.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.lucky.mouses.model.mouses.LinkedListNodeContainer;
import org.woehlke.computer.kurzweil.lucky.mouses.view.LuckyMousesFrame;

import java.io.Serial;
import java.io.Serializable;

/**
 * Koch Snowflake. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see ComputerKurzweilProperties
 * @see LuckyMousesFrame
 * @see LinkedListNodeContainer
 *
 * @see <a href="https://github.com/Computer-Kurzweil/kochsnowflake">Github Repository</a>
 * @see <a href="https://java.woehlke.org/kochsnowflake/">Maven Project Reports</a>
 *
 * Created by tw on 16.12.2019.
 */
@Getter
public class LuckyMousesModel implements Serializable {

    @Serial
    static final long serialVersionUID = 242L;

    private volatile LuckyMousesFrame tab;
    private volatile LinkedListNodeContainer linkedListNodeContainer;

    private final LatticeDimension worldDimensions;

    public LuckyMousesModel(LuckyMousesFrame tab) {
        this.tab = tab;
        int scale = tab.getConfig().getLuckyMouses().getView().getScale();
        int width = scale * tab.getConfig().getLuckyMouses().getView().getWidth();
        int height = scale * tab.getConfig().getLuckyMouses().getView().getHeight();
        this.worldDimensions = LatticeDimension.of(width,height);
        this.linkedListNodeContainer = new LinkedListNodeContainer(tab, this.worldDimensions);
    }

    public void step() {
         this.linkedListNodeContainer.step();
    }

    public void start(){
        this.linkedListNodeContainer.start();
    }

    public void runA() {
        System.out.println("run A");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupA();
        this.tab.restart();
    }

    public void runB() {
        System.out.println("run B");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupB();
        this.tab.restart();
    }

    public void runC() {
        System.out.println("run C");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupC();
        this.tab.restart();
    }

    public void runD() {
        System.out.println("run D");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupD();
        this.tab.restart();
    }

    public void runE() {
        System.out.println("run E");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupE();
        this.tab.restart();
    }

    public void runF() {
        System.out.println("run F");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupF();
        this.tab.restart();
    }

    public void runG() {
        System.out.println("run G");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupG();
        this.tab.restart();
    }

    public void runH() {
        System.out.println("run H");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupH();
        this.tab.restart();
    }

    public void runI() {
        System.out.println("run I");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupI();
        this.tab.restart();
    }

    public void runJ() {
        System.out.println("run J");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupJ();
        this.tab.restart();
    }

    public void runK() {
        System.out.println("run K");
        this.linkedListNodeContainer.start();
        this.linkedListNodeContainer.setupK();
        this.tab.restart();
    }
}
