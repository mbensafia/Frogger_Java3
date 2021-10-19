import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DisplayAllTexts  extends Board{
	
	public static  void DisplayGameOverText(Graphics g) {

		//affichage de la page du game over
		g.setColor(Color.red);
		g.setFont(new Font("arial",Font.BOLD,50));
		g.drawString("game over ", B_WIDTH/4, B_HEIGHT/3);
		g.setColor(Color.black);
		g.setFont(new Font("arial",Font.BOLD,30));
		g.drawString("Press Space to replay ", B_WIDTH/5, B_HEIGHT/2);

	}
	
	public static void DisplayGameText(Graphics g) {

		// ci dessous  se trouve tout ce qui est ecriture sur l'interface

		g.setColor(Color.white);// tout le texte sera de couleur blanche
		g.drawString("Lifes : "+numberlifes ,0, 15);// nombre de vies restantes
		g.drawString("Score: "+score ,400, 30);//score du joueur
		g.drawString("Highest score: "+highestscore ,370, 15);//score du joueur
		g.drawString("Level: "+currentlevel ,0, max+35);//niveau actuel


	}

}
