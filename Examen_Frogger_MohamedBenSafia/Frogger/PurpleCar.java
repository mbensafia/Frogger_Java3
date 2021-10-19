
public  class PurpleCar extends MovingGameElement{
	
	public  static int purpleCarSpeed= 4;
	
	
	public PurpleCar(int pos_x, int pos_y) {
	        
	        super(pos_x, pos_y, purpleCarSpeed);
	    }
	    
	    public static String getPathToImage(){
	        return "car3.png";
	    }
	    
	    public String getType(){
	        return "car3";
	    }

		
	    

}
