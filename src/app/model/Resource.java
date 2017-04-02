package app.model;

import framework.Model;


public class Resource extends Model {

	
	private String _copyright = "&copy; 2011, Ecole des Technologies Superieures";


	private String _title = "Laboratory LOG121#4 - Image Perspective";

	
	private String _version = "1.0.0";

	
	public final String getCopyright() {
		return _copyright;
	}

	
	public final String getTitle() {
		return _title;
	}


	public final String getVersion() {
		return _version;
	}

	

	public final void setCopyright(final String _copyright) {
		this._copyright = _copyright;
	}

	
	public final void setTitle(final String title) {
		_title = title;
	}

	
	public final void setVersion(final String _version) {
		this._version = _version;
	}

}
