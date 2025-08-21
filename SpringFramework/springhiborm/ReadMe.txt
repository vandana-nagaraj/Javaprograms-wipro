1. JDBC purely with Hibernate  == SessionFactory

<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE hibernate-configuration PUBLIC  
   "-//Hibernate/Hibernate Configuration DTD 5.3//EN"  
   "http://hibernate.org/dtd/hibernate-configuration-3.0.dtd">  

<hibernate-configuration>  
   <session-factory>  
      <!--  JDBC properties -->
 
 	   <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property> 
      <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/wiprotraining</property>  
      <property name="hibernate.connection.username">root</property>  
      <property name="hibernate.connection.password">root</property>  
     
       <!-- Dialect & schema -->
      <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>  
      <property name="hibernate.hbm2ddl.auto">update</property>  
      <property name ="hibernate.show_Sql">true</property>
      
      <!--  Annotation enitites -->
      
      <mapping class="com.company.HibernateORM.model.Student"/>  
   </session-factory>  
</hibernate-configuration>

2. Jdbc using Spring + Hibernate == LocalSessionFactory

<!--  1. Component Scanning -->
<context:component-scan base-package="com.example.springhiborm"></context:component-scan>
	
	<!-- 2. Data Source-->
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <!--  Dependency injection using setter  -->
		<property name="driverClassName"
			value="com.mysql.cj.jdbc.Driver" />
		<property name="url"
			value="jdbc:mysql://localhost:3306/wiprotraining" />
		<property name="username" value="root" />
		<property name="password" value="root"></property>

	</bean>


    <!-- 3. LocalSessionFactoryBean will be taking a reference of data source-->
    <!-- In LocalSessionFactoryBean inject three properties -a)DataSource b) Packages to Scan c) Hibernate Dialects 
	<bean id="sessionFactory"
		class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">

		<property name="dataSource" ref="dataSource"/>
		<property name="packagesToScan" value ="com.example.springhiborm.entity"></property>
		<!-- hibernate properties -->
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</prop>
				<prop key="hibernate.show_sql">true</prop>
				<prop key="hibernate.hbm2ddl.auto">update</prop>
			</props>
		</property>
	</bean>


   <!-- 4. HibernateTransactionManager  -->
	<bean id="txManager"
		class="org.springframework.orm.hibernate5.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory"></property>
	</bean>

 <!--  To Enable @Transactional -->
 <tx:annotation-driven transaction-manager="txManager"/>


</beans>


3. 


4. Spring MVC + JdbcTemplate( Define in a Dispatcher-Servlet.xml)


<!-- Enable annotation config -->
  <context:component-scan base-package="com.wipro" />
  <mvc:annotation-driven />

  <!-- JSP resolver -->
  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/views/" />
    <property name="suffix" value=".jsp" />
  </bean>

  <!-- DB Config -->
  <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
    <property name="url" value="jdbc:mysql://localhost:3306/wipro_training" />
    <property name="username" value="root" />
    <property name="password" value="root" />
  </bean>

  <!-- JdbcTemplate -->
  <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <property name="dataSource" ref="dataSource" />
  </bean>
