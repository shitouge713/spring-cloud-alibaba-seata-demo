package icu.funkye.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seata.spring.annotation.AspectTransactionalInterceptor;

@Configuration
public class AopConfig {

    @Bean
    public AspectTransactionalInterceptor aspectTransactionalInterceptor () {
        return new AspectTransactionalInterceptor();
    }

    @Bean
    public Advisor txAdviceAdvisor(AspectTransactionalInterceptor aspectTransactionalInterceptor ) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* icu.funkye.controller..test*(..))");
        return new DefaultPointcutAdvisor(pointcut, aspectTransactionalInterceptor);
    }

}
