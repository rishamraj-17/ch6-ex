package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] arguments = proceedingJoinPoint.getArgs();

        logger.info("Method Name : "+methodName+" with parameters being "+ Arrays.toString(arguments) + "is getting executed");

        Object returnByMethod = proceedingJoinPoint.proceed();
        logger.info("Method executed and returned "+returnByMethod);
        return returnByMethod;
    }
}
