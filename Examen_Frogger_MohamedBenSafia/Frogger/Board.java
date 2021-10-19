import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.HashMap;


public class Board extends JPanel implements ActionListener {


	//declaration et initalisation de differentes variables dont nous auront besoin

	// variables qui sont du type "final" et "static" simultanement
	public final static int B_WIDTH = 500;
	public final static int B_HEIGHT = 550;
	public final static int RAND_POS = 20;
	public final static int SIZEDRAW = 50;
	public final static int centralinsect_pos = 250;
	public final static int max = 500;

	// variables qui sont du type  "static" 

	public static int coinCounter = 3;
	public static int insectCounter = 1;
	public static int pos_x;
	public static int pos_y;
	public static int DOT_SIZE = 10;
	public static int score;
	public static int currentlevel = 1;
	public static int numberlifes = 5;
	public static int highestscore;

	// variables qui sont du type "final" 

	public final int DELAY = 140;
	public final int SPEED = 400;
	public final int posy_croc = 200;



	// declaration de booleens pour chaque directions, ils sont initalisés a faux 
	public static boolean leftDirection = false;
	public static boolean rightDirection = false;
	public static boolean upDirection = false;
	public static boolean downDirection = false;

	//declaration d'un booleeen qui permet de savoir si le jeu est en cours
	public boolean inGame = true;
	public boolean pillactivated = false;


	//declaration des differentes images  et timer dont nous auront besoin pour ce projet
	public Timer timer;
	public Image head;
	public static Image background;


	//declaration de variables essentielles au bon fonctionnement du jeu


	public int ImageCounter= 1 ;
	public int CrocCounter1= 1 ;
	public int CrocCounter2= 1 ;
	public int pos_diff = 25;
	public int min_posx = 40;
	public int speedcroc = 0;
	public int speedcroc2 = 500;
	public int speedcar1;
	public int speedcar2;
	public int speedcar3;
	public int speedcar4;
	public int speedtruck;
	public int currscore;
	public int void_x = -1*B_WIDTH;
	public int void_y = -1*B_HEIGHT;
	public int movingelementcounter = 1;


	// creation des listes qui vont par la suite contenir les images

	public static ArrayList<FixedGameElement> fixedGameElementList ;
	static HashMap<String, ImageIcon> fixedGameElementImageMap ;

	public static ArrayList<AlternativeGameElement> alternativegameElementList;
	static HashMap<String, ImageIcon> alternativeGameElementImageMap;

	public static ArrayList<HeadFixedElement> headFixedElementList;
	static HashMap<String, ImageIcon> headFixedElementImageMap;

	public static ArrayList<MovingGameElement> movingGameElementList;
	static HashMap<String, ImageIcon> movingGameElementImageMap;


	JButton resetButton;

	//methode qui permet d'appeler la fonction qui initialise l'interface
	public Board() {

		initBoard();

	}

	public void initBoard() {

		addKeyListener(new TAdapter());


		setFocusable(true);

		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		loadImages();
		initGame();
	}

	//methode qui appelle les differentes methodes de chargement
	public void loadImages() {

		AllLoadings.LoadFixedImages();
		AllLoadings.LoadAlternativeImages();
		AllLoadings.LoadMovingImages();
		AllLoadings.LoadHeadImages();
		AllLoadings.LoadBackground();


	}
	// methode pour reinitialiser les compteurs
	public void resetCounters() {
		coinCounter=3;
		insectCounter=1;
	}

	// methode appelée une fois que les niveaux augmentent
	public void increaselevel() {

		// on supprime la liste pour enlever les insectes qui nauraient eventuellement pas été mangés par Frogger et eviter les doublons
		fixedGameElementList.clear();
		// dedans nous augmentons le niveau de 1 et initialisons la position de frogger our faire en sorte qu'il se retrouve en bas au centre
		currentlevel++;

		// Appel de la methode pour reinitialiser les compteurs chaque manche et donc par consequent faire reafficher exactement 3 pieces et les 3 insects 
		resetCounters();
		// Appel  de la methode de reinitialisation de la position de frogger
		initializepos();

	}

