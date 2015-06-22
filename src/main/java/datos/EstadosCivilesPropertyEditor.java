package datos;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class EstadosCivilesPropertyEditor extends PropertyEditorSupport {

	

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Estadoscivile estadoscivile= new Estadoscivile();
		try {
			estadoscivile.setId(Integer.parseInt(text));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		setValue(estadoscivile);
	}

	
}
