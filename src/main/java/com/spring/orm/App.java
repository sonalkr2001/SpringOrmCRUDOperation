package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("ormconfig.xml");
    	StudentDao stdao=context.getBean("studentDao",StudentDao.class);
    	Student st=new Student(102,"krishna kumar","Delhi");
    	int r=stdao.insert(st);
        System.out.println( r );
    }
}
