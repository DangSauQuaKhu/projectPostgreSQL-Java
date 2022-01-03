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
public class SinhVien {

    public String getIDSV() {
        return IDSV;
    }

    public void setIDSV(String IDSV) {
        this.IDSV = IDSV;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
     private String IDSV;
    private String Name;
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

    public double getDGK() {
        return DGK;
    }

    public void setDGK(double DGK) {
        this.DGK = DGK;
    }

    public double getDCK() {
        return DCK;
    }

    public void setDCK(double DCK) {
        this.DCK = DCK;
    }
    private double DGK;
    private double DCK;

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    private String ngaysinh;

    @Override
    public String toString() {
        return Name;//To change body of generated methods, choose Tools | Templates.
    }

    public int getTonghp() {
        return tonghp;
    }

    public void setTonghp(int tonghp) {
        this.tonghp = tonghp;
    }

    public int getDuno() {
        return duno;
    }

    public void setDuno(int duno) {
        this.duno = duno;
    }

    public int getDadong() {
        return dadong;
    }

    public void setDadong(int dadong) {
        this.dadong = dadong;
    }
    private int tonghp;
    private int duno;
    private int dadong;
    
    
}
