import java.util.ArrayList;

public class Usuarios {
	//Agregar usuarios
		private static ArrayList<Usuario> activeUsers = new ArrayList<Usuario>();
		private static Usuario activeUser;
		
		public static void addUser(Usuario user) {
			activeUsers.add(user);
		}
		
		public static ArrayList<Usuario> getActiveUsers(){
			return activeUsers;
		}
		
	    public static void login(Usuario user){
	        activeUser = user;
	    }
	    
	    public static void signOut(){
	        activeUser = null;
	    }
	    
	    public static Usuario getActiveUser(){
	        return activeUser;
	    }
}
