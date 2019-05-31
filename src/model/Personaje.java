package model;

/**
*Descripci�n: La clase abstracta Personaje en el paquete model.<br>
*@author Esteban Ariza
*/
public abstract class Personaje{
	
	//Atributos
	private String nombre;
	private int xp;
	private int ojos;
	private int cabello;
	
	//Constructor
	/**
	*Descripci�n: El constructor de la clase abstracta Personaje.<br>
	*Post: Todos los atributos de la clase son inicializados.<br>
	*@param nombre El nombre que queremos colocar.
	*@param ojos El ojo que queremos colocar.
	*@param cabello El cabello que queremos colocar.
	*/
	public Personaje(String nombre, int ojos, int cabello){
				
		this.nombre=nombre;
		this.ojos=ojos;
		this.cabello=cabello;
		this.xp=0;
		
	}
	
	//Avatar
	/**
	*Descripci�n: Crea la imagen de un avatar a partir de algunos atributos del personaje.<br>
	*@return Un String que es el avata en texto.
	*/
	public abstract String generarAvatar();
	
	//Mostrar
	/**
	*Descripci�n: Retorna los datos del personaje en una plantilla.<br>
	*@return Un String que son los datos del personaje.
	*/
	public abstract String datos();
	
	//SubirNivel
	/**
	*Descripci�n: Subir de nivel al personaje.<br>
	*post: Se cambia el atributo principal(El que define el nivel) del personaje.<br>
	*@return Un String que indica si se pudo subir o no de nivel.
	*/
	public abstract String subirNivel();
	
	//Anadir
	/**
	*Descripci�n: Permite anadir xp al personaje.<br>
	*post: Se anade xp al personaje<br>
	*@param xp la xp que deseo anadir.
	*@return Un int que es la xp que se anadio.
	*/
	public int anadirXp(int xp) {
		
		this.xp+=xp;
		
		return xp;
		
	}
	
	//Quitar
	/**
	*Descripci�n: Permite quitar xp al personaje.<br>
	*post: Se quita xp al personaje<br>
	*@param xp la xp que deseo quitar.
	*@return Un double que es la xp que se quito.
	*/
	public double quitarXp(double xp){
		
		this.xp-=xp;
		
		return xp;
		
	}
	
	//Dar
	/**
	*Descripci�n: Retorna el nombre del Personaje.<br>
	*@return Un String que es el nombre del Personaje.
	*/
	public String darNombre(){
		
		return nombre;
		
	}
	
	/**
	*Descripci�n: Retorna el xp del Personaje.<br>
	*@return Un int que es el xp del Personaje.
	*/
	public int darXp(){
		
		return xp;
		
	}
	
	/**
	*Descripci�n: Retorna los ojos del Personaje.<br>
	*@return Un int que son los ojos del Personaje.
	*/
	public int darOjos() {
		
		return ojos;
		
	}
	
	/**
	*Descripci�n: Retorna el cabello del Personaje.<br>
	*@return Un int que es el cabello del Personaje.
	*/
	public int darCabello() {
		
		return cabello;
		
	}
	
}
