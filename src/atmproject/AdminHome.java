package atmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminHome extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    Statement stm;

    public AdminHome() {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver"); // To check if library added or not
            conn = DriverManager.getConnection("jdbc:mysql://localhost/atmtransaction", "root", "abc123");
            stm = conn.createStatement(); // Intialises stm object
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        getUserData();
        getAdminData();
        getTransactionData();
    }

    void getUserData() {
        try {
            String accountStr = searchAccountTf.getText().trim();
            String query = "Select * from user where usersid>0";
            if (!accountStr.equals("")) {
                query += " and accountnum like'" + accountStr + "%'";
            }
            rs = stm.executeQuery(query);

            // get table data from JTable(userTable)
            DefaultTableModel tableModel = (DefaultTableModel) userTable.getModel();

            // get total rows in  table (JTable(userTable))
            int rowCount = tableModel.getRowCount();

            // empty Jtable records
            for (int i = 0; i < rowCount; i++) {
                tableModel.removeRow(0);
            }
            // executes till records are available in mysql table and add records in userTable(JTable)
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("usersid"),
                    rs.getInt("accountnum"),
                    rs.getInt("pinnumber"),
                    rs.getDouble("balance"),
                    rs.getString("status")
                });
                /*sets first record of the mysql table in the respective textfields */
                if (rs.isFirst()) {
                    userAccountTf.setText(rs.getString("accountnum"));
                    userPinNumberTf.setText(rs.getString("pinnumber"));
                    userBalanceTf.setText(rs.getString("balance"));
                    userstatusCmb.setSelectedItem(rs.getString("status"));
                }
                // rs.getString("name of mysql table column")

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    void getAdminData() {
        try {
            String usernameStr = searchAdminUserNameTf.getText().trim();
            String query = "Select * from admin where userid>0";
            if (!usernameStr.equals("")) {
                query += " and username like'" + usernameStr + "%'";
            }
            rs = stm.executeQuery(query);

            // get table data from JTable(userTable)
            DefaultTableModel tableModel = (DefaultTableModel) adminTable.getModel();

            // get total rows in  table (JTable(userTable))
            int rowCount = tableModel.getRowCount();

            // empty Jtable records
            for (int i = 0; i < rowCount; i++) {
                tableModel.removeRow(0);
            }
            // executes till records are available in mysql table and add records in userTable(JTable)
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("userid"),
                    rs.getString("username"),
                    rs.getInt("password"),
                    rs.getString("status")
                });
                /*sets first record of the mysql table in the respective textfields */
                if (rs.isFirst()) {
                    adminUserIdTf.setText(rs.getString("userid"));
                    adminUsernameTf.setText(rs.getString("username"));
                    adminPasswordTf.setText(rs.getString("password"));
                    adminStatusCmb.setSelectedItem(rs.getString("status"));
                }
                // rs.getString("name of mysql table column")

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    void getTransactionData() {
        try {
            String accountStr = transactionAccountNumTf.getText().trim();
            String query = "Select transactionid,transactiondate,amount,balanceleft,accountnum from transaction t,user u where t.usersid=u.usersid";
            if (!accountStr.equals("")) {
                query += " and accountnum like'" + accountStr + "%'";
            }
            rs = stm.executeQuery(query);

            // get table data from JTable(userTable)
            DefaultTableModel tableModel = (DefaultTableModel) transactiontable.getModel();

            // get total rows in  table (JTable(userTable))
            int rowCount = tableModel.getRowCount();

            // empty Jtable records
            for (int i = 0; i < rowCount; i++) {
                tableModel.removeRow(0);
            }
            // executes till records are available in mysql table and add records in userTable(JTable)
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("transactionid"),
                    rs.getDate("transactiondate"),
                    rs.getDouble("amount"),
                    rs.getDouble("balanceleft"),
                    rs.getInt("accountnum"),});
                /*sets first record of the mysql table in the respective textfields */
