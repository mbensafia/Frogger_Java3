
public class BlueCar extends MovingGameElement{

	public static int speedBlueCar=10;

	public BlueCar(int pos_x, int pos_y) {
	        
	        super(pos_x, pos_y, speedBlueCar);
	    }
	    
	    public static String getPathToImage(){
	        return "car2.png";
	    }
	    
	    public String getType(){
	        return "car2";
	    }
	   
	    

}
