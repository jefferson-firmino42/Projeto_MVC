import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Telas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JTabbedPane tabbedPane_1;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblRgm;
	private JLabel lblDataDeNascimento;
	private JLabel lblEnail;
	private JLabel lblEnd;
	private JLabel lblMunicpio;
	private JLabel lblUf;
	private JLabel lblCelular;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JFormattedTextField ftxtDataNascimento;
	private JFormattedTextField ftxtCelular;
	private JTextField txtFRgm;
	private JTextField txtFEmail;
	private JTextField txtFEnd;
	private JTextField txtFMunicipio;
	private JTextField textField_4;
	private JPanel panel_2;
	private JPanel panel_3;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telas frame = new Telas();
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
	public Telas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 450);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);
		
		mntmSalvar = new JMenuItem("Salvar");
		mnAluno.add(mntmSalvar);
		
		mntmNewMenuItem = new JMenuItem("Alterar");
		mnAluno.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Consultar");
		mnAluno.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Excluir");
		mnAluno.add(mntmNewMenuItem_2);
		
		mnNewMenu = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_4 = new JMenuItem("Salvar");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Alterar");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_6 = new JMenuItem("Consultar");
		mnNewMenu.add(mntmNewMenuItem_6);
		
		mntmNewMenuItem_7 = new JMenuItem("Excluir");
		mnNewMenu.add(mntmNewMenuItem_7);
		
		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_3 = new JMenuItem("Sobre");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 694, 389);
		contentPane.add(tabbedPane_1);
		
		panel = new JPanel();
		tabbedPane_1.addTab("Dados pessoais", null, panel, null);
		panel.setLayout(null);
		
		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblRgm.setBounds(22, 40, 46, 14);
		panel.add(lblRgm);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblDataDeNascimento.setBounds(22, 100, 180, 14);
		panel.add(lblDataDeNascimento);
		
		lblEnail = new JLabel("Email");
		lblEnail.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblEnail.setBounds(22, 160, 57, 14);
		panel.add(lblEnail);
		
		lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblEnd.setBounds(22, 220, 46, 14);
		panel.add(lblEnd);
		
		lblMunicpio = new JLabel("Município");
		lblMunicpio.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblMunicpio.setBounds(22, 280, 91, 20);
		panel.add(lblMunicpio);
		
		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblUf.setBounds(281, 280, 39, 14);
		panel.add(lblUf);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblCelular.setBounds(466, 280, 67, 14);
		panel.add(lblCelular);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblNome.setBounds(239, 39, 67, 14);
		panel.add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblCpf.setBounds(466, 42, 57, 14);
		panel.add(lblCpf);
		
		ftxtDataNascimento = new JFormattedTextField();
		ftxtDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ftxtDataNascimento.setBounds(210, 95, 151, 22);
		panel.add(ftxtDataNascimento);
		
		JFormattedTextField ftxtCpf = new JFormattedTextField();
		ftxtCpf.setBounds(574, 39, 105, 20);
		panel.add(ftxtCpf);
		
		ftxtCelular = new JFormattedTextField();
		ftxtCelular.setBounds(555, 280, 91, 20);
		panel.add(ftxtCelular);
		
		txtFRgm = new JTextField();
		txtFRgm.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtFRgm.setBounds(78, 34, 151, 22);
		panel.add(txtFRgm);
		txtFRgm.setColumns(10);
		
		txtFEmail = new JTextField();
		txtFEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtFEmail.setColumns(10);
		txtFEmail.setBounds(78, 155, 283, 22);
		panel.add(txtFEmail);
		
		txtFEnd = new JTextField();
		txtFEnd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtFEnd.setColumns(10);
		txtFEnd.setBounds(78, 215, 283, 22);
		panel.add(txtFEnd);
		
		txtFMunicipio = new JTextField();
		txtFMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtFMunicipio.setColumns(10);
		txtFMunicipio.setBounds(114, 280, 151, 22);
		panel.add(txtFMunicipio);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_4.setColumns(10);
		textField_4.setBounds(305, 34, 151, 22);
		panel.add(textField_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" -", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox.setToolTipText("AC\r\nAL\r\nAP\r\nAM\r\nBA\r\nCE\r\nDF\r\nES\r\nGO\r\nMA\r\nMT\r\nMS\r\nMG\r\nPA\r\nPB\r\nPR\r\nPE\r\nPI\r\nRJ\r\nRN\r\nRS\r\nRO\r\nRR\r\nSC\r\nSP\r\nSE\r\nTO\r\n");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setBounds(331, 280, 57, 22);
		panel.add(comboBox);
		
		panel_1 = new JPanel();
		tabbedPane_1.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		tabbedPane_1.addTab("Notas e Faltas", null, panel_2, null);
		
		panel_3 = new JPanel();
		tabbedPane_1.addTab("Boletim", null, panel_3, null);
	}
}
