package model;
/**
*This class allows to create a Private playList<br>
*@author DanielRamirez<br>
*/
public class PrivatePlayList extends PlayList{
	
	//Attributes
	private String proprietor;//is the name of the playList owner
    
//======================================================================	
	
	/**
	*Constructor method of the private playList class<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	
	
	*@param name Is the PlayList name. name != "", name != null<br>
	*@param proprietor Is the proprietor of the private playList. proprietor != "" ,  proprietor != null<br>
	*/
	public PrivatePlayList(String name, String proprietor) {
		super (name);
		this.proprietor = proprietor;
	}
//======================================================================
	
	/**
	*Constructor method of the private playList class without parameters<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*/
	public PrivatePlayList() {
		super();
		proprietor = new String();
	}
//======================================================================
	
//Setters and Getters
//=====================================================================
	public void setUser(String user){
		proprietor = user;
	}//End setUser
	
	public String getUser(){
		return proprietor;
	}//End getUser
//====================================================================	
	
	/**
   	*this method shows the information of the private playList<br>
   	
   	
   	*<b>pre:</b>The playList class must have been initialized with all her attributes<br>
   	*<b>post:</b><br>
   	
   	
   	*@return Return the message with the info of the playList<br>
   	*/
    @Override
    public String showInfo(){
		String message = super.showInfo() + "**Proprietor: " + getUser() + "\n";
		return message;
	}//End toString
}//End private playList
