package settersandgetters;

import java.util.ArrayList;
import java.util.Scanner;

public class SettersAndGetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String atribut = "";
		String tipo = "";
		ArrayList<String> atributs = new ArrayList<String>();
		ArrayList<String> tipos = new ArrayList<String>();
		Scanner entrada = new Scanner(System.in);
		boolean fi = false;
		
		
		do {
			System.out.print("Indica el nom de l'atribut (o Enter per acabar):");
			atribut = entrada.nextLine();
			fi = atribut.equals("");
			if (!fi) {
				System.out.print("Indica el tipus de l'atribut;");
				tipo = entrada.nextLine();
				atributs.add(atribut);
				tipos.add(tipo);
			}
		}while (!fi);
		entrada.close();
		
		System.out.println("//Getters");
		System.out.println(getters(atributs,tipos));
		System.out.println("//Setters");
		System.out.println(setters(atributs,tipos));
	}
	
	public static String getters(ArrayList<String> atributs, ArrayList<String> tipos) {
		String resposta = "";
		byte elements = (byte) atributs.size();
		for (int i = 0; i < elements; i++) {
			resposta += String.format("public %s get%s(){\n"
					+ "return this.%s;\n"
					+ "}\n", tipos.get(i), primeraLetraMayus(atributs.get(i)), atributs.get(i));
			
		}
		return resposta;
	}
	
	public static String primeraLetraMayus(String word) {
		return word.replaceFirst("" + word.charAt(0), "" + Character.toUpperCase(word.charAt(0)));
	}
	
	public static String setters(ArrayList<String> atributs, ArrayList<String> tipos) {
		String resposta = "";
		byte elements = (byte) atributs.size();
		for (int i = 0; i < elements; i++) {
			resposta += String.format("public void set%s(%s %s){\n"
					+ "this.%s = %s;\n"
					+ "}\n", primeraLetraMayus(atributs.get(i)), tipos.get(i), atributs.get(i), atributs.get(i), atributs.get(i));
		}
		return resposta;
	}
}
