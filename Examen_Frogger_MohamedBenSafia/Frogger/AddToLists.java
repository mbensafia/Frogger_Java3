

public class AddToLists extends Board {
	
	public  static void AddToFixedList() {

		// stock les pieces de maniere aleatoire sur l'interface
		for(int i = 0; i < coinCounter ; i++){
			fixedGameElementList.add(new Coin(getRandomCoordinate()+140,300+getRandomCoordinate()));
		}

		// stock cet insectes de maniere aleatoire sur l'inteface

		for (int i = 0; i < insectCounter; i++) {
		fixedGameElementList.add(new Insect(getRandomCoordinate()+150, 300+getRandomCoordinate()));
		fixedGameElementList.add(new Insect3(centralinsect_pos, centralinsect_pos));
		fixedGameElementList.add(new Insect2(getrandomposinsect3()+150, getrandomposinsect3()));
		}
		


		//buissons

		fixedGameElementList.add(new Bush(7*SIZEDRAW,5*SIZEDRAW));
		fixedGameElementList.add(new Bush(SIZEDRAW,5*SIZEDRAW));

		// affiche la pillule 

		if (currentlevel%5==0) {
			//cette pillule apparait et est utilisable a chaque fois que frogger augmente un palier de 5 niveaux donc elle apparaitera au niveau 5,10,15,20,....

			fixedGameElementList.add(new Pill(0 ,SIZEDRAW*7));

		}


	}
	
	public static void AddToAlternativeList() {


		//bois
		alternativegameElementList.add(new Wood(5*SIZEDRAW,4*SIZEDRAW));
		alternativegameElementList.add(new Wood(2*SIZEDRAW,4*SIZEDRAW));
		alternativegameElementList.add(new Wood(4*SIZEDRAW,3*SIZEDRAW));
		alternativegameElementList.add(new Wood(SIZEDRAW , 3*SIZEDRAW));
		alternativegameElementList.add(new Wood(7*SIZEDRAW,3*SIZEDRAW));
		alternativegameElementList.add(new Wood(8*SIZEDRAW,4*SIZEDRAW));

		//cadeau
		alternativegameElementList.add(new Present(B_WIDTH/2,0));


		

	}


	public  static void AddToHeadList() {

		headFixedElementList.add(new Head(pos_x, pos_y));

	}
	

}
