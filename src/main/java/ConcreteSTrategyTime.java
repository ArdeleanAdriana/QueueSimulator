import java.util.List;

public class ConcreteSTrategyTime implements Strategy {

	int x;
	//static int var=0;
	@Override
	public void addTask(List<Server> servers, Task t) {
		// TODO Auto-generated method stub

		int minTime = servers.get(0).getWaitingPeriod().get();
		Server min_server = null;
		for (Server server : servers){
			if (server.getWaitingPeriod().get() <= minTime) {
				minTime = server.getWaitingPeriod().get();
				min_server = server;
			}

		}
		min_server.addTask(t);


		

	}



}
