
package app.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.model.Perspective;
import framework.Register;


public class PasteAction extends AbstractAction {

	
	private static final long serialVersionUID = -256992599601109032L;

	
	private final Register _register = Register.getInstance();

	
	@Override
	public void actionPerformed(final ActionEvent e) {
		Perspective perspective;
		perspective = (Perspective) _register.get("model.Perspective");
		Perspective copy;
		copy = (Perspective) _register.get("copied");
		if (perspective != null)
			perspective.setPerspective(copy);
	}
}
