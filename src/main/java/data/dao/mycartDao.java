/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import data.model.mycart;

import java.util.ArrayList;

/**
 *
 * @author parrot
 */
public interface mycartDao {

    public boolean Insert(int id_user, int id_car, int so_km_hoatdong, boolean trangthai);

    public boolean update(int id, int id_user, int id_produce, int quanlity);

    public boolean delete(int id);

    public boolean updatetrangthai(int id_user);

    public ArrayList<mycart> find(int id_user);

    public mycart find_id(int id);

    public ArrayList<mycart> findAll() ;
}
