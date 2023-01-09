package org.woehlke.computer.kurzweil.lucky.mouses.model;

import lombok.Getter;
import org.woehlke.computer.kurzweil.kochsnowflake.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.lucky.mouses.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.lucky.mouses.model.koch.LinkedListNodeContainer;
import org.woehlke.computer.kurzweil.lucky.mouses.view.KochSnowflakeFrame;

import java.io.Serial;
import java.io.Serializable;

/**
 * Koch Snowflake. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see ComputerKurzweilProperties
 * @see KochSnowflakeFrame
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

    private volatile KochSnowflakeFrame tab;
    private volatile LinkedListNodeContainer linkedListNodeContainer;

    private final LatticeDimension worldDimensions;

    public KochSnowflakeModel(KochSnowflakeFrame tab) {
        this.tab = tab;
        int scale = tab.getConfig().getKochsnowflake().getView().getScale();
        int width = scale * tab.getConfig().getKochsnowflake().getView().getWidth();
        int height = scale * tab.getConfig().getKochsnowflake().getView().getHeight();
        this.worldDimensions = LatticeDimension.of(width,height);
        this.linkedListNodeContainer = new LinkedListNodeContainer(tab, this.worldDimensions);
    }

    public void step() {
         this.linkedListNodeContainer.step();
    }

    public void start(){
        this.linkedListNodeContainer.start();
    }
}
