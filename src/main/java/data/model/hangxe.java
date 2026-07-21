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
public class hangxe {

    int id;
    String hangxe;

    public hangxe(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.hangxe = rs.getString("hangxe");
        } catch (SQLException ex) {
            System.getLogger(hangxe.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public hangxe(int id, String hangxe) {
        this.id = id;
        this.hangxe = hangxe;
    }

    public int getId() {
        return id;
    }

    public String getHangxe() {
        return hangxe;
    }

}
