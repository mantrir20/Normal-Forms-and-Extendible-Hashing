/*
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Help extends JFrame {
  private JScrollPane jScrollPane1;
  
  private JTextArea jTextArea1;
  
  public Help() {
    initComponents();
  }
  
  private void initComponents() {
    this.jScrollPane1 = new JScrollPane();
    this.jTextArea1 = new JTextArea();
    setTitle("Help");
    setLocationByPlatform(true);
    setResizable(false);
    this.jTextArea1.setEditable(false);
    this.jTextArea1.setColumns(20);
    this.jTextArea1.setFont(new Font("Consolas", 0, 18));
    this.jTextArea1.setRows(5);
    this.jTextArea1.setText("\"Attributes\"\n    Format: attribute names separated by comma.\n    Examples:\n\tname, location, favAppl, appl, provider\n\tA,B,C,D,E\n\n\"FD's\"\n    Format:\n\tAttribute names separated by comma.\n\tFD's separated by semicolon.\n    Examples:\n\tname-->location,favAppl; appl-->provider \n\tA-->B,C; C,D-->E; E-->A; B-->D\n\n*White spaces are auto-ignored.\n*Everything is case-sensitive.");
    this.jTextArea1.setOpaque(false);
    this.jScrollPane1.setViewportView(this.jTextArea1);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(this.jScrollPane1, -1, 576, 32767)
          .addContainerGap()));
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(this.jScrollPane1, -1, 374, 32767)
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
      Logger.getLogger(Help.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Help.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Help.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Help.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new Help()).setVisible(true);
          }
        });
  }
}