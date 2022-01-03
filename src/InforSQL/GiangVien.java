/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InforSQL;

/**
 *
 * @author ADMIN
 */
public class GiangVien {
    private String IDGV;
    private String NameGV;
    private String DiaChi;
    private String MaKhoa;
    private String email;
    private Boolean GioiTinh;

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    private String anh;
    

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    private String ngaysinh;

    @Override
    public String toString() {
        return NameGV;//To change body of generated methods, choose Tools | Templates.
    }

    public String getIDGV() {
        return IDGV;
    }

    public void setIDGV(String IDGV) {
        this.IDGV = IDGV;
    }

    public String getNameGV() {
        return NameGV;
    }

    public void setNameGV(String NameGV) {
        this.NameGV = NameGV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String MaKhoa) {
        this.MaKhoa = MaKhoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    
}
