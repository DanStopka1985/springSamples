package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by RTLabs on 07.12.2015.
 */
@Configuration
@ComponentScan
public class Conf {
    @Bean
    Figure figure(){
        Circle c = new Circle();
        c.setR(10);
        return c;
    }
}
