package nl.ikoodi.sample.dropwizard

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import nl.ikoodi.sample.dropwizard.health.TemplateHealthCheck
import nl.ikoodi.sample.dropwizard.resource.HelloWorldResource

class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) {
        new HelloWorldApplication().run(args)
    }

    @Override
    String getName() {
        return 'hello-world'
    }

    @Override
    void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
    }

    @Override
    void run(HelloWorldConfiguration config, Environment env) throws Exception {
        def resource = new HelloWorldResource(
                config.template,
                config.defaultName
        )
        env.jersey().register(resource)
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(config.getTemplate())
        env.healthChecks().register('template', healthCheck)
    }
}
