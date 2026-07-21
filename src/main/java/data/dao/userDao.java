package data.dao;

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
public interface userDao {

    public user findUser(String emailphone, String password);

    public boolean Insert(String name, String email, String phone, String password, String role);

    public boolean delete(int id);
    
    public boolean update(int id, String name, String email, String phone, String password, String role);
    public boolean update(int id, String name, String email, String phone, String role);
            
    public user find(int id);

    public ArrayList<user> findAll();

    public user findUser(String emailphone) ;
}
