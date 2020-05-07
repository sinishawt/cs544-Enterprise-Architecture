package cs544.exercise13_2.bank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.*;

@Aspect
public class TraceAdvice {

	private static Logger log;

    @After("execution(public void cs544.exercise13_2.bank.dao.AccountDAO.*(..))")
    public void DaoLog(JoinPoint joinPoint){
    	System.out.println(joinPoint.getSignature().getName());
        //log.info(new Date()+"\n method=" +joinPoint.getSignature().getName());
    }
//    @After("execution(public void cs544.exercise13_2.bank.jms.JMSSender.sendJMSMessage(String)) && args(msg)")
//    public void JmsLog(JoinPoint joinPoint,String msg){
//        logger.log(Level.INFO, "Message ="+msg);
//    }

    @Around("execution(public void cs544.exercise13_2.bank.service.*.*(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Time to execute save = " + totaltime + " ms ");

        return retVal;
    }


    public void setLogger(Logger logger) {
        this.log=logger;
    }
}