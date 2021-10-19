
public class Truck  extends MovingGameElement{
	
	public static int speedTruck = 5;

	public Truck(int pos_x, int pos_y) {
	        
	        super(pos_x, pos_y, speedTruck);
	    }
	    
	    public static String getPathToImage(){
	        return "truck.png";
	    }
	    
	    public String getType(){
	        return "truck";
	    }
	    
	   
	    
	    


}
