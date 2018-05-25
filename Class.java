import java.util.ArrayList;

public class Class extends Course{

	private Teacher teacher;
	private int period;
	private ArrayList<Student> students;
	private int id;
	private Dept dept;
	public Class(String name, int number, int maxStudents, ArrayList<Teacher> teachers, Teacher teacher, int period,
			ArrayList<Student> students, int id, Dept dept) {
		super(name, number, maxStudents, teachers);
		this.teacher = teacher;
		this.period = period;
		this.students = students;
		this.id = id;
		this.dept = dept;
	}
	public Class(Course course, Teacher teacher, int period,
			ArrayList<Student> students, int id, Dept dept) {
		super(course.getName(), course.getNumber(), course.getMaxStudents(), course.getTeachers());
		this.teacher = teacher;
		this.period = period;
		this.students = students;
		this.id = id;
		this.dept = dept;
	}
	
	public Class(Course course, int id, Dept dept) {
		super(course.getName(), course.getNumber(), course.getMaxStudents(), course.getTeachers());
		this.id = id;
		this.dept = dept;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String out = dept.toString()+ " " + id+" "+ super.getName()+"\t Teacher: "+ teacher.toString() + "\t Period " + period + "\t Students: ";
		if(this.getStudents()!=null){
		for(Student s : this.getStudents()){
			out+= s.getName()+", " ;
		}
		}
		return out;		
	}
	

}
