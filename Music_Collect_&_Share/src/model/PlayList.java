package model;
/**
*@author DanielRamirez<br>
*/
public abstract class PlayList {
	
	//Attributes
	private final int amountSongs = 30;//maximum number of songs allowed to add to the playlist
	private String name;//PlayList name
    private int hours;//Duration of the songs contained in the playlist given in hours
    private int minutes;//Duration of the songs contained in the playlist given in minutes
    private int seconds;//Duration of the songs contained in the playlist given in seconds
    
    //Relations
    private Genre[] genres;//gender arrangement of genres
    private Song[] songs;//song arrangement of songs
//========================================================================= 
    /**
	*PlayList class construct method<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	
	
	*@param name Is a string with the class name<br>
	*/
    public PlayList(String name) {
    	this.name = name;
    	hours = 0;
    	minutes = 0;
    	seconds = 0;
    	genres = new Genre[5];
    	songs = new Song[amountSongs];
    }
//=========================================================================
    
    /**
	*PlayList class construct method without parameters<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*/
    public PlayList() {
    	name = new String();
    	hours = 0;
    	minutes = 0;
    	seconds = 0;
    	genres = new Genre[5];
    	songs = new Song[amountSongs];
    	
    }
//=========================================================================

//Setters and Getters
//=========================================================================
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours += hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes += minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds += seconds;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//======================================================================
    
    /**
	*This method gets the genres of the playList<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	
	
	*@return Return a string with the playList genres<br>
	*/
    public String[] getGenres(){
		String[] genre = new String[5];
		for(int i = 0; i < genres.length; i++){
			if(genres[i] != null){
				genre[i] = genres[i].toString();
			}//End if
		}//End for
		return genre;
	}//End getGenres
//=====================================================================
    
    /**
	*This method set the genres of the playList<br>
	*<b>pre:</b>The gender must exist in the enum category<br>
	*<b>post:</b><br>
	
	
	*@param genre Is the genre of the songs.<br>
	*/
    public void setGenre(String genre){
		boolean set = false;
		for(int i = 0; i < genres.length && !set; i++){
			if(genres[i] != null){
				genres[i] = Genre.valueOf(genre);
				set = true;
			}//End if
		}//End for
	}//End setGenre
//=====================================================================
    
    /**
	*This method adds a song to the playList<br>
	
	
	*<b>pre:</b>the song is different from null and must have been initialized<br>
	*<b>post:</b>the song has been added<br>
	
	
	*@param song Is the song of type Song<br>
	*@return Returns a boolean value, if the value is true the song was added, if the value is false the song was not added<br>
	*/
    public boolean addSong(Song song){
		boolean addS = false;
		for(int i = 0; i < songs.length && !addS; i++){
			if(songs[i] == null){
				songs[i] = song;
				addS = true;
			}//End if
		}//End for
		return addS;
	}//End addSong
//===================================================================    
    
    /**
   	*This method update the genre to the playList<br>
   	
   	
   	*<b>pre:</b><br>
   	*<b>post:</b>the genre was updated<br>
   	
   	
   	*@param genre Is the genre of the song<br>
   	*/
    public void updateGenre(String genre){
		boolean update = false;
		boolean there = false;
		for(int i = 0; i < genres.length && !update; i++){
			if(genres[i] != null){
				if(genres[i] == Genre.valueOf(genre))
					there = true;
			}//End if
			else if(!there){
				genres[i] = Genre.valueOf(genre);
				update = true;
			}//end else if
		}//End for
	}//End updateGenre
//===================================================================
    
    /**
   	*This method update the duration to the playList<br>
   	
   	
   	*<b>pre:</b>integers must be initialized and distinct from a string<br>
   	*<b>post:</b>the total duration of the playList has been updated<br>
   	
   	
   	*@param m Is an integer which represents the duration in minutes. m != " "<br>
   	*@param s Is an integer which represents the duration in seconds. s != " "<br>
   	*/
    public void updateDuration(int m,int s){
		int hours = getHours();
		int minutes = m + getMinutes();
		int seconds = s + getSeconds();
		
		while(seconds >= 60){
			minutes ++;
			seconds -= 60;
		}//End calculate minutes
		while(minutes >= 60){
			hours++;
			minutes -= 60;
		}//End calculate hours
		setSeconds(seconds);
		setMinutes(minutes);
		setHours(hours);
	}//End updateDuration
//===================================================================    
    
    /**
   	*this method shows the information of the playList<br>
   	
   	
   	*<b>pre:</b><br>
   	*<b>post:</b><br>
   	
   	
   	*@return Return the message with the info of the playList<br>
   	*/
    public String showInfo(){

		String[] g = getGenres();
		boolean nmg = false;//No more genres
		String message = "\n**************PlayList**************\n" + 
					 "**Title: " + getName() + "\n";
		if(getHours() > 0)
			message += String.format("**Duration: %02d:%02d:%02d\n",getHours(),getMinutes(),getSeconds());
		else
			message += String.format("**Duration: %02d:%02d:%02d\n",getHours(),getMinutes(),getSeconds());
		
		message += "**Genre: ";
		if(g[0] == null )
			message += "Desconocido\n";
		else{
			for(int i = 0; i < g.length && !nmg; i++){
				if(g[i] != null)
					message += g[i].toString() + "-- ";
				else
					nmg = true;
			}//End for
			message += "\n";
		}//End else
			return message;
	}//End toShowInfo
    
}//End PlayList
