
package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import app.model.Image;
import app.model.Perspective;
import app.view.OriginalView;
import framework.Controller;


public class ImageController extends Controller<Image, OriginalView> implements
ActionListener {

	
	@Override
	public void actionPerformed(final ActionEvent e) {
		openAction();
	}

	
	private String getExtension(final String filePath) {
		String extension = "";

		final int index = filePath.lastIndexOf('.');
		if (index > 0)
			extension = filePath.substring(index + 1);
		return extension;
	}

	
	protected void openAction() {

		final JFileChooser openFile = new JFileChooser();
		final int rVal = openFile.showOpenDialog(null);

		if (rVal == JFileChooser.APPROVE_OPTION) {
			final String path = openFile.getCurrentDirectory().toString() + "/"
					+ openFile.getSelectedFile().getName();

			if (getExtension(path).equals("ser"))
				openImageAndPerspective(path);
			else
				openImage(path);
		} else if (rVal == JFileChooser.CANCEL_OPTION)
			System.out.println("You pressed cancel");
	}

	
	private void openImage(final String path) {
		
		_register.add("model.Perspective", new Perspective());
		((Image) _register.get("model.Image")).setImage(path);

	}

	
	private void openImageAndPerspective(final String path) {
		try {
			final FileInputStream fin = new FileInputStream(path);
			final ObjectInputStream ois = new ObjectInputStream(fin);

			final RenderedImage image = ImageIO.read(ois);
			final Perspective perspectiveModel = (Perspective) ois.readObject();
			
			Perspective perspective;
			perspective = (Perspective) _register.get("model.Perspective");
			perspective.setPerspective(perspectiveModel);
			
			((Image) _register.get("model.Image")).setImage(image);

		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

}
