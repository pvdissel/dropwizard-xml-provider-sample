package nl.ikoodi.sample.dropwizard

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty

class HelloWorldConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    String template

    @NotEmpty
    @JsonProperty
    String defaultName = 'Stranger'
}
