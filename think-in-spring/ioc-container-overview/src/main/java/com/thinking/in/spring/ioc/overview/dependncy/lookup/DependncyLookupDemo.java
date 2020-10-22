package com.thinking.in.spring.ioc.overview.dependncy.lookup;


import com.thinking.in.spring.ioc.overview.annotation.Supper;
import com.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependncyLookupDemo {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependncy-lookup-context.xml");
        lookupInRealTime(beanFactory);
        lookuoInLazy(beanFactory);

        //通过类型查找
        lookupByType(beanFactory);

        lookupListByType(beanFactory);

        //通过注解查找
        lookupByAnnotation(beanFactory);
    }

    private static void lookupListByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型查找" + beansOfType);
        }
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Supper.class);
            System.out.println(users);

        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User bean = beanFactory.getBean(User.class);
        System.out.println("通过类型查找" + bean);
    }

    private static void lookuoInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User u = objectFactory.getObject();
        System.out.println("延迟查找:" + u);
    }


    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User)beanFactory.getBean("user");
        System.out.println(user);
    }
}
