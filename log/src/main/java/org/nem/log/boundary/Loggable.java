package org.nem.log.boundary;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author nemanja.marjanovic
 */
@InterceptorBinding
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface Loggable
{ 
}
