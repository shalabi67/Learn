package com.learn.annotations.count_me_in;

import com.learn.annotations.AnnotationManagement;

import java.util.stream.Collectors;

public class CountMeInApplication {
    public static void main(String[] args) {
        AnnotationManagement.getAnnotationClasses("com.learn.annotations.count_me_in", CountMeIn.class)
                .stream()
                .map(classType -> classType.getName())
                .forEach(System.out::println);

        AnnotationManagement.getAnnotationClasses("com.learn.annotations.count_me_in", CountMeIn.class)
                .stream()
                .map(classType -> {
                    System.out.println( "*************** " + classType.getName() + " methods *******************");
                    return AnnotationManagement.getAnnotatinMethodsForClass(classType, CountMeIn.class);
                })
                .flatMap(methodList ->  {
                    return methodList.stream();
                })
                .map(method -> method.getName())
                .peek(System.out::println)
                .collect(Collectors.toList());

        AnnotationManagement.getAnnotationClasses("com.learn.annotations.count_me_in", CountMeIn.class)
                .stream()
                .map(classType -> {
                    System.out.println( "*************** " + classType.getName() + " properties *******************");
                    return AnnotationManagement.getAnnotationPropertiesForClass(classType, CountMeIn.class);
                })
                .flatMap(methodList ->  {
                    return methodList.stream();
                })
                .map(method -> method.getName())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
