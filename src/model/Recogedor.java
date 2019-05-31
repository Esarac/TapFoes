package model;

/**
*Descripci�n: La interfaz Recogedor en el paquete model.<br>
*@author Esteban Ariza
*/
public interface Recogedor {
	
	/**
	*Descripci�n: El metodo retorna para cada especifica unidad un valor, el cual va a ser la cantidad de dinero que cada unidad que los implemente puede recoger.<br>
	*@return El dinero que la unidad puede recoger.
	*/
	public double dineroRecogido();
	
}
