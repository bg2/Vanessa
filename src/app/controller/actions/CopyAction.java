
package app.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.model.Perspective;
import framework.Register;


public class CopyAction extends AbstractAction {

	private static final long serialVersionUID = 5512504222909156131L;

	
	private final Register _register = Register.getInstance();

	
	@Override
	public void actionPerformed(final ActionEvent e) {
		Perspective perspective;
		perspective = (Perspective) _register.get("model.Perspective");
		if (perspective != null)
			_register.add("copied", new Perspective(perspective));
	}
}
