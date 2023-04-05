/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import entities.Employee;
import exceptions.PersistenceException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marci
 */
public class EmployeeService {

    private EmployeeDAO dao;

    public EmployeeService() {
        this.dao = new EmployeeDAO();
    }

    public final void save(Employee t) throws PersistenceException {
        try {
            dao.create(t);
        } catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    public final void update(Employee t) throws PersistenceException {
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

    public final Employee getEmployee(Long id) throws PersistenceException {
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
