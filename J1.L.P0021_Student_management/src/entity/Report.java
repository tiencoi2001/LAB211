/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Vu Duc Tien
 */
public class Report {
    String id;
    String studentName;
    String course;
    int total;

    public Report(String id, String studentName, String course, int total) {
        this.id = id;
        this.studentName = studentName;
        this.course = course;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getTotal() {
        return total;
    }
}
