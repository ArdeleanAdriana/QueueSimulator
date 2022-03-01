import java.util.ArrayList;
import java.util.List;

public class Controller2 {
	private View view;
	private View2 view2= new View2();
	public int timeLimit;
	public int maxProcessingTime;
	public int minProcessingTime;
	public int maxArrivingTime ;
	public int minArrivingTime ;
	public int numberOfServers ;
	public int numberOfClients ;
	Controller controller;

	public Controller2(View2 view2, View view) {
		this.view2 = view2;
		this.view=view;
		

		this.view2.getStart().addActionListener(e -> {
			try {
				timeLimit = Integer.parseInt(view2.simulationTime());
				maxProcessingTime =  Integer.parseInt(view2.maxProcTime());
				minProcessingTime =  Integer.parseInt(view2.minProcTime());
				maxArrivingTime =  Integer.parseInt(view2.maxArrTime());
				minArrivingTime =  Integer.parseInt(view2.minArrTime());
				numberOfServers =  Integer.parseInt(view2.nrQueues());
				numberOfClients =  Integer.parseInt(view2.nrClients());
				if(minProcessingTime<maxProcessingTime && minArrivingTime<maxArrivingTime) {

					controller = new Controller(view, timeLimit, maxProcessingTime, minProcessingTime,
							maxArrivingTime, minArrivingTime,
							numberOfServers, numberOfClients);
					view.setVisible(true);
					Thread t = new Thread(controller);
					t.start();
				}
				else
					View2.showError("Timpii minimi trebuie sa fie mai mici decat timpii maximi");

			}
			catch(NumberFormatException nfex){
				View2.showError("Datele introduse trebuie sa fie numere intregi");
			}

		});

	}
}