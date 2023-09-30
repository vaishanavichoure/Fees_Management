/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fees_management_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author vaish
 */
public class Add_fee extends javax.swing.JFrame {

    /**
     * Creates new form Add_fee
     */
    public Add_fee() {
        initComponents();
        
         displyCashFirst(); 
        fillComboBox();
       
       int receiptNo=getReceiptNo();
       receiptNo++;
       txt_ReceiptNo.setText(Integer.toString(receiptNo));
    }
    
    public void displyCashFirst()
   {
       lbl_DD.setVisible(false);
       lbl_Cheque.setVisible(false);
       lbl_BankName.setVisible(false);
       
       txt_DDno.setVisible(false);
       txt_Chequeno.setVisible(false);
       txt_BankName.setVisible(false);
       
   }
    
     public boolean validation()
   {
       if(txt_ReceviedFrom.getText().equals(""))
       {
           JOptionPane.showMessageDialog(this,"Please Enter User Name");
           return false;
       }
       
        if(DateChooser.getDate() ==null)
       {
           JOptionPane.showMessageDialog(this,"Please Select a Date");
           return false;
       }
        
        if(txt_amount.getText().equals("")|| txt_amount.getText().matches("[0-9]+")==false)
       {
           JOptionPane.showMessageDialog(this,"Please Enter Amount(in Number)");
           return false;
       }
        
        if(ComboBox_ModeOfPayment1.getSelectedItem().toString().equalsIgnoreCase("Cheque"))
        {
           JOptionPane.showMessageDialog(this,"Please Enter Cheque Number");
           return false;
        }
        
        if(txt_BankName.getText().equals(""))
        {
           JOptionPane.showMessageDialog(this,"Please Enter Bank Name");
           return false;
        }
        
        if(ComboBox_ModeOfPayment1.getSelectedItem().toString().equalsIgnoreCase("DD"))
       {
            if(txt_DDno.getText().equals(""))
            {
              JOptionPane.showMessageDialog(this,"Please Enter DD Number");
             return false;
            }
            if(txt_BankName.getText().equals(""))
        {
           JOptionPane.showMessageDialog(this,"Please Enter Bank Name");
           return false;
        }
            
            
       }
        
         if(ComboBox_ModeOfPayment1.getSelectedItem().toString().equalsIgnoreCase("card"))
       {
           if(txt_BankName.getText().equals(""))
        {
           JOptionPane.showMessageDialog(this,"Please Enter Bank Name");
           return false;
        }
           
       }
        

       return true;
   }
     
    public void fillComboBox()
   {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_manage","root","root");
                PreparedStatement st = con.prepareStatement("select CourseName frome coursetb");
                
                ResultSet rs=st.executeQuery();
               
                while (rs.next())
                {
                  ComboBox_ModeOfPayment1.addItem(rs.getString("CourseName"));
                }
       }
       
