package com.spring.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author lipan
 * @date 2021-02-02
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
//        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
//        Stream.of(beanInfo.getPropertyDescriptors())
//                .forEach(propertyDescriptor -> {
//                    System.out.println(propertyDescriptor);
//                });


        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    // PropertyDescriptor 允许添加属性编辑器 - PropertyEditor
                    // GUI -> text(String)
                    // name -> String
                    // age -> Integer
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName(); // 为 "age" 字段/属性增加 PropertyEditor
                    if ("age".equals(propertyName)) {
                        // String -> Integer
                        // Integer.valueOf(xxx)
                        propertyDescriptor.setPropertyEditorClass(String2IntegerPropertyEditor.class);
//                        propertyDescriptor.createPropertyEditor()
                    }

                });
    }

    static class String2IntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }

}
