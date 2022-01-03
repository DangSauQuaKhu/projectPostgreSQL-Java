/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DangNhap;

/**
 *
 * @author ADMIN
 */
import ConnectSQL.ConnectSQL;
import InforSQL.GiangVien;
import InforSQL.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DangNhap {
     public int FrindUserSV(String st1, String st2,SinhVien sv)
    {
        int n = 0;
         try {
            String sql1 = "select count(*) from sinhvien WHERE account= ? and pass = ? ";
            PreparedStatement  stat = ConnectSQL.getConnection().prepareStatement(sql1);
            stat.setString(1, st1);
            stat.setString(2, st2);
            ResultSet rs1 = stat.executeQuery();
            rs1.next();
            n = rs1.getInt("count");
            if(n==1)
            {
            String sql = "select * from sinhvien WHERE account= ? and pass = ? ";
            PreparedStatement  sta = ConnectSQL.getConnection().prepareStatement(sql);
            sta.setString(1, st1);
            sta.setString(2, st2);
            ResultSet rs = sta.executeQuery();
            while(rs.next())
            {
               int s = rs.getInt("idsv");
               String s1 = s+"";
               sv.setIDSV(s1);
                 
                 
            }
            
            } 
         }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n ;
    } 
      /*public static void main(String args[]) {
          SinhVien sv = new SinhVien();
          int m = FindUserSV("12","13",sv);
      }*/
      public int FrindUserGV(String st1, String st2, GiangVien sv)
    {
        int n = 0;
         try {
            String sql1 = "select count(*) from giangvien WHERE account= ? and pass = ? ";
            PreparedStatement  stat = ConnectSQL.getConnection().prepareStatement(sql1);
            stat.setString(1, st1);
            stat.setString(2, st2);
            ResultSet rs1 = stat.executeQuery();
            rs1.next();
            n = rs1.getInt("count");
            if(n==1)
            {
            String sql = "select * from giangvien WHERE account= ? and pass = ? ";
            PreparedStatement  sta = ConnectSQL.getConnection().prepareStatement(sql);
            sta.setString(1, st1);
            sta.setString(2, st2);
            ResultSet rs = sta.executeQuery();
            int s=0;
            while(rs.next())
            {
                 s = rs.getInt("idgv");
                 if(s==0) n=0;
                String s1 = s+"";
                sv.setIDGV( s1);
                 
                 
            }
            String sql2 = "select count(*) from khoa where magvt =? ";
            PreparedStatement  stam = ConnectSQL.getConnection().prepareStatement(sql2);
            stam.setInt(1,s);
            ResultSet rs2 = stam.executeQuery();
            rs2.next();
            if(rs2.getInt("count")==1) n=2;
            
            
            } 
            
         }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n ;
    } 
      public int FrindAD(String st1, String st2,GiangVien sv)
    {
        int n = 0;
         try {
            String sql1 = "select count(*) from Giangvien WHERE account= ? and pass = ? ";
            PreparedStatement  stat = ConnectSQL.getConnection().prepareStatement(sql1);
            stat.setString(1, st1);
            stat.setString(2, st2);
            ResultSet rs1 = stat.executeQuery();
            rs1.next();
            n = rs1.getInt("count");
            
            
            
         }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    } 
}

