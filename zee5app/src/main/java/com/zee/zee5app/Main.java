package com.zee.zee5app;

//import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.UnabletoGenerateIdException;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserServiceImpl;
import com.zee.zee5app.utils.IdComparator;

//import com.zee.zee5app.dto.User;

public class Main {
	public static void main(String[] args) {
		
		
		
//		System.out.println("jnJub");
		UserService userService = UserServiceImpl.getInstance();
		try {
			userService.insertUser(
					new User("ab200191","rieksh","chivate","kskskskgmail.com",LocalDate.now(),LocalDate.of(1988, 12, 9)));
		} catch (UnabletoGenerateIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
//		User user = new User();
//		Collections.sort(User, IdComparator);
		
		
//		Optional<User> result = userService.getUserById("ab001");
//		
//		if(result.isPresent()) {
//			System.out.println("no record found");
//		}else {
//			User user = result.get();
//			System.out.println(user);
//		}

		
		
//		System.out.println("Hello Kuldeep");
//		User user = new User();
//		User user =  new User();
//		System.out.println(user);
//		System.out.println(user.toString());
//		System.out.println(user.getClass().getName());
//		System.out.println(user.hashCode());
//		System.out.println(Integer.toHexString(user.hashCode()));
		
//		UserServiceImpl userservice = UserServiceImpl.getInstance();
//		
//		User user  = new User();
//		
////		switch case
//		final int operation = 1;
//		
//		switch (operation) {
//		case 1:
//			String result = userservice.insertUser(user);
//			if("success".equals(result)) {
//				System.out.println("user is added successfully");
//			}else {
//				System.out.println("user not found");
//			}
//			
//			break;
//		case 2:
//			User[] users = userservice.getallusers();
//			
//			if(users==null) {
//				System.out.println("no record found");
//			}else {
//				for (User user1 : users) {
//					if(user1!=null) {
//						System.out.println(user1);
//					}
//				}
//			}
//			
//		case 3:
//			User specificuser = userservice.getuserbyid(user.getUserId());
//			if(specificuser==null) {
//				System.out.println("no user found for this id");
//			}else {
//				System.out.println(specificuser);
//			}
//			
//			break;
//			
//		case 4:
//			
//			String result1 = userservice.deleteuserbyid(user.getUserId());
//			if("success".equals(result1)) {
//				System.out.println("user is added successfully");
//			}else {
//				System.out.println("user not found");
//			}
//			
//			break;
//			
//			
//			
//		default:
//			break;
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
		

		
		
		
		
		
		
		
//		delete(id)
//		update(id,new obj)
		
	}

}



//mysql workbench
//postman

//vscode
//oracle vm
//nodejs
//mongo db
//android studio