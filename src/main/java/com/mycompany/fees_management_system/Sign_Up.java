/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fees_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author vaish
 */
public class Sign_Up extends javax.swing.JFrame {

    /**
     * Creates new form Sign_Up
     */
     String FName,LName,UName,Password,con_Password,ContactNo;
        Date dob;
        int id = 0;
    
    public Sign_Up() {
        initComponents();
    }
    
    public int getId()
    {ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_manage","root","root");
                String sql = "select max(id) from signup";
                Statement st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    id = rs.getInt(1);
                    id++;
                }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return id;

    }
    
   
        boolean validation()
        {
            FName=txt_FName.getText();
            LName=txt_LName.getText();
            UName=txt_UName.getText();
            Password=txt_Password.getText();
            con_Password=txt_ConPassword.getText();
            dob=txt_dob.getDate();
            ContactNo=txt_ContactNo.getText();
            
            if(FName.equals(""))
            {
              JOptionPane.showMessageDialog(this,"Please Enter First Name....");
              return false;
            }
            
            if(FName.equals(""))
            {
              JOptionPane.showMessageDialog(this,"Please Enter First Name.....");
              return false;
            }if(LName.equals(""))
            {
              JOptionPane.showMessageDialog(this,"Please Enter Last Name....");
              return false;
            }
            
            if(UName.equals(""))
            {
              JOptionPane.showMessageDialog(this,"Please Enter User Name....");
              return false;
            }
            
            if(Password.equals(""))
            {
              JOptionPane.showMessageDialog(this,"Please Enter Password....");
              return false;
            }
            
             if(con_Password.equals(""))
            {
              JOptionPane.showMessageDialog(this,"Please Enter confirm Password....");
              return false;
            }
            
             if(dob.equals(null))
            {
              JOptionPane.showMessageDialog(this,"Please Enter Date of Birth....");
              return false;
            }
             
             if(ContactNo.equals(""))
            {
              JOptionPane.showMessageDialog(this,"Please Enter Contact Number....");
              return false;
            }
             if(Password.length()<8)
            {
                lbl_Password_error.setText("Password Should be of 8 digits.");
                return false;
            }

            if(!Password.equals(con_Password))
            {
            JOptionPane.showMessageDialog(this, "Password Not Matched.");
            return false;

            }
            return true;
        }
        
        public void checkPassword()
        {
            Password=txt_Password.getText();
            if(Password.length()<8)
            {
                lbl_Password_error.setText("Password should be of 8 digits");
            }
            else
            {
                lbl_Password_error.setText("");
            }
        }
        
        public void checkContactNo()
        {
            ContactNo = txt_ContactNo.getText();
            if (ContactNo.length()==10)
            {
                lbl_Contact_error.setText("");
            }
            else
            {
                lbl_Contact_error.setText("Contact No should be of 10 digits.");
            }
        }
        
        
        void insertDetails()
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String myDob = format.format(dob);
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_manage","root","root");
                String sql = "insert into signup values(?,?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1,getId() );
                stmt.setString(2, FName);
                stmt.setString(3, LName);
                stmt.setString(4, UName);
                stmt.setString(5, Password);
                stmt.setString(6, myDob);
                stmt.setString(7, ContactNo);

                int i =stmt.executeUpdate();
                 if (i > 0)
                 {
                     JOptionPane.showMessageDialog(this, "Record Inserted");
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(this, "Record Not Inserted");
                 }
            } catch (Exception e)
            {
                e.printStackTrace();
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

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_signUp = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        txt_UName = new javax.swing.JTextField();
        txt_FName = new javax.swing.JTextField();
        txt_ContactNo = new javax.swing.JTextField();
        txt_LName = new javax.swing.JTextField();
        txt_ConPassword = new javax.swing.JPasswordField();
        txt_Password = new javax.swing.JPasswordField();
        txt_dob = new com.toedter.calendar.JDateChooser();
        lbl_Contact_error = new javax.swing.JLabel();
        lbl_Password_error = new javax.swing.JLabel();
        btn_Login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(30, 81, 81));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SignUp");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\signup.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 120));

        jPanel4.setBackground(new java.awt.Color(176, 212, 208));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("First Name :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("User Name :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Last Name :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Confirm Password :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Password :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Contact No : ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("DOB :");

        btn_signUp.setBackground(new java.awt.Color(0, 102, 102));
        btn_signUp.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btn_signUp.setForeground(new java.awt.Color(255, 255, 255));
        btn_signUp.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\signup.png")); // NOI18N
        btn_signUp.setText("SignUp");
        btn_signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signUpActionPerformed(evt);
            }
        });
        btn_signUp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_signUpKeyPressed(evt);
            }
        });

        btn_refresh.setBackground(new java.awt.Color(0, 102, 102));
        btn_refresh.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btn_refresh.setForeground(new java.awt.Color(255, 255, 255));
        btn_refresh.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\update.png")); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        txt_UName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_UName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UNameActionPerformed(evt);
            }
        });

        txt_FName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_FName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FNameActionPerformed(evt);
            }
        });

        txt_ContactNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_ContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ContactNoActionPerformed(evt);
            }
        });
        txt_ContactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ContactNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ContactNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ContactNoKeyTyped(evt);
            }
        });

        txt_LName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_LName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LNameActionPerformed(evt);
            }
        });

        txt_ConPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ConPasswordActionPerformed(evt);
            }
        });

        txt_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyReleased(evt);
            }
        });

        txt_dob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dobKeyPressed(evt);
            }
        });

        lbl_Contact_error.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Contact_error.setForeground(new java.awt.Color(255, 51, 51));

        lbl_Password_error.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Password_error.setForeground(new java.awt.Color(255, 51, 51));

        btn_Login.setBackground(new java.awt.Color(0, 102, 102));
        btn_Login.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(255, 255, 255));
        btn_Login.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\login.png")); // NOI18N
        btn_Login.setText("Login");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btn_signUp)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_dob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(txt_UName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_LName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_FName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ContactNo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ConPassword)
                            .addComponent(txt_Password))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_Password_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_Contact_error, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_refresh)
                        .addGap(74, 74, 74)
                        .addComponent(btn_Login)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_FName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_LName)
                                .addGap(2, 2, 2)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_UName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ConPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_Password_error, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(lbl_Contact_error, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_signUp)
                    .addComponent(btn_refresh)
                    .addComponent(btn_Login))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 860, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
     
       txt_FName.setText("");
       txt_LName.setText("");
       txt_UName.setText("");
       txt_Password.setText("");
       txt_ConPassword.setText("");
      //txt_dob.getDate();
       txt_ContactNo.setText("");


        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signUpActionPerformed
      validation();
        if(validation())         
     {
         insertDetails();
     }
        
    }//GEN-LAST:event_btn_signUpActionPerformed

    //private void txt_loginActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
     //   login login = new login();
     //   login.show();
     //   this.dispose();
    //}
    private void txt_UNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UNameActionPerformed

    private void txt_FNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FNameActionPerformed

    private void txt_ContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContactNoActionPerformed

    private void txt_LNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LNameActionPerformed

    private void txt_ConPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ConPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ConPasswordActionPerformed

    private void txt_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyPressed
    checkPassword();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordKeyPressed

    private void txt_PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyReleased
     checkPassword();         // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordKeyReleased

    private void txt_ContactNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContactNoKeyPressed
      checkContactNo();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContactNoKeyPressed

    private void txt_ContactNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContactNoKeyReleased
     checkContactNo();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContactNoKeyReleased

    private void txt_ContactNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ContactNoKeyTyped
    checkContactNo();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContactNoKeyTyped

    private void txt_dobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dobKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dobKeyPressed

    private void btn_signUpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_signUpKeyPressed
       validation();  // TODO add your handling code here:
    }//GEN-LAST:event_btn_signUpKeyPressed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        Login_Page login=new Login_Page();
        login.show();
        this.dispose();




// TODO add your handling code here:
    }//GEN-LAST:event_btn_LoginActionPerformed

    
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
            java.util.logging.Logger.getLogger(Sign_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sign_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sign_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_Up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_signUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_Contact_error;
    private javax.swing.JLabel lbl_Password_error;
    private javax.swing.JPasswordField txt_ConPassword;
    private javax.swing.JTextField txt_ContactNo;
    private javax.swing.JTextField txt_FName;
    private javax.swing.JTextField txt_LName;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_UName;
    private com.toedter.calendar.JDateChooser txt_dob;
    // End of variables declaration//GEN-END:variables
}
