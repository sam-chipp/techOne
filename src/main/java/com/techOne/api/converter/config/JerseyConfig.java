package com.techOne.api.converter.config;

import com.techOne.api.converter.controller.ConverterController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Jersey Config for registering the API endpoint.
 */
@Configuration
public class JerseyConfig extends ResourceConfig
{
    /**
     * Register the required controller and cors filter.
     */
    public JerseyConfig()
    {
        register(ConverterController.class);
        register(CorsFilter.class);
    }
}
