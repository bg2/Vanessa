

package framework;

import java.util.Observable;


public abstract class Model extends Observable {

	
	protected final Register _register = Register.getInstance();

	
	public final void changed() {
		// Mark the model as having been changed.
		setChanged();

		// Notify observers about the change.
		this.notifyObservers();
	}

	
	protected final void changed(final Object value) {
		// Mark the model as having been changed.
		setChanged();

		// Notify observers about the change.
		this.notifyObservers(value);
	}
}
