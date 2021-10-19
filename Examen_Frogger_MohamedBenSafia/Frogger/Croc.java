public  class Croc  extends MovingGameElement{
	
	public static int speedCroc =3;
	
	 public Croc(int pos_x, int pos_y) {
	        
	        super(pos_x, pos_y, speedCroc);
	    }
	    
	    public static String getPathToImage(){
	        return "croc.png";
	    }
	    
	    public String getType(){
	        return "croc";
	    }
	    


}
