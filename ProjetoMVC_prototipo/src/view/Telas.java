package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.DAO;
import model.AlunoModel;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JRadioButton;

public class Telas extends JFrame {
	private AlunoModel aluno;
	String path;

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
	private JFormattedTextField txtNascimento;
	private JFormattedTextField txtCelular;
	private JTextField txtRgm;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtMunicipio;
	private JTextField txtNome;
	private JPanel panel_2;
	private JPanel panel_3;
	private JComboBox cbxUf;
	private JLabel lblFoto;
	private JTextField txtRgm_1;
	private JTextField txtFaltas;
	private JTextField txtCpf;

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
		setBounds(100, 100, 816, 490);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);

		mntmSalvar = new JMenuItem("Salvar");

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
		tabbedPane_1.setBounds(0, 0, 790, 418);
		contentPane.add(tabbedPane_1);

		panel = new JPanel();
		tabbedPane_1.addTab("Dados pessoais", null, panel, null);
		panel.setLayout(null);

		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblRgm.setBounds(22, 40, 46, 14);
		panel.add(lblRgm);

		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(22, 93, 180, 14);
		panel.add(lblDataDeNascimento);

		lblEnail = new JLabel("Email");
		lblEnail.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblEnail.setBounds(22, 160, 57, 14);
		panel.add(lblEnail);

		lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblEnd.setBounds(22, 220, 46, 14);
		panel.add(lblEnd);

		lblMunicpio = new JLabel("Município");
		lblMunicpio.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblMunicpio.setBounds(22, 280, 91, 20);
		panel.add(lblMunicpio);

		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblUf.setBounds(299, 283, 39, 14);
		panel.add(lblUf);

		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblCelular.setBounds(466, 280, 67, 20);
		panel.add(lblCelular);

		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblNome.setBounds(239, 39, 67, 14);
		panel.add(lblNome);

		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblCpf.setBounds(484, 40, 28, 14);
		panel.add(lblCpf);

		txtNascimento = new JFormattedTextField();
		txtNascimento.setToolTipText("");
		txtNascimento.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNascimento.setBounds(210, 85, 151, 32);
		panel.add(txtNascimento);

		txtCelular = new JFormattedTextField();
		txtCelular.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtCelular.setBounds(543, 278, 91, 25);
		panel.add(txtCelular);

		txtRgm = new JTextField();
		txtRgm.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtRgm.setBounds(65, 24, 151, 32);
		panel.add(txtRgm);
		txtRgm.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(78, 145, 283, 32);
		panel.add(txtEmail);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(78, 205, 283, 32);
		panel.add(txtEndereco);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(112, 275, 151, 32);
		panel.add(txtMunicipio);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNome.setColumns(10);
		txtNome.setBounds(305, 24, 151, 32);
		panel.add(txtNome);

		cbxUf = new JComboBox();
		cbxUf.setModel(new DefaultComboBoxModel(
				new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbxUf.setToolTipText(
				"AC\r\nAL\r\nAP\r\nAM\r\nBA\r\nCE\r\nDF\r\nES\r\nGO\r\nMA\r\nMT\r\nMS\r\nMG\r\nPA\r\nPB\r\nPR\r\nPE\r\nPI\r\nRJ\r\nRN\r\nRS\r\nRO\r\nRR\r\nSC\r\nSP\r\nSE\r\nTO\r\n");
		cbxUf.setFont(new Font("Poppins", Font.PLAIN, 15));
		cbxUf.setBounds(348, 278, 57, 32);
		panel.add(cbxUf);

		lblFoto = new JLabel("");
		lblFoto.setBorder(new CompoundBorder());
		lblFoto.setIcon(new ImageIcon(Telas.class.getResource("/images/285680_camera_icon.png")));
		lblFoto.setBounds(594, 106, 128, 128);
		panel.add(lblFoto);

		JButton btnFoto = new JButton("Selecionar foto");
		btnFoto.setFont(new Font("Poppins", Font.PLAIN, 15));
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Selecione um arquivo de imagem");
				jfc.setFileFilter(
						new FileNameExtensionFilter("Arquivo de imagens(*.PNG,*.JPEG,*.JPG)", "png", "jpeg", "jpg"));
				int result = jfc.showOpenDialog(null);

		        if (result == JFileChooser.APPROVE_OPTION) {
		            File f = jfc.getSelectedFile();
		            path = f.getAbsolutePath();

		            try {
		                BufferedImage bi = ImageIO.read(f);
		                Image foto = bi.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);

		                ImageIcon imgIcon = new ImageIcon(foto);
		                lblFoto.setIcon(imgIcon);
		            } catch (IOException | IllegalArgumentException ex) {
		                JOptionPane.showMessageDialog(null, "Erro ao carregar a imagem: " + ex.getMessage());
		            }
		        }
		    }
		});
		btnFoto.setBounds(415, 160, 157, 32);
		panel.add(btnFoto);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtCpf.setBounds(522, 24, 206, 30);
		panel.add(txtCpf);
		txtCpf.setColumns(10);

		panel_1 = new JPanel();
		tabbedPane_1.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Curso:");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblNewLabel.setBounds(48, 28, 96, 49);
		panel_1.add(lblNewLabel);
		
		JComboBox cmbCurso = new JComboBox();
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Análise e Desenvolvimento de Sistemas", "Comércio Exterior", "Logística"}));
		cmbCurso.setFont(new Font("Poppins", Font.PLAIN, 20));
		cmbCurso.setBounds(148, 28, 493, 49);
		panel_1.add(cmbCurso);
		
		JLabel lblCampus = new JLabel("Campus:");
		lblCampus.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblCampus.setBounds(48, 87, 96, 49);
		panel_1.add(lblCampus);
		
		JComboBox cmbCampus = new JComboBox();
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Guarulhos", "São Caetano", "São Paulo"}));
		cmbCampus.setFont(new Font("Poppins", Font.PLAIN, 20));
		cmbCampus.setBounds(148, 87, 493, 49);
		panel_1.add(cmbCampus);
		
		JLabel lblPerodo = new JLabel("Período:");
		lblPerodo.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblPerodo.setBounds(48, 157, 96, 49);
		panel_1.add(lblPerodo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Matutino");
		rdbtnNewRadioButton.setFont(new Font("Poppins", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(163, 171, 132, 21);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnVespertino = new JRadioButton("Vespertino");
		rdbtnVespertino.setFont(new Font("Poppins", Font.PLAIN, 20));
		rdbtnVespertino.setBounds(315, 171, 166, 21);
		panel_1.add(rdbtnVespertino);
		
		JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
		rdbtnNoturno.setFont(new Font("Poppins", Font.PLAIN, 20));
		rdbtnNoturno.setBounds(483, 171, 166, 21);
		panel_1.add(rdbtnNoturno);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(Telas.class.getResource("/images/desligar_resized.png")));
		btnSair.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSair.setBounds(10, 227, 132, 113);
		panel_1.add(btnSair);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Telas.class.getResource("/images/alterar_resized.png")));
		btnAlterar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnAlterar.setBounds(163, 227, 132, 113);
		panel_1.add(btnAlterar);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Telas.class.getResource("/images/consultar_resized.png")));
		btnConsultar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnConsultar.setBounds(320, 227, 132, 113);
		panel_1.add(btnConsultar);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Telas.class.getResource("/images/excluir_resized.png")));
		btnLimpar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnLimpar.setBounds(472, 227, 132, 113);
		panel_1.add(btnLimpar);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Telas.class.getResource("/images/salvar_resized.png")));
		btnSalvar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSalvar.setBounds(625, 227, 132, 113);
		panel_1.add(btnSalvar);

		panel_2 = new JPanel();
		tabbedPane_1.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblRgm_1.setBounds(10, 32, 46, 14);
		panel_2.add(lblRgm_1);

		txtRgm_1 = new JTextField();
		txtRgm_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtRgm_1.setColumns(10);
		txtRgm_1.setBounds(66, 27, 151, 22);
		panel_2.add(txtRgm_1);

		JLabel lblConsultaNome = new JLabel("nome do usuário");
		lblConsultaNome.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblConsultaNome.setBounds(260, 27, 255, 22);
		panel_2.add(lblConsultaNome);

		JLabel lblConsultaCurso = new JLabel("curso do usuário");
		lblConsultaCurso.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblConsultaCurso.setBounds(10, 72, 255, 22);
		panel_2.add(lblConsultaCurso);

		JLabel lblDisciplina_1 = new JLabel("Disciplina");
		lblDisciplina_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblDisciplina_1.setBounds(10, 138, 83, 24);
		panel_2.add(lblDisciplina_1);

		JLabel lblSemetre_1 = new JLabel("Semestre");
		lblSemetre_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblSemetre_1.setBounds(10, 214, 83, 14);
		panel_2.add(lblSemetre_1);

		JLabel lblNota_1 = new JLabel("Nota");
		lblNota_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblNota_1.setBounds(197, 217, 46, 14);
		panel_2.add(lblNota_1);

		JComboBox cbxOpcoesDisciplina = new JComboBox();
		cbxOpcoesDisciplina.setBounds(103, 142, 30, 22);
		panel_2.add(cbxOpcoesDisciplina);

		JComboBox cbxOpcoesSemestre = new JComboBox();
		cbxOpcoesSemestre.setBounds(103, 213, 30, 22);
		panel_2.add(cbxOpcoesSemestre);

		JComboBox cbxOpcoesNotas = new JComboBox();
		cbxOpcoesNotas.setBounds(280, 213, 30, 22);
		panel_2.add(cbxOpcoesNotas);

		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		lblFaltas.setBounds(394, 217, 46, 14);
		panel_2.add(lblFaltas);

		txtFaltas = new JTextField();
		txtFaltas.setBounds(458, 217, 86, 20);
		panel_2.add(txtFaltas);
		txtFaltas.setColumns(10);

		panel_3 = new JPanel();
		tabbedPane_1.addTab("Boletim", null, panel_3, null);

		// Comandos(salvar, consultar, excluir, listar)

		// Salvar
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid = false;
				
				try {
					valid = getDados(false);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				if (valid) {
					aluno = new AlunoModel();
					aluno.setRgm(txtRgm.getText());
					aluno.setNome(txtNome.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf((String) cbxUf.getSelectedItem());
					aluno.setCelular(txtCelular.getText());
					aluno.setNascimento(txtNascimento.getText());
					
					try {
						FileInputStream is = new FileInputStream(new File(path));	
						aluno.setFoto(path);
					} catch (FileNotFoundException ex) {
						Logger.getLogger("Imagem não selecionada ou inválida").log(Level.SEVERE, null, ex);;
					}
				}
				try {
					DAO alunoDao = new DAO();
					alunoDao.salvar(aluno);
					JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		mnAluno.add(mntmSalvar);
	}

	// Voids e classes para validar dados
	public void getData() throws Exception {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		String dataInput = txtNascimento.getText();
		try {
			Date data = format.parse(dataInput);
			Date now = new Date();
			if (data.after(now)) {
				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public boolean getDados(boolean att) throws Exception {
		if (att) {
			AlunoModel aluno = new AlunoModel();
			if(!txtCpf.getText().matches("/^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$/") && !txtCpf.getText().isEmpty()) {
				throw new Exception("CPF deve conter apenas números");
			}
			
			if(!txtRgm.getText().isEmpty()) {
				throw new Exception("RGM inválido");
			}
			
			if(!txtEndereco.getText().isEmpty()) {
				throw new Exception("Endereço inválido");
			}
			
			if(!txtMunicipio.getText().isEmpty()) {
				throw new Exception("Município inválido");
			}
			
			if(!cbxUf.getSelectedItem().equals("")) {
				throw new Exception("Selecione um UF válido");
			}
			
			if(!txtCelular.getText().matches("[0-9]+") && !txtCelular.getText().isEmpty()) {
				throw new Exception("Município inválido");
			}
			
			if (!txtNome.getText().matches("^[\\p{L}~`,^ ]+$") && !txtNome.getText().isEmpty()) {
				throw new Exception("Nome deve ser inteiramente de caracteres");
			}

			if (!Pattern.compile("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")
					.matcher(txtEmail.getText().toString()).matches() && !txtEmail.getText().isEmpty()) {
				throw new Exception("Insira um email valido");
			}
			try {
				if (!txtNascimento.getText().isEmpty())
					getData();
			} catch (Exception e) {
				throw new Exception("Insira uma data válida no seguinte formado: dd/mm/AAAA");
			}

			return true;
		}

		AlunoModel aluno = new AlunoModel();
		if (!txtNome.getText().matches("^[\\p{L}~`,^ ]+$")) {
			throw new Exception("Nome deve ser inteiramente de caracteres ");
		}

		if (!Pattern.compile("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")
				.matcher(txtEmail.getText().toString()).matches()) {
			throw new Exception("Insira um email valido");
		}
		try {
			getData();
		} catch (Exception e) {
			throw new Exception("Insira uma data válida no seguinte formado: 00/00/0000");
		}
		if (txtEndereco.getText().equals("")) {
			throw new Exception("Insira um endereço");
		}

		if (cbxUf.getSelectedItem().equals(" ")) {
			throw new Exception("Selecione um UF válido");
		}
		return true;

	}
}
