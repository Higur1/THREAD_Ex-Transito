package controller;

import java.util.concurrent.Semaphore;

public class Transito extends Thread {
	private String sentido;
	private int Carro;
	private Semaphore semaforo;
	
	public Transito (int Carro, Semaphore semaforo) {
		this.Carro = Carro;
		this.semaforo = semaforo;
	}
	@Override
	public void run() {
		try {
			semaforo.acquire();
			Sinal();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
	}
	private void Sinal() {
		switch (Carro) {
			case 1:
				sentido = ("O carro #"+Carro+" está passando do Norte para o Sul");
				System.out.println(sentido);
				break;
			case 2:
				sentido = ("O carro #"+Carro+" está passando do Oeste para o leste");
				System.out.println(sentido);
				break;
			case 3:
				sentido = ("O carro #"+Carro+" está passando do Leste para o Oeste");
				System.out.println(sentido);
				break;
			case 4:
				sentido = ("O carro #"+Carro+" está passando do Sul para o Norte");
				System.out.println(sentido);
		}
	}
}

