/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Chien;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tun21
 */
public interface IChien<I> {
    public void addChien(I c) throws SQLException;
    public void updateChien(I c) throws SQLException;
    public void deleteChien(int id) throws SQLException;
    public Chien findChienById(int id) throws SQLException;
    public List<I> displayChiens() throws SQLException;
    
}
