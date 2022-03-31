/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import IOfile.IO;
import InforSQL.DDanh;
import InforSQL.SinhVien;
import InforSQL.ThongTinLop;
import LopInf.LopInf;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class QuanLop extends javax.swing.JFrame {

    /**
     * Creates new form QuanLop
     */
    int d=0,n=0;
    IO w = new IO();
    ThongTinLop lop = new ThongTinLop();
    SinhVien sv = new SinhVien();
     LopInf lopInf;
     int Chon = 0;
     
    public QuanLop() {
        initComponents();
        this.setLocationRelativeTo(null);
        lopInf = new LopInf();
        ImageIcon icon = new ImageIcon("src/Anhdd/logo.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        jLabel3.setIcon(scaleIcon);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jTextField1.setVisible(false);
        jLabel4.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jTable1.getTableHeader().setDefaultRenderer(new GVInf.HeaderColor());
        w.readFileLop(lop);
        label1.setText("LỚP "+lop.getIDLop());
        jLabel3.setText(lop.getIDLop());
        
       md danhsach = new md();
        table tb = new table();
        
        
      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, 366));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ĐIỂM DANH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 140, 100, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("NHẬP ĐIỂM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 110, 100, -1));

        jButton3.setBackground(new java.awt.Color(255, 153, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("SỬA ĐIỂM");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 170, 100, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("QUÁ TRÌNH");
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 93, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("CUỐI KÌ      ");
        jRadioButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 90, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 150, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("Nhập tên ( Hoặc MSSV )");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("TÌM KIẾM");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 93, -1));

        jButton6.setBackground(new java.awt.Color(255, 51, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("DANH SÁCH");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 100, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 153, 255));
        jPanel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("CHỌN CHỨC NĂNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 215, 327, 371));

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setForeground(new java.awt.Color(0, 0, 204));
        jButton5.setText("Lưu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 643, 73, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 122, 824, 10));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(204, 255, 255));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 0, 51));
        label1.setText("label1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 143, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 201, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(Chon==0)
        {
        List<SinhVien> SV = new ArrayList<SinhVien>();
        int rown= jTable1.getRowCount();
        for(int i =0; i< rown; i++)
        {
            SinhVien sv = new SinhVien();
            sv.setIDSV(jTable1.getValueAt(i, 1).toString());
            if(jTable1.getValueAt(i, 3).toString().length()==0) sv.setDGK(-1);
            else
            sv.setDGK(Double.parseDouble(jTable1.getValueAt(i, 3).toString()));
            if(jTable1.getValueAt(i, 4).toString().length()==0) sv.setDCK(-1);
            else
            sv.setDCK(Double.parseDouble(jTable1.getValueAt(i, 5).toString()));
            SV.add(sv);
        }
       
            lopInf.insertdiem(SV, lop);
            
        
        
        model a = new model(5);
        
         DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        TableModel tableModel = jTable1.getModel();
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        }
        else
        {
            int rown= jTable1.getRowCount();
             List<SinhVien> SV = new ArrayList<SinhVien>();
        for(int i =0; i< rown; i++)
        {
            if((Boolean)jTable1.getValueAt(i,3)==true) 
            {
                
                SinhVien svien = new SinhVien();
                svien.setIDSV(jTable1.getValueAt(i, 1).toString());
              //  label1.setText(label1.getText() + jTable1.getValueAt(i, 1).toString());
                SV.add(svien);
                
            }
        }
        lopInf.DDNGhi(SV,lop.getIDLop());
        tableDD tb = new tableDD();
        
        }
        
        

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        md m = new md();
      
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jTextField1.setVisible(false);
        jLabel4.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String text = jTextField1.getText();
        jButton5.setVisible(true);
        Chon =0;

        DefaultTableModel defaultb=new DefaultTableModel()
        {

            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==2||column==3) return true;
                return false;
            }

        };
        int stt=1;
        jTable1.setModel(defaultb);
        defaultb.addColumn("STT");
        defaultb.addColumn("MSSV");
        defaultb.addColumn("Tên Sinh Viên");
        defaultb.addColumn("Điểm Quá Trình");
        defaultb.addColumn("Điểm cuối kì");
        List<SinhVien> mclass= lopInf.getSVGK(lop.getIDLop(),text);
        for(SinhVien tt : mclass)
        {
            String ck, gk;
            if(tt.getDCK()==-1) ck=""; else ck = ""+tt.getDCK();
            if(tt.getDGK()==-1) gk ="";else gk = ""+tt.getDGK();
            if(tt.getDCK()!= -1 && tt.getDGK()!=-1)
            {

                defaultb.addRow(new Object[]{stt,tt.getIDSV(),tt.getName(),tt.getDGK(),tt.getDCK() });
            }
            else
            defaultb.addRow(new Object[]{stt,tt.getIDSV(),tt.getName(),gk,ck,""});
            stt++;

        }
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        TableModel tableModel = jTable1.getModel();
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jButton5.setVisible(true);
        Chon =0;
        model a = new model (4);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        TableModel tableModel = jTable1.getModel();
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jButton5.setVisible(true);
        Chon =0;
        model a = new model (3);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        TableModel tableModel = jTable1.getModel();
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        jTextField1.setVisible(true);
        jLabel4.setVisible(true);
        jButton4.setVisible(true);
        jTextField1.setText("");
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jButton5.setVisible(false);
        model a = new model (5);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        TableModel tableModel = jTable1.getModel();
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        model a = new model (5);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        TableModel tableModel = jTable1.getModel();
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }

        jRadioButton1.setVisible(true);
        jRadioButton2.setVisible(true);

        jTextField1.setVisible(false);
        jLabel4.setVisible(false);
        jButton4.setVisible(false);
       

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        jTextField1.setVisible(false);
        jLabel4.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(true);
        Chon =1;
        tableDD tb = new tableDD();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLop().setVisible(true);
            }
        });
    }
    public static class HeaderColor extends DefaultTableCellRenderer
    {
        public HeaderColor()
        {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable mytable, Object value,boolean selected,boolean focused,int row,int column)
        {
            super.getTableCellRendererComponent(mytable, value, selected, focused, row, column);
            setBackground(new java.awt.Color(255,51,51));
            setForeground(new java.awt.Color(255,255,255));
            return this;
        }
        
    }
    public class model
    {
        public model(int m)
        {
            DefaultTableModel defaultb=new DefaultTableModel()
         {
             
                    @Override
    public boolean isCellEditable(int row, int column) {
       if(column==m) return true;
       return false;
    }
         
             
         };
        jTable1.setModel(defaultb);
        int stt=1;
        defaultb.addColumn("STT");
        defaultb.addColumn("MSSV");
        defaultb.addColumn("Tên Sinh Viên");
        defaultb.addColumn("Điểm Quá Trình");
        defaultb.addColumn("Điểm cuối kì");
        List<SinhVien> Mclass= lopInf.getSVLopGK(lop.getIDLop());
        for(SinhVien tt : Mclass)
        {
            String ck, gk;
            if(tt.getDCK()==-1) ck=""; else ck = ""+tt.getDCK();
            if(tt.getDGK()==-1) gk ="";else gk = ""+tt.getDGK();
            if(tt.getDCK()!= -1 && tt.getDGK()!=-1)
            {
                
               defaultb.addRow(new Object[]{stt,tt.getIDSV(),tt.getName(),tt.getDGK(),tt.getDCK() });
            }
            else
            defaultb.addRow(new Object[]{stt,tt.getIDSV(),tt.getName(),gk,ck,""});
            stt++;
           
            
        }
            
        }
    }
    public class md
    {
        public md()
        {
            DefaultTableModel defaultb=new DefaultTableModel();
            defaultb = new DefaultTableModel()
                {
                    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
         
             };
            int stt=1;
        jTable1.setModel(defaultb);
        defaultb.addColumn("STT");
        defaultb.addColumn("MSSV");
        defaultb.addColumn("Tên Sinh Viên");
        defaultb.addColumn("Ngày Sinh");
        List<SinhVien> mclass12= lopInf.getSVLop(lop.getIDLop());
        for(SinhVien tt : mclass12)
        {
            defaultb.addRow(new Object[]{stt,tt.getIDSV(),tt.getName(),tt.getNgaysinh() });
            stt++;
            
        }
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        TableModel tableModel = jTable1.getModel();
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        }
    }
    public class table
    {
        public table()
        {
        
        jTable1.getTableHeader().setDefaultRenderer(new HeaderColor());
         JTableHeader tb3 = jTable1.getTableHeader();
        ((DefaultTableCellRenderer)tb3.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
         
    }
    }
    public class tableDD
    {
        public tableDD()
        {
            jTable1.setModel(new DefaultTableModel());
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount( 0 );
        DefaultTableModel defaultb=new DefaultTableModel();
            defaultb = new DefaultTableModel(new Object[]{"STT","MSSV","Tên Sinh Viên","Tích","Số buổi nghỉ"}, 0)
                {
                   
    

                    @Override
    public boolean isCellEditable(int row, int column) {
      if(column == 3) return true;
              else
       return false;
    
    
    }
   
         
             };
        jTable1.setModel(defaultb);
        JCheckBox check = new JCheckBox();
        int m=1;
        int sb = lopInf.SBDD(lop.getIDLop());
        List<DDanh> mclass12= lopInf.TKDD(lop.getIDLop());
        for(DDanh tt : mclass12)
        {
            defaultb.addRow(new Object[]{m,tt.getIdsv(),tt.getNameSV(),false,tt.getSbv()+"/"+sb });
            m++;
            
        }
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        TableModel tableModel = jTable1.getModel();
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
         TableColumn tc = jTable1.getColumnModel().getColumn(3);
        tc.setCellEditor(jTable1.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(jTable1.getDefaultRenderer(Boolean.class));
        }
    }
                
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