	public void CreatingLists() {

		// on cree les differentes listes 

		fixedGameElementList = new ArrayList<FixedGameElement>();
		alternativegameElementList = new ArrayList<AlternativeGameElement>();
		headFixedElementList = new ArrayList<HeadFixedElement>();
		movingGameElementList = new ArrayList<MovingGameElement>();
	}


	//methde qui initalise les variables du score, la vitesse des 2 crocos et determine aleotoirement les positions initailes des voitures
	public void initGame() {
		//creation et lancement du timer
		timer = new Timer(DELAY, this);
		timer.start();

		if (inGame) {
			score=currscore;

		}

		// on initilaise la position de la grenouille pour faire en sorte qu'elle se retrouve en bas au centre
		initializepos();

		// on fait appel a la methode qui sers a cree les listes de stockage dimage
		CreatingLists();

		// affichage des elements que frogger doit attraper
		imagedraw();


	}


	// permet de faire appel a la methode dodrawing, ce qui permet de dessiner les images
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);


	}

	// methode qui rassemble toutes les methodes qui font avancer les elements
	public void CallAllSpeed() {
		// les methodes qui permettent de faire avancer les elements sont appelées
		speedcar1(BlueCar.speedBlueCar);
		speedcar2(PurpleCar.purpleCarSpeed);
		speedcar3(RedCar.speedRedCar);
		speedcar4(OrangeCar.orangeCarSpeed);
		speedcroc(Croc.speedCroc);
		speedcroc2(Croc2.speedCroc2);
		speedtruck(Truck.speedTruck);

	}

	public void DrawListItem(Graphics g) {

		//Dessine l'arriere plan
		g.drawImage(background,0,0 ,B_WIDTH ,B_HEIGHT ,this);//arriere plan

		// affiche les images qui se situent dans la liste correspondante, crée un peu plus haut
		for(FixedGameElement elem: fixedGameElementList){               
			g.drawImage(AllLoadings.fixedGameElementImageMap.get(elem.getType()).getImage(), elem.getPosX(), elem.getPosY(), this);
		}       
		for(AlternativeGameElement elem: alternativegameElementList){               
			g.drawImage(AllLoadings.alternativeGameElementImageMap.get(elem.getType()).getImage(), elem.getPosX(), elem.getPosY(),this);
		}  
		for(HeadFixedElement elem: headFixedElementList){               
			g.drawImage(AllLoadings.headFixedElementImageMap.get(elem.getType()).getImage(), elem.getPosX(), elem.getPosY(),this);
		} 
		for(MovingGameElement elem: movingGameElementList){               
			g.drawImage(AllLoadings.movingGameElementImageMap.get(elem.getType()).getImage(), elem.getPosX(), elem.getPosY(),this);
		} 

	}



	public void CheckPill() {

		//si Frogger touche la pilule, alors il deviens invincible
		if ((pos_x>=0 && pos_x <=SIZEDRAW)&& (pos_y>= SIZEDRAW*7 && pos_y <=SIZEDRAW*8)) {
			pillactivated();
		}
	}

	//methode ou tout est dessiné
	public void doDrawing(Graphics g) {
		// le jeu est lancé:
		if (inGame) {

			//incrementation du score
			currscore=score;  

			// on fait appel a la methode qui nous permet de faire avancer les elements
			CallAllSpeed();

			//on fait appel a la methode qui dessine tout les elements y compris ceux se trouvant dans les differentes listes
			DrawListItem(g);

			// on appelle la methode qui affiche le texte, le nombre de vie, le niveau actuel,ectS
			DisplayAllTexts.DisplayGameText(g);

			//on appel la methode qui verifie si la pillule a été touchée
			CheckPill();

			//synchronisation
			Toolkit.getDefaultToolkit().sync();

		} 

		// si je jeu n'est plus en cours la methode game over est appelée
		else {

			gameOver(g);
		}       
	}



	// determine un chiffre aleatoire qui permettera de placer le gros insecte situé sur les voies de circulation au dessus de la riviere
	public static int  getrandomposinsect3() {

		int r = (int) ((Math.random() * RAND_POS));
		return ((r * ((DOT_SIZE)/2)));


	}

	// methode d'affichage des elements que frogger doit attraper 
	public void imagedraw() {


		// on mets le booleen a faux
		pillactivated=false;

		// on fait appel aux methodes pour ajouter les images aux differentes listes

		AddToLists.AddToFixedList();
		AddToLists.AddToHeadList();
		AddToLists.AddToAlternativeList();

	}

	//methode qui verifie si frogger a atteint le but pour passer au niveau suivant
	public void checklevelup( ) {
		//si frogger touche le cadeau en haut au centre (là ou il doit aller)et qu'il a ramassé toutes les pieces, le niveau suivant est generé 
		if (((pos_x >= (B_WIDTH/2)-min_posx && pos_x <= (B_WIDTH/2)+min_posx)&&(pos_y>=0 && pos_y<=min_posx-10))&& (coinCounter==0)) {


			increaselevel();
			imagedraw();


		}

	}
	//permet d'initialiser le booleen de la pilule a vrai pour que frogger puisse etre invincible une fois qu'il l'a pris
	public void pillactivated() {
		// la pillule est activé a chaque fois que frogger passe 5 niveaux
		if (currentlevel%5==0) {
			pillactivated=true;
		}


	}

	//methode pour la vitesse de la voiture bleu
	public void speedcar1(int blueCarValue) { 


		int minus =7;

		// on prends la valeur de vitesse definie ,qui se trouve dans la classe de cette voiture
		blueCarValue = BlueCar.speedBlueCar;

		//pour la premiere voiture en partant du bas:
		if (speedcar1>=0) {
			//la vitesse initiale de cette voiture est celle definie dasn la classe aditionné au niveau actuel
			speedcar1+=blueCarValue+currentlevel;
			//si la voiture touche l'extremité droite, elle reapparait a gauche
			if (speedcar1>=max) {
				speedcar1=minus;
			}
			//si frogger se trouve sur cette bande et traverse derriere la voiture s'y situant, alors cette derniere ralenti
			if (pos_y>=max-90 && pos_y<=max-20) {

				speedcar1-=minus;

			}
		}

		// on efface la liste avant chaque passage car sinon les images precedentes restent affichées 
		movingGameElementList.clear();

		// on ajoute la voiture souhaitée a la liste
		movingGameElementList.add(new BlueCar(speedcar1,SIZEDRAW*9));

	}

	//methode pour la vitesse de la voiture mauve
	public void speedcar2(int purpleCarValue) {

		// on prends la valeur de vitesse definie ,qui se trouve dans la classe de cette voiture
		purpleCarValue = PurpleCar.purpleCarSpeed	;

		int coincounter_max=3;
		int max_speed=17;


		// pour la deuxieme voiture en partant du bas:
		if (speedcar2>=0) {
			//la vitesse initiale de cette voiture est celle definie dasn la classe aditionné au niveau actuel

			//si la voiture touche l'extremité droite, elle reapparait a gauche
			if (speedcar2>=max) {
				speedcar2=0;
			}

			// s'il reste les trois pieces a recuperer alors la vitesse est lente
			if (coinCounter==coincounter_max) {
				speedcar2+=purpleCarValue;

			}
			// s'il reste deux pieces alors la vitesse est un peu plus rapide que dans le cas precedent
			else if (coinCounter==coincounter_max-1) {
				speedcar2+=purpleCarValue+coincounter_max+currentlevel;

			}
			// s'il reste une seuke piece alors la vitesse est encore plus rapide que dans le cas precedent
			else if (coinCounter==coincounter_max-2) {
				speedcar2+=purpleCarValue+(max_speed-5)+currentlevel;

			}
			// s'il ne reste aucune pieces alors la vitesse est la plus elevée 
			else {
				speedcar2+=purpleCarValue+max_speed+currentlevel;

			}
		}

		// on ajoute la voiture souhaitée a la liste
		movingGameElementList.add(new PurpleCar(speedcar2,SIZEDRAW*8));

	}

	//methode pour la vitesse de la voiture rouge
	public void speedcar3(int redCarValue) {
		int boostspeed=10;

		// on prends la valeur de vitesse definie ,qui se trouve dans la classe de cette voiture
		redCarValue = RedCar.speedRedCar;

		//pour la troisieme voiture en partant du bas:
		if (speedcar3>=0) {
			//la vitesse initiale de cette voiture est celle definie dasn la classe aditionné au niveau actuel
			speedcar3+=redCarValue+currentlevel;
			//si la voiture touche l'extremité droite, elle reapparait a gauche
			if (speedcar3>=max) {
				speedcar3=0;
			}
			//  si frogger se trouve sur cette bande de circulation, alors la voiture accelere
			if (pos_y>=max-190 && pos_y<=max-140) {
				speedcar3+=2+currentlevel+boostspeed;

			}

		}

		// on ajoute la voiture souhaitée a la liste
		movingGameElementList.add(new RedCar(speedcar3,SIZEDRAW*7));



	}


	//methode pour la vitesse de la voiture orange
	public void speedcar4(int orangeCarValue) {

		int min_speed = 1 ;
		int min_random = 20;
		int max_random = 100;
		int modulo = 8;
		int random = (int) ((Math.random()*max_random)+min_speed);
		int random_bonusspeed= (int) ((Math.random()*max_random)+ min_random);

		// on prends la valeur de vitesse definie ,qui se trouve dans la classe de cette voiture
		orangeCarValue= OrangeCar.orangeCarSpeed;



		//pour la derniere voiture:
		if (speedcar4>=0) 
		{

			speedcar4 += orangeCarValue;

			// un nombre aleatoire entre 1 et 20 est crée et on verifie apres si ce chiffre est divible par le chiffre 8 ou non

			if (random%modulo==0) 
			{
				// s'il est possible de diviser le nombre par 8, alors la voiture accelere
				speedcar4+=orangeCarValue+ currentlevel + random_bonusspeed;

			}
			else 
			{	// s'il l'operation n'est pas possible alors la voiture ralenti
				speedcar4 += min_speed;
			}



			//si la voiture touche l'extremité droite, elle reapparait a gauche
			if (speedcar4>=max) 
			{

				speedcar4=0;
			}

		}



		// on ajoute la voiture souhaitée a la liste
		movingGameElementList.add(new OrangeCar(speedcar4,SIZEDRAW*6));

	}

	public void speedtruck(int truckSpeed) {

		// on prends la valeur de vitesse definie ,qui se trouve dans la classe de ce camion
		truckSpeed = Truck.speedTruck;


		// le camion lui, commence tout a droite et se dirige vers la gauche, a l'opposé les voitures
		if (speedtruck<=max) {
			//la vitesse initiale du camion est de 1 additionné au niveameu actuel
			speedtruck-=truckSpeed+currentlevel;
			//si la voiture touche l'extremité gauche, elle reapparait a droite

			if (speedtruck<=(-150)) {
				speedtruck=max;
			}

		}

		// on ajoute le camion a la liste
		movingGameElementList.add(new Truck(speedtruck, SIZEDRAW+10));

	}



	//determine la position du croco
	public void speedcroc(int valuecroc) {

		// on prends la valeur de vitesse definie ,qui se trouve dans la classe de ce premier crocodile
		valuecroc= Croc.speedCroc;

		//le croco commence tout a gauche et augmente de 10 jusqu'a arriver a 500 ( l'extremité droite) et puis il reapparait tout a gauche
		speedcroc+=valuecroc+currentlevel ;
		//si le croco touche l'extremité droite, il reapparait a gauche
		if (speedcroc>=max) {
			speedcroc=0;
		}

		// à partir du niveau 2, le crocodile du dessous sera affiché

		movingGameElementList.add(new Croc(speedcroc,posy_croc));



	}

	// le croco commence tout a droite et avance a gauche par 5, une fois arrivé tout a gauche il reapparait a droite
	public void speedcroc2(int valueCroc2) {

		// on prends la valeur de vitesse definie ,qui se trouve dans la classe de ce deuxieme crocodile
		valueCroc2=Croc2.speedCroc2+ currentlevel;

		speedcroc2-=valueCroc2;
		//si ce croco touche l'extremité gauche, elle reapparait a droite
		if (speedcroc2==-100) {

			speedcroc2=max;
		}

		// a partir du niveau 3, le crocodile du dessus apparait


		movingGameElementList.add(new Croc2(speedcroc2,((posy_croc)-50) ));






	}
	// verifie les collisions avec les crocodiles
	public void checkcollisioncroco() {
		int posy_croco = 200;
		int posy_croco2 = 100;

		// si la position de frogger et celle du croco du haut coincident, alors il perds une vie et reviens au point de depart
		if ((pos_x>=speedcroc && pos_x<=speedcroc+80 )&& (pos_y>=posy_croco-40 && pos_y<=posy_croco+30)) {
			decreaselife();
		}

		// si la position de frogger et celle du croco du bas coincident, alors il perds une vie et reviens au point de depart
		if ((pos_x>=speedcroc2-80 && pos_x<=speedcroc2 )&& (pos_y>=posy_croco2 && pos_y<=posy_croco2+50)) {
			decreaselife();
		}

	}


	//verifie les collisions de frogger avec les voitures et le camion
	public void checkcollisioncarandfrogger() {
		int posy_cars = 300;
		int posy_truck = 20;
		int gap_between_cars = 50;

		// si frogger n'a pas de pillule alors les conditions sont prises en compte
		// si Frogger a pris la pillule alors il sera immunisé contre les vehicules

		if (pillactivated==false) {
			// si frogger entre en contact avec le camion, le jeu prends fin imediatemment
			if (((pos_x>=speedtruck && pos_x<=speedtruck+170)&& (pos_y>=posy_truck && pos_y<=posy_truck+90))) {

				inGame=false;
			}
			// si frogger entre en contact avec la premiere voiture en partant du bas, frogger perds une vie et retourne au point de depart
			if (((pos_x>=speedcar1 && pos_x<=speedcar1+100)&& (pos_y>=posy_cars+(gap_between_cars*2)+10 && pos_y<=posy_cars+180))) {
				decreaselife();
			}


			// si frogger entre en contact avec la deuxieme voiture en partant du bas, frogger perds une vie et retourne au point de depart

			if (((pos_x>=speedcar2 && pos_x<=speedcar2+100)&& (pos_y>=posy_cars+gap_between_cars+10 && pos_y<=posy_cars+(gap_between_cars*2)+10))) {
				decreaselife();
			}
			// si frogger entre en contact avec la troisieme voiture en partant du bas, frogger perds une vie et retourne au point de depart

			if (((pos_x>=speedcar3 && pos_x<=speedcar3+100)&& (pos_y>=posy_cars+10 && pos_y<=posy_cars+gap_between_cars+10))) {
				decreaselife();
			}
			// si frogger entre en contact avec la quatrieme voiture en partant du bas, frogger perds une vie et retourne au point de depart

			if (((pos_x>=speedcar4 && pos_x<=speedcar4+100)&& (pos_y>=posy_cars-gap_between_cars+10 && pos_y<=posy_cars+10))) {
				decreaselife();
			}
		}



	}



	//chaque partie terminée, nous reinitialisons differents parametres afin que le jeu soit coherent
	public void ResetParamOfGame() {

		numberlifes=5;
		currentlevel=1;
		score=0;


	}

	// methode de fin de jeu
	public void gameOver(Graphics g) {

		inGame=false;
		// on supprime les elements de cette liste pour eviter les doublons d'images
		fixedGameElementList.clear();
		resetCounters();

		DisplayAllTexts.DisplayGameOverText(g);
		ResetParamOfGame();
		initializepos();

		// permet de verifier constemment si il y'a un nouveau top score  
		if (currscore>highestscore) {
			highestscore=currscore;
		}

		// affichage des elements que frogger doit attraper
		imagedraw();

	}

	// verifie les collisions de frogger avec la riviere  
	public void checkFixedGameElementCollision() {

		int	Max_waterZone = 240;
		int	Min_waterZone = 120;


		for(FixedGameElement elem: fixedGameElementList){
			if ((pos_x <= elem.getPosX()+pos_diff && pos_x >= elem.getPosX()-pos_diff) && (pos_y <= elem.getPosY()+pos_diff  && pos_y >= elem.getPosY()-pos_diff)){
				elem.setPosX(void_x);
				elem.setPosY(void_y);

				elem.triggerAction(this);


			}

			// si frogger touche le rayon la riviere
			if ((pos_y >= Min_waterZone) && (pos_y<=Max_waterZone)) { 



				// si frogger se trouve sur les bout de bois du bas il est  protégé de l'eau, sil se trouve sur les bout de bois du haut il est egalement protégé de l'eau
				if (!((((pos_x>=SIZEDRAW*2 && pos_x<=SIZEDRAW*3)|| (pos_x>=SIZEDRAW*5 && pos_x<=SIZEDRAW*6)|| (pos_x>=SIZEDRAW*7 && pos_x<=SIZEDRAW*8))&& (pos_y>=SIZEDRAW*4 && pos_y<=Max_waterZone ) || (((pos_x>=SIZEDRAW && pos_x<=SIZEDRAW*2)|| (pos_x>=SIZEDRAW*4 && pos_x<=SIZEDRAW*5)|| (pos_x>=SIZEDRAW*6 && pos_x<=SIZEDRAW*7))&& (pos_y>=Min_waterZone && pos_y<=SIZEDRAW*4) )))) {
					decreaselife();

				}


				// appel de la methode pour verifier les chocs avec les crocodiles
				checkcollisioncroco();


			}

			//methode de verification de collision entre frogger et les vehicules est appelee 
			checkcollisioncarandfrogger();


		}    
	}
	
	//incrementation du score apres chaque piece ou insecte attrapé
	public void incScore(int valueToIncrease){
		int levelwanted=10;
		score += valueToIncrease;
		//petite fonctionnalité supplementaire qui permet d'ajouter une vie a frogger a chaque fois qu'il atteint un score multiple de 10!
		if (score%levelwanted==0) {
			numberlifes++;
		}
	} 
	// decrementation du compteur de pieces
	public void decreaseCoinAmount(){
		coinCounter -=1;
	}






	// methode qui est appelée a chaque fois que frogger rencontre un obstacle (crocodile , vehicule, riviere ) ou qu'il touche les extremitées de l'interface
	public void decreaselife() {

		//on decremente le nombre de vie de frogger 
		numberlifes--;
		// on fait ensuite appelle a une methode qui replace frogger a sa place initiale (en bas au centre)
		initializepos();
		//lorsque toutes les vies ont été utilisées, alors le jeu s'arrete
		if (numberlifes==0) {
			inGame = false;
		}

	}

	// methode qui reinitialise les positions de frogger pour faire en sorte qu'il se retrouve en bas au centre
	public void initializepos() {
		pos_x = B_WIDTH/2;
		pos_y = B_HEIGHT-SIZEDRAW;

	}
	// verifie les collisions avec les extremités de l'interface( touche trop en bas, trop haut, trop a gauche ou trop a droite)
	public void checkCollision() {
		//si frogger touche trop haut dans l'interface
		if ((pos_y >= B_HEIGHT)||(pos_y < 0) ||(pos_x >= B_WIDTH)||(pos_x < 0) ) {

			decreaselife();
		}

	}
	// methode de generation de chiffre aleatoire pour initilaliser les ositions de certains insectes
	public static int getRandomCoordinate() {

		int r = (int) (Math.random() * RAND_POS);

		return ((r * DOT_SIZE));




	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (inGame) {
			// si le jeu est toujours en marche, alors on verifie juste si il y'a des collisions

			checkFixedGameElementCollision();
			checkCollision();
			checklevelup();
		}

		// finalement on fait appel a la fonction repaint
		repaint();
	}

	//methode pour avancer une fois les boutons pressés
	public class TAdapter extends KeyAdapter {

		@Override

		public void keyPressed(KeyEvent e) {
			// initialisation de la variable key, afin d'ecrire seuelemnt key et non e.getjeycode.
			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_SPACE)&& inGame==false) {

				inGame=true;


			}
			//si la fleche de gauche est pressée, alors le booleen pour aller a gauche deviens vrai
			if ((key == KeyEvent.VK_LEFT) ) {
				leftDirection = true;


			}
			//si la fleche de droite est pressée, alors le booleen pour aller a droite deviens vrai
			if ((key == KeyEvent.VK_RIGHT) ) {
				rightDirection = true;


			}
			//si la fleche du haut est pressée, alors le booleen pour aller en haut deviens vrai
			if ((key == KeyEvent.VK_UP) ) {
				upDirection = true;


			}
			//si la fleche du bas est pressée, alors le booleen pour aller en bas deviens vrai
			if ((key == KeyEvent.VK_DOWN) ) {
				downDirection = true;


			}
			// appeler la fonction de mouvement pour lier les deux
			MoveFrogger.move();

		}
	}


}
