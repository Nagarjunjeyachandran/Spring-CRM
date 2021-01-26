package com.ajueshchan.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ajueshchan.springdemo.controller.CustomerController;
import com.ajueshchan.springdemo.entity.Customer;

@Aspect
@Component
public class CRMLoggingASpect {
	
	//setup Logger
	private Logger crmlog=Logger.getLogger(getClass().getName());
	
	
	//setup Pointcut expression
	@Pointcut("execution(* com.ajueshchan.springdemo.controller.*.*(..))")
	private void forcontrollerPackage() {}
	
	@Pointcut("execution(* com.ajueshchan.springdemo.service.*.*(..))")
	private void forservicePackage() {}
	
	@Pointcut("execution(* com.ajueshchan.springdemo.dao.*.*(..))")
	private void fordaoPackage() {}
	
	@Pointcut("forcontrollerPackage() || forservicePackage() || fordaoPackage()")
	private void forAppFlow() {}
	
	//add @BEfore advice
	@Before("forAppFlow()")
	public void addBeforAdvice(JoinPoint jp)
	{
		//System.out.println("Aspect is calling");
		String method=jp.getSignature().toShortString();
		crmlog.info("==--> Before Calling method "+method);
		
		Object[] tempargs=jp.getArgs();
		for(Object args:tempargs)
			crmlog.info("==--> Argument "+args);
	
		
	}
	//add @After returning advice
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void addAfterAdvice(JoinPoint jp,Object result)
	{
		//System.out.println("Aspect is calling");
		String method=jp.getSignature().toShortString();
		crmlog.info("==--> Before Calling method "+method);
		
	    crmlog.info("==--> Result "+result);
		
	}

}