       catch(Exception e)
       {
          e.printStackTrace();
       }
       
       
      
   }
    public int getReceiptNo()
   {
       int receiptNo=0;
        try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_manage","root","root");
             
                PreparedStatement st = con.prepareStatement("select max(receipt_no frome fees_details");
                
                ResultSet rs=st.executeQuery();
                
                if(rs.next()==true)
                {
                    receiptNo = rs.getInt("1");
                }
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        return receiptNo;
   }
    
    public String insertData()
    {
        int reciept_no=Integer.parseInt(txt_ReceiptNo.getText());
        String student_name=txt_ReceviedFrom.getText();
        String Payment_mode=ComboBox_ModeOfPayment1.getSelectedItem().toString();
        String cheque_no=txt_Chequeno.getText();
        String bank_name=txt_BankName.getText();
        String ddno=txt_DDno.getText();
        String courses=ComboBox_ourse.getSelectedItem().toString();
        String gstin=txt_cgst.getText();
        float total_amount=Float.parseFloat(txt_total.getText());
        SimpleDateFormat sd1=new SimpleDateFormat("yyy-dd-mm");
        String date=sd1.format(DateChooser);
        float amount=Float.parseFloat(txt_amount.getText());
        float cgst=Float.parseFloat(txt_cgst.getText());
        float sgst=Float.parseFloat(txt_sgst.getText());
        String total_in_words=txt_totalInWords.getText();
        String remark=txt_remarks.getText();
        int year1=Integer.parseInt(txt_Year1.getText());
        int year2=Integer.parseInt(txt_Year2.getText());
        
        
        String status;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_manage","root","root");
             
                PreparedStatement st = con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                st.setInt(1, reciept_no);
              st.setString(2,student_name);
              st.setString(3,Payment_mode);
              st.setString(4,cheque_no);
              st.setString(5,bank_name);
              st.setString(6,ddno);
              st.setString(7,courses);
              st.setString(8,gstin);
              st.setFloat(9,total_amount);
              st.setString(10,date);
              st.setFloat(12,amount);
              st.setFloat(13,cgst);
              st.setFloat(14,sgst);
              st.setString(15,total_in_words);
              st.setString(16,remark);
              st.setInt(17,year1);
              st.setInt(18,year2);
              
                
          int c=st.executeUpdate();
          
          
          if(c==1)
          {
              status="Success";
          }
          else
          {
              status="failed";
          }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } 
        return status="";
    }
    
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Side_Panle = new javax.swing.JPanel();
        panel_home = new javax.swing.JPanel();
        lbl_home = new javax.swing.JLabel();
        Panel_SearchRecord = new javax.swing.JPanel();
        lbl_SrarchR = new javax.swing.JLabel();
        panel_EditCourse = new javax.swing.JPanel();
        lbl_EditC = new javax.swing.JLabel();
        panel_CourseList = new javax.swing.JPanel();
        lbl_CourseList = new javax.swing.JLabel();
        panel_ViewallReco = new javax.swing.JPanel();
        lbl_ViewAllRe = new javax.swing.JLabel();
        panel_Back = new javax.swing.JPanel();
        lbl_Back = new javax.swing.JLabel();
        panel_Logout = new javax.swing.JPanel();
        lbl_Logout = new javax.swing.JLabel();
        Panel_Parent = new javax.swing.JPanel();
        lbl_GSTINno = new javax.swing.JLabel();
        lbl_receiptno = new javax.swing.JLabel();
        lbl_MOP = new javax.swing.JLabel();
        lbl_DD = new javax.swing.JLabel();
        lbl_Cheque = new javax.swing.JLabel();
        lbl_BankName = new javax.swing.JLabel();
        lbl_receviedFrom = new javax.swing.JLabel();
        lbl_year = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_Receiptno9 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        lbl_GSTIN = new javax.swing.JLabel();
        txt_ReceiptNo = new javax.swing.JTextField();
        txt_Chequeno = new javax.swing.JTextField();
        txt_DDno = new javax.swing.JTextField();
        txt_Year2 = new javax.swing.JTextField();
        txt_BankName = new javax.swing.JTextField();
        txt_Year1 = new javax.swing.JTextField();
        txt_ReceviedFrom = new javax.swing.JTextField();
        ComboBox_ourse = new javax.swing.JComboBox<>();
        DateChooser = new com.toedter.calendar.JDateChooser();
        ComboBox_ModeOfPayment1 = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lbl_Head = new javax.swing.JLabel();
        lbl_srno = new javax.swing.JLabel();
        lbl_amount = new javax.swing.JLabel();
        txt_head = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        lbl_cgst = new javax.swing.JLabel();
        lbl_sgst = new javax.swing.JLabel();
        txt_sgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_total = new javax.swing.JTextField();
        lbl_total = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_Receiversign = new javax.swing.JTextField();
        lbl_RecevierSign = new javax.swing.JLabel();
        lbl_totalInWords = new javax.swing.JLabel();
        txt_totalInWords = new javax.swing.JTextField();
        lbl_remark = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remarks = new javax.swing.JTextArea();
        btn_Print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Side_Panle.setBackground(new java.awt.Color(30, 81, 81));
        Side_Panle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_home.setBackground(new java.awt.Color(30, 81, 81));
        panel_home.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), null, null));
        panel_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_homeMouseExited(evt);
            }
        });
        panel_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_home.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_home.setForeground(new java.awt.Color(255, 255, 255));
        lbl_home.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\home.png")); // NOI18N
        lbl_home.setText("   Home");
        panel_home.add(lbl_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 210, 70));

        Side_Panle.add(panel_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 340, 70));

        Panel_SearchRecord.setBackground(new java.awt.Color(30, 81, 81));
        Panel_SearchRecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), null, null));
        Panel_SearchRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_SearchRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_SearchRecordMouseExited(evt);
            }
        });
        Panel_SearchRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_SrarchR.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_SrarchR.setForeground(new java.awt.Color(255, 255, 255));
        lbl_SrarchR.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\search2.png")); // NOI18N
        lbl_SrarchR.setText("   Search Record");
        Panel_SearchRecord.add(lbl_SrarchR, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 220, 70));

        Side_Panle.add(Panel_SearchRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 340, 70));

        panel_EditCourse.setBackground(new java.awt.Color(30, 81, 81));
        panel_EditCourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), null, null));
        panel_EditCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_EditCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_EditCourseMouseExited(evt);
            }
        });
        panel_EditCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_EditC.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_EditC.setForeground(new java.awt.Color(255, 255, 255));
        lbl_EditC.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\edit2.png")); // NOI18N
        lbl_EditC.setText("  Edit Course");
        panel_EditCourse.add(lbl_EditC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 220, 70));

        Side_Panle.add(panel_EditCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 340, 70));

        panel_CourseList.setBackground(new java.awt.Color(30, 81, 81));
        panel_CourseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), null, null));
        panel_CourseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_CourseListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_CourseListMouseExited(evt);
            }
        });
        panel_CourseList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_CourseList.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_CourseList.setForeground(new java.awt.Color(255, 255, 255));
        lbl_CourseList.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\list_1.png")); // NOI18N
        lbl_CourseList.setText("  Course List");
        panel_CourseList.add(lbl_CourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 70));

        Side_Panle.add(panel_CourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 340, 70));

        panel_ViewallReco.setBackground(new java.awt.Color(30, 81, 81));
        panel_ViewallReco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), null, null));
        panel_ViewallReco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_ViewallRecoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_ViewallRecoMouseExited(evt);
            }
        });
        panel_ViewallReco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ViewAllRe.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_ViewAllRe.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ViewAllRe.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\view all record.png")); // NOI18N
        lbl_ViewAllRe.setText("   View All Record");
        panel_ViewallReco.add(lbl_ViewAllRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 70));

        Side_Panle.add(panel_ViewallReco, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 340, 70));

        panel_Back.setBackground(new java.awt.Color(30, 81, 81));
        panel_Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), null, null));
        panel_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_BackMouseExited(evt);
            }
        });
        panel_Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Back.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_Back.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Back.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\back-button.png")); // NOI18N
        lbl_Back.setText("     Back");
        panel_Back.add(lbl_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 270, 70));

        Side_Panle.add(panel_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 340, 70));

        panel_Logout.setBackground(new java.awt.Color(30, 81, 81));
        panel_Logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), null, null));
        panel_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_LogoutMouseExited(evt);
            }
        });
        panel_Logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Logout.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_Logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Logout.setIcon(new javax.swing.ImageIcon("C:\\Users\\vaish\\OneDrive\\Documents\\NetBeansProjects\\Fees_Management_System\\src\\main\\java\\Fees_Management_Images\\logout.png")); // NOI18N
        lbl_Logout.setText("    Logout");
        panel_Logout.add(lbl_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 260, 70));

        Side_Panle.add(panel_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 750, 340, 70));

        getContentPane().add(Side_Panle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 1000));

        Panel_Parent.setBackground(new java.awt.Color(176, 212, 208));
        Panel_Parent.setMaximumSize(new java.awt.Dimension(2147483647, 2));
        Panel_Parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_GSTINno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_GSTINno.setText("22MVLT890");
        Panel_Parent.add(lbl_GSTINno, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 110, 110, 40));

        lbl_receiptno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_receiptno.setText("Receipt No :");
        Panel_Parent.add(lbl_receiptno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 110, 40));

        lbl_MOP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_MOP.setText("Mode Of Payment :");
        Panel_Parent.add(lbl_MOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 170, 40));

        lbl_DD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_DD.setText("DD No :");
        Panel_Parent.add(lbl_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 100, 40));

        lbl_Cheque.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Cheque.setText("Cheque No :");
        Panel_Parent.add(lbl_Cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 110, 40));

        lbl_BankName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_BankName.setText("Bank Name :");
        Panel_Parent.add(lbl_BankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 110, 40));

        lbl_receviedFrom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_receviedFrom.setText("Recevied From :");
        Panel_Parent.add(lbl_receviedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 140, 40));

        lbl_year.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_year.setText(" the following payment in the college office for the year :");
        Panel_Parent.add(lbl_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 500, 40));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_course.setText("Course :");
        Panel_Parent.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 90, 40));

        lbl_Receiptno9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Receiptno9.setText("to");
        Panel_Parent.add(lbl_Receiptno9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 40, 40));

        lbl_date.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_date.setText("Date :");
        Panel_Parent.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 80, 40));

        lbl_GSTIN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_GSTIN.setText("GSTIN :");
        Panel_Parent.add(lbl_GSTIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 80, 40));

        txt_ReceiptNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Panel_Parent.add(txt_ReceiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 190, 40));

        txt_Chequeno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Chequeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ChequenoActionPerformed(evt);
            }
        });
        Panel_Parent.add(txt_Chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 190, 40));

        txt_DDno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DDnoActionPerformed(evt);
            }
        });
        Panel_Parent.add(txt_DDno, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 190, 40));

        txt_Year2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Panel_Parent.add(txt_Year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 180, 40));

        txt_BankName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_BankName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BankNameActionPerformed(evt);
            }
        });
        Panel_Parent.add(txt_BankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 190, 40));

        txt_Year1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Year1ActionPerformed(evt);
            }
        });
        Panel_Parent.add(txt_Year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 190, 40));

        txt_ReceviedFrom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Panel_Parent.add(txt_ReceviedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 190, 40));

        Panel_Parent.add(ComboBox_ourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 190, 40));
        Panel_Parent.add(DateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, 170, -1));

        ComboBox_ModeOfPayment1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "CASH", "Cheque", "Card", "PhonePe", "UPI", "GooglePay", " " }));
        ComboBox_ModeOfPayment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_ModeOfPayment1ActionPerformed(evt);
            }
        });
        Panel_Parent.add(ComboBox_ModeOfPayment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 190, 40));
        Panel_Parent.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1310, -1));
        Panel_Parent.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 1300, -1));

        lbl_Head.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Head.setText("Head");
        Panel_Parent.add(lbl_Head, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 70, 40));

        lbl_srno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_srno.setText("Sr N0 :");
        Panel_Parent.add(lbl_srno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 70, 40));

        lbl_amount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_amount.setText("Amount");
        Panel_Parent.add(lbl_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 470, 90, 40));

        txt_head.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Panel_Parent.add(txt_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 460, 40));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        Panel_Parent.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 530, 170, 40));

        txt_cgst.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Panel_Parent.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 590, 170, 40));

        lbl_cgst.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_cgst.setText("CGST (9%)");
        Panel_Parent.add(lbl_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 590, 110, 40));

        lbl_sgst.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_sgst.setText("SGST (18%)");
        Panel_Parent.add(lbl_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 650, 110, 40));

        txt_sgst.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Panel_Parent.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 650, 170, 40));
        Panel_Parent.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 700, 500, -1));

        txt_total.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Panel_Parent.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 710, 170, 40));

        lbl_total.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_total.setText("Total");
        Panel_Parent.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 720, 80, 40));
        Panel_Parent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 760, 500, -1));

        txt_Receiversign.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Panel_Parent.add(txt_Receiversign, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 800, 170, 40));

        lbl_RecevierSign.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_RecevierSign.setText("Receiver signature :");
        Panel_Parent.add(lbl_RecevierSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 800, 180, 40));

        lbl_totalInWords.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_totalInWords.setText("Total in Words :");
        Panel_Parent.add(lbl_totalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 660, 150, 40));

        txt_totalInWords.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Panel_Parent.add(txt_totalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, 450, 30));

        lbl_remark.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_remark.setText("Remark :");
        Panel_Parent.add(lbl_remark, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 760, 110, 40));

        txt_remarks.setColumns(20);
        txt_remarks.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_remarks.setRows(5);
        jScrollPane1.setViewportView(txt_remarks);

        Panel_Parent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 760, 350, 80));

        btn_Print.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Print.setText("Print");
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });
        Panel_Parent.add(btn_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 900, -1, -1));

        getContentPane().add(Panel_Parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 1400, 1000));
        Panel_Parent.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_DDnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DDnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DDnoActionPerformed

    private void txt_ChequenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ChequenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ChequenoActionPerformed

    private void txt_BankNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BankNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BankNameActionPerformed

    private void txt_Year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Year1ActionPerformed

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed
        // TODO add your handling code here:
        
        
        if(validation()==true)
               {
                   String s=insertData();
                   if(s.equals("success"))
                   {
                       JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(this,"Record Not InsertedSuccessfully");
                   }
                   
               }                

    }//GEN-LAST:event_btn_PrintActionPerformed

    private void panel_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_homeMouseEntered

        Color clr=new Color(176,212,208);
        panel_home.setBackground(clr);



        // TODO add your handling code here:
    }//GEN-LAST:event_panel_homeMouseEntered

    private void panel_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_homeMouseExited
   Color clr=new Color(30,81,81);
        panel_home.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_panel_homeMouseExited

    private void Panel_SearchRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_SearchRecordMouseExited

        Color clr=new Color(30,81,81);
        Panel_SearchRecord.setBackground(clr); 

        
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_SearchRecordMouseExited

    private void Panel_SearchRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_SearchRecordMouseEntered
  Color clr=new Color(176,212,208);
        Panel_SearchRecord.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_SearchRecordMouseEntered

    private void panel_EditCourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_EditCourseMouseEntered
       Color clr=new Color(176,212,208);
        panel_EditCourse.setBackground(clr); // TODO add your handling code here:
    }//GEN-LAST:event_panel_EditCourseMouseEntered

    private void panel_EditCourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_EditCourseMouseExited
          Color clr=new Color(30,81,81);
        panel_EditCourse.setBackground(clr);// TODO add your handling code here:
    }//GEN-LAST:event_panel_EditCourseMouseExited

    private void panel_CourseListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_CourseListMouseExited
