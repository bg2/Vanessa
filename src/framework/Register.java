
package framework;

import java.util.HashMap;
import java.util.Map;


public class Register {

	
	private static final Register INSTANCE = new Register();

	
	public static Register getInstance() {
		return Register.INSTANCE;
	}

	
	private final Map<String, Object> REGISTER = new HashMap<String, Object>();

	
	private Register() {
	}

	
	public void add(final String key, final Object value) {
		REGISTER.put(key, value);
	}

	
	public boolean contains(final String key) {
		return REGISTER.containsKey(key);
	}

	
	public Object get(final String key) {
		return REGISTER.get(key);
	}
}
