/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LopInf;

import ConnectSQL.ConnectSQL;
import InforSQL.DDanh;
import InforSQL.DiemSV;
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
         String selectIf = "select hocphan.mahp,hocphan.tenhp,thong_ke_lop.idlop,giangvien.namegv from lop inner join thong_ke_lop using(idlop) inner join hocphan using (mahp) inner join giangvien on giangvien.idgv = thong_ke_lop.magv where lop.masv = ?   ";
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
         String selectIf = "select ttlop.thu, ttlop.giomd ,ttlop.giokt ,ttlop.idlop from lop inner join ttlop using (idlop) where lop.masv = ?  order by (ttlop.thu,ttlop.giomd) ASC";
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
         String selectIf = "select hp.mahp,hp.tenhp,hp.sotc,hp.tientc,(hp.tientc*hp.sotc) as Tong from lop inner join thong_ke_lop using (idlop) inner join hocphan as hp  using (mahp) where lop.masv = ?";

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
            String selectIf = "select lop.idlop,lop.diemgk,lop.diemck,hocphan.tenhp from lop inner join Thong_ke_lop using (idlop) inner join hocphan using (mahp) where lop.masv = ? ";
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
         String selectIf = "select hocphan.mahp, hocphan.tenhp,thong_ke_lop.idlop from  thong_ke_lop inner join hocphan using(mahp) where thong_ke_lop.magv = ?";
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
         String selectIf = "select ttlop.idlop,ttlop.thu,ttlop.giomd , ttlop.giokt from ttlop inner join thong_ke_lop using(idlop) where thong_ke_lop.magv = ?  order by (ttlop.thu,ttlop.giomd)";
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
         String selectIf = "select hocphan.mahp, hocphan.tenhp,thong_ke_lop.idlop from thong_ke_lop inner join hocphan using (mahp) where CAST (thong_ke_lop.magv AS varchar(10)) = ? and (thong_ke_lop.idlop like ? or Thong_ke_lop.mahp like ?) ";
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
         String selectIf = "select lop.masv,sinhvien.name,sinhvien.ngaysinh from lop inner join sinhvien on lop.masv = sinhvien.idsv  where lop.idlop =?  order by lop.masv asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1, str);
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                SinhVien sv = new SinhVien();
                sv.setIDSV(rs.getString("masv"));
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
         String selectIf = "select * from lop,sinhvien where lop.idlop = ? and sinhvien.idsv = lop.masv order by sinhvien.idsv asc";
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
        
         String selectIf = "update lop set diemgk =?, diemck =? where lop.idlop =? and lop.masv=?";
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
         String selectIf = "select sinhvien.idsv,sinhvien.name,lop.diemgk,lop.diemck from lop, sinhvien where lop.idlop =? and lop.masv = sinhvien.idsv and (CAST (sinhvien.idsv AS varchar(10)) like ? or sinhvien.name like ?) order by sinhvien.idsv asc";
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
         String selectIf = "select thong_ke_lop.idlop,thong_ke_lop.mahp,hocphan.tenhp,thong_ke_lop.magv,count(masv) from thong_ke_lop left outer join lop using(idlop) inner join hocphan using(mahp) where  hocphan.makhoa =? group by thong_ke_lop.idlop,thong_ke_lop.mahp,hocphan.tenhp order by thong_ke_lop.idlop asc";
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
                int s = rs.getInt("magv");
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
        
         String selectIf = "select thu,giomd,giokt from ttlop inner join thong_ke_lop using(idlop) where ttlop.idlop = ? ";
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
         String selectIf = "select * from lichsuhoctap inner join hocphan using(mahp) where idsv = ? order by (namhoc,kihoc) asc";
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
         String selectIf = "select sum(STC) from (select sotc as STC from lichsuhoctap inner join hocphan using(mahp) where idsv = ? and diemhp>=0 group by mahp,sotc having max(diemhp) >0) as NS";
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
         String selectIf = "select sum(STC) from (select sotc as STC from lichsuhoctap inner join hocphan using(mahp) where idsv = ? and diemhp>=0 group by mahp,sotc having max(diemhp) =0) as NS";
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
         String selectIf = "select * from lichsuhoctap ls1 inner join hocphan using (mahp) where idsv = ?  and diemhpchu = 'F' and  ls1.mahp not in (select ls2.mahp from lichsuhoctap ls2 where idsv = ? and diemhpchu!='F') order by (namhoc,kihoc) asc";
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
         String selectIf = "select * from thong_ke_lop where idlop=?";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,sv);
            
            ResultSet rs = stm.executeQuery();
            rs.next();
            sotc = rs.getInt("magv");
             
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
         String selectIf = "select * from thong_ke_lop where idlop=?";
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
         String selectIf = "select * from lop l inner join sinhvien s on l.masv = s.idsv where idlop=? order by masv asc";
        try
        {
            PreparedStatement stm = ConnectSQL.getConnection().prepareStatement(selectIf);
            stm.setString(1,sv);
            
            ResultSet rs = stm.executeQuery();
             while(rs.next())
            {
                DDanh lop = new DDanh();
                lop.setIdsv(rs.getInt("masv")+"");
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
         String selectIf = " select tk.*,tenhp, count(masv) from ((thong_ke_lop tk left outer join giangvien gv on tk.magv = gv.idgv) inner join ttlop tt using (idlop))left outer join lop using(idlop) inner join hocphan using(mahp) group by tk.idlop,idgv,tenhp order by idlop asc";
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
                int s = rs.getInt("magv");
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
         String selectIf = " select tk.*,tenhp, count(masv) from ((thong_ke_lop tk left outer join giangvien gv on tk.magv = gv.idgv) inner join ttlop tt using (idlop))left outer join lop using(idlop) inner join hocphan using(mahp) group by tk.idlop,idgv,tenhp having count(masv)=0 or idgv is null order by idlop asc";
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
                int s = rs.getInt("magv");
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
         String selectIf = " select tk.*,tenhp, count(masv) from ((thong_ke_lop tk left outer join giangvien gv on tk.magv = gv.idgv) inner join ttlop tt using (idlop))left outer join lop using(idlop) inner join hocphan using(mahp) where idlop=?  group by tk.idlop,idgv,tenhp order by idlop asc";
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
                int s = rs.getInt("magv");
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
         String selectIf = " select tk.*,tenhp, count(masv) from ((thong_ke_lop tk left outer join giangvien gv on tk.magv = gv.idgv) inner join ttlop tt using (idlop))left outer join lop using(idlop) inner join hocphan using(mahp) where idlop=?  group by tk.idlop,idgv,tenhp having count(masv)=0 or idgv is null  order by idlop asc";
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
                int s = rs.getInt("magv");
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
    String selectIf = " delete from thong_ke_lop where idlop =?";
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
    String selectIf = " update lop set sobuoivang= sobuoivang+1 where masv = ? and idlop = ?";
    String selectIf2 = " update thong_ke_lop set sbdd=sbdd+1 where idlop = ?";
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
}
   

