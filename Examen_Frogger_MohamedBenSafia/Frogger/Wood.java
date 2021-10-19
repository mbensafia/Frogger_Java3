
public class Wood extends AlternativeGameElement{

	  public Wood(int pos_x, int pos_y) {  
	        super(pos_x, pos_y);
	    }
	    
	    public static String getPathToImage(){
	        return "wood.png";
	    }
	    
	    public String getType(){
	        return "wood";
	    }

		
	    public void triggerAction(Board board){
	        
	    }
	    
}
