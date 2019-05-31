package model;
import java.util.ArrayList;

/**
*Descripción: La clase Partida en el paquete model.<br>
*@author Esteban Ariza
*/
public class Partida {
	
	//Atributos
	private int dinero;
	private ArrayList<Guerrero> guerreros;
	private Hechicera[] hechiceras;
	private Duende duende;
	
	//Constructor
	/**
	*Descripción: El constructor de la clase Partida.<br>
	*Post: Todos los atributos de la clase son inicializados.<br>
	*@param guerrero El guerrero inicial que queremos colocar.
	*/
	public Partida(Guerrero guerrero){
		
		this.guerreros=new ArrayList<Guerrero>();
		this.hechiceras=new Hechicera[5];
		this.guerreros.add(guerrero);
		this.dinero=0;
		
	}
	
	//SubirNivel
	/**
	*Descripción: Sube de nivel a un Guerrero.<br>
	*pre: El ArrayList de guerrreros no debe tener elementos nulos.<br>
	*@param index El indice del Guerrero que quiero subir de nivel.
	*@return Un String que indica si se pudo subir de nivel. Si no entonces dice que el indice esta mal.
	*@throws NullPointerException Si un guerrero esta nulo.
	*/
	public String subirNivelGuerrero(int index){
		
		String mensage;
		
		if((index>=0)&&(index<guerreros.size())){mensage=guerreros.get(index).subirNivel();}
		else{mensage="Numero invalido!";}
		
		return mensage;
		
	}
	
	/**
	*Descripción: Sube de nivel a una Hechicera.<br>
	*@param index El indice de la Hechicera que quiero subir de nivel.
	*@return Un String que indica si se pudo subir de nivel. Si no entonces dice que el indice esta mal.
	*/
	public String subirNivelHechicera(int index){
		
		String mensage;
		
		if((index>=0)&&(index<hechiceras.length)){
			if(hechiceras[index]!=null){mensage=hechiceras[index].subirNivel();}
			else{mensage="Numero invalido!";}
		}
		else{mensage="Numero invalido!";}
		
		return mensage;
		
	}
	
	/**
	*Descripción: Sube de nivel al Duende.<br>
	*@return Un String que indica si se pudo subir de nivel. Si no entonces dice que todavia no tienes el personaje.
	*/
	public String subirNivelDuende(){
		
		String mensage;
		
		if(duende!=null){mensage=duende.subirNivel();}
		else{mensage="No has adquirido la unidad!";}
		
		return mensage;
		
	}
	
	//Comprar
	/**
	*Descripción: Compra un Guerrero con tu dinero.<br>
	*post: Se anade un Guerrero al ArrayList de guerrreros. Se quita el dinero que cuesta la unidad.<br>
	*@param nombre El nombre del Guerrero.
	*@param ojos El ojo del Guerrero.
	*@param cabello El cabello del Guerrero.
	*@return Un String que indica si se pudo comprar el personaje. Si no entonces dice que no te alcanza el dinero.
	*/
	public String comprarGuerrero(String nombre, int ojos, int cabello) {
		
		Guerrero guerrero=new Guerrero(nombre, ojos, cabello);
		String message="Se ha comprado al guerrero exitosamente!";
		
		if(dinero>=Guerrero.VALOR_DINERO){
			dinero-=Guerrero.VALOR_DINERO; 
			guerreros.add(guerrero);
		}
		else{message="No tienes suficiente dinero!";}
		
		return message;
		
	}
	
	/**
	*Descripción: Compra una Hechicera con tu dinero.<br>
	*post: Se anade una Hechicera al Array de hechiceras. Se quita el dinero que cuesta la unidad.<br>
	*@param nombre El nombre de la Hechicera.
	*@param ojos El ojo de la Hechicera.
	*@param cabello El cabello de la Hechicera.
	*@param aretes El arete de la Hechicera.
	*@return Un String que indica si se pudo comprar el personaje. Si no, entonces dice la razon por la que no se pudo comprar.
	*/
	public String comprarHechicera(String nombre, int ojos, int cabello, int aretes){
		
		Hechicera hechicera=new Hechicera(nombre, ojos, cabello, aretes);
		String message="Solo puedes tener 5 hechiceras. Conformate con las que tienes!";
		
		boolean run=true;
		for(int i=0; (i<hechiceras.length) && run;i++){
			if(hechiceras[i]==null){
				if(dinero>=Hechicera.VALOR_DINERO){
					dinero-=Hechicera.VALOR_DINERO;
					hechiceras[i]=hechicera;
					message="Se ha comprado a la hechicera exitosamente!";
				}
				else{message="No tienes suficiente dinero!";}
				run=false;
			}
		}
		
		return message;
		
	}
	
