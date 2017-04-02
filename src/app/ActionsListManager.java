
package app;

import java.util.ArrayList;

import app.model.Perspective;
import framework.Register;


public class ActionsListManager {

	
	private int _index = -1;


	private final ArrayList<Perspective> _list;


	private final Register register = Register.getInstance();

	
	public ActionsListManager() {
		_list = new ArrayList<Perspective>();
	}


	public void add() {
		Perspective perspective;
		perspective = (Perspective) register.get("model.Perspective");
		if (perspective != null) {
			clearList();
			_index++;
			_list.add(_index, new Perspective(perspective));
		}
	}

	
	private void clearList() {
		for (int i = _list.size(); i > _index; i--)
			try {
				_list.remove(i);
			} catch (final Exception e) {

			}
	}

	
	public Perspective get() {
		return this.get(_index);
	}

	
	public Perspective get(final int index) {
		return _list.get(index);
	}


	public boolean isRedoable() {
		return _index != _list.size() - 1;
	}


	public boolean isUndoable() {
		return _index != -1;
	}

	
	public void redo() {
		Perspective newPerspective = null;
		try {
			newPerspective = this.get(_index + 1);
		} catch (final Exception e) {
		}
		if (isRedoable() && newPerspective != null) {
			Perspective perspective;
			perspective = (Perspective) register.get("model.Perspective");
			perspective.setPerspective(newPerspective);
			_index++;

		}
	}


	public void undo() {
		if (!isUndoable())
			return;
		else if (_index == 0) {
			Perspective perspective;
			perspective = (Perspective) register.get("model.Perspective");
			final Perspective newPerspective = new Perspective();
			perspective.setPerspective(newPerspective);
			_index--;
		} else {
			Perspective perspective;
			perspective = (Perspective) register.get("model.Perspective");
			_index--;
			final Perspective newPerspective = new Perspective(this.get());
			perspective.setPerspective(newPerspective);
		}
	}
}
