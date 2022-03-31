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
import java.sql.Timestamp;
public class DoiGV {
    private Timestamp thoigiangui ;
    private String  idlop ;
    private int idgv;
    private String dongy;
    private String lido;
    private int ng;

    public int getNg() {
        return ng;
    }

    public void setNg(int ng) {
        this.ng = ng;
    }

    public String getLido() {
        return lido;
    }

    public void setLido(String lido) {
        this.lido = lido;
    }

    public Timestamp getThoigiangui() {
        return thoigiangui;
    }

    public void setThoigiangui(Timestamp thoigiangui) {
        this.thoigiangui = thoigiangui;
    }

    public String getIdlop() {
        return idlop;
    }

    public void setIdlop(String idlop) {
        this.idlop = idlop;
    }

    public int getIdgv() {
        return idgv;
    }

    public void setIdgv(int idgv) {
        this.idgv = idgv;
    }

    public String getDongy() {
        return dongy;
    }

    public void setDongy(String dongy) {
        this.dongy = dongy;
    }
}
