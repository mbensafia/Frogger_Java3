
public class Pill extends FixedGameElement {


    public Pill(int pos_x, int pos_y) {
        
        super(pos_x, pos_y);
    }
    
    public static String getPathToImage(){
        return "pill.png";
    }
    
    public String getType(){
        return "pill";
    }
    
    public void triggerAction(Board board){
    	   board.incScore(1);
    }
}


