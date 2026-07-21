/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author parrot
 */
public class user {

    int id;
    String name;
    String email;
    String phone;
    String password;
    String role;

    public user(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.email = rs.getString("email");
            this.phone = rs.getString("phone");
            this.password = rs.getString("password");
            this.role = rs.getString("role");
        } catch (SQLException ex) {
            System.getLogger(user.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public user(int id, String name, String email, String phone, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

}
