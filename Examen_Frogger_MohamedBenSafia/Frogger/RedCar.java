
public class RedCar extends MovingGameElement{

	public static int speedRedCar=5;

	public RedCar(int pos_x, int pos_y) {

		super(pos_x, pos_y, speedRedCar);
	}

	public static String getPathToImage(){
		return "car1.png";
	}

	public String getType(){
		return "car1";
	}


}
