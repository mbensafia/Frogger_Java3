import java.util.HashMap;

import javax.swing.ImageIcon;

public  class AllLoadings  extends Board{


	// charge les images qui sont dans la liste du meme nom
	public static void LoadFixedImages() {

		fixedGameElementImageMap = new HashMap<String, ImageIcon>();

		//CHARGEMENT DES DIFFERENTES IMAGES QUI SERONT FIXE DANS LE JEU

		//charge les pieces
		ImageIcon iic = new ImageIcon(Coin.getPathToImage());
		fixedGameElementImageMap.put("coin", iic);
		//charge la premiere sorte d'insectes
		ImageIcon iii = new ImageIcon(Insect.getPathToImage());
		fixedGameElementImageMap.put("insect", iii);
		//charge la deuxieme sorte d'insectes
		ImageIcon iii2 = new ImageIcon(Insect2.getPathToImage());
		fixedGameElementImageMap.put("insect2", iii2);
		//charge la troisieme sorte d'insectes
		ImageIcon iii3 = new ImageIcon(Insect3.getPathToImage());
		fixedGameElementImageMap.put("insect3", iii3);
		//charge la pilule
		ImageIcon ipill = new ImageIcon(Pill.getPathToImage());
		fixedGameElementImageMap.put("pill", ipill);
		// charge les buissons
		ImageIcon ibush = new ImageIcon(Bush.getPathToImage());
		fixedGameElementImageMap.put("bush", ibush);


	}
	// charge les images qui sont dans la liste du meme nom
		public static void LoadAlternativeImages() {
			
			AllLoadings.LoadFixedImages();
			alternativeGameElementImageMap = new HashMap<String, ImageIcon>();

			//CHARGEMENT DES IMAGES FIXES QUI RENCONTRERONT FROGGER A UN MOMENT DU JEU (ELEMENTS ALTERNATIFS)


			//charge le cadeau se trouvant en haut au centre, ce qui permet de passer les niveaux une fois l'image atteinte
			ImageIcon ipres = new ImageIcon(Present.getPathToImage());
			alternativeGameElementImageMap.put("present", ipres);
			// charge les rondeaux de bois se situant sur l'eau
			ImageIcon iwood = new ImageIcon(Wood.getPathToImage());
			alternativeGameElementImageMap.put("wood", iwood);


		}

		// charge les images qui sont dans la liste du meme nom
		public static void LoadHeadImages() {
			headFixedElementImageMap = new HashMap<String, ImageIcon>();

			// CHARGE FROGGER

			// charge la grenouille
			ImageIcon ihead = new ImageIcon(Head.getPathToImage());
			headFixedElementImageMap.put("head", ihead);



		}

		// charge les images qui sont dans la liste du meme nom
		public static void LoadMovingImages() {
			movingGameElementImageMap = new HashMap<String, ImageIcon>();

			// CHARGEMENT DES IMAGES QUI BOUGE


			//charge la premiere voiture
			ImageIcon icar1 = new ImageIcon(RedCar.getPathToImage());
			movingGameElementImageMap.put("car1", icar1);
			//charge la deuxieme voiture
			ImageIcon icar2 = new ImageIcon(BlueCar.getPathToImage());
			movingGameElementImageMap.put("car2", icar2);
			//charge la troisieme voiture
			ImageIcon icar3 = new ImageIcon(PurpleCar.getPathToImage());
			movingGameElementImageMap.put("car3", icar3);
			//charge la quatrieme voiture
			ImageIcon icar4 = new ImageIcon(OrangeCar.getPathToImage());
			movingGameElementImageMap.put("car4", icar4);
			//le crocodile qui regarde a droite
			ImageIcon icroc = new ImageIcon(Croc.getPathToImage());
			movingGameElementImageMap.put("croc", icroc);
			//charge le crocodile qui regarde a gauche
			ImageIcon icroc2 = new ImageIcon(Croc2.getPathToImage());
			movingGameElementImageMap.put("croc2", icroc2);
			//charge le camion
			ImageIcon itruck = new ImageIcon(Truck.getPathToImage());
			movingGameElementImageMap.put("truck", itruck);



		}

		// charge les images qui sont dans la liste du meme nom
		public static void LoadBackground() {

			// CHARGEMENT DU FOND DECRAN


			//charge le fond d'ecran
			ImageIcon ibackg= new ImageIcon("background.jpeg");
			Board.background= ibackg.getImage();


		};




}
