
public class Usuario {
	private String userName;
	private String password;
	
	public Usuario(String Name, String Password) {
		this.userName = Name;
		this.password = Password;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
}