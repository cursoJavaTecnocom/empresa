package empresa.daos;

import java.util.List;

public interface EmpresaDaoInterface {
	public List<?> dameDatos(Class<?> clase) throws Exception;
	public void borrar(int id, Class<?> clase) throws Exception;
	public Object dameObjeto(int id, Class<?> clase) throws Exception;
	public void grabaObjeto(Object objeto) throws Exception;
	
}
