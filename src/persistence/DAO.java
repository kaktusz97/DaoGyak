/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence;

import entities.Entity;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marci
 * @param <PK>
 * @param <T>
 */
public interface DAO<PK extends Serializable, T extends Entity> {

    public void create(T t) throws SQLException;

    public T read(PK id) throws SQLException;

    public void update(T t) throws SQLException;

    public void remove(PK id) throws SQLException;

    public List<T> readAll() throws SQLException;

}
