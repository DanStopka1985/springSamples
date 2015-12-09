package org.pack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.entities.Book;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.temp.Figure;

import java.util.List;

/**
 * Created by RTLabs on 07.12.2015.
 */
@Controller
@EnableWebMvc
@SuppressWarnings(value = "unchecked")
public class Run {
    @Autowired
    Figure figure;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    BookDAO bookDAO;

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
    public String b(Model model){
        List<Book> books = bookDAO.getAll();
        for (Book book : books){
            System.out.println(book.getName());
        }

        model.addAttribute("title", "100100");

        return "index";
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getBooks(){
        return bookDAO.getAll();
    }

}
