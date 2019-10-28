package application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

	//class will represent users of this application. Each user has a username and a password.
	//Their username is their last name, in all lowercase. 
	private String name="",password="";
	private ArrayList <User> users = new ArrayList<User>();
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User() {
	}


	public void populateuserdataLists() throws IOException {

		// File x = getClass().getRecource() for proper java thinking!
			InputStream usrs =   getClass().getResourceAsStream("/users.csv"); //new File("data/users.csv");
		//		System.out.println("it worked");
		BufferedReader reader = new BufferedReader(new InputStreamReader((usrs)));
		String line="",usrnm="",psswrd="";


		while ((line=reader.readLine()) != null){
			Scanner scanline = new Scanner(line);
			scanline.useDelimiter(",");
			usrnm=scanline.next();
			psswrd=scanline.next();
			addToUsers(new User(usrnm,psswrd));
		}
		//        printUsers();
	}

	private void addToUsers(User user) {
		users.add(user);
	}

	/**There will be a class method called validate which should take in a user name and password.
	This method should be called from the controller.
	If the user exists in the app (if their user name is found in the users.csv file),
	then the password should be verified. If the given password is correct,
	then they should be permitted to move to the next view. This method will return a User object, 
	based on a given username.
	If the user does not exist in the app (if their user name is not found in the users.csv file),
	or if the password provided is incorrect, they should not be permitted to move to the next view.
	@param userName String user name
	@param psword String user password
	@return User user 
	*/
	public Boolean  validate(String userName, String psword) {

		for (int index = 0; index < users.size(); index++) {
			if (users.get(index).name.equals(userName) && users.get(index).password.equals(psword)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method returns the string value for name of the user
	 * @return String name of User
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method takes in a name to set the current users name to.
	 * @param name String to set the user name to.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method returns the password for the current user.
	 * @return String password for the user
	 */

	public String getPassword() {
		return password;
	}
	
	/**
	 * This method takes in a string for the password to set the current users password to.
	 * @param password to set the users password to.
	 */

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This method returns the arraylist of users 
	 * @return ArrayList  list of users.
	 */

	public ArrayList<User> getList() {
		return users;
	}
	
	/**
	 * This method takes in a arraylist of user objects to set the current arraylist of users to.
	 * @param list ArrayList of users
	 */

	public void setList(ArrayList<User> list) {
		this.users = list;
	}
	
	/**
	 * This method returns a string representation of the user objects.
	 * @return String string representation of the user objects.
	 */
	public String toString() {
		String tmp = "";
		tmp = "UserName: " + name + "User Password: " + password;
		return tmp;
	}
	
	

}
