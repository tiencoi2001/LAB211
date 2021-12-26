
import entity.Report;
import entity.Student;
import entity.StudentAndPos;
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
public class View {

    StudentManagement sm;

    public View(StudentManagement sm) {
        this.sm = sm;
    }

    private Student inputInfo() {
        DataInput in = new DataInput();

        String id = in.inputString("Student ID").toUpperCase();
        String name;
        int age = 0;
        String course;
        int semester;
        Student s = sm.getStudentByID(id);
        if (s != null) {
            name = s.getStudentName();
            age = s.getAge();
        } else {
            name = in.inputString("Student name");
            age = in.inputChoice(18, 100, "Age");
        }
        course = in.getCourseByChoice();
        semester = in.inputChoice(1, 9, "Semester");

        Student student = new Student(id, name, age, course, semester);
        return student;
    }

    public void create() {
        DataInput in = new DataInput();
        System.out.println("-------Create-------");
        while (true) {
            Student s = inputInfo();
            if (s != null) {
                if (!sm.isExitRegistration(s)) {
                    sm.create(s);
                    System.out.println("Registration successful.");
                    System.out.println("");
                } else {
                    System.out.println("You already registered for " + s.getCourse() + " course for "
                            + s.getSemester() + " term, you don't need to re-register.");
                    System.out.println("");
                }
            }
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
    }

    public void display(ArrayList<Student> list) {
        System.out.printf("%-10s | %-30s | %-10s | %-10s | %-5s\n", "ID", "Student name", "Age", "Course", "Semester");
        for (Student s : list) {
            System.out.printf("%-10s | %-30s | %-10d | %-10s | %-5d\n", s.getId(), s.getStudentName(), s.getAge(), s.getCourse(), s.getSemester());
        }
    }

    public void findAndSort() {
        DataInput in = new DataInput();

        if (sm.getRegistrationList().isEmpty()) {
            System.out.println("Please register first.");
        }
        System.out.println("-------Find and Sort-------");
        while (true) {
            String keyword = in.inputString("Entner search keyword");
            ArrayList<Student> searched = sm.find(keyword);
            if (searched.isEmpty()) {
                System.out.println("There are no product match with "
                        + "\"" + keyword + "\"");
                return;
            }
            sm.sort(searched);
            System.out.println("");
            System.out.println("LIST SEARCHED AND SORT");
            display(searched);
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
    }

    public void updateOrDelete() {
        DataInput in = new DataInput();

        if (sm.getRegistrationList().isEmpty()) {
            System.out.println("Please register first.");
        }
        System.out.println("-------Update/Delete-------");
        while (true) {
            String choice = in.UorD();
            if (choice.equalsIgnoreCase("U")) {
                String id = in.inputString("ID").toUpperCase();
                if (sm.getStudentByID(id) == null) {
                    System.out.println("ID not found.");
                    if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                            + " press \"N\" if you want to end the action.")) {
                        return;
                    } else {
                        continue;
                    }
                }
                while (true) {
                    ArrayList<StudentAndPos> saps = sm.getStudentAndIndex(id);
                    displayRegistrationOfAStudent(saps);
                    int index = in.inputChoice(1, saps.size(), "Your choice");
                    Student s = sm.getStudentByPos(saps.get(index - 1).getPos());
                    Student s1 = new Student(s.getId(), s.getStudentName(), s.getAge(), s.getCourse(), s.getSemester());
                    boolean isUpdateNameOrAge = false, isUpdateCourseOrSemeter = false;
                    if (in.checkYesNo("Do you want to update the name?")) {
                        isUpdateNameOrAge = true;
                        String name = in.inputString("Student name");
                        s1.setStudentName(name);
                    }
                    if (in.checkYesNo("Do you want to update the age?")) {
                        isUpdateNameOrAge = true;
                        int age = in.inputChoice(18, 100, "Age");
                        s1.setAge(age);
                    }
                    if (in.checkYesNo("Do you want to update the course?")) {
                        isUpdateCourseOrSemeter = true;
                        String course = in.getCourseByChoice();
                        s1.setCourse(course);
                    }
                    if (in.checkYesNo("Do you want to update the semester?")) {
                        isUpdateCourseOrSemeter = true;
                        int semester = in.inputChoice(1, 9, "Semester");
                        s1.setSemester(semester);
                    }
                    if (isUpdateNameOrAge && !isUpdateCourseOrSemeter) {
                        sm.update(s1, index - 1, saps);
                    }
                    if (isUpdateCourseOrSemeter) {
                        if (sm.isExitRegistrationOfAStudent(s1, saps)) {
                            System.out.println("You already registered for " + s1.getCourse() + " course for "
                                    + s1.getSemester() + " term, you don't need to re-register.");
                            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                                    + " press \"N\" if you want to end the action.")) {
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            sm.update(s1, index - 1, saps);
                        }
                    }
                    if (!isUpdateCourseOrSemeter && !isUpdateNameOrAge) {
                        System.out.println("No Update.");
                    } else {
                        System.out.println("Update successful.");
                    }
                    System.out.println("");
                    System.out.println("REGISTRATION LIST");
                    displayRegistrationOfAStudent(saps);
                    System.out.println("");
                    if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                            + " press \"N\" if you want to end the action.")) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
            if (choice.equalsIgnoreCase("D")) {
                String id = in.inputString("ID").toUpperCase();
                if (sm.getStudentByID(id) == null) {
                    System.out.println("ID not found.");
                    if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                            + " press \"N\" if you want to end the action.")) {
                        return;
                    } else {
                        continue;
                    }
                }
                while (true) {
                    ArrayList<StudentAndPos> saps = sm.getStudentAndIndex(id);
                    displayRegistrationOfAStudent(saps);
                    int index = in.inputChoice(1, saps.size(), "Your choice");
                    sm.delete(index - 1, saps);
                    System.out.println("Delete successful.");
                    System.out.println("");
                    System.out.println("REGISTRATION LIST");
                    displayRegistrationOfAStudent(saps);
                    System.out.println("");
                    if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                            + " press \"N\" if you want to end the action.")) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to continue updating or deleting,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
    }

    private void displayRegistrationOfAStudent(ArrayList<StudentAndPos> sais) {
        System.out.printf("%-7s | %-10s | %-30s | %-10s | %-10s | %-5s\n", "Index", "ID", "Student name", "Age", "Course", "Semester");
        for (StudentAndPos s : sais) {
            System.out.printf("%-7s | %-10s | %-30s | %-10d | %-10s | %-5d\n",
                    s.getIndex(), s.getStudent().getId(), s.getStudent().getStudentName(),
                    s.getStudent().getAge(), s.getStudent().getCourse(), s.getStudent().getSemester());
        }
    }

    public void report() {
        if (sm.getRegistrationList().isEmpty()) {
            System.err.println("List empty. Create student(s) first!");
            return;
        }
        sm.sort(sm.getRegistrationList());
        System.out.printf("%-10s | %-30s | %-15s | %-5s\n", "ID", "NAME", "COURSE NAME", "TOTAL COURSE");
        for (Report r : sm.report()) {
            System.out.printf("%-10s | %-30s | %-15s | %-5d\n",
                    r.getId(), r.getStudentName(), r.getCourse(), r.getTotal());
        }
    }

}
