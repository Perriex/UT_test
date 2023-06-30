package morriex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import morriex.context.ContextManager;
import morriex.context.MovieRepository;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class IEMDB {

	public static void main(String[] args) {
		SpringApplication.run(IEMDB.class, args);
	}

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("morriex.controllers"))
                .build();
    }

    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
                    .allowedOrigins("http://iemdb.com:31000", "http://87.247.187.217:31000", "http://87.247.187.221:31000", "http://87.247.188.249:31000", "http://localhost:3000")
                    .allowedMethods("GET", "POST", "DELETE", "PUT");
			}
		};
	}

	@Bean
	public ContextManager InitConextManager(MovieRepository movieRepository){
		ContextManager.movieRepository = movieRepository;
		return ContextManager.getInstance();
	}
}
