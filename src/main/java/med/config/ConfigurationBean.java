package med.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

@ApplicationScoped
@FacesConfig(
// Activates CDI build-in beans
        version = JSF_2_3
)
public class ConfigurationBean {

}