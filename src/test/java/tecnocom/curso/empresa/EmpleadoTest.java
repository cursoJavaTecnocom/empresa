package tecnocom.curso.empresa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import datos.Datoslaborale;
import datos.Datospersonale;
import datos.Empleado;
import datos.Empresa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
@FixMethodOrder(MethodSorters.JVM)
public class EmpleadoTest {
	
	/*Comentario para Git*/

	@Autowired
	private HomeController controler;

	private datos.Empleado empleado;

	public datos.Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(datos.Empleado empleado) {
		this.empleado = empleado;
	}

	@Test
	public void alta() {

		setEmpleado(new datos.Empleado());

		try {
			Empresa empresa = (Empresa) getControler().getEmpresaDelegate()
					.dameObjeto(496, Empresa.class);
			Datoslaborale dl = (Datoslaborale) getControler()
					.getEmpresaDelegate().dameObjeto(76, Datoslaborale.class);
			Datospersonale dp = (Datospersonale) getControler()
					.getEmpresaDelegate().dameObjeto(7, Datospersonale.class);
			getEmpleado().setNombre("javier");
			getEmpleado().setApellidos("diaz");
			getEmpleado().setEdad("25");
			getEmpleado().setDatoslaborale(dl);
			getEmpleado().setDatospersonale(dp);
			getEmpleado().setEmpresa(empresa);
			getEmpleado().setTelefono("939393");
			getControler().getEmpresaDelegate().grabaObjeto(getEmpleado());
			System.out.println(getEmpleado());
			// getControler().getEmpresaDelegate().getEmpresaService().getEmpresaDao().getSesion().close();
			getEmpleado().setNombre("pepe");
			getControler().getEmpresaDelegate().grabaObjeto(getEmpleado());
			// getControler().getEmpresaDelegate().getEmpresaService().getEmpresaDao().getSesion().close();

			getControler().getEmpresaDelegate().borrar(getEmpleado().getId(),
					Empleado.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void listado1() {
		ModelAndView model = controler.empleados();
		if (model.getViewName().equals("error"))
			fail();

	}

	@Test
	public void listado() {

		// HomeController homeController = new HomeController();

		try {
			assertNotNull(controler.getEmpresaDelegate().dameDatos(
					EmpleadoTest.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	public HomeController getControler() {
		return controler;
	}

	public void setControler(HomeController controler) {
		this.controler = controler;
	}

}
