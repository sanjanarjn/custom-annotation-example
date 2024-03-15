package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public class RecordAnnotations {
    public static void main(String[] args) {
        Class<?> cl = Test.class;
        for(var r: cl.getRecordComponents()) {
            System.out.println("record component "
                + Arrays.toString(r.getAnnotations()) + " " + r);
            System.out.println("\tof type " + r.getAnnotatedType());
            System.out.println("\taccessed by " +
                Arrays.toString(r.getAccessor().getAnnotations())+" "+r.getAccessor());
            System.out.println("\twith return type "
                + r.getAccessor().getAnnotatedReturnType());
        }
        System.out.println();
        for(var r: cl.getDeclaredFields()) {
            System.out.println("field " + Arrays.toString(r.getAnnotations())+" "+r);
            System.out.println("\tof type " + r.getAnnotatedType());
        }
        System.out.println();

        for(var c: cl.getDeclaredConstructors()) {
            System.out.println("constructor " + c);
            for(var r: c.getParameters()) {
                System.out.println("\tparameter "
                    + Arrays.toString(r.getAnnotations()) + " " + r);
                System.out.println("\t\tof type " + r.getAnnotatedType());
            }
        }
        //System.out.println();
        //for(var r: cl.getRecordComponents()) System.out.println(r);
    }
}

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.RECORD_COMPONENT)
@interface WithRecord {}

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD)
@interface WithField {}

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.PARAMETER)
@interface WithParameter {}

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE_USE)
@interface WithTypeUse {}

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
@interface WithMethod {}

record Test(@WithRecord @WithField @WithParameter @WithTypeUse @WithMethod
            int component) {
}