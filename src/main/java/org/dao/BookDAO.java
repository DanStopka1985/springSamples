package org.dao;

import org.entities.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List getAll(){

        return sessionFactory.getCurrentSession()
                .createQuery("select b from Book b")
                .list();
    }
    @Transactional(readOnly = true)
    public Book getById(int id){
        List<Book> books = sessionFactory.getCurrentSession()
                .createQuery("select b from Book b where b.id = :id")
                .setParameter("id", id).list();

        if (books.size() > 0) return books.get(0);
        else return null;
    }

}
