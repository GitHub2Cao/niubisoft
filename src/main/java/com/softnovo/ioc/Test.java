package com.softnovo.ioc;

import com.softnovo.ioc.scope.ScopeBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CompletableFuture;
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
        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
        System.out.println(scopeBeanl == scopeBean2);

        CompletableFuture<ScopeBean> task1 = CompletableFuture.supplyAsync(() -> {
            ScopeBean scopeBean = ctx.getBean(ScopeBean.class);
            return scopeBean;
        });

        CompletableFuture<ScopeBean> task2 = CompletableFuture.supplyAsync(() -> {
            ScopeBean scopeBean = ctx.getBean(ScopeBean.class);
            return scopeBean;
        });
        System.out.println(task1.get());
        System.out.println(task2.get());
        System.out.println(task1.get().equals(task2.get()));

    }
}
