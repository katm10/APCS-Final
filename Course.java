import java.util.ArrayList;

public class Course {
	private String name;
	private int num;
	private int maxStudents;
	private ArrayList<Teacher> teachers;
	private Dept dept;
	
	public Course(String name, int number, int maxStudents, ArrayList<Teacher> teachers) {
		super();
		this.name = name;
		this.num = number;
		this.maxStudents = maxStudents;
		this.teachers = teachers;
	}
	
	
	@Override
	public String toString() {
		return "Course Name: " + name + ", Number: " + num + ", Max Number of Students: " + maxStudents;
	}

	public String getName() {
		return name;
	}



	public int getNumber() {
		return num;
	}



	public int getMaxStudents() {
		return maxStudents;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}


	public boolean isAPClass(){
	    if(name.substring(0,2).equalsIgnoreCase("ap")){
	        return true;
	    }else{
	        return false;
	    }
	}
}



