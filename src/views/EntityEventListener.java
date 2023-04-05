/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package views;

import entities.Entity;

/**
 *
 * @author Marci
 * @param <T>
 */
public interface EntityEventListener<T extends Entity> {

    void entityAdded(T t);

    void entityUpdated(T t);

    void entityDeleted(T t);

}
