import java.util.ArrayList;

public class GeneticAlgo {
	private Data data;
	public GeneticAlgo(Data data){
		this.data = data;
	}
	public Population evolve(Population pop){
		System.out.println("Evolve");
		return mutatePop(crossover(pop));
	}
	public Population crossover(Population pop){ 
		System.out.println("Cross");
		Population crossoverPop = new Population(pop.getSchedules().size(), data);
		for(int i = 0; i < Driver.NUM_ELITE; i++){
			crossoverPop.getSchedules().set(i, pop.getSchedules().get(i));
		}
		for(int i = Driver.NUM_ELITE; i < pop.getSchedules().size(); i++){
			if(Driver.CROSSOVER_RATE > Math.random()){
				Scheduler schedule1 = selectPop(pop).sortByFitness().getSchedules().get(0);
				Scheduler schedule2 = selectPop(pop).sortByFitness().getSchedules().get(0);
				crossoverPop.getSchedules().set(i, pop.getSchedules().get(i));
			}else{crossoverPop.getSchedules().set(i, pop.getSchedules().get(i));}
		}
		return crossoverPop;
	}
	
	public Scheduler crossoverSchedule(Scheduler s1, Scheduler s2){
		System.out.println("Crossover Schedule");
		Scheduler crossoverSchedule = new Scheduler(data).initialize();
		for(int i = 0; i < crossoverSchedule.getClasses().size(); i++){
			if(Math.random() > .5){
				crossoverSchedule.getClasses().set(i, s1.getClasses().get(i));
			}else{
				crossoverSchedule.getClasses().set(i, s2.getClasses().get(i));
			}
		}
		return crossoverSchedule;
	}
	
	public Population mutatePop(Population pop){
		System.out.println("Mutate");
		Population mutate = new Population(pop.getSchedules().size(), data);
		ArrayList<Scheduler> schedules = mutate.getSchedules();
		for(int i = 0; i < Driver.NUM_ELITE; i++){
			schedules.set(i, pop.getSchedules().get(i));
		}
		for(int i = Driver.NUM_ELITE; i < pop.getSchedules().size(); i++){
			schedules.set(i, mutateScheduler(pop.getSchedules().get(i)));
		}
		return mutate;
	}
	
	public Scheduler mutateScheduler(Scheduler mutate){
		System.out.println("Mutate Schedule");
		Scheduler schedule = new Scheduler(data).initialize();
		for(int i = 0; i < mutate.getClasses().size(); i++){
			if(Driver.MUTATION_RATE > Math.random()){
				mutate.getClasses().set(i, schedule.getClasses().get(i));
			}
		}
		return mutate;
	}
	
	Population selectPop(Population pop){
		System.out.println("Select");
		Population tournament = new Population(Driver.TOURNAMENT_SELECTION_SIZE, data);
		for(int i = 0; i < Driver.TOURNAMENT_SELECTION_SIZE; i++){
			tournament.getSchedules().get((int)(Math.random()*tournament.getSchedules().size()));
		}
		return tournament;
	}
}
