
package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.model.Resource;
import app.view.AboutView;
import framework.Controller;
import framework.View;

public class ResourceController extends Controller<Resource, View> implements
ActionListener {
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		new AboutView();
	}
}
