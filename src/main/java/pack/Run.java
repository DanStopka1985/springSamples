package pack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pack.Entities.Author;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RTLabs on 07.12.2015.
 */
@Controller
//@RequestMapping(value = "/", method = RequestMethod.GET)
public class Run {
    @Autowired
    Figure figure;

    @Autowired
    private SessionFactory sessionFactory;

//    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//    @ResponseBody
//    public String a(){
//        String s = "Perimeter: " + String.valueOf(figure.getPerimeter()) + "<br>" +
//                ("Space: " + figure.getSpace());
//
//        return s;
//    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)

    @RequestMapping(value = "index", method = RequestMethod.GET)
    @Transactional(readOnly=true)
    public String b(Model model){

        //@SuppressWarnings("unchecked")

        //System.out.println(sessionFactory.getStatistics().getCollectionRoleNames());

        Session s = sessionFactory.getCurrentSession();

//        List authors = sessionFactory.getCurrentSession()
//                .createQuery("from Author ")
//                .list();

        model.addAttribute("title", "100100");

        return "index";
    }

}
