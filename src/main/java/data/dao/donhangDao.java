package data.dao;

import data.model.donhang;
import data.model.user;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author parrot
 */
public interface donhangDao {

    public boolean Insert(int id_khachhang, double tongtien, String trangthai, Date ngay_mua, int id_car, int id_user);

    public boolean delete(int id);
            

    public ArrayList<donhang> findAll();

    public donhang finddonhang(int id_user) ;
    public boolean xacnhandonhang(int id_dh) ;
    public donhang finddonhang(int id_user, int id_car) ;
}
