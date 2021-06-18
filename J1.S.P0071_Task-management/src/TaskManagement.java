
import entity.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vu Duc Tien
 */
public class TaskManagement {

    private List<Task> taskList;

    public TaskManagement(List<Task> task) {
        this.taskList = task;
    }

    public Task inputTask() {
        DataInput in = new DataInput();

//        int id = taskList.size() + 1;
        int id = taskList.get(taskList.size() - 1).getId() + 1;
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

    public List<Task> addTask(Task task) {
        taskList.add(task);
        return taskList;
    }

    public List<Task> deleteTask(int id) {        
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                taskList.remove(i);
            }
        }
        return taskList;
    }

//    public List<Task> setNewID() {
//        for (int i = 0; i < taskList.size(); i++) {
//            taskList.get(i).setId(i + 1);
//        }
//        return taskList;
//    }

    public void display(List<Task> list) {
        System.out.printf("%-3s | %-15s | %-10s | %-10s | %-5s | %-8s | %-7s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Task t : list) {
            System.out.printf("%-3s | %-15s | %-10s | %-10s | %-5s | %-8s | %-7s\n",
                    t.getId(), t.getRequirementName(), t.getTaskType(), sdf.format(t.getDate()),
                    t.getPlanTo() - t.getPlanFrom(), t.getAssign(), t.getReviewer());
        }
    }
}
