
package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.ActionsListManager;
import app.model.Image;
import app.model.Perspective;
import framework.Controller;
import framework.View;


public class PerspectiveController extends Controller<Perspective, View>
		implements ActionListener, MouseWheelListener, MouseListener {

	
	@Override
	public void actionPerformed(final ActionEvent e) {
	}

	
	public void addStep() {
		ActionsListManager list;
		list = (ActionsListManager) _register.get("list");
		list.add();
	}

	
	@Override
	public void mouseClicked(final MouseEvent e) {
		moveAction(e.getX(), e.getY());
	}

	
	@Override
	public void mouseEntered(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void mouseExited(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void mousePressed(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void mouseReleased(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void mouseWheelMoved(final MouseWheelEvent e) {
		zoomAction(-e.getWheelRotation());
	}

	
	public void moveAction() {
		final JTextField xPosition = new JTextField();
		final JTextField yPosition = new JTextField();
		final Object[] message = { "X pesition:", xPosition, "Y pesition:",
				yPosition };

		final int option = JOptionPane.showConfirmDialog(null, message, "Move",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			final int x = Integer.parseInt(xPosition.getText());
			final int y = Integer.parseInt(yPosition.getText());
			this.moveAction(x, y);
		} else
			System.out.println("Login canceled");
	}

	
	public void moveAction(final int x, final int y) {
		Perspective perspective;
		perspective = (Perspective) _register.get("model.Perspective");
		if (perspective != null)
			perspective.setPosition(x, y);
		addStep();
	}

	
	public void redoAction() {
		ActionsListManager list;
		list = (ActionsListManager) _register.get("list");
		list.redo();
	}

	
	public void saveAction() {

	
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setCurrentDirectory(new java.io.File("."));
		final int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			final String path = fc.getCurrentDirectory().toString() + "\\"
					+ fc.getSelectedFile().getName();
			;
			
			System.out.println("path: " + path + ".");
		} else {
			System.out.println("Open command cancelled by user.");
			return;
		}

		Image imageModel;
		imageModel = (Image) _register.get("model.Image");
		final java.awt.Image image = imageModel.getImage();
		Perspective perspectiveModel;
		perspectiveModel = (Perspective) _register.get("model.Perspective");
		String fileName = fc.getSelectedFile().getName();
		if (fileName.isEmpty() || fileName.equals(""))
			fileName = "default";
		try {
			final File file = new File(fc.getCurrentDirectory().toString()
					+ "\\" + fileName + ".ser");
			final FileOutputStream fos = new FileOutputStream(file);
			final ObjectOutputStream oos = new ObjectOutputStream(fos);

			ImageIO.write((RenderedImage) image, "jpg", oos);
			oos.writeObject(perspectiveModel);

			oos.close();
			fos.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	
	public void undoAction() {
		ActionsListManager list;
		list = (ActionsListManager) _register.get("list");
		list.undo();
	}

	
	public void zoomAction(final int wheelRotation) {
		Perspective perspective;
		perspective = (Perspective) _register.get("model.Perspective");
		if (perspective != null)
			perspective.setZoomScaler(wheelRotation);
		addStep();

	}
}
