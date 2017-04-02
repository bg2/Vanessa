
package app.view;

import java.awt.Graphics;
import java.util.Observable;

import app.controller.PerspectiveController;
import app.model.Perspective;
import framework.View;


public class ZoomView extends View<Perspective, PerspectiveController> {

	
	private static final long serialVersionUID = 2251167999138857478L;

	
	@Override
	public void paint(final Graphics g) {
		super.paintComponent(g);
		try {
			g.drawImage(model.getImageModel().getImage(), model.getxPesition(),
					model.getyPesition(), model.getImageSacledWidth(),
					model.getImageSacledHeight(), null);
		} catch (final Exception e) {
		}
	}

	
	@Override
	protected void render() {
		this.model((Perspective) _register.get("model.Perspective"));
		this.controller((PerspectiveController) _register
				.get("controller.PerspectiveController"));

		addMouseWheelListener(controller);
	}

	
	@Override
	public void update(final Observable model, final Object value) {
		super.model((Perspective) _register.get("model.Perspective"));
		repaint();
	}
}
