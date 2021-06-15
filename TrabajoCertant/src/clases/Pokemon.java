package clases;



public class Pokemon {
	//Atributos de los Pokemons
	private int numero;
	private String nombre;
	private String Tipo;
	private String Habilidad;
	private String nivel_aparece;
	private String como_aparece;
	private String evolucion;
	//Constructor, Sets y Gets
	public Pokemon(int numero,String nombre, String tipo, String habilidad, String nivel_aparece, String como_aparece,
			String evolucion) {
		super();
		this.numero=numero;
		this.nombre = nombre;
		this.Tipo = tipo;
		this.Habilidad = habilidad;
		this.nivel_aparece = nivel_aparece;
		this.como_aparece = como_aparece;
		this.evolucion = evolucion;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	public String getHabilidad() {
		return Habilidad;
	}

	public void setHabilidad(String habilidad) {
		Habilidad = habilidad;
	}

	public String getNivel_aparece() {
		return nivel_aparece;
	}
	public void setNivel_aparece(String nivel_aparece) {
		this.nivel_aparece = nivel_aparece;
	}
	
	public String getComo_aparece() {
		return como_aparece;
	}

	public void setComo_aparece(String como_aparece) {
		this.como_aparece = como_aparece;
	}

	public String getEvolucion() {
		return evolucion;
	}
	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}

	@Override
	public String toString() {
		return "Pokemon [numero=" + numero + ", nombre=" + nombre + ", Tipo=" + Tipo + ", Habilidad=" + Habilidad
				+ ", nivel_aparece=" + nivel_aparece + ", como_aparece=" + como_aparece + ", evolucion=" + evolucion
				+ "]";
	}
	
}