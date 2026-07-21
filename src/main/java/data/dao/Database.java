/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dao;

import data.driver.driver;
import data.impl.carImpl;
import data.impl.donhangImpl;
import data.impl.hangxeImpl;
import data.impl.mycartImpl;
import data.impl.userImpl;
import java.sql.SQLException;

/**
 *
 * @author parrot
 */
public class Database {
    public static void CloseProcess(){
        driver d = new driver("");
        try {
            d.ketnoi.close();
        } catch (SQLException ex) {
            System.getLogger(Database.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    public static carDao getCar(){
        return new carImpl();
    }
    public static userDao getuser(){
        return new userImpl();
    }
    public static hangxeDao gethangxe(){
        return new hangxeImpl();
    }
    public static mycartDao getmycart(){
        return new mycartImpl();
    }
    public static donhangDao getdonhang(){
        return new donhangImpl();
    }
}
