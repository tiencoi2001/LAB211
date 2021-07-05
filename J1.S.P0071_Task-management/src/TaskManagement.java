
import entity.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import entity.ID;

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

    private ArrayList<ID> listID = new ArrayList<>();

    public Task inputTask() {
        DataInput in = new DataInput();

        int id = ID();
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

    public int ID() {
        if (taskList.isEmpty()) {
            listID.add(new ID(1));
            return 1;
        }
        loadId();
        listID.add(new ID(listID.get(listID.size() - 1).getId() + 1));
        return listID.get(listID.size() - 1).getId();
    }

    public List loadId() {
        if (!taskList.isEmpty() && listID.isEmpty()) {
            for (int i = 0; i < taskList.size(); i++) {
                listID.add(new ID(taskList.get(i).getId()));
            }
        }
        return listID;
    }

    public List removeId() {
        loadId();
        for (int i = 0; i < listID.size() - 1; i++) {
            listID.remove(i);
            i--;
        }
        return listID;
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
