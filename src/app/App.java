
package app;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import app.controller.ImageController;
import app.controller.PerspectiveController;
import app.controller.ResourceController;
import app.controller.actions.CopyAction;
import app.controller.actions.MoveAction;
import app.controller.actions.PasteAction;
import app.controller.actions.RedoAction;
import app.controller.actions.SaveAction;
import app.controller.actions.UndoAction;
import app.controller.actions.ZoomInAction;
import app.controller.actions.ZoomOutAction;
import app.model.Image;
import app.model.Perspective;
import app.model.Resource;
import app.view.AppView;
import app.view.MoveView;
import app.view.OriginalView;
import app.view.ZoomView;
import framework.Application;


public final class App extends Application {

	
	public static void main(final String[] args) {
		new App();
	}


	final int WINDOW_HEIGHT = 400;


	final int WINDOW_WIDTH = 647;


	private void addObservers() {
		final Image imageModel = (Image) _register.get("model.Image");
		imageModel.addObserver((OriginalView) _register.get("vue.original"));
		imageModel.addObserver((MoveView) _register.get("vue.move"));
		imageModel.addObserver((ZoomView) _register.get("vue.zoom"));

	}


	private void initAction() {
		((JMenuItem) _register.get("menu.file.open"))
				.addActionListener((ActionListener) _register
						.get("controller.ImageController"));

		((JMenuItem) _register.get("menu.file.save"))
				.addActionListener((ActionListener) _register
						.get("controller.action.save"));

		((JMenuItem) _register.get("menu.help.about"))
				.addActionListener((ActionListener) _register
						.get("controller.ResourceController"));

		((JMenuItem) _register.get("menu.edit.zoom.in"))
				.addActionListener((ActionListener) _register
						.get("controller.action.zoom.in"));

		((JMenuItem) _register.get("menu.edit.zoom.out"))
				.addActionListener((ActionListener) _register
						.get("controller.action.zoom.out"));

		((JMenuItem) _register.get("menu.edit.move"))
				.addActionListener((ActionListener) _register
						.get("controller.action.move"));

		((JMenuItem) _register.get("menu.edit.undo"))
				.addActionListener((ActionListener) _register
						.get("controller.action.undo"));

		((JMenuItem) _register.get("menu.edit.redo"))
				.addActionListener((ActionListener) _register
						.get("controller.action.redo"));

		((JMenuItem) _register.get("menu.edit.copy"))
				.addActionListener((ActionListener) _register
						.get("controller.action.copy"));

		((JMenuItem) _register.get("menu.edit.paste"))
				.addActionListener((ActionListener) _register
						.get("controller.action.paste"));
	}


	@Override
	protected void initControllers() {
		_register.add("controller.ImageController", new ImageController());
		_register.add("controller.PerspectiveController",
				new PerspectiveController());
		_register
		.add("controller.ResourceController", new ResourceController());
		_register.add("controller.action.copy", new CopyAction());
		_register.add("controller.action.paste", new PasteAction());
		_register.add("controller.action.move", new MoveAction());
		_register.add("controller.action.redo", new RedoAction());
		_register.add("controller.action.undo", new UndoAction());
		_register.add("controller.action.save", new SaveAction());
		_register.add("controller.action.zoom.in", new ZoomInAction());
		_register.add("controller.action.zoom.out", new ZoomOutAction());
	}


	protected void initModels() {
		_register.add("model.Resource", new Resource());
		_register.add("model.Image", new Image());
		_register.add("model.Perspective", new Perspective());
	}


	protected void start() {
		_frame.setJMenuBar(new Menu());

		_register.add("list", new ActionsListManager());

		
		initAction();

		((Resource) _register.get("model.Resource"))
		.setTitle("Laboratory LOG121#4 - Image Perspective");
		_frame.setTitle(((Resource) _register.get("model.Resource")).getTitle());
		_frame.getContentPane().add(new AppView());


		addObservers();

		final Rectangle screenRect = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration().getBounds();

		final Rectangle frameRect = new Rectangle(Math.min(WINDOW_WIDTH,
				screenRect.width), Math.min(WINDOW_HEIGHT, screenRect.height));

		_frame.setLocation((screenRect.width - frameRect.width) / 2,
				(screenRect.height - frameRect.height) / 2);
		_frame.setSize(frameRect.width, frameRect.height);

		_frame.setVisible(true);
		final ComponentStateCheker checker = new ComponentStateCheker();
		_register.add("checker", checker);
	}
}
