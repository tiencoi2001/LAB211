
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        task.add(new Task(1, "Code", "Dev Program", sdf.parse("06/06/2020"), 8, 15, "Dev", "Lead"));
        task.add(new Task(2, "Test", "Test Program", sdf.parse("07/06/2020"), 9, 15.5, "Dev", "Lead"));        
        task.add(new Task(3, "Design", "Design Program", sdf.parse("10/06/2020"), 10.5, 17.5, "Dev", "Lead"));        
        task.add(new Task(4, "Review", "Review Program", sdf.parse("13/06/2020"), 9.5, 12, "Dev", "Lead"));       
        task.add(new Task(5, "Code", "Coder", sdf.parse("13/06/2020"), 9.5, 16, "Coder", "Lead"));        
        
        boolean isStop = false;
        while (!isStop) {
            m.displayMenu();
            int choice = in.inputChoice(1, 4);
            tm.removeId();
            switch (choice) {
                case 1: {
                    System.out.println("-------Add Task-------");
                    while (true) {
                        Task t = tm.inputTask();
                        tm.addTask(t);
                        System.out.println("Add product successful.");
                        System.out.println("");
                        if (!in.checkYesNo()) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("-------Del Task-------");

                    while (true) {
                        if (task.isEmpty()) {
                            System.out.println("List empty! You must add task first.");
                            System.out.println("");
                            break;
                        }
                        System.out.println("List task");
                        tm.display(task);
                        int id = in.inputExistedID(task);
                        tm.deleteTask(id);
                        System.out.println("Remove employee successful.");
                        System.out.println("");
                        System.out.println("List after deteled");
                        tm.display(task);
                        if (!in.checkYesNo()) {
//                            tm.setNewID();
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("-----------------------------------Task-----------------------------------");
                    if (task.isEmpty()) {
                        System.out.println("List empty! You must add task first.");
                        System.out.println("");
                        break;
                    }
                    tm.display(task);
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
