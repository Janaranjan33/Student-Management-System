
    package StudentManagement;

    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            StudentManager manager = new StudentManager();

            FileHandler.loadStudents(manager);

            int choice;

            do {

                System.out.println("\n================================");
                System.out.println("   STUDENT MANAGEMENT SYSTEM");
                System.out.println("================================");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.println("================================");

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Enter Course: ");
                        String course = scanner.nextLine();

                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        Student student =
                                new Student(id, name, age, course, email);

                        if (manager.addStudent(student)) {

                            FileHandler.saveStudents(
                                    manager.getStudents()
                            );

                            System.out.println(
                                    "Student added successfully."
                            );

                        } else {

                            System.out.println(
                                    "Student ID already exists."
                            );
                        }

                        break;

                    case 2:

                        manager.viewStudents();

                        break;

                    case 3:

                        System.out.print(
                                "Enter Student ID to search: "
                        );

                        int searchId = scanner.nextInt();

                        Student foundStudent =
                                manager.findStudent(searchId);

                        if (foundStudent != null) {

                            foundStudent.displayStudent();

                        } else {

                            System.out.println(
                                    "Student not found."
                            );
                        }

                        break;

                    case 4:

                        System.out.print(
                                "Enter Student ID to update: "
                        );

                        int updateId = scanner.nextInt();

                        Student updateStudent =
                                manager.findStudent(updateId);

                        if (updateStudent != null) {

                            scanner.nextLine();

                            System.out.print("Enter New Name: ");
                            String newName = scanner.nextLine();

                            System.out.print("Enter New Age: ");
                            int newAge = scanner.nextInt();

                            scanner.nextLine();

                            System.out.print("Enter New Course: ");
                            String newCourse = scanner.nextLine();

                            System.out.print("Enter New Email: ");
                            String newEmail = scanner.nextLine();

                            updateStudent.setName(newName);
                            updateStudent.setAge(newAge);
                            updateStudent.setCourse(newCourse);
                            updateStudent.setEmail(newEmail);

                            FileHandler.saveStudents(
                                    manager.getStudents()
                            );

                            System.out.println(
                                    "Student updated successfully."
                            );

                        } else {

                            System.out.println(
                                    "Student not found."
                            );
                        }

                        break;

                    case 5:

                        System.out.print(
                                "Enter Student ID to delete: "
                        );

                        int deleteId = scanner.nextInt();

                        if (manager.deleteStudent(deleteId)) {

                            FileHandler.saveStudents(
                                    manager.getStudents()
                            );

                            System.out.println(
                                    "Student deleted successfully."
                            );

                        } else {

                            System.out.println(
                                    "Student not found."
                            );
                        }

                        break;

                    case 6:

                        System.out.println(
                                "Thank you for using Student Management System!"
                        );

                        break;

                    default:

                        System.out.println(
                                "Invalid choice."
                        );
                }

            } while (choice != 6);

            scanner.close();
        }
    }