//                if (rs.isFirst()) {
//                    userAccountTf.setText(rs.getString("accountnum"));
//                    userPinNumberTf.setText(rs.getString("pinnumber"));
//                    userBalanceTf.setText(rs.getString("balance"));
//                    userstatusCmb.setSelectedItem(rs.getString("status"));
//                }
                // rs.getString("name of mysql table column")

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    void userClear() {
        userAccountTf.setText("");
        userPinNumberTf.setText("");
        userBalanceTf.setText("");
        searchAccountTf.setText("");
        getUserData();
    }

    void adminClear() {
        adminUserIdTf.setText("");
        adminUsernameTf.setText("");
        adminPasswordTf.setText("");
        searchAdminUserNameTf.setText("");
     //   getAdminData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userstatusCmb = new javax.swing.JComboBox();
        userAccountTf = new javax.swing.JTextField();
        userPinNumberTf = new javax.swing.JTextField();
        userBalanceTf = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        userAddBtn = new javax.swing.JButton();
        updateUserBtn = new javax.swing.JButton();
        deleteUserBtn = new javax.swing.JButton();
        userClearBtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        searchAccountTf = new javax.swing.JTextField();
        userSearchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        adminStatusCmb = new javax.swing.JComboBox();
        adminUserIdTf = new javax.swing.JTextField();
        adminUsernameTf = new javax.swing.JTextField();
        adminPasswordTf = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        adminAddBtn = new javax.swing.JButton();
        updateAdminBtn = new javax.swing.JButton();
        deleteAdminBtn = new javax.swing.JButton();
        adminClearBtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        searchAdminUserNameTf = new javax.swing.JTextField();
        adminSearchBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        oldPasswordTf = new javax.swing.JPasswordField();
        newPasswordTf = new javax.swing.JPasswordField();
        confirmPasswordTf = new javax.swing.JPasswordField();
        changePasswordBtn = new javax.swing.JButton();
        clearChgPassBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        transactionAccountNumTf = new javax.swing.JTextField();
        transSearchBtn = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        transactiontable = new javax.swing.JTable();
        logoutAdminBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Account Number");

        jLabel2.setText("Pin Number");

        jLabel3.setText("Balance");

        jLabel4.setText("Status");

        userstatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Blocked", "Closed" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userstatusCmb, 0, 170, Short.MAX_VALUE)
                    .addComponent(userAccountTf)
                    .addComponent(userPinNumberTf)
                    .addComponent(userBalanceTf))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userAccountTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(userPinNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(userBalanceTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userstatusCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        userAddBtn.setText("Add");
        userAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAddBtnActionPerformed(evt);
            }
        });

        updateUserBtn.setText("Update");
        updateUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserBtnActionPerformed(evt);
            }
        });

        deleteUserBtn.setText("Delete");
        deleteUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserBtnActionPerformed(evt);
            }
        });

        userClearBtn.setText("Clear");
        userClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userClearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateUserBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(userAddBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(userAddBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteUserBtn)
                .addGap(18, 18, 18)
                .addComponent(userClearBtn)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Enter account Number");

        userSearchBtn.setText("Search");
        userSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(45, 45, 45)
                .addComponent(searchAccountTf, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(userSearchBtn)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(searchAccountTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userSearchBtn))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "User Id", "Account Number", "Pin Number", "Balance", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(userTable);

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customers", jPanel1);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("User ID");

        jLabel7.setText("Username");

        jLabel8.setText("Password");

        jLabel9.setText("Status");

        adminStatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Blocked", "Closed" }));

        adminUserIdTf.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adminStatusCmb, 0, 170, Short.MAX_VALUE)
                    .addComponent(adminUserIdTf)
                    .addComponent(adminUsernameTf)
                    .addComponent(adminPasswordTf))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(adminUserIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(adminUsernameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(adminPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(adminStatusCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        adminAddBtn.setText("Add");
        adminAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminAddBtnActionPerformed(evt);
            }
        });

        updateAdminBtn.setText("Update");
        updateAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAdminBtnActionPerformed(evt);
            }
        });

        deleteAdminBtn.setText("Delete");
        deleteAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAdminBtnActionPerformed(evt);
            }
        });

        adminClearBtn.setText("Clear");
        adminClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminClearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminAddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(updateAdminBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(deleteAdminBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(adminClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(adminAddBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateAdminBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteAdminBtn)
                .addGap(18, 18, 18)
                .addComponent(adminClearBtn)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("Enter User name");

        adminSearchBtn.setText("Search");
        adminSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(45, 45, 45)
                .addComponent(searchAdminUserNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(adminSearchBtn)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(searchAdminUserNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminSearchBtn))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User Id", "Username", "Password", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        adminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(adminTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(293, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Admin", jPanel5);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel12.setText("Change Password");

        jLabel13.setText("New Password");

        jLabel14.setText("Old Password");

        jLabel15.setText("Confirm Password");

        changePasswordBtn.setText("Change");
        changePasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordBtnActionPerformed(evt);
            }
        });

        clearChgPassBtn.setText("Clear");
        clearChgPassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearChgPassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(oldPasswordTf, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(newPasswordTf)
                            .addComponent(confirmPasswordTf)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(changePasswordBtn)
                        .addGap(44, 44, 44)
                        .addComponent(clearChgPassBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel12)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(oldPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(newPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(confirmPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePasswordBtn)
                    .addComponent(clearChgPassBtn))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" Change Password", jPanel3);

        jLabel11.setText("Enter the account number for transaction :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(transactionAccountNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transactionAccountNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        transSearchBtn.setText("Search");
        transSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transSearchBtnActionPerformed(evt);
            }
        });

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        transactiontable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Transaction Id", "Transaction Date", "Amount", "Balance Left", "Account Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(transactiontable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(transSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(transSearchBtn)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transactions", jPanel2);

        logoutAdminBtn.setText("Logout");
        logoutAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutAdminBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoutAdminBtn)))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSearchBtnActionPerformed
        getUserData();
    }//GEN-LAST:event_userSearchBtnActionPerformed

    private void userClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userClearBtnActionPerformed
        userAccountTf.setText("");
        userPinNumberTf.setText("");
        userBalanceTf.setText("");
        // getUserData(); 
    }//GEN-LAST:event_userClearBtnActionPerformed

    private void userAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAddBtnActionPerformed
        String accountStr = userAccountTf.getText().trim();
        String pinNumberStr = userPinNumberTf.getText().trim();;
        String balanceStr = userBalanceTf.getText().trim();
        String statusStr = userstatusCmb.getSelectedItem().toString();

        if (accountStr.equals("") || pinNumberStr.equals("") || balanceStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the values");
            return;
        }
        int accountNumber, pinNumber;
        double balance;
        try {
            accountNumber = Integer.parseInt(accountStr);
            pinNumber = Integer.parseInt(pinNumberStr);
            balance = Double.parseDouble(balanceStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter numeric values in account,pin number and balance");
            return;
        }
        try {
            String query = "select * from user where accountnum=" + accountNumber;
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Account already exists !!!");
                return;
            }
            
            // query to insert record
            query = "insert into user (accountnum,pinnumber,balance,status) values (" + accountNumber + "," + pinNumber + "," + balance + ",'" + statusStr + "')";

            // executes insert query in mysql and returns number of rows inserted
            int rowsAff = stm.executeUpdate(query);

            if (rowsAff > 0) {
                //if record inserted
                JOptionPane.showMessageDialog(null, "Record added successfully");
            } else {
                // no rows inserted
                JOptionPane.showMessageDialog(null, "Unable to add Record");
            }
            getUserData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_userAddBtnActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            userAccountTf.setText(userTable.getValueAt(selectedRow, 1).toString());
            userPinNumberTf.setText(userTable.getValueAt(selectedRow, 2).toString());
            userBalanceTf.setText(userTable.getValueAt(selectedRow, 3).toString());
            userstatusCmb.setSelectedItem(userTable.getValueAt(selectedRow, 4).toString());
        } else {
            getUserData();
        }

    }//GEN-LAST:event_userTableMouseClicked

    private void updateUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserBtnActionPerformed
        String accountStr = userAccountTf.getText().trim();
        String pinNumberStr = userPinNumberTf.getText().trim();;
        String balanceStr = userBalanceTf.getText().trim();
        String statusStr = userstatusCmb.getSelectedItem().toString();

        if (accountStr.equals("") || pinNumberStr.equals("") || balanceStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the values");
            return;
        }
        int accountNumber = 0, pinNumber = 0;
        double balance = 0;
        try {
            accountNumber = Integer.parseInt(accountStr);
            pinNumber = Integer.parseInt(pinNumberStr);
            balance = Double.parseDouble(balanceStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter numeric values in account,pin number and balance");
            return;
        }

        try {

            // query to update record
            String query = "update user  set balance=" + balance + ",pinnumber=" + pinNumber + ",status='" + statusStr + "' where accountnum=" + accountNumber;

            // executes update query in mysql and returns number of rows updated
            int rowsAff = stm.executeUpdate(query);

            if (rowsAff > 0) {
                //if record updated
                JOptionPane.showMessageDialog(null, "Record updated successfully");
            } else {
                // no record updated
                JOptionPane.showMessageDialog(null, "Unable to update Record");
            }
            getUserData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_updateUserBtnActionPerformed

    private void deleteUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserBtnActionPerformed
        String accountStr = userAccountTf.getText().trim();

        if (accountStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the account number");
            return;
        }
        int accountNumber = 0;

        try {
            accountNumber = Integer.parseInt(accountStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter numeric values in account number ");
            return;
        }

        try {

            // query to update record
            String query = "update  user  set status='Blocked' where accountnum=" + accountNumber;

            // executes delete query in mysql and returns number of rows updated
            int rowsAff = stm.executeUpdate(query);

            if (rowsAff > 0) {
                //if record deleted
                JOptionPane.showMessageDialog(null, "Record deleted successfully");
            } else {
                // no record deleted
                JOptionPane.showMessageDialog(null, "Unable to delete Record");
            }
            getUserData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_deleteUserBtnActionPerformed

    private void adminAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminAddBtnActionPerformed
        String usernameStr = adminUsernameTf.getText().trim();;
        String passwordStr = adminPasswordTf.getText().trim();
        String statusStr = adminStatusCmb.getSelectedItem().toString();

        if (usernameStr.equals("") || passwordStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the values");
            return;
        }
        int password;
        try {
            password = Integer.parseInt(passwordStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter numeric values in password");
            return;
        }
        try {

            String query = "select * from admin where username='" + usernameStr+"'";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Account already exists !!!");
                return;
            }
            // query to insert record
            query = "insert into admin (username,password,status) values ('" + usernameStr + "'," + passwordStr + ",'" + statusStr + "')";

            // executes insert query in mysql and returns number of rows inserted
            int rowsAff = stm.executeUpdate(query);

            if (rowsAff > 0) {
                //if record inserted
                JOptionPane.showMessageDialog(null, "Record added successfully");
            } else {
                // no rows inserted
                JOptionPane.showMessageDialog(null, "Unable to add Record");
            }
            getAdminData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_adminAddBtnActionPerformed

    private void updateAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAdminBtnActionPerformed
        String userIdStr = adminUserIdTf.getText().trim();
        String usernameStr = adminUsernameTf.getText().trim();
        String passwordStr = adminPasswordTf.getText().trim();
        String statusStr = adminStatusCmb.getSelectedItem().toString();
        if (userIdStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Select Record to update");
            return;

        }
        if (usernameStr.equals("") || passwordStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the values");
            return;
        }
        int password;
        try {
            password = Integer.parseInt(passwordStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter numeric values in password");
            return;
        }

        try {

            // query to update record
            String query = "update admin  set password=" + password + ",username='" + usernameStr + "',status='" + statusStr + "' where userid=" + userIdStr;

            // executes update query in mysql and returns number of rows updated
            int rowsAff = stm.executeUpdate(query);

            if (rowsAff > 0) {
                //if record updated
                JOptionPane.showMessageDialog(null, "Record updated successfully");
            } else {
                // no record updated
                JOptionPane.showMessageDialog(null, "Unable to update Record");
            }
            getAdminData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_updateAdminBtnActionPerformed

    private void deleteAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAdminBtnActionPerformed
        String userIdStr = adminUserIdTf.getText().trim();
        if (userIdStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Select Record to update");
            return;

        }

        try {

            // query to update record
            String query = "delete from  admin  where userid=" + userIdStr;

            // executes delete query in mysql and returns number of rows updated
            int rowsAff = stm.executeUpdate(query);

            if (rowsAff > 0) {
                //if record deleted
                JOptionPane.showMessageDialog(null, "Record deleted successfully");
            } else {
                // no record deleted
                JOptionPane.showMessageDialog(null, "Unable to delete Record");
            }
            getAdminData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_deleteAdminBtnActionPerformed

    private void adminClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminClearBtnActionPerformed
        adminClear();
    }//GEN-LAST:event_adminClearBtnActionPerformed

    private void adminSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSearchBtnActionPerformed
        getAdminData();
    }//GEN-LAST:event_adminSearchBtnActionPerformed

    private void adminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTableMouseClicked
        int selectedRow = adminTable.getSelectedRow();
        if (selectedRow >= 0) {
            adminUserIdTf.setText(adminTable.getValueAt(selectedRow, 0).toString());
            adminUsernameTf.setText(adminTable.getValueAt(selectedRow, 1).toString());
            adminPasswordTf.setText(adminTable.getValueAt(selectedRow, 2).toString());
            adminStatusCmb.setSelectedItem(adminTable.getValueAt(selectedRow, 3).toString());
        } else {
            getAdminData();
        }
    }//GEN-LAST:event_adminTableMouseClicked

    private void transSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transSearchBtnActionPerformed
        getTransactionData();
    }//GEN-LAST:event_transSearchBtnActionPerformed

    private void changePasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordBtnActionPerformed
        String oldPasswordStr = new String(oldPasswordTf.getPassword()).trim();
        String newPasswordStr = new String(newPasswordTf.getPassword()).trim();
        String confirmPasswordStr = new String(confirmPasswordTf.getPassword()).trim();
        if (oldPasswordStr.equals("") || newPasswordStr.equals("") || confirmPasswordStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter all values");
        } else if (!oldPasswordStr.equals(Login.pass)) {
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
                String query = "update admin  set password=" + newPasswordStr + " where username='" + Login.user + "'";

                // executes update query in mysql and returns number of rows updated
                int rowsAff = stm.executeUpdate(query);

                if (rowsAff > 0) {
                    //if record updated
                    JOptionPane.showMessageDialog(null, "Password Changed successfully");
                } else {
                    // no record updated
                    JOptionPane.showMessageDialog(null, "Unable to change password");
                }
                getAdminData();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }//GEN-LAST:event_changePasswordBtnActionPerformed

    private void logoutAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutAdminBtnActionPerformed
        Login obj = new Login();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutAdminBtnActionPerformed

    private void clearChgPassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearChgPassBtnActionPerformed
        oldPasswordTf.setText("");
        newPasswordTf.setText("");
        confirmPasswordTf.setText("");
    }//GEN-LAST:event_clearChgPassBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminAddBtn;
    private javax.swing.JButton adminClearBtn;
    private javax.swing.JTextField adminPasswordTf;
    private javax.swing.JButton adminSearchBtn;
    private javax.swing.JComboBox adminStatusCmb;
    private javax.swing.JTable adminTable;
    private javax.swing.JTextField adminUserIdTf;
    private javax.swing.JTextField adminUsernameTf;
    private javax.swing.JButton changePasswordBtn;
    private javax.swing.JButton clearChgPassBtn;
    private javax.swing.JPasswordField confirmPasswordTf;
    private javax.swing.JButton deleteAdminBtn;
    private javax.swing.JButton deleteUserBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logoutAdminBtn;
    private javax.swing.JPasswordField newPasswordTf;
    private javax.swing.JPasswordField oldPasswordTf;
    private javax.swing.JTextField searchAccountTf;
    private javax.swing.JTextField searchAdminUserNameTf;
    private javax.swing.JButton transSearchBtn;
    private javax.swing.JTextField transactionAccountNumTf;
    private javax.swing.JTable transactiontable;
    private javax.swing.JButton updateAdminBtn;
    private javax.swing.JButton updateUserBtn;
    private javax.swing.JTextField userAccountTf;
    private javax.swing.JButton userAddBtn;
    private javax.swing.JTextField userBalanceTf;
    private javax.swing.JButton userClearBtn;
    private javax.swing.JTextField userPinNumberTf;
    private javax.swing.JButton userSearchBtn;
    private javax.swing.JTable userTable;
    private javax.swing.JComboBox userstatusCmb;
    // End of variables declaration//GEN-END:variables
}
