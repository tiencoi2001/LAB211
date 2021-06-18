
import java.util.List;
import entity.Employee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class EmployeeManagement {

    private List<Employee> employee;

    public EmployeeManagement(List<Employee> employee) {
        this.employee = employee;
    }
    
    public void addEmployee() {
        DataInput in = new DataInput();
        while (true) {
            String id = in.inputID(employee);
            String firstName = in.inputName("First name");
            String lastName = in.inputName("Last name");
            String phone = in.inputPhone();
            String email = in.inputEmail();
            String address = in.inputString("Address");
            Date DOB = in.inputDate();
            String sex = in.inputSex();
            double salary = in.inputSalary();
            String acency = in.inputString("Acency");

            Employee e = new Employee(id, firstName, lastName, phone, email, address, DOB, sex, salary, acency);
            employee.add(e);

            System.out.println("Add product successful.");
            System.out.println("");
            System.out.println("LIST EMPLOYEES");
            displayAll(employee);
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

    private void displayAll(List<Employee> employee) {
        System.out.printf("%-10s | %-11s | %-11s | %-13s | %-20s | %-18s | %-15s | %-8s | %-10s | %-15s\n",
                "Id", "FirstName", "LastName", "Phone number", "Email",
                "Address", "Date of birth", "Sex", "Salary", "Agency");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Employee e : employee) {
            System.out.printf("%-10s | %-11s | %-11s | %-13s | %-20s | %-18s | %-15s | %-8s | %-10.3f | %-15s\n",
                    e.getId(), e.getFirstName(), e.getLastName(),
                    e.getPhoneNumber(), e.getEmail(), e.getAddress(),
                    sdf.format(e.getDOB()), e.getSex(), e.getSalary(), e.getAgency());
        }
    }

    public void updateEmployee() {
        if (employee.isEmpty()) {
            System.out.println("Please enter employee first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            String id = in.inputExistedID(employee);
            Employee e = getEmployeeByID(id);
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

            System.out.println("Update employee successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll(employee);
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

    private Employee getEmployeeByID(String id) {
        for (Employee e : employee) {
            if (id.equals(e.getId())) {
                return e;
            }
        }
        return null;
    }

    public void removeEmployee() {
        if (employee.isEmpty()) {
            System.out.println("No data to take action.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            String id = in.inputExistedID(employee);
            for (int i = 0; i < employee.size(); i++) {
                if (employee.get(i).getId().equals(id)) {
                    employee.remove(i);
                    break;
                }
            }
            System.out.println("Remove employee successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll(employee);
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
        if (employee.isEmpty()) {
            System.out.println("Please enter employee first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            String searchValue = in.inputSearchValue();
            List<Employee> searched = searchByName(employee, searchValue);
            if (searched.isEmpty()) {
                System.out.println("There are no employee match with "
                        + "\"" + searchValue + "\"");
                return;
            }
            System.out.println("");
            System.out.println("LIST OF EMPLOYEES FOUND");
            System.out.printf("%-10s | %-11s | %-11s | %-13s | %-20s | %-18s | %-15s | %-8s | %-10s | %-15s\n",
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

    private String plusString(String firstName, String lastName) {
        String str;
        str = firstName + " " + lastName;
        return str;
    }

    private void displayEmployee(Employee e) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-10s | %-11s | %-11s | %-13s | %-20s | %-18s | %-15s | %-8s | %-10.3f | %-15s\n",
                e.getId(), e.getFirstName(), e.getLastName(),
                e.getPhoneNumber(), e.getEmail(), e.getAddress(),
                sdf.format(e.getDOB()), e.getSex(), e.getSalary(), e.getAgency());
    }

    private List<Employee> searchByName(List<Employee> employee, String searchValue) {
        List<Employee> searched = new ArrayList<>();
        for (Employee e : employee) {
            if (plusString(e.getFirstName(), e.getLastName()).toLowerCase().contains(searchValue.toLowerCase())) {
                searched.add(e);
            }
        }
        return searched;
    }

    public void sortBySalary() {
        if (employee.isEmpty()) {
            System.out.println("Please enter employee first.");
            System.out.println("");
            return;
        }
        if (employee.size() < 2) {
            System.out.println("There is only one employee, can not sort.");
            return;
        }
        System.out.println("");
        System.out.println("LIST BEFORE SORT:");
        displayAll(employee);
        Collections.sort(employee, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("");
        System.out.println("LIST AFTER SORT:");
        displayAll(employee);
    }

}
