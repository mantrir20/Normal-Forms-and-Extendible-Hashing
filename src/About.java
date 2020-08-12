
/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
*/


import java.awt.EventQueue;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class About extends JFrame {
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JScrollPane jScrollPane1;
  
  private JTextArea jTextArea1;
  
  public About() {
    initComponents();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jScrollPane1 = new JScrollPane();
    this.jTextArea1 = new JTextArea();
    setTitle("About");
    setAutoRequestFocus(false);
    setLocationByPlatform(true);
    setResizable(false);
    this.jLabel1.setFont(new Font("Garamond", 1, 48));
    this.jLabel1.setText("Normalization Helper");
    this.jLabel2.setFont(new Font("Calibri Light", 2, 20));
    this.jLabel2.setText("A simple tool to make normalization a lot easier.");
    this.jTextArea1.setEditable(false);
    this.jTextArea1.setColumns(20);
    this.jTextArea1.setFont(new Font("Calibri", 0, 18));
    this.jTextArea1.setLineWrap(true);
    this.jTextArea1.setRows(5);
    this.jTextArea1.setText("Author: Garvit Soni\nVersion: 1.0\nLast Update: 25 Mar 2020\nContact: garvitalwar@gmail.com\n\nCopyright (c) 2020 GARVIT SONI\nAll rights reserved.");
    this.jTextArea1.setWrapStyleWord(true);
    this.jTextArea1.setOpaque(false);
    this.jScrollPane1.setViewportView(this.jTextArea1);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap(67, 32767)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jScrollPane1, -2, 465, -2)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
              .addComponent(this.jLabel2)
              .addComponent(this.jLabel1)))
          .addGap(68, 68, 68)));
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(54, 54, 54)
          .addComponent(this.jLabel1)
          .addGap(18, 18, 18)
          .addComponent(this.jLabel2)
          .addGap(18, 18, 18)
          .addComponent(this.jScrollPane1, -2, 192, -2)
          .addContainerGap()));
    pack();
  }
  
  public static void main(String[] args) {
    try {
      byte b;
      int i;
      UIManager.LookAndFeelInfo[] arrayOfLookAndFeelInfo;
      for (i = (arrayOfLookAndFeelInfo = UIManager.getInstalledLookAndFeels()).length, b = 0; b < i; ) {
        UIManager.LookAndFeelInfo info = arrayOfLookAndFeelInfo[b];
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
        b++;
      } 
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(About.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(About.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(About.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(About.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new About()).setVisible(true);
          }
        });
  }
}
