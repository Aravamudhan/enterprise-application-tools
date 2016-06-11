package com.amudhan.controller;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport{
	
	/*User defined property editor. Extending PropertyEditorSupport is necessary for user defined editors
	 * The setAsText method will be called by default whenever binding takes place. If not overridden, the method
	 * defined in the PropertyEditorSupport will be called.*/
	@Override
	public void setAsText(String studentName)throws IllegalArgumentException{
		if(studentName.contains("Mr.") || studentName.contains("Ms.")){
			setValue(studentName);
		}else{
			studentName = "Mr."+studentName;
			setValue(studentName);
		}
	}

}
