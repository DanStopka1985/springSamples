package org.dao;

import org.entities.Author;
import org.entities.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@SuppressWarnings(value = "unchecked")
public class BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Book> getAll(){

        return sessionFactory.getCurrentSession()
                .createQuery("select b from Book b")
                .list();
    }

    @Transactional(readOnly = true)
    public Book getById(int id){
        return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Transactional
    public void create(Book book){
        Author author = book.getAuthor();
        author = (Author) sessionFactory.getCurrentSession().get(Author.class, author.getId());
        book.setAuthor(author);
        sessionFactory.getCurrentSession().persist(book);
    }

    @Transactional
    public void update(Book book){
        sessionFactory.getCurrentSession().update(book);
    }

    @Transactional
    public void delete(int id){
        Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, id);
        if (book != null)
            sessionFactory.getCurrentSession().delete(book);
    }

}
