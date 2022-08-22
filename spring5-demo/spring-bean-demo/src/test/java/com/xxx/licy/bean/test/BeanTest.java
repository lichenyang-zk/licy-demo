package com.xxx.licy.bean.test;

import com.xxx.licy.bean.MyBean;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 单元测试
 *
 * @author lichenyang
 * @version 1.0.0 2022/8/22 21:59
 */
@SuppressWarnings("deprecation")
public class BeanTest {

    @Test
    public void testMyBean(){
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyBean myBean = (MyBean) xmlBeanFactory.getBean("myBean");
        System.out.println("myBean.getTestStr() = " + myBean.getTestStr());
    }
}
