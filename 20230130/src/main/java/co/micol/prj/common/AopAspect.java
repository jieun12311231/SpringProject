package co.micol.prj.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspect { // 이거 자체가 advice // aspect: 이 클래스에 얘를 동작 시켜라 저것을 동작 시켜라 
	@Pointcut("execution(* co.micol.prj..*Impl.*(..))")
	public void allpointcut(){}
	
	@Before("allpointcut()")
	public void beforeLog() {
		System.out.println("▶▶▶▶동작 시작◀◀◀◀");
	}
	@After("allpointcut()")
	public void afterLog() {
		System.out.println("▶▶▶▶동작 종료◀◀◀◀");
	}
}
