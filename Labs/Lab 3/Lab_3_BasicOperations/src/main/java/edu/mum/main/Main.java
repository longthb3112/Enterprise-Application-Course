package edu.mum.main;


import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
  public static void main(String[] args) {

      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context/applicationContext.xml");
      // Load user service
      UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
      List<User> users = userService.findAll();
      User user = new User();
      user.setFirstName("John");
      user.setLastName("Doe");
      user.setId(1L);
      user.setAdmin(true);
      user.setEmail("hbtran@mum.edu");
      userService.save(user);

      User user1 = userService.findByEmail("hbtran@mum.edu");

      System.out.println();
      System.out.println("*********  USER **********");
      System.out.println("Username = "+user1.getFirstName() +" " + user1.getLastName());
  }
  
 }