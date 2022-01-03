/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PheDuyet;

import ConnectSQL.ConnectSQL;
import InforSQL.GiangVien;
import InforSQL.PheDuyet;
import InforSQL.SinhVien;
import InforSQL.ThongTinLop;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
/**
 *
 * @author ADMIN
 */
public class SqlDuyet {
    public void GuiDon(PheDuyet pd)
    {
        
        String selectIf = "insert into pheduyet(chucvu_ng,maso_ng,doituong,chucvu_nn,maso_nn,noidungyc,mayeucau ,thoigiangui ,malop ,dongy) values(?,?,?,?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, pd.getChucvu_ng());
            stm.setInt(2, pd.getMaso_ng());
            stm.setInt(3,Integer.parseInt(pd.getDoituong()));
            stm.setString(4,pd.getChucvu_nn());
            stm.setInt(5, pd.getMaso_nn());
            stm.setString(6,pd.getNoidungyc());
            stm.setString(7,pd.getMayc());
            stm.setTimestamp(8, pd.getThoigiangui());
            stm.setString(9, pd.getMalop());
            stm.setString(10,pd.getDongY_N());
            stm.executeLargeUpdate();
             
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
    }
    public List<PheDuyet> ThongKeDonGVT(String s1, int s2)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "select * from pheduyet where chucvu_ng= ? and maso_ng = ? and dongy = 'C'";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, s1);
            stm.setInt(2, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                PheDuyet pd = new PheDuyet();
                pd.setChucvu_ng(s1);
                pd.setMaso_ng(s2);
                pd.setDoituong(rs.getString("doituong"));
                pd.setMayc(rs.getString("mayeucau"));
                pd.setNoidungyc(rs.getString("noidungyc"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setMalop(rs.getString("malop"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
     public List<PheDuyet> ThongKeDonCD(String s1, int s2)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "select * from pheduyet where chucvu_nn= ? and maso_nn = ? and dongy = 'C'";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, s1);
            stm.setInt(2, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                PheDuyet pd = new PheDuyet();
                pd.setChucvu_ng(s1);
                pd.setMaso_ng(s2);
                pd.setDoituong(rs.getString("doituong"));
                pd.setMayc(rs.getString("mayeucau"));
                pd.setNoidungyc(rs.getString("noidungyc"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setMalop(rs.getString("malop"));
                pd.setChucvu_ng(rs.getString("chucvu_ng"));
                pd.setChucvu_ng(rs.getString("chucvu_ng"));
                pd.setMaso_ng(rs.getInt("maso_ng"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
     public List<PheDuyet> ThongKeDonDD(String s1, int s2)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "select * from pheduyet where chucvu_nn= ? and maso_nn = ? and (dongy = 'Y' or dongy ='N')";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, s1);
            stm.setInt(2, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                PheDuyet pd = new PheDuyet();
                pd.setChucvu_ng(rs.getString("chucvu_ng"));
                pd.setMaso_ng(rs.getInt("maso_ng"));
                pd.setDoituong(rs.getString("doituong"));
                pd.setMayc(rs.getString("mayeucau"));
                pd.setNoidungyc(rs.getString("noidungyc"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setMalop(rs.getString("malop"));
                pd.setDongY_N(rs.getString("dongy"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
     public void Tuchoi(PheDuyet pd)
    {
        
        String selectIf = "update pheduyet set dongy = 'N', thoigianduyet=? where chucvu_ng =? and maso_ng=? and thoigiangui = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setTimestamp(1,pd.getThoigianduyet());
            stm.setString(2, pd.getChucvu_ng());
            stm.setInt(3, pd.getMaso_ng());
            stm.setTimestamp(4, pd.getThoigiangui());
            stm.executeUpdate();
          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
    }
     public void DongY(PheDuyet pd)
    {
        
        String selectIf = "update pheduyet set dongy = 'Y', thoigianduyet=? where chucvu_ng =? and maso_ng=? and thoigiangui = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setTimestamp(1,pd.getThoigianduyet());
            stm.setString(2, pd.getChucvu_ng());
            stm.setInt(3, pd.getMaso_ng());
            stm.setTimestamp(4, pd.getThoigiangui());
            stm.executeUpdate();
          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        String selectIf2 = "select malop,doituong from pheduyet where chucvu_ng=? and maso_ng=? and thoigiangui=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf2);
            stm.setString(1, pd.getChucvu_ng());
            stm.setInt(2, pd.getMaso_ng());
            stm.setTimestamp(3, pd.getThoigiangui());
            ResultSet rs = stm.executeQuery();
            rs.next();
            pd.setMalop(rs.getString("malop"));
            pd.setDoituong(String.valueOf(rs.getInt("doituong")));
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String selectIf3 = "update thong_ke_lop set magv = ? where idlop=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf3);
            stm.setInt(1, Integer.parseInt(pd.getDoituong()));
            stm.setString(2, pd.getMalop());
            stm.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return;
    }
     public List<PheDuyet> ThongKeDonSV(String s1, int s2)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "select * from pheduyet where chucvu_ng= ? and maso_ng = ? and dongy = 'C' order by thoigiangui desc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, s1);
            stm.setInt(2, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                PheDuyet pd = new PheDuyet();
                pd.setChucvu_ng(s1);
                pd.setMaso_ng(s2);
                pd.setDoituong(rs.getString("doituong"));
                pd.setMayc(rs.getString("mayeucau"));
                pd.setNoidungyc(rs.getString("noidungyc"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setMalop(rs.getString("malop"));
                pd.setMaso_nn(rs.getInt("maso_nn"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
         public List<PheDuyet> ThongKeDonSVDD(String s1, int s2)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "select * from pheduyet where chucvu_ng= ? and maso_ng = ? and dongy != 'C' order by thoigiangui desc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, s1);
            stm.setInt(2, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                PheDuyet pd = new PheDuyet();
                pd.setChucvu_ng(s1);
                pd.setMaso_ng(s2);
                pd.setDoituong(rs.getString("doituong"));
                pd.setMayc(rs.getString("mayeucau"));
                pd.setNoidungyc(rs.getString("noidungyc"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setThoigianduyet(rs.getTimestamp("thoigianduyet"));
                pd.setMalop(rs.getString("malop"));
                pd.setMaso_nn(rs.getInt("maso_nn"));
                pd.setDongY_N(rs.getString("dongy"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
         public List<PheDuyet> ThongKeDonGVTDD( int s2)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "select * from pheduyet where (chucvu_ng='GVT' or chucvu_ng='GV') and maso_ng = ? and dongy != 'C' order by thoigiangui desc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                PheDuyet pd = new PheDuyet();
                pd.setChucvu_ng("GVT");
                pd.setMaso_ng(s2);
                pd.setDoituong(rs.getString("doituong"));
                pd.setMayc(rs.getString("mayeucau"));
                pd.setNoidungyc(rs.getString("noidungyc"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setThoigianduyet(rs.getTimestamp("thoigianduyet"));
                pd.setMalop(rs.getString("malop"));
                pd.setMaso_nn(rs.getInt("maso_nn"));
                pd.setDongY_N(rs.getString("dongy"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
          public List<PheDuyet> ThongKeDonGVTCDSV( int s2)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "select * from pheduyet where (chucvu_nn='GVT' or chucvu_nn='GV') and maso_nn = ? and dongy = 'C' order by thoigiangui desc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                PheDuyet pd = new PheDuyet();
                pd.setChucvu_nn("GVT");
                pd.setMaso_ng(rs.getInt("maso_ng"));
                pd.setDoituong(rs.getString("doituong"));
                pd.setMayc(rs.getString("mayeucau"));
                pd.setNoidungyc(rs.getString("noidungyc"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setThoigianduyet(rs.getTimestamp("thoigianduyet"));
                pd.setMalop(rs.getString("malop"));
                pd.setMaso_nn(rs.getInt("maso_nn"));
                pd.setDongY_N(rs.getString("dongy"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
          public void DuyetDonPK( PheDuyet pd,String x)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "update pheduyet set thoigianduyet =?,dongy=? where  chucvu_ng='SV' and maso_ng=? and doituong =? and (chucvu_nn='GV' or chucvu_nn='GVT') and maso_nn=? and malop=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setTimestamp(1, pd.getThoigianduyet());
            stm.setString(2, x);
           
            stm.setInt(3, pd.getMaso_ng());
            stm.setInt(4,Integer.parseInt( pd.getDoituong()));
            stm.setInt(5, pd.getMaso_nn());
            stm.setString(6, pd.getMalop());
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
    }
           public List<PheDuyet> ThongKeDonPKDD( int s2)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "select * from pheduyet where (chucvu_nn='GVT' or chucvu_nn='GV') and maso_nn = ? and dongy != 'C' order by thoigiangui desc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                PheDuyet pd = new PheDuyet();
                pd.setChucvu_nn("GVT");
                pd.setMaso_ng(rs.getInt("maso_ng"));
                pd.setDoituong(rs.getString("doituong"));
                pd.setMayc(rs.getString("mayeucau"));
                pd.setNoidungyc(rs.getString("noidungyc"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setThoigianduyet(rs.getTimestamp("thoigianduyet"));
                pd.setMalop(rs.getString("malop"));
                pd.setMaso_nn(rs.getInt("maso_nn"));
                pd.setDongY_N(rs.getString("dongy"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
         
}

