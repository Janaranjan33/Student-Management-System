package StudentManagement;
import java.util.ArrayList;

    public class StudentManager {


        private ArrayList<Student> students;

        public StudentManager() {
            students = new ArrayList<>();
        }

        public boolean addStudent(Student student) {

            if (findStudent(student.getId()) != null) {
                return false;
            }

            students.add(student);
            return true;
        }

        public void viewStudents() {

            if (students.isEmpty()) {
                System.out.println("No students found.");
                return;
            }

            for (Student student : students) {
                student.displayStudent();
            }
        }

        public Student findStudent(int id) {

            for (Student student : students) {

                if (student.getId() == id) {
                    return student;
                }
            }

            return null;
        }

        public boolean deleteStudent(int id) {

            Student student = findStudent(id);

            if (student != null) {
                students.remove(student);
                return true;
            }

            return false;
        }

        public ArrayList<Student> getStudents() {
            return students;
        }
    }

