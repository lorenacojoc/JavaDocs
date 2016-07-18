package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;

/**
 * Created by Lorena on 7/15/2016.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {
    String name() default  "";
}
