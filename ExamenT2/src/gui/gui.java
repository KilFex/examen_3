package gui;

import java.awt.EventQueue;
import examen.ArregloSueldos;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class gui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;
	private JButton btnReemplazarSueldo;
	private JButton btnIngresar;
	private JTextField textSueldo;
	private JButton btnEliminarTodo;
	private JButton btnEliminarAlFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	ArregloSueldos arregloSueldo = new ArregloSueldos();
	
	
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 220, 365);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		scrollPane.setViewportView(txtResultado);
		
		btnReemplazarSueldo = new JButton("Reemplazar sueldo");
		btnReemplazarSueldo.addActionListener(this);
		btnReemplazarSueldo.setBounds(255, 39, 152, 38);
		contentPane.add(btnReemplazarSueldo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(292, 125, 89, 23);
		contentPane.add(btnIngresar);
		
		textSueldo = new JTextField();
		textSueldo.setBounds(292, 159, 86, 20);
		contentPane.add(textSueldo);
		textSueldo.setColumns(10);
		
		btnEliminarTodo = new JButton("Eliminar Todo");
		btnEliminarTodo.addActionListener(this);
		btnEliminarTodo.setBounds(255, 249, 140, 23);
		contentPane.add(btnEliminarTodo);
		
		btnEliminarAlFinal = new JButton("Eliminar al  final");
		btnEliminarAlFinal.addActionListener(this);
		btnEliminarAlFinal.setBounds(255, 300, 140, 23);
		contentPane.add(btnEliminarAlFinal);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminarAlFinal) {
			actionPerformedBtnEliminarAlFinal(e);
		}
		if (e.getSource() == btnEliminarTodo) {
			actionPerformedBtnEliminarTodo(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnReemplazarSueldo) {
			actionPerformedReemplazarSueldo(e);
		}
	}
	protected void actionPerformedReemplazarSueldo(ActionEvent e) {
		
		boolean isExistMinorSalary = arregloSueldo.reemplazarPrimerSueldoMenorQue1000();
		if(!isExistMinorSalary ) {
			JOptionPane.showMessageDialog(this,"No existe ningún sueldo menor que 1000");
		}else {
		listar();
	}
		}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		String texAreaSueldo = textSueldo.getText();
	
		if(!texAreaSueldo.isEmpty()){
			int sueldo = Integer.parseInt(texAreaSueldo); 
			arregloSueldo.adicionar(sueldo);
				limpiar();
				listar();
			}
			else {
				mensaje("No se a ingresado ningun dato");
			}
	}
	void listar() {
		txtResultado.setText("");
		for (int i = 0; i < arregloSueldo.tamaño(); i++) {
			imprimir(arregloSueldo.obtener(i) + "");
		}
	}
	void imprimir(String s) {
		txtResultado.append(s + "\n");
	}
	void limpiar() {
		textSueldo.setText("");
		textSueldo.requestFocus();
	}
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	protected void actionPerformedBtnEliminarTodo(ActionEvent e) {
		if(arregloSueldo.tamaño() > 0) {
		arregloSueldo.eliminarTodo();
		listar();
	}else {
		mensaje("No existe kuno");
	}
	}
	
	protected void actionPerformedBtnEliminarAlFinal(ActionEvent e) {
		if(arregloSueldo.tamaño()>0) {
		arregloSueldo.eliminarFinal();
		listar();
	}
	else {
		mensaje("Eres fan de kuno");
	}
}
}
