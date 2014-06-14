package nl.ikoodi.sample.dropwizard.resource

import com.codahale.metrics.annotation.Timed
import com.google.common.base.Optional
import nl.ikoodi.sample.dropwizard.api.HelloWorldService
import nl.ikoodi.sample.dropwizard.core.Saying

import java.util.concurrent.atomic.AtomicLong

// NOTE: Do NOT put ANY javax.ws annotations on this class
//       Put them all on the interface!
//       Failing to do so, will make this resource invalid/unusable
class HelloWorldResource implements HelloWorldService {
    private final String template
    private final String defaultName
    private final AtomicLong counter

    HelloWorldResource(String template, String defaultName) {
        this.template = template
        this.defaultName = defaultName
        this.counter = new AtomicLong()
    }

    @Timed
    @Override
    Saying sayHello(Optional<String> name) {
        final String value = name.or(defaultName)
        return new Saying(counter.incrementAndGet(), value)
    }
}