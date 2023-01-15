package org.woehlke.computer.kurzweil.lucky.mouses.model.mouses;

import lombok.Getter;
import lombok.extern.java.Log;
import org.woehlke.computer.kurzweil.lucky.mouses.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.lucky.mouses.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.lucky.mouses.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.lucky.mouses.view.LuckyMousesFrame;

import java.io.Serializable;
import java.util.*;

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
    private Deque<List<LinkedListNode>> startNode = new ArrayDeque<>();
    private LinkedListNode currentNode;
    private Boolean firstStep;

    public LinkedListNodeContainer(LuckyMousesFrame tab, LatticeDimension worldDimensions){
        this.tab = tab;
        this.worldDimensions = worldDimensions;
        firstStep = true;
    }

    public void start(){
        setupA();
        currentNode = this.startNode.peek().get(0);
        firstStep = true;
    }

    private void setupPoints(){
        int marginY = 0;
        int padding = 20;
        marginY += padding;
        int squareSide = this.worldDimensions.getHeight();
        double octagonSideDouble = (squareSide - (2.0 * padding));
        int octagonSide = Double.valueOf(Math.abs(octagonSideDouble)).intValue();
        double octagonSidePartDouble = (squareSide - (2.0 * padding)) / 3.0;
        int octagonSidePart = Double.valueOf(Math.abs(octagonSidePartDouble)).intValue();
        int marginX = (this.worldDimensions.getWidth() - octagonSide) / 2;

        latticePoints.clear();

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
    }

    public void setupA(){
        log.info("setup A");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('A');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupB(){
        log.info("setup B");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('B');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupC(){
        log.info("setup C");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('C');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupD(){
        log.info("setup D");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('D');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupE(){
        log.info("setup E");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('E');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupF(){
        log.info("setup F");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('F');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupG(){
        log.info("setup G");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('G');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupH(){
        log.info("setup H");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('H');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupI(){
        log.info("setup I");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('I');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupJ(){
        log.info("setup J");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('J');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public void setupK(){
        log.info("setup K");
        setupPoints();
        LinkedListNode n[] = setupNodesbyPoint('K');
        List<LinkedListNode> nn = setupNodesSetNext(n);
        this.startNode.clear();
        this.startNode.add(nn);
    }

    public LinkedListNode[] setupNodesbyPoint(char k){
        LinkedListNode n[] = new LinkedListNode[8];
        switch (k){
            case 'A':
                n[0] = new LinkedListNode(latticePoints.get("upperLeft"));
                n[1] = new LinkedListNode(latticePoints.get("bottomLeft"));
                n[2] = new LinkedListNode(latticePoints.get("leftBottom"));
                n[3] = new LinkedListNode(latticePoints.get("rightUpper"));
                n[4] = new LinkedListNode(latticePoints.get("upperRight"));
                n[5] = new LinkedListNode(latticePoints.get("bottomRight"));
                n[6] = new LinkedListNode(latticePoints.get("rightBottom"));
                n[7] = new LinkedListNode(latticePoints.get("leftUpper"));
                break;
            case 'B':
                n[0] = new LinkedListNode(latticePoints.get("upperLeft"));
                n[1] = new LinkedListNode(latticePoints.get("bottomRight"));
                n[2] = new LinkedListNode(latticePoints.get("leftBottom"));
                n[3] = new LinkedListNode(latticePoints.get("rightUpper"));
                n[4] = new LinkedListNode(latticePoints.get("upperRight"));
                n[5] = new LinkedListNode(latticePoints.get("bottomLeft"));
                n[6] = new LinkedListNode(latticePoints.get("rightBottom"));
                n[7] = new LinkedListNode(latticePoints.get("leftUpper"));
                break;
            case 'C':
                n[0] = new LinkedListNode(latticePoints.get("upperLeft"));
                n[1] = new LinkedListNode(latticePoints.get("leftBottom"));
                n[2] = new LinkedListNode(latticePoints.get("bottomRight"));
                n[3] = new LinkedListNode(latticePoints.get("rightUpper"));
                n[4] = new LinkedListNode(latticePoints.get("upperRight"));
                n[5] = new LinkedListNode(latticePoints.get("rightBottom"));
                n[6] = new LinkedListNode(latticePoints.get("bottomLeft"));
                n[7] = new LinkedListNode(latticePoints.get("leftUpper"));
                break;
            case 'D':
                n[0] = new LinkedListNode(latticePoints.get("upperLeft"));
                n[1] = new LinkedListNode(latticePoints.get("bottomLeft"));
                n[2] = new LinkedListNode(latticePoints.get("rightUpper"));
                n[3] = new LinkedListNode(latticePoints.get("leftBottom"));
                n[4] = new LinkedListNode(latticePoints.get("upperRight"));
                n[5] = new LinkedListNode(latticePoints.get("bottomRight"));
                n[6] = new LinkedListNode(latticePoints.get("leftUpper"));
                n[7] = new LinkedListNode(latticePoints.get("rightBottom"));
                break;
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
                n[0] = new LinkedListNode(latticePoints.get("upperLeft"));
                n[1] = new LinkedListNode(latticePoints.get("upperRight"));
                n[2] = new LinkedListNode(latticePoints.get("rightUpper"));
                n[3] = new LinkedListNode(latticePoints.get("rightBottom"));
                n[4] = new LinkedListNode(latticePoints.get("bottomRight"));
                n[5] = new LinkedListNode(latticePoints.get("bottomLeft"));
                n[6] = new LinkedListNode(latticePoints.get("leftBottom"));
                n[7] = new LinkedListNode(latticePoints.get("leftUpper"));
                break;
            default:
                break;
        }
        return n;
    }

    public List<LinkedListNode> setupNodesSetNext(LinkedListNode n[]){
        n[0].setNext(n[1]);
        n[1].setNext(n[2]);
        n[2].setNext(n[3]);
        n[3].setNext(n[4]);
        n[4].setNext(n[5]);
        n[5].setNext(n[6]);
        n[6].setNext(n[7]);
        n[7].setNext(n[0]);
        List<LinkedListNode> nn = new ArrayList<>();
        for(LinkedListNode o:n){
            nn.add(o);
        }
        return nn;
    }

    public List<LinkedListNode> copyNodes(List<LinkedListNode> polygonOld){
        LinkedListNode n[] = new LinkedListNode[8];
        for (int i=0; i<8;i++){
            n[i] = new LinkedListNode(polygonOld.get(i));
        }
        n[0].setNext(n[1]);
        n[1].setNext(n[2]);
        n[2].setNext(n[3]);
        n[3].setNext(n[4]);
        n[4].setNext(n[5]);
        n[5].setNext(n[6]);
        n[6].setNext(n[7]);
        n[7].setNext(n[0]);
        List<LinkedListNode> nn = new ArrayList<>();
        for(LinkedListNode o:n){
            nn.add(o);
        }
        return nn;
    }

    public void step() {
        log.info("step");
        double wayFraction = 0.05;
        List<LinkedListNode> polygonOld = startNode.element();
        List<LinkedListNode> polygonNew = copyNodes(polygonOld);
        for(int i = 0; i<polygonNew.size();i++){
            LatticePoint thisPoint = polygonOld.get(i).getPoint();
            LatticePoint nextPoint = polygonOld.get(i).getNext().getPoint();
            LatticePoint delta = thisPoint.delta(nextPoint).scalarMultiplied(wayFraction);
            LatticePoint thisPointNew = thisPoint.plus(delta);
            polygonOld.get(i).setPoint(thisPointNew);
        }
        startNode.add(polygonNew);
    }
}
