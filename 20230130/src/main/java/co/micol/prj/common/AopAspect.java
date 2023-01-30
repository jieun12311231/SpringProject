package co.micol.prj.common;

import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component  //bean에 태우기 위해서 => IoC로 올라감
@Aspect  //나는 advice에 들어갈 aspect입니다요
public class AopAspect { // 이거 자체가 advice // aspect: 이 클래스에 얘를 동작 시켜라 저것을 동작 시켜라 
	@Pointcut("execution(* co.micol.prj..*Impl.*(..))")
	public void allpointcut(){  //allpointcut는 호출명 allpointcut이라는 이름으로 불러서 사용하겠다
	}
	
	//위빙
//	@Before("execution(* co.micol.prj..*Impl.*Check(String)) && args(str)")
//	public void beforeLog(String str) {
//		String id = str;
//		if(!id.isEmpty()) {//id가 비어있지않다면
//			System.out.println(id+"님이 수행했다.");
//		}else {
//			System.out.println("방문객이 수행했다.");
//		}
//	}
	
	@Before("execution(* co.micol.prj..*Impl.*(..))")
	public void beforeLog() {
		System.out.println("▶▶▶▶시작 전 동작◀◀◀◀");
	}
//	@After("allpointcut()")
	public void afterLog() {
		System.out.println("▶▶▶▶메서드 실행 후 동작◀◀◀◀");
	}
//	@Around("execution(* co.micol.prj..*Impl.*(..))")
	public void aroundLog() {
		System.out.println("▶▶▶▶시작과 끝에 동작 ◀◀◀◀");
	}
}
