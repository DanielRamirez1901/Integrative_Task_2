package model;
/**
*This class allows to create the Music Collect and Share<br>
*@author DanielRamirez<br>
*/
public class MCS {
	
	//Constants
    private final static int MAX_USERS = 10;//Constant with the maximum number of users that can be created
    private final static int MAX_SONGS = 30;//Constant with the maximum number of songs that can be created
    private final static int MAX_PLAYLIST = 20;//Constant with the maximum number of playList that can be created
    
    //Attributes
    private User[] nUsers;//Array of users
    private Song[] nSongs;//Array of songs
    private PlayList[] playList;//Array of playList
//=====================================================================  
    
    /**
	* Constructor of the MCS class. <br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	*/
    public MCS() {
        nUsers = new User[MAX_USERS];
        nSongs = new Song[MAX_SONGS];
        playList = new PlayList[MAX_PLAYLIST];
    }
//=====================================================================
    
    /**
	* This method adds a new user.<br>
	 
	
	* <b>pre:</b> parameters are initialized. User array is initialized. <br>
	* <b>post:</b> User added successfully or User could not be added. <br>
	 
	
	* @param name Is the user name. name != "", name != null.<br>
	* @param age Is the user age. age &gt; 0 , age &lt; 124 , age != null.<br>
	* @param password Is the user passWord. password != "", password != null.<br>
	* @return Return a message saying that the user was created successfully<br>
	*/
    public String addUser(String name,byte age,String password){
    	
		String message;
		boolean addU = false;
			for(int i = 0; i < nUsers.length && !addU; i++){
				if(nUsers[i] == null){
					nUsers[i] = new User(removeSpaces(name),password,age);
					addU = true;
					message = "Usuario agregado exitosamente";
			}//End for
		}//End if
		
		return	message = "Usuario agregado exitosamente";

	}//End addUser
//=====================================================================    
    
	/**
	*Remove blank spaces of the String <br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@param vName String to remove blank spaces. vName != null.<br>
	*@return Return a string without blank spaces.<br>
	*/
    public String removeSpaces(String vName){
		String rSpaces = new String();
        for(int i = 0; i < vName.length(); i++){
            if(vName.charAt(i) != ' '){
                rSpaces += vName.charAt(i);
            }//End if
        }//End for
		return rSpaces;
	}//End validateString
//=====================================================================
   
    /**
	* Saves the information of the users <br>
	*
	
	* <b>pre:</b> Users array must be initialized.<br>
	* <b>post:</b> information of the users.<br>
	*
	
	* @return Return users information.<br>
	*/
    public String displayUsers(){
		boolean all = false;
		String users = new String();
		for(int i = 0; i < this.nUsers.length && !all; i++){
			if(this.nUsers[i] != null){
				users += this.nUsers[i].infoUser();
			}//End if
			else
				all = true;
		}//End for
		return users;
	}//End displayUsers.
//=====================================================================
    
    /**
	* This method add a new song.<br>
	
	
	* <b>pre:</b> parameters must be initialized. Song list must be initialized. <br>
	* <b>post:</b> Song was successfully added or Song could not be added. <br>
	 
	
	* @param user Is the name of the user who adds the song. user != "", user != null<br>
	* @param title Is the song title. title != "", title != null<br>
	* @param artistName Is the song artist. artistName != "", artistName != null.<br>
	* @param releaseDate Is the song release date. releaseDate != "", releaseDate != null.<br>
	* @param minutes Is the song minutes duration<br>
	* @param seconds Is the song seconds duration<br>
	* @param num Is the number of the song genre. num != "", num != null.<br>
	* @return return the state of the song<br>
	*/
    public String addSong(String user,String title, String artistName, String releaseDate,int minutes,int seconds, int num){
		boolean add = false;
		boolean found = false;
		int in = 0;
		user = removeSpaces(user);
		String msg = "No ha sido posible agregar la cancion";
		for(int i = 0; i < nUsers.length && !found; i++){
			if(nUsers[i] != null){
				if(nUsers[i].getName().equalsIgnoreCase(user)){
					in = i;
					found = true;
				}//End if
			}//End if
		}//End for
		for(int i = 0; i < nSongs.length && !add;i++ ){
			if(nSongs[i] == null){
				nSongs[i] = new Song(title,artistName,releaseDate,minutes,seconds,num);
				nUsers[in].increaseSharedSongs();
				nUsers[in].modifyCategory();
				add = true;
				msg = "Cancion agregada exitosamente";
			}//End if
		}//End for
		return msg;
	}//End addSong
//=====================================================================    
    
