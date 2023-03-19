package cn.chenmanman.ssm.config;


import com.github.xiaoymin.knife4j.spring.model.MarkdownFiles;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class knife4jConfig {

    @Bean
    public MarkdownFiles markdownFiles() {
        MarkdownFiles markdownFiles = new MarkdownFiles();
        markdownFiles.setBasePath("classpath:markdown/*");
        return null;
    }

    @Bean
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .groupName("默认接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.chenmanman.ssm.controller"))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("陈慢慢的ssm通用admin模板")
                .description("陈慢慢的ssm通用admin模板接口文档")
                .termsOfServiceUrl("http://www.group.com/")
                .contact("1738352551@qq.com")
                .version("1.0")
                .build();
    }

}
