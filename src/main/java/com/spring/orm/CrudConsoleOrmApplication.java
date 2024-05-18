package com.spring.orm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class CrudConsoleOrmApplication {
	public static void main(String ar[])
	{
	ApplicationContext context=new ClassPathXmlApplicationContext("ormconfig.xml");
	StudentDao stdao=context.getBean("studentDao",StudentDao.class);
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	boolean go=true;
		while(go)
			{
				System.out.println("Press 1. for Add Record in Databse");
				System.out.println("Press 2. for Display All Record in Databse");
				System.out.println("Press 3. for Display Single Record in Databse");
				System.out.println("Press 4. for Delete Record from Databse");
				System.out.println("Press 5. for Update Record in Databse");
				System.out.println("Press 6. for Exit");
				try
				{
					System.out.println("\nPlease Enter Your Choice between 1 to 6 \n");
					int choice=Integer.parseInt(br.readLine());
					System.out.println();					
					switch(choice)
					{
					case 1:
						// add a new student in database.
						
						// 1.teaking input from user
						System.out.println(" \n Enter student id \n");
						int sid=Integer.parseInt(br.readLine());
						System.out.println("\n Enter student name \n");
						String sname=br.readLine();
						System.out.println("\n Enter the student city \n");
						String scity=br.readLine();
						System.out.println();
						
						// 2. creating object of   student class and pass input value as argument. 
						Student st=new Student(sid,sname,scity);
						
						// 3. insert in database by using insert method and studentdao object .
						int r=stdao.insert(st);
						System.out.println(r+" "+"Student added");
						System.out.println("********************************");
						
						break;
					case 2:
						// show all student record from database.
						List <Student> allstudent=stdao.getallStudent();
						for(Student s : allstudent)
						{
							System.out.println("********************************");
							System.out.println("Id :"+ s.getStudentId());
							System.out.println("Name :"+ s.getStudentName());
							System.out.println("City :"+ s.getStudentCity());
							System.out.println("_____________________________________");
						}
						System.out.println("********************************");
						break;
					case 3:
						// show one record from database.
						// 1.teaking input from user
						System.out.println(" \n Enter student id \n");
						int stid=Integer.parseInt(br.readLine());
						Student st2=stdao.getStudent(stid);
						System.out.println("Id :"+ st2.getStudentId());
						System.out.println("Name :"+ st2.getStudentName());
						System.out.println("City :"+ st2.getStudentCity());
						System.out.println("********************************");
						break;
					case 4:
						//Delete a record from database.
						// 1.teaking input from user
						System.out.println(" \n Enter student id \n");
						int stdid=Integer.parseInt(br.readLine());
						stdao.deleteStudent(stdid);
						System.out.println("Student Deleted Successfully.....");
						System.out.println("********************************");
						break;
					case 5:
						// Update record in database.
						// 1.teaking input from user
						System.out.println(" \n Enter student id Which u want to update \n");
						int s1id=Integer.parseInt(br.readLine());
						System.out.println(" \n Enter the new name of student \n");
						String name=br.readLine();
						System.out.println(" \n Enter the city name of student \n");
						String city=br.readLine();
						Student stud1=new Student(s1id,name,city);
						stdao.updateStudent(stud1);
						System.out.println("Student detail update Successfully");
						break;
					case 6:
						// for exit.
						go=false;
						break;
						
					}
				}catch(Exception e)
				{
					System.out.println("Invalid Input try with another one \ns");
					System.out.println(e.getMessage());
				}
			}
	
		System.out.println("Thank You for using my Apllication");
		System.out.println("See you soon !!");
	}
}
