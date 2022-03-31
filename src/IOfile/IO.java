/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOfile;

import InforSQL.GiangVien;
import InforSQL.SinhVien;
import InforSQL.ThongTinLop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
 
public class IO {
    public void writeFile (String ms)
    {
        try
        {
            FileWriter fos = new FileWriter("nhap.txt");
            BufferedWriter dos = new BufferedWriter(fos);
            dos.write(ms);
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
    public void readFileSV (SinhVien sv)
    {
        //String ms = new String();
        try
        {
            FileReader fos = new  FileReader("nhap.txt");
            BufferedReader dos = new BufferedReader(fos);
            sv.setIDSV(dos.readLine());
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
    
   
public void readFileGV (GiangVien gv)
    {
        //String ms = new String();
        try
        {
            FileReader fos = new  FileReader("nhap.txt");
            BufferedReader dos = new BufferedReader(fos);
            gv.setIDGV(dos.readLine());
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
   
 public void writeFileQL (String ms)
    {
        try
        {
            FileWriter fos = new FileWriter("lop.txt");
            BufferedWriter dos = new BufferedWriter(fos);
            dos.write(ms);
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
 public void readFileLop (ThongTinLop lop)
    {
        //String ms = new String();
        try
        {
            FileReader fos = new  FileReader("lop.txt");
            BufferedReader dos = new BufferedReader(fos);
            lop.setIDLop(dos.readLine());
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
 public void writeFileTtSv (String ms)
    {
        try
        {
            FileWriter fos = new FileWriter("TTSV.txt");
            BufferedWriter dos = new BufferedWriter(fos);
            dos.write(ms);
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
 public void readFileTtSb (SinhVien sv)
    {
        //String ms = new String();
        try
        {
            FileReader fos = new  FileReader("TTSV.txt");
            BufferedReader dos = new BufferedReader(fos);
            sv.setIDSV(dos.readLine());
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
  public void writeFileTtGv (String ms)
    {
        try
        {
            FileWriter fos = new FileWriter("TTGV.txt");
            BufferedWriter dos = new BufferedWriter(fos);
            dos.write(ms);
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
 public void readFileTtGv (GiangVien sv)
    {
        //String ms = new String();
        try
        {
            FileReader fos = new  FileReader("TTGV.txt");
            BufferedReader dos = new BufferedReader(fos);
            sv.setIDGV(dos.readLine());
            dos.close();
            fos.close();
         } catch (IOException ex) {
    ex.printStackTrace();} 
        
    }
 
   
    
}
