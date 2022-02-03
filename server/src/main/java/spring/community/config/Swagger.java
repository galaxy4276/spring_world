package spring.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.OAS_30)
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo());
  }

  public ApiInfo getApiInfo() {
    String apiName = "spring_world_api";
    return new ApiInfoBuilder()
            .title(apiName)
            .description("스프링으로 구현하는 유지보수성, 안정성 높은 웹 커뮤니티 서비스")
            .build();
  }
}
