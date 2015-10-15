package org.demo.thm.config;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableMetrics
public class MetricsConfig  extends MetricsConfigurerAdapter {

    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        registerReporter(ConsoleReporter
                .forRegistry(metricRegistry)
                .build())
                .start(1, TimeUnit.SECONDS);
    }

    @Bean
    public ServletRegistrationBean codehaleServlet() {
        return new ServletRegistrationBean(new MetricsServlet(), "/metrics");
    }

}
