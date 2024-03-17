package ra.business.entity;

import ra.business.config.InputMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private Date dob;
    private String address;
    private String phone;
    private double salary;
    private double coefficient;

    public Employee() {
    }

    public Employee(int id, String name, Date dob, String address, String phone, double salary, double coefficient) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void inputData() {
        System.out.println("Nhập mã nhân viên: ");
        this.id = Integer.parseInt(InputMethods.getString());
        System.out.println("Nhập tên nhân viên: ");
        this.name = InputMethods.getString();
        System.out.println("Nhập ngày tháng năm sinh nhân viên: ");
        this.dob = InputMethods.getDate();
        System.out.println("Nhập địa chỉ: ");
        this.address = InputMethods.getString();
        System.out.println("Nhập số điện thoại: ");
        this.phone = InputMethods.getString();
        System.out.println("Nhập lương cơ bản: ");
        this.salary = InputMethods.getDouble();
        System.out.println("Nhập hệ số năng suất: ");
        this.coefficient = InputMethods.getDouble();
    }

    @Override
    public String toString() {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        return "Employee {" +
                "id= " + id +
                ", name = '" + name + '\'' +
                ", dob = " + dob +
                ", address = '" + address + '\'' +
                ", phone = '" + phone + '\'' +
                ", salary = " + salary +
                ", coefficient = " + coefficient +
                '}';
    }
}