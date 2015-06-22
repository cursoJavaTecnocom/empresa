package tecnocom.curso.empresa;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import datos.Cargo;
import datos.CargoPropertyEditor;
import datos.Datoslaborale;
import datos.Datospersonale;
import datos.Empleado;
import datos.Empresa;
import datos.EstadosCivilesPropertyEditor;
import datos.Estadoscivile;
import datos.Hijo;
import datos.HijosPropertyEditor;
import empresa.delegates.EmpresaDelegate;

/**
 * Handles requests for the application home page.
 */
@Controller
@Qualifier("homeControler")
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Cargo.class, new CargoPropertyEditor());
		binder.registerCustomEditor(Hijo.class, new HijosPropertyEditor());
		binder.registerCustomEditor(Estadoscivile.class, new EstadosCivilesPropertyEditor());
	}

	@Autowired
	private EmpresaDelegate empresaDelegate;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "index";
	}

	@RequestMapping("grabaEmpresa.gin")
	public ModelAndView grabaEmpresa(Empresa empresa) {

		try {
			getEmpresaDelegate().grabaObjeto(empresa);

			return empresas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}

	@RequestMapping("grabaCargo.gin")
	public ModelAndView grabaCargo(Cargo cargo) {

		try {
			getEmpresaDelegate().grabaObjeto(cargo);

			return cargos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}
	
	
	@RequestMapping("grabaDatoPersonal.gin")
	public ModelAndView grabaDatoPersonal(Datospersonale datoPersonal) {

		try {
			getEmpresaDelegate().grabaObjeto(datoPersonal);

			return datosPersonales();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}
	

	@RequestMapping("grabaDatoLaboral.gin")
	public ModelAndView grabaDatoLaboral(Datoslaborale datoLaboral) {

		try {
			getEmpresaDelegate().grabaObjeto(datoLaboral);

			return datosLaborales();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}

	@RequestMapping("grabaHijo.gin")
	public ModelAndView grabaHijo(Hijo hijo) {

		try {
			getEmpresaDelegate().grabaObjeto(hijo);

			return hijos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}

	@RequestMapping("modificaEmpresa.gin")
	public ModelAndView modificaEmpresa(int id) {
		Empresa empresa = null;
		if (id == 0) {
			empresa = new Empresa();
		}

		try {
			if (id > 0)
				empresa = (Empresa) getEmpresaDelegate().dameObjeto(id,
						Empresa.class);

			ModelAndView salida = new ModelAndView("modificaEmpresa");
			salida.addObject("empresa", empresa);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	
	
	
	@RequestMapping("modificaEmpleado.gin")
	public ModelAndView modificaEmpleado(int id) {
		Empleado empleado = null;
		if (id == 0) {
			empleado = new Empleado();
		}

		try {
			if (id > 0)
				empleado = (Empleado) getEmpresaDelegate().dameObjeto(id,
						Empleado.class);

			ModelAndView salida = new ModelAndView("modificaEmpleado");
			salida.addObject("empleado", empleado);
			List<Empresa> empresas= (List<Empresa>) getEmpresaDelegate().dameDatos(Empresa.class);
			List<Datospersonale> datosPersonales = (List<Datospersonale>) getEmpresaDelegate()
					.dameDatos(Datospersonale.class);
			List<Datoslaborale> datosLaborales = (List<Datoslaborale>) getEmpresaDelegate().dameDatos(Datoslaborale.class);
			salida.addObject("empresas", empresas);
			salida.addObject("datosPersonales", datosPersonales);
			salida.addObject("datosLaborales", datosLaborales);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}
	
	
	
	@RequestMapping("modificaCargo.gin")
	public ModelAndView modificaCargo(int id) {
		Cargo cargo = null;
		if (id == 0) {
			cargo = new Cargo();
		}

		try {
			if (id > 0)
				cargo = (Cargo) getEmpresaDelegate()
						.dameObjeto(id, Cargo.class);

			ModelAndView salida = new ModelAndView("modificaCargo");
			salida.addObject("cargo", cargo);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("modificaHijo.gin")
	public ModelAndView modificaHijo(int id) {
		Hijo hijo = null;
		if (id == 0) {
			hijo = new Hijo();
		}

		try {
			if (id > 0)
				hijo = (Hijo) getEmpresaDelegate().dameObjeto(id, Hijo.class);

			ModelAndView salida = new ModelAndView("modificaHijo");
			salida.addObject("hijo", hijo);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("cargos.gin")
	public ModelAndView cargos() {

		try {
			List<Cargo> cargos = (List<Cargo>) getEmpresaDelegate().dameDatos(
					Cargo.class);
			Set<Cargo> cargosOrdenadas = new TreeSet<Cargo>();
			for (Cargo cargo : cargos) {
				cargosOrdenadas.add(cargo);
			}
			ModelAndView salida = new ModelAndView("cargo");
			salida.addObject("cargos", cargosOrdenadas);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("hijos.gin")
	public ModelAndView hijos() {

		try {
			List<Hijo> hijos = (List<Hijo>) getEmpresaDelegate().dameDatos(
					Hijo.class);

			ModelAndView salida = new ModelAndView("hijos");
			salida.addObject("hijos", hijos);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("empresas.gin")
	public ModelAndView empresas() {

		try {
			List<Empresa> empresas = (List<Empresa>) getEmpresaDelegate()
					.dameDatos(Empresa.class);
			
			ModelAndView salida = new ModelAndView("empresa");
			salida.addObject("empresas", empresas);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}
	
	@RequestMapping("empleados.gin")
	public ModelAndView empleados() {

		try {
			List<Empleado> empleados = (List<Empleado>) getEmpresaDelegate()
					.dameDatos(Empleado.class);
			
			ModelAndView salida = new ModelAndView("empleados");
			salida.addObject("empleados", empleados);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}
	

	@RequestMapping("datosPersonales.gin")
	public ModelAndView datosPersonales() {

		try {
			List<Datospersonale> datosPersonales = (List<Datospersonale>) getEmpresaDelegate()
					.dameDatos(Datospersonale.class);

			ModelAndView salida = new ModelAndView("datosPersonales");
			salida.addObject("datosPersonales", datosPersonales);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("datosLaborales.gin")
	public ModelAndView datosLaborales() {

		try {
			List<Datoslaborale> datosLaborales = (List<Datoslaborale>) getEmpresaDelegate()
					.dameDatos(Datoslaborale.class);

			ModelAndView salida = new ModelAndView("datosLaborales");
			salida.addObject("datosLaborales", datosLaborales);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("modificaDatoPersonal.gin")
	public ModelAndView modificadatoPersonal(int id) {

		Datospersonale datoPersonal = null;
		if (id == 0)
			datoPersonal = new Datospersonale();

		try {
			if (id > 0)
				datoPersonal = (Datospersonale) getEmpresaDelegate()
						.dameObjeto(id, Datospersonale.class);

			List<Estadoscivile> estadosCiviles = (List<Estadoscivile>) getEmpresaDelegate()
					.dameDatos(Estadoscivile.class);
			List<Hijo> hijos = (List<Hijo>) getEmpresaDelegate()
					.dameDatos(Hijo.class);


			ModelAndView salida = new ModelAndView("modificaDatoPersonal");
			salida.addObject("estadosCiviles", estadosCiviles);
			salida.addObject("hijos", hijos);
			salida.addObject("datoPersonal",datoPersonal);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
		/*
		 * datoPersonal.setSalario(salario); Cargo
		 * cargo=getEmpresaDelegate().dameObjeto(cargo, Cargo.class);
		 */

	}

	@RequestMapping("modificaDatoLaboral.gin")
	public ModelAndView modificaDatoLaboral(int id) {

		Datoslaborale datoLaboral = null;
		if (id == 0)
			datoLaboral = new Datoslaborale();

		try {
			if (id > 0)
				datoLaboral = (Datoslaborale) getEmpresaDelegate().dameObjeto(
						id, Datoslaborale.class);

			List<Cargo> cargos = (List<Cargo>) getEmpresaDelegate().dameDatos(
					Cargo.class);

			ModelAndView salida = new ModelAndView("modificaDatoLaboral");
			salida.addObject("cargos", cargos);
			salida.addObject("datoLaboral", datoLaboral);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
		/*
		 * datoLaboral.setSalario(salario); Cargo
		 * cargo=getEmpresaDelegate().dameObjeto(cargo, Cargo.class);
		 */

	}

	@RequestMapping("borraEmpresa.gin")
	public ModelAndView borraEmpresa(int id) {

		try {
			getEmpresaDelegate().borrar(id, Empresa.class);
			return empresas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("borraDatoLaboral.gin")
	public ModelAndView borraDatoLaboral(int id) {

		try {
			getEmpresaDelegate().borrar(id, Datoslaborale.class);
			return datosLaborales();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("borraHijo.gin")
	public ModelAndView borraHijo(int id) {

		try {
			getEmpresaDelegate().borrar(id, Hijo.class);
			return hijos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("borraCargo.gin")
	public ModelAndView borraCargo(int id) {

		try {
			getEmpresaDelegate().borrar(id, Cargo.class);
			return cargos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}
	@RequestMapping("borraEmpleado.gin")
	public ModelAndView borraEmpleado(int id) {

		try {
			getEmpresaDelegate().borrar(id, Empleado.class);
			return empleados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	public EmpresaDelegate getEmpresaDelegate() {
		return empresaDelegate;
	}

	public void setEmpresaDelegate(EmpresaDelegate empresaDelegate) {
		this.empresaDelegate = empresaDelegate;
	}

}
