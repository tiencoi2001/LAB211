
import entity.Task;
import java.text.SimpleDateFormat;
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
public class View {

    TaskManagement tm;

    public View(TaskManagement tm) {
        this.tm = tm;
    }

    public Task inputTask() {
        DataInput in = new DataInput();

        int id = tm.ID();
        String requirementName = in.inputString("Requirement Name");
        String taskType = in.getType();
        Date date = in.inputDate();
        double planFrom = in.inputPlanFrom();
        double planTo = in.inputPlanTo(planFrom);
        String assign = in.inputString("Assignee");
        String reviewer = in.inputString("Reviewer");

        Task t = new Task(id, taskType, requirementName, date, planFrom, planTo, assign, reviewer);
        return t;
    }

    public void addTask() {
        DataInput in = new DataInput();
        System.out.println("-------Add Task-------");
        while (true) {
            tm.removeId();
            Task t = inputTask();
            tm.addTask(t);
            System.out.println("Add product successful.");
            System.out.println("");
            if (!in.checkYesNo()) {
                break;
            } else {
                continue;
            }
        }
    }

    public void removeTask() {
        DataInput in = new DataInput();
        tm.removeId();
        System.out.println("-------Del Task-------");
        while (true) {
            if (tm.checkTaskList()) {
                System.out.println("List empty! You must add task first.");
                System.out.println("");
                break;
            }
            System.out.println("List task");
            display();
            int id = in.inputExistedID(tm.getTaskList());
            tm.deleteTask(id);
            System.out.println("Remove employee successful.");
            System.out.println("");
            System.out.println("List after deteled");
            display();
            if (!in.checkYesNo()) {
//                            tm.setNewID();
                break;
            } else {
                continue;
            }
        }
    }

    public void displayTask() {
        System.out.println("-----------------------------------Task-----------------------------------");
        if (tm.checkTaskList()) {
            System.out.println("List empty! You must add task first.");
            System.out.println("");
            return;
        }
        display();
    }

    public void display() {
        System.out.printf("%-3s | %-15s | %-10s | %-10s | %-5s | %-8s | %-7s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Task t : tm.getTaskList()) {
            System.out.printf("%-3s | %-15s | %-10s | %-10s | %-5s | %-8s | %-7s\n",
                    t.getId(), t.getRequirementName(), t.getTaskType(), sdf.format(t.getDate()),
                    t.getPlanTo() - t.getPlanFrom(), t.getAssign(), t.getReviewer());
        }
    }

}