	/**
	* Saves the information of the songs<br>
	*
	
	* <b>pre:</b> pool songs array must be initialized.<br>
	* <b>post:</b><br>
	
	
	* @return Return songs information.<br>
	*/
	public String displayPoolSongs(){
		boolean all = false;
		String song = new String();
		for(int i = 0; i < nSongs.length && !all; i++){
			if(nSongs[i] != null){
				song += "\n"+ ( i + 1)+")" + nSongs[i].showSong();
			}//End if
			else
				all = true;
		}//End for
		return song;
	}//End displayPoolSongs
//=====================================================================
	
	/**
	* This method adds a new public playList.<br>
	 
	
	* <b>pre:</b> parameters must be initialized. PlayList array must be initialized.<br>
	* <b>post:</b> PlayList added successfully or playList could not be added.<br>
	
	
	* @param name Is the playList name. name != "", name != null<br>
	* @return return the state of the playList<br>
	*/
	public String addPlayList(String name){
		
		boolean add = false;
		String msg = "No ha sido posible crear la Playlist";
		for(int i = 0; i < playList.length && !add; i++){
			if(playList[i] == null ){
				playList[i] = new PublicPlayList(name,0) {
				};
				msg = "La playlist publica ha sido creada con exito";
				add = true;
			}//End if
		}//End for
		return msg;
	}//End addPlayList
//=====================================================================    
	
	/**
	* This method adds a new restricted playList.<br>
	
	
	* <b>pre:</b> parameters must b initialized. PlayList array must be initialized.<br>
	* <b>post:</b> PlayList successfully added or PlayList could not be added.<br>
	
	
	* @param name Is the playList name. name != "", name != null.<br>
	* @param proprietor Is the playList proprietor. proprietor != "", proprietor != null.<br>
	* @return return the state of the playList<br>
	*/
	public String addPlayList(String name, String[] proprietor){
		
		boolean add = false;
		String msg = "No ha sido posible crear la playlist";
		for(int i = 0; i < playList.length && !add; i++){
			if(playList[i] == null ){
				playList[i] = new RestrictPlayList(name,proprietor);
				msg = "La playlist restringida ha sido creada con exito";
				add = true;
			}//End if
		}//End for
		return msg;
	}//End addPlayList
//=====================================================================	
	
	/**
	* This method adds a new private playList.<br>
	 
	 
	* <b>pre:</b> parameters must be initialized. PlayList array must be initialized.<br>
	* <b>post:</b> The playList successfully added or the playList could not be added.<br>
	
	
	* @param name Is the playList name. name != "", name != null<br>
	* @param proprietor Is the playList proprietor. proprietor != "", proprietor != null.<br>
	* @return return the state of the playList<br>
	*/
	public String addPlayList(String name, String proprietor){
		boolean add = false;
		String msg = "No ha sido posible crear la playlist";
		for(int i = 0; i < playList.length && !add; i++){
			if(playList[i] == null ){
				playList[i] = new PrivatePlayList(name, proprietor);
				msg = "La playlist privada ha sido creada con exito";
				add = true;
			}//End if
		}//End for
		return msg;
	}//End addPlayList2
//=====================================================================	
	
