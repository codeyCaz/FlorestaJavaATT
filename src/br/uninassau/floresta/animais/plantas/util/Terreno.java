package br.uninassau.floresta.animais.plantas.util;

import java.util.Random;

import br.uninassau.floresta.Animal;
import br.uninassau.floresta.Planta;

public class Terreno {
	private String[][] tamanhoTerreno; 
	private int valorProp; 
	Random random = new Random();
	
	
	public Terreno(int tamanho) { 
			this.valorProp = tamanho;
			this.tamanhoTerreno = criarTerreno();
		}
	

	public int getTamanho() {
		return valorProp;
	}
	
	public String[][] getTamanhoTerreno() {
		return tamanhoTerreno;
	}
	
	public String[][] criarTerreno() {
			String[][] tamanhoTerreno = new String[valorProp][valorProp];
		    for (int i = 0; i < valorProp; i++) {
		        for (int j = 0; j < valorProp; j++) {
		            tamanhoTerreno[i][j] = ".";
		        }
		    }
		    return tamanhoTerreno;
		}
	
	
		public void imprimirTerreno() {
			for (int i = 0; i < valorProp; i++) {
				for (int j = 0; j < valorProp; j++) {
					System.out.print(tamanhoTerreno[i][j] + " ");
				}
				System.out.println("|");
			}
		}
		
	
		public void adicionarAnimal(Animal animal) {
				tamanhoTerreno[animal.getposix()][animal.getposiy()] = animal.getSimbolo();
		}
		
	
		public void adicionarPlanta(Planta planta) {
			tamanhoTerreno[planta.getposix()][planta.getposiy()] = planta.getSimbolo();
		}	

		public void moverAnimal(Animal animal, int posX, int posY) {
			tamanhoTerreno[posX][posY] = animal.getSimbolo();
		}
	
		public void removerAnimal(Animal animal) {
			tamanhoTerreno[animal.getposix()][animal.getposiy()] = ".";
		}	
}