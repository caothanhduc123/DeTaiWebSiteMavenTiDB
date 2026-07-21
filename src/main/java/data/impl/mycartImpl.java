/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.impl;

import data.dao.mycartDao;
import data.driver.driver;
import data.model.mycart;
import data.model.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author parrot
 */
public class mycartImpl implements mycartDao {

    public driver d = new driver("user_buy");

    @Override
    public boolean Insert(int id_user, int id_car, int so_km_hoatdong, boolean trangthai) {
        d.execute = "INSERT INTO " + d.tenbang + "(`id_user`, `id_car`, `so_km_hoatdong`, `trangthai`) VALUES (?, ?, ?, ?)";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setInt(1, id_user);
            d.sttm.setInt(2, id_car);
            d.sttm.setInt(3, so_km_hoatdong);
            d.sttm.setBoolean(4, trangthai);
            d.sttm.execute();

            return true;
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    @Override
    public boolean update(int id, int id_user, int id_produce, int quanlity) {
        d.execute = "UPDATE " + d.tenbang + " SET `id_user`=?,`id_product`=?,`quantity`=? WHERE `id`= ?";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setInt(1, id_user);
            d.sttm.setInt(2, id_produce);
            d.sttm.setInt(4, id);
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
            return true;
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<mycart> find(int id) {
        ArrayList<mycart> l = new ArrayList<>();
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                mycart c = new mycart(d.rs);
                if (c.getId_user() == id) {
                    l.add(c);
                }
            }

        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return l;
    }
    @Override
    public ArrayList<mycart> findAll() {
        ArrayList<mycart> l = new ArrayList<>();
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                mycart c = new mycart(d.rs);
                    l.add(c);
                }
            } catch (SQLException ex) {
            System.getLogger(mycartImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return l;
    }

    @Override
    public boolean updatetrangthai(int id_user) {
        try {
            d.execute = "UPDATE `user_buy` SET `trangthai`= 1 WHERE id_user = " + id_user;
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            int row = d.sttm.executeUpdate();
            return row > 0;
        } catch (SQLException ex) {
            System.getLogger(mycartImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    @Override
    public mycart find_id(int id) {
        try {
            d.rs = d.laybang(" where id = " + id);
            if(d.rs.next())
                return new mycart(d.rs);

        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
}
