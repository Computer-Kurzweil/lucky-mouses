package org.woehlke.computer.kurzweil.lucky.mouses.view.labels;

import org.woehlke.computer.kurzweil.lucky.mouses.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.lucky.mouses.model.LuckyMousesModel;
import org.woehlke.computer.kurzweil.lucky.mouses.view.LuckyMousesFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelButtons extends JPanel implements ActionListener {

    final static long serialVersionUID = 242L;

    private volatile JLabel copyright;
    private volatile JButton buttonsRunA;
    private volatile JButton buttonsRunB;
    private volatile JButton buttonsRunC;
    private volatile JButton buttonsRunD;
    private volatile JButton buttonsRunE;
    private volatile JButton buttonsRunF;
    private volatile JButton buttonsRunG;
    private volatile JButton buttonsRunH;
    private volatile JButton buttonsRunI;
    private volatile JButton buttonsRunJ;
    private volatile JButton buttonsRunK;
    private final LuckyMousesFrame tab;
    private final LuckyMousesModel model;

    public PanelButtons(LuckyMousesModel model, LuckyMousesFrame tab, ComputerKurzweilProperties config ) {
        this.tab = tab;
        this.model = model;
        this.copyright = new JLabel(config.getLuckyMouses().getView().getCopyright());
        this.buttonsRunA = new JButton(config.getLuckyMouses().getView().getButtonsRunA());
        this.buttonsRunB = new JButton(config.getLuckyMouses().getView().getButtonsRunB());
        this.buttonsRunC = new JButton(config.getLuckyMouses().getView().getButtonsRunC());
        this.buttonsRunD = new JButton(config.getLuckyMouses().getView().getButtonsRunD());
        this.buttonsRunE = new JButton(config.getLuckyMouses().getView().getButtonsRunE());
        this.buttonsRunF = new JButton(config.getLuckyMouses().getView().getButtonsRunF());
        this.buttonsRunG = new JButton(config.getLuckyMouses().getView().getButtonsRunG());
        this.buttonsRunH = new JButton(config.getLuckyMouses().getView().getButtonsRunH());
        this.buttonsRunI = new JButton(config.getLuckyMouses().getView().getButtonsRunI());
        this.buttonsRunJ = new JButton(config.getLuckyMouses().getView().getButtonsRunJ());
        this.buttonsRunK = new JButton(config.getLuckyMouses().getView().getButtonsRunK());
        int hgap = 16;
        int vgap = 2;
        this.copyright.setLayout(new FlowLayout( FlowLayout.RIGHT, hgap, vgap));
        FlowLayout layout = new FlowLayout( FlowLayout.LEFT, hgap, vgap);
        this.buttonsRunA.setLayout(layout);
        this.buttonsRunB.setLayout(layout);
        this.buttonsRunC.setLayout(layout);
        this.buttonsRunD.setLayout(layout);
        this.buttonsRunE.setLayout(layout);
        this.buttonsRunF.setLayout(layout);
        this.buttonsRunG.setLayout(layout);
        this.buttonsRunH.setLayout(layout);
        this.buttonsRunI.setLayout(layout);
        this.buttonsRunJ.setLayout(layout);
        this.buttonsRunK.setLayout(layout);
        this.setLayout(new FlowLayout( FlowLayout.CENTER, hgap, vgap));
        this.add(this.copyright);
        this.add(this.buttonsRunA);
        this.add(this.buttonsRunB);
        this.add(this.buttonsRunC);
        this.add(this.buttonsRunC);
        this.add(this.buttonsRunD);
        this.add(this.buttonsRunE);
        this.add(this.buttonsRunF);
        this.add(this.buttonsRunG);
        this.add(this.buttonsRunH);
        this.add(this.buttonsRunI);
        this.add(this.buttonsRunJ);
        this.add(this.buttonsRunK);
        this.buttonsRunA.addActionListener(this);
        this.buttonsRunB.addActionListener(this);
        this.buttonsRunC.addActionListener(this);
        this.buttonsRunD.addActionListener(this);
        this.buttonsRunE.addActionListener(this);
        this.buttonsRunF.addActionListener(this);
        this.buttonsRunG.addActionListener(this);
        this.buttonsRunH.addActionListener(this);
        this.buttonsRunI.addActionListener(this);
        this.buttonsRunJ.addActionListener(this);
        this.buttonsRunK.addActionListener(this);
    }

    /**
     * TODO write doc.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.buttonsRunA){
            this.model.runA();
        }
        if(ae.getSource() == this.buttonsRunB){
            this.model.runB();
        }
        if(ae.getSource() == this.buttonsRunC){
            this.model.runC();
        }
        if(ae.getSource() == this.buttonsRunD){
            this.model.runD();
        }
        if(ae.getSource() == this.buttonsRunE){
            this.model.runE();
        }
        if(ae.getSource() == this.buttonsRunF){
            this.model.runF();
        }
        if(ae.getSource() == this.buttonsRunG){
            this.model.runG();
        }
        if(ae.getSource() == this.buttonsRunH){
            this.model.runH();
        }
        if(ae.getSource() == this.buttonsRunI){
            this.model.runI();
        }
        if(ae.getSource() == this.buttonsRunJ){
            this.model.runJ();
        }
        if(ae.getSource() == this.buttonsRunK){
            this.model.runK();
        }
        this.tab.getCanvas().repaint();
        this.tab.repaint();
    }
}
