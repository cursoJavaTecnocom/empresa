package empresa.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import datos.Empresa;
import empresa.services.EmpresaService;

@Component
public class EmpresaDelegate {

	@Autowired
	private EmpresaService empresaService;

	public List<?> dameDatos(Class<?> clase) throws Exception {
		return getEmpresaService().dameDatos(clase);
	}

	public EmpresaService getEmpresaService() {
		return empresaService;
	}

	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	public void borrar(int id, Class<?> clase) throws Exception {
		getEmpresaService().borrar(id, clase);

	}

	public Object dameObjeto(int id, Class<?> clase) throws Exception {

		return getEmpresaService().dameObjeto(id, clase);
	}

	public void grabaObjeto(Object objeto) throws Exception {
		getEmpresaService().grabaObjeto(objeto);
		
	}

}
