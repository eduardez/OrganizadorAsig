package dominio;

import presentacion.SplashME;
import presentacion.menuPrincipal;

public class mainPrin {
	public static void main(String[] args) throws Exception {
		
		SplashME sp=new SplashME();
		menuPrincipal men = new menuPrincipal();
		men.setVisible(true);
		men.setLocationRelativeTo(null);
	}	
}