package model;
/**
*This class allows to create a song<br>
*@author DanielRamirez<br>
*/
public class Song {
	
	//Attributes
    private String title;//song title
    private String nameArtist;//name of the artist of the song
    private String releaseDate;//is the creation date of the song
    private String genre;//is the genre of the song
    private int seconds;//song duration in seconds
    private int minutes;//song duration in minutes
//========================================================================
    
    /**
	*Constructor of the song class. <br>
	*<b>pre:</b> parameters are initialized. <br>
	*<b>post:</b> Song class created. <br>
	*
	*@param tittle Is the song title. title != "", title != null.<br>
	*@param nameArtist Is the artist song name. nameArtist != "", nameArtist != null.<br>
	*@param releaseDate Is the date of the song. releaseDate != "", releaseDate != null.<br>
	*@param minutes Is the duration minutes of the song<br>
	*@param seconds is the duration seconds of the song<br>
	*@param num Is the number associated with the chosen gender. num !=" ", num != null <br>
	*/
    public Song(String title, String nameArtist, String releaseDate, int minutes, int seconds , int num) {
        this.title = title;
        this.nameArtist = nameArtist;
        this.releaseDate = releaseDate;
        this.minutes = minutes;
        this.seconds = seconds;
        
        genre = String.valueOf(Genre.values()[num-1]);
        
    }
//========================================================================
    
    /**
	*Constructor of the song class without parameters. <br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*/
    public Song() {
    	title = new String ();
    	nameArtist = new String();
    	releaseDate = new String();
    	genre = new String();
    	seconds = 0;
    	minutes = 0;	
    }
    
 //Setters and Getters
 //=======================================================================
 
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }
    
    public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
//==================================================================
	
	/**
	* Changes the Duration of the Song. <br>
	* <b>pre:</b>parameters need to be initialized <br>
	* <b>post:</b> Duration has been updated. <br>
	* @param m Minutes of the song. m != " ", m != null<br>
	* @param s Seconds of the song. s != " ", s!= null<br>
	*/
	public void checkDuration(int m, int s){
		while(s >= 60){
			m++;
			s -= 60;
		}//End while
		setMinutes(m);
		setSeconds(s);
	}
	
	/**
     *this method prints the song data <br>
     
     
    *<b>pre:</b><br>
 	*<b>post:</b><br>
 	
 	
 	*@return Returns song information through a string
    */
	public String showSong(){
        String infoSong;
        
        infoSong = "----------------------------------------------";
        infoSong+= "\n**************  Song **************";
        infoSong+= "\n**  Title: "+getTitle();
        infoSong+= "\n**  Artist: "+getNameArtist();
        infoSong+= "\n**  Duration: "+getMinutes() + ":" + getSeconds();
        infoSong+= "\n**  Genre: "+getGenre();
        
        return infoSong;
    }
}

