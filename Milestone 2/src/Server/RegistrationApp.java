package Server;
import java.util.Scanner;

public class RegistrationApp {
	private Student student;
	private Course theCourse;
	private CourseCatalogue cat;
	private Scanner scan;
	private String input;
	
	RegistrationApp()
	{
		student = new Student("Martin", 30068529);
		cat = new CourseCatalogue();
	}
	public int menu()
	{
		System.out.println("Please choose one of the following opperations: ");
		System.out.println("1. Search catalogue courses ");
		System.out.println("2. Add course to student courses ");
		System.out.println("3. Remove course from student courses ");
		System.out.println("4. View all courses in catalogue ");
		System.out.println("5. View all courses taken by student ");
		System.out.println("6. Quit. ");
		scan = new Scanner(System.in);
		input = scan.nextLine();
		int choice = Integer.parseInt(input);
		return choice;
	}
	
	public void searchCatalogueCourses()
	{
		System.out.println("Please enter the name of the course you want to search ");
		scan = new Scanner(System.in);
		input = scan.nextLine();
		String courseName = input;
		System.out.println("Please enter the number of " + input + " course");
		input = scan.nextLine();
		int courseNum = Integer.parseInt(input);
		theCourse = cat.searchCat(courseName, courseNum);
		if (theCourse != null) {
			System.out.println("Course found: ");
			System.out.println(theCourse.getCourseOfferingAt(0).toString());
			System.out.println(theCourse.getCourseOfferingAt(1).toString());
		}
		else
		{
			System.out.println("Sorry we can't find this course in our system. ");
		}
		System.out.println();
	}
	
	public void viewAllCourses()
	{
		System.out.println(cat.toString());
		System.out.println();
	}
	
	public void addStudentCourses()
	{
		System.out.println("Please enter the name of the course you want to add: ");
		scan = new Scanner(System.in);
		input = scan.nextLine();
		String courseName = input;
		System.out.println("Please enter the number of " + input + " course");
		input = scan.nextLine();
		int courseNum = Integer.parseInt(input);
		theCourse = cat.searchCat(courseName, courseNum);
		if(theCourse!=null)
		{
			System.out.println("Which offering would you like to choose? ");
			System.out.println("1. " + theCourse.getCourseOfferingAt(0).toString());
			System.out.println("2. " + theCourse.getCourseOfferingAt(1).toString());
			System.out.println("3. " + theCourse.getCourseOfferingAt(2).toString());
			input = scan.nextLine();
			int choice = Integer.parseInt(input);
			Registration rg;
			switch(choice)
			{
			case 1:
				rg = new Registration(student, theCourse.getCourseOfferingAt(0));
				break;
			case 2:
				rg = new Registration(student, theCourse.getCourseOfferingAt(1));
				break;
			case 3:
				rg = new Registration(student, theCourse.getCourseOfferingAt(2));
			}
			student.printAllStudentCourses();
			System.out.println();
		}
		System.out.println();
	}
	
	public void removeStudentCourses()
	{
		scan = new Scanner(System.in);
		System.out.println("Which course would you like to remove? ");
		student.printAllStudentCourses();
		if(student.getOfferingListSize()!=0)
		{
			input = scan.nextLine();
			int choice = Integer.parseInt(input);
			Registration rg = new Registration(student, student.getOfferingList().get(choice-1), "remove");
			System.out.println("Operation succedded! ");
		}
		System.out.println();
	}
	
	public void viewAllStudentCourses() 
	{
		student.printAllStudentCourses();
	}
	public void displayMenu()
	{
		while(true)
		{
			switch(menu())
			{
				case 1:
					searchCatalogueCourses();
					break;
				case 2:
					addStudentCourses();
					break;
				case 3:
					removeStudentCourses();
					break;
				case 4:
					viewAllCourses();
					break;
				case 5:
					viewAllStudentCourses();
					break;
				case 6:
					System.out.println("Thanks for using the program");
					System.exit(0);
					break;
			}
		}
	}
	public static void main (String [] args) {
		RegistrationApp theApp = new RegistrationApp();
		theApp.displayMenu();
	}

}
