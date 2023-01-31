/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author KAMIL RAZA
 */
public class tableQues extends javax.swing.JFrame {

    /**
     * Creates new form tableQues
     */
    public tableQues() {
        initComponents();
        
        try{
            Connection con;
            Statement st;
            ResultSet rs;
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Paper","root","");
            st=con.createStatement();
            rs=st.executeQuery("SELECT * from ques");
            while(rs.next()){
                
                int id = rs.getInt(1);
             String username = rs.getString(2);
             String mail = rs.getString(3);
             String pass = rs.getString(4);    
             Object data1[] = {id, username, mail, pass};
                
                
            DefaultTableModel table1model = (DefaultTableModel)table1.getModel();
            
            table1model.addRow(data1);
                
            }
            
            rs=st.executeQuery("SELECT * from table2");
            while(rs.next()){
                
             int id = rs.getInt(1);
             String username = rs.getString(2);
             String mail = rs.getString(3);
             String pass = rs.getString(4);    
             Object data2[] = {id, username, mail, pass};
                
                
            DefaultTableModel table2model = (DefaultTableModel)table2.getModel();
            
            table2model.addRow(data2);
                
            }
            
        }catch(ClassNotFoundException | SQLException e){
        
            System.out.println(e);
        
        }
        
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        forward = new javax.swing.JButton();
        backword = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "username", "email", "password"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        forward.setText(">>");
        forward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardActionPerformed(evt);
            }
        });

        backword.setText("<<");
        backword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backwordActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "username", "email", "password"
            }
        ));
        jScrollPane3.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forward)
                    .addComponent(backword))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(forward)
                            .addGap(105, 105, 105)
                            .addComponent(backword))))
                .addContainerGap(127, Short.MAX_VALUE))
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

    @SuppressWarnings("empty-statement")
    private void forwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardActionPerformed
        
        try{
            
            Connection con;
            Statement st;
            ResultSet rs;
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Paper","root", "");
            st=con.createStatement();
            
            DefaultTableModel tb1 = (DefaultTableModel) table1.getModel();
            int trans = table1.getSelectedRow();
            st.executeUpdate("DELETE from ques WHERE id='"+table1.getValueAt(trans,0)+"'");
            st.executeUpdate("INSERT into table2 (id, username, email, password) values('"+table1.getValueAt(trans,0)+"','"+table1.getValueAt(trans,1)+"','"+table1.getValueAt(trans,2)+"','"+table1.getValueAt(trans,3)+"')");
            
            DefaultTableModel tb2 = (DefaultTableModel) table2.getModel();
            Object[] array = {table1.getValueAt(trans,0),table1.getValueAt(trans,1),table1.getValueAt(trans,2),table1.getValueAt(trans,3)};
            tb2.addRow(array);
            tb1.removeRow(trans);
            
//           
            
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println(e);
        }
        
    }//GEN-LAST:event_forwardActionPerformed

    private void backwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backwordActionPerformed
        try{
            
            Connection con;
            Statement st;
            ResultSet rs;
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Paper","root", "");
            st=con.createStatement();
            
            DefaultTableModel tb2 = (DefaultTableModel) table2.getModel();
            int trans = table2.getSelectedRow();
            st.executeUpdate("DELETE from ques WHERE id='"+table2.getValueAt(trans,0)+"'");
            st.executeUpdate("INSERT into table2 (id, username, email, password) values('"+table2.getValueAt(trans,0)+"','"+table2.getValueAt(trans,1)+"','"+table2.getValueAt(trans,2)+"','"+table2.getValueAt(trans,3)+"')");
            
            DefaultTableModel tb1 = (DefaultTableModel) table1.getModel();
            Object[] array = {table2.getValueAt(trans,0),table2.getValueAt(trans,1),table2.getValueAt(trans,2),table2.getValueAt(trans,3)};
            tb1.addRow(array);
            tb2.removeRow(trans);
            
//           
            
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println(e);
        }
    }//GEN-LAST:event_backwordActionPerformed

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
            java.util.logging.Logger.getLogger(tableQues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tableQues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tableQues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tableQues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tableQues().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backword;
    private javax.swing.JButton forward;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
