package tecnocom.curso.empresa;

import static org.junit.Assert.*;

import org.junit.Test;

import datos.Empresa;

public class AltaEmpresa {

	@Test
	public void test() {
		HomeController homeController= new HomeController();
		Empresa empresa= new Empresa();
		try {
			homeController.getEmpresaDelegate().grabaObjeto(empresa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void leerEmpesa()
	{
		HomeController homeController= new HomeController();
		
		try {
			assertNotNull(homeController.getEmpresaDelegate().dameDatos(Empresa.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
