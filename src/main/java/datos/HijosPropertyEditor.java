package datos;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class HijosPropertyEditor extends PropertyEditorSupport {

	

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Hijo hijo= new Hijo();
		try {
			hijo.setId(Integer.parseInt(text));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
		setValue(hijo);
	}

	
}
