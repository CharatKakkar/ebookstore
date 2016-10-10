package com.ebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private int usersId;		
		private String username;
	    private String password;
	    private boolean isActive;
	    private int customerId;
	    
	    public int getUsersId() {
			return usersId;
		}
		public void setUsersId(int usersId) {
			this.usersId = usersId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
	
}
