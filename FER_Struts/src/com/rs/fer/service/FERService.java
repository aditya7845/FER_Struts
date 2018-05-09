package com.rs.fer.service;

import java.sql.Connection;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public interface FERService {
	
	boolean login(String username, String password, Connection connection);
	
	boolean registration (User user, Connection connection);
	
    boolean addExpense(Expense expense,Connection connection);
    
    boolean deleteExpense(int id,Connection connection);
    
    boolean editExpense(Expense expense,Connection connection);
    
    Expense getExpense(int expenseid);
    
    List<Expense> getExpenseReport(String expensetype ,String fromdate , String todate);
    
    List<Expense> getExpenses();
    
    boolean resetPassword(String username, String currentpassword , String newPassword );
    
    PersonalInfo getPersonalInfo(String username);
    
    boolean uppdatePersonalInfo(User user, Address address);
    
    boolean isUsernameAvailabe(String username);
       

}