package model;
/**
*This class allows to represent the user of application.<br>
*@author DanielRamirez<br>
*/
public class User {

	//Attributes
	private String name;//save user name
    private String password;//save user password
    private byte age;//save the user's age
    private int sharedSongs;//saves the number of songs shared by the user
    
    //Relations
    private Category category;//Relation with category
    
//================================================================
    /**
    *Constructor method of the user class <br>
    
    
    *<b>pre:</b><br>
	*<b>post:</b><br>
	
	
	*@param name Is the user name. <br>
	*@param password Is the user password
	*@param age Is the user age
    */
    public User(String name, String password, byte age) {
        this.name = name;
        this.password = password;
        this.age = age;
        sharedSongs = 0;
        category = Category.NEWBIE;
    }    
 //===============================================================
    
    /**
    *Constructor method of the user class without parameters <br>
     
     
    *<b>pre:</b><br>
 	*<b>post:</b><br>

     */
    public User() {
    	name = new String();
    	password = new String();
    	age = 0;
    	sharedSongs = 0;
    	category = Category.NEWBIE;
    }
//================================================================
    
//Getters y Setters
//================================================================

    public Category getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(byte age) {
        this.age = age;
    }
    public int getSharedSongs() {
		return sharedSongs;
	}
	public void setSharedSongs(int sharedSongs) {
		this.sharedSongs = sharedSongs;
	}
//=====================================================================
	
	/**
     *This method modifies the user's category <br>
     
     
    *<b>pre:</b><br>
 	*<b>post:</b>the user's category has been modified<br>
    */
	public void modifyCategory(){
    	
		if(getSharedSongs() == 3)
			category = Category.LITTLE_CONTRIBUTOR;
		else if(getSharedSongs() == 10)
			category = Category.MILD_CONTRIBUTOR;
		else if(getSharedSongs() == 30)
			category = Category.STAR_CONTRIBUTOR;
	}//End modifyCategory
//=============================================================
	
	/**
     *This method counts the number of shared songs <br>
     
     
    *<b>pre:</b><br>
 	*<b>post:</b><br>
    */
	public void increaseSharedSongs() {
		sharedSongs++;
	}
 //===========================================================
	
	/**
     *this method prints the user data <br>
     
     
    *<b>pre:</b><br>
 	*<b>post:</b><br>
 	
 	
 	*@return Returns user information through a string
    */
    public String infoUser(){
        String infoUser;
        
        infoUser = "-------------------------------------------------------";
        infoUser += "\n*************  User **************";
        infoUser+= "\n**  UserName: "+getName();
        infoUser+= "\n**  Age: " +getAge();
        infoUser+= "\n**  Category: "+getCategory();
        infoUser += "\n***********************************";
    return infoUser;
    }
}
