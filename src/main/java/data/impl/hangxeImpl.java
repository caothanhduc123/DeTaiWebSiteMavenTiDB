/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.impl;

import data.model.hangxe;
import data.dao.hangxeDao;
import data.driver.driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author parrot
 */
public class hangxeImpl implements hangxeDao {

    public driver d = new driver("Loaixe");

    @Override
    public boolean Insert(String name) {
        d.execute = "INSERT INTO " + d.tenbang + "(`hangxe`) VALUES (?)"; 
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setString(1, name);
            d.sttm.execute();

            return true;
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    @Override
    public boolean update(int id, String name) {
        d.execute = "UPDATE " + d.tenbang + " SET `name`=? WHERE `id`= ?";
        try {
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            d.sttm.setString(1, name);   
            d.sttm.setInt(2, id);
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
    public hangxe find(int id) {
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                if (new hangxe(d.rs).getId() == id) {
                    return new hangxe(d.rs);
                }
            }
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<hangxe> findAll() {
        ArrayList<hangxe> l = new ArrayList<>();
        try {
            d.rs = d.laybang("");
            while (d.rs.next()) {
                l.add(new hangxe(d.rs));
            }
        } catch (SQLException ex) {
            System.getLogger(userImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return l;
    }
}
