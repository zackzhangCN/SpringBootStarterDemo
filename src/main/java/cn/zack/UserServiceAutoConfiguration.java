package cn.zack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConditionalOnClass  当类路径classpath下有指定的类的情况下进行自动配置
 * ConditionalOnProperty  当配置文件中example.service.enabled=true时进行自动配置，如果没有设置此值就默认使用matchIfMissing对应的值
 * ConditionalOnBean  当容器(Spring Context)中有指定的Bean的条件下
 * ConditionalOnMissingBean  当容器(Spring Context)中没有指定Bean的情况下进行自动配置
 */
@Configuration
@EnableConfigurationProperties(UserProperties.class)
@ConditionalOnClass(UserService.class)
@ConditionalOnProperty(prefix = "spring.user", value = "enabled", matchIfMissing = true)
public class UserServiceAutoConfiguration {
    @Autowired
    private UserProperties userProperties;

    @Bean
    @ConditionalOnMissingBean(UserService.class)
    public UserService userService(){
        UserService userService = new UserService(userProperties);
        return userService;
    }
}
