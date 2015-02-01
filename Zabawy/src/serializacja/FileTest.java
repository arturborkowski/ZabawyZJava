package serializacja;

import java.io.File;

public class FileTest {

	File folder = new File("C:/Users/Artek/Documents/Programowanie/JavaProjects");
	File fold = new File("Folder");

	public static void main(String[] args) {
		FileTest test = new FileTest();
		test.folder.mkdir();
		
		/*if(test.folder.isDirectory()) {
			String[] zawartosc = test.folder.list();
			for(int i = 0; i < zawartosc.length; i++) {
				System.out.println(zawartosc[i]);
			}
		}*/
		
		
		System.out.println(test.fold.getAbsolutePath());
	}

}
