package ra.business.design;

import ra.business.entity.Employee;

public interface CRUD {
    void create();

    void display();

    void edit();

    void delete();

    Employee[] getEmployees();

    int getSize();
}