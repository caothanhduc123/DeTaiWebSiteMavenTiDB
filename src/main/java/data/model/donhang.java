/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author parrot
 */
public class donhang {
    int id, id_khachhang;
    double tongtien;
    String trangthai;
    Date ngay_mua;
    int id_car, id_user;

    public donhang(int id, int id_khachhang, String trangthai, Date ngay_mua, int id_car, int id_user) {
        this.id = id;
        this.id_khachhang = id_khachhang;
        this.trangthai = trangthai;
        this.ngay_mua = ngay_mua;
        this.id_car = id_car;
        this.id_user = id_user;
    }
    public donhang(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.id_khachhang = rs.getInt("id_khachhang");
            this.trangthai = rs.getString("trangthai");
            this.ngay_mua = rs.getDate("ngay_mua");
            this.id_car = rs.getInt("id_car");
            this.id_user = rs.getInt("id_user");
        } catch (SQLException ex) {
            System.getLogger(donhang.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public int getId_khachhang() {
        return id_khachhang;
    }



    public String getTrangthai() {
        return trangthai;
    }

    public Date getNgay_mua() {
        return ngay_mua;
    }

    public int getId_car() {
        return id_car;
    }

    public int getId_user() {
        return id_user;
    }
    
}
