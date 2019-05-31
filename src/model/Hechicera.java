package model;

/**
*Descripción: La clase Hechicera en el paquete model. Se extiende de Personaje e implementa Recogedor.<br>
*@author Esteban Ariza
*/
public class Hechicera extends Personaje implements Recogedor{
	
	//Constantes
	public final static int VALOR_XP=200;
	public final static int VALOR_DINERO=200;
	
	//Atributos
	private double multiplicadorXp;
	private int aretes;
	
	//Constructor
	/**
	*Descripción: El constructor de la clase Hechicera.<br>
	*Post: Todos los atributos de la clase son inicializados.<br>
	*@param nombre El nombre que queremos colocar.
	*@param ojos El ojo que queremos colocar.
	*@param cabello El cabello que queremos colocar.
	*@param aretes El arete que queremos colocar.
	*/
	public Hechicera(String nombre, int ojos, int cabello, int aretes){
		
		super(nombre, ojos, cabello);
		this.aretes=aretes;
		this.multiplicadorXp=1;
		
	}
	
	//Avatar
	/**
	*Descripción: Crea la imagen de un avatar a partir de algunos atributos del personaje.<br>
	*@return Un String que es el avata en texto.
	*/
	public String generarAvatar() {
		
		char[][] avatar={
		{' ',' ','_','_','_',' ',' '},
		{'/',' ','_','_','_',' ','\\'},
		{'|','|',' ',' ',' ','|','|'},
		{'|','\\','_','_','_','/','|'},
		{' ',' ',' ','|',' ',' ',' '},
		{' ',' ','/','|','\\',' ',' '},
		{' ','/',' ','|',' ','\\',' '},
		{' ',' ',' ','|',' ',' ',' '},
		{' ',' ','/',' ','\\',' ',' '},
		{' ','/',' ',' ',' ','\\',' '}
		};
		
		if(darCabello()==0){
			
			avatar[4][0]='|';avatar[4][1]='_';avatar[4][2]='_';avatar[4][4]='_';avatar[4][5]='_';avatar[4][6]='|';
			
		}
		else if(darCabello()==1) {
			
			avatar[4][0]='|';								   avatar[4][6]='|';
			avatar[5][0]='|';avatar[5][1]='_';avatar[5][5]='_';avatar[5][6]='|';
			
		}
		else if(darCabello()==2){
			
			avatar[1][3]='/';avatar[1][4]='\\';
			avatar[4][1]='\\';avatar[4][6]='|';
							  avatar[5][6]='|';
			avatar[6][4]='\\';avatar[6][6]='|';
			avatar[7][5]='\\';avatar[7][6]='|';
			
		}
		
		if(aretes==1){avatar[3][0]='*';avatar[3][6]='*';}
		else if(aretes==2){avatar[3][0]='O';avatar[3][6]='O';}
		else if(aretes==3){avatar[3][0]='?';avatar[3][6]='?';}
		else if(aretes==4){avatar[3][0]='$';avatar[3][6]='$';}
		else if(aretes==5){avatar[3][0]=';';avatar[3][6]=';';}
		
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
		
		String datos=darNombre()+":\n\n"+generarAvatar()+"\nXP: "+darXp()+"\nNivel: "+calcularNivel();
		
		return datos;
		
	}
	
	//SubirNivel
	/**
	*Descripción: Suma 0.5 al atributo multiplicadorXp a partir de la xp que tenga el personaje. Subir de nivel al personaje.<br>
	*post: Se cambia el multiplicadorXp.<br>
	*@return Un String que indica si se pudo subir o no de nivel.
	*/
	public String subirNivel(){
		
		String message="Se ha subido de nivel a la unidad!";
		
		if(darXp()>=(VALOR_XP*calcularNivel())){
			quitarXp(VALOR_XP*calcularNivel());
			multiplicadorXp+=0.5;
		}
		else{message="La unidad no tiene suficiente XP!";}
		
		return message;
		
	}
	
	//Dinero
	/**
	*Descripción: El metodo retorna un valor, el cual va a ser la cantidad de dinero que el personaje puede recoger.<br>
	*@return Un double que es el dinero que el personaje puede recoger.
	*/
	public double dineroRecogido(){
		
		double dinero=(multiplicadorXp+0.5);
		return dinero;
		
	}
	
	//Calcular
	/**
	*Descripción: El metodo calcula el nivel del personaje por su atributo multiplicadorXp.<br>
	*@return Un int que es el nivel del personaje.
	*/
	public int calcularNivel(){
		
		int nivel=(int)((multiplicadorXp-0.5)*2);
		
		return nivel;
		
	}
	
	//Dar
	/**
	*Descripción: Retorna el multiplicadorXp de la Hechicera.<br>
	*@return Un double que es el multiplicadorXp de la Hechicera.
	*/
	public double darMultiplicadorXp(){
		
		return multiplicadorXp;
		
	}
	
}