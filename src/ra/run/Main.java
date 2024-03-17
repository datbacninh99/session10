package ra.run;

import ra.business.config.InputMethods;
import ra.business.design.CRUD;
import ra.business.implement.EmployeeImplement;
import ra.business.entity.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static CRUD employeeImplement = new EmployeeImplement();

    public static void main(String[] args) {
        while (true) {
            System.out.println("*********************MENU********************** \n" +
                    "1.\tThêm mới 1 nhân viên \n" +
                    "2.\tHiển thị danh sách thông tin nhân viên \n" +
                    "3.\tXem thông tin nhân viên theo mã nhân viên\n" +
                    "4.\tCập nhật thông tin nhân viên\n" +
                    "5.\tXóa nhân viên\n" +
                    "6.\tTìm kiếm nhân viên theo tên (tương đối)\n" +
                    "7.\tSắp xếp và hiển thị danh sách nhân viên theo tên từ a - z\n" +
                    "8.\tThoát\n" +
                    "Nhập từ 1 - 8: \n");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    employeeImplement.create();
                    break;
                case 2:
                    employeeImplement.display();
                    break;
                case 3:
                    viewEmployeeById();
                    break;
                case 4:
                    employeeImplement.edit();
                    break;
                case 5:
                    employeeImplement.delete();
                    break;
                case 6:
                    searchEmployeeByName();
                    break;
                case 7:
                    sortAndDisplayEmployeeByName();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    private static void viewEmployeeById() {
        System.out.println("Nhập mã nhân viên cần xem: ");
        int id = InputMethods.getInteger();
        boolean check = false;
        for (Employee employee : ((EmployeeImplement) employeeImplement).getEmployees()) {
            if (employee != null && employee.getId() == id) {
                check = true;
                System.out.println("Thông tin nhân viên:");
                System.out.println(employee);
                break;
            }
        }
        if (check) {
            System.err.println("Không tìm thấy nhân viên có mã " + id);
        }
    }

    private static void searchEmployeeByName() {
        System.out.println("Nhập tên nhân viên cần tìm: ");
        String name = InputMethods.getString().toLowerCase();
        boolean check = false;
        for (Employee employee : ((EmployeeImplement) employeeImplement).getEmployees()) {
            if (employee != null && employee.getName().toLowerCase().contains(name)) {
                check = true;
                System.out.println("Thông tin nhân viên:");
                System.out.println(employee);
            }
        }
        if (check) {
            System.err.println("Không tìm thấy nhân viên có tên chứa \"" + name + "\"");
        }
    }

    private static void sortAndDisplayEmployeeByName() {
        Employee[] sortedEmployees = Arrays.copyOf(((EmployeeImplement) employeeImplement).getEmployees(), ((EmployeeImplement) employeeImplement).getSize());
        Arrays.sort(sortedEmployees, Comparator.comparing(Employee::getName));
        if (sortedEmployees.length == 0) {
            System.err.println("Danh sách nhân viên rỗng.");
        } else {
            System.out.println("Danh sách nhân viên được sắp xếp theo tên:");
            for (Employee employee : sortedEmployees) {
                System.out.println(employee);
            }
        }
    }
}