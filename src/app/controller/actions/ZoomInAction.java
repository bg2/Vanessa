
package app.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.controller.PerspectiveController;
import framework.Register;

public class ZoomInAction extends AbstractAction {

	private static final long serialVersionUID = 96597461518330932L;


	private final Register _register = Register.getInstance();

	
	@Override
	public void actionPerformed(final ActionEvent e) {
		PerspectiveController perspective;
		perspective = (PerspectiveController) _register
				.get("controller.PerspectiveController");
		perspective.zoomAction(1);
	}
}
