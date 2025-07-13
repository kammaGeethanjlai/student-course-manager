import java.util.List;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		StudentDAO dao=new StudentDAO();
		while(true) {
			System.out.println("\n===Student Course Manager===");
			System.out.println("1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.println("Choose option:");
			int choice=sc.nextInt();
			 
			switch(choice) {
			
			case 1:
                System.out.println("Name: ");
                String name=sc.next();
                System.out.println("Course: ");
                String course = sc.next();
                System.out.print("Email: ");
                String email = sc.next();
                dao.addStudent(new Student(choice, name,course,email));
                break;
            case 2:
                List<Student> list = dao.getAllStudents();
                for (Student s : list) {
                    System.out.println(s.getId() + " | " + s.getName() + " | " + s.getCourse() + " | " + s.getEmail());
                }
                break;
            case 3:
                System.out.print("Student ID to update: "); int id = sc.nextInt(); sc.nextLine();
                System.out.print("New Name: "); String newName = sc.nextLine();
                System.out.print("New Course: "); String newCourse = sc.nextLine();
                System.out.print("New Email: "); String newEmail = sc.nextLine();
                dao.updateStudent(new Student(id, newName, newCourse, newEmail));
                break;
            case 4:
                System.out.print("Student ID to delete: "); int delId = sc.nextInt();
                dao.deleteStudent(delId);
                break;
            case 5:
                System.out.println("Bye!");
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
}
