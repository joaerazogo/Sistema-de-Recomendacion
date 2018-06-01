
public class Ciudad {
	private String Nombre;
	private String Descripcion;
	private String Ubicacion;
	private String Telefono;
	
	public Ciudad(String nombre, String descripcion, String ubicacion, String telefono) {
		Nombre = nombre;
		Descripcion = descripcion;
		Ubicacion = ubicacion;
		Telefono = telefono;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public String getDescripcion() {
		return Descripcion;
	}
	
	public String Ubicacion() {
		return Ubicacion;
	}
	
	public String getTelefono() {
		return Telefono;
	}
}
