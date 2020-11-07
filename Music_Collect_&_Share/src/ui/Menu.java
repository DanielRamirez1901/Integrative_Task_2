package ui;
import model.MCS;
import java.util.Scanner;

public class Menu{
	
	//Main menu
	private final int ADD_USERS = 1;
	private final int SEE_USERS = 2;
	private final int ADD_SONG = 3;
	private final int SEE_SONGS = 4;
	private final int ADD_PLAYLIST = 5;
	private final int ADD_SONG_TO_PLAYLIST = 6;
	private final int SEE_PLAYLIST = 7;
	private final int RATE_PLAYLIST = 8;
	private final int EXIT = 9;
	
	//Choose playlist
	private final int PUBLIC_PL = 1;
	private final int RESTRICTED_PL = 2;
	private final int PRIVATE_PL = 3;
	
	private Scanner sc = new Scanner(System.in);
	private MCS mcs;

	public Menu(){
		mcs = new MCS();
	}//End constructor

	public void showLogo(){
		String logo =   "((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
					    "((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((  ((((((((*  ((((((((,      (((((((     ((((\n" +
						"((((   (((((((   ((((((   /((((((((((.  ((((((((\n" +
						"((((    ((((((   (((((*  ((((((((((((  /((((((((\n" +
						"((((    /((((*   (((((*  ((((((((((((   ((((((((\n" +
						"((((  (  ((((    (((((.  ((((((((((((/  *(((((((\n" +
						"((((  (. ,((*    *((((.  (((((((((((((/  .((((((\n" +
						"((((  ((  ((  (  ,((((.  (((((((((((((((   (((((\n" +
						"((((  ((* ,, .(  (((((.  ((((((((((((((((   ((((\n" +
						"((((  (((    ((  (((((,  (((((((((((((((((   (((\n" +
						"((((  (((   ,((  (((((/  ((((((((((((((((((  /((\n" +
						"((((  /((   (((  ((((((  ,(((((((((((((((((  *((\n" +
						"((((  /((((((((  ((((((/  .(((((((((((((((   (((\n" +
						"((((  /((((((((  ((((((((       ((((*(.(*   ((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"                    .#//////#.\n"+                                               
						"               .###/         /###.\n"+
						"            ##                     ##\n"+
						"          #*                         /#\n"+         
						"        .#       ///////////////       #(\n"+        
						"        #     /////////////////////     #,\n"+       
						"       /#   *///////////////////////,   ##\n"+     
						"     ,///////////////////////////////*//////\n"+     
						"     /////////////////////......////////////\n"+    
						"     //////..........................,//////\n"+   
						"     //////........((.......*(*......,//////\n"+  
						"     //////..........................,//////\n"+ 
						"      *///, .......,/......../....... ,////\n"+
						"              .......//,..*/*......\n"+
						"                  .............\n";              
		System.out.println(logo);
		sc.nextLine();
		System.out.println("\n==================Bienvenido a MCS==================\n");
		System.out.println("\nPress Enter\n");
		sc.nextLine();
	}//End showLogo.

	
	public void showMenu(){
		System.out.println("Porfavor elija una opcion a seguir");
		System.out.println("1 = Si desea agregar un usuario.");
		System.out.println("2 = Si desea ver los usuarios existentes.");
		System.out.println("3 = Si desea agregar una cancion a la pool.");
		System.out.println("4 = Si desea ver las canciones agregadas a la pool.");
		System.out.println("5 = Si desea crear una playlist.");
		System.out.println("6 = Si desea agregar una cancion a la playlist");
		System.out.println("7 = Si desea ver las playlist existentes.");
		System.out.println("8 = Si desea calificar la playlist publica.");
		System.out.println("9 = Si desea salir de MCS.");
		System.out.println("\nIngrese el numero relacionado a la opcion a seguir");

	}//End showMenu

	public int readOption(){
		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}//End readOption.

