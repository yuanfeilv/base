package com.ambity.springbootbase.condition;


import com.ambity.springbootbase.annotation.MyConditionAnno;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(MyConditionAnno.class.getName(),true));
        annotationAttributes.getString("value");
        return true;
    }
}
