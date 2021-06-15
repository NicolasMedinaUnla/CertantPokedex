package clases;

import java.util.ArrayList;
import java.util.List;
//Clase Sistema -- Donde se almacenan todos los metodos del programa
public class Sistema {
	List<Pokemon> listapokemon;

	public Sistema() {
		super();
		this.listapokemon = new ArrayList<Pokemon>();
	}
	
	@Override
	public String toString() {
		return "Sistema [listapokemon=" + listapokemon + "]";
	}


	public List<Pokemon> getLista() {
		return listapokemon;
	}

	public void setLista(List<Pokemon> lista) {
		this.listapokemon = lista;
	}
	
	//Metodos
	
	public Pokemon buscarPokemon(String nombre)throws Exception{//Busca un pokemon en base al nombre
		for(Pokemon x: listapokemon) {
			if(nombre.equals(x.getNombre())) {
				return x;
			}
		}
		return null;
	}
	
	public boolean eliminarPokemon(String nombre) {//Elimina un pokemon en base al nombre
		for(Pokemon x: listapokemon) {
			if(nombre.equals(x.getNombre())) {
				return listapokemon.remove(x);
			}
		}
		return false;
	}
	
	public Pokemon verEvolucion(String evolucion) throws Exception {//Muestra la info de la evolucion de un Pokemon
		String pokeEvolucion=buscarPokemon(evolucion).getEvolucion();
		return buscarPokemon(pokeEvolucion);
	}
	
	public boolean tieneEvolucion(String nombre) throws Exception {//Pregunta si x Pokemon tiene evolucion
		
		return !buscarPokemon(nombre).getEvolucion().isEmpty();
	}
	
	public boolean agregarPokemon(String nombre, String tipo, String habilidad, String nivel_aparece, String como_aparece,
			String evolucion){// Agrega un pokemon a la lista del pokemons
		int numero =0;
		if(!listapokemon.isEmpty()) {
			numero=listapokemon.get(listapokemon.size()-1).getNumero()+1;
		}
		
		return listapokemon.add(new Pokemon(numero, nombre, tipo, habilidad, nivel_aparece, como_aparece, evolucion));
	}
	
	public int idPokemon(String nombre) throws Exception {//Trae el id de un Pokemon
		
		return buscarPokemon(nombre).getNumero();
	}
	
	public void editarNombre(String nombre, String nuevo_nombre) throws Exception {//Edita el nombre de un Pokemon en la Lista
		
		for(Pokemon x: listapokemon) {
			if(nombre.equals(x.getNombre())) {
				 x.setNombre(nuevo_nombre);
			}
		}
	}
	
	public void editarTipo(String nombre, String nuevoTipo)throws Exception {//Edita el Tipo de un Pokemon en la Lista
	
		for(Pokemon x: listapokemon) {
			if(nombre.equals(x.getNombre())) {
				 x.setTipo(nuevoTipo);
			}
		}
	}
	
	public void editarNivel(String nombre, String nuevo_nivel_aparece)throws Exception {//Edita el Nivel de un Pokemon en la lista
		
		for(Pokemon x: listapokemon) {
			if(nombre.equals(x.getNombre())) {
				 x.setNivel_aparece(nuevo_nivel_aparece);
			}
		}
	}
	
	
//Fin de la clase Sistema
}
