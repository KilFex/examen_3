package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.ArregloPesos;

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
	private JTextField txtPeso;
	private JLabel lblPeso;
	private JButton btnAdicionar;
	private JButton btnReemplazarPeso;
	private JButton btnIncrementarPeso;

	ArregloPesos a = new ArregloPesos();

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

		txtPeso = new JTextField();
		txtPeso.setBounds(66, 8, 169, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		lblPeso = new JLabel("Sueldo");
		lblPeso.setBounds(10, 11, 46, 14);
		contentPane.add(lblPeso);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(247, 7, 213, 23);
		contentPane.add(btnAdicionar);
		
		btnReemplazarPeso = new JButton("Reemplazar Peso");
		btnReemplazarPeso.addActionListener(this);
		btnReemplazarPeso.setBounds(245, 41, 215, 23);
		contentPane.add(btnReemplazarPeso);
		
		btnIncrementarPeso = new JButton("Incrementar Peso");
		btnIncrementarPeso.addActionListener(this);
		btnIncrementarPeso.setBounds(245, 75, 215, 23);
		contentPane.add(btnIncrementarPeso);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIncrementarPeso) {
			
			
			
			actionPerformedBtnIncrementarPeso(arg0);
		}
		if (arg0.getSource() == btnReemplazarPeso) {
			actionPerformedBtnReemplazarPeso(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			
			actionPerformedBtnAdicionar(arg0);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		String Peso = txtPeso.getText();
		if(!Peso.isEmpty()){
	
		a.adicionar(leerPeso());
			limpiar();
			listar();
		}
		else {
			mensaje("No se a ingresado ningun dato");
		}
}

	protected void actionPerformedBtnReemplazarPeso(ActionEvent arg0) {
		
		a.reemplazarPesoMayor70();
		listar();
		
	}
	
	protected void actionPerformedBtnIncrementarPeso(ActionEvent arg0) {
		
		a.incrementarPesoMayor70();
		listar();
		
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

	double leerPeso() {
		return Double.parseDouble(txtPeso.getText());
	}
	
	void limpiar() {
		txtPeso.setText("");
		txtPeso.requestFocus();
	}
}
