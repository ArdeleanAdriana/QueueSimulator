import java.util.List;

public class ConcreteSTrategyQueue implements Strategy {

	@Override
	public void addTask(List<Server> servers, Task t) {
		// TODO Auto-generated method stub
		int minSize = servers.get(0).getTasks().size();
		Server min_server = null;
		for (Server server : servers)
			if (server.getTasks().size() < minSize) {
				minSize = server.getTasks().size();
				min_server=server;

				server.addTask(t);
			}
		min_server.addTask(t);
	}

}
