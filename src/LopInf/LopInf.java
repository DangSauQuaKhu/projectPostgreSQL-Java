/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LopInf;

import ConnectSQL.ConnectSQL;
import InforSQL.DDanh;
import InforSQL.DiemSV;
import InforSQL.DonPK;
import InforSQL.LichSuHT;
import InforSQL.SinhVien;
import InforSQL.ThongTinLop;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ADMIN
 */
public class LopInf {
     public List<ThongTinLop> getClassInf(String str)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = "select hocphan.mahp,hocphan.tenhp,lop.idlop,giangvien.namegv from lop natural join lop_sv natural join  hocphan natural join giangvien where lop_sv.idsv = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(str));
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                lop.setIDLop(rs.getString("idlop"));
                lop.setNameGV(rs.getString("namegv"));
                LOP.add(lop);
                
             }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
     public List<ThongTinLop> getClassInfNgay(String str)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = "select ttlop.thu, ttlop.giomd ,ttlop.giokt ,ttlop.idlop from lop_sv inner join giohoc ttlop using (idlop) where lop_sv.idsv = ?   order by (ttlop.thu,ttlop.giomd) ASC";
        try
        {
           
                
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(str));
    
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setThu(rs.getInt("thu"));
                lop.setGioMD(rs.getTime("giomd"));
                lop.setGioKT(rs.getTime("giokt"));
                lop.setIDLop(rs.getString("IDLop"));
                LOP.add(lop);
                
             }
              stm.close();
            rs.close();
            
            
             
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
        }
        public List<ThongTinLop> HocPhi(String str)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = "select hp.mahp,hp.tenhp,hp.sotc,hp.tientc,(hp.tientc*hp.sotc) as Tong from lop_SV inner join lop using (idlop) inner join hocphan as hp  using (mahp) where lop_SV.idsv=?";

        try
        {
            
                
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(str));
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                lop.setSoTC(rs.getInt("sotc"));
                lop.setTien(rs.getInt("tientc"));
                lop.setTong(rs.getInt("tong"));
                LOP.add(lop);
                
             }
              stm.close();
            rs.close();
            
             
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
        public void TongHP(SinhVien str)
        {
            String selectIf = "select tonghp,duno,dadong from sinhvien where idsv = ?";
           
             try
        {
            
                
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
              stm.setInt(1, Integer.parseInt(str.getIDSV()));
            ResultSet rs = stm.executeQuery();
            rs.next();
             str.setDuno(rs.getInt("duno"));
            str.setTonghp(rs.getInt("tonghp"));
            str.setDadong(rs.getInt("dadong"));
            
              stm.close();
            rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  ;
        }
         
        public List<DiemSV> diemsv(String str)
        {
            List<DiemSV> SV = new ArrayList<DiemSV>();
            String selectIf = "select lop_SV.idlop,lop_SV.diemgk,lop_SV.diemck,hocphan.tenhp,hocphan.trongsodiemqt from lop inner join lop_SV using (idlop) inner join hocphan using (mahp) where lop_SV.idsv = ? ";
            int tong=0;
             try
        {
            
                
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(str));
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                DiemSV diem = new DiemSV();
                diem.setIDLop(rs.getString("idlop"));
                diem.setTenHP(rs.getString("tenhp"));
                diem.setDiemGK(rs.getFloat("diemgk"));
                diem.setDiemCK(rs.getFloat("diemck"));
                diem.setTrongsodiemqt(rs.getFloat("trongsodiemqt"));
                SV.add(diem);
            }
             stm.close();
            rs.close();
            
            
             
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV ;
        }
         public List<ThongTinLop> getHPGV(String str)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = "select hocphan.mahp, hocphan.tenhp,lop.idlop from  lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH inner join hocphan using(mahp) where lop.idgv = ?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(str));
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                lop.setIDLop(rs.getString("idlop"));
                LOP.add(lop);
                
             }
              stm.close();
              rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
        
    }
         public List<ThongTinLop> getTKB(String str)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = "select ttlop.idlop,ttlop.thu,ttlop.giomd , ttlop.giokt from giohoc ttlop inner join lop using(idlop) natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH where lop.idgv = ? order by (ttlop.thu,ttlop.giomd)";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1, Integer.parseInt(str));
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setIDLop(rs.getString("idlop"));
                lop.setThu(rs.getInt("thu"));
                lop.setGioMD(rs.getTime("giomd"));
                lop.setGioKT(rs.getTime("giokt"));
                LOP.add(lop);
                
             }
              stm.close();
              rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
         public List<ThongTinLop> getHPGV2(String str, String str2)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         str2 = "%"+str2+"%";
         String selectIf = "select hocphan.mahp, hocphan.tenhp,lop.idlop from lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH inner join hocphan using (mahp) where CAST (lop.idgv AS varchar(10)) = ? and (lop.idlop like ? or lop.mahp like ?) ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            stm.setString(2, str2);
            stm.setString(3, str2);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                lop.setIDLop(rs.getString("idlop"));
                LOP.add(lop);
                
             }
              stm.close();
              rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
   
}
         public List<SinhVien> getSVLop(String str)
    {
         List<SinhVien> SV = new ArrayList<SinhVien>();
         String selectIf = "select lop_SV.idsv,sinhvien.name,sinhvien.ngaysinh from lop_SV inner join sinhvien on lop_SV.idsv = sinhvien.idsv  where lop_SV.idlop =?  order by lop_SV.idsv asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                SinhVien sv = new SinhVien();
                sv.setIDSV(rs.getString("idsv"));
                sv.setName(rs.getString("name"));
                sv.setNgaysinh(rs.getString("ngaysinh"));
                SV.add(sv);
                
             }
              stm.close();
             rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV;
   
}
          public List<SinhVien> getSVLopGK(String str)
    {
         List<SinhVien> SV = new ArrayList<SinhVien>();
         String selectIf = "select * from lop_SV,sinhvien where lop_SV.idlop = ? and sinhvien.idsv = lop_SV.idsv order by sinhvien.idsv asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                SinhVien sv = new SinhVien();
                sv.setIDSV(rs.getString("idsv"));
                sv.setName(rs.getString("name"));
                sv.setDGK(rs.getDouble("diemgk"));
                sv.setDCK(rs.getDouble("diemck"));
                SV.add(sv);
                
             }
             stm.close();
             rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV;
   
}
        public void insertdiem (List<SinhVien> SV,ThongTinLop lop)
    {
        
         String selectIf = "update lop_SV set diemgk =?, diemck =? where lop_SV.idlop =? and lop_SV.idsv=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(3,lop.getIDLop() );
            for(SinhVien tt : SV)
            {
            stm.setDouble(1, tt.getDGK());
            stm.setDouble(2, tt.getDCK());
            stm.setInt(4, Integer.parseInt(tt.getIDSV()));
            stm.executeUpdate();
            }
            stm.close();
           
          
           
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        public List<SinhVien> getSVGK(String str, String str2)
    {
         List<SinhVien> SV = new ArrayList<SinhVien>();
         String str22 = "%"+str2+"%";
         String selectIf = "select sinhvien.idsv,sinhvien.name,lop_SV.diemgk,lop_SV.diemck from lop_SV, sinhvien where lop_SV.idlop =? and lop_SV.idsv = sinhvien.idsv and (CAST (sinhvien.idsv AS varchar(10)) like ? or sinhvien.name like ?) order by sinhvien.idsv asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            stm.setString(2, str22);
            stm.setString(3, str22);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                SinhVien sv = new SinhVien();
                sv.setIDSV(rs.getString("idsv"));
                sv.setName(rs.getString("name"));
                sv.setDGK(rs.getDouble("diemgk"));
                sv.setDCK(rs.getDouble("diemck"));
                SV.add(sv);
                
             }
             stm.close();
            rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SV;
   
      
   
}
        public List<ThongTinLop> LopKHoa(String str)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = "select lop.idlop,lop.mahp,hocphan.tenhp,lop.idgv,count(idsv) from lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH left outer join lop_SV using(idlop) inner join hocphan using(mahp) where  hocphan.makhoa =? group by lop.idlop,lop.mahp,hocphan.tenhp order by lop.idlop asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setIDLop(rs.getString("idlop"));
                lop.setSiSo(rs.getInt("count"));
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                int s = rs.getInt("idgv");
                lop.setMaGV(s+"");
                LOP.add(lop);
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
        
          public void TGLop(ThongTinLop tt)
    {
        
         String selectIf = "select thu,giomd,giokt from giohoc where giohoc.idlop = ? ";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,tt.getIDLop() );
            
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                tt.setThu(rs.getInt("thu"));
                tt.setGioMD(rs.getTime("GioMD"));
                tt.setGioKT(rs.getTime("GioKT"));
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  ;
    }
           public List<LichSuHT> ThanhTich(String sv)
    {
        List<LichSuHT> LOP = new ArrayList<LichSuHT>();
         String selectIf = "select * from lichsuhoctap natural join lop inner join hocphan using(mahp) where idsv = ? order by (namhoc,kihoc) asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1,Integer.parseInt(sv));
            
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                LichSuHT lop = new LichSuHT();
                lop.setNamhoc(rs.getInt("namhoc"));
                lop.setKihoc(rs.getInt("kihoc"));
                lop.setMahp(rs.getString("mahp"));
                lop.setIdsv(rs.getInt("idsv"));
                lop.setDiemhp(rs.getFloat("diemhp"));
                lop.setDiemchu(rs.getString("diemhpchu"));
                lop.setDiemQT(rs.getFloat("diemQT"));
                lop.setDiemCK(rs.getFloat("diemck"));
                lop.setTenHP(rs.getString("tenhp"));
                lop.setSOTC(rs.getInt("SOTC"));
                LOP.add(lop);
                
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
           public List<LichSuHT> TongKet(String sv)
    {
        List<LichSuHT> LOP = new ArrayList<LichSuHT>();
         String selectIf = "select namhoc1 namhoc, kihoc1 kihoc, tbki1 tbki, tbht1 tbht from Func1(?)";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1,Integer.parseInt(sv));
            
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                LichSuHT lop = new LichSuHT();
                lop.setNamhoc(rs.getInt("namhoc"));
                lop.setKihoc(rs.getInt("kihoc"));
                lop.setTBKi(rs.getFloat("tbki"));
                lop.setCPA(rs.getFloat("tbht"));
                LOP.add(lop);
                
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
           public int SoTCQua(String sv)
    {
        int sotc = 0;
         String selectIf = "select sum(STC) from (select sotc as STC from lichsuhoctap natural join lop inner join hocphan using(mahp) where idsv = ? and diemhp>=0 group by mahp,sotc having max(diemhp) >0) as NS";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1,Integer.parseInt(sv));
            
            ResultSet rs = stm.executeQuery();
            rs.next();
            sotc = rs.getInt("sum");
             
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sotc ;
    }
            public int SoTCChuaqua(String sv)
    {
        int sotc = 0;
         String selectIf = "select sum(STC) from (select sotc as STC from lichsuhoctap natural join lop inner join hocphan using(mahp) where idsv = ? and diemhp>=0 group by mahp,sotc having max(diemhp) =0) as NS";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1,Integer.parseInt(sv));
            
            ResultSet rs = stm.executeQuery();
            rs.next();
            sotc = rs.getInt("sum");
             
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sotc ;
    }
           public List<LichSuHT> NoTin(String sv)
    {
        List<LichSuHT> LOP = new ArrayList<LichSuHT>();
         String selectIf = "select * from (lichsuhoctap  natural join lop)ls1 inner join hocphan using (mahp) where idsv = ?  and diemhpchu = 'F' and  ls1.mahp not in (select ls2.mahp from (lichsuhoctap natural join lop) ls2 where idsv = ? and diemhpchu!='F') order by (namhoc,kihoc) asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setInt(1,Integer.parseInt(sv));
            stm.setInt(2,Integer.parseInt(sv));
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                LichSuHT lop = new LichSuHT();
                lop.setNamhoc(rs.getInt("namhoc"));
                lop.setKihoc(rs.getInt("kihoc"));
                lop.setMahp(rs.getString("mahp"));
                lop.setIdsv(rs.getInt("idsv"));
                lop.setDiemhp(rs.getFloat("diemhp"));
                lop.setDiemchu(rs.getString("diemhpchu"));
                lop.setDiemQT(rs.getFloat("diemQT"));
                lop.setDiemCK(rs.getFloat("diemck"));
                lop.setTenHP(rs.getString("tenhp"));
                LOP.add(lop);
                
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
        
    }
            public int MaGV(String sv)
    {
        int sotc = 0;
         String selectIf = "select * from lop where idlop=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,sv);
            
            ResultSet rs = stm.executeQuery();
            rs.next();
            sotc = rs.getInt("idgv");
             
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sotc ;
    }
             public int SBDD(String sv)
    {
        int sotc = 0;
         String selectIf = "select * from lop where idlop=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,sv);
            
            ResultSet rs = stm.executeQuery();
            rs.next();
            sotc = rs.getInt("SBDD");
             
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sotc ;
    }
             public List<DDanh> TKDD(String sv)
    {
        List<DDanh> LOP = new ArrayList<DDanh>();
         String selectIf = "select * from lop_SV l inner join sinhvien s on l.idsv = s.idsv where idlop=? order by l.idsv asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,sv);
            
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                DDanh lop = new DDanh();
                lop.setIdsv(rs.getInt("idsv")+"");
                lop.setSbv(rs.getInt("sobuoivang"));
                lop.setNameSV(rs.getString("name"));
                LOP.add(lop);
                
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
        
    }

