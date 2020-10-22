package com.thinking.in.spring.ioc.overview.dependncy.injection;


import com.thinking.in.spring.ioc.overview.annotation.Supper;
import com.thinking.in.spring.ioc.overview.domain.User;
import com.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependncyInjectionDemo {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependncy-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository.getBeanFactory());
        System.out.println(beanFactory);

        System.out.println(userRepository.getObjectFactory().getObject());
    }


}
