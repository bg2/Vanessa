
package app.model;

import java.io.Serializable;

import framework.Model;


public class Perspective extends Model implements Serializable {

	
	private static final long serialVersionUID = -2697391205307141912L;

	
	private transient Image _model;

	
	private int _xPosition;

	
	private int _yPosition;

	
	private double _zoomScaler = 1;


	public Perspective() {
		_model = (Image) _register.get("model.Image");
		// try {
		// _model.changed();
		// } catch (final Exception e) {
		// System.out.println(e.getMessage());
		// }
	}

	
	public Perspective(final Perspective perspective) {
		_model = (Image) _register.get("model.Image");
		try {
			_model.notifyObservers();
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}
		_xPosition = perspective.getxPesition();
		_yPosition = perspective.getyPesition();
		_zoomScaler = perspective.getZoomScaler();
	}

	
	public Image getImageModel() {
		return _model;
	}

	
	public int getImageSacledHeight() {
		return (int) (_model.getHeight() * getZoomScaler());
	}

	
	public int getImageSacledWidth() {
		return (int) (_model.getWidth() * getZoomScaler());
	}

	
	public Perspective getState() {
		return new Perspective(this);
	}

	
	public int getxPesition() {
		return _xPosition;
	}

	
	public int getyPesition() {
		return _yPosition;
	}

	
	public double getZoomScaler() {
		return _zoomScaler;
	}

	
	public void reset() {
		_model = (Image) _register.get("model.Image");
		_xPosition = 0;
		_yPosition = 0;
		_zoomScaler = 1;
		try {
			_model.changed();
		} catch (final Exception e) {
		}
	}

	
	public void setPerspective(final Perspective perspectiveModel) {
		_xPosition = perspectiveModel._xPosition;
		_yPosition = perspectiveModel._yPosition;
		_zoomScaler = perspectiveModel._zoomScaler;
		try {
			_model.changed();
		} catch (final Exception e) {
		}
	}

	
	public void setPosition(final int xPosition, final int yPosition) {
		_xPosition = xPosition - getImageSacledWidth() / 2;
		_yPosition = yPosition - getImageSacledHeight() / 2;
		try {
			_model.changed();
		} catch (final Exception e) {
		}
	}

	
	public void setZoomScaler(final double zoomScaler) {
		if (zoomScaler > 0)
			_zoomScaler *= Math.pow(1.25, Math.abs(zoomScaler));
		else
			_zoomScaler /= Math.pow(1.25, Math.abs(zoomScaler));
		try {
			_model.changed();
		} catch (final Exception e) {
		}
	}

}