public List<ThongTinLop> ALLLopKHoa()
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = "select tk.*,tenhp, count(idsv) from (lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH) tk left outer join lop_SV using(idlop) inner join hocphan using(mahp)   group by tk.idlop,idgv,tenhp  order by idlop asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setIDLop(rs.getString("idlop"));
                lop.setSiSo(rs.getInt("count"));
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                int s = rs.getInt("idgv");
                lop.setMaGV(s+"");
                LOP.add(lop);
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
public List<ThongTinLop> ALLLopKD()
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = " select tk.*,tenhp, count(idsv) from (lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH) tk left outer join lop_SV using(idlop) inner join hocphan using(mahp)   group by tk.idlop,idgv,tenhp having count(idsv)<25 or idgv is null  order by idlop asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setIDLop(rs.getString("idlop"));
                lop.setSiSo(rs.getInt("count"));
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                int s = rs.getInt("idgv");
                lop.setMaGV(s+"");
                LOP.add(lop);
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
public List<ThongTinLop> TimLop(String str)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = " select tk.*,tenhp, count(idsv) from (lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH) tk left outer join lop_SV using(idlop) inner join hocphan using(mahp)   where idlop =? group by tk.idlop,idgv,tenhp order by idlop asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,str);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setIDLop(rs.getString("idlop"));
                lop.setSiSo(rs.getInt("count"));
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                int s = rs.getInt("idgv");
                lop.setMaGV(s+"");
                LOP.add(lop);
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
public List<ThongTinLop> TimLopKD(String str)
    {
         List<ThongTinLop> LOP = new ArrayList<ThongTinLop>();
         String selectIf = " select tk.*,tenhp, count(idsv) from (lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH) tk left outer join lop_SV using(idlop) inner join hocphan using(mahp) where idlop = ?  group by tk.idlop,idgv,tenhp having count(idsv)<25 or idgv is null  order by idlop asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,str);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                ThongTinLop lop = new ThongTinLop();
                lop.setIDLop(rs.getString("idlop"));
                lop.setSiSo(rs.getInt("count"));
                lop.setMaHP(rs.getString("mahp"));
                lop.setTenHP(rs.getString("tenhp"));
                int s = rs.getInt("idgv");
                lop.setMaGV(s+"");
                LOP.add(lop);
                
             }
             stm.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LOP ;
    }
