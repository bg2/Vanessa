
package app.view;

import java.awt.Graphics;
import java.util.Observable;

import app.controller.PerspectiveController;
import app.model.Perspective;
import framework.View;


public final class MoveView extends View<Perspective, PerspectiveController> {


	private static final long serialVersionUID = 1619754923595213218L;

	
	@Override
	public void paint(final Graphics g) {
		super.paintComponent(g);
		try {
			g.drawImage(model.getImageModel().getImage(), model.getxPesition(),
					model.getyPesition(), model.getImageSacledWidth(),
					model.getImageSacledHeight(), null);
		} catch (final NullPointerException e) {
		}
	}

	
	@Override
	protected void render() {
		this.model((Perspective) _register.get("model.Perspective"));
		this.controller((PerspectiveController) _register
				.get("controller.PerspectiveController"));
		addMouseListener(controller);
	}

	
	@Override
	public void update(final Observable model, final Object value) {
		super.model((Perspective) _register.get("model.Perspective"));
		repaint();
	}

}
