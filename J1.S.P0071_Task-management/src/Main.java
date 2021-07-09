
import entity.ID;
import entity.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static void main(String[] args) throws ParseException {
        List<Task> task = new ArrayList<>();

        Main m = new Main();
        DataInput in = new DataInput();
        TaskManagement tm = new TaskManagement(task);
        View v = new View(tm);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//        task.add(new Task(1, "Code", "Dev Program", sdf.parse("06/06/2020"), 8, 15, "Dev", "Lead"));
//        task.add(new Task(2, "Test", "Test Program", sdf.parse("07/06/2020"), 9, 15.5, "Dev", "Lead"));        
//        task.add(new Task(3, "Design", "Design Program", sdf.parse("10/06/2020"), 10.5, 17.5, "Dev", "Lead"));        
//        task.add(new Task(4, "Review", "Review Program", sdf.parse("13/06/2020"), 9.5, 12, "Dev", "Lead"));       
//        task.add(new Task(5, "Code", "Coder", sdf.parse("13/06/2020"), 9.5, 16, "Coder", "Lead"));        
        boolean isStop = false;
        while (!isStop) {
            m.displayMenu();
            int choice = in.inputChoice(1, 4);
            switch (choice) {
                case 1: {
                    tm.loadId();
                    v.addTask();
                    break;
                }
                case 2: {
                    tm.loadId();
                    v.removeTask();
                    break;
                }
                case 3: {
                    v.displayTask();
                    break;
                }
                case 4: {
                    isStop = true;
                    break;
                }
                case 5: {
                    tm.removeId();
                    break;
                }
            }
        }
    }

    private void displayMenu() {
        System.out.println("=======Task program=======");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }
}
