package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by RTLabs on 07.12.2015.
 */
@Controller

public class Run {
    @Autowired
    Figure figure;

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    @ResponseBody
    public String a(){
        String s = "Perimeter: " + String.valueOf(figure.getPerimeter()) + "<br>" +
                ("Space: " + figure.getSpace());

        return s;
    }

}
