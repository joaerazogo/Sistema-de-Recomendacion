import java.util.ArrayList;

public class Autenticar {
	public static boolean autenticacion(String username, String password){
        ArrayList<Usuario> Users = Usuarios.getActiveUsers();
        for (int i = 0; i < Users.size(); i++) {
            if(Users.get(i).getUserName().equals(username) && Users.get(i).getPassword().equals(password)){
                Usuarios.login(Users.get(i));
                return true;
            }
        }
        return false;
    }

}
