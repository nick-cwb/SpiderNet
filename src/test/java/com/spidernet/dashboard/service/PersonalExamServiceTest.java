package com.spidernet.dashboard.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spidernet.dashboard.entity.PersonalExam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
@Transactional
public class PersonalExamServiceTest
{
    @Resource
    PersonalExamService personalExamService;

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    @Rollback(true)
    public void testAddPersonalExam()
    {
        List<PersonalExam> personalExamList = new ArrayList<PersonalExam>();
        PersonalExam personalExam1 = new PersonalExam();
        new PersonalExam();

        personalExam1.setEmployeeId("14f014a655e04b88b10fc5a502fc4986");
        personalExam1.setExamId("5721e3b030a73b8e9441724e9f2bc095");
        personalExam1.setPersonalExam("DOJO");
        personalExam1.setRegisterTime("2017-03-30 14:29:00");
        personalExam1.setStatus("1");
        personalExam1.setUpdateTime("2017-03-31 14:29:00");

        personalExamList.add(personalExam1);

        assertTrue(personalExamService.addPersonalExam(personalExamList));
    }

    @Test
    public void testCheckPersonalExamExists()
    {
        PersonalExam personalExam  = new PersonalExam();
        personalExam.setEmployeeId("b831465b1b594c44927a8c5845e8daad");
        personalExam.setExamId("5721b3b030a71b6d9441724e9f2bc074");
        assertTrue(personalExamService.checkPersonalExamExists(personalExam));
    }

}
