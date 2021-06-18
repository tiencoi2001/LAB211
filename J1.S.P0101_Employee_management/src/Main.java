
import java.util.ArrayList;
import java.util.List;
import entity.Employee;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vu Duc Tien
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        DataInput in = new DataInput();
        List<Employee> employee = new ArrayList<>();
        EmployeeManagement em = new EmployeeManagement(employee);

        employee.add(new Employee("1", "a", "a", "+125712352422", "a123@gmail.com", "a", new Date("01/02/2001"), "male", 1241, "a"));
        employee.add(new Employee("2", "b", "b", "+127132523423", "bhe124@fpt.edu.vn", "b", new Date("01/04/2001"), "female", 121, "b"));
        employee.add(new Employee("3", "c", "c", "+235875241645", "c712@yahoo.vn", "c", new Date("16/01/2001"), "male", 232, "c"));
        employee.add(new Employee("4", "d", "d", "+235236124235", "dkjags@gmail.com", "d", new Date("13/01/2001"), "female", 346, "d"));

        boolean isStop = false;
        while (!isStop) {
            m.displayMenu();
            int choice = in.inputChoice(1, 6);
            switch (choice) {
                case 1: {
                    em.addEmployee();
                    break;
                }
                case 2: {
                    em.updateEmployee();
                    break;
                }
                case 3: {
                    em.removeEmployee();
                    break;
                }
                case 4: {
                    em.searchEmployee();
                    break;
                }
                case 5: {
                    em.sortBySalary();
                    break;
                }
                case 6: {
                    isStop = true;
                    break;
                }
            }
        }

    }

    private void displayMenu() {
        System.out.println("=======MAIN MENU=======");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }
}
