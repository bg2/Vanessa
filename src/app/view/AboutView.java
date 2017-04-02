package app.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import app.controller.ResourceController;
import app.model.Resource;
import framework.View;


public final class AboutView extends View<Resource, ResourceController> {

	private static final long serialVersionUID = -6060053024108718057L;


	@Override
	protected void render() {
		final Resource model = (Resource) _register.get("model.Resource");
	
	}
}
