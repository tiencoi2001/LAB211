
import entity.Student;
import java.util.ArrayList;

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
        
        ArrayList<Student> registrationList = new ArrayList<>();
        StudentManagement sm = new StudentManagement(registrationList);
        View v = new View(sm);
        
        registrationList.add(new Student("HE130258", "Nguyen Van Duy", 22, ".Net", 7));
        registrationList.add(new Student("HE151114", "Nguyen Van A", 20, "Java", 6));
        registrationList.add(new Student("HE130020", "Tran Van C", 22, "C/C++", 1));
        registrationList.add(new Student("HE141543", "Nguyen Thi B", 21, "C/C++", 1));
        registrationList.add(new Student("HE141543", "Nguyen Thi B", 21, "Java", 2));
        registrationList.add(new Student("HE130258", "Nguyen Van Duy", 22, ".Net", 9));
        registrationList.add(new Student("HE151114", "Nguyen Van A", 20, "C/C++", 3));
        registrationList.add(new Student("HE130258", "Nguyen Van Duy", 22, "C/C++", 1));
        registrationList.add(new Student("HE141543", "Nguyen Thi B", 21, ".Net", 9));
        registrationList.add(new Student("HE130020", "Tran Van C", 22, ".Net", 8));
        registrationList.add(new Student("HE130258", "Nguyen Van Duy", 22, "C/C++", 5));
        registrationList.add(new Student("HE130020", "Tran Van C", 22, "Java", 3));
        registrationList.add(new Student("HE130258", "Nguyen Van Duy", 22, "Java", 1));
        registrationList.add(new Student("HE151114", "Nguyen Van A", 20, ".Net", 3));
        
        
        boolean isStop = false;
        while(!isStop){
            m.menu();
            int choice = in.inputChoice(1, 6, "Your choice");
            switch(choice){
                case 1:{
                    v.create();
                    break;
                }
                case 2:{
                    v.findAndSort();
                    break;
                }
                case 3:{
                    v.updateOrDelete();
                    break;
                }
                case 4:{
                    v.report();
                    break;
                }
                case 5:{
                    isStop = true;
                    break;
                }
            }
        }
    }
    
    private void menu(){
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");      
    }
}