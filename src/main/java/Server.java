import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

	private BlockingQueue<Task> tasks;
	private AtomicInteger waitingPeriod;
	private int id;

	private static int contor;


	public Server(int maxTasksPerServer) {
		this.waitingPeriod = new AtomicInteger();
		this.waitingPeriod.set(0);
		this.tasks = new ArrayBlockingQueue<Task>(maxTasksPerServer);
		contor++;
		this.id=contor;

	}

	public void addTask(Task newTask) {

		tasks.add(newTask);

		waitingPeriod.set(waitingPeriod.get() + newTask.getProcessingTime());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (tasks.isEmpty() == false) {
				try {
					Task t = tasks.peek();
				
					for (int i = t.getProcessingTime(); i > 0; i--)
					{
						Thread.sleep(500);

					}

					waitingPeriod.set(waitingPeriod.get() - t.getProcessingTime());

					tasks.poll();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				

			}

		}

	}

	public int getId() {
		return id;
	}
	
	public AtomicInteger getWaitingPeriod() {
		return waitingPeriod;
	}

	public BlockingQueue<Task> getTasks() {
		return tasks;
	}



}
