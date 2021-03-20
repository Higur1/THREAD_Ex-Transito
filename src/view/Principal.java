package view;
import java.util.concurrent.Semaphore;

import controller.Transito;

public class Principal {

	public static void main(String[] args) {
		int perm = 1;
		
		Semaphore semaforo = new Semaphore(perm);
		for(int Carro = 1; Carro < 5; Carro++) {
			Thread StartTransito = new Transito(Carro, semaforo);
			StartTransito.start();
		}
	}
}
