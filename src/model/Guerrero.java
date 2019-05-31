package model;

/**
*Descripción: La clase Guerrero en el paquete model. Se extiende de Personaje e implementa Recogedor.<br>
*@author Esteban Ariza
*/
public class Guerrero extends Personaje implements Recogedor{
	
	//Constantes
	public final static int VALOR_XP=100;
	public final static int VALOR_DINERO=100;
	
	//Atributos
	private int dano;
	
	//Constructor
	/**
	*Descripción: El constructor de la clase Guerrero.<br>
	*Post: Todos los atributos de la clase son inicializados.<br>
	*@param nombre El nombre que queremos colocar.
	*@param ojos El ojo que queremos colocar.
	*@param cabello El cabello que queremos colocar.
	*/
	public Guerrero(String nombre, int ojos, int cabello) {
		
		super(nombre, ojos, cabello);
		
		this.dano=1;
		
	}
	
	//Avatar
	/**
	*Descripción: Crea la imagen de un avatar a partir de algunos atributos del personaje.<br>
	*@return Un String que es el avata en texto.
	*/
	public String generarAvatar() {
		
		char[][] avatar={
		{' ',' ','_','_','_',' ',' '},
		{' ','/',' ',' ',' ','\\',' '},
		{' ','|',' ',' ',' ','|',' '},
		{' ','\\','_','_','_','/',' '},
		{' ',' ',' ','|',' ',' ',' '},
		{' ',' ','/','|','\\',' ',' '},
		{' ','/',' ','|',' ','\\',' '},
		{' ',' ',' ','|',' ',' ',' '},
		{' ',' ','/',' ','\\',' ',' '},
		{' ','/',' ',' ',' ','\\',' '}
		};
		
		if(darCabello()==1) {
			
															   avatar[0][5]='/';avatar[0][6]='|';
			avatar[1][2]='_';avatar[1][3]='_';avatar[1][4]='_';avatar[1][5]='_';avatar[1][6]='/';
			
		}
		else if(darCabello()==2) {
			
							 avatar[0][1]='_';													 avatar[0][5]='_';
			avatar[1][0]='/';avatar[1][1]=' ';avatar[1][2]='_';avatar[1][3]='_';avatar[1][4]='_';avatar[1][5]=' ';avatar[1][6]='\\';
			avatar[2][0]='\\';																					  avatar[2][6]='/';
			
		}
		else if(darCabello()==3){
			
							 avatar[0][1]='_';													  avatar[0][5]='_';
			avatar[1][0]='/';avatar[1][1]=' ';avatar[1][2]='/';avatar[1][3]='V';avatar[1][4]='\\';avatar[1][5]=' ';avatar[1][6]='\\';
			avatar[2][0]='|';avatar[2][1]='/';													  avatar[2][5]='\\';avatar[2][6]='|';
			avatar[3][0]='\\';																						avatar[3][6]='/';
			
		}
		
		if(darOjos()==0){avatar[2][2]='\'';avatar[2][4]='\'';}
		else if(darOjos()==1){avatar[2][2]='*';avatar[2][4]='*';}
		else if(darOjos()==2){avatar[2][2]='-';avatar[2][4]='-';}
		else if(darOjos()==3){avatar[2][2]='^';avatar[2][4]='^';}
		else if(darOjos()==4){avatar[2][2]='|';avatar[2][4]='|';}
		else if(darOjos()==5){avatar[2][2]='>';avatar[2][4]='<';}
		else if(darOjos()==6){avatar[2][2]='$';avatar[2][4]='$';}
		else if(darOjos()==7){avatar[2][2]='I';avatar[2][4]='I';}
		else if(darOjos()==8){avatar[2][2]='0';avatar[2][3]='-';avatar[2][4]='0';}
		else if(darOjos()==9){avatar[2][2]='-';avatar[2][4]='o';}
		else if(darOjos()==10){avatar[2][2]='O';avatar[2][4]='o';}
		
		String avatarTexto="";
		
		for(char[] avatarFila: avatar){
			for(char avatarElemento: avatarFila){avatarTexto+=avatarElemento;}
			avatarTexto+="\n";
		}
		
		return avatarTexto;
		
	}
	
	//Mostrar
	/**
	*Descripción: Retorna los datos del personaje en una plantilla.<br>
	*@return Un String que son los datos del personaje.
	*/
	public String datos(){
		
		String datos=darNombre()+":\n\n"+generarAvatar()+"\nXP: "+darXp()+"\nNivel: "+darDano();
		
		return datos;
		
	}
	
	//SubirNivel
	/**
	*Descripción: Suma 1 al atributo dano a partir de la xp que tenga el personaje. Subir de nivel al personaje.<br>
	*post: Se cambia el dano.<br>
	*@return Un String que indica si se pudo subir o no de nivel.
	*/
	public String subirNivel(){
		
		String message="Se ha subido de nivel a la unidad!";
		
		if(darXp()>=(VALOR_XP*dano)){
			quitarXp(VALOR_XP*dano);
			dano+=1;
		}
		else{message="La unidad no tiene suficiente XP!";}
		
		return message;
		
	}
	
	//Dinero
	/**
	*Descripción: El metodo retorna un valor, el cual va a ser la cantidad de dinero que el personaje puede recoger.<br>
	*@return Un double que es dinero que el personaje puede recoger.
	*/
	public double dineroRecogido(){
			
		double dinero=dano+1;
		return dinero;
			
	}
	
	//Dar
	/**
	*Descripción: Retorna el dano del Guerrero.<br>
	*@return Un int que es el dano del Guerrero.
	*/
	public int darDano(){
		
		return dano;
		
	}
	
}
