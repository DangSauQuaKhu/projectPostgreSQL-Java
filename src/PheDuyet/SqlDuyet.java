/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PheDuyet;

import ConnectSQL.ConnectSQL;
import InforSQL.DoiGV;
import InforSQL.DonPK;
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
    public void GuiDon(DoiGV pd)
    {
        
        String selectIf = "insert into DONdoiGV values(?,?,?,?,?)";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setTimestamp(1, pd.getThoigiangui());
            stm.setString(2, pd.getIdlop());
            stm.setInt(3,pd.getIdgv());
            stm.setString(4,pd.getDongy());
            stm.setString(5,pd.getLido());
            stm.executeLargeUpdate();
             
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
    }
    public List<DoiGV> ThongKeDonGVT(String s1)
    {
        List<DoiGV> PD = new ArrayList<DoiGV>();
        String selectIf = "select * from dondoigv where idlop in (select idlop from lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH natural join hocphan where makhoa=?) and dongy='C' order by thoigiangui asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, s1);
            
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                DoiGV pd = new DoiGV();
                pd.setDongy(rs.getString("dongy"));
                pd.setLido(rs.getString("lido"));
                pd.setIdgv(rs.getInt("idgv"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setIdlop(rs.getString("idlop"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
     public List<DoiGV> ThongKeDonCD()
    {
        List<DoiGV> PD = new ArrayList<DoiGV>();
        String selectIf = "select * from dondoigv natural join (select idlop,magvt from lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH natural join hocphan natural join khoa ) MN where dongy='C' order by thoigiangui asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
           
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                DoiGV pd = new DoiGV();
                pd.setDongy(rs.getString("dongy"));
                pd.setLido(rs.getString("lido"));
                pd.setIdgv(rs.getInt("idgv"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setIdlop(rs.getString("idlop"));
                pd.setNg(rs.getInt("magvt"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
        
    }
     public List<DoiGV> ThongKeDonDD()
    {
       List<DoiGV> PD = new ArrayList<DoiGV>();
        String selectIf = "select * from dondoigv natural join (select idlop,magvt from lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH natural join hocphan natural join khoa ) MN where dongy!='C' order by thoigiangui asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
           
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                DoiGV pd = new DoiGV();
                pd.setDongy(rs.getString("dongy"));
                pd.setLido(rs.getString("lido"));
                pd.setIdgv(rs.getInt("idgv"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setIdlop(rs.getString("idlop"));
                pd.setNg(rs.getInt("magvt"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
      public List<DoiGV> ThongKeDonDDGVT(String s1)
    {
       List<DoiGV> PD = new ArrayList<DoiGV>();
        String selectIf = "select * from dondoigv natural join (select idlop,magvt from lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH natural join hocphan natural join khoa where makhoa=?) MN where dongy!='C' order by thoigiangui asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, s1);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                DoiGV pd = new DoiGV();
                pd.setDongy(rs.getString("dongy"));
                pd.setLido(rs.getString("lido"));
                pd.setIdgv(rs.getInt("idgv"));
                pd.setThoigiangui(rs.getTimestamp("thoigiangui"));
                pd.setIdlop(rs.getString("idlop"));
                pd.setNg(rs.getInt("magvt"));
               
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
     public void Tuchoi(DoiGV pd)
    {
        
        String selectIf = "update dondoigv set dongy = 'N' where idlop=? and thoigiangui = ? ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,pd.getIdlop());
            stm.setTimestamp(2, pd.getThoigiangui());
           stm.executeUpdate();
          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
    }
     public void DongY(DoiGV pd)
    {
        
        String selectIf = "update dondoigv set dongy = 'Y' where idlop=? and thoigiangui = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
             stm.setString(1,pd.getIdlop());
            stm.setTimestamp(2, pd.getThoigiangui());
            stm.executeUpdate();
          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        String selectIf2 = "select idgv from dondoigv where  thoigiangui=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf2);
            
            stm.setTimestamp(1, pd.getThoigiangui());
            ResultSet rs = stm.executeQuery();
            rs.next();
           
            pd.setIdgv(rs.getInt("idgv"));
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String selectIf3 = "update lop set idgv = ? where idlop=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf3);
            stm.setInt(1, pd.getIdgv());
            stm.setString(2, pd.getIdlop());
            stm.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return;
    }
     public List<DonPK> ThongKeDonSV(String s1)
    {
        List<DonPK> PD = new ArrayList<DonPK>();
        String selectIf = "select * from Donphuckhao where trangthaiduyet = 'C' and idsv=?  ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(s1));
            
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                DonPK pd = new DonPK();
                pd.setIdlop(rs.getString("idlop"));
                pd.setIdsv(rs.getInt("idsv"));
                pd.setLoaidiem(rs.getString("loaidiem"));
                pd.setDiem_sauPK(rs.getFloat("diem_sauPK"));
                pd.setDiem_truocPK(rs.getFloat("diem_truocPK"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
     public List<DonPK> ThongKeDonSVDD(String s1)
    {
        List<DonPK> PD = new ArrayList<DonPK>();
        String selectIf = "select * from Donphuckhao where trangthaiduyet != 'C' and idsv=?  ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(s1));
            
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                DonPK pd = new DonPK();
                pd.setIdlop(rs.getString("idlop"));
                pd.setIdsv(rs.getInt("idsv"));
                pd.setLoaidiem(rs.getString("loaidiem"));
                pd.setDiem_sauPK(rs.getFloat("diem_sauPK"));
                pd.setDiem_truocPK(rs.getFloat("diem_truocPK"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
     
     
         public  void GuidonPK(DonPK pd)
    {
        String selectIf = "insert into donphuckhao(idsv,idlop,loaidiem,diem_truocPK,trangthaiduyet) values(?,?,?,?,?)";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, pd.getIdsv());
            stm.setString(2, pd.getIdlop());
            stm.setString(3,pd.getLoaidiem());
            stm.setFloat(4, pd.getDiem_truocPK());
            stm.setString(5, pd.getTrangthaiduyet());
            stm.executeUpdate();
            
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
         
         public List<DonPK> ThongKeDonGVTDD( int s2)
    {
        List<DonPK> PD = new ArrayList<DonPK>();
        String selectIf = "select * from Donphuckhao natural join lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) N where trangthaiduyet != 'C' and idgv=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                 DonPK pd = new DonPK();
                pd.setIdlop(rs.getString("idlop"));
                pd.setIdsv(rs.getInt("idsv"));
                pd.setLoaidiem(rs.getString("loaidiem"));
                pd.setDiem_sauPK(rs.getFloat("diem_sauPK"));
                pd.setDiem_truocPK(rs.getFloat("diem_truocPK"));
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PD ;
    }
          public List<DonPK> ThongKeDonGVTCDSV( int s2)
    {
        List<DonPK> PD = new ArrayList<DonPK>();
        String selectIf = "select * from Donphuckhao natural join lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) N where trangthaiduyet = 'C' and idgv=?  ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, s2);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                DonPK pd = new DonPK();
                
                pd.setIdlop(rs.getString("idlop"));
                pd.setIdsv(rs.getInt("idsv"));
                pd.setLoaidiem(rs.getString("loaidiem"));
                pd.setDiem_sauPK(rs.getFloat("diem_sauPK"));
                pd.setDiem_truocPK(rs.getFloat("diem_truocPK"));
         
                PD.add(pd);
          
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return PD ;
    }
          public void DuyetDonPK( DonPK pd)
    {
        List<PheDuyet> PD = new ArrayList<PheDuyet>();
        String selectIf = "update DonPhucKhao set trangthaiduyet=?,diem_sauPK =? where  idlop=? and idsv=? and loaidiem=? ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, pd.getTrangthaiduyet());
            stm.setFloat(2, pd.getDiem_sauPK());
           
            stm.setInt(4, pd.getIdsv());
           
            stm.setString(3, pd.getIdlop());
            stm.setString(5, pd.getLoaidiem());
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
    }
          
           public int HanChe( String s)
    {
       int n =0;
        String selectIf = "select count(*) from dondoigv where idlop =? and dongy ='C'";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, s);
            ResultSet rs = stm.executeQuery();
           rs.next();
           n = rs.getInt("count");
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n ;
    }
         
}

