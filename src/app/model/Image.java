
package app.model;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import framework.Model;


public class Image extends Model {


	private java.awt.Image _image;


	public Image() {
		// Do nothing but initiate the image to null
		_image = null;
	}

	
	public Image(final Image model) {
		_image = model.getImage();
	}

	
	public Image(final java.awt.Image image) {
		_image = image;
	}

	
	public Image(final String ImageFilePath) {
		this.setImage(ImageFilePath);
	}

	
	public int getHeight() {
		if (_image != null)
			return _image.getHeight(null);
		else
			return 0;
	}

	
	public java.awt.Image getImage() {
		return _image;
	}

	
	public int getWidth() {
		if (_image != null)
			return _image.getWidth(null);
		else
			return 0;
	}

	
	public void setImage(final RenderedImage image) {
		_image = (java.awt.Image) image;
		changed();
	}

	
	public void setImage(final String ImageFilePath) {
		try {
			_image = ImageIO.read(new File(ImageFilePath));
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		changed();
	}

	/**
	 * Test.
	 */
	public void test() {
		this.notifyObservers();
	}
}
