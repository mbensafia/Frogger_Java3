
public class Bush extends FixedGameElement {
	
	public Bush(int pos_x, int pos_y) {  
        super(pos_x, pos_y);
    }
    
    public static String getPathToImage(){
        return "bush.png";
    }
    
    public String getType(){
        return "bush";
    }


	public void triggerAction(Board board) {
		// Aucune Action en particulier
		
	}

}
