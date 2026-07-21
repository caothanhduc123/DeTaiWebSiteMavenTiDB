/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.impl;

import data.dao.donhangDao;
import data.driver.driver;
import data.model.donhang;
import data.model.hangxe;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author parrot
 */
public class donhangImpl implements donhangDao {

    public driver d = new driver("donhang");

    @Override
    public boolean Insert(int id_khachhang, double tongtien, String trangthai, Date ngay_mua, int id_car, int id_user) {
        d.execute = "INSERT INTO " + d.tenbang + "(`hangxe`) VALUES (?)";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setInt(1, id_khachhang);
            d.sttm.setDouble(2, tongtien);
            d.sttm.setString(3, trangthai);
            d.sttm.setDate(4, (java.sql.Date) ngay_mua);
            d.sttm.setInt(5, id_car);
            d.sttm.setInt(6, id_user);
            d.sttm.execute();

            return true;
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        d.execute = "DELETE FROM " + d.tenbang + " WHERE id = ?";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setInt(1, id);
            d.sttm.execute();
            d.ketnoi.close();
            return true;
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<donhang> findAll() {
        ArrayList<donhang> l = new ArrayList<>();
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                l.add(new donhang(d.rs));
            }
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return l;
    }

    @Override
    public donhang finddonhang(int id_user) {
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                if (new hangxe(d.rs).getId() == id_user) {
                    return new donhang(d.rs);
                }
            }
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    public donhang finddonhang(int id_user, int id_car) {
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                if (new donhang(d.rs).getId_user()== id_user && new donhang(d.rs).getId_car() == id_car) {
                    return new donhang(d.rs);
                }
            }
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    @Override
    public boolean xacnhandonhang(int id_dh) {
        d.execute = "UPDATE `donhang` SET `trangthai`=? WHERE `id`=?";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setString(1, "1");
            d.sttm.setInt(2, id_dh);
            int row = d.sttm.executeUpdate();
            
            return row > 0;
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
}
