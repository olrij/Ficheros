package Caracteres;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FicherosCaracteres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//escribir(new File("datos.txt"),"Haasad ef");
		//escribirLinea(new File("datos2.txt"),"                       Haasad ef esto es una linea \n Línea 112");
		//leer(new File("datos.txt"));
		leerDoc(new File("datos2.txt"));
	}
	
	public static void escribir(File f, String mensaje) {
		try {
			
			// 1. Abrir
			FileWriter fw=new FileWriter(f);
			
			// 2. Operar
			
			for(int i=0;i<mensaje.length();i++) {
				
				fw.write(mensaje.charAt(i));
				
			}
			
			// 3. Cerrar
			
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void leer(File f) {
		try {
			
			// 1. Abrir
			FileReader fr=new FileReader(f);
			
			// 2. Operar
			
			int car=fr.read();
			
			while(car!=-1) {
				System.out.print((char)car);
				car=fr.read();
			}
			
			// 3. Cerrar
			fr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void leerDoc(File f) {
		try {
			
			// 1. Abrir
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			
			// 2. Operar
			
			String linea=br.readLine();
			
			while(linea!=null) {
				System.out.println(linea);
				linea=br.readLine();
			}
			
			// 3. Cerrar
			fr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void escribirLinea(File f, String linea) {
		try {
			
			// 1. Abrir
			FileWriter fw=new FileWriter(f,true);
			PrintWriter pw=new PrintWriter(fw);
			
			// 2. Operar
			
			pw.write(linea);
			
			// 3. Cerrar
			
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
