import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

public class Controller implements Runnable {
	private View view;
	private View2 view2;
	public int timeLimit ;
	public int maxProcessingTime ;
	public int minProcessingTime ;
	public int maxArrivingTime ;
	public int minArrivingTime ;
	public int numberOfServers ;
	public int numberOfClients ;
	public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
	private Scheduler scheduler;
	private List<Task> generatedTasks = new ArrayList<Task>();
	float avgProcTime=0;
	int min=0;
	int nrClt=0;
	int peakHour;

	int nr=0;
	static int x=0;



	public Controller(View view, int timeLimit , int maxProcessingTime , int minProcessingTime , int maxArrivingTime ,
	 int minArrivingTime , int numberOfServers , int numberOfClients) 
	{
			this.view = view;		
			this.timeLimit =timeLimit;
			this.maxProcessingTime = maxProcessingTime;
			this.minProcessingTime = minProcessingTime;
			this.maxArrivingTime = maxArrivingTime;
			this.minArrivingTime = minArrivingTime;
			this.numberOfServers = numberOfServers;
			this.numberOfClients = numberOfClients;
			


		scheduler = new Scheduler(numberOfServers, numberOfClients);
		this.generateNRandomTaks();

	}

	private void generateNRandomTaks() {
		for (int i = 0; i < numberOfClients; i++) {
			Random r = new Random();
			int processingTime = r.nextInt(maxProcessingTime - minProcessingTime) + minProcessingTime;
			int arrivalTime = r.nextInt(maxArrivingTime - minArrivingTime) + minArrivingTime;
			avgProcTime= avgProcTime + processingTime;
			Task task = new Task(arrivalTime, processingTime);
			generatedTasks.add(task);
		}
		avgProcTime=avgProcTime/numberOfClients;
		Collections.sort(generatedTasks, (t1, t2) -> t1.getArrivingTime() - t2.getArrivingTime());
	}

	@Override
	public void run() {
		int currentTime = 0;
		while (currentTime < timeLimit) {
			String str= "";
			final int ct = currentTime;
			System.out.println(currentTime);
			List<Task> tasksEqual = generatedTasks.stream().filter(t -> t.getArrivingTime() == ct)
					.collect(Collectors.toList());

			for (Task t : tasksEqual) {
				scheduler.dispatchTask(t);
				generatedTasks.remove(t);
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


			str=str+"Time: " + String.valueOf(currentTime) + "\n" + "Waiting Clients: ";
			for (Task t : generatedTasks) {

				str=str+t.toString() + " ";

			}
			str=str+"\n";
			List<Server> servers = scheduler.getServers();
			for (Server s : servers) {
				if(s.getTasks().size()>1)
				x=x+s.getTasks().size()-1;
			}
			nrClt=0;
			for (Server s : servers) {
				str=str+"Queue " + String.valueOf(s.getId()) + ": ";
				nrClt=nrClt+s.getTasks().size();
				if (s.getTasks().isEmpty()) {
					str=str+"closed\n";
					nr++;
				}else{
					 BlockingQueue<Task> tasks= s.getTasks();
					 for(Task t : tasks) {
						 str=str+t.toString()+" ";
					 }
					str=str+"\n";
				}
			}
			if(nrClt>min){
				min=nrClt;
				peakHour=currentTime;
			}

			view.setLogs(str);

			currentTime++;
			int ok=0;
			for (Server s : servers) {
				if (!s.getTasks().isEmpty()) {
					ok=1;}}
			if(generatedTasks.isEmpty() && ok==0){
				break;
			}

		}

		System.out.println(avgProcTime);
		System.out.println(peakHour);

		System.out.println((double)x/ numberOfClients);

		view.setLogs("Average Processing Time: " + String.valueOf(avgProcTime) + "\n");
		view.setLogs("Peak Hour: " + String.valueOf(peakHour) + "\n");

		view.setLogs("Average Waiting Time: " + (double)x/ numberOfClients + "\n");
		view.setAverageServiceTime(avgProcTime);
		view.setPeakTime(peakHour);

		view.setAverageWaitingTime((double)x/ numberOfClients);
		FileWriiter f= new FileWriiter();
		String st=view.text();
		f.fisier("Report.txt",st);
	}

}
