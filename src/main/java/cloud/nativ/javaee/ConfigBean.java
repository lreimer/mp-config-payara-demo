package cloud.nativ.javaee;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Wrapper around the MicroProfile Config interface.
 */
@ApplicationScoped
public class ConfigBean {

    @Inject
    private Config config;

    public Iterable<ConfigSource> getConfigSources() {
        return config.getConfigSources();
    }

    public <T> T getValue(String propertyName, Class<T> clazz) {
        return config.getValue(propertyName, clazz);
    }
}
