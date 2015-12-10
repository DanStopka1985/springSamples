package org.ctrl;
import org.dao.BookDAO;
import org.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.entities.Book;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * Created by Stepan Danilov on 07.12.2015.
 */

@RestController
@EnableWebMvc

public class RestCtrl {
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

    @RequestMapping(value = "book/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable int id){
        bookDAO.delete(id);
    }

    @RequestMapping(value = "book", method = RequestMethod.POST)
    public void updateBook(@RequestBody Book book){
        bookDAO.update(book);
    }

    @RequestMapping(value = "book", method = RequestMethod.PUT)
    public void insertBook(@RequestBody Book book){
        bookDAO.create(book);
    }



    @RequestMapping(value = "x", method = RequestMethod.GET)
    public void temp() {/*
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.add("b");
        return strings;*/
        Book book = new Book();
        book.setName("book1");
        book.setPrice(2);
        Author author = new Author();
        author.setName("author1");
        book.setAuthor(author);
        bookDAO.create(book);

        book.setName("book2");
        bookDAO.update(book);

        bookDAO.delete(100);

    }

}
