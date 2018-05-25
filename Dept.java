import java.util.ArrayList;

public class Dept {
	private String name;
	private ArrayList<Course> courses;
	public Dept(String name, ArrayList<Course> courses) {
		super();
		this.name = name;
		this.courses = courses;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public String toString(){
		return name;
	}
}
