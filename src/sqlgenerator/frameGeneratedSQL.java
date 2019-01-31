/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlgenerator;

import java.awt.datatransfer.*;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.PrintWriter;
import java.awt.Desktop;

/**
 *
 * @author mjwat
 *
 * This class creates a frame that is used to the display the Generate SQL
 * -Current progress - This frame will contain a number of buttons with various
 * functions e.g. Save SQL, copy SQL and generate new SQL... etc....
 *
 */
public class frameGeneratedSQL extends javax.swing.JFrame {

    /**
     * Creates new form frameGeneratedSQL
     */
    public frameGeneratedSQL(String SQL) {
        initComponents();
        txtSQL.setText(SQL);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSQL = new javax.swing.JTextArea();
        lblGeneratedSQLTitle = new javax.swing.JLabel();
        btnCopy = new javax.swing.JButton();
        btnSaveSQL = new javax.swing.JButton();
        btnSaveSQLFile = new javax.swing.JButton();

        setTitle("SQL Insert Generator");
        setResizable(false);

        txtSQL.setColumns(20);
        txtSQL.setLineWrap(true);
        txtSQL.setRows(5);
        jScrollPane1.setViewportView(txtSQL);

        lblGeneratedSQLTitle.setText("Generated SQL Code");

        btnCopy.setText("Copy");
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        btnSaveSQL.setText("Save to DB");
        btnSaveSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSQLActionPerformed(evt);
            }
        });

        btnSaveSQLFile.setText("Save as File");
        btnSaveSQLFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSQLFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveSQLFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveSQL, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblGeneratedSQLTitle)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGeneratedSQLTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCopy)
                    .addComponent(btnSaveSQL)
                    .addComponent(btnSaveSQLFile))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //This button copys the generated SQL insert and copys to the system clip-board.
    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        String SQL = txtSQL.getText();
        StringSelection stringSelection = new StringSelection(SQL);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_btnCopyActionPerformed

    private void btnSaveSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSQLActionPerformed
        String SQL = txtSQL.getText();
        String nameOfInsert = "";
        try {
            nameOfInsert = JOptionPane.showInputDialog("Enter Name: ");
            if (nameOfInsert.equals(null) || nameOfInsert.equalsIgnoreCase("")) {
                JOptionPane dialogBox = new JOptionPane();
                JOptionPane.showMessageDialog(dialogBox, "No name was given. Please at enter a name.", "Save Failed!", JOptionPane.PLAIN_MESSAGE);
            } else {
                DatabaseConnection databaseConnection = new DatabaseConnection();
                databaseConnection.insertSavedSQL(SQL, nameOfInsert);
                databaseConnection.closeDatabaseConnection();
            }
        } catch (Exception ex) {
            System.out.println("btnSaveSQLActionPerformed - Cancel Selected - no negative effect on prog. Exception:  " + ex);
        }
    }//GEN-LAST:event_btnSaveSQLActionPerformed

    private void btnSaveSQLFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSQLFileActionPerformed
        String nameOfFile = "";
        nameOfFile = JOptionPane.showInputDialog("Enter Name: ");
        if (nameOfFile.equals(null) || nameOfFile.equalsIgnoreCase("")) {
            JOptionPane dialogBox = new JOptionPane();
            JOptionPane.showMessageDialog(dialogBox, "No name was given. Please at add a descriptive name to save.", "Save Failed!", JOptionPane.PLAIN_MESSAGE);
        } else {
            try {
                //here
                File dir = new File("SavedSQL");
                File file = new File(dir, (nameOfFile + ".txt"));
                file.createNewFile();
                //Prints into the file
                PrintWriter output = new PrintWriter(file);
                output.print(txtSQL.getText());
                output.close();
                int openFile = JOptionPane.showConfirmDialog(null, "Open File Location?", "Test", JOptionPane.YES_NO_OPTION);
                //for some reason 0 means open.
                if (openFile == 0) {
                    Desktop.getDesktop().open(new File(file.getAbsolutePath()));
                } else {
                  //do nothing.
                }
            } catch (Exception ex) {
                System.out.println("btnSaveSQLFileActionPerformed: " + ex);
            }
        }
    }//GEN-LAST:event_btnSaveSQLFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frameGeneratedSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameGeneratedSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameGeneratedSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameGeneratedSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameGeneratedSQL("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnSaveSQL;
    private javax.swing.JButton btnSaveSQLFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGeneratedSQLTitle;
    private javax.swing.JTextArea txtSQL;
    // End of variables declaration//GEN-END:variables
}
