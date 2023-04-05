/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Marci
 */
public class CEO implements Entity<Long> {

    private Long id;
    private String name;
    private int employees;

    public CEO(Long id, String name, int employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "CEO{" + "id=" + id + ", name=" + name + ", employees=" + employees + '}';
    }

}
