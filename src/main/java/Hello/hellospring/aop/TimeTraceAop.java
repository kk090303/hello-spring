package Hello.hellospring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//Aop로 사용할 수 있게 하는 애노테이션
@Aspect
@Component //컴포넌트 스캔을 통해 스프링 빈에 등록
public class TimeTraceAop {

    //aop 적용 타겟팅 (package 하위에 모두 적용)
    @Around("execution(* Hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
       Long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
       try{
           return joinPoint.proceed();
       } finally{
           long finish= System.currentTimeMillis();
           long timeMs = finish - start;
           System.out.println("END: " + joinPoint.toString()+" " + timeMs + "ms");
       }
    }

}
