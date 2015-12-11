package org.dao;

import org.config.Conf;
import org.entities.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Stepan Danilov on 10.12.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conf.class)
@Transactional

public class AuthorDAOTest {

    @Autowired
    AuthorDAO authorDAO;

    @Test
    public void testGetAll() throws Exception {
        Author author = new Author();
        author.setName("test author");

        authorDAO.create(author);
        assertTrue(author.getId() == 0);



//        authorDAO.create();
//        authorDAO.getAll();
//        assertTrue(true);
    }
}