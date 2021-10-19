
public class Insect3 extends FixedGameElement {


    public Insect3(int pos_x, int pos_y) {
        
        super(pos_x, pos_y);
    }
    
    public static String getPathToImage(){
        return "insect3.png";
    }
    
    public String getType(){
        return "insect3";
    }
    
    public void triggerAction(Board board){
        board.incScore(1);
    }
}





