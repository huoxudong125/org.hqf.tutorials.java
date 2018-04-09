package org.hqf.tutorials.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestServiceTest {

    @Autowired
    ApplicationContext context;


    @Autowired
    private TestService testService;

    @Before
    public void init(){
        System.out.println("context = " + context);
    }

    @Test
    public void echo() {
        Apply apply = new Apply();
        apply.setEmpId(101);
        apply.setOrderId(9512548);
        apply.setPhone("18011217376");
        apply.setAppointmentTime(new Date());
        try {
            System.out.println(testService.echo(apply));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}