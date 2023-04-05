/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import entities.CEO;
import exceptions.PersistenceException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marci
 */
public class CEOService {

    private CEODAO dao;

    public CEOService() {
        dao = new CEODAO();
    }

    public final void save(CEO t) throws PersistenceException {
        try {
            dao.create(t);
        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    public final void update(CEO t) throws PersistenceException {
        try {
            dao.update(t);
        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    public final void delete(Long id) throws PersistenceException {
        try {
            dao.remove(id);
        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    public final CEO getCEO(Long id) throws PersistenceException {
        try {
            return dao.read(id);
        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    public final List getAllEntities() throws PersistenceException {
        try {
            return dao.readAll();
        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

}
