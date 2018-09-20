package com;
public class Employee {
    private int id;
    private String name;
    private float salary;
    Employee() {

    }
    Employee(int id, String name, float salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSalary(float salary){
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getSalary() {
        return salary;
    }
}