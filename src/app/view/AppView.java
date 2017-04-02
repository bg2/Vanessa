
package app.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;

import app.controller.PerspectiveController;
import framework.Controller;
import framework.Model;

import framework.View;

public final class AppView extends View<Model, Controller> {

	
	private static final long serialVersionUID = -1246493417689049998L;

	
	@Override
	protected void render() {
		final GridLayout gl = new GridLayout(0, 3);
		setLayout(gl);

		final OriginalView originalVue = new OriginalView();
		_register.add("vue.original", originalVue);
		originalVue.setBorder(BorderFactory.createLineBorder(Color.black));
		add(originalVue);

		final MoveView moveVue = new MoveView();
		_register.add("vue.move", moveVue);
		moveVue.setBorder(BorderFactory.createLineBorder(Color.black));
		moveVue.addMouseListener((PerspectiveController) _register
				.get("controller.Perspective"));
		add(moveVue);

		final ZoomView zoomVue = new ZoomView();
		_register.add("vue.zoom", zoomVue);
		zoomVue.setBorder(BorderFactory.createLineBorder(Color.black));
		moveVue.addMouseWheelListener((PerspectiveController) _register
				.get("controller.Perspective"));
		add(zoomVue);
	}
}