Color clr=new Color(30,81,81);
        panel_CourseList.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_panel_CourseListMouseExited

    private void panel_ViewallRecoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_ViewallRecoMouseEntered
     Color clr=new Color(176,212,208);
       panel_ViewallReco.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_panel_ViewallRecoMouseEntered

    private void panel_BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_BackMouseExited
   Color clr=new Color(30,81,81);
       panel_Back.setBackground(clr);
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_BackMouseExited

    private void panel_LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_LogoutMouseExited
Color clr=new Color(30,81,81);
      panel_Logout.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_panel_LogoutMouseExited

    private void panel_LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_LogoutMouseEntered
Color clr=new Color(176,212,208);
       panel_Logout.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_panel_LogoutMouseEntered

    private void panel_BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_BackMouseEntered
Color clr=new Color(176,212,208);
       panel_Back.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_panel_BackMouseEntered

    private void panel_ViewallRecoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_ViewallRecoMouseExited
    Color clr=new Color(30,81,81);
       panel_ViewallReco.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_panel_ViewallRecoMouseExited

    private void panel_CourseListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_CourseListMouseEntered
Color clr=new Color(176,212,208);
       panel_CourseList.setBackground(clr);        // TODO add your handling code here:
    }//GEN-LAST:event_panel_CourseListMouseEntered

    private void ComboBox_ModeOfPayment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_ModeOfPayment1ActionPerformed
     // TODO add your handling code here:
     
     
        if(ComboBox_ModeOfPayment1.getSelectedIndex()==0)
        {
            lbl_DD.setVisible(true);
            txt_DDno.setVisible(true);
            lbl_Cheque.setVisible(false);
            txt_Chequeno.setVisible(false);
            lbl_BankName.setVisible(true);
            txt_BankName.setVisible(true);

        }
        
        if(ComboBox_ModeOfPayment1.getSelectedIndex()==1)
        {
            lbl_DD.setVisible(false);
            txt_DDno.setVisible(false);
            lbl_Cheque.setVisible(true);
            txt_Chequeno.setVisible(true);
            lbl_BankName.setVisible(true);
            txt_BankName.setVisible(true);

        }
        
        if(ComboBox_ModeOfPayment1.getSelectedIndex()==2)
        {
            lbl_DD.setVisible(false);
            txt_DDno.setVisible(false);
            lbl_Cheque.setVisible(false);
            txt_Chequeno.setVisible(false);
            lbl_BankName.setVisible(false);
            txt_BankName.setVisible(false);

        }
        
        if(ComboBox_ModeOfPayment1.getSelectedItem().equals("Card"))
        {
            lbl_DD.setVisible(false);
            txt_DDno.setVisible(false);
            lbl_Cheque.setVisible(false);
            txt_Chequeno.setVisible(false);
            lbl_BankName.setVisible(true);
            txt_BankName.setVisible(true);

        }
    }//GEN-LAST:event_ComboBox_ModeOfPayment1ActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
       
       Float Amount = Float.parseFloat(txt_amount.getText());

        Float CGST =(float)(Amount * 0.07);
        Float SGST = (float)(Amount * 0.07);

        txt_cgst.setText(CGST.toString());
        txt_sgst.setText(SGST.toString());

        float Total= Amount + CGST+ SGST;

        txt_total.setText(Float.toString(Total));

        txt_totalInWords.setText(NumberToWordsConverter.convert((int)Total) + "only");
    }//GEN-LAST:event_txt_amountActionPerformed

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
            java.util.logging.Logger.getLogger(Add_fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_fee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_fee().setVisible(true);
            }
        });
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_ModeOfPayment1;
    private javax.swing.JComboBox<String> ComboBox_ourse;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JPanel Panel_Parent;
    private javax.swing.JPanel Panel_SearchRecord;
    private javax.swing.JPanel Side_Panle;
    private javax.swing.JButton btn_Print;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_Back;
    private javax.swing.JLabel lbl_BankName;
    private javax.swing.JLabel lbl_Cheque;
    private javax.swing.JLabel lbl_CourseList;
    private javax.swing.JLabel lbl_DD;
    private javax.swing.JLabel lbl_EditC;
    private javax.swing.JLabel lbl_GSTIN;
    private javax.swing.JLabel lbl_GSTINno;
    private javax.swing.JLabel lbl_Head;
    private javax.swing.JLabel lbl_Logout;
    private javax.swing.JLabel lbl_MOP;
    private javax.swing.JLabel lbl_Receiptno9;
    private javax.swing.JLabel lbl_RecevierSign;
    private javax.swing.JLabel lbl_SrarchR;
    private javax.swing.JLabel lbl_ViewAllRe;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_cgst;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_home;
    private javax.swing.JLabel lbl_receiptno;
    private javax.swing.JLabel lbl_receviedFrom;
    private javax.swing.JLabel lbl_remark;
    private javax.swing.JLabel lbl_sgst;
    private javax.swing.JLabel lbl_srno;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_totalInWords;
    private javax.swing.JLabel lbl_year;
    private javax.swing.JPanel panel_Back;
    private javax.swing.JPanel panel_CourseList;
    private javax.swing.JPanel panel_EditCourse;
    private javax.swing.JPanel panel_Logout;
    private javax.swing.JPanel panel_ViewallReco;
    private javax.swing.JPanel panel_home;
    private javax.swing.JTextField txt_BankName;
    private javax.swing.JTextField txt_Chequeno;
    private javax.swing.JTextField txt_DDno;
    private javax.swing.JTextField txt_ReceiptNo;
    private javax.swing.JTextField txt_Receiversign;
    private javax.swing.JTextField txt_ReceviedFrom;
    private javax.swing.JTextField txt_Year1;
    private javax.swing.JTextField txt_Year2;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_head;
    private javax.swing.JTextArea txt_remarks;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalInWords;
    // End of variables declaration//GEN-END:variables
}
