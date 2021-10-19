
public class Background extends FixedGameElement{
	
public Background(int pos_x, int pos_y) {
        
        super(pos_x, pos_y);
    }
    
    public static String getPathToImage(){
        return "background.jpeg";
    }
    
    public String getType(){
        return "background";
    }
    
    public void triggerAction(Board board){
        // aucune action en particulier 
    }
}
