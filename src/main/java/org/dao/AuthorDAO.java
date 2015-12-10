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
public class AuthorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Author> getAll(){

        return sessionFactory.getCurrentSession()
                .createQuery("select a from Author a")
                .list();
    }

    @Transactional(readOnly = true)
    public Author getById(int id){
        return (Author) sessionFactory.getCurrentSession().get(Author.class, id);
    }

    @Transactional
    public void create(Author author){
        sessionFactory.getCurrentSession().persist(author);
    }

    @Transactional
    public void update(Author author){
        sessionFactory.getCurrentSession().update(author);
    }

    @Transactional
    public void delete(int id){
        Author author = (Author) sessionFactory.getCurrentSession().get(Author.class, id);
        if (author != null)
            sessionFactory.getCurrentSession().delete(author);
    }

}
