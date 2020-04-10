import java.util.ArrayList;
import java.util.Iterator;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<CourseOffering> offeringList;
	private ArrayList<Registration> studentRegList;
	private int offeringListSize;
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
		offeringList = new ArrayList<CourseOffering>();
		offeringListSize = 0;
	}
	
	public void addCourse(CourseOffering theOffering)
	{
		offeringList.add(theOffering);
		offeringListSize++;
	}
	
	public void removeCourse(CourseOffering theOffering)
	{
		offeringList.remove(theOffering);
		offeringListSize--;
	}
	
	public void printAllStudentCourses()
	{
		Iterator<CourseOffering> iterator = offeringList.iterator();
		int i=0;
		if(offeringListSize!=0)
		{
			System.out.println("Here are your courses: ");
			while(iterator.hasNext() && i<offeringListSize)
			{
				int temp = i+1;
				System.out.print(temp + ": " + offeringList.get(i));
				System.out.println();
				i++;
			}
			System.out.println();
		}
		else
			System.out.println(studentName + " currently has no courses. ");
	}
	public String getStudentName() {
		return studentName;
	}
	
	public ArrayList<CourseOffering> getOfferingList()
	{
		return offeringList;
	}
	public int getOfferingListSize()
	{
		return offeringListSize;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		return st;
	}

	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.add(registration);
	}

}
