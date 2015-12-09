package org.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly=true)
    public List getAll(){

        return sessionFactory.getCurrentSession()
                .createQuery("select a from Book a")
                .list();
    }

}
