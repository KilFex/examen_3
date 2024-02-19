package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.ArregloSueldos;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Problema_2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JTextField txtSueldo;
	private JLabel lblSueldo;
	private JButton btnAdicionar;
	private JButton btnReemplazarSueldo;
	private JButton btnIncrementarSueldo;

	ArregloSueldos a = new ArregloSueldos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema_2 frame = new Problema_2();
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
	public Problema_2() {
		setTitle("Problema_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 225, 412);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtS);

		txtSueldo = new JTextField();
		txtSueldo.setBounds(66, 8, 169, 20);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);

		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(10, 11, 46, 14);
		contentPane.add(lblSueldo);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(247, 7, 213, 23);
		contentPane.add(btnAdicionar);
		
		btnReemplazarSueldo = new JButton("Reemplazar sueldo");
		btnReemplazarSueldo.addActionListener(this);
		btnReemplazarSueldo.setBounds(245, 41, 215, 23);
		contentPane.add(btnReemplazarSueldo);
		
		btnIncrementarSueldo = new JButton("Incrementar sueldo");
		btnIncrementarSueldo.addActionListener(this);
		btnIncrementarSueldo.setBounds(245, 75, 215, 23);
		contentPane.add(btnIncrementarSueldo);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIncrementarSueldo) {
			actionPerformedBtnIncrementarSueldo(arg0);
		}
		if (arg0.getSource() == btnReemplazarSueldo) {
			actionPerformedBtnReemplazarSueldo(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
			a.adicionar(leerSueldo());
			limpiar();
			listar();
	}

	protected void actionPerformedBtnReemplazarSueldo(ActionEvent arg0) {
		
	}
	
	protected void actionPerformedBtnIncrementarSueldo(ActionEvent arg0) {
		
	}
	
	void listar() {
		txtS.setText("");
		for (int i = 0; i < a.tamaño(); i++) {
			imprimir(a.obtener(i) + "");
		}
	}

	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	double leerSueldo() {
		return Double.parseDouble(txtSueldo.getText());
	}
	
	void limpiar() {
		txtSueldo.setText("");
		txtSueldo.requestFocus();
	}
}
