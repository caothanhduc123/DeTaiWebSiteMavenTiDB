/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author parrot
 */
public class mycart {

    int id;
    int id_user;
    int id_car;
    int so_km_hoatdong;
    boolean trangthai;
    public mycart(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.id_user = rs.getInt("id_user");
            this.id_car = rs.getInt("id_car");
            this.so_km_hoatdong = rs.getInt("so_km_hoatdong");
            this.trangthai = rs.getBoolean("trangthai");
        } catch (SQLException ex) {
//            System.getLogger(categorie.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public mycart(int id, int id_user, int id_car, int so_km_hoatdong, boolean trangthai) {
        this.id = id;
        this.id_user = id_user;
        this.id_car = id_car;
        this.so_km_hoatdong = so_km_hoatdong;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_car() {
        return id_car;
    }

    public int getSo_km_hoatdong() {
        return so_km_hoatdong;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    

   

    

    

  


}
