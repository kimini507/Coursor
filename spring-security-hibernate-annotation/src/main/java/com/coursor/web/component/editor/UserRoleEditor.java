package com.coursor.web.component.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.coursor.app.model.UserRole;

@Component
public class UserRoleEditor extends PropertyEditorSupport {	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		UserRole ur = new UserRole();
		ur.setRole(text);
		this.setValue(ur);
	}
}
