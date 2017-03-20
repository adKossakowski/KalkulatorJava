package kalkulator;

import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.plaf.synth.SynthOptionPaneUI;

public class kalkulatorMain {
	
	
	public static double oblicz(String str) 
	{
		
		StringTokenizer stk = new StringTokenizer(str);
		
		double wynik=Double.parseDouble((String)stk.nextElement());
			while (stk.hasMoreElements()) 
			{
				
				String znak = stk.nextToken();
				if(znak.equals("-"))
				{
					
					wynik-=Double.parseDouble((String)stk.nextElement());
				}
				else if(znak.equals("+"))
				{
					
					wynik+=Double.parseDouble((String)stk.nextElement());
				}
				else if(znak.equals("*"))
				{
					
					wynik*=Double.parseDouble((String)stk.nextElement());
				}
				else if(znak.equals("/"))
				{
					
					wynik/=Double.parseDouble((String)stk.nextElement());
				}
			}
			return wynik;
		}
		
		public static void readFile(String filePath) throws IOException {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
		  
			try {
				String textLine = bufferedReader.readLine();
				do {
					
					double oK = oblicz(textLine);
					System.out.println(textLine+ " = "+ oK);
					textLine = bufferedReader.readLine();
				} while (textLine != null);
			} finally {
				bufferedReader.close();
				}
			}
		
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("\tWitaj w kalkulatorze!!\n");
		System.out.println("Wybierz opcjê któr¹ chcesz wygenerowaæ\n\n1- Wpisywanie w konsoli\n2- Pobieranie dzia³ania z pliku");
		
		boolean tru=true;
		while(tru){
			System.out.print("Twój wybór:");
			Scanner inpt = new Scanner(System.in);
			String wybor = inpt.nextLine();
			switch(wybor){
				case "1":
					System.out.println("Proszê wprowadziæ dzia³anie do obliczenia");
					String dzial = inpt.nextLine();
					double ok = oblicz(dzial);
					System.out.println(dzial+ " = "+ ok);
					break;
				case "2":					
					readFile("plik.txt");
					break;
				case "Koniec":
					System.out.println("Koniec!!");
					tru=false;
					break;
				default:
					System.out.println("Nieprawid³owy wybór proszê poprawiæ");
					break;
			}
		}
	}
}
