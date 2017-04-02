
package app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import app.model.Image;
import framework.Register;


public class ComponentStateCheker {

	
	private final Register _register = Register.getInstance();

	
	public ComponentStateCheker() {
		runBackgroundWorker();
	}

	
	private void runBackgroundWorker() {
		final JMenu edit = (JMenu) _register.get("menu.edit");
		final Image image = (Image) _register.get("model.Image");
		final ActionsListManager list = (ActionsListManager) _register
				.get("list");

		final JMenuItem paste = (JMenuItem) _register.get("menu.edit.paste");
		final JMenuItem undo = (JMenuItem) _register.get("menu.edit.undo");
		final JMenuItem redo = (JMenuItem) _register.get("menu.edit.redo");
		final JMenuItem save = (JMenuItem) _register.get("menu.file.save");

		final Runnable r = new Runnable() {
			@Override
			public void run() {
				while (true)
					try {
						if (image.getImage() == null) {
							paste.setEnabled(false);
							undo.setEnabled(false);
							save.setEnabled(false);
							redo.setEnabled(false);
						} else {
							save.setEnabled(true);
							edit.setEnabled(true);
							redo.setEnabled(list.isRedoable());
							undo.setEnabled(list.isUndoable());
							paste.setEnabled(_register.get("copied") != null);
						}
						Thread.sleep(300);
					} catch (final InterruptedException e) {
						e.printStackTrace();
					}
			}
		};

		final ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(r);

	}

}
