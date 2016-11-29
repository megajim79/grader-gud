/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindemo;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author James
 */
public class StudentAssignmentTable extends javax.swing.JFrame {
    Object id = null;
    Object name = null;
    String[] student_headers = null;
    /**
     * Creates new form StudentAssignmentTable
     */
    public StudentAssignmentTable(Object selected_id,Object selected_name, Object num) {
        initComponents();
        student_headers = new String [2 + (Integer.parseInt(num.toString()))];
        student_headers[0] = "Name";
        student_headers[1] = "FIDN";
        DefaultTableModel model = (DefaultTableModel) StudentTable1.getModel();
        for (int i = 0; i < (Integer.parseInt(num.toString())); i++) {
            student_headers[i+2] = "Assignment " + (i+1);
            model.addColumn(student_headers[i+2]);
        }
        model.addColumn("Average");
        
        name = selected_name;
        id = selected_id;
        if(file_system.check_existance(name.toString()+id.toString()+".csv")){
            ArrayList<ArrayList<String>> data = file_system.read_from_file(name.toString()+id.toString()+".csv",student_headers);
            for(int i = 1; i < data.size();i++)
            {
               Vector<String> vector = new Vector<String>(data.get(i));
               int sum = 0;
               for (int y=2; y < student_headers.length; y++){
                   sum += Integer.parseInt(vector.get(y));
               }
               sum = sum/(student_headers.length-2);
               vector.addElement(Integer.toString(sum));
               model.addRow(vector);
                 
            }
        
        }
        else
            file_system.create_file(name.toString()+id.toString()+".csv");
        StudentNameLabel1.setText(StudentNameLabel1.getText() + name);

    }

         private String[][] tableDataToArray()
    {
        int columnCount = StudentTable1.getColumnCount();
        int rowCount = StudentTable1.getRowCount();
        String[][] data = new String[rowCount][columnCount]  ;  
        for(int i = 0; i < rowCount; i++)
        {
           for(int y = 0; y < columnCount; y++)
           {
              if(StudentTable1.getValueAt(i,y)==null)
                data[i][y] = "0";
              else
                data[i][y] = StudentTable1.getValueAt(i,y).toString();
           }
        }
        return data;
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        StudentNameLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AssignmentTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DateTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AddButton1 = new javax.swing.JButton();
        RemoveButton1 = new javax.swing.JButton();
        ExitButton1 = new javax.swing.JButton();
        LogOutButton1 = new javax.swing.JButton();
        BackButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StudentNameLabel1.setText("Class Name:");

        jLabel1.setText("Student");

        AssignmentTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignmentTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("FIDN");

        AddButton1.setText("Add");
        AddButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton1ActionPerformed(evt);
            }
        });

        RemoveButton1.setText("Remove");
        RemoveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButton1ActionPerformed(evt);
            }
        });

        ExitButton1.setText("Exit");
        ExitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButton1ActionPerformed(evt);
            }
        });

        LogOutButton1.setText("Log Out");
        LogOutButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButton1ActionPerformed(evt);
            }
        });

        BackButton1.setText("Back");
        BackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButton1ActionPerformed(evt);
            }
        });

        StudentTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student", "FIDN"
            }
        ));
        jScrollPane1.setViewportView(StudentTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(BackButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOutButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentNameLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(AssignmentTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(AddButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RemoveButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StudentNameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(AssignmentTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton1)
                    .addComponent(RemoveButton1)
                    .addComponent(jButton1))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DateTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(357, 357, 357)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton1)
                    .addComponent(LogOutButton1)
                    .addComponent(BackButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AssignmentTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignmentTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AssignmentTextField1ActionPerformed

    private void LogOutButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButton1ActionPerformed
        // TODO add your handling code here:
        LoginForm o = new LoginForm();
        o.setVisible(true);
        close();
    }//GEN-LAST:event_LogOutButton1ActionPerformed

    private void AddButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) StudentTable1.getModel();
        model.addRow(new Object[]{AssignmentTextField1.getText(),DateTextField1.getText()});
    }//GEN-LAST:event_AddButton1ActionPerformed

    private void ExitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButton1ActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_ExitButton1ActionPerformed

    private void BackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButton1ActionPerformed
        // TODO add your handling code here:
        JTableForm j = new JTableForm();
        j.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackButton1ActionPerformed

    private void RemoveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) StudentTable1.getModel();
        int numRows = StudentTable1.getSelectedRows().length;
        for(int i=0; i<numRows ; i++ ) {

            model.removeRow(StudentTable1.getSelectedRow());
        }
    }//GEN-LAST:event_RemoveButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         file_system.update_file(name.toString()+id.toString()+".csv", student_headers,tableDataToArray());
         DefaultTableModel model = (DefaultTableModel) StudentTable1.getModel();
         ArrayList<ArrayList<String>> data = file_system.read_from_file(name.toString()+id.toString()+".csv",student_headers);
            for(int i = 1; i < data.size();i++)
            {
               Vector<String> vector = new Vector<String>(data.get(i));
               int sum = 0;
               for (int y=2; y < student_headers.length; y++){
                   sum += Integer.parseInt(vector.get(y));
               }
               sum = sum/(student_headers.length-2);
               vector.addElement(Integer.toString(sum));
               System.out.print(i+"\n");
               System.out.print(model.getColumnCount()+"\n");
               model.setValueAt(sum, i-1, model.getColumnCount()-1 );
                 
            }
         this.revalidate();
         this.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed
                  
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
            java.util.logging.Logger.getLogger(StudentAssignmentTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentAssignmentTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentAssignmentTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentAssignmentTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentAssignmentTable(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton1;
    private javax.swing.JTextField AssignmentTextField1;
    private javax.swing.JButton BackButton1;
    private javax.swing.JTextField DateTextField1;
    private javax.swing.JButton ExitButton1;
    private javax.swing.JButton LogOutButton1;
    private javax.swing.JButton RemoveButton1;
    private javax.swing.JLabel StudentNameLabel1;
    private javax.swing.JTable StudentTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
 private void close() {
    WindowEvent WinClosing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WinClosing);
 }
}
