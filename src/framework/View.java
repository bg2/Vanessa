
package framework;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;




public abstract class View<M extends Model, C extends Controller> extends
JPanel implements Observer {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3205795086954026886L;

	/** The register. */
	protected final Register _register = Register.getInstance();
	/**
	 * The controller operating on the view.
	 */
	protected C controller;

	/**
	 * The model that the view operates on.
	 */
	protected M model;

	/**
	 * Initialize the view.
	 */
	public View() {
		// Run view initialization such as loading controllers and models.
		this.initialize();

		// Render the view now that the controllers and models are available.
		this.render();
	}


	protected final C controller() {
		return this.controller;
	}

	
	@SuppressWarnings("unchecked")
	protected final void controller(final C controller) {
		if (controller == null)
			return;

		this.controller = controller;
		this.controller.view(this);

		// Set the model on the controller if the model eixsts.
		if (this.model != null)
			this.controller.model(this.model);
	}

	
	protected void initialize() {
		; // Do nothing by default.
	}

	
	protected final M model() {
		return this.model;
	}

	
	@SuppressWarnings("unchecked")
	protected final void model(final M model) {
		if (model == null)
			return;

		// If a model has already been associated with the view, remove the view
		// as an observer from the old model.
		// if (this.model != null)
		// this.model.deleteObserver(this);

		this.model = model;

		// Add the view as an observer of the model.
		// this.model.addObserver(this);

		// Set the model on the controller if the controller exists.
		if (this.controller != null)
			this.controller.model(this.model);
	}

	
	protected abstract void render();

	
	protected void update(final M model, final Object value) {
		throw new UnsupportedOperationException();
	}

	
	@Override
	public void update(final Observable observable, final Object object) {
		this.update(observable, object);
	}
}
