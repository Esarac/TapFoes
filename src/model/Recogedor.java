package model;

/**
*Descripción: La interfaz Recogedor en el paquete model.<br>
*@author Esteban Ariza
*/
public interface Recogedor {
	
	/**
	*Descripción: El metodo retorna para cada especifica unidad un valor, el cual va a ser la cantidad de dinero que cada unidad que los implemente puede recoger.<br>
	*@return El dinero que la unidad puede recoger.
	*/
	public double dineroRecogido();
	
}
