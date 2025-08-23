package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.entity.ReportCard;
import com.example.entity.Student;
import com.example.service.StudentService;

//App.java --> Controller  --> Service --- > Repository -- JPA --> Hibernate ---> jdbc --- >Database
public class App 
{
    public static void main( String[] args )
    {
    	

    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
         
    	    
         StudentService service =  ctx.getBean(StudentService.class);
    	
         ReportCard rc = new ReportCard(490);
         Student student = new Student("jiya");
          student.setReportcard(rc);
          service.saveData(student);
    }
}
