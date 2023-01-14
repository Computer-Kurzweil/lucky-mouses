package org.woehlke.computer.kurzweil.lucky.mouses.view.canvas;

import lombok.Getter;
import lombok.extern.java.Log;
import org.woehlke.computer.kurzweil.lucky.mouses.model.LuckyMousesModel;
import org.woehlke.computer.kurzweil.lucky.mouses.model.koch.LinkedListNode;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.List;


/**
 * Koch Snowflake. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see LuckyMousesModel
 * @see Dimension
 *
 * @see JComponent
 * @see Graphics
 *
 * @see <a href="https://github.com/Computer-Kurzweil/kochsnowflake">Github Repository</a>
 * @see <a href="https://java.woehlke.org/kochsnowflake/">Maven Project Reports</a>
 *
 * Date: 05.02.2006
 * Time: 00:51:51
 */
@Log
@Getter
public class LuckyMousesCanvas extends JComponent  {

    @Serial
    private final static long serialVersionUID = 242L;

    private volatile LuckyMousesModel model;
    private volatile Dimension preferredSize;

    public LuckyMousesCanvas(LuckyMousesModel model) {
        this.model = model;
        int width = this.model.getWorldDimensions().getWidth();
        int height = this.model.getWorldDimensions().getHeight();
        this.preferredSize = new Dimension(width, height);
        Rectangle bounds = new Rectangle(0,0,width,height);
        this.setBounds(bounds);
        this.setSize(this.preferredSize);
        this.setPreferredSize(preferredSize);
    }

    public void paint(Graphics g) {
        log.info("paint");
        this.setSize(this.preferredSize);
        this.setPreferredSize(preferredSize);
        super.paintComponent(g);
        //super.setBackground(Color.DARK_GRAY);
        super.setBackground(Color.BLACK);
        int paddingX = (this.model.getWorldDimensions().getWidth()-this.model.getWorldDimensions().getHeight())/2;
        //g.setColor(Color.DARK_GRAY);
        g.setColor(Color.BLACK);
        g.fillRect(
            0,0,
            this.model.getWorldDimensions().getWidth(),
            this.model.getWorldDimensions().getHeight()
        );
        g.setColor(Color.BLACK);
        g.fillRect(
            paddingX,0,
            this.model.getWorldDimensions().getHeight(),
            this.model.getWorldDimensions().getHeight()
        );
        //g.setColor(Color.RED);
        List<LinkedListNode> startNode = model.getLinkedListNodeContainer().getStartNode();
        int i=0;
        for(LinkedListNode o : startNode) {
            switch (i%4){
                case 0: g.setColor(Color.RED); break;
                case 1: g.setColor(Color.GREEN); break;
                case 2: g.setColor(Color.BLUE); break;
                case 3: g.setColor(Color.YELLOW); break;
            }
            i++;
            g.drawLine(
                o.getPoint().getX(),
                o.getPoint().getY(),
                o.getNext().getPoint().getX(),
                o.getNext().getPoint().getY()
            );
        }
    }

    public void update(Graphics g) {
        paint(g);
    }
}