	/**
	* This method adds a song to a playList.<br>
	
	
	* <b>pre:</b> parameters must be initialized. Song array must be initialized. PlayList array must be initialized.<br>
	* <b>post:</b> Song successfully added to playList or Song could not be added to playList <br>
	 
	
	* @param songIn Is the playList proprietors. songIn != null, sonIn != " "<br>
	* @param playListIn Is the playList proprietors<br>
	* @return return the state of the song<br>
	*/
	public String addSongToPlayList(int songIn,int playListIn){
		
		String message = "No ha sido posible agregar la cancion a la playlist.No queda espacio en la playList";
		boolean addSong = playList[playListIn-1].addSong(nSongs[songIn-1]);
		
		if(addSong){
			playList[playListIn-1].updateGenre(nSongs[songIn-1].getGenre());
			playList[playListIn-1].updateDuration(nSongs[songIn-1].getMinutes(),nSongs[songIn-1].getSeconds());
			message = "Se ha agregado la cancion a la playList";
		}//End if
		
		return message;
	}//End addSongToPlayList.
//=====================================================================	
	
	/**
	* Saves the information of the playList <br>
	 
	
	* <b>pre:</b> PlayList array is initialized.<br>
	* <b>post:</b> info of the users.<br>
	 
	
	* @return Return the playList information.<br>
	*/
	public String displayPlayList(){
		
		boolean allPlayList = false;
		String message = new String();
		
		for(int i = 0; i < playList.length && !allPlayList; i++ ){
			if(playList[i] != null)
				message += playList[i].showInfo() + "\n";
			else
				allPlayList = true;
		}//End for
		
		return message;
	}//End displayPlayList
//=====================================================================	
	
	/**
	* Saves the information of the public playList<br>
	 
	
	* <b>pre:</b> public playList have to exist.<br>
	* <b>post:</b><br>
	 
	
	* @return Return the names of the public playList.<br>
	*/
	public String displayPublicPlayList(){
		
		String pList = new String();
		int in = 0;
		
		for(int i = 0; i < playList.length; i++){
			
			if(playList[i] instanceof PublicPlayList){
				++in;
				System.out.println("["+in+"]"+playList[i].getName()+".");
			}//End if
			
		}//End for
		
		return pList;
	}//End displayPublicPlayList
//=====================================================================
	
	/**
	* This method rates a public playList.<br>
	
	
	* <b>pre:</b> Parameters must be initialized. Song list must be initialized. PlayList list must be initialized.<br>
	* <b>post:</b> The public playList was rated. <br>
	
	
	* @param in Is the playList proprietors. index != null.<br>
	* @param score Is the playList.  score != null.<br>
	* @return Return the state of the playList<br>
	*/
	public String qualifyPlayList(int in,double score){
		
		boolean updatePl = false;
		String message = "No ha sido posible calificar la playlist";
		int count = 0;
		
		for(int i = 0; i < playList.length && !updatePl; i++){
			
			if(playList[i] != null){
				if(playList[i] instanceof PublicPlayList){
					++count;	
				if(count == in){
						PublicPlayList publicList = (PublicPlayList) playList[i];
						publicList.setScore(score);
						updatePl = true;
						message = "Se ha calificado la playList correctamente";
					}//End if
				}//End if
			}//End if
		}//End for
		
		return message;
	}//End ratePlayList
//=====================================================================
	
	/**
	* This method saves the information of the genres on a String.<br>
	 
	
	* <b>pre:</b> <br>
	* <b>post:</b><br>
	 
	
	* @return Return the genres.<br>
	*/
	public String displayGenres(){
		
		String genres = new String();
		Genre[] gen = Genre.values();
		
		for(Genre genre:gen){
			
				genres += "-" + genre.toString() + ".\n";


		}//End for
		
		return genres;
	}//End displayGenres
//=====================================================================
	
	/**
	* This method saves the names of the songs<br>
	 
	
	* <b>pre:</b> Songs array must be initialized.<br>
	* <b>post:</b><br>
	 
	
	* @return Return the names of the songs.<br>
	*/
	public String displaySongsNames(){
		
		boolean all = false;
		String nameSongs = new String();
		
		for(int i = 0; i < nSongs.length && !all; i++){
			if(nSongs[i] != null)
				nameSongs += "(" + (i+1) + ") " + " Titulo: " + nSongs[i].getTitle() + " - Artista: " + nSongs[i].getNameArtist()+ "\n";
			else
				all = true;
		}//End for
		
		return nameSongs;
	}//End displaySongsNames
//=====================================================================
	
