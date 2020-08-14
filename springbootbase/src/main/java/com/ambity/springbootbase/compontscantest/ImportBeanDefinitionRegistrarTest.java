package com.ambity.springbootbase.compontscantest;

import com.ambity.springbootbase.annotation.MyAnnotation;
import com.ambity.springbootbase.enable.MyEnable;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Map;
import java.util.Set;

public class ImportBeanDefinitionRegistrarTest implements ImportBeanDefinitionRegistrar , ResourceLoaderAware, EnvironmentAware {
    private ResourceLoader resourceLoader;

    ImportBeanDefinitionRegistrarTest(){

    }
    private Environment environment;
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
    // 获取BasePackage
     AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyEnable.class.getName(),true));
     String basePackage = annotationAttributes.getString("basePackages");
     // 添加注解扫描，使spring 能够扫描到注解
     ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
     scanner.setResourceLoader(this.resourceLoader);
     scanner.addIncludeFilter(new AnnotationTypeFilter(MyAnnotation.class));
        Set<BeanDefinition> candidateComponents = scanner
                .findCandidateComponents(basePackage);
        // 遍历拿到的bean
        for (BeanDefinition candidateComponent : candidateComponents) {
            if (candidateComponent instanceof AnnotatedBeanDefinition) {
                AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                Map<String, Object> attributes = annotationMetadata
                        .getAnnotationAttributes(
                                MyAnnotation.class.getCanonicalName());
                // 如果是MyAnnotation 的注解
                if (attributes!=null){
                    String className =annotationMetadata.getClassName();
                    try {
                        // 注入对应的bean
                        registry.registerBeanDefinition((String)attributes.get("name"),new RootBeanDefinition(Class.forName(className)));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
