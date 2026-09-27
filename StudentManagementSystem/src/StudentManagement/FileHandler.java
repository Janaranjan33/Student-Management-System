package StudentManagement;

import java.io.*;
import java.util.ArrayList;

    public class FileHandler {

        private static final String FILE_NAME = "students.txt";

        public static void saveStudents(ArrayList<Student> students) {

            try {

                BufferedWriter writer =
                        new BufferedWriter(new FileWriter(FILE_NAME));

                for (Student student : students) {

                    writer.write(
                            student.getId() + "|" +
                                    student.getName() + "|" +
                                    student.getAge() + "|" +
                                    student.getCourse() + "|" +
                                    student.getEmail()
                    );

                    writer.newLine();
                }

                writer.close();

            } catch (IOException e) {

                System.out.println("Error while saving students.");
            }
        }

        public static void loadStudents(StudentManager manager) {

            File file = new File(FILE_NAME);

            if (!file.exists()) {
                return;
            }

            try {

                BufferedReader reader =
                        new BufferedReader(new FileReader(FILE_NAME));

                String line;

                while ((line = reader.readLine()) != null) {

                    String[] data = line.split("\\|");

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];
                    String email = data[4];

                    Student student =
                            new Student(id, name, age, course, email);

                    manager.addStudent(student);
                }

                reader.close();

            } catch (IOException | NumberFormatException e) {

                System.out.println("Error while loading students.");
            }
        }
    }

