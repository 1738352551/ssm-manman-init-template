package cn.chenmanman.ssm.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import({MybatisConfig.class, RedisConfig.class})
@ComponentScan(value = "cn.chenmanman.ssm", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = RestController.class)
})
public class SpringConfig {


    @Bean
    public DataSourceTransactionManager  dataSourceTransactionManager(DataSource druidDataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(druidDataSource);
        return dataSourceTransactionManager;
    }


}
