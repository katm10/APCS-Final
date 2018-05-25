import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Data {
	private ArrayList<Teacher> teachers;
	private ArrayList<Course> courses; 
	private ArrayList<Dept> depts;
	private ArrayList<Student> students;
	private int numberOfClasses = 0;
	
	public Data(){
		initialize();
	}
	
	
	
	public ArrayList<Student> getStudents() {
		return students;
	}



	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}



	public ArrayList<Course> getCourses() {
		return courses;
	}



	public ArrayList<Dept> getDepts() {
		return depts;
	}



	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public void premadeData(){
		Teacher t1 = new Teacher(1, "Wade");
		Teacher t2 = new Teacher(2, "Karshan");
		Teacher t3 = new Teacher(3, "Bennett");
		Teacher t4 = new Teacher(4, "Kreppel");
		Teacher t5 = new Teacher(5, "Marcan");
		Teacher t6 = new Teacher(6, "Sully");
		Teacher t7 = new Teacher(7, "Sr. Martinez");
		Teacher t8 = new Teacher(8, "Noyes");
		Teacher t9 = new Teacher(9, "Chin");
		Teacher t10 = new Teacher(10, "McLean");
		int maxStudents = 30;
		Course c1 = new Course("AP Comp Sci", 1, maxStudents, new ArrayList<Teacher>(Arrays.asList(t1)));
		Course c2 = new Course("AP Lang", 2, maxStudents,  new ArrayList<Teacher>(Arrays.asList(t2)));
		Course c3 = new Course("Calc", 3, maxStudents,  new ArrayList<Teacher>(Arrays.asList(t3, t4)));
		Course c4 = new Course("AP Chem", 4, maxStudents, new ArrayList<Teacher>(Arrays.asList(t5)));
		Course c5 = new Course("Spanish IV", 11, maxStudents, new ArrayList<Teacher>(Arrays.asList(t7)));
		Course c6 = new Course("APUSH", 10, maxStudents, new ArrayList<Teacher>(Arrays.asList(t9, t6)));
		Course c7 = new Course("Gov/Econ", 9, maxStudents, new ArrayList<Teacher>(Arrays.asList(t6)));
		Course c8 = new Course("Precalc", 8, maxStudents, new ArrayList<Teacher>(Arrays.asList(t1, t10)));
		Course c9 = new Course("AP Euro", 7, maxStudents, new ArrayList<Teacher>(Arrays.asList(t9)));
		Course c10 = new Course("Art", 6, maxStudents, new ArrayList<Teacher>(Arrays.asList(t8)));
		Course c11 = new Course("English 3", 5, maxStudents, new ArrayList<Teacher>(Arrays.asList(t2)));
		Dept d1 = new Dept("Math", new ArrayList<Course>(Arrays.asList(c1, c3, c8)));
		Dept d2 = new Dept("English", new ArrayList<Course>(Arrays.asList(c2, c11)));
		Dept d3 = new Dept("Science", new ArrayList<Course>(Arrays.asList(c4)));
		Dept d4 = new Dept("History", new ArrayList<Course>(Arrays.asList(c6, c7, c9)));
		Dept d5 = new Dept("VPA", new ArrayList<Course>(Arrays.asList(c10)));
		Dept d6 = new Dept("Language", new ArrayList<Course>(Arrays.asList(c5)));
		Student s1 = new Student("Bob", "Charles", 9, new ArrayList<Course>(Arrays.asList(c1, c2, c3, c4, c5,c9)));
		Student s2 = new Student("Taylor", "Maclaurin", 9, new ArrayList<Course>(Arrays.asList(c1, c2, c3, c4, c10,c9)));
		Student s3 = new Student("Harold", "He", 10, new ArrayList<Course>(Arrays.asList(c1, c2, c4, c8, c5,c9)));
		Student s4 = new Student("Fred", "Franklin", 10, new ArrayList<Course>(Arrays.asList(c1, c2, c4, c8, c10,c9)));
		Student s5 = new Student("Gretel", "Gauss", 11, new ArrayList<Course>(Arrays.asList(c1, c11, c4, c5, c3,c6)));
		Student s6 = new Student("Hansel", "Gauss", 11, new ArrayList<Course>(Arrays.asList(c1,c11, c4, c8, c10,c6)));
		Student s7 = new Student("Axel", "Maker", 11, new ArrayList<Course>(Arrays.asList(c1, c11, c4, c8, c5,c6)));
		Student s8 = new Student("Auora", "Doe", 10, new ArrayList<Course>(Arrays.asList(c1,c2, c3, c4, c10,c9)));
		Student s9 = new Student("Penny", "Less", 11, new ArrayList<Course>(Arrays.asList(c1, c2, c4, c8, c5,c6)));
		Student s10 = new Student("Violet", "Red", 11, new ArrayList<Course>(Arrays.asList(c1, c2, c4, c3,c10,c6)));
		Student s11= new Student("Dolores", "Umbridge", 11, new ArrayList<Course>(Arrays.asList(c1, c11, c4,c3, c5,c6)));
		Student s12 = new Student("Severus", "Snape", 12, new ArrayList<Course>(Arrays.asList(c1, c11,c3,c4,c10,c7)));
		Student s13 = new Student("Kevin", "Toman", 12, new ArrayList<Course>(Arrays.asList(c1, c11,c4,c8,c5,c7)));
		Student s14 = new Student("Ulysses", "Grant", 12, new ArrayList<Course>(Arrays.asList(c1, c11,c4,c8,c10,c7)));
		teachers.addAll(Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10));
		courses.addAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11));
		depts.addAll(Arrays.asList(d1,d2,d3,d4,d5,d6));
		students.addAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14));
		
	}

	private Data initialize(){
		teachers = new ArrayList<Teacher>();
		courses = new ArrayList<Course>();
		depts = new ArrayList<Dept>();
		students = new ArrayList<Student>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to use your own data or just use pre-entered data? Type 1 to use your own and 2 for pre-entered.");
		String ans = scan.nextLine();
		int num = Integer.parseInt(ans.trim());
		switch(num){
		case 1:
			enterData();
			break;
		case 2:
			premadeData();
			break;
		default:
			System.out.println("Sorry. I didn't understand that. We will use premade data.");
			premadeData();
			break;
		}

		scan.close();
		depts.forEach(x -> numberOfClasses += x.getCourses().size());
		return this;
	}

	public void enterData(){
		int id = 1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please list out all teachers' names on separate lines. Type DONE once you have finished");
		String next = scan.nextLine();
		while(!next.toLowerCase().equals("done")){
			teachers.add(new Teacher(id, next));
			id++;
			next = scan.nextLine();
		}
		for(Teacher teach : teachers){
			System.out.println(teach.getId()+" : "+teach.getName());
		}
		int firstIndexCourse = id;
		System.out.println("Please type the first course name or type DONE to end");
		next = scan.nextLine();
		while(!next.toLowerCase().equals("done")){
			ArrayList<Teacher> courseTeachers = new ArrayList<>();
			System.out.println("Please type the id numbers of all teachers who can teach this course, separated by commas");
			String nums = scan.next();
			String[] numArr = nums.split(",");
			for(String num : numArr){
				num.trim();
				courseTeachers.add(teachers.get(Integer.parseInt(num)-1));
			}
			courses.add(new Course(next, id, 30, courseTeachers));
			System.out.println("Please type the next course name or type DONE to end");
			id++;
			scan.nextLine();
			next = scan.nextLine();
		}
		for(Course course: courses){
			System.out.println(course.getNumber()+" : " +course.getName());
		}
		int firstDeptIndex = id;
		System.out.println("Please type the first department name or type DONE to end");
		next = scan.nextLine();
		while(!next.toLowerCase().equals("done")){
			ArrayList<Course> deptCourses = new ArrayList<>();
			System.out.println("Please type the id numbers of all courses in this department, separated by commas");
			String nums = scan.next();
			String[] numArr = nums.split(",");
			for(String num : numArr){
				num.trim();
				deptCourses.add(courses.get(Integer.parseInt(num)-firstIndexCourse));
			}
			depts.add(new Dept(next, deptCourses));
			for(String num : numArr){
				num.trim();
				courses.get(Integer.parseInt(num)-firstIndexCourse).setDept(depts.get(id-firstDeptIndex));
			}
			System.out.println("Please type the department name or type DONE to end");			
			scan.nextLine();
			next = scan.nextLine();
			id++;
		}
		
		System.out.println("Last thing, please begin entering student data");
		System.out.println("Enter student's full name or type DONE to finish");
		next = scan.nextLine();
		while(!next.toLowerCase().equals("done")){
			ArrayList<Course> coursesToTake = new ArrayList<>();
			System.out.println("Enter student's grade (integers only)");
			int grade = scan.nextInt();
			scan.nextLine();
			System.out.println("Please refer to the courses above and type the 6 courses the student wants to take, separated by commas");
			String coursesWanted = scan.nextLine();
			String[] courseArr = coursesWanted.split(",");
			for(String courseWanted : courseArr){
				courseWanted.trim();
				coursesToTake.add(courses.get(Integer.parseInt(courseWanted)-firstIndexCourse));
			}
			String[] names = next.split(" ");
			students.add(new Student(names[0], names[1], grade, coursesToTake));
			System.out.println("Enter student's full name or type DONE to finish");
			next = scan.nextLine();
		
		}
		scan.close();
	}
	

	
}
