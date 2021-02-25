package atmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    static String user, pass;
    static String useraccno, userpinnum;
    static double userbal;
    static int userid;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordTf = new javax.swing.JPasswordField();
        loginAdminBtn = new javax.swing.JButton();
        exitAdminBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Admin Login");

        jLabel2.setText("User Name");

        jLabel3.setText("Password");

        loginAdminBtn.setText("Login");
        loginAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginAdminBtnActionPerformed(evt);
            }
        });

        exitAdminBtn.setText("Exit");
        exitAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitAdminBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTf)
                            .addComponent(passwordTf, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(loginAdminBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitAdminBtn)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginAdminBtn)
                    .addComponent(exitAdminBtn))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAdminBtnActionPerformed
        String usernameStr = usernameTf.getText().trim();
        String passwordStr = new String(passwordTf.getPassword()).trim();
        String status = "";
        if (usernameStr.equals("") || passwordStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter both username and password");
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver"); // To check if library added or not
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/atmtransaction", "root", "abc123");
                Statement stm = conn.createStatement(); // Intialises stm object
                String query = "select * from admin where username='" + usernameStr + "'";
                ResultSet rs = stm.executeQuery(query);
                if (rs.next()) {
                    // if admin details match
                    user = usernameStr;
                    pass = passwordStr;
                    status = rs.getString("status");
                    if (status.equalsIgnoreCase("Active")) {
                        if (pass.equals(rs.getString("password"))) {
                            AdminHome obj = new AdminHome();
                            obj.setVisible(true);
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid details /Incorrect Password ");

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Your Account is " + status);
                    }
                } else {
                    // check i

                    query = "select * from user where accountnum='" + usernameStr + "'";  //------------doubt
                    rs = stm.executeQuery(query);
                    if (rs.next()) {
                        // if admin details match
                        user = usernameStr;
                        pass = passwordStr;
                        status = rs.getString("status");
                        if (status.equalsIgnoreCase("Active")) {
                            if (pass.equals(rs.getString("pinnumber"))) {
                                useraccno = usernameStr;
                                userpinnum = passwordStr;
                                userbal = rs.getDouble("balance");
                                userid = rs.getInt("usersid");
                                UserHome obj = new UserHome();
                                obj.setVisible(true);
                                this.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid details ");

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Your Account is " + status);
                        }

                    }
                    else{
                             JOptionPane.showMessageDialog(null, "Invalid username and password");
                   
                    }
                }
                stm.close();
                rs.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_loginAdminBtnActionPerformed

    private void exitAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitAdminBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitAdminBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitAdminBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginAdminBtn;
    private javax.swing.JPasswordField passwordTf;
    private javax.swing.JTextField usernameTf;
    // End of variables declaration//GEN-END:variables
}
