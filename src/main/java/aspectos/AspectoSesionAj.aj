package aspectos;

import org.aspectj.lang.ProceedingJoinPoint;

import empresa.daos.EmpresaDao;

public aspect AspectoSesionAj {
	
	
	 Object around() : execution(@ManejadorDeSesiones * *.*.*(..)) {
		
		Object salida=null;
		EmpresaDao empresaDao=(EmpresaDao)thisJoinPoint.getTarget();
		if(empresaDao.getSesion()==null || !empresaDao.getSesion().isOpen())
			empresaDao.setSesion(empresaDao.getFactoria().openSession());
		else
			empresaDao.setSesion(empresaDao.getFactoria().getCurrentSession());		
		
		
		return salida;
	}
	

}
