
package model;
/**
*This class allows to create a public playList <br>
*@author DanielRamirez<br>
*/

public abstract class PublicPlayList extends PlayList{
	
	//Attributes
	private double score;//save the user's rating to the playList
 
//===============================================================
	/**
	*Constructor method of the public playList class<br>
	
	
	*<b>pre: </b>the playList class must have been initialized<br>
	*<b>post: </b>The public playList has been created<br>
	
	
	*@param name Is the name of the playList. name != " ", name != null<br>
	*@param score Is the rate of the playList. score != " ", score != null<br>
	*/
	public PublicPlayList(String name, double score) {
		super(name);
		this.score = score;
	}
//===============================================================
	
	/**
	*Constructor method of the public playList class without parameters<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*/
	public PublicPlayList() {
		super();
		score = 0;
	}
//===============================================================	
	
//Setters and Getters
//===============================================================
	public double getScore(){
		return score;
	}//End getRate
	public void setScore(double scoreX){
		score = averageScore(scoreX);
	}//End setRate
//===============================================================
	
	/**
	*this method calculates the average grade from the public playList<br>
	
	
	*<b>pre: </b><br>
	*<b>post: </b>the average of the playList has been obtained<br>
	
	
	*@param scoreX Is the rate of the playList. scoreX != " ", scoreX != null
	*
	*/
	public double averageScore(double scoreX){
		double score = 0;
		if(getScore() > 0)
			score = (scoreX + getScore())/2;
		else
			score = scoreX;
		
		return score;
	}//End calculateQualification
//==============================================================
	
	/**
   	*this method shows the information of the public playList<br>
   	
   	
   	*<b>pre:</b>The playList class must have been initialized with all her attributes<br>
   	*<b>post:</b><br>
   	
   	
   	*@return Return the message with the info of the playList<br>
   	*/
	@Override
	public String showInfo(){
		String message = super.showInfo() + "**Score: " + getScore() + "\n";
		return message;
	}//End toString
}
