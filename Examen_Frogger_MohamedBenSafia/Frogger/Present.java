
public class Present extends AlternativeGameElement{
	
public Present(int pos_x, int pos_y) {
        
        super(pos_x, pos_y);
    }
    
    public static String getPathToImage(){
        return "present.png";
    }
    
    public String getType(){
        return "present";
    }

	@Override
	public void triggerAction(Board board) {
		// TODO Auto-generated method stub
		
	}
    
   

}
