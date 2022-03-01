import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		View2 view2 = new View2();
		View view = new View();
		Controller2 controller2 = new Controller2(view2, view);
	
		
		view2.setVisible(true);
	}

}
