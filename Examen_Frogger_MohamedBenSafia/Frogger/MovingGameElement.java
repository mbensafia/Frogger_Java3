
public abstract class MovingGameElement {
	
	private int pos_x;
    private int pos_y;
    private int speed;
    
    
    public MovingGameElement(int pos_x, int pos_y, int speed) {
        
        this.pos_x = pos_x ;
        this.pos_y = pos_y ;
        this.speed = speed;
     
    }
    
    public int getPosX(){
        return pos_x;
    }
    
    public int getPosY(){
        return pos_y;
    }
    public int getSpeed(){
        return speed;
    }
    
    
    public void setPosX(int new_pos){
        pos_x = new_pos;
    }
    
    public void setPosY(int new_pos){
        pos_y = new_pos;
    }
    public void setSpeed(int new_pos){
        pos_y = new_pos;
    }
   
    public abstract String getType();
    
   
    

}
