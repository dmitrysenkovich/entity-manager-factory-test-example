package com.bug.example.dao;

import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceTestConfig.class)
@TestPropertySource(properties = {
        "spring.datasource.platform=hsqldb",
        "spring.jpa.properties.hibernate.current_session_context_class=org.springframework.orm.hibernate5.SpringSessionContext"})
@AutoConfigurationPackage
public abstract class AbstractDaoTest {

    @Resource
    protected SessionFactory sessionFactory;

    public void flushAndClearSession() {
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

}