	/**
	* This method saves the names of the playList on a String.<br>
	 
	
	* <b>pre:</b> playList array must be initialized.<br>
	* <b>post:</b><br>
	 
	
	* @return Return the names of the playList.<br>
	*/
	public String displayPlayListNames(){
		
		boolean all = false;
		String plNames = new String();
		
		for(int i = 0; i < playList.length && !all; i++){
			if(playList[i] != null)
				plNames += "(" + (i+1) + ") " + playList[i].getName() + "\n";
			else
				all = true;
		}//End for
		return plNames;
	}//End displayPlayListNames
//=====================================================================	
	
	/**
	* Counts the quantity of playList.<br>
	
	 
	* <b>pre:</b> playList array must be initialized.<br>
	* <b>post:</b> amount of playList.<br>
	 
	
	* @return Return the quantity of playList<br>
	*/
	public int quantityPlaylist(){
		
		boolean all = false;
		int quantity = 0;
		
		for(int i = 0; i < playList.length && !all; i++ ){
			if(playList[i] != null)
				quantity++;
			else
				all = true;
		}//End for
		
		return quantity;
	}//End amountPlaylist
//=====================================================================
	
	/**
	* Counts the quantity of public playLists.<br>
	 
	
	* <b>pre:</b>PlayList array must be initialized.<br>
	* <b>post:</b> quantity of public playLists.<br>
	 
	
	* @return Return the amount of public playList<br>
	*/
	public int quantityPublicPlaylist(){
		
		boolean all = false;
		int quantity = 0;
		
		for(int i = 0; i < playList.length && !all; i++ ){
			if(playList[i] instanceof PublicPlayList)
				quantity++;
			else
				all = true;
		}//End for
		
		return quantity;
	}//End amountPlaylist
//=====================================================================
	
	/**
	* Counts the quantity of songs.<br>
	
	
	* <b>pre:</b> Pool of songs is initialized.<br>
	* <b>post:</b> quantity of songs.<br>
	
	
	* @return Return the quantity of songs<br>
	*/
	public int quantitySongs(){
		
		boolean all = false;
		int quantity = 0;
		
		for(int i = 0; i < nSongs.length && !all; i++ ){
			if(nSongs[i] != null)
				quantity++;
			else
				all = true;
		}//End for
		return quantity;
	}//End amountSongs
//=====================================================================	
	
	/**
	* Counts the amount of users.<br>
	
	
	* <b>pre:</b> <br>
	* <b>post:</b><br>
	
	
	* @return Return the amount of users<br>
	*/
	public int amountUsers(){
		boolean all = false;
		int amount = 0;
		for(int i = 0; i < nUsers.length && !all; i++ ){
			if(nUsers[i] != null)
				amount++;
			else
				all = true;
		}//End for
		return amount;
	}//End amountSongs
//=====================================================================
	
	/**
	*This method check is the public playList is null<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a boolean value<br>
	*/
	public boolean isNullPublicPlayList(){
		boolean isnull = true;
		for(int i = 0; i < playList.length && isnull; i++){
			if(playList[i] instanceof PublicPlayList){
				isnull = false;
			}//End if
		}//End for
		return isnull;
	}//End isNullPlayList
//=====================================================================
	
	/**
	*This method check is the playList is null<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a boolean value<br>
	*/
	public boolean isNullPlayList(){
		boolean isnull = false;
		if(playList[0] == null )
			isnull = true;
		return isnull;
	}//End isNullPlayList
//=====================================================================
	
	/**
	*This method check is the users is null<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a boolean value<br>
	*/
	public boolean isNullUser(){
		boolean isnull = false;
		if(nUsers[0] == null )
			isnull = true;
		return isnull;
	}//End isNullUser
//=====================================================================
	
	/**
	*This method check is the pool song is null<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a boolean value<br>
	*/
	public boolean isNullPool(){
		boolean isnull = false;
		if(nSongs[0] == null )
			isnull = true;
		return isnull;
	}//End isNullPool
}
