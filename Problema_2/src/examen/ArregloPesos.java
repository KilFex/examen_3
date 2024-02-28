package examen;

public class ArregloPesos {
	private double peso[];
	private int indice;

	public ArregloPesos() {
		peso = new double[10];
		indice = 0;
	}

	public int tamaño() {
		return indice;
	}

	public double obtener(int p) {
		return peso[p];
	}

	public void adicionar(double s) {
		if (indice == tamaño())
			ampliarArreglo();
		peso[indice] = s;
		indice++;
	}

	private void ampliarArreglo() {
		double aux[] = peso; 
		peso = new double[indice + 10];
		for (int i = 0; i < indice; i++)
			peso[i] = aux[i];
	}
	public int posicionPrimerPesoMayor70(int numero){
		for(int i=0; i<tamaño();i++) {
			if(obtener(i)> numero)
				return i;
		}
		return -1;	
	}
	public int sumarPeso() {
		int suma= 0;
		for(int i = 0; i<tamaño();i++)
			suma+=obtener(i);
		return suma;
	}
	public double retornarPesoMayor() {
		double mayor= 0; 
		for(int i = 0; i<tamaño();i++) {
			if(obtener(i) > mayor ) {
				mayor = obtener(i);
		}			
}
		return mayor;
}
	public boolean  reemplazarPesoMayor70() {
		if(posicionPrimerPesoMayor70(70)!= -1) {
			peso[posicionPrimerPesoMayor70(70)] = sumarPeso();
			return true;
		}
		return false;
		
	}
	public boolean incrementarPesoMayor70() {
		int p70 = posicionPrimerPesoMayor70(70); 
		if(p70 != -1) {
			peso[posicionPrimerPesoMayor70(70)] *= 1.2;
			 return true;
		}
		return false;
	}
}