	public void readUsersData(){
		
		System.out.print("\nIngrese el nombre de usuario");
		System.out.println("(Este nombre se guardara sin espacios)");
		String name = sc.nextLine();
		System.out.println("El nombre de usuario sin espacios es [ " + mcs.removeSpaces(name) + " ]");
		System.out.println("Ingrese la contraseña: ");
		String password = sc.nextLine();
		System.out.println("Ingrese su edad: ");
		byte age = sc.nextByte();sc.nextLine();
		System.out.println("\n" + mcs.addUser(name, age, password));
		System.out.println("\nPress Enter\n");
		sc.nextLine();
	}//End readUsersData

	
	public void readSongData(){
		
		String msg = new String();
		System.out.println("\nIngrese el nombre del usuario que creara la cancion: ");
		String user = sc.nextLine();
		System.out.println("Ingrese el titulo de la cancion: ");
		String title = sc.nextLine();
		System.out.println("Ingrese el nombre del artista o banda de la cancion: ");
		String artistName = sc.nextLine();
		System.out.println("Ingrese la fecha de lanzamiento de la cancion: ");
		String date = sc.nextLine();
		System.out.println("Ingrese los minutos que dura la cancion: ");
		int minutes = sc.nextInt();sc.nextLine();
		System.out.println("Ingrese los segundos que dura la cancion: ");
		int seconds = sc.nextInt();sc.nextLine();
		System.out.println("Mostrando los generos musicales posibles...");
		System.out.println(mcs.displayGenres());
		System.out.println("Ingrese el numero que corresponde al genero: ");
		int num = sc.nextInt();sc.nextLine();
		msg = mcs.addSong(user,title,artistName,date,minutes,seconds,num);
		System.out.println("\n" + msg);
		System.out.println("\nPress Enter\n");

	}//End readSongData

	
	public void readPlayListData(){
		
		String message = new String();
		String proprietor = new String();
		String[] proprietors = new String[5];
		System.out.print("\nIngrese el nombre de la playlist: ");
		String name = sc.nextLine();
		System.out.println("Tipos de playlist:");
		System.out.println("\n(1)Playlist publica.\n(2)Playlist restringida.\n(3)Playlist privada.");
		System.out.print("Ingrese el tipo de playlist que creara: ");
		int opt = sc.nextInt();
		
		while(opt < 1 || opt > 3){
			System.out.println("\nOpcion erronea!");
			System.out.print("Ingrese el tipo de playlist que creara: ");
		    opt = sc.nextInt();
		}//End while
		sc.nextLine();
		
		switch(opt){
			case PUBLIC_PL:
				
				message = mcs.addPlayList(name);
				break;
				
			case RESTRICTED_PL:
				
				boolean end = false;
				int i = 0;
				opt = 0;
				
				while(!end || i >= 5){
					System.out.print("\n[1] Agregar propietario(maximo 5).\n[Cualquier otro numero] Dejar de agregar propietarios\n");
					System.out.print("Ingrese la opcion: ");
					opt = sc.nextInt();
					sc.nextLine();
					if(opt == 1){
						System.out.print("Ingresa el nombre del propietario (sin espacios): ");
						proprietors[i] = sc.nextLine();
						i++;
					}//End if
					
					else
						end = true;
				}//End while
				
				message = mcs.addPlayList(name,proprietors);
				break;
				
			case PRIVATE_PL:
				
				System.out.print("\nIngresa el nombre del propietario (sin espacios): ");
				proprietor = sc.nextLine();
				message = mcs.addPlayList(name,proprietor);
				break;
				
		}//End switch
		
		System.out.println("\n" + message);
		sc.nextLine();
		
	}//End readPlayListData.

	
	public void rateList(){
		
		System.out.println("Listas publicas:");
		System.out.println(mcs.displayPublicPlayList());
		
		System.out.print("Ingrese el numero de la lista a calificar: ");
		int opt = sc.nextInt();
		sc.nextLine();
		
		while(opt < 1 || opt > mcs.quantityPublicPlaylist()){
			System.out.println("Opcion erronea!!");
			System.out.print("Ingrese el numero de la lista a calificar: ");
		    opt = sc.nextInt();
			sc.nextLine();
		}//End while
		
		System.out.print("Ingrese una calificacion del 1 al 5 para la playList: ");
		double score = sc.nextInt();
		sc.nextLine();
		
		while( score < 1 || score > 5){
			System.out.println("Calificacion erronea!!");
			System.out.print("Ingrese una calificacion del 1 al 5 para la playList: ");
			score = sc.nextInt();
			sc.nextLine();
		}//End while
		
		System.out.println(mcs.qualifyPlayList(opt, score));
		System.out.println("\nPress Enter\n");

	}//End rateList

	
	public void addSong(){
		System.out.println("\nPlaylist creadas:");
		System.out.println(mcs.displayPlayListNames());
		
		System.out.print("Ingrese el numero de la playlist para agregar una cancion: ");
		int playlistIndex = sc.nextInt();sc.nextLine();
		
		while( playlistIndex < 1 && playlistIndex > mcs.quantityPlaylist()){
			System.out.println("Opcion incorrecta!!");
			System.out.print("Ingrese el numero de la playlist para agregar una cancion: ");
		    playlistIndex = sc.nextInt();sc.nextLine();
		}//End while
		
		System.out.println("\nCanciones creadas:");
		System.out.print(mcs.displaySongsNames());
		
		System.out.print("\nIngrese el numero de la cancion para agregarla: ");
		int songIndex = sc.nextInt();sc.nextLine();
		
		while( songIndex < 1 && songIndex > mcs.quantityPlaylist()){
			System.out.println("Opcion incorrecta!!");
			System.out.print("Ingrese el numero de la cancion para agregarla: ");
		    songIndex = sc.nextInt();sc.nextLine();

		}//End while
		
		System.out.println("\n" + mcs.addSongToPlayList(songIndex,playlistIndex));
		System.out.println("\nPress Enter\n");

	}//End addSong.

	
	public void doOperation(int option){
		switch(option){
		
			case ADD_USERS:
				
				readUsersData();
				break;
				
			case SEE_USERS:
				
				if(!mcs.isNullUser())
					System.out.println(mcs.displayUsers());
				else
					System.out.println("\nAun no se ha creado ningun usuario");
					sc.nextLine();
				break;
				
			case ADD_SONG:
				
				if(!mcs.isNullUser())
					readSongData();
				else
					System.out.println("\nAun no se ha creado ningun usuario.\nCrea un usuario primero.");
					sc.nextLine();
				break;
				
			case SEE_SONGS:
				
				if(!mcs.isNullPool())
					System.out.println(mcs.displayPoolSongs());
				else
					System.out.println("\nNo se han añadido canciones");
					sc.nextLine();
				break;
				
			case ADD_PLAYLIST:
				
				if(!mcs.isNullUser())
					readPlayListData();
				else
					System.out.println("\nAun no se ha creado ningun usuario.\nCrea un usuario primero.");
					sc.nextLine();
				break;
				
			case ADD_SONG_TO_PLAYLIST:
				
				if(!mcs.isNullPlayList() || !mcs.isNullPool())
					addSong();
				else
					System.out.println("\nNo se han creado canciones ni playlist.");
					sc.nextLine();
				break;
				
			case SEE_PLAYLIST:
				
				if(!mcs.isNullPlayList())
					System.out.println(mcs.displayPlayList());
				else 
					System.out.println("\nNo se han añadido playlist");
					sc.nextLine();
				break;
				
			case RATE_PLAYLIST:
				
				if(!mcs.isNullPublicPlayList())
					rateList();
				else 
					System.out.println("\nNo se ha creado ninguna playlist publica.");
					sc.nextLine();
				break;
				
			case EXIT:
				
				break;
				
		}//End switch
	}//End doOperation

	
	public void startProgram(){
		int opt = 0;
		showLogo();
		do{
			showMenu();
			opt = readOption();
			doOperation(opt);
		}while(opt != 9);//End do while
	}//End startProgram
}//End Menu