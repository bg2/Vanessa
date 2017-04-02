
package framework;

import java.util.EventListener;

public abstract class Controller<M extends Model, V extends View> implements
		EventListener {

	
	protected final Register _register = Register.getInstance();

	
	protected M model;

	
	protected V view;

	
	protected final M model() {
		return this.model;
	}

	
	protected final void model(final M model) {
		if (model == null)
			return;

		this.model = model;
	}

	
	protected final V view() {
		return this.view;
	}

	
	protected final void view(final V view) {
		if (view == null)
			return;

		this.view = view;
	}
}
