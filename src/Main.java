/*
public class Main extends javax.swing.JFrame {


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
*/

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import normalization.Algos;
import normalization.Attribute;
import normalization.FuncDep;
import normalization.Relation;

public class Main extends JFrame {
  private static final String ERR = "Error!";
  
  private JTextArea area;
  
  private JButton buttonAbout;
  
  private JButton buttonCheck3NF;
  
  private JButton buttonCheckBCNF;
  
  private JButton buttonCheckEquiv;
  
  private JButton buttonClosure;
  
  private JButton buttonDecomp3NF;
  
  private JButton buttonDecompBCNF;
  
  private JButton buttonInfo;
  
  private JButton buttonKey;
  
  private JButton buttonLossyCheck;
  
  private JButton buttonMinimalBasis;
  
  private JButton buttonProjection;
  
  private JButton buttonSuperkey;
  
  private JButton buttonTestInput;
  
  private JTextField fieldAttribute;
  
  private JTextField fieldFD;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JScrollPane jScrollPane1;
  
  public Main() {
    initComponents();
  }
  
  private void initComponents() {
    this.fieldFD = new JTextField();
    this.fieldAttribute = new JTextField();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jScrollPane1 = new JScrollPane();
    this.area = new JTextArea();
    this.buttonClosure = new JButton();
    this.buttonMinimalBasis = new JButton();
    this.buttonProjection = new JButton();
    this.buttonCheckBCNF = new JButton();
    this.buttonCheck3NF = new JButton();
    this.buttonSuperkey = new JButton();
    this.buttonKey = new JButton();
    this.buttonDecompBCNF = new JButton();
    this.buttonDecomp3NF = new JButton();
    this.buttonTestInput = new JButton();
    this.buttonInfo = new JButton();
    this.buttonAbout = new JButton();
    this.buttonLossyCheck = new JButton();
    this.buttonCheckEquiv = new JButton();
    setDefaultCloseOperation(3);
    setTitle("Normalization Solver (c) 2015 SUN XIMENG Nathaniel");
    setLocationByPlatform(true);
    setResizable(false);
    this.fieldFD.setFont(new Font("Calibri", 0, 20));
    this.fieldFD.addFocusListener(new FocusAdapter() {
          public void focusGained(FocusEvent evt) {
            Main.this.fieldFDFocusGained(evt);
          }
        });
    this.fieldAttribute.setFont(new Font("Calibri", 0, 20));
    this.fieldAttribute.addFocusListener(new FocusAdapter() {
          public void focusGained(FocusEvent evt) {
            Main.this.fieldAttributeFocusGained(evt);
          }
        });
    this.jLabel1.setFont(new Font("Calibri", 0, 20));
    this.jLabel1.setText("Attributes:");
    this.jLabel2.setFont(new Font("Calibri", 0, 20));
    this.jLabel2.setText("FD's:");
    this.area.setEditable(false);
    this.area.setColumns(20);
    this.area.setFont(new Font("Consolas", 0, 20));
    this.area.setLineWrap(true);
    this.area.setRows(5);
    this.area.setWrapStyleWord(true);
    this.jScrollPane1.setViewportView(this.area);
    this.buttonClosure.setFont(new Font("Calibri", 0, 20));
    this.buttonClosure.setText("Closure");
    this.buttonClosure.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonClosureActionPerformed(evt);
          }
        });
    this.buttonMinimalBasis.setFont(new Font("Calibri", 0, 20));
    this.buttonMinimalBasis.setText("Minimal Basis");
    this.buttonMinimalBasis.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonMinimalBasisActionPerformed(evt);
          }
        });
    this.buttonProjection.setFont(new Font("Calibri", 0, 20));
    this.buttonProjection.setText("Projection");
    this.buttonProjection.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonProjectionActionPerformed(evt);
          }
        });
    this.buttonCheckBCNF.setFont(new Font("Calibri", 0, 20));
    this.buttonCheckBCNF.setText("Check BCNF");
    this.buttonCheckBCNF.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonCheckBCNFActionPerformed(evt);
          }
        });
    this.buttonCheck3NF.setFont(new Font("Calibri", 0, 20));
    this.buttonCheck3NF.setText("Check 3NF");
    this.buttonCheck3NF.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonCheck3NFActionPerformed(evt);
          }
        });
    this.buttonSuperkey.setFont(new Font("Calibri", 0, 20));
    this.buttonSuperkey.setText("Superkeys");
    this.buttonSuperkey.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonSuperkeyActionPerformed(evt);
          }
        });
    this.buttonKey.setFont(new Font("Calibri", 0, 20));
    this.buttonKey.setText("Keys");
    this.buttonKey.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonKeyActionPerformed(evt);
          }
        });
    this.buttonDecompBCNF.setFont(new Font("Calibri", 0, 20));
    this.buttonDecompBCNF.setText("BCNF Decomp.");
    this.buttonDecompBCNF.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonDecompBCNFActionPerformed(evt);
          }
        });
    this.buttonDecomp3NF.setFont(new Font("Calibri", 0, 20));
    this.buttonDecomp3NF.setText("3NF Decomp.");
    this.buttonDecomp3NF.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonDecomp3NFActionPerformed(evt);
          }
        });
    this.buttonTestInput.setFont(new Font("Calibri", 3, 20));
    this.buttonTestInput.setForeground(Color.red);
    this.buttonTestInput.setText("Test Inputs");
    this.buttonTestInput.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonTestInputActionPerformed(evt);
          }
        });
    this.buttonInfo.setFont(new Font("Calibri", 3, 18));
    this.buttonInfo.setText("Help");
    this.buttonInfo.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonInfoActionPerformed(evt);
          }
        });
    this.buttonAbout.setFont(new Font("Calibri", 3, 18));
    this.buttonAbout.setText("About");
    this.buttonAbout.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonAboutActionPerformed(evt);
          }
        });
    this.buttonLossyCheck.setFont(new Font("Calibri", 0, 20));
    this.buttonLossyCheck.setText("Detect FD Loss");
    this.buttonLossyCheck.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonLossyCheckActionPerformed(evt);
          }
        });
    this.buttonCheckEquiv.setFont(new Font("Calibri", 0, 20));
    this.buttonCheckEquiv.setText("Check Equiv.");
    this.buttonCheckEquiv.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            Main.this.buttonCheckEquivActionPerformed(evt);
          }
        });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(33, 33, 33)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.jLabel1)
                .addComponent(this.jLabel2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(this.fieldAttribute, -1, 771, 32767)
                .addComponent(this.fieldFD)))
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                  .addComponent(this.buttonTestInput, -2, 105, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.buttonClosure, -2, 135, -2))
                .addGroup(layout.createSequentialGroup()
                  .addComponent(this.buttonProjection)
                  .addGap(18, 18, 18)
                  .addComponent(this.buttonMinimalBasis))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(this.buttonSuperkey)
                    .addGap(18, 18, 18)
                    .addComponent(this.buttonKey))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(this.buttonCheckBCNF)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                    .addComponent(this.buttonCheck3NF))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(this.buttonDecompBCNF)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                    .addComponent(this.buttonDecomp3NF, -2, 105, -2))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(this.buttonLossyCheck)
                    .addGap(18, 18, 18)
                    .addComponent(this.buttonCheckEquiv, -1, -1, 32767))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(this.buttonInfo)
                    .addGap(18, 18, 18)
                    .addComponent(this.buttonAbout))))
              .addGap(42, 42, 42)
              .addComponent(this.jScrollPane1, -2, 488, -2)))
          .addContainerGap(22, 32767)));
    layout.linkSize(0, new Component[] { 
          this.buttonCheck3NF, this.buttonCheckBCNF, this.buttonCheckEquiv, this.buttonClosure, this.buttonDecomp3NF, this.buttonDecompBCNF, this.buttonKey, this.buttonLossyCheck, this.buttonMinimalBasis, this.buttonProjection, 
          this.buttonSuperkey, this.buttonTestInput });
    layout.linkSize(0, new Component[] { this.buttonAbout, this.buttonInfo });
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(17, 17, 17)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.fieldAttribute, -2, 47, -2)
            .addComponent(this.jLabel1))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.fieldFD, -2, 47, -2)
            .addComponent(this.jLabel2))
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addGap(18, 18, 18)
              .addComponent(this.jScrollPane1))
            .addGroup(layout.createSequentialGroup()
              .addGap(45, 45, 45)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.buttonTestInput)
                .addComponent(this.buttonClosure))
              .addGap(18, 18, 18)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.buttonProjection)
                .addComponent(this.buttonMinimalBasis))
              .addGap(18, 18, 18)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.buttonSuperkey)
                .addComponent(this.buttonKey))
              .addGap(18, 18, 18)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.buttonCheckBCNF)
                .addComponent(this.buttonCheck3NF, -2, 50, -2))
              .addGap(18, 18, 18)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.buttonDecompBCNF)
                .addComponent(this.buttonDecomp3NF))
              .addGap(18, 18, 18)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(this.buttonLossyCheck, -1, -1, 32767)
                .addComponent(this.buttonCheckEquiv, -1, -1, 32767))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, 32767)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.buttonInfo, -2, 52, -2)
                .addComponent(this.buttonAbout))))
          .addGap(19, 19, 19)));
    layout.linkSize(1, new Component[] { 
          this.buttonAbout, this.buttonCheck3NF, this.buttonCheckBCNF, this.buttonCheckEquiv, this.buttonClosure, this.buttonDecomp3NF, this.buttonDecompBCNF, this.buttonInfo, this.buttonKey, this.buttonLossyCheck, 
          this.buttonMinimalBasis, this.buttonProjection, this.buttonSuperkey, this.buttonTestInput });
    layout.linkSize(1, new Component[] { this.fieldAttribute, this.fieldFD, this.jLabel1, this.jLabel2 });
    pack();
  }
  
  private void buttonClosureActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (attrs.equals("") || fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      Set<Attribute> closure = Algos.closure(Attribute.getSet(attrs), FuncDep.getSet(fds));
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Closure>>>\n\n");
      for (Attribute a : closure) {
        sb.append(a);
        sb.append(", ");
      } 
      sb.delete(sb.length() - 2, sb.length() - 1);
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonTestInputActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (attrs.equals("") && fds.equals("")) {
        this.area.setText("You didn't enter anything yet.");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Testing Inputs>>>\n\n");
      Set<Attribute> names = Attribute.getSet(attrs);
      if (!names.isEmpty()) {
        sb.append("Attributes:\n");
        for (Attribute a : names) {
          sb.append(a);
          sb.append(", ");
        } 
        sb.append("\n\n");
      } 
      sb.delete(sb.length() - 4, sb.length() - 2);
      Set<FuncDep> fs = FuncDep.getSet(fds);
      if (!fs.isEmpty()) {
        sb.append("Functional Dependencies: \n");
        for (FuncDep f : fs) {
          sb.append(f);
          sb.append('\n');
        } 
        sb.deleteCharAt(sb.length() - 1);
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void fieldAttributeFocusGained(FocusEvent evt) {
    this.fieldAttribute.selectAll();
  }
  
  private void fieldFDFocusGained(FocusEvent evt) {
    this.fieldFD.selectAll();
  }
  
  private void buttonMinimalBasisActionPerformed(ActionEvent evt) {
    try {
      String fds = this.fieldFD.getText();
      if (fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Minimal Basis>>>\n\n");
      Set<FuncDep> mb = Algos.minimalBasis(FuncDep.getSet(fds));
      for (FuncDep fd : mb) {
        sb.append(fd);
        sb.append('\n');
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonProjectionActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (attrs.equals("") || fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Projection>>>\n\n");
      Set<FuncDep> mb = Algos.projection(Attribute.getSet(attrs), FuncDep.getSet(fds));
      for (FuncDep fd : mb) {
        sb.append(fd);
        sb.append('\n');
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonCheckBCNFActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (attrs.equals("") || fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Check BCNF>>>\n\n");
      Relation r = new Relation(attrs, fds);
      if (r.isBCNF()) {
        sb.append("This relation is already in BCNF.\n\n");
      } else {
        Set<FuncDep> violating = r.getFdsViolatingBCNF();
        sb.append("FD's violating BCNF:\n");
        for (FuncDep fd : violating) {
          sb.append(fd);
          sb.append('\n');
        } 
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonCheck3NFActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (attrs.equals("") || fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Check 3NF>>>\n\n");
      Relation r = new Relation(attrs, fds);
      if (r.is3NF()) {
        sb.append("This relation is already in 3NF.\n\n");
      } else {
        Set<FuncDep> violating = r.getFdsViolating3NF();
        sb.append("FD's violating 3NF:\n");
        for (FuncDep fd : violating) {
          sb.append(fd);
          sb.append('\n');
        } 
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonSuperkeyActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<All Superkeys>>>\n\n");
      Set<Set<Attribute>> keys = Algos.superKeys(Attribute.getSet(attrs), FuncDep.getSet(fds));
      for (Set<Attribute> sa : keys) {
        sb.append(sa);
        sb.append('\n');
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonKeyActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<All Candidate Keys>>>\n\n");
      Set<Set<Attribute>> keys = Algos.keys(Attribute.getSet(attrs), FuncDep.getSet(fds));
      for (Set<Attribute> sa : keys) {
        sb.append(sa);
        sb.append('\n');
      } 
      sb.deleteCharAt(sb.length() - 1);
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonDecompBCNFActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (attrs.equals("") || fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      Relation r = new Relation(attrs, fds);
      Set<Relation> rs = r.decomposeToBCNF();
      Set<Set<Attribute>> subattrs = new HashSet<>();
      for (Relation rl : rs)
        subattrs.add(rl.getAttributes()); 
      Set<FuncDep> lost = Algos.checkLossyDecomposition(r.getAttributes(), r.getFuncDeps(), subattrs);
      if (lost.isEmpty()) {
        sb.append("<<<Decomposed to BCNF with Preserved FD's>>>\n\n");
        for (Relation rl : rs) {
          sb.append(rl);
          sb.append("\n\n");
        } 
        sb.delete(sb.length() - 2, sb.length() - 1);
      } else {
        int select = JOptionPane.showConfirmDialog(this.rootPane, "Some FD's will be lost. Still continue?");
        if (select == 0) {
          sb.append("<<<Forced Decomposed to BCNF with FD Loss>>>\n\n");
          for (Relation rl : rs) {
            sb.append(rl);
            sb.append("\n\n");
          } 
          sb.append("Lost FD's:\n");
          for (FuncDep fd : lost) {
            sb.append(fd);
            sb.append('\n');
          } 
        } else {
          sb.append("Operation cancelled due to potential FD loss.\n\n");
        } 
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonDecomp3NFActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (attrs.equals("") || fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Forced Decomposition Regardless of Necessity>>>\n\n");
      Relation r = new Relation(attrs, fds);
      Set<Relation> rs = r.decomposeTo3NF();
      for (Relation rl : rs) {
        sb.append(rl);
        sb.append("\n\n");
      } 
      sb.delete(sb.length() - 2, sb.length() - 1);
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonInfoActionPerformed(ActionEvent evt) {
    Help.main(new String[0]);
  }
  
  private void buttonLossyCheckActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (attrs.equals("") || fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Detect FD Loss During Decomposition>>>\n\n");
      String input = JOptionPane.showInputDialog("Please enter sub-relations.\nFormat: Attributes are seperated by comma, and relations by semicolon.\nExample: A,B,C; C,D,E; A,D");
      String[] inputs = input.split(";");
      Set<Set<Attribute>> subattrs = new HashSet<>();
      byte b;
      int i;
      String[] arrayOfString1;
      for (i = (arrayOfString1 = inputs).length, b = 0; b < i; ) {
        String s = arrayOfString1[b];
        subattrs.add(Attribute.getSet(s));
        b++;
      } 
      Set<FuncDep> lost = Algos.checkLossyDecomposition(Attribute.getSet(attrs), FuncDep.getSet(fds), subattrs);
      if (lost.size() == 0) {
        sb.append("No FD is lost.");
      } else {
        sb.append("If decomposed into the following sub-relations\n");
        String[] arrayOfString;
        for (int j = (arrayOfString = inputs).length; i < j; ) {
          String s = arrayOfString[i];
          sb.append('(');
          sb.append(s.trim());
          sb.append(')');
          sb.append('\n');
          i++;
        } 
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n\nthe following FD's will be lost:\n");
        for (FuncDep fd : lost) {
          sb.append(fd);
          sb.append('\n');
        } 
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonCheckEquivActionPerformed(ActionEvent evt) {
    try {
      String attrs = this.fieldAttribute.getText();
      String fds = this.fieldFD.getText();
      if (fds.equals("")) {
        this.area.setText("Error!");
        return;
      } 
      StringBuilder sb = new StringBuilder();
      sb.append("<<<Check Equivalent Sets of FD's>>>\n\n");
      String input = JOptionPane.showInputDialog("Please enter another set of FD's.\n");
      boolean equiv = Algos.equivalent(FuncDep.getSet(fds), FuncDep.getSet(input));
      if (equiv) {
        sb.append("Yes, these two sets of FD's are equivalent.");
      } else {
        sb.append("No, these two sets of FD's are NOT equivalent.");
      } 
      this.area.setText(sb.toString());
    } catch (Exception e) {
      this.area.setText("Error!");
    } 
  }
  
  private void buttonAboutActionPerformed(ActionEvent evt) {
    About.main(new String[0]);
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
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new Main()).setVisible(true);
          }
        });
  }
}
