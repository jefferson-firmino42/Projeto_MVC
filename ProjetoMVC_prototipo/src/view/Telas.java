package view;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.CursoDAO;
import dao.DAO;
import model.AlunoModel;
import model.CursoModel;
import utils.ConnectionFactory;

import java.util.Date;
import java.util.Enumeration;
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
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

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
	private JMenuItem btnSobre;
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
	private ButtonGroup bg = new ButtonGroup();
	private JComboBox<String> cmbCurso;
	private JComboBox<String> cmbSemestre;
	private JComboBox<String> cmbCampus;
	private JComboBox<String> cmbDisciplina;
	private JTextField txtNota_1;
	private JLabel lblrgmcurso;
	private JTextField txtRGMCurso;
	private JLabel lblSair;
	private JLabel lblConsultar;
	private JLabel lblConsultar_1;
	private JLabel lblLimpar;
	private JLabel lblSalvar;
	private JLabel lblSair_1;
	private JLabel lblConsultar_2;
	private JLabel lblConsultar_3;
	private JLabel lblLimpar_1;
	private JLabel lblSalvar_1;
	private JMenuItem mntmLimparTela;
	private JTextField txtRgmBoletim;
	private JTextField txtNota_2;

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

		// acessa a tela sobre
		btnSobre = new JMenuItem("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Ajuda novaTela = new Tela_Ajuda();
				novaTela.setVisible(true);
			}
		});

		mnNewMenu_1.add(btnSobre);
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
		lblEnail.setBounds(22, 170, 57, 14);
		panel.add(lblEnail);

		lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblEnd.setBounds(22, 217, 46, 14);
		panel.add(lblEnd);

		lblMunicpio = new JLabel("Município");
		lblMunicpio.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblMunicpio.setBounds(22, 296, 91, 20);
		panel.add(lblMunicpio);

		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblUf.setBounds(299, 299, 39, 14);
		panel.add(lblUf);

		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Poppins", Font.PLAIN, 15));
		lblCelular.setBounds(466, 296, 67, 20);
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
		txtCelular.setBounds(543, 294, 208, 25);
		panel.add(txtCelular);

		txtRgm = new JFormattedTextField(new MaskFormatter("#########"));
		txtRgm.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtRgm.setBounds(65, 24, 151, 32);
		panel.add(txtRgm);
		txtRgm.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(78, 155, 283, 32);
		panel.add(txtEmail);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(78, 202, 283, 32);
		panel.add(txtEndereco);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(112, 291, 166, 32);
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
		cbxUf.setBounds(348, 294, 57, 32);
		panel.add(cbxUf);

		lblFoto = new JLabel("");
		lblFoto.setBorder(new CompoundBorder());
		lblFoto.setIcon(new ImageIcon(Telas.class.getResource("/images/icone-usuario.png")));
		lblFoto.setBounds(623, 118, 128, 128);
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
		btnFoto.setBounds(428, 174, 157, 32);
		panel.add(btnFoto);

		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtCpf.setBounds(545, 25, 206, 30);
		panel.add(txtCpf);
		txtCpf.setColumns(10);

		panel_1 = new JPanel();
		tabbedPane_1.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Curso");
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

		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblCampus.setBounds(69, 139, 96, 49);
		panel_1.add(lblCampus);

		cmbCampus = new JComboBox<>();
		cmbCampus.setFont(new Font("Poppins", Font.PLAIN, 20));
		cmbCampus.setBounds(169, 139, 493, 49);

		DefaultComboBoxModel<String> modelCampus = new DefaultComboBoxModel<>();
		modelCampus.addElement("Selecione um câmpus");
		modelCampus.addElement("Guarulhos");
		modelCampus.addElement("São Paulo");
		modelCampus.addElement("São Caetano");
		panel_1.add(cmbCampus);
		cmbCampus.setModel(modelCampus);
		cmbCampus.setSelectedIndex(0);

		JLabel lblPerodo = new JLabel("Período:");
		lblPerodo.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblPerodo.setBounds(69, 209, 96, 49);
		panel_1.add(lblPerodo);

		// Restante do seu código para salvar no banco de dados...

		Matutino = new JRadioButton("Matutino");
		Matutino.setFont(new Font("Poppins", Font.PLAIN, 20));
		Matutino.setBounds(184, 223, 132, 21);
		panel_1.add(Matutino);

		Vespertino = new JRadioButton("Vespertino");
		Vespertino.setFont(new Font("Poppins", Font.PLAIN, 20));
		Vespertino.setBounds(338, 223, 166, 21);
		panel_1.add(Vespertino);

		Noturno = new JRadioButton("Noturno");
		Noturno.setFont(new Font("Poppins", Font.PLAIN, 20));
		Noturno.setBounds(522, 223, 166, 21);
		panel_1.add(Noturno);

		bg.add(Matutino);
		bg.add(Vespertino);
		bg.add(Noturno);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Telas.class.getResource("/images/desligar_resized.png")));
		btnSair.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSair.setBounds(28, 268, 96, 79);
		panel_1.add(btnSair);

		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursoModel cursoModel = new CursoModel();
				boolean valid = false;
				try {
					valid = getDadosCurso(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				if (valid) {
					String periodoSelecionado = "";

					Enumeration<AbstractButton> buttons = bg.getElements();
					while (buttons.hasMoreElements()) {
						AbstractButton button = buttons.nextElement();
						if (button.isSelected()) {
							periodoSelecionado = button.getText();
							cursoModel.setRgm(txtRGMCurso.getText());
							cursoModel.setNomeCurso(String.valueOf(cmbCurso.getSelectedItem()));
							cursoModel.setCampus(String.valueOf(cmbCampus.getSelectedItem()));
							cursoModel.setPeriodo(periodoSelecionado);
						}

					}

					try {
						CursoDAO cursoDAO = new CursoDAO();
						cursoDAO.alterar(cursoModel);
						JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso.");

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		btnAlterar.setIcon(new ImageIcon(Telas.class.getResource("/images/alterar_resized.png")));
		btnAlterar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnAlterar.setBounds(181, 268, 96, 79);
		panel_1.add(btnAlterar);

		JButton btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String rgm = txtRGMCurso.getText().trim();
					CursoDAO dao = new CursoDAO();
					CursoModel curso = dao.consultar(rgm);

					if (curso != null) { // Verifica se o curso foi encontrado
						cmbCurso.setSelectedItem(curso.getNomeCurso());
						cmbCampus.setSelectedItem(curso.getCampus());
						String periodo = curso.getPeriodo();

						Enumeration<AbstractButton> buttons = bg.getElements();
						while (buttons.hasMoreElements()) {
							JRadioButton radioButton = (JRadioButton) buttons.nextElement();
							if (radioButton.getText().equals(periodo)) {
								radioButton.setSelected(true);
								break;
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Curso não encontrado para o RGM informado.");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(Telas.class.getResource("/images/consultar_resized.png")));
		btnConsultar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnConsultar.setBounds(338, 268, 86, 79);
		panel_1.add(btnConsultar);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbCampus.setSelectedIndex(0);
				cmbCurso.setSelectedIndex(0);
				bg.clearSelection();
				txtRGMCurso.setText("");

			}
		});
		btnLimpar.setIcon(new ImageIcon(Telas.class.getResource("/images/excluir_resized.png")));
		btnLimpar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnLimpar.setBounds(490, 268, 96, 79);
		panel_1.add(btnLimpar);

		JButton btnSalvar = new JButton("");

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursoModel cursoModel = new CursoModel();
				boolean valid = false;

				try {
					valid = getDadosCurso(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

				if (valid) {
					cursoModel.setRgm(txtRGMCurso.getText());
					cursoModel.setNomeCurso(String.valueOf(cmbCurso.getSelectedItem()));
					cursoModel.setCampus(String.valueOf(cmbCampus.getSelectedItem()));

					String periodoSelecionado = null;

					if (Matutino.isSelected()) {
						periodoSelecionado = "Matutino";
					} else if (Vespertino.isSelected()) {
						periodoSelecionado = "Vespertino";
					} else if (Noturno.isSelected()) {
						periodoSelecionado = "Noturno";
					}

					if (periodoSelecionado != null) {
						cursoModel.setPeriodo(periodoSelecionado);

						try {
							DAO alunoDAO = new DAO();
							CursoDAO cursoDAO = new CursoDAO();
							String rgm = txtRGMCurso.getText().trim();

							if (alunoDAO.rgmExiste(rgm) && !cursoDAO.rgmExiste(rgm)) {
								JOptionPane.showMessageDialog(null, "Salvo com sucesso");
								cursoDAO.salvarCurso(cursoModel);
							} else {
								JOptionPane.showMessageDialog(null,
										"Aluno não cadastrado no sistema ou já possui algum curso.");
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um período");
					}
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(Telas.class.getResource("/images/salvar_resized.png")));
		btnSalvar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSalvar.setBounds(643, 268, 96, 79);
		panel_1.add(btnSalvar);

		lblrgmcurso = new JLabel("RGM");
		lblrgmcurso.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblrgmcurso.setBounds(69, 21, 96, 49);
		panel_1.add(lblrgmcurso);

		txtRGMCurso = new JFormattedTextField(new MaskFormatter("#########"));
		txtRGMCurso.setFont(new Font("Poppins", Font.PLAIN, 20));
		txtRGMCurso.setBounds(169, 21, 493, 49);
		panel_1.add(txtRGMCurso);
		txtRGMCurso.setColumns(10);

		lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Poppins", Font.BOLD, 15));
		lblSair.setBounds(57, 337, 61, 44);
		panel_1.add(lblSair);

		lblConsultar = new JLabel("Alterar");
		lblConsultar.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar.setBounds(201, 337, 70, 44);
		panel_1.add(lblConsultar);

		lblConsultar_1 = new JLabel("Consultar");
		lblConsultar_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar_1.setBounds(338, 337, 96, 44);
		panel_1.add(lblConsultar_1);

		lblLimpar = new JLabel("Limpar");
		lblLimpar.setFont(new Font("Poppins", Font.BOLD, 15));
		lblLimpar.setBounds(510, 337, 70, 44);
		panel_1.add(lblLimpar);

		lblSalvar = new JLabel("Salvar");
		lblSalvar.setFont(new Font("Poppins", Font.BOLD, 15));
		lblSalvar.setBounds(663, 337, 70, 44);
		panel_1.add(lblSalvar);
		DefaultComboBoxModel<String> disciplinaModel = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> semestreModel = new DefaultComboBoxModel<>();
		semestreModel.addElement("Selecione");
		semestreModel.addElement("1º");
		semestreModel.addElement("2º");
		semestreModel.addElement("3º");
		semestreModel.addElement("4º");
		semestreModel.addElement("5º");
		semestreModel.addElement("6º");

		panel_2 = new JPanel();
		tabbedPane_1.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblRgm_1.setBounds(10, 32, 62, 24);
		panel_2.add(lblRgm_1);

		txtRgm_1 = new JTextField();
		txtRgm_1.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtRgm_1.setColumns(10);
		txtRgm_1.setBounds(82, 18, 151, 39);
		panel_2.add(txtRgm_1);

		JLabel lblConsultaNome = new JLabel("nome do usuário");
		lblConsultaNome.setFont(new Font("Poppins", Font.BOLD, 18));
		lblConsultaNome.setBounds(260, 32, 255, 24);
		panel_2.add(lblConsultaNome);

		JLabel lblConsultaCurso = new JLabel("curso do usuário");
		lblConsultaCurso.setFont(new Font("Poppins", Font.BOLD, 18));
		lblConsultaCurso.setBounds(10, 85, 255, 24);
		panel_2.add(lblConsultaCurso);

		JLabel lblDisciplina_1 = new JLabel("Disciplina");
		lblDisciplina_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblDisciplina_1.setBounds(275, 139, 106, 24);
		panel_2.add(lblDisciplina_1);

		JLabel lblSemetre_1 = new JLabel("Semestre");
		lblSemetre_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblSemetre_1.setBounds(10, 139, 106, 24);
		panel_2.add(lblSemetre_1);

		JLabel lblNota_1 = new JLabel("Nota 1");
		lblNota_1.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblNota_1.setBounds(250, 194, 70, 24);
		panel_2.add(lblNota_1);

		cmbDisciplina = new JComboBox<>();
		cmbDisciplina.setFont(new Font("Poppins", Font.PLAIN, 15));
		cmbDisciplina.setBounds(382, 124, 370, 39);
		cmbDisciplina.setModel(disciplinaModel);
		panel_2.add(cmbDisciplina);

		JComboBox cmbSemestre = new JComboBox();
		cmbSemestre.setFont(new Font("Poppins", Font.PLAIN, 15));
		cmbSemestre.setBounds(126, 124, 125, 39);
		panel_2.add(cmbSemestre);
		cmbSemestre.setModel(semestreModel);
		cmbSemestre.setSelectedIndex(0);

		// Seleção das Disciplinas
		cmbCurso.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					disciplinaModel.removeAllElements();

					String cursoSelecionado = (String) cmbCurso.getSelectedItem();
					String semestreSelecionado = (String) cmbSemestre.getSelectedItem();

					if (!"Selecione um curso".equals(cursoSelecionado)) {

						if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "1º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Programação em Microinformática");
							disciplinaModel.addElement("Algoritmos e Lógica de Programação");
							disciplinaModel.addElement("Laboratório de Hardware ");
							disciplinaModel.addElement("Arquitetura e Organização de Computadores");
							disciplinaModel.addElement("Administração Geral");
							disciplinaModel.addElement("Matemática Discreta");
							disciplinaModel.addElement("Inglês I ");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "2º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Engenharia de Software I ");
							disciplinaModel.addElement("Linguagem de Programação");
							disciplinaModel.addElement("Sistemas de Informação");
							disciplinaModel.addElement("Contabilidade");
							disciplinaModel.addElement("Cálculo");
							disciplinaModel.addElement("Comunicação e Expressão");
							disciplinaModel.addElement("Inglês II ");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "3º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Engenharia de Software II");
							disciplinaModel.addElement("Interação Humano Computador");
							disciplinaModel.addElement("Estruturas de Dados ");
							disciplinaModel.addElement("Sistemas Operacionais I");
							disciplinaModel.addElement("Economia e Finanças");
							disciplinaModel.addElement("Estatística aplicada");
							disciplinaModel.addElement("Sociedade e Tecnologia");
							disciplinaModel.addElement("Inglês III ");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "4º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Engenharia de Software III");
							disciplinaModel.addElement("Programação Orientada a Objetos");
							disciplinaModel.addElement("Banco de dados ");
							disciplinaModel.addElement("Sistemas Operacionais II ");
							disciplinaModel.addElement("Programação para Dispositivos Móveis");
							disciplinaModel.addElement("Metodologia da Pesquisa Científico-tecnológica");
							disciplinaModel.addElement("Inglês IV");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "5º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Laboratório de Engenharia de Software");
							disciplinaModel.addElement("Projeto de Redes de Computadores");
							disciplinaModel.addElement("Redes de computadores");
							disciplinaModel.addElement("Laboratório de Banco de Dados");
							disciplinaModel.addElement("Sistemas distribuídos");
							disciplinaModel.addElement("Segurança da Informação");
							disciplinaModel.addElement("Programação Linear e Aplicações");
							disciplinaModel.addElement("Inglês V ");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "6º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Gestão de Projetos ");
							disciplinaModel.addElement("Gestão e Governança de Tecnologia da Informação");
							disciplinaModel.addElement("Tópicos Especiais em Informática ");
							disciplinaModel.addElement("Laboratório de Redes");
							disciplinaModel.addElement("Inteligência Artificial");
							disciplinaModel.addElement("Auditoria de Sistemas");
							disciplinaModel.addElement("Gestão de Equipes ");
							disciplinaModel.addElement("Empreendedorismo");
							disciplinaModel.addElement("Ética e Responsabilidade Profissional ");
							disciplinaModel.addElement("Inglês VI");
						}

						else if ("Logística".equals(cursoSelecionado) && "1º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Administração Geral");
							disciplinaModel.addElement("Cálculo I");
							disciplinaModel.addElement("Comunicação e Expressão");
							disciplinaModel.addElement("Informatica Básica");
							disciplinaModel.addElement("Inglês I");
							disciplinaModel.addElement("Logística");
							disciplinaModel.addElement("Métodos para a Produção do Conhecimento");
							disciplinaModel.addElement("Projeto Interdisciplinar I");
						} else if ("Logística".equals(cursoSelecionado) && "2º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Cálculo Diferencial e Integral");
							disciplinaModel.addElement("Contabilidade");
							disciplinaModel.addElement("Espanhol I");
							disciplinaModel.addElement("Estatística Aplicada à Gestão");
							disciplinaModel.addElement("Fundamentos de Gestão da Qualidade");
							disciplinaModel.addElement("Inglês II");
							disciplinaModel.addElement("Matemática Financeira");
							disciplinaModel.addElement("Modalidade e Intermodalidade");
							disciplinaModel.addElement("Projeto Interdisciplinar II");
						} else if ("Logística".equals(cursoSelecionado) && "3º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Economia e Finanças empresariais");
							disciplinaModel.addElement("Espanhol II");
							disciplinaModel.addElement("Gestão de Equipes");
							disciplinaModel.addElement("Gestão de Produção e Operações");
							disciplinaModel.addElement("Gestão Tributária nas Operações Logísticas");
							disciplinaModel.addElement("Inglês III");
							disciplinaModel.addElement("Pesquisa Operacional");
							disciplinaModel.addElement("Projeto Interdisciplinar III");
						} else if ("Logística".equals(cursoSelecionado) && "4º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Custos e tarifas Logísticos");
							disciplinaModel.addElement("Eletiva I");
							disciplinaModel.addElement("Gestão de estoques");
							disciplinaModel.addElement("Inglês IV");
							disciplinaModel.addElement("Fundamentos de Marketing");
							disciplinaModel.addElement("Métodos Quantitativos de Gestão");
							disciplinaModel.addElement("Sistemas de Movimentação e Transporte");
							disciplinaModel.addElement("Projeto Interdisciplinar IV");
						} else if ("Logística".equals(cursoSelecionado) && "5º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Embalagens e Unitização");
							disciplinaModel.addElement("Gestão da Cadeia de Suprimentos");
							disciplinaModel.addElement("Inglês V");
							disciplinaModel.addElement("Inovação e Empreendedorismo");
							disciplinaModel.addElement("Movimentação e Armazenagem");
							disciplinaModel.addElement("Projeto Aplicado à Logística");
							disciplinaModel.addElement("Simulação em Logística");
							disciplinaModel.addElement("Projeto Interdisciplinar V");
						} else if ("Logística".equals(cursoSelecionado) && "6º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Gestão de Projetos Logísticos");
							disciplinaModel.addElement("Eletiva II");
							disciplinaModel.addElement("Projeto Interdisciplinar VI");
							disciplinaModel.addElement("Comércio Exterior e Logística");
							disciplinaModel.addElement("Gestão de Transporte de Carga e Roteirização");
							disciplinaModel.addElement("Tecnologia de Transportes");
							disciplinaModel.addElement("Transportes de Cargas Especiais");
							disciplinaModel.addElement("Inglês VI");

						} else if ("Comércio Exterior".equals(cursoSelecionado) && "1º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Comércio Exterior");
							disciplinaModel.addElement("Administração Geral");
							disciplinaModel.addElement("Matemática aplicada");
							disciplinaModel.addElement("Direito público e privado");
							disciplinaModel.addElement("Economia");
							disciplinaModel.addElement("Informática Aplicada ao Comércio Exterior ");
							disciplinaModel.addElement("Comunicação e expressão I ");
							disciplinaModel.addElement("Inglês I e II ");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "2º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Projeto em Comércio Exterior I");
							disciplinaModel.addElement("Política comercial externa");
							disciplinaModel.addElement("Economia Internacional ");
							disciplinaModel.addElement("Sistemas de informações contábeis");
							disciplinaModel.addElement("Direito internacional");
							disciplinaModel.addElement("Estatística aplicada a Comércio Exterior");
							disciplinaModel.addElement("Gestão de Pessoas no Comércio Exterior");
							disciplinaModel.addElement("Comunicação e expressão II ");
							disciplinaModel.addElement("Inglês III e IV");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "3º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Projeto em Comércio Exterior II");
							disciplinaModel.addElement("Mercado e Finanças Internacionais");
							disciplinaModel.addElement("Gestão Financeira");
							disciplinaModel.addElement("Gestão de Custos e Tributos");
							disciplinaModel.addElement("Logística Aplicada");
							disciplinaModel.addElement("Modais de Transporte e Seguro de Carga");
							disciplinaModel.addElement("Espanhol I");
							disciplinaModel.addElement("Inglês V e VI");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "4º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Projeto em Comércio Exterior III");
							disciplinaModel.addElement("Marketing Internacional");
							disciplinaModel.addElement("Inovação e Empreendedorismo");
							disciplinaModel.addElement("Métodos para a Produção do Conhecimento");
							disciplinaModel.addElement("Logística Internacional");
							disciplinaModel.addElement("Espanhol II");
							disciplinaModel.addElement("Inglês VII e VIII");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "5º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Projeto em Comércio Exterior IV");
							disciplinaModel.addElement("Teoria e prática cambial ");
							disciplinaModel.addElement("Legislação Aduaneira ");
							disciplinaModel.addElement("Elementos de Cultura dos Povos ");
							disciplinaModel.addElement("Espanhol III");
							disciplinaModel.addElement("Inglês IX e X");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "6º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplinaoi");
							disciplinaModel.addElement("Projeto em Comércio Exterior V");
							disciplinaModel.addElement("Negócios Internacionais");
							disciplinaModel.addElement("Gestão Estratégica Internacional");
							disciplinaModel.addElement("Sistemática do Comércio Exterior");
							disciplinaModel.addElement("Espanhol IV ");
							disciplinaModel.addElement("Inglês XI ");
						}

					}
				}
			}
		});

		cmbSemestre.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					disciplinaModel.removeAllElements();

					String cursoSelecionado = (String) cmbCurso.getSelectedItem();
					String semestreSelecionado = (String) cmbSemestre.getSelectedItem();

					if (!"Selecione um curso".equals(cursoSelecionado)) {

						if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "1º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Programação em Microinformática");
							disciplinaModel.addElement("Algoritmos e Lógica de Programação");
							disciplinaModel.addElement("Laboratório de Hardware ");
							disciplinaModel.addElement("Arquitetura e Organização de Computadores");
							disciplinaModel.addElement("Administração Geral");
							disciplinaModel.addElement("Matemática Discreta");
							disciplinaModel.addElement("Inglês I ");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "2º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Engenharia de Software I ");
							disciplinaModel.addElement("Linguagem de Programação");
							disciplinaModel.addElement("Sistemas de Informação");
							disciplinaModel.addElement("Contabilidade");
							disciplinaModel.addElement("Cálculo");
							disciplinaModel.addElement("Comunicação e Expressão");
							disciplinaModel.addElement("Inglês II ");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "3º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Engenharia de Software II");
							disciplinaModel.addElement("Interação Humano Computador");
							disciplinaModel.addElement("Estruturas de Dados ");
							disciplinaModel.addElement("Sistemas Operacionais I");
							disciplinaModel.addElement("Economia e Finanças");
							disciplinaModel.addElement("Estatística aplicada");
							disciplinaModel.addElement("Sociedade e Tecnologia");
							disciplinaModel.addElement("Inglês III ");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "4º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Engenharia de Software III");
							disciplinaModel.addElement("Programação Orientada a Objetos");
							disciplinaModel.addElement("Banco de dados ");
							disciplinaModel.addElement("Sistemas Operacionais II ");
							disciplinaModel.addElement("Programação para Dispositivos Móveis");
							disciplinaModel.addElement("Metodologia da Pesquisa Científico-tecnológica");
							disciplinaModel.addElement("Inglês IV");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "5º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Laboratório de Engenharia de Software");
							disciplinaModel.addElement("Projeto de Redes de Computadores");
							disciplinaModel.addElement("Redes de computadores");
							disciplinaModel.addElement("Laboratório de Banco de Dados");
							disciplinaModel.addElement("Sistemas distribuídos");
							disciplinaModel.addElement("Segurança da Informação");
							disciplinaModel.addElement("Programação Linear e Aplicações");
							disciplinaModel.addElement("Inglês V ");
						} else if ("Análise e Desenvolvimento de Sistemas".equals(cursoSelecionado)
								&& "6º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Gestão de Projetos ");
							disciplinaModel.addElement("Gestão e Governança de Tecnologia da Informação");
							disciplinaModel.addElement("Tópicos Especiais em Informática ");
							disciplinaModel.addElement("Laboratório de Redes");
							disciplinaModel.addElement("Inteligência Artificial");
							disciplinaModel.addElement("Auditoria de Sistemas");
							disciplinaModel.addElement("Gestão de Equipes ");
							disciplinaModel.addElement("Empreendedorismo");
							disciplinaModel.addElement("Ética e Responsabilidade Profissional ");
							disciplinaModel.addElement("Inglês VI");
						}

						else if ("Logística".equals(cursoSelecionado) && "1º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Administração Geral");
							disciplinaModel.addElement("Cálculo I");
							disciplinaModel.addElement("Comunicação e Expressão");
							disciplinaModel.addElement("Informatica Básica");
							disciplinaModel.addElement("Inglês I");
							disciplinaModel.addElement("Logística");
							disciplinaModel.addElement("Métodos para a Produção do Conhecimento");
							disciplinaModel.addElement("Projeto Interdisciplinar I");
						} else if ("Logística".equals(cursoSelecionado) && "2º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Cálculo Diferencial e Integral");
							disciplinaModel.addElement("Contabilidade");
							disciplinaModel.addElement("Espanhol I");
							disciplinaModel.addElement("Estatística Aplicada à Gestão");
							disciplinaModel.addElement("Fundamentos de Gestão da Qualidade");
							disciplinaModel.addElement("Inglês II");
							disciplinaModel.addElement("Matemática Financeira");
							disciplinaModel.addElement("Modalidade e Intermodalidade");
							disciplinaModel.addElement("Projeto Interdisciplinar II");
						} else if ("Logística".equals(cursoSelecionado) && "3º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Economia e Finanças empresariais");
							disciplinaModel.addElement("Espanhol II");
							disciplinaModel.addElement("Gestão de Equipes");
							disciplinaModel.addElement("Gestão de Produção e Operações");
							disciplinaModel.addElement("Gestão Tributária nas Operações Logísticas");
							disciplinaModel.addElement("Inglês III");
							disciplinaModel.addElement("Pesquisa Operacional");
							disciplinaModel.addElement("Projeto Interdisciplinar III");
						} else if ("Logística".equals(cursoSelecionado) && "4º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Custos e tarifas Logísticos");
							disciplinaModel.addElement("Eletiva I");
							disciplinaModel.addElement("Gestão de estoques");
							disciplinaModel.addElement("Inglês IV");
							disciplinaModel.addElement("Fundamentos de Marketing");
							disciplinaModel.addElement("Métodos Quantitativos de Gestão");
							disciplinaModel.addElement("Sistemas de Movimentação e Transporte");
							disciplinaModel.addElement("Projeto Interdisciplinar IV");
						} else if ("Logística".equals(cursoSelecionado) && "5º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Embalagens e Unitização");
							disciplinaModel.addElement("Gestão da Cadeia de Suprimentos");
							disciplinaModel.addElement("Inglês V");
							disciplinaModel.addElement("Inovação e Empreendedorismo");
							disciplinaModel.addElement("Movimentação e Armazenagem");
							disciplinaModel.addElement("Projeto Aplicado à Logística");
							disciplinaModel.addElement("Simulação em Logística");
							disciplinaModel.addElement("Projeto Interdisciplinar V");
						} else if ("Logística".equals(cursoSelecionado) && "6º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Gestão de Projetos Logísticos");
							disciplinaModel.addElement("Eletiva II");
							disciplinaModel.addElement("Projeto Interdisciplinar VI");
							disciplinaModel.addElement("Comércio Exterior e Logística");
							disciplinaModel.addElement("Gestão de Transporte de Carga e Roteirização");
							disciplinaModel.addElement("Tecnologia de Transportes");
							disciplinaModel.addElement("Transportes de Cargas Especiais");
							disciplinaModel.addElement("Inglês VI");

						} else if ("Comércio Exterior".equals(cursoSelecionado) && "1º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Comércio Exterior");
							disciplinaModel.addElement("Administração Geral");
							disciplinaModel.addElement("Matemática aplicada");
							disciplinaModel.addElement("Direito público e privado");
							disciplinaModel.addElement("Economia");
							disciplinaModel.addElement("Informática Aplicada ao Comércio Exterior ");
							disciplinaModel.addElement("Comunicação e expressão I ");
							disciplinaModel.addElement("Inglês I e II ");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "2º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Projeto em Comércio Exterior I");
							disciplinaModel.addElement("Política comercial externa");
							disciplinaModel.addElement("Economia Internacional ");
							disciplinaModel.addElement("Sistemas de informações contábeis");
							disciplinaModel.addElement("Direito internacional");
							disciplinaModel.addElement("Estatística aplicada a Comércio Exterior");
							disciplinaModel.addElement("Gestão de Pessoas no Comércio Exterior");
							disciplinaModel.addElement("Comunicação e expressão II ");
							disciplinaModel.addElement("Inglês III e IV");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "3º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Projeto em Comércio Exterior II");
							disciplinaModel.addElement("Mercado e Finanças Internacionais");
							disciplinaModel.addElement("Gestão Financeira");
							disciplinaModel.addElement("Gestão de Custos e Tributos");
							disciplinaModel.addElement("Logística Aplicada");
							disciplinaModel.addElement("Modais de Transporte e Seguro de Carga");
							disciplinaModel.addElement("Espanhol I");
							disciplinaModel.addElement("Inglês V e VI");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "4º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Projeto em Comércio Exterior III");
							disciplinaModel.addElement("Marketing Internacional");
							disciplinaModel.addElement("Inovação e Empreendedorismo");
							disciplinaModel.addElement("Métodos para a Produção do Conhecimento");
							disciplinaModel.addElement("Logística Internacional");
							disciplinaModel.addElement("Espanhol II");
							disciplinaModel.addElement("Inglês VII e VIII");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "5º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplina");
							disciplinaModel.addElement("Projeto em Comércio Exterior IV");
							disciplinaModel.addElement("Teoria e prática cambial ");
							disciplinaModel.addElement("Legislação Aduaneira ");
							disciplinaModel.addElement("Elementos de Cultura dos Povos ");
							disciplinaModel.addElement("Espanhol III");
							disciplinaModel.addElement("Inglês IX e X");
						} else if ("Comércio Exterior".equals(cursoSelecionado) && "6º".equals(semestreSelecionado)) {
							disciplinaModel.addElement("Selecione uma disciplinaoi");
							disciplinaModel.addElement("Projeto em Comércio Exterior V");
							disciplinaModel.addElement("Negócios Internacionais");
							disciplinaModel.addElement("Gestão Estratégica Internacional");
							disciplinaModel.addElement("Sistemática do Comércio Exterior");
							disciplinaModel.addElement("Espanhol IV ");
							disciplinaModel.addElement("Inglês XI ");
						}

					}
				}
			}
		});

		JComboBox cmbEtapa = new JComboBox();
		cmbEtapa.setModel(new DefaultComboBoxModel(new String[] {"\t-", "2020 - 1", "2020 - 2", "2021 - 1", "2021 - 2", "2022 - 1", "2022 - 2", "2023 - 1", "2023 - 2"}));
		cmbEtapa.setFont(new Font("Poppins", Font.PLAIN, 15));
		cmbEtapa.setBounds(126, 194, 90, 31);
		panel_2.add(cmbEtapa);
		
		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblFaltas.setBounds(550, 194, 70, 24);
		panel_2.add(lblFaltas);

		txtFaltas = new JTextField();
		txtFaltas.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtFaltas.setBounds(630, 194, 60, 31);
		panel_2.add(txtFaltas);
		txtFaltas.setColumns(10);

		JLabel lblEtapa = new JLabel("Período");
		lblEtapa.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblEtapa.setBounds(10, 194, 100, 24);
		panel_2.add(lblEtapa);

		txtNota_1 = new JTextField();
		txtNota_1.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNota_1.setColumns(10);
		txtNota_1.setBounds(319, 194, 60, 31);
		panel_2.add(txtNota_1);

		JButton btnSair_1 = new JButton("");
		btnSair_1.setIcon(new ImageIcon(Telas.class.getResource("/images/desligar_resized.png")));
		btnSair_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSair_1.setBounds(52, 257, 100, 79);
		panel_2.add(btnSair_1);

		JButton btnAlterar_1 = new JButton("");
		btnAlterar_1.setIcon(new ImageIcon(Telas.class.getResource("/images/alterar_resized.png")));
		btnAlterar_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnAlterar_1.setBounds(196, 257, 102, 79);
		panel_2.add(btnAlterar_1);

		JButton btnConsultar_1 = new JButton("");
		btnConsultar_1.setIcon(new ImageIcon(Telas.class.getResource("/images/consultar_resized.png")));
		btnConsultar_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnConsultar_1.setBounds(330, 257, 100, 79);
		panel_2.add(btnConsultar_1);

		JButton btnLimpar_1 = new JButton("");
		btnLimpar_1.setIcon(new ImageIcon(Telas.class.getResource("/images/excluir_resized.png")));
		btnLimpar_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnLimpar_1.setBounds(476, 257, 106, 79);
		panel_2.add(btnLimpar_1);

		JButton btnSalvar_1 = new JButton("");
		btnSalvar_1.setIcon(new ImageIcon(Telas.class.getResource("/images/salvar_resized.png")));
		btnSalvar_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSalvar_1.setBounds(632, 257, 100, 79);
		panel_2.add(btnSalvar_1);

		lblSair_1 = new JLabel("Sair");
		lblSair_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblSair_1.setBounds(82, 323, 61, 44);
		panel_2.add(lblSair_1);

		lblConsultar_2 = new JLabel("Alterar");
		lblConsultar_2.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar_2.setBounds(217, 323, 70, 44);
		panel_2.add(lblConsultar_2);

		lblConsultar_3 = new JLabel("Consultar");
		lblConsultar_3.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar_3.setBounds(340, 323, 96, 44);
		panel_2.add(lblConsultar_3);

		lblLimpar_1 = new JLabel("Limpar");
		lblLimpar_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblLimpar_1.setBounds(501, 323, 70, 44);
		panel_2.add(lblLimpar_1);

		lblSalvar_1 = new JLabel("Salvar");
		lblSalvar_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblSalvar_1.setBounds(652, 323, 70, 44);
		panel_2.add(lblSalvar_1);
		
		JLabel lblNota_2 = new JLabel("Nota 2");
		lblNota_2.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblNota_2.setBounds(400, 194, 70, 24);
		panel_2.add(lblNota_2);
		
		txtNota_2 = new JTextField();
		txtNota_2.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNota_2.setColumns(10);
		txtNota_2.setBounds(470, 194, 60, 31);
		panel_2.add(txtNota_2);

		panel_3 = new JPanel();
		tabbedPane_1.addTab("Boletim", null, panel_3, null);

		JButton btnGerarBoletim = new JButton("Gerar boletim\r\n");
		btnGerarBoletim.setToolTipText("Gerar boletim do aluno");
		btnGerarBoletim.setFont(new Font("Poppins", Font.PLAIN, 15));
		btnGerarBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarPdf();
			}
		});
		panel_3.setLayout(null);
		btnGerarBoletim.setBounds(469, 108, 161, 31);
		panel_3.add(btnGerarBoletim);

		JLabel lblRgmBoletim = new JLabel("RGM");
		lblRgmBoletim.setFont(new Font("Poppins", Font.PLAIN, 20));
		lblRgmBoletim.setBounds(126, 109, 45, 30);
		panel_3.add(lblRgmBoletim);

		txtRgmBoletim = new JTextField();
		txtRgmBoletim.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtRgmBoletim.setBounds(187, 110, 220, 26);
		panel_3.add(txtRgmBoletim);
		txtRgmBoletim.setColumns(10);

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
					String rgm = txtRgm.getText().trim();
					String cpf = txtCpf.getText();
					if (!alunoDao.rgmExiste(rgm) && !alunoDao.cpfExiste(cpf)) {
						alunoDao.salvar(aluno);
						JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Aluno já está cadastrado.");
					}
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
						txtRgm.setText("");
						txtNome.setText("");
						txtCpf.setText("");
						txtEmail.setText("");
						txtEndereco.setText("");
						txtMunicipio.setText("");
						cbxUf.setSelectedItem(" ");
						txtCelular.setText("");
						txtNascimento.setText("");

						lblFoto.setIcon(new ImageIcon(Telas.class.getResource("/images/icone-usuario.png")));
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

		mntmLimparTela = new JMenuItem("Limpar tela");
		mntmLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRgm.setText("");
				txtNome.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtEndereco.setText("");
				txtMunicipio.setText("");
				cbxUf.setSelectedItem(" ");
				txtCelular.setText("");
				txtNascimento.setText("");

				lblFoto.setIcon(new ImageIcon(Telas.class.getResource("/images/icone-usuario.png")));
			}
		});
		mnAluno.add(mntmLimparTela);
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

	public boolean getDadosCurso(boolean att) throws Exception {
		if (att) {
			if (cmbCurso.getSelectedItem().equals("Selecione um curso")) {
				throw new Exception("Selecione um curso válido");
			} else if (cmbCampus.getSelectedItem().equals("Selecione um câmpus")) {
				throw new Exception("Selecione um câmpus válido");
			}

			else if (bg.getSelection() == null) {
				throw new Exception("Selecione um período válido");
			}
		}

		return true;
	}

	public boolean getDados(boolean att) throws Exception {
		if (att) {
			AlunoModel aluno = new AlunoModel();
			if (!txtCpf.getText().matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$") && !txtCpf.getText().isEmpty()) {
				throw new Exception("CPF inválido");
			}

			if (!txtRgm.getText().isEmpty()) {
				throw new Exception("Digite um RGM.");
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

		if (txtRgm.getText().equals("") || txtRgm.getText().length() != 9) {
			throw new Exception("Digite um RGM válido.");
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

	private void gerarPdf() {
		Connection con; 
		PreparedStatement pst;  
		ResultSet rs;  
		String rgm = txtRgmBoletim.getText();
		
		try {
			DAO dao = new DAO();
			if (txtRgmBoletim.getText().equals("") || !dao.rgmExiste(rgm)) {
				JOptionPane.showMessageDialog(null, "Digite um rgm válido.");
				return;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		Document documento = new Document();

		// Gerando documento
		try {
			PdfWriter.getInstance(documento, new FileOutputStream("boletim.pdf"));
			documento.open();
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			documento.add(new Paragraph(formatador.format(data)));
			documento.add(new Paragraph("Boletim do aluno:"));
			documento.add(new Paragraph(" "));

			// Tabela
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("RGM"));
			tabela.addCell(col1);
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome"));
			tabela.addCell(col2);
			PdfPCell col3 = new PdfPCell(new Paragraph("Foto"));
			tabela.addCell(col3);
			
			String buscarAluno = "SELECT * FROM aluno WHERE rgm=?";

			try {
			    con = ConnectionFactory.getConnection();
			    pst = con.prepareStatement(buscarAluno);
			    pst.setString(1, rgm);
			    rs = pst.executeQuery();

			    while (rs.next()) {
			        tabela.addCell(rs.getString(1));
			        tabela.addCell(rs.getString(2));
			        String caminho = (String) rs.getString(10);
			        com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(caminho);
			        tabela.addCell(image);
			    }
			    con.close();
			} catch (Exception e) {
			    System.out.println(e);
			}
			
			PdfPTable tabela2 = new PdfPTable(3);
			PdfPCell col4 = new PdfPCell(new Paragraph("Curso"));
			tabela.addCell(col4);
			PdfPCell col5 = new PdfPCell(new Paragraph("Campus"));
			tabela.addCell(col5);
			PdfPCell col6 = new PdfPCell(new Paragraph("Período"));
			tabela.addCell(col6);
			
			String buscarCurso = "SELECT * FROM curso WHERE rgm=?";
			
			try {
			    con = ConnectionFactory.getConnection();
			    pst = con.prepareStatement(buscarCurso);
			    pst.setString(1, rgm);
			    rs = pst.executeQuery();

			    while (rs.next()) {
			        tabela.addCell(rs.getString(3));
			        tabela.addCell(rs.getString(4));
			        tabela.addCell(rs.getString(5));
			    }
			    con.close();
			} catch (Exception e) {
			    System.out.println(e);
			}
			
			documento.add(tabela);
			documento.add(tabela2);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			documento.close();
		}

		// Abrir documento no leitor padrão
		try {
			Desktop.getDesktop().open(new File("boletim.pdf"));
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}
}
