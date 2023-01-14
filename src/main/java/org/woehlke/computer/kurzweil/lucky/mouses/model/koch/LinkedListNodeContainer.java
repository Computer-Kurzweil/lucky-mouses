package org.woehlke.computer.kurzweil.lucky.mouses.model.koch;

import lombok.Getter;
import lombok.extern.java.Log;
import org.woehlke.computer.kurzweil.lucky.mouses.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.lucky.mouses.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.lucky.mouses.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.lucky.mouses.view.LuckyMousesFrame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Koch Snowflake. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see ComputerKurzweilProperties
 * @see LuckyMousesFrame
 * @see LatticeDimension
 *
 * @see LinkedListNode
 *
 * @see <a href="https://github.com/Computer-Kurzweil/kochsnowflake">Github Repository</a>
 * @see <a href="https://java.woehlke.org/kochsnowflake/">Maven Project Reports</a>
 */
@Log
@Getter
public class LinkedListNodeContainer implements Serializable {

    static final long serialVersionUID = 242L;

    private final LuckyMousesFrame tab;

    private final LatticeDimension worldDimensions;

    private List<String> latticePointKeys = new ArrayList<>();
    private Map<String,LatticePoint> latticePoints = new HashMap<>();

    private List<LinkedListNode> startNode = new ArrayList<>();
    private LinkedListNode currentNode;

    private Boolean firstStep;

    public LinkedListNodeContainer(LuckyMousesFrame tab, LatticeDimension worldDimensions){
        this.tab = tab;
        this.worldDimensions = worldDimensions;
    }

    public void start(){
        int marginY = 0;
        int padding = 20;
        marginY += padding;
        int squareSide = this.worldDimensions.getHeight();
        double octagonSideDouble = (squareSide - (2.0 * padding));
        int octagonSide = Double.valueOf(Math.abs(octagonSideDouble)).intValue();
        double octagonSidePartDouble = (squareSide - (2.0 * padding)) / 3.0;
        int octagonSidePart = Double.valueOf(Math.abs(octagonSidePartDouble)).intValue();
        int marginX = (this.worldDimensions.getWidth() - octagonSide) / 2;

        int x1 = marginX + octagonSidePart * 0;
        int x2 = marginX + octagonSidePart * 1;
        int x3 = marginX + octagonSidePart * 2;
        int x4 = marginX + octagonSidePart * 3;

        int y1 = marginY + octagonSidePart * 0;
        int y2 = marginY + octagonSidePart * 1;
        int y3 = marginY + octagonSidePart * 2;
        int y4 = marginY + octagonSidePart * 3;

        LatticePoint upperLeft = new LatticePoint(x2,y1);
        LatticePoint upperRight = new LatticePoint(x3,y1);
        LatticePoint rightUpper = new LatticePoint(x4,y2);
        LatticePoint rightBottom = new LatticePoint(x4,y3);
        LatticePoint bottomLeft = new LatticePoint(x2,y4);
        LatticePoint bottomRight = new LatticePoint(x3,y4);
        LatticePoint leftUpper = new LatticePoint(x1,y2);
        LatticePoint leftBottom = new LatticePoint(x1,y3);

        latticePoints.put( "upperLeft", upperLeft);
        latticePoints.put( "upperRight", upperRight);
        latticePoints.put( "rightUpper", rightUpper);
        latticePoints.put( "rightBottom", rightBottom);
        latticePoints.put( "bottomLeft", bottomLeft);
        latticePoints.put( "bottomRight", bottomRight);
        latticePoints.put( "leftUpper", leftUpper);
        latticePoints.put( "leftBottom", leftBottom);

        setupA();

        currentNode = this.startNode.get(0);
        firstStep = true;
    }

    public void setupA(){
        log.info("setup A");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupB(){
        log.info("setup B");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupC(){
        log.info("setup C");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupD(){
        log.info("setup D");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupE(){
        log.info("setup E");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupF(){
        log.info("setup F");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupG(){
        log.info("setup G");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupH(){
        log.info("setup H");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupI(){
        log.info("setup I");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupJ(){
        log.info("setup J");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void setupK(){
        log.info("setup K");
        LinkedListNode n0 = new LinkedListNode(latticePoints.get("upperLeft"));
        LinkedListNode n1 = new LinkedListNode(latticePoints.get("upperRight"));
        LinkedListNode n2 = new LinkedListNode(latticePoints.get("rightUpper"));
        LinkedListNode n3 = new LinkedListNode(latticePoints.get("rightBottom"));
        LinkedListNode n4 = new LinkedListNode(latticePoints.get("bottomRight"));
        LinkedListNode n5 = new LinkedListNode(latticePoints.get("bottomLeft"));
        LinkedListNode n6 = new LinkedListNode(latticePoints.get("leftBottom"));
        LinkedListNode n7 = new LinkedListNode(latticePoints.get("leftUpper"));
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n0);
        this.startNode.add(n0);
        this.startNode.add(n1);
        this.startNode.add(n2);
        this.startNode.add(n3);
        this.startNode.add(n4);
        this.startNode.add(n5);
        this.startNode.add(n6);
        this.startNode.add(n7);
    }

    public void step() {
        log.info("step");
        double wayFraction = 0.1;
        for(LinkedListNode o : startNode){
            LatticePoint thisPoint = o.getPoint();
            LatticePoint nextPoint = o.getNext().getPoint();
            LatticePoint delta = thisPoint.delta(nextPoint).scalarMultiplied(wayFraction);
            LatticePoint thisPointNew = thisPoint.plus(delta);
            o.setPoint(thisPointNew);
        }
        firstStep = false;
    }
}
