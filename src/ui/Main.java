package ui;
import model.Partida;
import model.Guerrero;
import java.util.Scanner;

/**
*Descripción: La clase Main en el paquete ui.<br>
*@author Esteban Ariza
*/
public class Main {
	
	//Atributos
	private Scanner scanner;
	private Partida partida;
	
	//Starter
	public static void main(String[]args) {
		
		Main m=new Main();
		m.Menu();
		
	}
	
	//Constructor
	/**
	*Descripción: El constructor de la clase Main.<br>
	*/
	public Main(){
		
		init();
		
	}
	
	//Inicializador
	/**
	*Descripción: Inicializa un Scanner, una Partida y un Guerrero en la partida.<br>
	*/
	public void init(){
		
		scanner=new Scanner(System.in);
		
		Guerrero guerrero=new Guerrero("Esteban", 0, 1);
		
		partida=new Partida(guerrero);
		
	}
	
	//Menu
	public void Menu(){
		
		boolean run=true;
		
		while(run){
			
			System.out.print("\n===================\nTapFoes \n~~~~~~~ \n1.Batallar \n2.Base \n3.Santuario \n4.Cuartel \n5.Ayuda \n6.Salir \n===================\n>");
			
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option){
				
				case 1:
					
					System.out.print("Derrota a los enemigos!						Atacar[ENTER]\n ^ ^\n OuO\n | |");
					boolean runGame=true;
					while(runGame){
						
						boolean recolectanDinero=false;
						
						String tap=scanner.nextLine();
						
						if(tap.equals("0")){
							
							runGame=false;
							
						}
						else{
							
							if(tap.equals("1")){
								
								recolectanDinero=true;
								System.out.print("\n							Dinero[1->ENTER]");
								
							}
							else{
								
								System.out.print("\n+ "+partida.anadirXp()+"xp							Dinero[1->ENTER]");
								
							}
							
							System.out.print("\n+ $"+(partida.anadirDinero()+partida.anadirDinero(recolectanDinero))+"							Salir[0->ENTER]\n>");
							
						}
						
					}
					
				break;
				
				case 2:
					
					System.out.print(partida.mostrarDatos());
					
				break;
				
				case 3:
					
					boolean runSantuario=true;
					while(runSantuario){
						
						System.out.print("\n===================\nSantuario \n~~~~~~~~~ \n Que unidad de tu ejercito deseas subir de nivel? \n1.Guerrero \n2.Hechicera \n3.Duende "+partida.mostrarMenuDuende()+" \n4.Menu \n===================\n>");
						
						int option1=scanner.nextInt();
						scanner.nextLine();
						
						switch(option1){
							
							case 1:
								
								System.out.print(partida.mostrarMenuGuerreros()+"\n>");
								int unidadGuerrero=scanner.nextInt();
								scanner.nextLine();
								
								System.out.print(partida.subirNivelGuerrero(unidadGuerrero));
								
							break;
							
							case 2:
								
								System.out.print(partida.mostrarMenuHechiceras()+"\n>");
								if(!(partida.mostrarMenuHechiceras()).equals("No has adquirido la unidad!")){
									
									int unidadHechicera=scanner.nextInt();
									scanner.nextLine();
								
									System.out.print(partida.subirNivelHechicera(unidadHechicera));
									
								}
								
								
							break;
							
							case 3:
								
								System.out.print(partida.subirNivelDuende());
								
							break;
							
							case 4:
								
								runSantuario=false;
								
							break;
							
						}
						
					}
					
				break;
				
				case 4:
					
					boolean runCuartel=true;
					while(runCuartel){
						
						System.out.print("\n===================\nCuartel							Dinero: $"+partida.darDinero()+"\n~~~~~~~ \n Que unidad deseas reclutar? \n1.Guerrero [$100]\n2.Hechicera [$200]\n3.Duende [$400]\n4.Menu \n===================\n>");
						
						int option2=scanner.nextInt();
						scanner.nextLine();
						
						switch(option2){
							
							case 1:
								
								System.out.print("\nNombre del guerrero\n>");
								String nombreGuerrero=scanner.nextLine();
								
								int ojosGuerrero=preguntarAccesorio(0, 10, "\nOjos del guerrero \n0.\' \'\n1.* *\n2.- -\n3.^ ^\n4.| |\n5.> <\n6.$ $\n7.I I\n8.0-0\n9.- o\n10.O o\n>");
								
								int cabelloGuerrero=preguntarAccesorio(0, 3, "\nCabello del guerrero\n0.Calvo\n1.Copete\n2.Afro\n3.Hongo\n>");
								
								System.out.print(partida.comprarGuerrero(nombreGuerrero, ojosGuerrero, cabelloGuerrero));
								
							break;
							
							case 2:
								
								System.out.print("\nNombre de la hechicera\n>");
								String nombreHechicera=scanner.nextLine();
								
								int ojosHechicera=preguntarAccesorio(0, 10, "\nOjos de la hechicera \n0.\' \'\n1.* *\n2.- -\n3.^ ^\n4.| |\n5.> <\n6.$ $\n7.I I\n8.0-0\n9.- o\n10.O o\n>");
								
								int cabelloHechicera=preguntarAccesorio(0, 2, "\n\\nCabello de la hechicera\n0.Corto\n1.Liso\n2.Ondulado\n>");
								
								int aretesHechicera=preguntarAccesorio(0, 5, "\nAretes de la hechicera\n0.NO\n1.* *\n2.O O\n3.? ?\n4.$ $\n5.; ;\n>");
								
								System.out.print(partida.comprarHechicera(nombreHechicera, ojosHechicera, cabelloHechicera, aretesHechicera));
								
							break;
							
							case 3:
								
								System.out.print("\nNombre del duende\n>");
								String nombreDuende=scanner.nextLine();
								
								int ojosDuende=preguntarAccesorio(0, 10, "\nOjos del duende \n0.\' \'\n1.* *\n2.- -\n3.^ ^\n4.| |\n5.> <\n6.$ $\n7.I I\n8.0-0\n9.- o\n10.O o\n>");
								
								int cabelloDuende=preguntarAccesorio(0, 8, "\nGorro del duende \n0.^\n1.&\n2.!\n3.+\n4.$\n5.*\n6.#\n7.@\n8.O\n>");
								
								int narizDuende=preguntarAccesorio(0, 5, "\nNariz del duende\n0.NO\n1.L\n2.|\n3.o\n4._\n5.v\n>");
								
								System.out.print(partida.comprarDuende(nombreDuende, ojosDuende, cabelloDuende, narizDuende));
								
							break;
							
							case 4:
								
								runCuartel=false;
								
							break;
							
						}
						
					}
					
				break;
				
				case 5:
					
					System.out.print(partida.mostrarAyuda());
					
				break;
				
				case 6:
					
					run=false;
					
				break;
				
				default:
					
					
					
				break;
				
			}
			
		}
		
	}
	
	//Preguntar
	/**
	*Descripción: Pregunta un numero entre un rango que representa un accesorio del avatar.<br>
	*@param rangoInicial El numero donde comienza el rango.
	*@param rangoFinal El numero donde terminaa el rango.
	*@param mensageConsola El mensajje que quiero que salga como un outPut.
	*@return Un int que es el accesorio en cuestion.
	*/
	public int preguntarAccesorio(int rangoInicial, int rangoFinal, String mensageConsola){
		
		boolean run=true;
		int accesorio=0;
		
		System.out.print(mensageConsola);
		
		while(run){
			
			accesorio=scanner.nextInt();
			scanner.nextLine();
			
			if((accesorio>=rangoInicial)&&(accesorio<=rangoFinal)){
				
				run=false;
				
			}
			else{
				
				System.out.print("Digito invalido. Vuelva a intentarlo \n>");
				run=true;
				
			}
			
		}
		
		return accesorio;
		
	}
	
}
