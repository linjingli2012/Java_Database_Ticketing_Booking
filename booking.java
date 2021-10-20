/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mufty
 */
public class booking extends javax.swing.JFrame {

    /**
     * Creates new form booking
     */
    public booking() {
        initComponents();
        Connect();
        Customer();
        Customer1();
        Sum1();
        Sum2();
    }
    
    
     Connection con;
        PreparedStatement pst;
                PreparedStatement pst1;
                PreparedStatement pst2;

        ResultSet rs;
        
        public void Connect()
        {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonarbangla?zeroDateTimeBehavior=convertToNull","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(seat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(seat.class.getName()).log(Level.SEVERE, null, ex);
        }
        }


    public void Load()
    {
         try {
            // TODO add your handling code here:
            
            SimpleDateFormat Df= new SimpleDateFormat("yyyy-MM-dd");
            String date= Df.format(txtdchooser2.getDate());
            
            
            pst= con.prepareStatement("SELECT seat.type,seat.seats,seat.status,seat.date,busbook.customer,busbook.fees FROM seat Left JOIN busbook ON seat.type = busbook.type AND seat.seats=busbook.seat AND seat.date= busbook.date where seat.date= ?");
            pst.setString(1, date);
            
            rs = pst.executeQuery(); 
            ResultSetMetaData rsd = rs.getMetaData();
            int c;
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            
            d.setRowCount(0);
            
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                for(int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("type"));
                    v2.add(rs.getString("seats"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("customer"));
                    v2.add(rs.getString("fees"));
                    v2.add(rs.getString("date"));  
  
                }
                d.addRow(v2);
            }
            
        } 
            catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtsno = new javax.swing.JTextField();
        txtcustname = new javax.swing.JTextField();
        txtmno = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtdchooser2 = new org.netbeans.modules.form.InvalidComponent();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        txtdchooser1 = new org.netbeans.modules.form.InvalidComponent();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtmsg = new javax.swing.JTextField();
        txtmsg1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtmsg2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtmsg3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtmsg4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Ticket Booking");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel1)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Customer Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Fees");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Seat No");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcustname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcustname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Seats", "Status", "Customer Name", "Fees", "Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Seated Date");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Reserve");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Seats", "Status", "Customer Name", "Fees", "Date"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable2PropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Show");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Reserve Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("No of Reserve");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("No of Seated");

        txtmsg.setText("jTextField1");

        txtmsg1.setText("jTextField3");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("No of Available");

        txtmsg2.setText("jTextField3");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Total Reserve Fees");

        txtmsg3.setText("jTextField3");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Total Seated Fees");

        txtmsg4.setText("jTextField3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmsg)
                            .addComponent(txtmsg1)
                            .addComponent(txtmsg2)
                            .addComponent(txtmsg3)
                            .addComponent(txtmsg4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(txtdchooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane2))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdchooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdchooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtmsg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtmsg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmsg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmsg4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtdchooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        Load();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
            int selected = jTable1.getSelectedRow();
            
            String type = d1.getValueAt(selected, 0).toString();
            
            String cusname = txtcustname.getText();
            String seat = txtsno.getText();
            String mno = txtmno.getText();
            
            String date = txtdate.getText();
            
            
            pst = con.prepareStatement("insert into busbook(type,seat,customer,fees,date)values(?,?,?,?,?)"); //book table
            pst.setString(1, type);
            pst.setString(2, seat);
            
            pst.setString(3, cusname);
            pst.setString(4, mno);
            pst.setString(5, date);
            
            pst.executeUpdate();
            
           
 
            
            

            pst1 = con.prepareStatement("update seat set status=? where seats=?"); 
            pst1.setString(1,"Reserved");
            pst1.setString(2,seat);
            int k = pst1.executeUpdate();
            
             if (k==1)
            {
                                               
            JOptionPane.showMessageDialog(this,"Ticket Is Reserved !");
                        
                        Load();
                          txtcustname.setText("");
                          txtsno.setText("");
                          txtmno.setText("");
                          txtdate.setText("");
                          txtcustname.requestFocus();
                          Customer();
                          Sum1();
            }
            
            else
            {
                JOptionPane.showMessageDialog(this,"Reserved Failed!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

        public void Load1()
    {
         try {
            // TODO add your handling code here:
            
            SimpleDateFormat Df= new SimpleDateFormat("yyyy-MM-dd");
            String date= Df.format(txtdchooser2.getDate());
            
            
            pst= con.prepareStatement("SELECT seat.type,seat.seats,seat.status,seat.date,busbook.customer,busbook.fees FROM seat Left JOIN busbook ON seat.type = busbook.type AND seat.seats=busbook.seat AND seat.date= busbook.date where seat.date= ?");
            pst.setString(1, date);
            
            rs = pst.executeQuery(); 
            ResultSetMetaData rsd = rs.getMetaData();
            int c;
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jTable2.getModel();
            
            d.setRowCount(0);
            
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                for(int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("type"));
                    v2.add(rs.getString("seats"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("customer"));
                    v2.add(rs.getString("fees"));
                    v2.add(rs.getString("date"));  
  
                }
                d.addRow(v2);
            }
            
        } 
            catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
     
    public void Customer()
    {
        try 
        {  
             pst = con.prepareStatement("SELECT COUNT(*) AS customerCount FROM busbook");
             ResultSet rs = pst.executeQuery(); 
             while(rs.next())
             {
              int count = rs.getInt("customerCount");
              //  int count = rs.getInt(1);
 
                txtmsg.setText(String.valueOf(count));
                txtmsg2.setText(String.valueOf(99-count));
             } 
        }
    catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
        
        public void Customer1()
    {
        try 
        {  
             pst = con.prepareStatement("SELECT SUM(if(seat.status = 'Seated', 1, 0)) AS customerCount FROM seat");
             ResultSet rs = pst.executeQuery(); 
             while(rs.next())
             {
              int count = rs.getInt("customerCount");
              //  int count = rs.getInt(1);
 
                txtmsg1.setText(String.valueOf(count));
             } 
        }
    catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
        
    public void Sum1()
    {
        try 
        {  
             pst = con.prepareStatement("SELECT SUM(fees) AS feeCount FROM busbook");
             ResultSet rs = pst.executeQuery(); 
             while(rs.next())
             {
              String totalfees1 = rs.getString("feeCount");
              //  int count = rs.getInt(1);
 
                txtmsg3.setText(totalfees1);
             } 
        }
    catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
        
         public void Sum2()
    {
        try 
        {  
             pst = con.prepareStatement("SELECT SUM(fees) AS feeCount FROM seat WHERE seat.status = 'Seated'");
             ResultSet rs = pst.executeQuery(); 
             while(rs.next())
             {
              String totalfees2 = rs.getString("feeCount");
              //  int count = rs.getInt(1);
 
                txtmsg4.setText(totalfees2);
             } 
        }
    catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
        
        
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

            // TODO add your handling code here:
            
            try {
                
            DefaultTableModel d1 = (DefaultTableModel)jTable2.getModel();
            int selected = jTable2.getSelectedRow();
            
            String type = d1.getValueAt(selected, 0).toString();
            
            String cusname = txtcustname.getText();
            String seat = txtsno.getText();
            String mno = txtmno.getText();
            
            String date = txtdate.getText();
            
     /*       
            pst = con.prepareStatement("insert into busbook(type,seat,customer,fees,date)values(?,?,?,?,?)"); //book table
            pst.setString(1, type);
            pst.setString(2, seat);
            
            pst.setString(3, cusname);
            pst.setString(4, mno);
            pst.setString(5, date);
            
            pst.executeUpdate();
            
*/
     /*
            pst2 = con.prepareStatement("update fees set fees=? where fees=?"); 
            pst2.setString(1,mno);
            pst2.setString(2,mno);
            pst2.executeUpdate();   
     */
     
            pst1 = con.prepareStatement("update seat set status=? where seats=?"); 
            pst1.setString(1,"Seated");
            pst1.setString(2,seat);
            int j = pst1.executeUpdate();
            
            if (j==1)
            {
                                              
            JOptionPane.showMessageDialog(this,"Ticket Is Seated !");
            //txtcustname.requestFocus();
            Customer1();
            Sum2();
            Load();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Reserved Failed!");
            }
            
            
            
         /*   

                        Load();
                          txtcustname.setText("");
                          txtsno.setText("");
                          txtmno.setText("");
                          txtdate.setText("");
            

 */
          
            }catch (SQLException ex) {
            Logger.getLogger(booking.class.getName()).log(Level.SEVERE, null, ex);
        } 
                
   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1PropertyChange

//show seat and date on the left boxes if the seat is not booked
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow();
        String status = d1.getValueAt(selected, 2).toString();

        if(!status.equals("Reserved"))
        {
            String seat = d1.getValueAt(selected, 1).toString();
            String date = d1.getValueAt(selected, 5).toString();
            txtsno.setText(seat);
            txtdate.setText(date);
        }
        
        else
        {
            JOptionPane.showMessageDialog(this, "Ticket Reserved!");
            
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable2.getModel();
        int selected = jTable2.getSelectedRow();
        String status = d1.getValueAt(selected, 2).toString();

        if(!status.equals("Seated"))
        {
            String seat = d1.getValueAt(selected, 1).toString();
            String customer = d1.getValueAt(selected, 3).toString();
            String date = d1.getValueAt(selected, 5).toString();
            String fees = d1.getValueAt(selected, 4).toString();
            txtcustname.setText(customer);
            txtmno.setText(fees);
            txtsno.setText(seat);
            txtdate.setText(date);
        }
        
        else
        {
            JOptionPane.showMessageDialog(this, "Ticket Seated!");
        }
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2PropertyChange

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Load1();
    }//GEN-LAST:event_jButton5ActionPerformed

    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtcustname;
    private javax.swing.JTextField txtdate;
    private org.netbeans.modules.form.InvalidComponent txtdchooser1;
    private org.netbeans.modules.form.InvalidComponent txtdchooser2;
    private javax.swing.JTextField txtmno;
    private javax.swing.JTextField txtmsg;
    private javax.swing.JTextField txtmsg1;
    private javax.swing.JTextField txtmsg2;
    private javax.swing.JTextField txtmsg3;
    private javax.swing.JTextField txtmsg4;
    private javax.swing.JTextField txtsno;
    // End of variables declaration//GEN-END:variables

}
