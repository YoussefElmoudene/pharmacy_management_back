package ma.gestion.pharmacie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowedOrigins(
                                "http://localhost:3000",
                                "https://elmoudene-pharmacy.netlify.app",
                                "https://elmoudene-pharmacy.netlify.app/**",
                                "https://647b67a5af2e9e1bc66f1b80--transcendent-pika-4e4d20.netlify.app/"
                        );
            }
        };
    }
}