	/**
	*Descripción: Compra un Duende con tu dinero.<br>
	*post: Se anade un Duende al atributo duende. Se quita el dinero que cuesta la unidad.<br>
	*@param nombre El nombre del Duende.
	*@param ojos El ojo del Duende.
	*@param cabello El gorro del Duende.
	*@param nariz La nariz del Duende.
	*@return Un String que indica si se pudo comprar el personaje. Si no entonces dice que no te alcanza el dinero.
	*/
	public String comprarDuende(String nombre, int ojos, int cabello, int nariz) {
		
		Duende duende=new Duende(nombre, ojos, cabello, nariz);
		String message="Se ha comprado al guerrero exitosamente!";
		
		if(this.duende==null){
			if(dinero>=Duende.VALOR_DINERO){
				dinero-=Duende.VALOR_DINERO; 
				this.duende=duende;
			}
			else{message="No tienes suficiente dinero!";}
		}
		else{message="Solo puedes tener 1 duende. Conformate con el que tienes!";}
		
		return message;
		
	}
	
	//Anadir
	/**
	*Descripción: Anade xp a todas las unidades existentes en partida.<br>
	*pre: El ArrayList de guerrreros no debe tener elementos nulos.<br>
	*@return Un int que indica la suma de toda la xp obtenida combinando guerreros y hechiceras.
	*@throws NullPointerException Si un guerrero esta nulo.
	*/
	public int anadirXp(){
		
		int xpGanada=0;
		
		for(int i=0; i<guerreros.size(); i++){xpGanada+=guerreros.get(i).darDano();}
		for(Hechicera hechicera: hechiceras) {
			if(hechicera!=null){xpGanada*=hechicera.darMultiplicadorXp();}
		}
		
		for(int i=0; i<guerreros.size(); i++){guerreros.get(i).anadirXp(xpGanada);}
		for(Hechicera hechicera: hechiceras){
			if(hechicera!=null){hechicera.anadirXp(xpGanada);}
		}
		if(duende!=null){duende.anadirXp(xpGanada);}
		
		return xpGanada;
		
	}
	
	/**
	*Descripción: Anade dinero al atributo dinero.<br>
	*@return Un int que indica la suma de todo el dinero recolectado (A veces con ayuda del duende).
	*/
	public int anadirDinero(){
		
		int dinero=1;
		
		if(duende!=null){dinero=duende.darMultiplicadorDinero();}
		this.dinero+=dinero;
		
		return dinero;
		
	}
	
	/**
	*Descripción: Anade dinero al atributo dinero a partir de los guerreros y hechiceras.<br>
	*pre: El ArrayList de guerrreros no debe tener elementos nulos.<br>
	*@param active Dice si el usuario esta activando esta opcion.
	*@return Un int que indica la suma de todo el dinero recolectado combinando guerreros y hechiceras.
	*@throws NullPointerException Si un guerrero esta nulo.
	*/
	public int anadirDinero(boolean active){
		
		double dinero=0;
		
		if(active){
			
			for(int i=0; i<guerreros.size(); i++){dinero+=guerreros.get(i).dineroRecogido();}
			for(Hechicera hechicera: hechiceras) {
				if(hechicera!=null){dinero+=hechicera.dineroRecogido();}
			}
			this.dinero+=dinero;
		}
		
		int dineroReal=(int)dinero;
		
		return dineroReal;
		
	}
	
	//Mostrar
	/**
	*Descripción: Muestra todos los datos de todas las unidades de la partida.<br>
	*pre: El ArrayList de guerrreros no debe tener elementos nulos.<br>
	*@return Un String que son los datos de las unidades en partida.
	*@throws NullPointerException Si un guerrero esta nulo.
	*/
	public String mostrarDatos(){
		
		String datos="Dinero: $"+dinero;
		
		if(duende!=null){
			datos+="\nDuende:";
			datos+="\n"+duende.datos();
		}
		
		if(hechiceras[0]!=null){datos+="\nHechiceras:";}
		for(int i=0; i<hechiceras.length;i++){
			if(hechiceras[i]!=null){datos+="\n"+i+"."+hechiceras[i].datos();}
		}
		
		datos+="\nGuerreros:";
		for(int i=0;i<guerreros.size();i++){datos+="\n"+i+"."+guerreros.get(i).datos();}
		
		return datos;
		
	}
	
	/**
	*Descripción: Muestra un menu de guerreros.<br>
	*pre: El ArrayList de guerrreros no debe tener elementos nulos.<br>
	*@return Un String que es un menu de los guerreros.
	*@throws NullPointerException Si un guerrero esta nulo.
	*/
	public String mostrarMenuGuerreros(){
		
		String menuGuerreros="";
		
		for(int i=0; i<guerreros.size(); i++){menuGuerreros+="\n"+i+"."+guerreros.get(i).darNombre()+" ["+((guerreros.get(i).darDano())*Guerrero.VALOR_XP)+"xp]					XP: "+guerreros.get(i).darXp();}
		
		return menuGuerreros;
		
	}
	
