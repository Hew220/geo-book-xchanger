package hu.wup.geobookxchanger;

import hu.wup.geobookxchanger.filters.SpecificUrlPatternFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeoBookXChangerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoBookXChangerApplication.class, args);
    }

    @Bean
    FilterRegistrationBean<SpecificUrlPatternFilter> specificUrlPatternFilterFilterRegistrationBean() {
        final FilterRegistrationBean<SpecificUrlPatternFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new SpecificUrlPatternFilter());
        filterRegistrationBean.addUrlPatterns("/all");

        return filterRegistrationBean;
    }
}
