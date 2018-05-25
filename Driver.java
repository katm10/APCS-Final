import java.util.Scanner;

public class Driver {
	public static final int POP_SIZE = 9;
	public static final double MUTATION_RATE = .1;
	public static final double CROSSOVER_RATE = .9;
	public static final int TOURNAMENT_SELECTION_SIZE = 3;
	public static final int NUM_ELITE = 1;
	private int scheduleNum = 0;
	private int classNum = 1;
	private static Data data;
	
	public static void main(String[] args){
		data = new Data();
		int genNumber = 0;
		GeneticAlgo genAlgo = new GeneticAlgo(data);
		Population pop = new Population(Driver.POP_SIZE, data).sortByFitness();
		while(pop.getSchedules().get(0).getFitness()!= 1.0 && genNumber < 5555){
			//System.out.println("Generation: " + genNumber+"\tFitness: "+pop.getSchedules().get(0).getFitness());
//			for(Scheduler s: pop.getSchedules()){
//				System.out.println(s);
//			}
			pop = genAlgo.evolve(pop).sortByFitness();
			genNumber++;
		}
		if(pop.getSchedules().get(0).getFitness()== 1.0){
		System.out.println("Solution found in "+genNumber+" solutions."+"\n"+ pop.getSchedules().get(0).toString());
		}else{
			System.out.println("Solution not found in "+genNumber+" generations. Here is the latest schedule.");
			System.out.println(pop.getSchedules().get(0));
		}
		Scheduler schedule = pop.getSchedules().get(0);
		schedule.setRandomGrades();
		System.out.println("Current Grades: \n"+schedule.getStudentGrades());
		Scanner in = new Scanner(System.in);
		
		System.out.println("After studying");
		schedule.study();
	}
	
	
}