	/**
	*Descripción: Muestra un menu de hechiceras.<br>
	*@return Un String que es un menu de las hechiceras. Si no existe dice que no he adquirido la unidad.
	*/
	public String mostrarMenuHechiceras(){
		
		String menuHechiceras="No has adquirido la unidad!";
		
		if(hechiceras[0]!=null){menuHechiceras="";}
		for(int i=0; i<hechiceras.length; i++){
			if(hechiceras[i]!=null){menuHechiceras+="\n"+i+"."+hechiceras[i].darNombre()+" ["+((hechiceras[i].calcularNivel())*Hechicera.VALOR_XP)+"xp]					XP: "+hechiceras[i].darXp();}
		}
		
		return menuHechiceras;
		
	}
	
	/**
	*Descripción: Muestra un menu del Duende.<br>
	*@return Un String que es un menu del duende. Si no existe no lo muestra.
	*/
	public String mostrarMenuDuende(){
		
		String menuDuende="";
		
		if(duende!=null) {menuDuende="["+((duende.darMultiplicadorDinero())*Duende.VALOR_XP)+"xp]					XP: "+duende.darXp();}
		
		return menuDuende;
		
	}
	
	/**
	*Descripción: Muestra un menu de ayuda.<br>
	*@return Un String que es un menu que indica todo sobre el juego.
	*/
	public String mostrarAyuda(){
		
		String ayuda="";
		
		ayuda+="\n==================================================================================================";
		ayuda+="\nAyuda";
		ayuda+="\n~~~~~";
		ayuda+="\n-Como Jugar:";
		ayuda+="\n Seleciona las teclas que te indica el menu para moverte por la interfaz. Para Empezar a pelear";
		ayuda+="\n contra los monstruos de TapLandia debes meterte en la opcion \"Batallar\". Una vez que estes  ";
		ayuda+="\n dentro, oprime la tecla \"Enter\" para empezar a pelear (Si prefieres que tus otras dos unidades";
		ayuda+="\n recojan dinero oprime \\\"1\\\"+\\\"Enter\\\"). Cada vez que peleas consigues \\\"Xp\\\"(Para";
		ayuda+="\n mejorar tus unidades) y \"Dinero\"(Para comprar unidades). Este es un Tycoon donde tu meta es";
		ayuda+="\n aumentar tus unidades y tenerlas mejor que las unidades de los otros reinos.";
		ayuda+="\n ";
		ayuda+="\n-Unidades:";
		ayuda+="\n *Guerrero: Los guerreros son los que pelean contra los monstruos. Cada que los subes de nivel";
		ayuda+="\n  aumentan la \"Xp\" en 1. Puedes tener cuantos guerreros desees.";
		ayuda+="\n *Hechicera: Ellas aumentan la fuerza de los guerreros con sus encantamientos, por lo que ";
		ayuda+="\n  multiplican la \"Xp\" obtenida por los guerreros. Al subir su nivel aumenta un 0.5 el ";
		ayuda+="\n  multiplicador. Tan solo puedes tener 5 hechiceras.";
		ayuda+="\n *Duende: Este avaro ser recolecta con mayor efectividad el dinero que sueltan los monstruos al";
		ayuda+="\n  morir. Si se aumenta su nivel, tambien aumenta su capacidad para recoger dinero en 1. Al ser ";
		ayuda+="\n  una criatura tan rara solo puedes poseer 1.";
		ayuda+="\n ";
		ayuda+="\n-Edificaciones:";
		ayuda+="\n *Base: Donde tus unidades descansan antes de la batalla. Aqui puedes visualizar todos los datos ";
		ayuda+="\n  de tus unidades";
		ayuda+="\n *Santuario: Donde tus unidades le rezan al dios \"Johanio\" para aumentar sus habilidades en batalla.";
		ayuda+="\n  Aqui es donde se suben de nivel las unidades.";
		ayuda+="\n *Cuartel: Donde las unidades se entrenan para algun dia dedicarse a las artes belicas. Aqui puedes";
		ayuda+="\n  comprar unidades.";
		ayuda+="\n==================================================================================================";
		
		
		return ayuda;
		
	}
	
	//Dar
	/**
	*Descripción: Retorna el dinero de la Partida.<br>
	*@return Un int que es el dinero de la Partida.
	*/
	public int darDinero(){
		
		return dinero;
		
	}
	
}
