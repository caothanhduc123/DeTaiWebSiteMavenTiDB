/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.impl;

import data.dao.carDao;
import data.driver.driver;
import data.model.car;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author parrot
 */
public class carImpl implements carDao {

    public driver d = new driver("Car");

    @Override
    public ArrayList<car> findAll() {
        try {
            ArrayList<car> lc = new ArrayList<>();
            d.laybang("");
            while (d.rs.next()) {
                lc.add(new car(d.rs.getInt("id"),
                        d.rs.getString("ten"),
                        d.rs.getInt("namsanxuat"),
                        d.rs.getDouble("giaban"),
                        d.rs.getString("image"),
                        d.rs.getString("kieudang"),
                        d.rs.getString("hopso"),
                        d.rs.getString("nhienlieu"),
                        d.rs.getInt("id_loaixe"),
                        d.rs.getString("mota"),
                        d.rs.getString("power"),
                        d.rs.getString("acceleration"),
                        d.rs.getString("topspeed"),
                        d.rs.getString("engine"),
                        d.rs.getString("DungTich"),
                        d.rs.getString("TruyenDong"),
                        d.rs.getString("CongNghe"),
                        d.rs.getString("TrongLuong")));
            }
            return lc;
        } catch (SQLException ex) {
            System.getLogger(carImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    @Override
    public car find(int id) {
        try {
            d.laybang("where id = " + id);
            if (d.rs.next()) {
                return new car(d.rs.getInt("id"),
                        d.rs.getString("ten"),
                        d.rs.getInt("namsanxuat"),
                        d.rs.getDouble("giaban"),
                        d.rs.getString("image"),
                        d.rs.getString("kieudang"),
                        d.rs.getString("hopso"),
                        d.rs.getString("nhienlieu"),
                        d.rs.getInt("id_loaixe"),
                        d.rs.getString("mota"),
                        d.rs.getString("power"),
                        d.rs.getString("acceleration"),
                        d.rs.getString("topspeed"),
                        d.rs.getString("engine"),
                        d.rs.getString("DungTich"),
                        d.rs.getString("TruyenDong"),
                        d.rs.getString("CongNghe"),
                        d.rs.getString("TrongLuong"));
            }
        } catch (SQLException ex) {
            System.getLogger(carImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
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
    public boolean insert(car c) {
        try {
            d.execute = "INSERT INTO `Car` (`ten`, `namsanxuat`, `giaban`, `image`, `kieudang`, `hopso`, `nhienlieu`, `id_loaixe`, `mota`, `power`, `acceleration`, `topspeed`, `engine`, `DungTich`, `TruyenDong`, `CongNghe`, `TrongLuong`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            int i = 1;
            d.sttm.setString(i++, c.getTen());
            d.sttm.setInt(i++, c.getNamsanxuat());
            d.sttm.setDouble(i++, c.getGiaban());
            d.sttm.setString(i++, c.getImage());
            d.sttm.setString(i++, c.getKieudang());
            d.sttm.setString(i++, c.getHopso());
            d.sttm.setString(i++, c.getNhienlieu());
            d.sttm.setInt(i++, c.getId_loaixe());
            d.sttm.setString(i++, c.getMota());
            d.sttm.setString(i++, c.getPower());
            d.sttm.setString(i++, c.getAcceleration());
            d.sttm.setString(i++, c.getTopspeed());
            d.sttm.setString(i++, c.getEngine());
            d.sttm.setString(i++, c.getDungTich());
            d.sttm.setString(i++, c.getTruyenDong());
            d.sttm.setString(i++, c.getCongNghe());
            d.sttm.setString(i++, c.getTrongLuong());

            int row = d.sttm.executeUpdate();
            return row > 0;

        } catch (SQLException ex) {
            System.getLogger(carImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    @Override
    public boolean update(int id, String ten, int id_loaixe, int namsanxuat, double giaban, String kieudang, String mota) {
        try {
            d.execute = "UPDATE `Car` SET `ten`=?,`namsanxuat`=?,`giaban`=?,`kieudang`=?,`id_loaixe`=?,`mota`=? WHERE `id`=?";
            d.sttm = d.ketnoi.prepareStatement(d.execute);
            int i = 1;
            d.sttm.setString(i++, ten);
            d.sttm.setInt(i++, namsanxuat);
            d.sttm.setDouble(i++, giaban);
            d.sttm.setString(i++, kieudang);
            d.sttm.setInt(i++, id_loaixe);
            d.sttm.setString(i++, mota);
            d.sttm.setInt(i++, id);
            int row = d.sttm.executeUpdate();
            return row > 0;
        } catch (SQLException ex) {
            System.getLogger(carImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
}
