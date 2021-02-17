package com.ambity.springbootbase.compontscantest;

import com.ambity.springbootbase.importtest.ImportSelectTestBean;
import org.springframework.context.annotation.ImportSelector;

import org.springframework.core.type.AnnotationMetadata;

public class ImportSelectTest implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 可以做定制化逻辑，常和自定义注解合并使用
        String classname = ImportSelectTestBean.class.getName();
        String[] classStrings = {classname};
        return classStrings;
    }
}
