
package framework;

import javax.swing.JFrame;


public abstract class Application {

	
	protected JFrame _frame;

	
	protected final Register _register = Register.getInstance();

	
	public Application() {
		// Create the main frame of the application.
		_frame = new JFrame();

		// And register it.
		_register.add("window.frame", _frame);

		// Exit the application when the main frame is closed.
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initiates the models
		initModels();

		// Initiates the controllers
		initControllers();

		// Start the application.
		start();
	}

	
	protected abstract void initControllers();

	
	protected abstract void initModels();

	
	protected abstract void start();

}
