package com.itheima.a23;

import com.itheima.a20.A20;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.core.GenericTypeResolver;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormatterPropertyEditorAdapter;
import org.springframework.format.support.FormattingConversionService;

import java.util.Date;

public class TestBeanWrapper {
    private static final Logger log = LoggerFactory.getLogger(TestBeanWrapper.class);
    public static void main(String[] args) {
        // 利用反射原理, 为 bean 的属性赋值 （本质上走的是set方法）
        MyBean target = new MyBean();
        BeanWrapperImpl wrapper = new BeanWrapperImpl(target);
        wrapper.setPropertyValue("a", "10");
        wrapper.setPropertyValue("b", "hello");
        wrapper.setPropertyValue("c", "1999/03/04");
        System.out.println(target);
    }

    static class MyBean {
        private int a;
        private String b;
        private Date c;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            log.info("setA({})",a);//BeanWrapperImpl本质上走的是set方法
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public Date getC() {
            return c;
        }

        public void setC(Date c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "MyBean{" +
                   "a=" + a +
                   ", b='" + b + '\'' +
                   ", c=" + c +
                   '}';
        }
    }
}
