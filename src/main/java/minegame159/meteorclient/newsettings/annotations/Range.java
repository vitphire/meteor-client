package minegame159.meteorclient.newsettings.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {
    double[] min() default {};
    double[] max() default {};

    double[] sliderMin() default 0;
    double[] sliderMax() default 10;
}
