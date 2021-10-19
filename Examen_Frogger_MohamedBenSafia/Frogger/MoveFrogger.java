
public class MoveFrogger extends Board{
	
	//methode permettanta frogger de bouger
		public  static void move() {

			// conditions pour voir si frogger est en contact avec les arbustes, si frogger essaie de traverser un arbuste il ne pourra pas. Une des touches (haut, bas, gauche, droite) est systematiquement desactivée pour empecher frogger de traverser l'arbuste

			int direction_posx_max=300;
			int direction_posx_min=20;

			if (((pos_x>=direction_posx_max+10 && pos_x<=direction_posx_max+90)||(pos_x>=direction_posx_min&& pos_x<=direction_posx_min+80)) && pos_y==direction_posx_max-10) {

				if (leftDirection) {
					pos_x -= DOT_SIZE;
					leftDirection=false;
				}

				if (rightDirection) {
					pos_x += DOT_SIZE;
					rightDirection=false;
				}
				if (downDirection) {
					pos_y += DOT_SIZE;
					downDirection=false;
				}
			}else if (((pos_x==direction_posx_max ||pos_x==direction_posx_min-10) && (pos_y>=direction_posx_max-60 && pos_y<=direction_posx_max-20))) {

				if (leftDirection) {
					pos_x -= DOT_SIZE;
					leftDirection=false;
				}


				if (upDirection) {
					pos_y -= DOT_SIZE;
					upDirection=false;
				}

				if (downDirection) {
					pos_y += DOT_SIZE;
					downDirection=false;
				}

			}else if (((pos_x==direction_posx_max+100||pos_x==direction_posx_min+90) && (pos_y>=direction_posx_max-60 && pos_y<=direction_posx_max-20))) {


				if (rightDirection) {
					pos_x += DOT_SIZE;
					rightDirection=false;
				}

				if (upDirection) {
					pos_y -= DOT_SIZE;
					upDirection=false;
				}

				if (downDirection) {
					pos_y += DOT_SIZE;
					downDirection=false;
				}
			}else {
				// si aucun arbuste n'est sur le point d'etre rencontré alors toutes les touches sont a dispositions pour faire bouger frogger

				if (leftDirection) {
					pos_x -= DOT_SIZE;
					leftDirection=false;
				}

				if (rightDirection) {
					pos_x += DOT_SIZE;
					rightDirection=false;
				}

				if (upDirection) {
					pos_y -= DOT_SIZE;
					upDirection=false;
				}

				if (downDirection) {
					pos_y += DOT_SIZE;
					downDirection=false;
				}
			}

			for (int i = 0; i < 1; i++) {

				headFixedElementList.clear();

				headFixedElementList.add(new Head(pos_x, pos_y));


			}

		}
		


}
