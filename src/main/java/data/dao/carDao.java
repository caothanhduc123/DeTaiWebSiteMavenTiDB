/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import data.model.car;
import java.util.ArrayList;

/**
 *
 * @author parrot
 */
public interface carDao {
    public ArrayList<car> findAll();
    public car find(int id);
    public boolean delete(int id);
    public boolean insert(car c);
    public boolean update(int id, String ten, int id_loaixe, int namsanxuat, double giaban, String kieudang, String mota );
}
