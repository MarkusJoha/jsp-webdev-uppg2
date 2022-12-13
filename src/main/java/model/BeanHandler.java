 package model;

public class BeanHandler {
	private static String username = "Markus";
	private static String username2 = "Loke";
	private static String password1 = "kul";
	private static String password2 = "lok";

	public static boolean users(String users, String password) {
	    if(username.equals(users)&& password.equals(password1)) {
	        return true;
	        
	    } else if(username2.equals(users)&& password.equals(password2)) {
	        return true;
	    }else {
	        return false;
	    }
	}
}
