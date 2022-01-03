/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author ADMIN
 */
import ConnectSQL.ConnectSQL;
import InforSQL.GiangVien;
import InforSQL.SinhVien;
import InforSQL.ThongTinLop;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
public class User {
    public List<SinhVien> getALLSV()
    {
         List<SinhVien> SV = new ArrayList<SinhVien>();
         try {
            Statement sta = ConnectSQL.getConnection().createStatement();
            String sql = "select * from SinhVien order by idsv asc";
            ResultSet rs = sta.executeQuery(sql);
            while(rs.next())
            {
                 SinhVien sv = new SinhVien();
                 sv.setIDSV(rs.getString("IDSV"));
                 sv.setName(rs.getString("Name"));
                 sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                 sv.setDiaChi(rs.getString("DiaChi"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setMaKhoa(rs.getString("MaKhoa"));
                 sv.setNgaysinh(rs.getString("ngaysinh"));
                 sv.setAnh(rs.getString("anh"));
                 SV.add(sv);
                 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV;
    }
    public List<SinhVien> getInf(String str)
    {
         List<SinhVien> SV = new ArrayList<SinhVien>();
         String tim = "%"+str+"%";
        String selectIf = "SELECT * from SINHVIEN WHERE CAST (sinhvien.idsv AS varchar(10)) like ? or Name like ? order by idsv asc ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, tim);
            stm.setString(2, tim);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                 SinhVien sv = new SinhVien();
                 sv.setIDSV(rs.getString("IDSV"));
                 sv.setName(rs.getString("Name"));
                 sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                 sv.setDiaChi(rs.getString("DiaChi"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setMaKhoa(rs.getString("MaKhoa"));
                 sv.setNgaysinh(rs.getString("ngaysinh"));
                 sv.setAnh(rs.getString("anh"));
                 
                 SV.add(sv);
                 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV;
    }
    public void getInfOne(SinhVien sv)
    {
        
        String selectIf = "SELECT * from SINHVIEN WHERE IDSV = ? ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(sv.getIDSV()));
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                
                 sv.setName(rs.getString("Name"));
                 sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                 sv.setDiaChi(rs.getString("DiaChi"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setMaKhoa(rs.getString("MaKhoa"));
                 sv.setNgaysinh(rs.getString("ngaysinh"));
                 sv.setAnh(rs.getString("anh"));
                 
                
                 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
    }
     
     public void getInfOneGV(GiangVien gv)
    {
        
        String selectIf = "SELECT * from GIANGVIEN WHERE IDGV = ? ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(gv.getIDGV()));
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                
                 gv.setNameGV(rs.getString("NameGV"));
                 gv.setGioiTinh(rs.getBoolean("GioiTinh"));
                 gv.setDiaChi(rs.getString("DiaChi"));
                 gv.setEmail(rs.getString("Email"));
                 gv.setMaKhoa(rs.getString("MaKhoa"));
                 gv.setNgaysinh(rs.getString("ngaysinh"));
                 gv.setAnh(rs.getString("anh"));
                 
                
                 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
    }
     public void getKhoa(List<String> str)
     {
          String selectIf = "SELECT * from KHOA ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                String st= new String();
                st = rs.getString("makhoa");
               str.add(st);
                 
             }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
     public void updateTT(String []str,int n,Date d)
     {
          String selectIf = "update sinhvien set name=?, ngaysinh=?, diachi=?,makhoa=?,email=?,gioitinh=? where idsv = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str[2]);
            stm.setDate(2,d);
            stm.setString(3, str[3]);
            stm.setString(4, str[6]);
            stm.setString(5, str[4]);
            stm.setInt(6, n);
            stm.setInt(7, Integer.parseInt(str[1]));
            stm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
     public void deleteTT (String str)
     {
         
          String select2 ="delete from sinhvien where sinhvien.idsv = ?";

        try
        {
           
            PreparedStatement stm2 = ConnectSQL.getConnection().prepareStatement(select2);
          
           
            stm2.setInt(1, Integer.parseInt(str));
          
            
           
            stm2.executeUpdate();
          
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
      public int getNumber()
     {
          String selectIf = "SELECT max(sinhvien.idsv) from SINHVIEN ";
          int n=0;
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            ResultSet rs = stm.executeQuery();
            rs.next();
            n = rs.getInt("max");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
     }
      public void InsertTT(String []str,int n,Date d)
     {
          String selectIf = "Insert into SinhVien (name, ngaysinh, diachi, makhoa,email,gioitinh,anh,idsv,pass,account) values (?,?,?,?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str[2]);
            stm.setDate(2,d);
            stm.setString(3, str[3]);
            stm.setString(4, str[6]);
            stm.setString(5, str[4]);
            stm.setInt(6, n);
            stm.setString(7, str[7]);
            stm.setInt(8, Integer.parseInt(str[1]));
            int m = Integer.parseInt(str[1]);
            stm.setString(9, "acount"+m);
            stm.setString(10, "pass"+m);
            
            stm.executeLargeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
     public List<GiangVien> getALLGV()
    {
         List<GiangVien> SV = new ArrayList<GiangVien>();
         try {
            Statement sta = ConnectSQL.getConnection().createStatement();
            String sql = "select * from Giangvien order by idgv asc";
            ResultSet rs = sta.executeQuery(sql);
            while(rs.next())
            {
                 GiangVien sv = new GiangVien();
                 sv.setIDGV(rs.getString("IDGV"));
                 sv.setNameGV(rs.getString("NameGV"));
                 sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                 sv.setDiaChi(rs.getString("DiaChi"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setMaKhoa(rs.getString("MaKhoa"));
                 sv.setNgaysinh(rs.getString("ngaysinh"));
                 SV.add(sv);
                 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV;
    }
     public List<GiangVien> getInfGV(String str)
    {
         List<GiangVien> SV = new ArrayList<GiangVien>();
         String tim = "%"+str+"%";
        String selectIf = "SELECT * from GIANGVIEN WHERE  CAST (idgv AS varchar(10))like ? or NameGV like ? order by idgv asc ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, tim);
            stm.setString(2, tim);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                 GiangVien sv = new GiangVien();
                 sv.setIDGV(rs.getString("IDGV"));
                 sv.setNameGV(rs.getString("NameGV"));
                 sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                 sv.setDiaChi(rs.getString("DiaChi"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setMaKhoa(rs.getString("MaKhoa"));
                 sv.setNgaysinh(rs.getString("ngaysinh"));
                 
                 SV.add(sv);
                 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV;
    }
     public int getNumberGV()
     {
          String selectIf = "SELECT max(giangvien.idgv) from Giangvien ";
          int n=0;
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            ResultSet rs = stm.executeQuery();
            rs.next();
            n = rs.getInt("max");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
     }
     public void InsertTTGV(String []str,int n,Date d)
     {
          String selectIf = "Insert into GiangVien (namegv, ngaysinh, diachi, makhoa,email,gioitinh,anh,pass,account) values (?,?,?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str[2]);
            stm.setDate(2,d);
            stm.setString(3, str[3]);
            stm.setString(4, str[6]);
            stm.setString(5, str[4]);
            stm.setInt(6, n);
            stm.setString(7, str[7]);
          //  stm.setInt(8, Integer.parseInt(str[1]));
            int m = Integer.parseInt(str[1]);
            stm.setString(8, "pass"+m);
            stm.setString(9, "acc"+m);
            stm.executeLargeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
    public void deleteTTGv (String str)
     {
         
          String select2 ="delete from giangvien where giangvien.idgv = ?";
          
        try
        {
           
            PreparedStatement stm2 = ConnectSQL.getConnection().prepareStatement(select2);
         
            
            stm2.setInt(1, Integer.parseInt(str));
        
            
          
            stm2.executeUpdate();
          
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
    public void updateTTGV(String []str,int n,Date d)
     {
          String selectIf = "update giangvien set namegv=?, ngaysinh=?, diachi=?,makhoa=?,email=?,gioitinh=? where idgv = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str[2]);
            stm.setDate(2,d);
            stm.setString(3, str[3]);
            stm.setString(4, str[6]);
            stm.setString(5, str[4]);
            stm.setInt(6, n);
            stm.setInt(7, Integer.parseInt(str[1]));
            stm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
    public void updateAnhSV(String str,String str2)
     {
          String selectIf = "update sinhvien set anh=? where idsv = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            stm.setInt(2, Integer.parseInt(str2));
            stm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
    public void updateAnhGV(String str,String str2)
     {
          String selectIf = "update giangvien set anh=? where idgv = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            stm.setInt(2, Integer.parseInt(str2));
            stm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ;
     }
     public List<GiangVien> GvKhoa(String str)
    {
         List<GiangVien> SV = new ArrayList<GiangVien>();
        String selectIf = "select * from giangvien where giangvien.makhoa =? order by idgv asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                 GiangVien sv = new GiangVien();
                 sv.setIDGV(rs.getString("IDGV"));
                 sv.setNameGV(rs.getString("NameGV"));
                 sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                 sv.setDiaChi(rs.getString("DiaChi"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setMaKhoa(rs.getString("MaKhoa"));
                 sv.setNgaysinh(rs.getString("ngaysinh"));
                 
                 SV.add(sv);
                 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV;
    }
     public List<GiangVien> GvThayThe(ThongTinLop tt,String str)
    {
         List<GiangVien> SV = new ArrayList<GiangVien>();
        String selectIf = "select * from giangvien where giangvien.makhoa =? and not exists(select * from thong_ke_lop inner join ttlop using(idlop) where thong_ke_lop.magv = giangvien.idgv and ((ttlop.thu=? and ttlop.giomd >= ? and ? >= ttlop.giomd ) or (ttlop.thu=? and ? >= ttlop.giomd and ttlop.giokt >= ?) ))";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            stm.setInt(2, tt.getThu());
            stm.setTime(3, tt.getGioMD());
            stm.setTime(4, tt.getGioKT());
            stm.setInt(5, tt.getThu());
            stm.setTime(6, tt.getGioMD());
            stm.setTime(7, tt.getGioMD());
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                 GiangVien sv = new GiangVien();
                 sv.setIDGV(rs.getString("IDGV"));
                 sv.setNameGV(rs.getString("NameGV"));
                 sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                 sv.setDiaChi(rs.getString("DiaChi"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setMaKhoa(rs.getString("MaKhoa"));
                 sv.setNgaysinh(rs.getString("ngaysinh"));
                 
                 SV.add(sv);
                 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return SV;
    }
}
