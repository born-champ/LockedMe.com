package locker.front;

import java.io.IOException;

import locker.back.MainMenu;

public class MainView {

	public static void main(String[] args) throws IOException {
		MainMenu mm=new MainMenu();
		mm.introduction();	
	}

}
