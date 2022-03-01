
public class Task {
	private int id;
	private int arrivingTime;
	private int processingTime;
	private static int contor=0;
	
	public Task(int arrivingTime, int processingTime) {
		this.arrivingTime = arrivingTime;
		this.processingTime = processingTime;
		contor++;
		this.id=contor;
	}
	
	public int getArrivingTime() {
		return arrivingTime;
	}
	public void setArrivingTime(int arrivingTime) {
		this.arrivingTime = arrivingTime;
	}
	
	public int getProcessingTime() {
		return processingTime;
	}
	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String toString() 
	{
		return "(" + id + "," + arrivingTime + "," + processingTime + ")";
	}
}
