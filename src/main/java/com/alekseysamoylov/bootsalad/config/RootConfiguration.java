package com.alekseysamoylov.bootsalad.config;

import com.alekseysamoylov.bootsalad.postprocessor.CustomTransactionBeanPostProcessor;
import com.alekseysamoylov.bootsalad.postprocessor.InjectRandomBeanPostProcessor;
import com.alekseysamoylov.bootsalad.service.Quoter;
import com.alekseysamoylov.bootsalad.service.TerminatorQuoter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:/quoter.properties")
public class RootConfiguration {

    @Value("${terminator.message}")
    private String message;

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new InjectRandomBeanPostProcessor();
    }

    @Bean
    public BeanPostProcessor customTransactionBeanPostProcessor() {
        return new CustomTransactionBeanPostProcessor();
    }

    @Bean
    public Quoter quoter() {
        TerminatorQuoter quoter = new TerminatorQuoter();
        quoter.setQuote(message);
        return quoter;
    }

}
