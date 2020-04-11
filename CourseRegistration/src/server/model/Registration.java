package server.model;
public class Registration {
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	
	Registration(Student student, CourseOffering offering)
	{
		theStudent = student;
		theOffering = offering;
		theOffering.addRegistration(this);
		theStudent.addCourse(offering);
	}
	
	Registration(Student student, CourseOffering offering, String remove)
	{
		theStudent = student;
		theOffering = offering;
		theOffering.removeRegistration(this);
		theStudent.removeCourse(offering);
	}
	void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration ();
	}
	
	private void addRegistration () {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
	}
	
	
	public Student getTheStudent() {
		return theStudent;
	}
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString () {
		String st = "\n";
		st += "Student Name: " + getTheStudent() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}
	

}