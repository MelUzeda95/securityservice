package securityservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableEurekaServer
@Configuration
public class OpenApiConfig {

    @Value("${application.title}")
    private String title;

    @Value("${application.description}")
    private String description;

    @Value("${application.version}")
    private String version;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title(this.title)
                .description(this.description)
                .version(this.version);
    }
}

