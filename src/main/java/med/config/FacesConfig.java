package med.config;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.enterprise.util.Nonbinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Qualifier
@Target(TYPE)
@Retention(RUNTIME)
public @interface FacesConfig {

    public static enum Version {

        /**
         * <p class="changed_added_2_3">This value indicates CDI should be used
         * for EL resolution as well as enabling JSF CDI injection, as specified
         * in Section 5.6.3 "CDI for EL Resolution" and Section 5.9 "CDI Integration".</p>
         */
        JSF_2_3

    }

    /**
     * <p class="changed_added_2_3">The value of this attribute indicates that
     * features corresponding to this version must be enabled for this application.</p>
     * @return the spec version for which the features must be enabled.
     */
    @Nonbinding Version version() default Version.JSF_2_3;

}
