package com.example.HiberORM;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HiberORM.model.Employee;
import com.example.HiberORM.util.HibernateUtil;


/**
 * Hello world!
 *
 */
public class App 
{
//	@SuppressWarnings("removal")
	public static void main( String[] args )
    {
		// to obtain/get the session from sessionfactory (It can be multiple session based on multiple services or work)
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// To create a  transaction ( Transient + Persistent) -- Transient when you do not to reflect and save in backend  but persistent to save into a backend
	   Transaction tx = session.beginTransaction();
	   
	  Employee emp = new Employee("Raman" , "Raman@gmail.com"); // transient
	   
	   session.persist(emp);//Make a transient instance persistent 
	   
	   tx.commit(); //Commit the current resource transaction, writing any unflushed changes to the database.
	   
	   
	   // Read the data
	
	 Employee eData  =   session.get(Employee.class, emp.getId());
	 System.out.println("Retreived the Data : " + eData);
	 
//	 // Update the data
//	 
//	tx =  session.beginTransaction();
//	eData.setEmail("nitin.kumar@outlook.com");
//	 System.out.println("Retreived the Data : " + eData);
//	tx.commit();
	
	// HQL Query to write to fetch using email // Parameterized query
//	Query<Employee> q1 =session.createQuery("from Employee e where e.email = :e" , Employee.class);
//	q1.setParameter("e", "nitin.kumar@outlook.com");
//	System.out.println("Result is :" + q1.uniqueResult());
	
	// Native SQL
	
	//List<Employee> empList =  (List<Employee>) session.createNativeQuery("Select * from Employee" , Employee.class);
	
	  
//	System.out.println("The size is : " + empList.size());
//	
//	for(Employee e : empList)
//	 System.out.println("Result is :" + e);
	
    tx = session.beginTransaction();
    
    List<Employee> empList = session.createNativeQuery("SELECT * FROM employee", Employee.class)
            .getResultList(); //Execute the query and return the query results as a List. 
    System.out.println(empList);
    
//    String sql = "SELECT * FROM EMPLOYEE";
//    NativeQuery query = session.createNativeQuery(sql);
//    
//    List data = query.list();
//
//    for(Object object : data) {
//       Map row = (Map)object;
//    
//    	} 
//      // System.out.print(" Name: " + row.get("name")); 
//     //  System.out.println(", Email: " + row.get("email")); 
//    }
    tx.commit();
    
    
    //Delete or detach the session
    
    session.evict(eData); // eData will be  detached from the session
    
    System.out.println(session.contains(eData));
   Employee ed =  session.get(Employee.class, emp.getId());
   
   
    tx = session.beginTransaction();
    
    Employee emp1 = new Employee("Rohan" , "Rohann@gmail.com"); // transient
	   
	   session.persist(emp1);//Make a transient instance persistent 
	   session.remove(emp1); // emp1 object is removed from session
	   tx.commit();
    session.get(Employee.class, emp1.getId());
    session.close(); 
    HibernateUtil.close(); // closing the session factory
	   
	   
    }
}
