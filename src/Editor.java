
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Editor extends JComponent implements KeyListener, WindowListener {
    private JFrame fen;
    private int nChars = 0;
    private int nWords = 0;
    private JLabel lChars,lWords;
    private JTextArea tArea;
    private JProgressBar progressBar;
    private JPanel navPanel;
    private int nCapacity = 0;




    public Editor(){
        fen = new JFrame("Editor");
        fen.setSize(800,600);
        Container c = fen.getContentPane();
        c.setLayout(new BorderLayout());

        navPanel =new JPanel(new FlowLayout());
        lChars = new JLabel("Chars");
        lWords = new JLabel("Words");





       

        tArea = new JTextArea();
        tArea.addKeyListener(this);
        
        navPanel.add(lChars);
        navPanel.add(new JLabel(Integer.toString(nChars)));
        navPanel.add(lWords);
        navPanel.add(new JLabel(Integer.toString(nWords)));

       
        fen.addWindowListener(this);
        System.out.println(nCapacity);
        progressBar = new JProgressBar(1);
        progressBar.setMinimum(0);
        
        progressBar.setStringPainted(true);


        fen.add(navPanel,"North");
        fen.add(progressBar,"East");
        fen.add(tArea,"Center");


        fen.setVisible(true);
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        nChars = this.tArea.getText().length();
        nWords = this.tArea.getText().trim().split("\\s+").length;
        ( (JLabel)this.navPanel.getComponent(1)).setText(Integer.toString(nChars));
        ( (JLabel)this.navPanel.getComponent(3)).setText(Integer.toString(nWords));

       if(this.nCapacity > 0){

        this.progressBar.setValue(this.nChars*100/this.nCapacity);

       }else{
        //tArea.setText(tArea.getText().substring(0, this.nCapacity));
       }
       
        

      
    }

    @Override
    public void keyTyped(KeyEvent e) {
            
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
     

        nChars = this.tArea.getText().length();
        nWords = this.tArea.getText().trim().split("\\s+").length;
        ( (JLabel)this.navPanel.getComponent(1)).setText(Integer.toString(nChars));
        ( (JLabel)this.navPanel.getComponent(3)).setText(Integer.toString(nWords));

       if(this.nCapacity > 0){
        this.progressBar.setValue(this.nChars*100/this.nCapacity);
       }else{
        tArea.setText(tArea.getText().substring(0, this.nCapacity));
       }

    
    }

    @Override
    public void windowOpened(WindowEvent e) {

        do{
            String s = JOptionPane.showInputDialog(this,"Entrez la capacité de l'éditeur :",
            "Saisie de la capacité" , JOptionPane.PLAIN_MESSAGE);

            if(s==null){
                System.exit(0);
                try {
                    this.setnCapacity(Integer.parseInt(s));
                    this.progressBar.setMaximum(nCapacity);
                    System.out.println(nCapacity);
                    if(this.nCapacity < 0){
                        JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre entier positif");
                    }
                   
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Entrée invalide. Veuillez entrer un nombre valide");
                }
            }

        

        }while(nCapacity > 0);

   
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
 
    }

    @Override
    public void windowIconified(WindowEvent e) {
 
 
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
 
    }

    @Override
    public void windowActivated(WindowEvent e) {
 
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    
    }

    public void setFen(JFrame fen) {
        this.fen = fen;
    }

    public void setnChars(int nChars) {
        this.nChars = nChars;
    }

    public void setnWords(int nWords) {
        this.nWords = nWords;
    }

    public void setlChars(JLabel lChars) {
        this.lChars = lChars;
    }

    public void setlWords(JLabel lWords) {
        this.lWords = lWords;
    }

    public void settArea(JTextArea tArea) {
        this.tArea = tArea;
    }

    public void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void setNavPanel(JPanel navPanel) {
        this.navPanel = navPanel;
    }

    public void setnCapacity(int nCapacity) {
        this.nCapacity = nCapacity;
    }

    public JFrame getFen() {
        return fen;
    }

    public int getnChars() {
        return nChars;
    }

    public int getnWords() {
        return nWords;
    }

    public JLabel getlChars() {
        return lChars;
    }

    public JLabel getlWords() {
        return lWords;
    }

    public JTextArea gettArea() {
        return tArea;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JPanel getNavPanel() {
        return navPanel;
    }

    public int getnCapacity() {
        return nCapacity;
    }

 


    
}
