package model;
/**
*This class allows to create a Restrict playList<br>
*@author DanieRamirez<br>
*/
public class RestrictPlayList extends PlayList{
	
	//Attributes
	private String [] proprietors;//The maximum 5 users that the restricted playList can have are accommodated
//=============================================================================
	
	/**
	*Constructor method of the restrict playList class<br>
	
	
	*<b>pre: </b>the playList class must have been initialized<br>
	*<b>post: </b>The restrict playList has been created<br>
	
	
	*@param name Is the name of the playList. name != " ", name != null<br>
	*@param propietors Is the name of the proprietors. proprietors != " ", proprietors != null<br>
	*/
    public RestrictPlayList(String name, String [] proprietors) {
    	super(name);
    	this.proprietors = proprietors;
    }
//=============================================================================
    
    /**
	*Constructor method of the restrict playList class without parameters<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*/
    public RestrictPlayList() {
    	super();
    	proprietors = new String [5];
    }
//=============================================================================
    
//Setters and Getters
//=============================================================================

	public String[] getProprietors() {
		return proprietors;
	}

	public void setProprieters(String[] proprietors) {
		this.proprietors = proprietors;
	}
//=============================================================================
	
	/**
   	*this method shows the information of the restrict playList<br>
   	
   	
   	*<b>pre:</b>The playList class must have been initialized with all her attributes<br>
   	*<b>post:</b><br>
   	
   	
   	*@return Return the message with the info of the playList<br>
   	*/
	@Override
	public String showInfo(){
		String message = super.showInfo() + "**Proprietors: ";
		boolean allProprietors = false;
		String[] owners = getProprietors();
		for(int i = 0; i < owners.length && !allProprietors; i++){
			if(owners[i] != null)
				message += owners[i]+", ";
			else
				allProprietors = true;
		}//End for
		message += "\n";
		return message;
	}//End toString
}
