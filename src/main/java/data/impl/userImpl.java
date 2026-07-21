/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import data.dao.userDao;
import data.driver.driver;
import data.model.user;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.API;

/**
 *
 * @author parrot
 */
public class userImpl implements userDao {

    public driver d = new driver("users");

    @Override
    public boolean Insert(String name, String email, String phone, String password, String role) {
        d.execute = "INSERT INTO " + d.tenbang + "(`name`, `email`, `phone`, `password`, `role`) VALUES (?,?,?,?,?)";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setString(1, name);
            d.sttm.setString(2, email);
            d.sttm.setString(3, phone);
            d.sttm.setString(4, password);
            d.sttm.setString(5, role);
            d.sttm.execute();

            return true;
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    @Override
    public boolean update(int id, String name, String email, String phone, String password, String role) {
        d.execute = "UPDATE " + d.tenbang + " SET `name`=?,`email`=?,`phone`=?,`password`=?,`role`=? WHERE `id`= ?";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setString(1, name);
            d.sttm.setString(2, email);
            d.sttm.setString(3, phone);
            d.sttm.setString(4, password);
            d.sttm.setString(5, role);
            d.sttm.setInt(6, id);
            d.sttm.execute();
            d.ketnoi.close();
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
    public user find(int id) {
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                if (new user(d.rs).getId() == id) {
                    return new user(d.rs);
                }
            }
            d.ketnoi.close();
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<user> findAll() {
        ArrayList<user> l = new ArrayList<>();
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                l.add(new user(d.rs));
            }

        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return l;
    }

    @Override
    public user findUser(String emailphone, String password) {
        try {
            d.rs = d.laybang(d.tenbang + " where " + (emailphone.contains("@") ? " email " : " phone ") + " = '" + emailphone + "'and password = '" + API.getMd5(password) + "'");
            if (d.rs.next()) {
                return new user(d.rs);
            }
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    public user findUser(String emailphone) {
        try {
            if (emailphone.contains("@")) {
                d.execute = d.tenbang + " where  email   = " + "'" + emailphone + "'";
            } else {
                d.execute = d.tenbang + " where  phone  = " + emailphone;
            }
            d.rs = d.laybang(d.execute);
            if (d.rs.next()) {
                return new user(d.rs);
            }
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    @Override
    public boolean update(int id, String name, String email, String phone, String role) {
        d.execute = "UPDATE " + d.tenbang + " SET `name`=?,`email`=?,`phone`=?,`role`=? WHERE `id`= ?";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setString(1, name);
            d.sttm.setString(2, email);
            d.sttm.setString(3, phone);
            d.sttm.setString(4, role);
            d.sttm.setInt(5, id);
            d.sttm.execute();
            d.ketnoi.close();
            return true;
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

}
