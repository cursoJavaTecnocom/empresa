//chorreo - Angel

package empresa.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import anotaciones.ManejadorDeSesiones;

@Repository
public class EmpresaDao implements EmpresaDaoInterface {

	private Session sesion;

	@Autowired
	private SessionFactory factoria;

	@ManejadorDeSesiones
	public List<?> dameDatos(Class<?> clase) throws Exception {

		setSesion(getFactoria().openSession());
		Criteria cri = getSesion().createCriteria(clase);
		List<?> datos = cri.list();

		return datos;

	}

	@Override
	public void borrar(int id, Class<?> clase) throws Exception {
		if(getSesion()==null)
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();

		getSesion().getTransaction().setTimeout(1);
		Object objeto = getSesion().load(clase, id);
		getSesion().delete(objeto);

		getSesion().getTransaction().commit();

	}

	@Override
	public Object dameObjeto(int id, Class<?> clase) throws Exception {

		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();

		return getSesion().load(clase, id);
	}

	@Override
	public void grabaObjeto(Object objeto) throws Exception {
		if(getSesion()==null)
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		getSesion().saveOrUpdate(objeto);
		getSesion().getTransaction().commit();
	}

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}

	public SessionFactory getFactoria() {
		return factoria;
	}

	public void setFactoria(SessionFactory factoria) {
		this.factoria = factoria;
	}

}
