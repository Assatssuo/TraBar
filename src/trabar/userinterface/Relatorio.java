package trabar.userinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import trabar.negocio.RelatorioDados;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio frame = new Relatorio();
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
	public Relatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		RelatorioDados relatorio = CadastroController.CalculaRelatorio();
		
		JLabel lblQuantidade = new JLabel("Quantidade: "+relatorio.getQuantidade());
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPercentualM = new JLabel("Mulheres: "+relatorio.getPorcentagemF()+"%");
		lblPercentualM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPercentualH = new JLabel("Homem: "+relatorio.getPorcentagemM()+"%");
		lblPercentualH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblStatusNone = new JLabel("Sem VIP: "+relatorio.getNone()+"%");
		lblStatusNone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblStatusSilver = new JLabel("Silver: "+relatorio.getSilver()+"%");
		lblStatusSilver.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblStatusGold = new JLabel("Gold: "+relatorio.getGold()+"%");
		lblStatusGold.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblStatusPlatinum = new JLabel("Platinum: "+relatorio.getPlatinum()+"%");
		lblStatusPlatinum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("VIP: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnFechar)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(84)
								.addComponent(lblQuantidade))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGenero)
								.addComponent(lblPercentualH)
								.addComponent(lblPercentualM))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStatusNone)
						.addComponent(lblStatusSilver)
						.addComponent(lblStatusPlatinum)
						.addComponent(lblNewLabel)
						.addComponent(lblStatusGold))
					.addGap(222))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGenero)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblQuantidade)
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStatusPlatinum)
								.addComponent(lblPercentualH))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStatusGold)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblStatusSilver))
						.addComponent(lblPercentualM))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStatusNone)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFechar)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
