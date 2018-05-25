import java.util.ArrayList;

public class Student implements Person{
	private String first;
	private String last;
	private int grade;
	private double[] grades = new double[6];
	private ArrayList<Course> coursesWantedList;
	private ArrayList<Class> classesGot;
	
	public Student(String first, String last, int grade) {
		this.first = first;
		this.last = last;
		this.grade = grade;
		this.classesGot = new ArrayList<Class>();
	}
	
	public ArrayList<Course> getCoursesWantedList() {
		return coursesWantedList;
	}
	
	public Student clone(){
		return new Student(first, last, grade, coursesWantedList);
	}

	public void addClass(Class c){
		classesGot.add(c);
	}
	
	public void resetStudent(){
		classesGot.clear();
	}
	
	public ArrayList<Class> getClassesGot() {
		return classesGot;
	}

	public void setClassesGot(ArrayList<Class> classesGot) {
		this.classesGot = classesGot;
	}

	public Student(String first, String last, int grade, ArrayList<Course> coursesWanted) {
		this.first = first;
		this.last = last;
		this.grade = grade;
		this.coursesWantedList = coursesWanted;
		this.classesGot = new ArrayList<Class>();

	}
	
	public String toString() {
		String out = "Name: " + first + " "+ last+"\nClass Schedule: ";
		for(Class c: this.classesGot){
			out+= c.getName()+" , period "+c.getPeriod()+"\t";
		}
		return out;
	}
	

	
	public void setGPA(double[] gradeGPAs){
	    if(gradeGPAs.length==6){
	            grades= gradeGPAs;
	        }
	    }
	
	public double calcGPA() {
		double total = 0;
		for(int i = 0; i < grades.length; i++) {
			total += grades[i];
		}
		return total/grades.length;
	}
	
	public char getGPAGrade() {
		double gpa = this.calcGPA();
		if(gpa > 4) {
			return 'A';
		}else if(gpa > 3) {
			return 'B';
		}else if(gpa > 2) {
			return 'C';
		}else if(gpa > 1){
			return 'D';
		}else {
			return 'F';
		}
	}
	
	public char[] getGrades() {
		char[] gradeLetters = new char[this.grades.length];
		for(int i = 0; i < gradeLetters.length; i++) {
			double percent = this.grades[i];
			if(percent > 4) {
				gradeLetters[i]= 'A';
			}else if(percent > 3) {
				gradeLetters[i]=  'B';
			}else if(percent > 2) {
				gradeLetters[i]=  'C';
			}else if(percent > 1){
				gradeLetters[i]=  'D';
			}else {
				gradeLetters[i]=  'F';
			}
		}
		return gradeLetters;
	}

	
	public boolean wantsCourse(Course c){
		for(Course course: coursesWantedList){
			if(course!=null){
			if(c.equals(course)){
				return true;
			}}
		}
		return false;
	}

	public String getName() {
		return first + " "+ last;
	}
	

	public double[] getGradeDoubles(){
		return grades;
	}
	
	public boolean isHonorStudent(){
	    String grade = new String(this.getGrades());
	    if(grade.indexOf("D") < 0 && grade.indexOf("F") <0 && this.calcGPA() > 3.5){
	        return true;
	    }else{
	        return false;
	    }
	}

	@Override
	public String sayHi() {
		return "Hey, what's up, "+this.first+"?";
	}
}

