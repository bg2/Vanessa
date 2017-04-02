
package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import framework.Register;


public class Menu extends JMenuBar {
	
	private static final long serialVersionUID = -5617155576631422259L;

	
	private final Register register = Register.getInstance();

	
	public Menu() {
		initMenu();
	}

	
	private void initMenu() {
		register.add("menu", this);

		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		register.add("menu.file", fileMenu);
		this.add(fileMenu);

		final JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		register.add("menu.edit", editMenu);
		editMenu.setEnabled(false);
		this.add(editMenu);

		final JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		register.add("menu.help", helpMenu);
		this.add(helpMenu);

		final JMenuItem openItem = new JMenuItem("Open");
	
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		register.add("menu.file.open", openItem);
		fileMenu.add(openItem);

		final JMenuItem saveItem = new JMenuItem("Save");
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		register.add("menu.file.save", saveItem);
		fileMenu.add(saveItem);

		final JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				System.exit(0);
			}
		});
		register.add("menu.file.exit", exitItem);
		fileMenu.add(exitItem);

		final JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		register.add("menu.help.about", aboutItem);
		helpMenu.add(aboutItem);

		final JMenuItem zoomInImage = new JMenuItem("Zoom In");
		zoomInImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD,
				ActionEvent.CTRL_MASK));
		register.add("menu.edit.zoom.in", zoomInImage);
		editMenu.add(zoomInImage);

		final JMenuItem zoomOutImage = new JMenuItem("Zoom Out");
		zoomOutImage.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
		register.add("menu.edit.zoom.out", zoomOutImage);
		editMenu.add(zoomOutImage);

		final JMenuItem moveImage = new JMenuItem("Move Image");
		moveImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				ActionEvent.CTRL_MASK));
		register.add("menu.edit.move", moveImage);
		editMenu.add(moveImage);

		final JMenuItem undo = new JMenuItem("Un-Do");
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				ActionEvent.CTRL_MASK));
		register.add("menu.edit.undo", undo);
		editMenu.add(undo);

		final JMenuItem redo = new JMenuItem("Re-Do");
		redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
				ActionEvent.CTRL_MASK));
		register.add("menu.edit.redo", redo);
		editMenu.add(redo);

		final JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		register.add("menu.edit.copy", copy);
		editMenu.add(copy);

		final JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				ActionEvent.CTRL_MASK));
		register.add("menu.edit.paste", paste);
		editMenu.add(paste);

	}
}
