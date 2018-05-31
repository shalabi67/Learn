package com.learn.annotations;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationManagement {
    public static List<Class<?>> getAnnotationClasses(
            String packageName,
            Class<? extends Annotation> annotationClass) {
        Reflections ref = new Reflections(packageName);
        List<Class<?>> annotationClassesList = new ArrayList<>();
        for (Class<?> cl : ref.getTypesAnnotatedWith(annotationClass)) {
            Annotation countMeIn = cl.getAnnotation(annotationClass);
            if(countMeIn == null)
                continue;
            annotationClassesList.add(cl);
        }

        return annotationClassesList;
    }

    public static List<Method> getAnnotatinMethodsForClass(
            Class<?> classType,
            Class<? extends Annotation> annotationClass) {
        List<Method> annotationMethodList = new ArrayList<>();

        for(Method method : classType.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotationClass))
            {
                annotationMethodList.add(method);
            }
        }
        return annotationMethodList;
    }

    public static List<Field> getAnnotationPropertiesForClass(
            Class<?> classType,
            Class<? extends Annotation> annotationClass) {
        List<Field> annotationPropertyList = new ArrayList<>();

        for(Field field : classType.getDeclaredFields()) {
            if (field.isAnnotationPresent(annotationClass))
            {
                annotationPropertyList.add(field);
            }
        }
        return annotationPropertyList;
    }
}
