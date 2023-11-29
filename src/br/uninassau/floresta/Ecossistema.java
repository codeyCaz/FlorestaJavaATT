package br.uninassau.floresta;

import java.util.Scanner;
import br.uninassau.animais.Coelho;
import br.uninassau.animais.Tigre;
import br.uninassau.plantas.Arvore;
import br.uninassau.util.Configuracoes;
import br.uninassau.util.Terreno;

public class Ecossistema  {
	public static void main(String[] args) {

        
        Scanner in = new Scanner(System.in);
        Configuracoes config = new Configuracoes(in);
        in.close();

        
        Terreno terreno = new Terreno(config.getTamanhoMapa());

        
        Coelho[] coelhos = new Coelho[config.getquantidadeCoelho()];
        for (int i = 0; i < coelhos.length; i++) {
            String coelhoNome = "Coelho" + (i + 1);
            coelhos[i] = new Coelho(coelhoNome, false, 1, "C", config.getTamanhoMapa());
            terreno.adicionarAnimal(coelhos[i]);
        }
        Tigre[] tigres = new Tigre[config.getquantidadeTigre()];
        for (int i = 0; i < tigres.length; i++) {
        	String tigreNome = "Tigre" + (i + 1);
        	tigres[i] = new Tigre(tigreNome, true, 5, "T", config.getTamanhoMapa());
        	terreno.adicionarAnimal(tigres[i]);
        } 
        Arvore[] arvores = new Arvore[config.getquantidadeArvore()];
        for (int i = 0; i < arvores.length; i++) {
            String arvoreNome = "Tigre" + (i + 1);
            arvores[i] = new Arvore(arvoreNome, 1, "#", config.getTamanhoMapa());
            terreno.adicionarPlanta(arvores[i]);
        }
        
        
        while (true) {
        	
        	terreno.imprimirTerreno();
        	System.out.println("");
        	
        	
        	for (Arvore arvore : arvores) {
        		arvore.setClicoVida(arvore.getClicoVida() + 1);
        	}
            for (Animal coelho : coelhos) {
            	if(coelho.getVida() > 0) {
            		coelho.mover(terreno, coelho);
            		coelho.setClicoVida(coelho.getClicoVida() + 1);
            	}
            } 
            for (Animal tigre : tigres) {
            	if(tigre.getVida() > 0) {
            		tigre.mover(terreno, tigre);
            		tigre.setClicoVida(tigre.getClicoVida() + 1);
            	}
            }
            
            
            for(Animal coelho : coelhos) {
            	for(Animal tigre : tigres) {
            		if (tigre.getposix() == coelho.getposix() && tigre.getposiy() == coelho.getposiy()) {
            			tigre.comer(tigre, coelho, terreno);
            			if (coelho.getVida() == 0) {
            				break;
            			}
            		}
            	}
            }
            
            
            boolean todosMortos = true;
            for (Coelho coelho : coelhos) {
                if (coelho.getVida() > 0) {
                    todosMortos = false;
                    break;
                }
            }
            if (todosMortos) {
            	break;
            }
            
            
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}