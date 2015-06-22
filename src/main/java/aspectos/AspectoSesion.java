package aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import empresa.daos.EmpresaDao;

@Aspect
public class AspectoSesion {

	@Pointcut("execution(* *.*.dameDatos(..))")
	public void ejecutar() {

	}

	@Around("ejecutar()")
	public void tomaSesion(ProceedingJoinPoint joinPoint) {
		
		try {
			EmpresaDao empresaDao=(EmpresaDao) joinPoint.getTarget();
			
			if(empresaDao.getSesion()==null || !empresaDao.getSesion().isOpen())
				empresaDao.setSesion(empresaDao.getFactoria().openSession());
			else
				empresaDao.setSesion(empresaDao.getFactoria().getCurrentSession());
			
			
			joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
