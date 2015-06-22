package empresa.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import datos.Empresa;
import empresa.daos.EmpresaDao;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaDao empresaDao;

	

	public List<?> dameDatos(Class<?> clase) throws Exception {

		List<?> salida = null;
		Method metodo = getEmpresaDao().getClass().getMethod("dameDatos",
				Class.class);
		salida = (List<?>) metodo.invoke(getEmpresaDao(), clase);

		return salida;

	}

	public void borrar(int id, Class<?> clase) throws Exception {

		Method metodo = getEmpresaDao().getClass().getMethod("borrar",
				int.class, Class.class);
		metodo.invoke(getEmpresaDao(), id, clase);

	}

	public Object dameObjeto(int id, Class<?> clase) throws Exception {

		Method metodo = getEmpresaDao().getClass().getMethod("dameObjeto",
				int.class, Class.class);
		return metodo.invoke(getEmpresaDao(), id, clase);
	}

	public EmpresaDao getEmpresaDao() {
		return empresaDao;
	}

	public void setEmpresaDao(EmpresaDao empresaDao) {
		this.empresaDao = empresaDao;
	}

	public void grabaObjeto(Object objeto) throws Exception {
		Method metodo= getEmpresaDao().getClass().getMethod("grabaObjeto", Object.class);
		metodo.invoke(getEmpresaDao(), objeto);
		
	}

}
