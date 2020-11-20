package wk.sb_do1.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        //        添加shiro的内置过滤器：
        /*
            anon:   无需认证就可以访问；
            authc:  必须认证了才能访问；
            user:   必须拥有 记住我 功能才可以用；
            perms:  拥有某个角色权限才能访问；
         */
//        拦截n

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();


        filterChainDefinitionMap.put("/shiro", "anon");
        filterChainDefinitionMap.put("/getImg", "anon");

        filterChainDefinitionMap.put("/**", "anon");

        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        bean.setSuccessUrl("/query");
        bean.setLoginUrl("/login");
        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
