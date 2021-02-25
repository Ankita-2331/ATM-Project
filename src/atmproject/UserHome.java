
package atmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UserHome extends javax.swing.JFrame {

    Connection conn;
    Statement stm;

    public UserHome() {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver"); // To check if library added or not
            conn = DriverManager.getConnection("jdbc:mysql://localhost/atmtransaction", "root", "abc123");
            stm = conn.createStatement(); // Intialises stm object
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        balanceLbl.setText("The balance of account number  " + Login.useraccno + " is : " + Login.userbal);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLogoutBtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        balanceLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        useramtTf = new javax.swing.JTextField();
        userwithdrawBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        changePinNumberBtn = new javax.swing.JButton();
        clearPinNumberBtn = new javax.swing.JButton();
        oldPinNumberTf = new javax.swing.JPasswordField();
        newPinNumberTf = new javax.swing.JPasswordField();
        confirmPinNumberTf = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userAmtDepositTf = new javax.swing.JTextField();
        userdepositBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userLogoutBtn.setText("Log out");
        userLogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(balanceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(balanceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Check Balance", jPanel1);

        jLabel1.setText("Enter Amount:");

        userwithdrawBtn.setText("Withdraw");
        userwithdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userwithdrawBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(useramtTf, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(userwithdrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(useramtTf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(userwithdrawBtn)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Withdraw", jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel20.setText("Change  PinNumber");

        jLabel21.setText("Old PinNumber");

        jLabel22.setText("New PinNumber");

        jLabel23.setText("Confirm  PinNumber");

        changePinNumberBtn.setText("Change");
        changePinNumberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePinNumberBtnActionPerformed(evt);
            }
        });

        clearPinNumberBtn.setText("Clear");
        clearPinNumberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPinNumberBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(344, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(oldPinNumberTf, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(newPinNumberTf)
                    .addComponent(confirmPinNumberTf))
                .addGap(52, 52, 52))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21)
                        .addComponent(jLabel22)
                        .addComponent(jLabel23)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(changePinNumberBtn)
                            .addGap(44, 44, 44)
                            .addComponent(clearPinNumberBtn)))
                    .addContainerGap(252, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addGap(37, 37, 37)
                .addComponent(oldPinNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(newPinNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmPinNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(jLabel21)
                    .addGap(28, 28, 28)
                    .addComponent(jLabel22)
                    .addGap(36, 36, 36)
                    .addComponent(jLabel23)
                    .addGap(61, 61, 61)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(changePinNumberBtn)
                        .addComponent(clearPinNumberBtn))
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Change PinNumber", jPanel3);

        jLabel2.setText("Enter Amount:");

        userdepositBtn.setText("Deposit");
        userdepositBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userdepositBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(userAmtDepositTf, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(userdepositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userAmtDepositTf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(userdepositBtn)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Deposit", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(532, Short.MAX_VALUE)
                .addComponent(userLogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userLogoutBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userLogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLogoutBtnActionPerformed
        // TODO add your handling code here:
        Login obj = new Login();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_userLogoutBtnActionPerformed

    private void userwithdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userwithdrawBtnActionPerformed
        String useramt = useramtTf.getText().trim();
        if (useramt.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the amount to be withdrawn");
        } else {
            int amtVal;
            try {
                amtVal = Integer.parseInt(useramt);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter Integer value in amount");
                return;
            }
            try {
                if ((Login.userbal - 1000) >= amtVal) {
                    // balance is atleast greater than the amount to be withdrawn
                    if ((amtVal % 100 == 0)) {
                        // if amount is multiple of 100
                        Login.userbal = Login.userbal - amtVal;
                        String query = "Insert into transaction(transactiondate,amount,balanceleft,usersid)values(CURRENT_DATE()," + amtVal + "," + Login.userbal + "," + Login.userid + ")";

                        int rowaffected = stm.executeUpdate(query);
                        if (rowaffected > 0) {
                            query = "Update user set balance= " + Login.userbal + " where accountnum=" + Login.useraccno;
                            rowaffected = stm.executeUpdate(query);
                            if (rowaffected > 0) {
                                JOptionPane.showMessageDialog(null, "Withdraw Successful!! Your current Balance = " + Login.userbal);
                            }

                        }
                    } else // if amount is not multiple of 100
                    {
                        JOptionPane.showMessageDialog(null, "Amount should be multiple of 100");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry! Insufficient balance. Your Current Balance = " + Login.userbal);
                }
            } catch (Exception e) {
                System.out.println(e);
                return;

            }
            balanceLbl.setText("The balance of account number  " + Login.useraccno + " is : " + Login.userbal);

        }

        useramtTf.setText("");
    }//GEN-LAST:event_userwithdrawBtnActionPerformed

    private void changePinNumberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePinNumberBtnActionPerformed
        String oldPasswordStr = new String(oldPinNumberTf.getPassword()).trim();
        String newPasswordStr = new String(newPinNumberTf.getPassword()).trim();
        String confirmPasswordStr = new String(confirmPinNumberTf.getPassword()).trim();
        if (oldPasswordStr.equals("") || newPasswordStr.equals("") || confirmPasswordStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter all values");
        } else if (!oldPasswordStr.equals(Login.userpinnum)) {
            JOptionPane.showMessageDialog(null, "Old Password does not match");
        } else if (!newPasswordStr.equals(confirmPasswordStr)) {
            JOptionPane.showMessageDialog(null, "New and Confirm password does not match");
        } else {
            try {
                int pass = Integer.parseInt(newPasswordStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter numeric values in password");
                return;
            }
            try {

                // query to update record
                String query = "update user  set pinnumber=" + newPasswordStr + " where accountnum='" + Login.useraccno + "'";

                // executes update query in mysql and returns number of rows updated
                int rowsAff = stm.executeUpdate(query);

                if (rowsAff > 0) {
                    //if record updated
                    JOptionPane.showMessageDialog(null, "Pin number Changed successfully");
                } else {
                    // no record updated
                    JOptionPane.showMessageDialog(null, "Unable to change pin number");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }//GEN-LAST:event_changePinNumberBtnActionPerformed

    private void clearPinNumberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearPinNumberBtnActionPerformed
        oldPinNumberTf.setText("");
        newPinNumberTf.setText("");
        confirmPinNumberTf.setText("");
    }//GEN-LAST:event_clearPinNumberBtnActionPerformed

    private void userdepositBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userdepositBtnActionPerformed
        // TODO add your handling code here:
        String useramt = userAmtDepositTf.getText().trim();
        if (useramt.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the amount to be deposited");
        } else {
            int amtVal;
            try {
                amtVal = Integer.parseInt(useramt);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter Integer value in amount");
                return;
            }
            try {
                    if ((amtVal % 100 == 0)) {
                        // if amount is multiple of 100
                        Login.userbal = Login.userbal + amtVal;
                        String query = "Insert into transaction(transactiondate,amount,balanceleft,usersid)values(CURRENT_DATE()," + amtVal + "," + Login.userbal + "," + Login.userid + ")";

                        int rowaffected = stm.executeUpdate(query);
                        if (rowaffected > 0) {
                            query = "Update user set balance= " + Login.userbal + " where accountnum=" + Login.useraccno;
                            rowaffected = stm.executeUpdate(query);
                            if (rowaffected > 0) {
                                JOptionPane.showMessageDialog(null, "Deposited Successful!! Your current Balance = " + Login.userbal);
                            }

                        }
                    } else // if amount is not multiple of 100
                    {
                        JOptionPane.showMessageDialog(null, "Amount should be multiple of 100");
                    }
               
            } catch (Exception e) {
                System.out.println(e);
                return;

            }
            balanceLbl.setText("The balance of account number  " + Login.useraccno + " is : " + Login.userbal);

        }

        userAmtDepositTf.setText("");

    }//GEN-LAST:event_userdepositBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceLbl;
    private javax.swing.JButton changePinNumberBtn;
    private javax.swing.JButton clearPinNumberBtn;
    private javax.swing.JPasswordField confirmPinNumberTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField newPinNumberTf;
    private javax.swing.JPasswordField oldPinNumberTf;
    private javax.swing.JTextField userAmtDepositTf;
    private javax.swing.JButton userLogoutBtn;
    private javax.swing.JTextField useramtTf;
    private javax.swing.JButton userdepositBtn;
    private javax.swing.JButton userwithdrawBtn;
    // End of variables declaration//GEN-END:variables
}
