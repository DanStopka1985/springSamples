package org.ctrl;
import org.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.entities.Book;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.temp.Figure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stepan Danilov on 07.12.2015.
 */

@RestController
@EnableWebMvc
@SuppressWarnings(value = "unchecked")
public class RestCtrl {
    @Autowired
    Figure figure;

    @Autowired
    BookDAO bookDAO;

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> getBooks(){
        return bookDAO.getAll();
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable int id){
        return bookDAO.getById(id);
    }

    @RequestMapping(value = "x", method = RequestMethod.GET)
    public ArrayList<String> getX() {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.add("b");
        return strings;
    }

}
