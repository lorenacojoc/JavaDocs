package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;

/**
 * Created by Lorena on 7/18/2016.
 */

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectService {
}
