package com.softnovo.ioc;

import com.softnovo.ioc.scope.ScopeBean;
import com.softnovo.ioc.service.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;

/**
 * @author cgm
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        //Person person = ctx.getBean(BussinessPerson.class);
        //person.service();

        ScopeBean scopeBeanl = ctx.getBean(ScopeBean.class);
        ServiceImpl serviceImpl = ctx.getBean(ServiceImpl.class);
        System.out.println("「『「『「『" + ctx.getBean(ServiceImpl.class));
        System.out.println("「『「『「『" + ctx.getBean(ServiceImpl.class));

        System.out.println("ApplicationContext ==== " + scopeBeanl.getBeanFactory());
        System.out.println("BeanFactory ==== " + scopeBeanl.getApplicationContext());

//        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
//        System.out.println(scopeBeanl == scopeBean2);
//        System.out.println(ctx.getBean(AutowiredAnnotationBeanPostProcessor.class));
//
//        System.out.println("niubiperson ------- " + ctx.getBean("niubiperson"));

//        CompletableFuture<ScopeBean> task1 = CompletableFuture.supplyAsync(() -> {
//            ScopeBean scopeBean = ctx.getBean(ScopeBean.class);
//            return scopeBean;
//        });
//
//        CompletableFuture<ScopeBean> task2 = CompletableFuture.supplyAsync(() -> {
//            ScopeBean scopeBean = ctx.getBean(ScopeBean.class);
//            return scopeBean;
//        });
//        System.out.println(task1.get());
//        System.out.println(task2.get());
//        System.out.println(task1.get().equals(task2.get()));

    }
}
