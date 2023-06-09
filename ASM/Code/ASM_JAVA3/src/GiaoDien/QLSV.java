/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import Data.DatabaseAcc;
import Model.SinhVien;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class QLSV extends javax.swing.JFrame {

    /**
     * Creates new form QLSV
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    SinhVien sinhVien;
    public QLSV() {
        initComponents();
        showTable();
    }
 String ImagePast=null;
    public ImageIcon ResizeImage(String imagePath,byte[] pic){
        ImageIcon myImage = null;
        if(imagePath != null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbimage.getWidth(), lbimage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;   
    }
    public boolean CheckInput(){
        if(txtMaSv.getText()==null || txtHoTen.getText()==null ||txtEmail.getText()==null
                ||checkNam.getText()==null||checkNu.getText()==null||txtDiaChi.getText()==null){
            return false;
        }else{
            try{
                Integer.parseInt(txtSDT.getText());
                return true;
            }catch(Exception E){
                return false;
            }
        }
    }
    //đưa dữ liệu từ sever về để hiễn thị lên table
    public ArrayList<SinhVien> getSinhVienList(){
         ArrayList<SinhVien> sinhViens = new ArrayList<SinhVien>();
            con = DatabaseAcc.getDatabaseAcc();
            String query = "SELECT * FROM SinhVien";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                sinhVien = new SinhVien(rs.getInt("id"), rs.getString("MaSV"), rs.getString("HoTen"),
                        rs.getString("Email"), Integer.parseInt(rs.getString("SDT")), rs.getString("GioTinh"), rs.getString("DiaChi"),rs.getBytes("HinhAnh"));
                sinhViens.add(sinhVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLSV.class.getName()).log(Level.SEVERE, null, ex);
        }
      return sinhViens;
    }
    //hiễn thị lên table
    public void showTable(){
        ArrayList<SinhVien> list = getSinhVienList();
        DefaultTableModel model = (DefaultTableModel) tbhienthi.getModel();
        //clead khi chạy không chồng dữ liệu lên nhau
        model.setRowCount(0);
        Object[] row = new Object[7];
        for(int i =0;i<list.size();i++){
            row[0] = list.get(i).getMaSV();
            row[1] = list.get(i).getHoTen();
            row[2] = list.get(i).getEmail();
            row[3] = list.get(i).getSDT();
            row[4] = list.get(i).getGiotinh();
            row[5] = list.get(i).getDiaChi();
            row[6] = list.get(i).getHinhanh();
            model.addRow(row);
        }
    }
    public void ShowItem(int index){
        txtMaSv.setText(getSinhVienList().get(index).getMaSV());
        txtHoTen.setText(getSinhVienList().get(index).getHoTen());
        txtEmail.setText(getSinhVienList().get(index).getEmail());
         txtSDT.setText(Integer.toString(getSinhVienList().get(index).getSDT()));
       if(tbhienthi.getValueAt(index, 4).equals("Nam")){
           checkNam.setSelected(true);
       }else{
           checkNu.setSelected(true);
       }
          txtDiaChi.setText(getSinhVienList().get(index).getDiaChi());
           lbimage.setIcon(ResizeImage(null,getSinhVienList().get(index).getHinhanh()));
    }
    public void Clean(){
         txtMaSv.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        checkNam.setSelected(false);
        checkNu.setSelected(false);
       txtDiaChi.setText("");
       lbimage.setIcon(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkNam = new javax.swing.JRadioButton();
        checkNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbhienthi = new javax.swing.JTable();
        bntIcon = new javax.swing.JButton();
        bntSave = new javax.swing.JButton();
        bntdetele = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbimage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Sinh Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã SV:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Họ Tên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("SĐT:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Giới Tính:");

        checkNam.setText("Nam");

        checkNu.setText("Nu");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Địa Chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        tbhienthi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ", "Hình Ảnh"
            }
        ));
        tbhienthi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbhienthiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbhienthi);

        bntIcon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btn_add.png"))); // NOI18N
        bntIcon.setText("New");
        bntIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIconActionPerformed(evt);
            }
        });

        bntSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btn_save.png"))); // NOI18N
        bntSave.setText("Save");
        bntSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSaveActionPerformed(evt);
            }
        });

        bntdetele.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntdetele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/btn_delete.png"))); // NOI18N
        bntdetele.setText("Delete");
        bntdetele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntdeteleActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/edit.png"))); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbimage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbimageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbimage, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(checkNam)
                                .addGap(37, 37, 37)
                                .addComponent(checkNu))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtMaSv)
                            .addComponent(txtHoTen)
                            .addComponent(txtEmail))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bntIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bntSave, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bntdetele)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(checkNam)
                            .addComponent(checkNu)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntdetele, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbimageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbimageMouseClicked
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile  = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbimage.setIcon(ResizeImage(path, null));
            ImagePast = path;
        }else{
            JOptionPane.showMessageDialog(this,"Vui lòng chọn hình ảnh");
        }
    }//GEN-LAST:event_lbimageMouseClicked

    private void bntIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIconActionPerformed
        // TODO add your handling code here:
        this.Clean();
       
    }//GEN-LAST:event_bntIconActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(CheckInput() && txtMaSv.getText()!=null){
            String UpString = null;
            pst = null;
              con = DatabaseAcc.getDatabaseAcc();
              if(ImagePast ==null){
                try {
                    UpString = "UPDATE SinhVien SET MaSV = ?,HoTen = ?,Email = ?,SDT = ?,GioTinh = ?,DiaChi = ?"
                            + " WHERE MaSV = ?";
                    pst =con.prepareStatement(UpString);
                     pst.setString(1, txtMaSv.getText());
               pst.setString(2, txtHoTen.getText());
               pst.setString(3, txtEmail.getText());
               pst.setInt(4, Integer.parseInt(txtSDT.getText()));
               if(checkNam.isSelected()){
                    pst.setString(5, checkNam.getText());
               }
               if(checkNu.isSelected()){
                   pst.setString(5, checkNu.getText());
               }
               pst.setString(6, txtDiaChi.getText());
               pst.setString(7, txtMaSv.getText());
               pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                showTable();
                this.Clean();
                } catch (SQLException ex) {
                    Logger.getLogger(QLSV.class.getName()).log(Level.SEVERE, null, ex);
                }
              }else{
                  try{
                  InputStream img = new FileInputStream(new File(ImagePast));
                   UpString = "UPDATE SinhVien SET MaSV = ?,HoTen = ?,Email = ?,SDT = ?,GioTinh = ?,DiaChi = ?,HinhAnh = ?"
                            + " WHERE MaSV = ?";
                    pst =con.prepareStatement(UpString);
                    pst.setString(1, txtMaSv.getText());
               pst.setString(2, txtHoTen.getText());
               pst.setString(3, txtEmail.getText());
               pst.setInt(4, Integer.parseInt(txtSDT.getText()));
               if(checkNam.isSelected()){
                    pst.setString(5, checkNam.getText());
               }
               if(checkNu.isSelected()){
                   pst.setString(5, checkNu.getText());
               }
               pst.setString(6, txtDiaChi.getText());
                pst.setBlob(7, img);
                 pst.setString(8, txtMaSv.getText());
                 pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                this.Clean();
                showTable();
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null, e.getMessage());
              }
             }
        }else{
            JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bntdeteleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntdeteleActionPerformed
        try {
            // TODO add your handling code here:
            con = DatabaseAcc.getDatabaseAcc();
            pst = con.prepareStatement("DELETE FROM SinhVien WHERE MaSV = ?");
             String xoa=JOptionPane.showInputDialog(this, "Nhập Mã NV cần xóa");
            JOptionPane.showMessageDialog(this, xoa);
            pst.setString(1, xoa);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            this.Clean();
            showTable();
        } catch (SQLException ex) {
            Logger.getLogger(QLSV.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Xóa không thành công");
        }
    }//GEN-LAST:event_bntdeteleActionPerformed

    private void tbhienthiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhienthiMouseClicked
        // TODO add your handling code here:
        int index = tbhienthi.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_tbhienthiMouseClicked

    private void bntSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSaveActionPerformed
        // TODO add your handling code here:
         if(CheckInput() && ImagePast != null){
            try{
               con = DatabaseAcc.getDatabaseAcc();
               //lấy dữ liệu bảng từ dattabase
               pst = con.prepareStatement("INSERT INTO SinhVien(MaSV,HoTen,Email,SDT,GioTinh,DiaChi,HinhAnh)"+
                       "values(?,?,?,?,?,?,?)");
               pst.setString(1, txtMaSv.getText());
               pst.setString(2, txtHoTen.getText());
               pst.setString(3, txtEmail.getText());
               pst.setInt(4, Integer.parseInt(txtSDT.getText()));
               if(checkNam.isSelected()){
                    pst.setString(5, checkNam.getText());
               }
               if(checkNu.isSelected()){
                   pst.setString(5, checkNu.getText());
               }
               pst.setString(6, txtDiaChi.getText());
                InputStream img = new FileInputStream(new File(ImagePast));
                pst.setBlob(7, img);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                showTable();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(this, "Thêm không thành công");
        }
    }//GEN-LAST:event_bntSaveActionPerformed

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
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntIcon;
    private javax.swing.JButton bntSave;
    private javax.swing.JButton bntdetele;
    private javax.swing.JRadioButton checkNam;
    private javax.swing.JRadioButton checkNu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbimage;
    private javax.swing.JTable tbhienthi;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSv;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
