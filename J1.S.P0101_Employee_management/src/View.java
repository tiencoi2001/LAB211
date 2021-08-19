
import entity.Employee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoang Tran
 */
public class View {

    EmployeeManagement em;

    public View(EmployeeManagement em) {
        this.em = em;
    }

    public Employee inputEmployee() {
        DataInput in = new DataInput();
        String id = in.inputID(em.getEmployee());
        String firstName = in.inputName("First name");
        String lastName = in.inputName("Last name");
        String phone = in.inputPhone();
        String email = in.inputEmail();
        String address = in.inputString("Address");
        Date DOB = in.inputDate();
        if (in.checkAge(DOB) == false) {
            return null;
        }
        String sex = in.inputSex();
        double salary = in.inputSalary();
        String acency = in.inputString("Acency");

        Employee e = new Employee(id, firstName, lastName, phone, email, address, DOB, sex, salary, acency);
        return e;
    }

    public void addEmployee() {
        DataInput in = new DataInput();
        while (true) {
            Employee e = inputEmployee();
            if (e == null) {
                if (!in.checkYesNo("Press \"Y\" if you want to add another employee,"
                        + " press \"N\" if you want to end the action.")) {
                    return ;
                } else {
                    continue;
                }
            }
            em.addEmployee(e);
            System.out.println("Add employee successful.");
            System.out.println("");
            System.out.println("LIST EMPLOYEES");
            displayAll();
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Add all employees successful.");
        System.out.println("");
    }

    private void displayAll() {
        System.out.printf("%-10s | %-11s | %-11s | %-20s | %-20s | %-18s | %-15s | %-8s | %-10s | %-15s\n",
                "Id", "FirstName", "LastName", "Phone number", "Email",
                "Address", "Date of birth", "Sex", "Salary", "Agency");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Employee e : em.getEmployee()) {
            System.out.printf("%-10s | %-11s | %-11s | %-20s | %-20s | %-18s | %-15s | %-8s | %-10.3f | %-15s\n",
                    e.getId(), e.getFirstName(), e.getLastName(),
                    e.getPhoneNumber(), e.getEmail(), e.getAddress(),
                    sdf.format(e.getDOB()), e.getSex(), e.getSalary(), e.getAgency());
        }
    }

    public void updateEmployee() {
        if (em.getEmployee().isEmpty()) {
            System.out.println("Please enter employee first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            String id = in.inputExistedID(em.getEmployee());
            Employee e = new Employee(em.getEmployeeByID(id).getId() ,em.getEmployeeByID(id).getFirstName(),
                    em.getEmployeeByID(id).getLastName(), em.getEmployeeByID(id).getPhoneNumber(),
                    em.getEmployeeByID(id).getEmail(), em.getEmployeeByID(id).getAddress(),
                    em.getEmployeeByID(id).getDOB(), em.getEmployeeByID(id).getSex(),
                    em.getEmployeeByID(id).getSalary(), em.getEmployeeByID(id).getAgency());
            if (in.checkYesNo("Do you want to update first name? Choose Yes(Y) to update, No(N) to continue.")) {
                String firstName = in.inputName("First name");
                e.setFirstName(firstName);
            }
            if (in.checkYesNo("Do you want to update last name? Choose Yes(Y) to update, No(N) to continue.")) {
                String lastName = in.inputName("Last name");
                e.setLastName(lastName);
            }
            if (in.checkYesNo("Do you want to update phone? Choose Yes(Y) to update, No(N) to continue.")) {
                String phone = in.inputPhone();
                e.setPhoneNumber(phone);
            }
            if (in.checkYesNo("Do you want to update email? Choose Yes(Y) to update, No(N) to continue.")) {
                String email = in.inputEmail();
                e.setEmail(email);
            }
            if (in.checkYesNo("Do you want to update addres? Choose Yes(Y) to update, No(N) to continue.")) {
                String address = in.inputString("Address");
                e.setAddress(address);
            }
            if (in.checkYesNo("Do you want to update date of birth? Choose Yes(Y) to update, No(N) to continue.")) {
                Date DOB = in.inputDate();
                e.setDOB(DOB);
            }
            if (in.checkYesNo("Do you want to update sex? Choose Yes(Y) to update, No(N) to continue.")) {
                String sex = in.inputSex();
                e.setSex(sex);
            }
            if (in.checkYesNo("Do you want to update salary? Choose Yes(Y) to update, No(N) to continue.")) {
                double salary = in.inputSalary();
                e.setSalary(salary);
            }
            if (in.checkYesNo("Do you want to update acency? Choose Yes(Y) to update, No(N) to continue.")) {
                String acency = in.inputString("Acency");
                e.setAgency(acency);
            }
            em.updateEmployee(e);
            System.out.println("Update employee successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll();
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Update all employees successful.");
        System.out.println("");
    }

    public void removeEmployee() {
        DataInput in = new DataInput();
        while (true) {
            if (em.getEmployee().isEmpty()) {
                System.out.println("No data to take action.");
                System.out.println("");
                return;
            }
            String id = in.inputExistedID(em.getEmployee());
            em.removeEmployee(id);
            System.out.println("Remove employee successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll();
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
    }

    public void searchEmployee() {
        if (em.getEmployee().isEmpty()) {
            System.out.println("Please enter employee first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            String searchValue = in.inputSearchValue();
            List<Employee> searched = em.searchByName(em.getEmployee(), searchValue);
            if (searched.isEmpty()) {
                System.out.println("There are no employee match with "
                        + "\"" + searchValue + "\"");
                return;
            }
            System.out.println("");
            System.out.println("LIST OF EMPLOYEES FOUND");
            System.out.printf("%-10s | %-11s | %-11s | %-20s | %-20s | %-18s | %-15s | %-8s | %-10s | %-15s\n",
                    "Id", "FirstName", "LastName", "Phone number", "Email",
                    "Address", "Date of birth", "Sex", "Salary", "Agency");

            for (Employee em : searched) {
                displayEmployee(em);
            }
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
    }

    private void displayEmployee(Employee e) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-10s | %-11s | %-11s | %-20s | %-20s | %-18s | %-15s | %-8s | %-10.3f | %-15s\n",
                e.getId(), e.getFirstName(), e.getLastName(),
                e.getPhoneNumber(), e.getEmail(), e.getAddress(),
                sdf.format(e.getDOB()), e.getSex(), e.getSalary(), e.getAgency());
    }

    public void sortBySalary() {
        if (em.getEmployee().isEmpty()) {
            System.out.println("Please enter employee first.");
            System.out.println("");
            return;
        }
        if (em.getEmployee().size() < 2) {
            System.out.println("There is only one employee, can not sort.");
            return;
        }
        System.out.println("");
        System.out.println("LIST BEFORE SORT:");
        displayAll();
        em.sortBySalary();
        System.out.println("");
        System.out.println("LIST AFTER SORT:");
        displayAll();
        System.out.println("");
    }
}
