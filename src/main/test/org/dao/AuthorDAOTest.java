package org.dao;

import org.config.Conf;
import org.entities.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Stepan Danilov on 10.12.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conf.class)
@Transactional
@Rollback(false)

public class AuthorDAOTest {

    @Autowired
    AuthorDAO authorDAO;

    @Autowired
    BookDAO bookDAO;

    @Test
    public void testGetAll() throws Exception {
        assertNotNull(authorDAO);

        List<Author> authorList = authorDAO.getAll();
        int authorsCnt = authorList.size();

        Author author = new Author();
        author.setName("test author");
        authorDAO.create(author);
        authorList = authorDAO.getAll();
        assertEquals(authorsCnt + 1, authorList.size());

        int testAuthorId = author.getId();
        authorDAO.delete(testAuthorId);
        authorList = authorDAO.getAll();
        assertEquals(authorsCnt, authorList.size());

    }
}