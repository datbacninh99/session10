package ra.business.implement;

import ra.business.design.CRUD;
import ra.business.entity.Employee;
import ra.business.config.InputMethods;

import java.util.Arrays;

public class EmployeeImplement implements CRUD {
    private static final int MAX_EMPLOYEES = 100;
    private Employee[] employees = new Employee[MAX_EMPLOYEES];
    private int size = 0;

    @Override
    public void create() {
        if (size == MAX_EMPLOYEES) {
            System.err.println("Mảng đầy");
        } else {
            Employee newEmployee = new Employee();
            newEmployee.inputData();
            employees[size] = newEmployee;
            size++;
        }
    }

    @Override
    public void display() {
        if (size == 0) {
            System.err.println("Mảng không có phần tử");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    @Override
    public void edit() {
        System.out.println("Nhập mã nhân viên cần sửa: ");
        int id = InputMethods.getInteger();
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                check = true;
                System.out.println("Nhập thông tin mới cho nhân viên:");
                employees[i].inputData();
                System.out.println("Thông tin nhân viên đã được cập nhật!");
                break;
            }
        }
        if (!check) {
            System.err.println("Không tìm thấy nhân viên có mã " + id);
        }
    }

    @Override
    public void delete() {
        System.out.println("Nhập mã nhân viên cần xóa: ");
        int id = InputMethods.getInteger();
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                check = true;
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                size--;
                System.out.println("Nhân viên đã được xóa!");
                break;
            }
        }
        if (check) {
            System.err.println("Không tìm thấy nhân viên có mã " + id);
        }
    }

    public Employee[] getEmployees() {
        return Arrays.copyOf(employees, size);
    }

    public int getSize() {
        return size;
    }
}