public void XoaLop (String str)
{
    String selectIf = " delete from lop where idlop =?";
    try
    {
         PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,str);
            stm.executeUpdate();
    }
    catch (SQLException ex) {
            ex.printStackTrace();
        }
    return;
}
public void DDNGhi(List<SinhVien> sv,String str)
{
    String selectIf = " update lop_SV set sobuoivang= sobuoivang+1 where idsv = ? and idlop = ?";
    String selectIf2 = " update lop set sbdd=sbdd+1 where idlop = ?";
    try
    {
         PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
         for(SinhVien m : sv)
         {
            stm.setInt(1,Integer.parseInt(m.getIDSV()));
            stm.setString(2,str);
            stm.executeUpdate();
         }
         PreparedStatement stm2 = ConnectSQL.getConnection().prepareStatement(selectIf2);
         stm2.setString(1,str);
         stm2.executeUpdate();
    }
    catch (SQLException ex) {
            ex.printStackTrace();
        }
    return;
}

public void XoaLopAll ()
{
    String selectIf = " delete from lop where idlop in (select tk.idlop from (lop natural join (select namhoc,kihoc from Kyhoc order by (namhoc,kihoc) desc limit 1) as NH) tk left outer join lop_SV using(idlop) inner join hocphan using(mahp)   group by tk.idlop,idgv,tenhp having count(idsv)<25 or idgv is null  order by idlop asc)";
    try
    {
         PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.executeUpdate();
    }
    catch (SQLException ex) {
            ex.printStackTrace();
        }
    return;
}
public int Ktra (String s1, int s2, int n)
{
    String selectIf;
    int k=0;
    if(n==1)
    {
    selectIf = " select diemgk from lop_SV where idlop=? and idsv=?";
    }
    else
    {
      selectIf = " select diemck from lop_SV where idlop=? and idsv=?";
    }
    try
    {
         PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
         stm.setString(1,s1);
         stm.setInt(2,s2);
         ResultSet rs = stm.executeQuery();
         rs.next();
         if(n==1 && rs.getFloat("diemgk")==-1) k=1;
          if(n==2 && rs.getFloat("diemck")==-1) k=1;
          
    }
    catch (SQLException ex) {
            ex.printStackTrace();
        }
    return k;
}
public void DiemPk (DonPK pd)
{
    String selectIf;
    float k = 0;
    
      selectIf = " select * from lop_SV where idlop=? and idsv=?";
   
    try
    {
         PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
         stm.setString(1,pd.getIdlop());
         stm.setInt(2,pd.getIdsv());
         ResultSet rs = stm.executeQuery();
         if(rs.next())
         if(pd.getLoaidiem().equals("gk ") ) pd.setDiem_sauPK(rs.getFloat("diemgk"));
         else  pd.setDiem_sauPK(rs.getFloat("diemck"));
          
          
    }
    catch (SQLException ex) {
        System.out.print("hear");
            ex.printStackTrace();
            
        }
   
}
public int KtraDon (DonPK pd)
{
    String selectIf;
    int k=0;
   
    selectIf = " select count(*) from donphuckhao where idlop=? and idsv=? and loaidiem=?";
    
    try
    {
         PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
         stm.setString(1,pd.getIdlop());
         stm.setInt(2,pd.getIdsv());
         stm.setString(3, pd.getLoaidiem());
         ResultSet rs = stm.executeQuery();
         rs.next();
         k=rs.getInt("count");
          
    }
    catch (SQLException ex) {
            ex.printStackTrace();
        }
    return k;
}

}
   

