/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlgenerator;

import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mjwat
 */
public class frameSearchSavedSQL extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * Creates new form frameSearchSavedSQL
     */
    public frameSearchSavedSQL() {
        initComponents();
        displaySQLQueryToTable();
    }

    public ArrayList<StoredSQL> storedSQL() {
        ArrayList<StoredSQL> SQLFromDB;
        DatabaseConnection databaseConnection = new DatabaseConnection();
        SQLFromDB = databaseConnection.getStoredSQL();
        return SQLFromDB;
    }

    public ArrayList<StoredSQL> storedSQLFilter(String name) {
        ArrayList<StoredSQL> SQLFromDB;
        DatabaseConnection databaseConnection = new DatabaseConnection();
        SQLFromDB = databaseConnection.getStoredSQLFilter(name);
        return SQLFromDB;
    }

    //filter Data
    private void filterName(String queryName) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tableSQL.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(queryName, 1));
    }

    private void filterDate(String queryDate) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tableSQL.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(queryDate, 0));
    }

    public void displaySQLQueryToTable() {
        ArrayList<StoredSQL> list = storedSQL();
        model = (DefaultTableModel) tableSQL.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getDate();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getSQL();
            model.addRow(row);
        }//for
    }//displaySQLQueryToTable

    public void displaySQLQueryToTableFilter() {
        ArrayList<StoredSQL> list = storedSQLFilter(txtFilterName.getText());
        System.out.println("txtFilterName : " + txtFilterName.getText());
        model = (DefaultTableModel) tableSQL.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getDate();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getSQL();
            model.addRow(row);
        }//for
    }//displaySQLQueryToTableFilter

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFilterName = new javax.swing.JTextField();
        lblSearchName = new javax.swing.JLabel();
        lblSearchDate = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tableSQL = new javax.swing.JTable();
        txtSearchDate = new javax.swing.JFormattedTextField();
        Refesh = new javax.swing.JButton();

        setTitle("SQL Insert Generator");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        txtFilterName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilterNameActionPerformed(evt);
            }
        });
        txtFilterName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyPressedActionPerformed(evt);
            }
        });

        lblSearchName.setText("Search Name:");

        lblSearchDate.setText("Search Date (dd/mm/yyyy) :");

        lblTitle.setText("Search for SQL");

        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableSQL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Name", "SQL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSQL.setColumnSelectionAllowed(true);
        tableSQL.setRowHeight(30);
        tableSQL.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(tableSQL);
        tableSQL.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableSQL.getColumnModel().getColumnCount() > 0) {
            tableSQL.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        txtSearchDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchDateActionPerformed(evt);
            }
        });
        txtSearchDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchDateKeyPressed(evt);
            }
        });

        Refesh.setText("Refresh");
        Refesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearchDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearchName)
                        .addGap(5, 5, 5)
                        .addComponent(txtFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(Refesh))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchDate)
                    .addComponent(txtSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilterNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilterNameActionPerformed
        txtSearchDate.setText(null);
        String query = txtFilterName.getText();
        System.out.println("Filtering");
        filterName(query);
    }//GEN-LAST:event_txtFilterNameActionPerformed

    private void RefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefeshActionPerformed
        model.setRowCount(0);
        displaySQLQueryToTable();
    }//GEN-LAST:event_RefeshActionPerformed

    private void keyPressedActionPerformed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPressedActionPerformed
        txtSearchDate.setText(null);
        String query = txtFilterName.getText();
        System.out.println("Filtering");
        filterName(query);
    }//GEN-LAST:event_keyPressedActionPerformed

    private void txtSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchDateActionPerformed
        txtFilterName.setText(null);
        String query = txtSearchDate.getText();
        System.out.println("Filtering");
        filterDate(query);
    }//GEN-LAST:event_txtSearchDateActionPerformed

    private void txtSearchDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDateKeyPressed
        txtFilterName.setText(null);
        String query = txtSearchDate.getText();
        System.out.println("Filtering");
        filterDate(query);
    }//GEN-LAST:event_txtSearchDateKeyPressed

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
            java.util.logging.Logger.getLogger(frameSearchSavedSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameSearchSavedSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameSearchSavedSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameSearchSavedSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameSearchSavedSQL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refesh;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblSearchDate;
    private javax.swing.JLabel lblSearchName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tableSQL;
    private javax.swing.JTextField txtFilterName;
    private javax.swing.JFormattedTextField txtSearchDate;
    // End of variables declaration//GEN-END:variables
}