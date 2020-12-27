package org.sekka.api.event;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Himmelt
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Listener {
    EventPriority priority() default EventPriority.DEFAULT;

    /**
     * @return 是否忽略已被取消的事件，默认忽略，即不会触发本监听器.
     */
    boolean ignoreCancelled() default true;
}
