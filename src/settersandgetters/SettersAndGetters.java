package settersandgetters;

import java.util.ArrayList;
import java.util.Scanner;

public class SettersAndGetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String classe = "";
		String atribut = "";
		String tipo = "";
		ArrayList<String> atributs = new ArrayList<String>();
		ArrayList<String> tipos = new ArrayList<String>();
		Scanner entrada = new Scanner(System.in);
		boolean fi = false;
		
		System.out.print("Indica el nom de la classe:");
		classe = entrada.nextLine();
		
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
		
		System.out.println("//Constructor");
		System.out.println(constructor(classe,atributs,tipos));
		System.out.println("//Getters");
		System.out.println(getters(atributs,tipos));
		System.out.println("//Setters");
		System.out.println(setters(atributs,tipos));
		System.out.println("//Propis");
		System.out.println(makeToString(classe, atributs,tipos));
	}
	
	private static String constructor(String classe, ArrayList<String> atributs, ArrayList<String> tipos) {
		String resposta = String.format("public %s(", classe);
		byte elements = (byte) atributs.size();
		for (int i = 0; i < elements - 1; i++) {
			resposta += String.format("%s %s, ", tipos.get(i), atributs.get(i));
		}
		resposta += String.format("%s %s){\n", tipos.get(elements - 1), atributs.get(elements - 1));
		for (int i = 0; i < elements; i++) {
			resposta += String.format("this.%s = %s;\n", atributs.get(i), atributs.get(i));
		}
		resposta += "}\n";
		return resposta;
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
	
	private static String makeToString(String classe, ArrayList<String> atributs, ArrayList<String> tipos) {
		String resposta = String.format("public String toString(){\nreturn \"Sóc una %s", classe);
		byte elements = (byte) atributs.size();
		if (elements > 0) resposta += ". "; 
		for (int i = 0; i < elements - 1; i++) {
			resposta += String.format("%s: this.%s, ", atributs.get(i), atributs.get(i));
		}
		resposta += String.format("%s: this.%s", atributs.get(elements -1), atributs.get(elements -1));
		resposta += ".\"\n}\n";
		return resposta;
	}
}
