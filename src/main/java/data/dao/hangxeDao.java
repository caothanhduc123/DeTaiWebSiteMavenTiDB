/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.dao;

import data.model.hangxe;
import java.util.ArrayList;

/**
 *
 * @author parrot
 */
public interface hangxeDao {

    public boolean Insert(String name);

    public boolean update(int id, String name);

    public boolean delete(int id);

    public hangxe find(int id);

    public ArrayList<hangxe> findAll();
}
