
package app.view;

import java.awt.Graphics;
import java.util.Observable;

import app.controller.ImageController;
import app.model.Image;
import framework.View;


public class OriginalView extends View<Image, ImageController> {

	
	private static final long serialVersionUID = -5599197974491141284L;

	
	@Override
	public void paint(final Graphics g) {
		super.paintComponent(g);
		try {
			g.drawImage(model.getImage(), 0, 0, null);
		} catch (final NullPointerException e) {
		}
	}

	
	@Override
	protected void render() {
		this.model((Image) _register.get("model.Image"));
		this.controller((ImageController) _register
				.get("controller.ImageController"));
	}

	
	@Override
	public void update(final Observable model, final Object value) {
		repaint();
	}
}
