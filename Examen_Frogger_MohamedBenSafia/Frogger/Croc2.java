public class Croc2  extends MovingGameElement{
	
	public static int speedCroc2 = 3;

	public Croc2(int pos_x, int pos_y) {
	        
	        super(pos_x, pos_y, speedCroc2 );
	    }
	    
	    public static String getPathToImage(){
	        return "croc2.png";
	    }
	    
	    public String getType(){
	        return "croc2";
	    }
	    
	  
	    
	    


}
