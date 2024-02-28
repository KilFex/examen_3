package examen;

import javax.swing.JOptionPane;

public class ArregloSueldos {
	private double sueldo[];
	private int indice;
	
	
	public ArregloSueldos() {
		sueldo = new double [10];
		indice = 0;
		
	}
	public int tamaño() {
	 	return indice; 
		
	}
	public double obtener(int p) {
		return sueldo[p];
	}
	public void adicionar(double s) {
		if(indice == tamaño()) {
			ampliarArreglo();
			sueldo[indice] = s;
			indice++;
		}
	}
	private void ampliarArreglo() {
		double aux[]= sueldo;
		sueldo = new double [indice + 10];
		for(int i = 0; i<indice; i++) {
			sueldo[i] = aux[i];
		}
	}
	public void eliminarTodo() {
		indice = 0;
	}
	public void eliminarFinal() {
		indice--;
	}
	
	public int posicionPrimerSueldoMenorQue1000() {
	        for (int i = 0; i < indice; i++) {
	            if (sueldo[i] < 1000) {
	                return i;
	            }
	        }
	        return -1;
}
	public double sueldoMayor() {
		double mayor = 0;
		for(int i = 0; i <tamaño(); i++) {
			if(obtener(i)>mayor) {
				mayor = obtener(i);
			}
		}
		return mayor;
	}
	public boolean reemplazarPrimerSueldoMenorQue1000() {
		int posMen1000 = posicionPrimerSueldoMenorQue1000();
		if(posMen1000 != -1) {
		sueldo[posMen1000] = sueldoMayor();
		return true;
	}
	else {
		return false;
	}
}
}
  