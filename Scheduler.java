import java.util.ArrayList;
import java.util.Collections;

public class Scheduler {
	private ArrayList<Class> classes;
	private int num;
	private Data data;
	private int numConflicts;
	private boolean isFitnessChanged = true;
	private double fitness = -1;
	private ArrayList<Student> students;
	private ArrayList<Teacher> teachers;
	private int[][] teacherPeriods;

	public Data getData() {
		return data;
	}

	public Scheduler(Data data) {
		this.data = data;
		classes = new ArrayList<Class>();
		students = new ArrayList<Student>();
		for (Student s : data.getStudents()) {
			students.add(s.clone());
		}

	}
	
	public Scheduler initialize() {
		int[] periods = new int[6];
		for (Dept dept : data.getDepts()) {
			for (Course course : dept.getCourses()) {
				int period = 0;
					Class newClass = new Class(course, num++, dept);
					newClass.setTeacher(course.getTeachers().get((int) (course.getTeachers().size() * Math.random())));
					int p = 1;
					while (periods[p - 1] > 2) {
						p = 1 + (int) (Math.random() * 6);
					}
					periods[p - 1]++;
					newClass.setPeriod(p);
					Collections.shuffle(students);
					ArrayList<Student> enrollStudents = new ArrayList<>();
					int enrolled = 0;
					int i = 0;
					do {
						if (students.get(i).getCoursesWantedList().contains(course)) {
							enrollStudents.add(students.get(i));
							students.get(i).addClass(newClass);
							enrolled++;
						}
						i++;
					} while (enrolled < course.getMaxStudents() && i < students.size());
					newClass.setStudents(enrollStudents);
					classes.add(newClass);
				
			}
		}
		return this;
	}

	public int getConflicts() {
		return numConflicts;
	}

	public double getFitness() {
		if (isFitnessChanged == true) {
			fitness = calculateFitness();
			isFitnessChanged = false;
		}
		return fitness;
	}

	private double calculateFitness() {
		numConflicts = 0;
		for (Student student : students) {
			for (int i = 0; i < student.getClassesGot().size() - 1; i++) {
				for (int j = i + 1; j < student.getClassesGot().size(); j++) {
					//System.out.println(student.getClassesGot().get(1).getName());
					if (student.getClassesGot().get(i).getPeriod() == student.getClassesGot().get(j).getPeriod()) {
						numConflicts += 10;
						//System.out.println("conflicting period");
						// "+student.getClassesGot().get(i).getName()+" and
						// "+student.getClassesGot().get(j).getName()+" are in
						// period
						// "+student.getClassesGot().get(j).getPeriod()+student.getClassesGot().get(j=i).getPeriod());
					}
				}
			}
			numConflicts += (student.getCoursesWantedList().size() - student.getClassesGot().size());
		}

		for (int i = 0; i < classes.size() - 1; i++) {
			for (int j = i + 1; j < classes.size(); j++) {
				if (classes.get(i).getTeacher().equals(classes.get(j).getTeacher())
						&& classes.get(i).getPeriod() == (classes.get(j).getPeriod())) {
					numConflicts += 10;
					//System.out.println("teacher teaching wo classes in period " + classes.get(i).getPeriod());
				}
			}
		}
		return 1 / (double) (numConflicts + 1);

	}

	public String toString() {
		String output = "";
		output += "\n---CLASSES-----\n";
		for (Class c : classes) {
			output += c.toString() + "\n";
		}
		output+="\n---STUDENTS-----";
		for(Student s: this.students){
			output+=s.toString();
		}
		return output;
	}

	public ArrayList<Class> getClasses() {
		return classes;
	}

	public int getNum() {
		return num;
	}

	public int getNumConflicts() {
		return numConflicts;
	}

	public boolean isFitnessChanged() {
		return isFitnessChanged;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public void setRandomGrades(){
		for(Student s : students){
			double[] grades = new double[s.getGradeDoubles().length];
			for(int i = 0; i < s.getGradeDoubles().length; i++){
				grades[i] = (Math.random()*2)+2;
			}
			s.setGPA(grades);
		}
	}
	
	public String getStudentGrades(){
		String out = "";
		for(Student s:students){
			out+= s.getName()+": ";
			char[] letters = s.getGrades();
			for(char letter : letters){
				out+= letter+", ";
			}
		}
		return out;
	}
	
	public String study(){
		for(Student s : students){
			double[] grades = new double[s.getGradeDoubles().length];
			for(int i = 0; i < s.getGradeDoubles().length; i++){
				grades[i] = Math.pow(s.getGradeDoubles()[i], 1.1);
			}
			s.setGPA(grades);
		}
		return "New Grades: \n"+getStudentGrades();
	}

}
