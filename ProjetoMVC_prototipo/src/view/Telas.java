package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

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
	private JMenuItem mntmAlterar;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmExcluir;
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
	private JRadioButton Matutino;
	private JRadioButton Vespertino;
	private JRadioButton Noturno;
	private JComboBox<String> cmbCurso;
	private JComboBox<String> cmbCampus;
	private JComboBox<String> cmbDisciplina;
	private JLabel lblrgmcurso;
	private JTextField txtRGMCurso;

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
	public Telas() throws Exception {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 490);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);

		mntmSalvar = new JMenuItem("Salvar");

		mntmAlterar = new JMenuItem("Alterar");

		mntmConsultar = new JMenuItem("Consultar");

		mntmExcluir = new JMenuItem("Excluir");

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
		lblCpf.setBounds(484, 40, 49, 14);
		panel.add(lblCpf);

		txtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtNascimento.setToolTipText("");
		txtNascimento.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNascimento.setBounds(210, 85, 151, 32);
		panel.add(txtNascimento);

		txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtCelular.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtCelular.setBounds(543, 278, 208, 25);
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
		txtMunicipio.setBounds(112, 275, 166, 32);
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
		lblFoto.setBounds(623, 104, 128, 128);
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
		btnFoto.setBounds(428, 160, 157, 32);
		panel.add(btnFoto);

		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtCpf.setBounds(545, 25, 206, 30);
		panel.add(txtCpf);
		txtCpf.setColumns(10);

		panel_1 = new JPanel();
		tabbedPane_1.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Curso:");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 80, 96, 49);
		panel_1.add(lblNewLabel);

		cmbCurso = new JComboBox<>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		model.addElement("Selecione um curso");
		model.addElement("Análise e Desenvolvimento de Sistemas");
		model.addElement("Logística");
		model.addElement("Comércio Exterior");
		cmbCurso.setFont(new Font("Poppins", Font.PLAIN, 20));
		cmbCurso.setBounds(169, 80, 493, 50);
		panel_1.add(cmbCurso);
		cmbCurso.setModel(model);
		cmbCurso.setSelectedIndex(0);
		
		JLabel lblCampus = new JLabel("Campus:");
		lblCampus.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblCampus.setBounds(69, 139, 96, 49);
		panel_1.add(lblCampus);

		JComboBox cmbCampus = new JComboBox();
		cmbCampus.setFont(new Font("Poppins", Font.PLAIN, 20));
		cmbCampus.setBounds(169, 139, 493, 49);
		panel_1.add(cmbCampus);

		DefaultComboBoxModel<String> modelCampus = new DefaultComboBoxModel<>();
		modelCampus.addElement("Selecione um câmpus");
		modelCampus.addElement("Guarulhos");
		modelCampus.addElement("São Paulo");
		modelCampus.addElement("São Caetano");
		cmbCampus.setModel(modelCampus);
		cmbCampus.setSelectedIndex(0);

		JLabel lblPerodo = new JLabel("Período:");
		lblPerodo.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblPerodo.setBounds(69, 209, 96, 49);
		panel_1.add(lblPerodo);

		Matutino = new JRadioButton("Matutino");
		Matutino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Matutino.isSelected()) {
					Vespertino.setSelected(false);
					Noturno.setSelected(false);
				}
			}
		});
		Matutino.setFont(new Font("Poppins", Font.PLAIN, 20));
		Matutino.setBounds(184, 223, 132, 21);
		panel_1.add(Matutino);

		Vespertino = new JRadioButton("Vespertino");
		Vespertino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Vespertino.isSelected()) {
					Matutino.setSelected(false);
					Noturno.setSelected(false);
				}
			}
		});
		Vespertino.setFont(new Font("Poppins", Font.PLAIN, 20));
		Vespertino.setBounds(336, 223, 166, 21);
		panel_1.add(Vespertino);

		Noturno = new JRadioButton("Noturno");
		Noturno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Noturno.isSelected()) {
					Matutino.setSelected(false);
					Vespertino.setSelected(false);
				}
			}
		});
		Noturno.setFont(new Font("Poppins", Font.PLAIN, 20));
		Noturno.setBounds(504, 223, 166, 21);
		panel_1.add(Noturno);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Telas.class.getResource("/images/desligar_resized.png")));
		btnSair.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSair.setBounds(28, 268, 132, 113);
		panel_1.add(btnSair);

		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Telas.class.getResource("/images/alterar_resized.png")));
		btnAlterar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnAlterar.setBounds(181, 268, 132, 113);
		panel_1.add(btnAlterar);

		JButton btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Telas.class.getResource("/images/consultar_resized.png")));
		btnConsultar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnConsultar.setBounds(338, 268, 132, 113);
		panel_1.add(btnConsultar);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbCurso.setSelectedIndex(0);
				cmbCampus.setSelectedIndex(0);
				Matutino.setSelected(false);
				Vespertino.setSelected(false);
				Noturno.setSelected(false);
			}
		});
		btnLimpar.setIcon(new ImageIcon(Telas.class.getResource("/images/excluir_resized.png")));
		btnLimpar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnLimpar.setBounds(490, 268, 132, 113);
		panel_1.add(btnLimpar);

		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Telas.class.getResource("/images/salvar_resized.png")));
		btnSalvar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSalvar.setBounds(643, 268, 132, 113);
		panel_1.add(btnSalvar);
		
		lblrgmcurso = new JLabel("RGM:");
		lblrgmcurso.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblrgmcurso.setBounds(69, 21, 96, 49);
		panel_1.add(lblrgmcurso);
		
		txtRGMCurso = new JTextField();
		txtRGMCurso.setFont(new Font("Poppins", Font.PLAIN, 20));
		txtRGMCurso.setBounds(169, 21, 493, 49);
		panel_1.add(txtRGMCurso);
		txtRGMCurso.setColumns(10);

		panel_2 = new JPanel();
		tabbedPane_1.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblRgm_1.setBounds(10, 32, 46, 24);
		panel_2.add(lblRgm_1);

		txtRgm_1 = new JTextField();
		txtRgm_1.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtRgm_1.setColumns(10);
		txtRgm_1.setBounds(66, 32, 151, 24);
		panel_2.add(txtRgm_1);

		JLabel lblConsultaNome = new JLabel("nome do usuário");
		lblConsultaNome.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblConsultaNome.setBounds(260, 32, 255, 24);
		panel_2.add(lblConsultaNome);

		JLabel lblConsultaCurso = new JLabel("curso do usuário");
		lblConsultaCurso.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblConsultaCurso.setBounds(10, 87, 255, 24);
		panel_2.add(lblConsultaCurso);

		JLabel lblDisciplina_1 = new JLabel("Disciplina");
		lblDisciplina_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblDisciplina_1.setBounds(10, 139, 106, 24);
		panel_2.add(lblDisciplina_1);

		JLabel lblSemetre_1 = new JLabel("Semestre");
		lblSemetre_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblSemetre_1.setBounds(10, 194, 106, 24);
		panel_2.add(lblSemetre_1);

		JLabel lblNota_1 = new JLabel("Nota");
		lblNota_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblNota_1.setBounds(197, 194, 70, 24);
		panel_2.add(lblNota_1);

		cmbDisciplina = new JComboBox<>();
		DefaultComboBoxModel<String> disciplinaModel = new DefaultComboBoxModel<>();
		cmbDisciplina.setFont(new Font("Poppins", Font.PLAIN, 15));
		cmbDisciplina.setBounds(126, 139, 235, 24);
		cmbDisciplina.setModel(disciplinaModel);
		panel_2.add(cmbDisciplina);
		
		cmbCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                disciplinaModel.removeAllElements();

                String cursoSelecionado = (String) cmbCurso.getSelectedItem();

                if (!"Selecione um curso".equals(cursoSelecionado)) {

                    if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)) {
                    	disciplinaModel.addElement("Selecione uma disciplina");
                    	disciplinaModel.addElement("Disciplina A");
                        disciplinaModel.addElement("Disciplina B");

                    } else if ("Logística".equals(cursoSelecionado)) {
                    	disciplinaModel.addElement("Selecione uma disciplina");
                        disciplinaModel.addElement("Disciplina C");
                        disciplinaModel.addElement("Disciplina D");

                    } else if ("Comércio Exterior".equals(cursoSelecionado)) {
                    	disciplinaModel.addElement("Selecione uma disciplina");
                        disciplinaModel.addElement("Disciplina E");
                        disciplinaModel.addElement("Disciplina F");

                    }
                }
            }
        });

		JComboBox cbxOpcoesSemestre = new JComboBox();
		cbxOpcoesSemestre.setFont(new Font("Poppins", Font.PLAIN, 15));
		cbxOpcoesSemestre.setBounds(126, 194, 30, 24);
		panel_2.add(cbxOpcoesSemestre);

		JComboBox cbxOpcoesNotas = new JComboBox();
		cbxOpcoesNotas.setBounds(318, 194, 30, 22);
		panel_2.add(cbxOpcoesNotas);

		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblFaltas.setBounds(394, 194, 70, 24);
		panel_2.add(lblFaltas);

		txtFaltas = new JTextField();
		txtFaltas.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtFaltas.setBounds(470, 194, 60, 24);
		panel_2.add(txtFaltas);
		txtFaltas.setColumns(10);

		panel_3 = new JPanel();
		tabbedPane_1.addTab("Boletim", null, panel_3, null);

		// CRUD tela dados pessoais(salvar, consultar, excluir, listar)

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
						Logger.getLogger("Imagem não selecionada ou inválida").log(Level.SEVERE, null, ex);
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
		
		// Alterar
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valid = false;

				try {
					valid = getDados(false);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(rootPane, "Preencha os dados do aluno.");
					return;
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
						Logger.getLogger("Imagem não selecionada ou inválida").log(Level.SEVERE, null, ex);
					}
				}
				try {
					DAO alunoDao = new DAO();
					alunoDao.alterar(aluno);
					JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		mnAluno.add(mntmAlterar);
		
		// Excluir
		mntmExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String rgm = txtRgm.getText().trim();

				try {
					if (rgm.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, insira um RGM.");
						return;
					}

					AlunoModel aluno = new AlunoModel();
					aluno.setRgm(rgm);

					DAO dao = new DAO();

					if (dao.rgmExiste(rgm)) {
						dao.excluir(aluno);
						JOptionPane.showMessageDialog(null, "Aluno deletado");
					} else {
						JOptionPane.showMessageDialog(null, "O RGM informado não foi encontrado no banco de dados.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "RGM deve ser um número.");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		mnAluno.add(mntmExcluir);
		
		// Consultar
		mntmConsultar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String rgm = txtRgm.getText().trim();
					DAO dao = new DAO();
					AlunoModel aluno = dao.consultar(rgm);

					if (aluno != null) {
						txtNome.setText(aluno.getNome());
						txtCpf.setText(aluno.getCpf());
						txtEmail.setText(aluno.getEmail());
						txtEndereco.setText(aluno.getEndereco());
						txtMunicipio.setText(aluno.getMunicipio());
						String uf = aluno.getUf();
						cbxUf.setSelectedItem(uf);
						txtCelular.setText(aluno.getCelular());
						txtNascimento.setText(aluno.getNascimento());
						String fotoPath = aluno.getFoto();
						lblFoto.setText(fotoPath);
						exibirImagem(fotoPath);
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		mnAluno.add(mntmConsultar);
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
			if (!txtCpf.getText().matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$") && !txtCpf.getText().isEmpty()) {
			    throw new Exception("CPF inválido");
			}

			if (!txtRgm.getText().isEmpty()) {
				char lastChar = txtRgm.getText().charAt(txtRgm.getText().length() - 1);
				if (!Character.isDigit(lastChar) && !Character.isLetter(lastChar)) {
					throw new Exception("O último dígito do RGM deve ser um número ou uma letra");
				}
			}

			if (!txtEndereco.getText().isEmpty()) {
				throw new Exception("Endereço inválido");
			}

			if (!txtMunicipio.getText().isEmpty()) {
				throw new Exception("Município inválido");
			}

			if (!cbxUf.getSelectedItem().equals("")) {
				throw new Exception("Selecione um UF válido");
			}

			if (!txtCelular.getText().matches("^\\(\\d{2}\\)\\s\\d{5}-\\d{4}$") && !txtCelular.getText().isEmpty()) {
			    throw new Exception("Celular inválido");
			}


			if (!txtNome.getText().matches("^[\\p{L}~`,^ ]+$") && !txtNome.getText().isEmpty()) {
				throw new Exception("Nome deve ser inteiramente de caracteres");
			}

			if (!Pattern.compile("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")
					.matcher(txtEmail.getText().toString()).matches() && !txtEmail.getText().isEmpty()) {
				throw new Exception("Insira um email valido");
			}

			try {
				FileInputStream is = new FileInputStream(new File(path));
				aluno.setFoto(path);
			} catch (FileNotFoundException ex) {
				Logger.getLogger("Imagem não selecionada ou inválida").log(Level.SEVERE, null, ex);
				throw new Exception("Selecione uma foto válida");
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

		try {
			getData();
		} catch (Exception e) {
			throw new Exception("Insira uma data válida no seguinte formado: 00/00/0000");
		}

		if (!txtNome.getText().matches("^[\\p{L}~`,^ ]+$")) {
			throw new Exception("Nome deve ser inteiramente de caracteres ");
		}

		if (!Pattern.compile("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")
				.matcher(txtEmail.getText().toString()).matches()) {
			throw new Exception("Insira um email valido");
		}

		if (!txtRgm.getText().isEmpty()) {
			char lastChar = txtRgm.getText().charAt(txtRgm.getText().length() - 1);
			if (!Character.isDigit(lastChar) && !Character.isLetter(lastChar)) {
				throw new Exception("O último dígito do RGM deve ser um número ou uma letra");
			}
		}

		if (txtEndereco.getText().equals("")) {
			throw new Exception("Insira um endereço");
		}

		if (cbxUf.getSelectedItem().equals(" ")) {
			throw new Exception("Selecione um UF válido");
		}

		if (path == null || path.isEmpty()) {
			throw new Exception("Selecione uma foto");
		}

		if (txtMunicipio.getText().isEmpty()) {
			throw new Exception("Insira um município");
		}

		if (txtCelular.getText().isEmpty() || !txtCelular.getText().matches("^\\(\\d{2}\\)\\s\\d{5}-\\d{4}$")) {
			throw new Exception("Insira um número de celular válido");
		}

		if (txtCpf.getText().isEmpty() || !txtCpf.getText().matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
			throw new Exception("Insira um CPF válido");
		}

		return true;
	}

	private void exibirImagem(String caminhoImagem) {
		try {
			if (caminhoImagem != null && !caminhoImagem.isEmpty()) {
				ImageIcon imagemIcon = new ImageIcon(caminhoImagem);
				Image imagem = imagemIcon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_SMOOTH);
				lblFoto.setIcon(new ImageIcon(imagem));
			} else {
				lblFoto.setIcon(null);
				lblFoto.setText("Imagem não disponível");
			}
		} catch (Exception ex) {
			lblFoto.setIcon(null);
			lblFoto.setText("Erro ao carregar imagem");
			Logger.getLogger("Erro ao carregar imagem").log(Level.SEVERE, null, ex);
		}
	}
}
