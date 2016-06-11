package com.amudhan.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDetailsApp 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
    	/*All beans will be destroyed when main method ends*/
    	((AbstractApplicationContext)context).registerShutdownHook();
    	EmployeeDetails employeeDetails = (EmployeeDetails)context.getBean("employeeDetails");
    	employeeDetails.greetEmployee();
    	//employeeDetails.setGreeting("This is a greeting from the application");
    	System.out.println("Employee name : "+employeeDetails.getEmployeeName());
    	System.out.println("Projects of the Employee: ");
    	for(String projectName:employeeDetails.getProjects()){
    		System.out.println(projectName+" ");
    	}
    	System.out.println("Greeting from the first request of the bean :"+employeeDetails.getGreeting());
    	System.out.println("Employee Greeting from the 1st request of the bean :"+employeeDetails.getEmployeeGreeting());
    	/*Creating the employeeDetails again to test its scope.
    	 * If prototype is the scope, greeting message from the configuration file will be displayed.
    	 * If singleton is the scope, greeting message set in the application will be displayed.
    	 * Default is singleton*/
    	EmployeeDetails employeeDetailsAgain = (EmployeeDetails)context.getBean("employeeDetails");
    	System.out.println("The greeting from the 2nd request will be different, if the scope of the bean is prototype");
    	System.out.println("Greeting from the second request of the bean :"+employeeDetailsAgain.getGreeting());
    	System.out.println("Employee Greeting from the 2nd request of the bean :"+employeeDetails.getEmployeeGreeting());
    	
    	/*The following bean was created using an alias of the bean employeeDetails*/
    	EmployeeDetails employeeDetailsByAlias=(EmployeeDetails)context.getBean("employeeDetailsManager");
    	System.out.println(employeeDetailsByAlias.getGreeting() +" from a bean created using alias");
    	
    	/*The following bean is being injected with another bean "employeeDetailsTeamLead" created by using static factory method*/
    	TeamLead teamLeadStaticFactory=(TeamLead)context.getBean("teamLead");
    	System.out.println(teamLeadStaticFactory);
    	
    	/*The following bean is being injected with another bean "teamLeadInstanceFactory"
    	 * created by using instance factory method createTeamLeadInstance of the class InstanceBeanFactory*/
    	TeamLead teamLeadInstanceFactory=(TeamLead)context.getBean("teamLeadInstanceFactory");
    	System.out.println(teamLeadInstanceFactory.getGreeting());
    	
    	((AbstractApplicationContext)context).close();
    }
}
