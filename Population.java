import java.util.ArrayList;

public class Population {
	private ArrayList<Scheduler> schedules;
	
	public Population(int size, Data data){
		schedules = new ArrayList<>();
		for(int i = 0; i < size; i++){
			schedules.add(new Scheduler(data).initialize());
		}
	}

	public ArrayList<Scheduler> getSchedules() {
		return schedules;
	} 
	public Population sortByFitness(){
		int n = schedules.size();
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (schedules.get(j).getFitness() > schedules.get(j+1).getFitness() )
                {
                    // swap temp and arr[i]
                    Scheduler temp = schedules.get(j);
                    schedules.set(j, schedules.get(j+1));
                    schedules.set(j+1, temp);
                }
            }
        }
        return this;
	}
}
