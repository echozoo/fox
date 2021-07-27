package com.echozoo.grpc.anotation;


import java.lang.annotation.*;

/**
 * @author dujf
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GrpcService {
}
