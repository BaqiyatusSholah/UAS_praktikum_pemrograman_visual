/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package e.wardrobe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author OKI
 */
public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
        
        
        inusername.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inusername.getText().equals("Username")) {
                        inusername.setText("");
                        inusername.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inusername.getText().isEmpty()) {
                        inusername.setText("Username");
                        inusername.setForeground(Color.GRAY);
                    }
                }
        });
        inpassword.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inpassword.getText().equals("********")) {
                        inpassword.setText("");
                        inpassword.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inpassword.getText().isEmpty()) {
                        inpassword.setText("********");
                        inpassword.setForeground(Color.GRAY);
                    }
                }
        });
        innamalengkap.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (innamalengkap.getText().equals("Nama Lengkap")) {
                        innamalengkap.setText("");
                        innamalengkap.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (innamalengkap.getText().isEmpty()) {
                        innamalengkap.setText("Nama Lengkap");
                        innamalengkap.setForeground(Color.GRAY);
                    }
                }
        });
        inalamat.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inalamat.getText().equals("Alamat")) {
                        inalamat.setText("");
                        inalamat.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inalamat.getText().isEmpty()) {
                        inalamat.setText("Alamat");
                        inalamat.setForeground(Color.GRAY);
                    }
                }
        });
        innomor.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (innomor.getText().equals("Nomor")) {
                        innomor.setText("");
                        innomor.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (innomor.getText().isEmpty()) {
                        innomor.setText("Nomor");
                        innomor.setForeground(Color.GRAY);
                    }
                }
        });
        inpassreg.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inpassreg.getText().equals("Password")) {
                        inpassreg.setText("");
                        inpassreg.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inpassreg.getText().isEmpty()) {
                        inpassreg.setText("Password");
                        inpassreg.setForeground(Color.GRAY);
                    }
                }
        });
        inuserreg.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inuserreg.getText().equals("Username")) {
                        inuserreg.setText("");
                        inuserreg.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inuserreg.getText().isEmpty()) {
                        inuserreg.setText("Username");
                        inuserreg.setForeground(Color.GRAY);
                    }
                }
        });
    }
    
    public void LoadDataAdmin(){    
    try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/uas_java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM tb_admin"; // Ganti dengan nama tabel Anda
            ResultSet rs = stmt.executeQuery(query);

            // Tambahkan data baris ke model tabel
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nama = rs.getString("nama_admin");
                String alamat = rs.getString("alamat_admin");
                String nomor = rs.getString("nomor_admin");
                
                String tbdata[] = {id, nama, alamat, nomor};
                DefaultTableModel tablemodel = (DefaultTableModel)tbadmin.getModel();
                tablemodel.addRow(tbdata);
            }

            // Tutup koneksi
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void LoadDataPengguna(){    
    try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/uas_java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM tb_pengguna"; // Ganti dengan nama tabel Anda
            ResultSet rs = stmt.executeQuery(query);

            // Tambahkan data baris ke model tabel
            while (rs.next()) {
                String username = rs.getString("username");
                String nama = rs.getString("pass_user");
                String alamat = rs.getString("nomor_user");
                String nomor = rs.getString("alamat_user");
                
                String tbdata[] = {username, nama, alamat, nomor};
                DefaultTableModel tablemodel = (DefaultTableModel)tbpengguna.getModel();
                tablemodel.addRow(tbdata);
            }

            // Tutup koneksi
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void BuatTablePengguna(){   
    String tableName = inuserreg.getText();
    String sql1_teks = "outfit_";

            if (tableName == null || tableName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    try {
            // Koneksi ke Database
            String url = "jdbc:mysql://localhost:3306/uas_java_database";
            String user = "root"; // sesuaikan dengan user database Anda
            String password = ""; // sesuaikan dengan password database Anda
            Connection conn = DriverManager.getConnection(url, user, password);

            // Query untuk membuat tabel
            String sql = "CREATE TABLE " + tableName + " (id INT PRIMARY KEY AUTO_INCREMENT, nama_pakaian VARCHAR(32), warna VARCHAR(16), kategori VARCHAR(16))";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            
            String sql1 = "CREATE TABLE " + sql1_teks + tableName + " (id INT PRIMARY KEY AUTO_INCREMENT, nama_outfit VARCHAR(32), pakaian VARCHAR(128))";
            Statement statement1 = conn.createStatement();
            statement1.executeUpdate(sql1);

            // Tutup koneksi
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/uas_java_database";
        private static final String USER = "root"; // Ganti sesuai user database
        private static final String PASSWORD = ""; // Ganti sesuai password database

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
    
    private void Login() {
        String username = inusername.getText();
        String password = new String(inpassword.getPassword());

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM tb_pengguna WHERE username = ? AND pass_user = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Login berhasil!");
                TabPengguna.setVisible(true);
                LogPanel.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Username atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        Parent = new javax.swing.JPanel();
        LogPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        inusername = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        btnregdis = new javax.swing.JButton();
        inpassword = new javax.swing.JPasswordField();
        RegPanel = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        innamalengkap = new javax.swing.JTextField();
        innomor = new javax.swing.JTextField();
        btnreg = new javax.swing.JButton();
        inuserreg = new javax.swing.JTextField();
        inalamat = new javax.swing.JTextField();
        inpassreg = new javax.swing.JTextField();
        btnlogdis = new javax.swing.JButton();
        TabAdmin = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbadmin = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        inuseredit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inpassedit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btneditadmin = new javax.swing.JButton();
        btndeladmin = new javax.swing.JButton();
        btnoutadmin = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbpengguna = new javax.swing.JTable();
        TabPengguna = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        inpakaian = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        inwarna = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnaddpakaian = new javax.swing.JButton();
        btneditpakaian = new javax.swing.JButton();
        btndelpakaian = new javax.swing.JButton();
        btnoutuser = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbpakaian = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tboutfit = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        innamaoutfit = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btneditoutfit = new javax.swing.JButton();
        btndeloutfit = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnaddoufit = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Parent.setLayout(new java.awt.CardLayout());

        LogPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 150));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel6.setBackground(new java.awt.Color(189, 189, 189));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6);

        jPanel4.setBackground(new java.awt.Color(189, 189, 189));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("penyimpanan baju digital");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("e-Wardrobe");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(32, 32, 32))
        );

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(189, 189, 189));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5);

        LogPanel.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jPanel8.setBackground(new java.awt.Color(243, 240, 230));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e/gambar/home.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel8);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(243, 240, 230));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel10, java.awt.BorderLayout.LINE_START);

        jPanel11.setBackground(new java.awt.Color(243, 240, 230));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel11, java.awt.BorderLayout.LINE_END);

        jPanel12.setBackground(new java.awt.Color(243, 240, 230));

        inusername.setText("Username");

        btnlogin.setBackground(new java.awt.Color(212, 175, 55));
        btnlogin.setText("MASUK");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btnregdis.setBackground(new java.awt.Color(212, 175, 55));
        btnregdis.setText("REGISTRASI");
        btnregdis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregdisActionPerformed(evt);
            }
        });

        inpassword.setText("********");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inusername)
            .addComponent(btnlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnregdis, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addComponent(inpassword)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(inusername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnregdis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9);

        LogPanel.add(jPanel7, java.awt.BorderLayout.CENTER);

        Parent.add(LogPanel, "card2");

        RegPanel.setLayout(new java.awt.BorderLayout());

        jPanel38.setPreferredSize(new java.awt.Dimension(800, 150));
        jPanel38.setLayout(new java.awt.GridLayout(1, 0));

        jPanel39.setBackground(new java.awt.Color(189, 189, 189));
        jPanel39.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        jPanel38.add(jPanel39);

        jPanel40.setBackground(new java.awt.Color(189, 189, 189));
        jPanel40.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("penyimpanan baju digital");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("e-Wardrobe");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(32, 32, 32))
        );

        jPanel38.add(jPanel40);

        jPanel41.setBackground(new java.awt.Color(189, 189, 189));
        jPanel41.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        jPanel38.add(jPanel41);

        RegPanel.add(jPanel38, java.awt.BorderLayout.PAGE_START);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setLayout(new java.awt.GridLayout(1, 0));

        jPanel43.setBackground(new java.awt.Color(243, 240, 230));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e/gambar/home.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel42.add(jPanel43);

        jPanel44.setLayout(new java.awt.BorderLayout());

        jPanel45.setBackground(new java.awt.Color(243, 240, 230));

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jPanel44.add(jPanel45, java.awt.BorderLayout.LINE_START);

        jPanel46.setBackground(new java.awt.Color(243, 240, 230));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jPanel44.add(jPanel46, java.awt.BorderLayout.LINE_END);

        jPanel47.setBackground(new java.awt.Color(243, 240, 230));

        innamalengkap.setText("Nama Lengkap");

        innomor.setText("Nomor");

        btnreg.setBackground(new java.awt.Color(212, 175, 55));
        btnreg.setText("REGISTRASI");
        btnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregActionPerformed(evt);
            }
        });

        inuserreg.setText("Username");

        inalamat.setText("Alamat");

        inpassreg.setText("Password");

        btnlogdis.setBackground(new java.awt.Color(212, 175, 55));
        btnlogdis.setText("MASUK");
        btnlogdis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogdisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(innamalengkap)
            .addComponent(innomor, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addComponent(btnreg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inuserreg, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addComponent(inalamat)
            .addComponent(inpassreg, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addComponent(btnlogdis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(innamalengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(innomor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inuserreg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inpassreg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlogdis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jPanel44.add(jPanel47, java.awt.BorderLayout.CENTER);

        jPanel42.add(jPanel44);

        RegPanel.add(jPanel42, java.awt.BorderLayout.CENTER);

        Parent.add(RegPanel, "card2");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(189, 189, 189));

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel7.setText("DAFTAR ADMIN");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(632, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        tbadmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAMA", "ALAMAT", "NOMOR"
            }
        ));
        jScrollPane1.setViewportView(tbadmin);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, java.awt.BorderLayout.CENTER);

        TabAdmin.addTab("ADMIN", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(189, 189, 189));

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel11.setText("DAFTAR PENGGUNA");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(584, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jPanel16.setBackground(new java.awt.Color(243, 240, 230));
        jPanel16.setPreferredSize(new java.awt.Dimension(250, 466));

        jLabel9.setText("Username");

        jLabel10.setText("Password Baru");

        btneditadmin.setBackground(new java.awt.Color(174, 223, 247));
        btneditadmin.setText("GANTI");
        btneditadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditadminActionPerformed(evt);
            }
        });

        btndeladmin.setBackground(new java.awt.Color(255, 111, 97));
        btndeladmin.setText("HAPUS");
        btndeladmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeladminActionPerformed(evt);
            }
        });

        btnoutadmin.setBackground(new java.awt.Color(212, 175, 55));
        btnoutadmin.setText("Log Out");
        btnoutadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoutadminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inuseredit)
                    .addComponent(inpassedit, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btneditadmin)
                                .addGap(28, 28, 28)
                                .addComponent(btndeladmin))
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnoutadmin)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inuseredit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inpassedit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneditadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeladmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(btnoutadmin)
                .addContainerGap())
        );

        jPanel2.add(jPanel16, java.awt.BorderLayout.LINE_END);

        tbpengguna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USERNAME", "NAMA", "ALAMAT", "NOMOR"
            }
        ));
        tbpengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpenggunaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbpengguna);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel17, java.awt.BorderLayout.CENTER);

        TabAdmin.addTab("TASK", jPanel2);

        Parent.add(TabAdmin, "card5");

        jPanel21.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(189, 189, 189));

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel17.setText("DAFTAR PAKAIAN");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(610, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel17)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel21.add(jPanel22, java.awt.BorderLayout.PAGE_START);

        jPanel23.setBackground(new java.awt.Color(243, 240, 230));
        jPanel23.setPreferredSize(new java.awt.Dimension(250, 466));

        jLabel13.setText("Nama Pakaian");

        jLabel14.setText("Warna");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KATEGORI", "Topi", "Atasan", "Outwear", "Bawahan", "Alas Kaki", "Aksesoris" }));

        btnaddpakaian.setBackground(new java.awt.Color(152, 255, 152));
        btnaddpakaian.setText("TAMBAH");

        btneditpakaian.setBackground(new java.awt.Color(174, 223, 247));
        btneditpakaian.setText("GANTI");

        btndelpakaian.setBackground(new java.awt.Color(255, 111, 97));
        btndelpakaian.setText("HAPUS");

        btnoutuser.setBackground(new java.awt.Color(212, 175, 55));
        btnoutuser.setText("Log Out");
        btnoutuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoutuserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inpakaian)
                    .addComponent(inwarna, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnaddpakaian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(btneditpakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelpakaian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnoutuser)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inpakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inwarna, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaddpakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneditpakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelpakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(btnoutuser)
                .addContainerGap())
        );

        jPanel21.add(jPanel23, java.awt.BorderLayout.LINE_END);

        tbpakaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KATEGORI", "NAMA", "WARNA"
            }
        ));
        jScrollPane4.setViewportView(tbpakaian);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        jPanel21.add(jPanel24, java.awt.BorderLayout.CENTER);

        TabPengguna.addTab("PAKAIAN", jPanel21);

        jPanel25.setLayout(new java.awt.BorderLayout());

        jPanel26.setBackground(new java.awt.Color(189, 189, 189));

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel18.setText("DAFTAR OUTFIT");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(632, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel18)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel25.add(jPanel26, java.awt.BorderLayout.PAGE_START);

        tboutfit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAMA", "PAKAIAN"
            }
        ));
        jScrollPane5.setViewportView(tboutfit);

        jPanel27.setBackground(new java.awt.Color(243, 240, 230));
        jPanel27.setPreferredSize(new java.awt.Dimension(250, 466));

        jLabel16.setText("Nama Outfit");

        btneditoutfit.setBackground(new java.awt.Color(174, 223, 247));
        btneditoutfit.setText("GANTI");

        btndeloutfit.setBackground(new java.awt.Color(255, 111, 97));
        btndeloutfit.setText("HAPUS");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Topi" }));

        btnaddoufit.setBackground(new java.awt.Color(152, 255, 152));
        btnaddoufit.setText("TAMBAH");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Outwear" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bawahan" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alas Kaki" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atasan" }));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aksesoris" }));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(innamaoutfit)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnaddoufit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(btneditoutfit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndeloutfit, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(innamaoutfit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox7, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnaddoufit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneditoutfit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeloutfit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.add(jPanel28, java.awt.BorderLayout.CENTER);

        TabPengguna.addTab("OUTFIT", jPanel25);

        Parent.add(TabPengguna, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        String username = inusername.getText();
        String pass = inpassword.getText();

        if ("admin".equals(username) && "admin123".equals(pass)){
            LogPanel.setVisible(false);
            TabAdmin.setVisible(true);
            LoadDataAdmin();
            LoadDataPengguna();
        }else{
            Login();
        }
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnregdisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregdisActionPerformed
        // TODO add your handling code here:
        RegPanel.setVisible(true);
        LogPanel.setVisible(false);
    }//GEN-LAST:event_btnregdisActionPerformed

    private void btnoutadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoutadminActionPerformed
        // TODO add your handling code here:
        TabAdmin.setVisible(false);
        LogPanel.setVisible(true);
    }//GEN-LAST:event_btnoutadminActionPerformed

    private void btnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregActionPerformed
        // TODO add your handling code here:        
        if(innamalengkap.getText().equals("Username") || inalamat.getText().equals("Alamat") || innomor.getText().equals("Nomor") || inuserreg.getText().equals("Username") || inpassreg.getText().equals("Password")){
            JOptionPane.showMessageDialog(null, "ISI SEMUA");
        }else{        
        String namauser = innamalengkap.getText();
        String alamatuser =inalamat.getText();
        String nomoruser = innomor.getText();
        String username = inuserreg.getText();
        String pass = inpassreg.getText();
        
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/uas_java_database";
            String user = "root";
            String password = "";
            PreparedStatement pst;

            Connection conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement("INSERT INTO `tb_pengguna`(`username`, `pass_user`, `nama_user`, `nomor_user`, `alamat_user`) VALUES (?,?,?,?,?)");
            pst.setString(1, username);
            pst.setString(2, pass);
            pst.setString(3, namauser);
            pst.setString(4, nomoruser);
            pst.setString(5, alamatuser);
            
            int k = pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(null, "Silahkan Login" ,"Berhasil Daftar", JOptionPane.PLAIN_MESSAGE);
                BuatTablePengguna();
                RegPanel.setVisible(false);
                LogPanel.setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }}
    }//GEN-LAST:event_btnregActionPerformed

    private void btnoutuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoutuserActionPerformed
        // TODO add your handling code here:
        TabPengguna.setVisible(false);
        LogPanel.setVisible(true);
    }//GEN-LAST:event_btnoutuserActionPerformed

    private void tbpenggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpenggunaMouseClicked
        // TODO add your handling code here:
        String username = tbpengguna.getValueAt(tbpengguna.getSelectedRow(), 0).toString();
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/uas_java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT username, pass_user FROM tb_pengguna WHERE username = '" + username + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery(query);
            if (rs.next()) {
                inuseredit.setText(rs.getString("username"));
                inpassedit.setText(rs.getString("pass_user"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tbpenggunaMouseClicked

    private void btneditadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditadminActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel)tbpengguna.getModel();
        String username = tbpengguna.getValueAt(tbpengguna.getSelectedRow(), 0).toString();
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/uas_java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM tb_pengguna WHERE username = '" + username + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.execute("UPDATE `tb_pengguna` SET `username`='" + inuseredit.getText() + "',`pass_user`='" + inpassedit.getText() + "' WHERE username = '" + username + "'");
            int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataPengguna();
            inuseredit.setText("");
            inpassedit.setText("");
                
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneditadminActionPerformed

    private void btndeladminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeladminActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel)tbpengguna.getModel();
        String username = tbpengguna.getValueAt(tbpengguna.getSelectedRow(), 0).toString();
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/uas_java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM tb_pengguna WHERE username = '" + username + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            int k = pstmt.executeUpdate();
            if(k == 1){
                JOptionPane.showMessageDialog(null, "Sudah Terhapus", "Berhasil" ,JOptionPane.PLAIN_MESSAGE);
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataPengguna();
                inuseredit.setText("");
                inpassedit.setText("");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btndeladminActionPerformed

    private void btnlogdisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogdisActionPerformed
        // TODO add your handling code here:
        RegPanel.setVisible(false);
        LogPanel.setVisible(true);
    }//GEN-LAST:event_btnlogdisActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogPanel;
    private javax.swing.JPanel Parent;
    private javax.swing.JPanel RegPanel;
    private javax.swing.JTabbedPane TabAdmin;
    private javax.swing.JTabbedPane TabPengguna;
    private javax.swing.JButton btnaddoufit;
    private javax.swing.JButton btnaddpakaian;
    private javax.swing.JButton btndeladmin;
    private javax.swing.JButton btndeloutfit;
    private javax.swing.JButton btndelpakaian;
    private javax.swing.JButton btneditadmin;
    private javax.swing.JButton btneditoutfit;
    private javax.swing.JButton btneditpakaian;
    private javax.swing.JButton btnlogdis;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnoutadmin;
    private javax.swing.JButton btnoutuser;
    private javax.swing.JButton btnreg;
    private javax.swing.JButton btnregdis;
    private javax.swing.JTextField inalamat;
    private javax.swing.JTextField innamalengkap;
    private javax.swing.JTextField innamaoutfit;
    private javax.swing.JTextField innomor;
    private javax.swing.JTextField inpakaian;
    private javax.swing.JTextField inpassedit;
    private javax.swing.JTextField inpassreg;
    private javax.swing.JPasswordField inpassword;
    private javax.swing.JTextField inuseredit;
    private javax.swing.JTextField inusername;
    private javax.swing.JTextField inuserreg;
    private javax.swing.JTextField inwarna;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbadmin;
    private javax.swing.JTable tboutfit;
    private javax.swing.JTable tbpakaian;
    private javax.swing.JTable tbpengguna;
    // End of variables declaration//GEN-END:variables
}
