package soStringSample;

public class Student {
	int studentId;
	String name;
	
	Student(int studentId,String name){
		this.studentId = studentId;
		this.name = name;
		
	}
	
	public String toString() {
		return studentId + " " + name;
	}
}
