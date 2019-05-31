package model;

/**
*Descripción: La clase Duende en el paquete model. Se extiende de Personaje.<br>
*@author Esteban Ariza
*/
public class Duende extends Personaje{
	
	//Constantes
	public final static int VALOR_XP=100;
	public final static int VALOR_DINERO=400;
	
	//Atributos
	private int multiplicadorDinero;
	private int nariz;
	
	//Constructor
	/**
	*Descripción: El constructor de la clase Duende.<br>
	*Post: Todos los atributos de la clase son inicializados.<br>
	*@param nombre El nombre que queremos colocar.
	*@param ojos El ojo que queremos colocar.
	*@param cabello El gorro que queremos colocar.
	*@param nariz La nariz que queremos colocar.
	*/
	public Duende(String nombre, int ojos, int cabello, int nariz){
		
		super(nombre, ojos, cabello);
		this.nariz=nariz;
		this.multiplicadorDinero=1;
		
	}
	
	//Avatar
	/**
	*Descripción: Crea la imagen de un avatar a partir de algunos atributos del personaje.<br>
	*@return Un String que es el avata en texto.
	*/
	public String generarAvatar() {
		
		char[][] avatar={
		{' ',' ',' ','*',' ',' ',' '},
		{' ',' ','/',' ','\\',' ',' '},
		{' ','/','_','_','_','\\',' '},
		{' ','|',' ',' ',' ','|',' '},
		{' ','\\','_','_','_','/',' '},
		{' ',' ','/','|','\\',' ',' '},
		{' ',' ',' ','|',' ',' ',' '},
		{' ',' ','/',' ','\\',' ',' '},
		};
		
		if(darCabello()==0){avatar[0][3]='^';}
		else if(darCabello()==1){avatar[0][3]='&';}
		else if(darCabello()==2){avatar[0][3]='!';}
		else if(darCabello()==3){avatar[0][3]='+';}
		else if(darCabello()==4){avatar[0][3]='$';}
		else if(darCabello()==5){avatar[0][3]='*';}
		else if(darCabello()==6){avatar[0][3]='#';}
		else if(darCabello()==7){avatar[0][3]='@';}
		else if(darCabello()==8){avatar[0][3]='O';}
		
		if(darOjos()==0){avatar[3][2]='\'';avatar[3][4]='\'';}
		else if(darOjos()==1){avatar[3][2]='*';avatar[3][4]='*';}
		else if(darOjos()==2){avatar[3][2]='-';avatar[3][4]='-';}
		else if(darOjos()==3){avatar[3][2]='^';avatar[3][4]='^';}
		else if(darOjos()==4){avatar[3][2]='|';avatar[3][4]='|';}
		else if(darOjos()==5){avatar[3][2]='>';avatar[3][4]='<';}
		else if(darOjos()==6){avatar[3][2]='$';avatar[3][4]='$';}
		else if(darOjos()==7){avatar[3][2]='I';avatar[3][4]='I';}
		else if(darOjos()==8){avatar[3][2]='0';avatar[3][3]='-';avatar[2][4]='0';}
		else if(darOjos()==9){avatar[3][2]='-';avatar[3][4]='o';}
		else if(darOjos()==10){avatar[3][2]='O';avatar[3][4]='o';}
		
		if(nariz==0){avatar[3][3]=' ';}
		else if(nariz==1){avatar[3][3]='L';}
		else if(nariz==2){avatar[3][3]='|';}
		else if(nariz==3){avatar[3][3]='o';}
		else if(nariz==4){avatar[3][3]='_';}
		else if(nariz==5){avatar[3][3]='v';}
		
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
		
		String datos=darNombre()+":\n\n"+generarAvatar()+"\nXP: "+darXp()+"\nNivel: "+darMultiplicadorDinero();
		
		return datos;
		
	}
	
	//SubirNivel
	/**
	*Descripción: Suma 1 al atributo multiplicadorDinero a partir de la xp que tenga el personaje. Subir de nivel al personaje.<br>
	*post: Se cambia el multiplicadorDinero.<br>
	*@return Un String que indica si se pudo subir o no de nivel.
	*/
	public String subirNivel(){
		
		String message="Se ha subido de nivel a la unidad!";
		
		if(darXp()>=(VALOR_XP*multiplicadorDinero)){
			quitarXp(VALOR_XP*multiplicadorDinero);
			multiplicadorDinero+=1;
		}
		else{message="La unidad no tiene suficiente XP!";}
		
		return message;
		
	}
	
	//Dar
	/**
	*Descripción: Retorna el multiplicadorDinero del Duende.<br>
	*@return Un int que es el multiplicadorDinero del Duende.
	*/
	public int darMultiplicadorDinero(){
		
		return multiplicadorDinero;
		
	}
	
}
