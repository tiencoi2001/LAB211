
import entity.Report;
import entity.Student;
import entity.StudentAndPos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author duy
 */
public class StudentManagement {

    private ArrayList<Student> registrationList;

    public StudentManagement(ArrayList<Student> registrationList) {
        this.registrationList = registrationList;
    }

    public ArrayList<Student> getRegistrationList() {
        return registrationList;
    }

    public void create(Student s) {
        registrationList.add(s);
    }

    public Student getStudentByID(String id) {
        for (Student s : registrationList) {
            if (id.equals(s.getId())) {
                return s;
            }
        }
        return null;
    }

    public boolean isExitRegistration(Student student) {
        for (Student s : registrationList) {
            if (s.getId().equalsIgnoreCase(student.getId())
                    && s.getCourse().equals(student.getCourse())
                    && s.getSemester() == student.getSemester()) {
                return true;
            }
        }
        return false;
    }

    public boolean isExitRegistrationOfAStudent(Student student, ArrayList<StudentAndPos> sais) {
        for (StudentAndPos s : sais) {
            if (s.getStudent().getCourse().equals(student.getCourse())
                    && s.getStudent().getSemester() == student.getSemester()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> find(String keyword) {
        ArrayList<Student> searched = new ArrayList<>();
        for (Student s : registrationList) {
            if (s.getStudentName().toLowerCase().contains(keyword.toLowerCase())) {
                searched.add(s);
            }
        }
        return searched;
    }

    public List<Student> sort(List<Student> list) {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge(); // for decreasing use o2 - o1
            }
        });
        return list;
    }

    public Student getStudentByPos(int pos) {
        return registrationList.get(pos);
    }

    public ArrayList<StudentAndPos> getStudentAndIndex(String id) {
        ArrayList<StudentAndPos> studentAndIndexs = new ArrayList<>();
        int index = 1;
        for (int j = 0; j < registrationList.size(); j++) {
            if (registrationList.get(j).getId().equalsIgnoreCase(id)) {
                Student student = registrationList.get(j);
                StudentAndPos sai = new StudentAndPos(student, index, j);
                studentAndIndexs.add(sai);
                index++;
            }
        }
        return studentAndIndexs;
    }

    public void update(Student s, int index, ArrayList<StudentAndPos> sais) {
        for (int i = 0; i < sais.size(); i++) {
            if (!sais.get(i).getStudent().getStudentName().equalsIgnoreCase(s.getStudentName())
                    || sais.get(i).getStudent().getAge() != s.getAge()) {
                sais.get(i).getStudent().setStudentName(s.getStudentName());
                sais.get(i).getStudent().setAge(s.getAge());
                registrationList.get(sais.get(i).getPos()).setStudentName(s.getStudentName());
                registrationList.get(sais.get(i).getPos()).setAge(s.getAge());
            }
        }
        sais.get(index).setStudent(s);
        registrationList.get(sais.get(index).getPos()).setCourse(s.getCourse());
        registrationList.get(sais.get(index).getPos()).setSemester(s.getSemester());
    }

    public void delete(int index, ArrayList<StudentAndPos> sais) {
        registrationList.remove(sais.get(index).getPos());
        sais.remove(sais.get(index));
    }

    public ArrayList<Report> report() {
        ArrayList<Report> listReport = new ArrayList<>();
        ArrayList<Student> listStudent2 = new ArrayList<>(registrationList);
        int total = 0;
        for (int i = 0; i < listStudent2.size(); i++) {
            total = 1;
            String id = listStudent2.get(i).getId();
            String course = listStudent2.get(i).getCourse();
            String studentName = listStudent2.get(i).getStudentName();

            for (int j = i + 1; j < listStudent2.size(); j++) {
                if (listStudent2.get(j).getId().equalsIgnoreCase(id)
                        && listStudent2.get(j).getStudentName().equalsIgnoreCase(studentName)
                        && listStudent2.get(j).getCourse().equalsIgnoreCase(course)) {
                    total++;
                    listStudent2.remove(j);
                    j--;
                }
            }
            listReport.add(new Report(id, studentName, course, total));
        }

        return listReport;
    }
}
