
public class Insect2 extends FixedGameElement {


    public Insect2(int pos_x, int pos_y) {
        
        super(pos_x, pos_y);
    }
    
    public static String getPathToImage(){
        return "insect2.png";
    }
    
    public String getType(){
        return "insect2";
    }
    
    public void triggerAction(Board board){
        board.incScore(5);
    }
}





