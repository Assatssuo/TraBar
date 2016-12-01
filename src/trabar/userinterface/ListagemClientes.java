package trabar.userinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import trabar.negocio.Cliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

public class ListagemClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListagemClientes frame = new ListagemClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListagemClientes() {
		setTitle("Lista de Clientes Presentes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JTable();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
		);
		List<Cliente> lista = CadastroController.listaClientesPresentes();
		if(lista.size()==0){
			System.out.println(lista.size());
			setVisible(false);
			dispose();
		}
		Object[] columnNames = { "Nome", "CPF", "Idade", "Genero", "Status" };

		DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
		for (Cliente cliente : lista) {
			Object[] o = new Object[5];
			o[0] = cliente.getNome();
			o[1] = cliente.getCpf();
			o[2] = cliente.getIdade();
			o[3] = cliente.getGenero();
			o[4] = cliente.getStatus();
			model.addRow(o);
		}
		table.setModel(model);
		contentPane.setLayout(gl_contentPane);
	}
}
