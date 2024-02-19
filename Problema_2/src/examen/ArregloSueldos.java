package examen;

public class ArregloSueldos {
	private double sueldo[];
	private int indice;

	public ArregloSueldos() {
		sueldo = new double[10];
		indice = 0;
	}

	public int tamaño() {
		return indice;
	}

	public double obtener(int p) {
		return sueldo[p];
	}

	public void adicionar(double s) {
		if (indice == tamaño())
			ampliarArreglo();
		sueldo[indice] = s;
		indice++;
	}

	private void ampliarArreglo() {
		double aux[] = sueldo;
		sueldo = new double[indice + 10];
		for (int i = 0; i < indice; i++)
			sueldo[i] = aux[i];
	}

}
