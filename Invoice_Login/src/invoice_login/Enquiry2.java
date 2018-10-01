
package invoice_login;

import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Enquiry2 extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Enquiry2() {
        initComponents();
        Show();
        tab();
        showDate();
    }
    
     private void showDate(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MMMMM-yyyy");
        date.setText(s.format(d));
     }
     
    public Connection give(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/Emp","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e+"conn");
        }
        
        return con;
    }
    
     private void Show(){
        
        try{  
           con = give();
            ps = con.prepareStatement("select name,productno,quantity,date from sales");
            rs = ps.executeQuery();
            saletab.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
     
     private void tab(){
         try{  
           con = give();
            ps = con.prepareStatement("select * from enquiryonly");
            rs = ps.executeQuery();
            entab.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
     }
     
     
     public void Check(String a, String b,String c){
         
         try{
              con = give();
             ps = con.prepareStatement("insert into enquiryonly values(?,?,?)");
            
            ps.setString(1,a);
            ps.setString(2,b);
            ps.setString(3,c);
                        
            int q = ps.executeUpdate();
            
           
          if(q==0){
          JOptionPane.showMessageDialog(this,"Record  not added");
                  }
        }
        catch(Exception e){
                 JOptionPane.showMessageDialog(this,e);
                }
         }

        public void update(int squantity, String pnum , int price,int amount, int bill, int rquantity) {
            int q,a,gain;
            q = squantity - rquantity;
            gain = price*rquantity;
            a = amount-gain;
            try{
                 con = give();
                 ps = con.prepareStatement("update sales set quantity=?,amount=? where billnumber=?  ");
                 
                 ps.setInt(1,q);
                 ps.setInt(2,a);
                 ps.setInt(3,bill);
                 
                 int m = ps.executeUpdate();
                 
                 if(m==1)
                    JOptionPane.showMessageDialog(this,"You get back"+" "+gain+" "+"INR"); 
                 
                 if((reason.getText()).equalsIgnoreCase("defective"))
                         {
                             damaged(pnum,price,rquantity);
                         }
                 
                 else{
                     stock(pnum,rquantity,bill);
                 }
            }
            
            catch(Exception e){
                 JOptionPane.showMessageDialog(this,e+"uuuuu");
            }
        }
     
        public void damaged(String pnum,int price,int rquantity){
            
            try{  
            con = give();
            ps = con.prepareStatement("insert into damaged values(?,?,?,?)");
            
            ps.setString(1,pnum);
            ps.setInt(2,price);
            ps.setInt(3,rquantity);
            ps.setString(4,date.getText());
            
            int a = ps.executeUpdate();
            
            if(a==1)
                JOptionPane.showMessageDialog(this,"Record added");
                     
          else{
          JOptionPane.showMessageDialog(this,"Record  not added");
                  }
        }
        catch(Exception e){
                 JOptionPane.showMessageDialog(this,e+"ddddd");
                }
          
        }
        
        public void stock(String pnum, int rquantity,int bill){
            int q;
            q = get(pnum);
            q = q+rquantity;
            
            try{
                 con = give();
                 ps = con.prepareStatement("update producttable set quantity=? where productno=?");
                 
                 ps.setInt(1,q);
                 ps.setString(2,pnum);
                 
                 int a = ps.executeUpdate();
                
            }
            
            catch(Exception e){
                 JOptionPane.showMessageDialog(this,e+"ssss");
            }
            
        }
        
        public int get(String pnum){
            
            int q=0;
            try{
                 con = give();
                 ps = con.prepareStatement("select * from producttable ");
                 rs = ps.executeQuery();
                 while(rs.next())
                 {
                     String num = rs.getString(2);
                     q = rs.getInt(3);
                     
                     if(num.compareTo(pnum)==0)
                         break;
                 }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this,e+"ppppp");
            }
            return q;
        }
        
        public void delete(String num,int price,int rquantity,int bill){
           
           int gain = price*rquantity;
          
            try{
                 con = give();
                 ps = con.prepareStatement("delete  from sales where billnumber=?");
                 ps.setInt(1, bill);
                 
                 int a =ps.executeUpdate();
                 
                 if(a==1)
                    JOptionPane.showMessageDialog(this,"You get back "+gain+" INR"); 
                 else
                     JOptionPane.showMessageDialog(this,"Not deleted");
                 
                  if((reason.getText()).equalsIgnoreCase("defective"))
                         {
                             damaged(num,price,rquantity);
                         }
                 
                 else{
                     stock(num,rquantity,bill);
                 }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this,e);
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
        jLabel1 = new javax.swing.JLabel();
        purpose = new javax.swing.JComboBox<>();
        eq = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tx1 = new javax.swing.JTextArea();
        msubmit = new javax.swing.JButton();
        getnum = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        billnum = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        backpanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pquantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        reason = new javax.swing.JTextField();
        give = new javax.swing.JButton();
        bracket = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        entab = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        saletab = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CUSTOMER SERVICE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Purpose");

        purpose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        purpose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENQUIRE PRODUCT", "RETURN PRODUCT" }));
        purpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purposeActionPerformed(evt);
            }
        });

        eq.setBackground(new java.awt.Color(0, 153, 153));
        eq.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENQUIRY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        eq.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Contact");

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        name.setEnabled(false);

        contact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        contact.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contact.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Enter description of enquiry :");

        tx1.setColumns(20);
        tx1.setRows(5);
        tx1.setEnabled(false);
        jScrollPane2.setViewportView(tx1);

        msubmit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        msubmit.setText("SUBMIT");
        msubmit.setEnabled(false);
        msubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eqLayout = new javax.swing.GroupLayout(eq);
        eq.setLayout(eqLayout);
        eqLayout.setHorizontalGroup(
            eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eqLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(msubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eqLayout.createSequentialGroup()
                .addGroup(eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eqLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44))
                    .addGroup(eqLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name)
                            .addComponent(contact, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24))
        );
        eqLayout.setVerticalGroup(
            eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eqLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eqLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(eqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(eqLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(msubmit)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getnum.setBackground(new java.awt.Color(0, 153, 153));
        getnum.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BILL NUMBER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        getnum.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Bill Number");

        billnum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        billnum.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        billnum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        billnum.setEnabled(false);

        confirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        confirm.setText("CONFIRM");
        confirm.setEnabled(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout getnumLayout = new javax.swing.GroupLayout(getnum);
        getnum.setLayout(getnumLayout);
        getnumLayout.setHorizontalGroup(
            getnumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getnumLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(billnum, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(confirm)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        getnumLayout.setVerticalGroup(
            getnumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getnumLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(getnumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(billnum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        backpanel.setBackground(new java.awt.Color(0, 153, 153));
        backpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRODUCT DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        backpanel.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Product Number");

        pno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pno.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Quantity");

        pquantity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pquantity.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pquantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pquantity.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Reason");

        reason.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        reason.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        reason.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reason.setEnabled(false);

        give.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        give.setText("RETURN");
        give.setEnabled(false);
        give.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giveActionPerformed(evt);
            }
        });

        bracket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bracket.setText("(if defective, write defective)");
        bracket.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("DATE");

        date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        date.setEnabled(false);

        javax.swing.GroupLayout backpanelLayout = new javax.swing.GroupLayout(backpanel);
        backpanel.setLayout(backpanelLayout);
        backpanelLayout.setHorizontalGroup(
            backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backpanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(pno)
                    .addComponent(pquantity)
                    .addComponent(reason))
                .addGroup(backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backpanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(give))
                    .addGroup(backpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bracket)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        backpanelLayout.setVerticalGroup(
            backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backpanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(give)
                        .addComponent(pquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backpanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(36, 36, 36)
                        .addGroup(backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backpanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addGroup(backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reason, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(bracket, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(eq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(purpose, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(getnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(purpose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(eq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VIEW SERVICE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(0, 153, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENQUIRED ONLY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        entab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(entab);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 153, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        saletab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(saletab);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        
         int f =0;
        int p = Integer.parseInt(billnum.getText());
      try{  
            con = give();
            ps = con.prepareStatement("select * from sales");
            rs = ps.executeQuery();
            
            while(rs.next()){
                int num = rs.getInt(9);
                if(num == p){
                    f=1;
                    break;
                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
      if(f==1){
       backpanel.setEnabled(true);
       pno.setEnabled(true);
       give.setEnabled(true);
       pquantity.setEnabled(true);
       reason.setEnabled(true);
       getnum.setEnabled(true);
       billnum.setEnabled(true);
       confirm.setEnabled(true);
       date.setEnabled(true);
       bracket.setEnabled(true);
       tx1.setEnabled(false);
       tx1.setEnabled(false);
         eq.setEnabled(false);
             name.setEnabled(false);
             contact.setEnabled(false);
             msubmit.setEnabled(false);
                  
      }
      
      else{
          JOptionPane.showMessageDialog(this," Sorry! no such bill number exists.");
      }
      
    }//GEN-LAST:event_confirmActionPerformed

    private void purposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purposeActionPerformed
       
        String p =(String) purpose.getSelectedItem();
         if(p.compareTo("ENQUIRE PRODUCT")== 0){
             backpanel.setEnabled(false);
             pno.setEnabled(false);
             give.setEnabled(false);
             pquantity.setEnabled(false);
             reason.setEnabled(false);
             date.setEnabled(false);
             getnum.setEnabled(false);
             billnum.setEnabled(false);
             confirm.setEnabled(false);
             tx1.setEnabled(true);
             tx1.setEnabled(true);
             eq.setEnabled(true);
             name.setEnabled(true);
             contact.setEnabled(true);
             msubmit.setEnabled(true);
             bracket.setEnabled(false);     
               }
         
         if(p.compareTo("RETURN PRODUCT")==0){
             tx1.setEnabled(false);
             getnum.setEnabled(true);
             billnum.setEnabled(true);
             confirm.setEnabled(true);
              name.setEnabled(false);
             contact.setEnabled(false);
             msubmit.setEnabled(false);
             bracket.setEnabled(false);
             backpanel.setEnabled(false);
             pno.setEnabled(false);
             give.setEnabled(false);
             pquantity.setEnabled(false);
             reason.setEnabled(false);
             date.setEnabled(false);
         }
          
        
    }//GEN-LAST:event_purposeActionPerformed

    private void msubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msubmitActionPerformed
        
        if(evt.getSource()== msubmit){
        
          String n = name.getText();
          String cont = contact.getText();
          String p = (String) purpose.getSelectedItem();
          String text = tx1.getText();
          int f = 0;
          
          String empty="";
          if(n.compareTo(empty)==0 || cont.compareTo(empty)==0 || p.compareTo(empty)==0 || text.compareTo(empty)==0)
          {
              JOptionPane.showMessageDialog(this," Complete all the details first!");
                      f=1;
          }
         
          
         if(f==0){
            
              Check(name.getText(),contact.getText(),tx1.getText());
              tab();
                }
         }
    }//GEN-LAST:event_msubmitActionPerformed

    private void giveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giveActionPerformed
       
        String a = pno.getText();
        int b = Integer.parseInt(pquantity.getText());
        String m = pquantity.getText();
        String c = reason.getText();
        int bill=0,q=0,p=0,amount=0,g=0,h=0,f=0;
        String num = null;
        int actual = Integer.parseInt(billnum.getText());
        String empty="";
        try{
            
            con = give();
            ps = con.prepareStatement("select * from sales");
            rs = ps.executeQuery();
            while(rs.next()){
                 bill = rs.getInt(9);
                 num = rs.getString(5);
                 q = rs.getInt(4);
                 p = rs.getInt(6);
                 amount = rs.getInt(7);
                 
                 if(actual==bill){
                     break;
                 }
            }
            
            if(a.compareTo(num)==0){
                f=1;
                   if( b>0 && q>=b){
                       g=1;
                   }
                   else if(b==0){
                       JOptionPane.showMessageDialog(this,"Enter valid quantity");
                   }
                    else {
                       JOptionPane.showMessageDialog(this,"Quantity value you entered exceeds the actual value in bill ");
                   }
            }
            
            if(f==0)
            {
                JOptionPane.showMessageDialog(this,"Invalid Product Number");
            }
            
            if(g ==1 ){
                 if(c.compareTo(empty)==0)
                {
                    JOptionPane.showMessageDialog(this,"Please enter valid reason");
                }
                
                 else{
                     if(b<q){
                    update(q,num,p,amount,bill,b);  
                    Show();
                    }
                else{
                    delete(num,p,b,bill);
                    Show();
                }
            }
            }
            
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_giveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backpanel;
    private javax.swing.JTextField billnum;
    private javax.swing.JLabel bracket;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField date;
    private javax.swing.JTable entab;
    private javax.swing.JPanel eq;
    private javax.swing.JPanel getnum;
    private javax.swing.JButton give;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton msubmit;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pno;
    private javax.swing.JTextField pquantity;
    private javax.swing.JComboBox<String> purpose;
    private javax.swing.JTextField reason;
    private javax.swing.JTable saletab;
    private javax.swing.JTextArea tx1;
    // End of variables declaration//GEN-END:variables
}
