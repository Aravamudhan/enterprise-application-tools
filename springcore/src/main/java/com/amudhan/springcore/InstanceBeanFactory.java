package com.amudhan.springcore;

/*The beans Manager and TeamLead are injected through configuration file.
 * By using instance factory methods, the required bean Manager or TeamLead will be returned*/
public class InstanceBeanFactory {
	private Manager manager;
	private TeamLead teamLead;
	
	public InstanceBeanFactory(Manager manager,TeamLead teamLead){
		this.manager = manager;
		this.teamLead = teamLead;
	}
	
	public Manager createManagerInstance(){
		return manager;
	}
	
	public TeamLead createTeamLeadInstance(){
		return teamLead;
	}
	

}
