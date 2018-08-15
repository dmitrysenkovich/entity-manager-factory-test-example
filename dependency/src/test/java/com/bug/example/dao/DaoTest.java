package com.bug.example.dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.io.Serializable;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class DaoTest extends AbstractDaoTest {

    @Resource
    private Dao repository;

    @Before
    public void injectMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        Ololo ololo = new Ololo();

        Serializable id = repository.save(ololo);

        flushAndClearSession();
        Ololo loaded = sessionFactory.getCurrentSession().load(Ololo.class, id);

        assertThat("Ololo Expected", loaded, is(notNullValue()));
    }

}
