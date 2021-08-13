
import entity.Task;
import java.util.ArrayList;
import java.util.List;
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
    private ArrayList<ID> listID = new ArrayList<>();

    public TaskManagement(List<Task> task) {
        this.taskList = task;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int ID() {
        if (taskList.isEmpty() && listID.isEmpty()) {
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
        for (int i = 0; i < listID.size() - 1; i++) {
            listID.remove(i);
            i--;
        }
        return listID;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int id) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                taskList.remove(i);
            }
        }
    }
}
