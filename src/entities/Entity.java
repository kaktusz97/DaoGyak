/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Marci
 * @param <PK>
 */
public interface Entity<PK extends Serializable> {

    PK getId();
}
