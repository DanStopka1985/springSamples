package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RTLabs on 07.12.2015.
 */
@Controller

public class Run {
    @Autowired
    Figure figure;

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public String a(){
        System.out.println(figure.getPerimeter());
        System.out.println(figure.getSpace());
        return "123";
    }

}