package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//escribir("datos.dat");
		
		
		accesoDirecto("datos.dat");
		
		leerDatos("datos.dat");
		

	}
	
	private static void accesoDirecto(String string) {
		// TODO Auto-generated method stub
		
		RandomAccessFile raf=null;
		try {
			raf=new RandomAccessFile(string,"rw");
			
			double num; 
			
			while(true) {
				raf.skipBytes(4);
				
				num=raf.readDouble();
				
				raf.seek(raf.getFilePointer()-8);
				
				num+=1.0;
				
				raf.writeDouble(num);
				
				raf.skipBytes(2);
				
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(EOFException e){

			try {
				raf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void accesoDirecto2(String string) {
		// TODO Auto-generated method stub
		
		RandomAccessFile raf=null;
		try {
			raf=new RandomAccessFile(string,"rw");
			
			double num; 
			
			while(true) {
				raf.readInt();
				
				num=raf.readDouble();
				//System.out.println(num);
				
				raf.seek(raf.getFilePointer()-8);
				
				num+=1.0;
				
				raf.writeDouble(num);
				
				raf.readChar();
				
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(EOFException e){

			try {
				raf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static void leerDatos(String ruta) {
		// TODO Auto-generated method stub
		FileInputStream fos=null;
		DataInputStream dos=null;
		try {
			fos = new FileInputStream(ruta);
			dos=new DataInputStream(fos);
			
			for(;;) {
				
				System.out.print(dos.readInt()+"|");
				System.out.print(dos.readDouble()+"|");
				System.out.print(dos.readChar()+"|");
				System.out.println();
								
		}
			
			
			
			
		} catch(EOFException e){

			try {
				fos.close();
				dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		
		
	}

	public static void escribir(String ruta) {
		try {

			FileOutputStream fos=new FileOutputStream(ruta);
			DataOutputStream dos=new DataOutputStream(fos);
			
			dos.writeInt(1);
			dos.writeDouble(2.12);
			dos.writeChar('a');
			
			dos.writeInt(2);
			dos.writeDouble(3.12);
			dos.writeChar('b');
			
			dos.writeInt(3);
			dos.writeDouble(4.12);
			dos.writeChar('c');
			
			dos.flush();
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
