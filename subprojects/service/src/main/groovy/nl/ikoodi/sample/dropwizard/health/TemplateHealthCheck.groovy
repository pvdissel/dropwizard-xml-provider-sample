package nl.ikoodi.sample.dropwizard.health

import com.codahale.metrics.health.HealthCheck

import static com.codahale.metrics.health.HealthCheck.Result.healthy
import static com.codahale.metrics.health.HealthCheck.Result.unhealthy

class TemplateHealthCheck extends HealthCheck {
    private final String template

    TemplateHealthCheck(String template) {
        this.template = template
    }

    @Override
    protected HealthCheck.Result check() throws Exception {
        final String saying = String.format(template, "TEST")
        if (!saying.contains("TEST")) {
            return unhealthy("template doesn't include a name")
        }
        return healthy()
    }
}