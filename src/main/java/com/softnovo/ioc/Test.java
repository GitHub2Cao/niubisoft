package com.softnovo.ioc;

import com.softnovo.ioc.scope.ScopeBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cgm
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        //Person person = ctx.getBean(BussinessPerson.class);
        //person.service();

        ScopeBean scopeBeanl = ctx.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
        System.out.println(scopeBeanl == scopeBean2);
    }
}
