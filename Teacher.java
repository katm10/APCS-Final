
public class Teacher implements Person {
	private int id;
	private String name;
	private int[] periodsteaching;
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.periodsteaching = new int[6];
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void addPeriod(int i){
		this.periodsteaching[i] =1;
	}
	public boolean isTeachingPeriod(int i){
		return (this.periodsteaching[i]==1);
	}
	
	public Teacher clone(){
		return new Teacher(id, name);
	}
	
	public String toString(){
		return name;
	}
	@Override
	public String sayHi() {
		return "Good afternoon, "+name+"!";
	}
}
