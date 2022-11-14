
package mukodes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Dolgozat1114 {

    public static void main(String[] args) {
        new Dolgozat1114();
    }
    
    /*Adattagok*/
    private JFrame frame;
    private static final int GOMB_DB = 10;
    
    private JButton gomb1, gomb2, gomb3, gomb4, gomb5, gomb6, gomb7, gomb8, gomb9, gomb0;
    private JButton[] gombok;
    private JPanel pnlBal;
    private JTextField szamokField;
    private String kodsor= "";
    
    private static final int AMOBAGOMB_DB = 9;
    private JButton[] amobaGombok;
    private JCheckBox keverCheck;
    /*Konstruktor*/
    public Dolgozat1114(){
        ini();
    }
    
    /*Kinézet, inicializálás*/
    
    private void ini(){
        adatModellIni();
        formIni();
    }
    
    private void adatModellIni(){
        gombok = new JButton[GOMB_DB];
        amobaGombok = new JButton[AMOBAGOMB_DB];
    }
    
    private void formIni(){
        frame = new JFrame("GUI - OOP 1. dolgozat");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new FormWindowAdapter());
        frame.setSize(410, 350);
        frame.setJMenuBar(menuIni());
        tartalomKinezetIni();
        frame.setVisible(true);
    }
    
    private JMenuBar menuIni(){
    /*Menü*/
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuPrg = new JMenu("Program");
        
        JMenu mnuJatekElrend = new JMenu("Játék elrendezése");
        menuBar.add(mnuPrg);
        menuBar.add(mnuJatekElrend);
        
        JMenuItem mnPrgUjra = new JMenuItem("Újra");
        mnPrgUjra.addActionListener(new MnuUjraListener());
        mnuPrg.add(mnPrgUjra);
        
        mnuPrg.addSeparator();
        
        JMenuItem mnuPrgKilep = new JMenuItem("Kilépés");
        mnuPrgKilep.addActionListener(new MnuKilepListener());
        mnuPrg.add(mnuPrgKilep);
        
        
        JMenuItem mnuVizsz = new JMenuItem("vízszintes");
        JMenuItem mnuFugg = new JMenuItem("függőleges");
        mnuJatekElrend.add(mnuVizsz);
        mnuJatekElrend.add(mnuFugg);
       
        
        return menuBar;
    }
    
    private void tartalomKinezetIni(){
        LayoutManager lymGridFrame = new GridLayout(1, 1);
        
        
        pnlBal = pnlBalIni();
        JPanel pnlJobb = pnlJobbIni();
        frame.getContentPane().add(pnlBal);
        frame.getContentPane().add(pnlJobb);
        
        JPanel pnlbejel = new JPanel();
        pnlbejel.add(pnlBal);
        pnlbejel.add(pnlJobb);
        
        JPanel pnlJatekBal = pnlJatekBalIni();
        JPanel pnlJatekJobb = pnlJatekJobbIni();
        frame.getContentPane().add(pnlJatekBal);
        frame.getContentPane().add(pnlJatekJobb);
        
        JPanel pnlJatek = new JPanel();
        pnlJatek.add(pnlJatekBal);
        pnlJatek.add(pnlJatekJobb);
        
        JTabbedPane paneBejel = new JTabbedPane();
        paneBejel.setSize(50, 200);
        paneBejel.addTab("Bejelentkezés", pnlbejel);
        paneBejel.addTab("Játék", pnlJatek);
        frame.getContentPane().add(paneBejel);
        
        pnlbejel.setLayout(lymGridFrame);
        pnlJatek.setLayout(lymGridFrame);
        
        
    }
    
    private JPanel pnlJatekBalIni(){
        JPanel pnlJatekBal = new JPanel();
        pnlJatekBal.setBorder(new TitledBorder("Amőba"));
        
        amobaGombokIni();
        for (JButton g : amobaGombok) {
            pnlJatekBal.add(g);
        }
        return pnlJatekBal;
    }
    
    private JPanel pnlJatekJobbIni(){
        LayoutManager lymGridFrame = new GridLayout(3, 1);
        JPanel pnlJatekJobb = new JPanel();
        pnlJatekJobb.setBorder(new TitledBorder("Beállítás"));
        
        JRadioButton radio1 = new JRadioButton("X kezd", true);
        JRadioButton radio2 = new JRadioButton("O kezd", false);
        ButtonGroup csoport = new ButtonGroup();
        csoport.add(radio1);
        csoport.add(radio2);
        
        JPanel pnl = new JPanel();
        String lista[]={"3*3","4*4","5*5"};
        JList list = new JList(lista);
        list.add(pnl);
        pnl.setBounds(0, 0,100,10);
        JScrollPane scrollPane = new JScrollPane(pnl);
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
        pnlJatekJobb.add(list);
        pnlJatekJobb.add(radio1);
        pnlJatekJobb.add(radio2);
        pnlJatekJobb.setLayout(lymGridFrame);
        return pnlJatekJobb;
    }
    
    private JPanel pnlBalIni() {
        JPanel pnlBal = new JPanel();
        pnlBal.setBorder(new TitledBorder("Pin kód"));
        
        gombokIni();
        for (JButton g : gombok) {
            pnlBal.add(g);
        }
        return pnlBal;
    }
    
    private JPanel pnlJobbIni() {
        LayoutManager lymGridFrame = new GridLayout(3, 1);
        JPanel pnlJobb = new JPanel();
        pnlJobb.setBorder(new TitledBorder("Beállítás"));
        keverCheck = new JCheckBox("kever");
        keverCheck.addActionListener(new kever());
        pnlJobb.add(keverCheck);
    
        
        
        JLabel lbl = new JLabel("Kód: ");
        
        pnlJobb.add(lbl);
        
        szamokField = new JTextField();
        pnlJobb.add(szamokField);
        
        pnlJobb.setLayout(lymGridFrame);
        
        return pnlJobb;
    }
    
    private void gombokIni(){
        JButton gomb1 = new JButton("1");
        JButton gomb2 = new JButton("2");
        JButton gomb3 = new JButton("3");
        JButton gomb4 = new JButton("4");
        JButton gomb5 = new JButton("5");
        JButton gomb6 = new JButton("6");
        JButton gomb7 = new JButton("7");
        JButton gomb8 = new JButton("8");
        JButton gomb9 = new JButton("9");
        JButton gomb0 = new JButton("0");
        
        gombok[0] = gomb1;
        gombok[1] = gomb2;
        gombok[2] = gomb3;
        gombok[3] = gomb4;
        gombok[4] = gomb5;
        gombok[5] = gomb6;
        gombok[6] = gomb7;
        gombok[7] = gomb8;
        gombok[8] = gomb9;
        gombok[9] = gomb0;
        
        for (JButton g : gombok) {
            g.addActionListener(new KattintListener());
        }

    }
    
    private void amobaGombokIni(){
        JButton gomb1 = new JButton();
        JButton gomb2 = new JButton();
        JButton gomb3 = new JButton();
        JButton gomb4 = new JButton();
        JButton gomb5 = new JButton();
        JButton gomb6 = new JButton();
        JButton gomb7 = new JButton();
        JButton gomb8 = new JButton();
        JButton gomb9 = new JButton();
        
        amobaGombok[0] = gomb1;
        amobaGombok[1] = gomb2;
        amobaGombok[2] = gomb3;
        amobaGombok[3] = gomb4;
        amobaGombok[4] = gomb5;
        amobaGombok[5] = gomb6;
        amobaGombok[6] = gomb7;
        amobaGombok[7] = gomb8;
        amobaGombok[8] = gomb9;
        
        

    }
    
    /*Belső osztályok*/
    class FormWindowAdapter extends WindowAdapter{

        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            kilepes();
        }
        
    }
    class MnuUjraListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ujJatek();
        }
    }
    
    
    class MnuKilepListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            kilepes();
        }
    }
    
    class KattintListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton gomb = (JButton)e.getSource();
            gomb.setBackground(Color.red);
            String felirat = gomb.getActionCommand();
            kodsor += felirat;
            szamokField.setText(kodsor);
            
        }
        
    }
    
    class kever implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (keverCheck.isSelected()) {
                System.out.println("igen csekkelt");
                List<Integer> szamok = new ArrayList<>();
                System.out.println("igen csekkelt");
                for (int i = 0; i < GOMB_DB; i++) {
                    szamok.add(i);
                }
                System.out.println("igen csekkelt");
                Collections.shuffle(szamok);
                System.out.println("igen csekkelt");
                gombok[szamok.get(0)] = gomb1;
                gombok[szamok.get(1)] = gomb2;
                gombok[szamok.get(2)] = gomb3;
                gombok[szamok.get(3)] = gomb4;
                gombok[szamok.get(4)] = gomb5;
                gombok[szamok.get(5)] = gomb6;
                gombok[szamok.get(6)] = gomb7;
                gombok[szamok.get(7)] = gomb8;
                gombok[szamok.get(8)] = gomb9;
                gombok[szamok.get(9)] = gomb0;
                System.out.println(szamok.get(0));
                System.out.println("igen csekkelt5");
                gombBerak();
                
                System.out.println("igen csekkelt6");
                frame.validate();
            } else if(!(keverCheck.isSelected())){
                for (JButton g : gombok) {
                    pnlBal.remove(g);
                }
                gombokIni();
            }
        }
    }
    
    /*Működéssel kapcsolatos tagfüggvények*/
    private void kilepes(){
        int valasz = JOptionPane.showConfirmDialog(frame, "Kilépés", "Biztos kilép?", JOptionPane.YES_NO_OPTION);
        if(valasz == JOptionPane.YES_OPTION){
            System.exit(valasz);
        }
    }
    
    private void ujJatek(){
        szamokField.setText("");
        pnlBal.removeAll();
        gombokIni();
        keverCheck.setSelected(false);
        frame.validate();
    }
    
    private void gombBerak(){
        for (JButton g : gombok) {
                    pnlBal.add(g);
                }
    }
    
    
   
}
