package org.woehlke.computer.kurzweil.lucky.mouses.model;

import lombok.Getter;
import org.woehlke.computer.kurzweil.kochsnowflake.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.lucky.mouses.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.lucky.mouses.model.koch.LinkedListNodeContainer;
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
public class KochSnowflakeModel implements Serializable {

    @Serial
    static final long serialVersionUID = 242L;

    private volatile LuckyMousesFrame tab;
    private volatile LinkedListNodeContainer linkedListNodeContainer;

    private final LatticeDimension worldDimensions;

    public KochSnowflakeModel(LuckyMousesFrame tab) {
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
