package com.meesho.zookeeper.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class BeanUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> beanClass) {

        return context.getBean(beanClass);
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static void resetBean(String beanName, Object newBean) {

        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
        BeanDefinition annotationProcessor = BeanDefinitionBuilder.genericBeanDefinition(newBean.getClass()).getBeanDefinition();
        ((BeanDefinitionRegistry)registry).removeBeanDefinition(beanName);
        ((BeanDefinitionRegistry) context.getAutowireCapableBeanFactory()).registerBeanDefinition(beanName,annotationProcessor);
    }

    public static String getBeanIdForAutowiredBeans(Class clazz) {
        if (clazz == null)
            return null;
        else {
            char c[] = clazz.getSimpleName().toCharArray();
            c[0] = Character.toLowerCase(c[0]);
            return new String(c);
        }
    }

}

