package aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import model.Comment;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // String methodName = joinPoint.getSignature().getName();
        // Object[] args = joinPoint.getArgs();

        // logger.info("Method with name " + methodName + " called with parameters being
        // " + Arrays.asList(args));
        // Object returnedmethod = joinPoint.proceed();
        // logger.info("Method executed and returned " + returnedmethod);

        // return returnedmethod;

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method with name : " + methodName + " called with parameters being " + Arrays.asList(args));

        Comment comment = new Comment();
        comment.setText("Some other new comment");
        comment.setauthor("Ojha");
        Object[] newArgs = { comment };
        Object returnedMethod = joinPoint.proceed(newArgs); // cnanging parameters of method

        logger.info("Method executed and returned " + returnedMethod);

        return "FAILED";// return different value to caller
    }
}
