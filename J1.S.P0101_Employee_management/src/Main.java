
import java.util.ArrayList;
import java.util.List;
import entity.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoang Tran
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Main m = new Main();
        DataInput in = new DataInput();
        List<Employee> employee = new ArrayList<>();
        EmployeeManagement em = new EmployeeManagement(employee);
        View v = new View(em);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        employee.add(new Employee("1", "tran", "hoang", "+125712352422", "a123@gmail.com", "a", sdf.parse("01/02/2001"), "male", 1241, "a"));
        employee.add(new Employee("2", "b", "b", "+127132523423", "bhe124@fpt.edu.vn", "b", sdf.parse("01/04/2001"), "female", 121, "b"));
        employee.add(new Employee("3", "c", "c", "+235875241645", "c712@yahoo.vn", "c", sdf.parse("16/01/2001"), "male", 232, "c"));
        employee.add(new Employee("4", "d", "d", "+235236124235", "dkjags@gmail.com", "d", sdf.parse("13/01/2001"), "female", 346, "d"));

        boolean isStop = false;
        while (!isStop) {
            m.displayMenu();
            int choice = in.inputChoice(1, 6);
            switch (choice) {
                case 1: {
                    v.addEmployee();
                    break;
                }
                case 2: {
                    v.updateEmployee();
                    break;
                }
                case 3: {
                    v.removeEmployee();
                    break;
                }
                case 4: {
                    v.searchEmployee();
                    break;
                }
                case 5: {
                    v.sortBySalary();
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
