
public class OrangeCar extends MovingGameElement{
	
	public static int orangeCarSpeed=10;
	
	public OrangeCar(int pos_x, int pos_y) {
	        
	        super(pos_x, pos_y, orangeCarSpeed);
	    }
	    
	    public static String getPathToImage(){
	        return "car4.png";
	    }
	    
	    public String getType(){
	        return "car4";
	    }

	
		

		
	   

}
