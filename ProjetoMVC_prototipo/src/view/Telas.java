package view;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.CursoDAO;
import dao.DAO;
import dao.DisciplinaDAO;
import model.AlunoModel;
import model.CursoModel;
import model.DisciplinaModel;
import utils.ConnectionFactory;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

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
	private JMenuItem menuSalvar_1;
	private JMenuItem menuAlterar_1;
	private JMenuItem menuConsultar_1;
	private JMenuItem menuExcluir_1;
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
	private JComboBox<String> cmbEtapa;
	private JComboBox<String> cmbPeriodo;
	private JTextField txtNota_1;
	private JLabel lblrgmcurso;
	private JTextField txtRGMCurso;
	private JLabel lblSair;
	private JLabel lblConsultar;
	private JLabel lblConsultar_1;
	private JLabel lblLimpar;
	private JLabel lblSalvar;
	private JLabel lblConsultar_2;
	private JLabel lblConsultar_3;
	private JLabel lblLimpar_1;
	private JLabel lblSalvar_1;
	private JMenuItem mntmLimparTela;
	private JTextField txtRgmBoletim;
	private JTextField txtNota_2;

	private DisciplinaDAO disciplinaDAO;
	private JLabel lblLimpar_2;
	private JTable table;
	private JLabel lblNomeBoletim;
	private DefaultTableModel tableModel;
	private JLabel lblSair_1;
	private JMenuItem menuLimpar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telas frame = new Telas();
					frame.setVisible(true);
					frame.setResizable(false);
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
		setTitle("Sistema acadêmico - Roblox");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Telas.class
				.getResource("/images/4745715_classmates_communication_education_learning_media_icon (2).png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 490);

		menuBar = new JMenuBar();
		menuBar.setBorder(null);
		setJMenuBar(menuBar);

		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);

		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

		mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

		mnNewMenu = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu);

		menuSalvar_1 = new JMenuItem("Salvar");
		menuSalvar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(menuSalvar_1);

		menuAlterar_1 = new JMenuItem("Alterar");
		menuAlterar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(menuAlterar_1);

		menuConsultar_1 = new JMenuItem("Consultar");
		menuConsultar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(menuConsultar_1);

		menuExcluir_1 = new JMenuItem("Excluir");
		menuExcluir_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(menuExcluir_1);

		menuLimpar_1 = new JMenuItem("Limpar Tela");
		menuLimpar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(menuLimpar_1);

		mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);

		// acessa a tela sobre
		btnSobre = new JMenuItem("Sobre");
		btnSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Ajuda novaTela = new Tela_Ajuda();
				novaTela.setVisible(true);
				novaTela.setResizable(false);
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
		panel.setBackground(new Color(176, 224, 230));
		tabbedPane_1.addTab("Dados pessoais", null, panel, null);
		panel.setLayout(null);

		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblRgm.setBounds(22, 40, 46, 14);
		panel.add(lblRgm);

		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblDataDeNascimento.setBounds(22, 93, 180, 14);
		panel.add(lblDataDeNascimento);

		lblEnail = new JLabel("Email");
		lblEnail.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblEnail.setBounds(22, 170, 57, 14);
		panel.add(lblEnail);

		lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblEnd.setBounds(22, 217, 46, 14);
		panel.add(lblEnd);

		lblMunicpio = new JLabel("Município");
		lblMunicpio.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblMunicpio.setBounds(22, 296, 91, 20);
		panel.add(lblMunicpio);

		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblUf.setBounds(299, 299, 39, 14);
		panel.add(lblUf);

		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblCelular.setBounds(466, 296, 67, 20);
		panel.add(lblCelular);

		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblNome.setBounds(239, 39, 67, 14);
		panel.add(lblNome);

		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblCpf.setBounds(484, 40, 49, 14);
		panel.add(lblCpf);

		txtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtNascimento.setToolTipText("");
		txtNascimento.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNascimento.setBounds(210, 85, 151, 32);
		txtNascimento.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtNascimento.setPreferredSize(new Dimension(220, 50));
		txtNascimento.setBackground(Color.WHITE);
		panel.add(txtNascimento);

		txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtCelular.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtCelular.setBounds(543, 294, 208, 25);
		txtCelular.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtCelular.setPreferredSize(new Dimension(220, 50));
		txtCelular.setBackground(Color.WHITE);
		panel.add(txtCelular);

		txtRgm = new JFormattedTextField(new MaskFormatter("#########"));
		txtRgm.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtRgm.setBounds(65, 24, 151, 32);
		txtRgm.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtRgm.setPreferredSize(new Dimension(220, 50));
		txtRgm.setBackground(Color.WHITE);
		panel.add(txtRgm);
		txtRgm.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(78, 155, 283, 32);
		txtEmail.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtEmail.setPreferredSize(new Dimension(220, 50));
		txtEmail.setBackground(Color.WHITE);
		panel.add(txtEmail);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(78, 202, 283, 32);
		txtEndereco.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtEndereco.setPreferredSize(new Dimension(220, 50));
		txtEndereco.setBackground(Color.WHITE);
		panel.add(txtEndereco);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(112, 291, 166, 32);
		txtMunicipio.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtMunicipio.setPreferredSize(new Dimension(220, 50));
		txtMunicipio.setBackground(Color.WHITE);
		panel.add(txtMunicipio);

		txtNome = new JTextField();
		txtNome.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtNome.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNome.setColumns(10);
		txtNome.setBounds(305, 24, 151, 32);
		txtNome.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtNome.setPreferredSize(new Dimension(220, 50));
		txtNome.setBackground(Color.WHITE);
		panel.add(txtNome);

		cbxUf = new JComboBox();
		cbxUf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbxUf.setBorder(new LineBorder(Color.BLACK, 2, true));
		cbxUf.setPreferredSize(new Dimension(220, 50));
		cbxUf.setBackground(Color.WHITE);
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
		btnFoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFoto.setFont(new Font("Poppins", Font.PLAIN, 15));
		btnFoto.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnFoto.setPreferredSize(new Dimension(220, 50));
		btnFoto.setBackground(Color.WHITE);
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
		txtCpf.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtCpf.setPreferredSize(new Dimension(220, 50));
		txtCpf.setBackground(Color.WHITE);
		txtCpf.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		tabbedPane_1.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Curso");
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 80, 96, 49);
		panel_1.add(lblNewLabel);

		cmbCurso = new JComboBox<>();
		cmbCurso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		model.addElement("Selecione um curso");
		model.addElement("Análise e Desenvolvimento de Sistemas");
		model.addElement("Logística");
		model.addElement("Comércio Exterior");
		cmbCurso.setFont(new Font("Poppins", Font.PLAIN, 20));
		cmbCurso.setBounds(169, 80, 493, 50);
		cmbCurso.setBorder(new LineBorder(Color.BLACK, 2, true));
		cmbCurso.setPreferredSize(new Dimension(220, 50));
		cmbCurso.setBackground(Color.WHITE);
		panel_1.add(cmbCurso);
		cmbCurso.setModel(model);
		cmbCurso.setSelectedIndex(0);

		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblCampus.setBounds(69, 139, 96, 49);
		panel_1.add(lblCampus);

		cmbCampus = new JComboBox<>();
		cmbCampus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbCampus.setFont(new Font("Poppins", Font.PLAIN, 20));
		cmbCampus.setBounds(169, 139, 493, 49);

		DefaultComboBoxModel<String> modelCampus = new DefaultComboBoxModel<>();
		modelCampus.addElement("Selecione um câmpus");
		modelCampus.addElement("Guarulhos");
		modelCampus.addElement("São Paulo");
		modelCampus.addElement("São Caetano");
		panel_1.add(cmbCampus);
		cmbCampus.setModel(modelCampus);
		cmbCampus.setBorder(new LineBorder(Color.BLACK, 2, true));
		cmbCampus.setPreferredSize(new Dimension(220, 50));
		cmbCampus.setBackground(Color.WHITE);
		cmbCampus.setSelectedIndex(0);

		JLabel lblPerodo = new JLabel("Período:");
		lblPerodo.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblPerodo.setBounds(69, 209, 96, 49);
		panel_1.add(lblPerodo);

		// Restante do seu código para salvar no banco de dados...

		Matutino = new JRadioButton("Matutino");
		Matutino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Matutino.setFont(new Font("Poppins Light", Font.PLAIN, 20));
		Matutino.setBounds(184, 223, 132, 21);
		Matutino.setBorderPainted(false);
		Matutino.setContentAreaFilled(false);
		Matutino.setFocusPainted(false);
		Matutino.setOpaque(false);
		panel_1.add(Matutino);

		Vespertino = new JRadioButton("Vespertino");
		Vespertino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Vespertino.setFont(new Font("Poppins Light", Font.PLAIN, 20));
		Vespertino.setBounds(338, 223, 166, 21);
		Vespertino.setBorderPainted(false);
		Vespertino.setContentAreaFilled(false);
		Vespertino.setFocusPainted(false);
		Vespertino.setOpaque(false);
		panel_1.add(Vespertino);

		Noturno = new JRadioButton("Noturno");
		Noturno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Noturno.setFont(new Font("Poppins Light", Font.PLAIN, 20));
		Noturno.setBounds(522, 223, 166, 21);
		Noturno.setBorderPainted(false);
		Noturno.setContentAreaFilled(false);
		Noturno.setFocusPainted(false);
		Noturno.setOpaque(false);
		panel_1.add(Noturno);

		bg.add(Matutino);
		bg.add(Vespertino);
		bg.add(Noturno);

		JButton btnSair = new JButton("");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(Telas.class.getResource("/images/desligar_resized.png")));
		btnSair.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSair.setBounds(28, 268, 96, 79);
		btnSair.setBorderPainted(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setFocusPainted(false);
		btnSair.setOpaque(false);
		panel_1.add(btnSair);

		JButton btnAlterar = new JButton("");
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		btnAlterar.setBorderPainted(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setFocusPainted(false);
		btnAlterar.setOpaque(false);
		panel_1.add(btnAlterar);

		JButton btnConsultar = new JButton("");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		btnConsultar.setBorderPainted(false);
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setFocusPainted(false);
		btnConsultar.setOpaque(false);
		panel_1.add(btnConsultar);

		JButton btnLimpar = new JButton("");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbCampus.setSelectedIndex(0);
				cmbCurso.setSelectedIndex(0);
				bg.clearSelection();
				txtRGMCurso.setText("");

			}
		});
		btnLimpar.setIcon(new ImageIcon(Telas.class.getResource("/images/borracha.png")));
		btnLimpar.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnLimpar.setBounds(490, 268, 96, 79);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setFocusPainted(false);
		btnLimpar.setOpaque(false);
		panel_1.add(btnLimpar);

		JButton btnSalvar = new JButton("");
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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
		btnSalvar.setBorderPainted(false);
		btnSalvar.setContentAreaFilled(false);
		btnSalvar.setFocusPainted(false);
		btnSalvar.setOpaque(false);
		panel_1.add(btnSalvar);

		lblrgmcurso = new JLabel("RGM");
		lblrgmcurso.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblrgmcurso.setBounds(69, 21, 96, 49);
		panel_1.add(lblrgmcurso);

		txtRGMCurso = new JFormattedTextField(new MaskFormatter("#########"));
		txtRGMCurso.setFont(new Font("Poppins", Font.PLAIN, 20));
		txtRGMCurso.setBounds(169, 21, 493, 49);
		txtRGMCurso.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtRGMCurso.setPreferredSize(new Dimension(220, 50));
		txtRGMCurso.setBackground(Color.WHITE);
		panel_1.add(txtRGMCurso);
		txtRGMCurso.setColumns(10);

		lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Poppins", Font.BOLD, 15));
		lblSair.setBounds(58, 337, 61, 44);
		panel_1.add(lblSair);

		lblConsultar = new JLabel("Alterar");
		lblConsultar.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar.setBounds(191, 337, 70, 44);
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
		lblSalvar.setBounds(666, 337, 70, 44);
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
		panel_2.setBackground(new Color(176, 224, 230));
		tabbedPane_1.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblRgm_1.setBounds(10, 32, 62, 24);
		panel_2.add(lblRgm_1);

		txtRgm_1 = new JFormattedTextField(new MaskFormatter("#########"));
		txtRgm_1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtRgm_1.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtRgm_1.setColumns(10);
		txtRgm_1.setBounds(82, 18, 151, 39);
		txtRgm_1.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtRgm_1.setPreferredSize(new Dimension(220, 50));
		txtRgm_1.setBackground(Color.WHITE);
		panel_2.add(txtRgm_1);

		JLabel lblConsultaNome = new JLabel("");
		lblConsultaNome.setFont(new Font("Poppins", Font.BOLD, 18));
		lblConsultaNome.setBounds(260, 32, 255, 24);
		panel_2.add(lblConsultaNome);

		JLabel lblConsultaCurso = new JLabel("");
		lblConsultaCurso.setFont(new Font("Poppins", Font.BOLD, 18));
		lblConsultaCurso.setBounds(10, 85, 400, 24);
		panel_2.add(lblConsultaCurso);

		JLabel lblDisciplina_1 = new JLabel("Disciplina");
		lblDisciplina_1.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblDisciplina_1.setBounds(275, 139, 106, 24);
		panel_2.add(lblDisciplina_1);

		JLabel lblSemetre_1 = new JLabel("Semestre");
		lblSemetre_1.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblSemetre_1.setBounds(10, 139, 106, 24);
		panel_2.add(lblSemetre_1);

		JLabel lblNota_1 = new JLabel("Nota 1");
		lblNota_1.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblNota_1.setBounds(250, 194, 70, 24);
		panel_2.add(lblNota_1);

		cmbDisciplina = new JComboBox<>();
		cmbDisciplina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbDisciplina.setFont(new Font("Poppins", Font.PLAIN, 15));
		cmbDisciplina.setBounds(382, 124, 370, 39);
		cmbDisciplina.setModel(disciplinaModel);
		cmbDisciplina.setBorder(new LineBorder(Color.BLACK, 2, true));
		cmbDisciplina.setPreferredSize(new Dimension(220, 50));
		cmbDisciplina.setBackground(Color.WHITE);
		panel_2.add(cmbDisciplina);

		cmbSemestre = new JComboBox<>();
		cmbSemestre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbSemestre
				.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "1º", "2º", "3º", "4º", "5º", "6º" }));
		cmbSemestre.setFont(new Font("Poppins", Font.PLAIN, 15));
		cmbSemestre.setBounds(126, 124, 125, 39);
		cmbSemestre.setBorder(new LineBorder(Color.BLACK, 2, true));
		cmbSemestre.setPreferredSize(new Dimension(220, 50));
		cmbSemestre.setBackground(Color.WHITE);
		panel_2.add(cmbSemestre);

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
							disciplinaModel.addElement("Selecione uma disciplina");
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

		cmbEtapa = new JComboBox();
		cmbEtapa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbEtapa.setModel(new DefaultComboBoxModel(new String[] { "\t-", "2020 - 1", "2020 - 2", "2021 - 1", "2021 - 2",
				"2022 - 1", "2022 - 2", "2023 - 1", "2023 - 2" }));
		cmbEtapa.setFont(new Font("Poppins", Font.PLAIN, 15));
		cmbEtapa.setBounds(126, 194, 90, 31);
		cmbEtapa.setBorder(new LineBorder(Color.BLACK, 2, true));
		cmbEtapa.setPreferredSize(new Dimension(220, 50));
		cmbEtapa.setBackground(Color.WHITE);
		panel_2.add(cmbEtapa);

		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblFaltas.setBounds(550, 194, 70, 24);
		panel_2.add(lblFaltas);

		txtFaltas = new JTextField();
		txtFaltas.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtFaltas.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtFaltas.setBounds(630, 194, 60, 31);
		panel_2.add(txtFaltas);
		txtFaltas.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtFaltas.setPreferredSize(new Dimension(220, 50));
		txtFaltas.setBackground(Color.WHITE);
		txtFaltas.setColumns(10);

		JLabel lblEtapa = new JLabel("Etapa");
		lblEtapa.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblEtapa.setBounds(10, 194, 100, 24);
		panel_2.add(lblEtapa);

		txtNota_1 = new JTextField();
		txtNota_1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtNota_1.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNota_1.setColumns(10);
		txtNota_1.setBounds(319, 194, 60, 31);
		txtNota_1.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtNota_1.setPreferredSize(new Dimension(220, 50));
		txtNota_1.setBackground(Color.WHITE);
		panel_2.add(txtNota_1);

		JButton btnSair_1 = new JButton("");
		btnSair_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair_1.setContentAreaFilled(false);
		btnSair_1.setFocusPainted(false);
		btnSair_1.setBorderPainted(false);
		btnSair_1.setIcon(new ImageIcon(Telas.class.getResource("/images/desligar_resized.png")));
		btnSair_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSair_1.setBounds(52, 257, 100, 79);
		panel_2.add(btnSair_1);

		btnSair_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton btnAlterar_1 = new JButton("");
		btnAlterar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar_1.setIcon(new ImageIcon(Telas.class.getResource("/images/alterar_resized.png")));
		btnAlterar_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnAlterar_1.setBounds(196, 257, 102, 79);
		btnAlterar_1.setBorderPainted(false);
		btnAlterar_1.setContentAreaFilled(false);
		btnAlterar_1.setFocusPainted(false);
		btnAlterar_1.setOpaque(false);
		panel_2.add(btnAlterar_1);

		JButton btnConsultar_1 = new JButton("");
		btnConsultar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar_1.setIcon(new ImageIcon(Telas.class.getResource("/images/consultar_resized.png")));
		btnConsultar_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnConsultar_1.setBounds(330, 257, 100, 79);
		btnConsultar_1.setBorderPainted(false);
		btnConsultar_1.setContentAreaFilled(false);
		btnConsultar_1.setFocusPainted(false);
		btnConsultar_1.setOpaque(false);
		panel_2.add(btnConsultar_1);

		JButton btnLimpar_1 = new JButton("");
		btnLimpar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar_1.setIcon(new ImageIcon(Telas.class.getResource("/images/excluir_resized.png")));
		btnLimpar_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnLimpar_1.setBounds(476, 257, 106, 79);
		btnLimpar_1.setBorderPainted(false);
		btnLimpar_1.setContentAreaFilled(false);
		btnLimpar_1.setFocusPainted(false);
		btnLimpar_1.setOpaque(false);
		panel_2.add(btnLimpar_1);

		JButton btnSalvar_1 = new JButton("");
		btnSalvar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar_1.setIcon(new ImageIcon(Telas.class.getResource("/images/salvar_resized.png")));
		btnSalvar_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnSalvar_1.setBounds(632, 257, 100, 79);
		btnSalvar_1.setBorderPainted(false);
		btnSalvar_1.setContentAreaFilled(false);
		btnSalvar_1.setFocusPainted(false);
		btnSalvar_1.setOpaque(false);
		panel_2.add(btnSalvar_1);

		lblSair_1 = new JLabel("Sair");
		lblSair_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSair_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblSair_1.setBounds(82, 323, 61, 44);
		panel_2.add(lblSair_1);

		lblConsultar_2 = new JLabel("Alterar");
		lblConsultar_2.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar_2.setBounds(216, 323, 70, 44);
		panel_2.add(lblConsultar_2);

		lblConsultar_3 = new JLabel("Consultar");
		lblConsultar_3.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar_3.setBounds(340, 323, 96, 44);
		panel_2.add(lblConsultar_3);

		lblLimpar_1 = new JLabel("Excluir");
		lblLimpar_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblLimpar_1.setBounds(504, 323, 70, 44);
		panel_2.add(lblLimpar_1);

		lblSalvar_1 = new JLabel("Salvar");
		lblSalvar_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblSalvar_1.setBounds(661, 323, 70, 44);
		panel_2.add(lblSalvar_1);

		JLabel lblNota_2 = new JLabel("Nota 2");
		lblNota_2.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblNota_2.setBounds(400, 194, 70, 24);
		panel_2.add(lblNota_2);

		txtNota_2 = new JTextField();
		txtNota_2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtNota_2.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtNota_2.setColumns(10);
		txtNota_2.setBounds(470, 194, 60, 31);
		txtNota_2.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtNota_2.setPreferredSize(new Dimension(220, 50));
		txtNota_2.setBackground(Color.WHITE);
		panel_2.add(txtNota_2);

		JButton btnExcluir_1 = new JButton("");
		btnExcluir_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir_1.setIcon(new ImageIcon(
				Telas.class.getResource("/images/3672876_education_eraser_erasing_rubber_stationery_icon.png")));
		btnExcluir_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		btnExcluir_1.setBounds(685, 0, 70, 70);
		btnExcluir_1.setBorderPainted(false);
		btnExcluir_1.setContentAreaFilled(false);
		btnExcluir_1.setFocusPainted(false);
		btnExcluir_1.setOpaque(false);
		panel_2.add(btnExcluir_1);

		lblLimpar_2 = new JLabel("Limpar Tela");
		lblLimpar_2.setFont(new Font("Poppins", Font.BOLD, 15));
		lblLimpar_2.setBounds(675, 57, 100, 44);
		panel_2.add(lblLimpar_2);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 224, 230));
		tabbedPane_1.addTab("Boletim", null, panel_3, null);

		JButton btnGerarBoletim = new JButton("");
		btnGerarBoletim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGerarBoletim.setIcon(
				new ImageIcon(Telas.class.getResource("/images/2133056_document_eps_file_format_pdf_icon (1).png")));
		btnGerarBoletim.setToolTipText("Gerar boletim do aluno");
		btnGerarBoletim.setFont(new Font("Poppins", Font.PLAIN, 15));
		btnGerarBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarPdf();
			}
		});
		panel_3.setLayout(null);
		btnGerarBoletim.setBounds(621, 0, 121, 111);
		btnGerarBoletim.setBorderPainted(false);
		btnGerarBoletim.setContentAreaFilled(false);
		btnGerarBoletim.setFocusPainted(false);
		btnGerarBoletim.setOpaque(false);
		panel_3.add(btnGerarBoletim);

		JLabel lblRgmBoletim = new JLabel("RGM");
		lblRgmBoletim.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblRgmBoletim.setBounds(36, 42, 53, 30);
		panel_3.add(lblRgmBoletim);

		txtRgmBoletim = new JFormattedTextField(new MaskFormatter("#########"));
		txtRgmBoletim.setText("      ");
		txtRgmBoletim.setFont(new Font("Poppins", Font.PLAIN, 15));
		txtRgmBoletim.setBounds(90, 33, 334, 39);
		txtRgmBoletim.setBorder(new LineBorder(Color.BLACK, 2, true));
		txtRgmBoletim.setPreferredSize(new Dimension(220, 50));
		txtRgmBoletim.setBackground(Color.WHITE);
		panel_3.add(txtRgmBoletim);
		txtRgmBoletim.setColumns(10);

		JLabel lblConsultar_2_1 = new JLabel("Gerar boletim");
		lblConsultar_2_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar_2_1.setBounds(631, 110, 150, 21);
		panel_3.add(lblConsultar_2_1);

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Disciplina");
		tableModel.addColumn("Semestre");
		tableModel.addColumn("Média");
		tableModel.addColumn("Faltas");

		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		scrollPane.setBounds(10, 142, 770, 231);
		panel_3.add(scrollPane);

		JButton btnConsultarBoletim = new JButton("");
		btnConsultarBoletim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String rgm = txtRgmBoletim.getText().trim();

					if (txtRgmBoletim.getText().trim().equals("")) {
						throw new Exception("Digite um RGM válido.");
					}

					DisciplinaDAO dao = new DisciplinaDAO();
					DAO alunoDao = new DAO();
					AlunoModel aluno = alunoDao.consultar(rgm);

					if (aluno == null) {
						lblNomeBoletim.setText("Nome do aluno");
						tableModel.setRowCount(0);
						throw new Exception("Aluno não cadastrado.");
					}

					lblNomeBoletim.setText(aluno.getNome());

					List<DisciplinaModel> disciplinas = dao.consultarDisciplinasDoAluno(rgm);

					if (!disciplinas.isEmpty()) {
						tableModel.setRowCount(0);

						for (DisciplinaModel disciplina : disciplinas) {
							String[] dadosDisciplina = { disciplina.getNomeDisciplina(), disciplina.getSemestre(),
									String.valueOf(disciplina.getMediaNotas()),
									String.valueOf(disciplina.getFaltas()) };
							tableModel.addRow(dadosDisciplina);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não possui disciplinas cadastradas.");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnConsultarBoletim.setIcon(new ImageIcon(Telas.class.getResource("/images/consultar_resized.png")));
		btnConsultarBoletim.setBounds(472, 0, 121, 111);
		btnConsultarBoletim.setBorderPainted(false);
		btnConsultarBoletim.setContentAreaFilled(false);
		btnConsultarBoletim.setFocusPainted(false);
		btnConsultarBoletim.setOpaque(false);
		panel_3.add(btnConsultarBoletim);

		JLabel lblConsultar_2_1_1 = new JLabel("Consultar");
		lblConsultar_2_1_1.setFont(new Font("Poppins", Font.BOLD, 15));
		lblConsultar_2_1_1.setBounds(494, 110, 97, 21);
		panel_3.add(lblConsultar_2_1_1);

		lblNomeBoletim = new JLabel("Nome do aluno");
		lblNomeBoletim.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		lblNomeBoletim.setBounds(36, 101, 388, 30);
		panel_3.add(lblNomeBoletim);

//CRUD da tela Notas e Faltas		
		// Salvar
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisciplinaModel disciplina = new DisciplinaModel();
				boolean valid = false;

				try {
					valid = getDadosNotas(true);
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, a.getMessage());
				}

				if (valid) {
					disciplina.setRgm(txtRgm_1.getText());
					disciplina.setNomeDisciplina((String) cmbDisciplina.getSelectedItem());
					disciplina.setSemestre((String) cmbSemestre.getSelectedItem());

					try {
						double nota1 = Double.parseDouble(txtNota_1.getText());
						double nota2 = Double.parseDouble(txtNota_2.getText());
						double mediaNotas = (nota1 + nota2) / 2;
						disciplina.setMediaNotas(mediaNotas);

						int faltas = Integer.parseInt(txtFaltas.getText());
						disciplina.setFaltas(faltas);

						DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

						if (!disciplinaDAO.existeDisciplina(disciplina.getRgm(), disciplina.getNomeDisciplina(),
								disciplina.getSemestre())) {
							disciplinaDAO.salvarDisciplina(disciplina);
							JOptionPane.showMessageDialog(null, "Disciplina salva com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null, "Disciplina já existe.");
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,
								"Certifique-se de inserir valores válidos para as notas e faltas.");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao salvar disciplina: " + ex.getMessage());
					}
				}
			}
		});

		// Alterar
		btnAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisciplinaModel disciplina = new DisciplinaModel();
				boolean valid = false;

				try {
					valid = getDadosNotas(true);

				} catch (Exception k) {
					JOptionPane.showMessageDialog(null, k.getMessage());
				}

				if (valid) {

					disciplina.setRgm(txtRgm_1.getText());
					disciplina.setNomeDisciplina((String) cmbDisciplina.getSelectedItem());
					disciplina.setSemestre((String) cmbSemestre.getSelectedItem());

					double nota1 = Double.parseDouble(txtNota_1.getText());
					double nota2 = Double.parseDouble(txtNota_2.getText());
					double mediaNotas = (nota1 + nota2) / 2;
					disciplina.setMediaNotas(mediaNotas);

					int faltas = Integer.parseInt(txtFaltas.getText());
					disciplina.setFaltas(faltas);
					disciplina.setEtapa((String) cmbEtapa.getSelectedItem());

					try {
						DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
						if (disciplinaDAO.existeDisciplina(disciplina.getRgm(), disciplina.getNomeDisciplina(),
								disciplina.getSemestre())) {

							disciplinaDAO.atualizarDisciplina(disciplina);
							JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null,
									"Disciplina não encontrada para alteração. Você pode salvar uma nova disciplina usando o botão 'Salvar'.");
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,
								"Certifique-se de inserir valores válidos para as notas e faltas.");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao alterar disciplina: " + ex.getMessage());
					}
				}
			}
		});

		// Consultar
		btnConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
					DisciplinaModel disciplina = disciplinaDAO.consultarDisciplina(txtRgm_1.getText());
					CursoDAO cursoDAO = new CursoDAO();
					CursoModel curso = cursoDAO.consultar(txtRgm_1.getText());

					if (curso != null) {

						String nomeAluno = disciplinaDAO.consultarNomeAluno(txtRgm_1.getText());
						lblConsultaNome.setText(nomeAluno);

						String cursoAluno = disciplinaDAO.consultarCursoAluno(txtRgm_1.getText());
						lblConsultaCurso.setText(cursoAluno);

					} else {
						JOptionPane.showMessageDialog(null,
								"Nenhuma disciplina encontrada para o aluno com RGM: " + txtRgm.getText());
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar disciplina: " + ex.getMessage());
				}
			}
		});

		// Excluir
		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String rgm = txtRgm_1.getText().trim();
					String nome_disciplina = (String) cmbDisciplina.getSelectedItem();
					;
					DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

					if (!rgm.isEmpty()) {
						disciplinaDAO.excluirDisciplina(rgm, nome_disciplina);
						JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, insira um RGM válido.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir disciplina: " + ex.getMessage());
				}
			}
		});

		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRgm_1.setText("");
				lblConsultaNome.setText("");
				lblConsultaCurso.setText("");
				cmbSemestre.setSelectedIndex(-1);
				cmbEtapa.setSelectedIndex(-1);
				cmbDisciplina.setSelectedIndex(-1);
				txtNota_1.setText("");
				txtNota_2.setText("");
				txtFaltas.setText("");
			}
		});

		// CRUD menus notas e faltas
		// Salvar
		menuSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisciplinaModel disciplina = new DisciplinaModel();
				boolean valid = false;
				try {
					valid = getDadosNotas(true);
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, a.getMessage());
				}
				if (valid) {
					disciplina.setRgm(txtRgm_1.getText());
					disciplina.setNomeDisciplina((String) cmbDisciplina.getSelectedItem());
					disciplina.setSemestre((String) cmbSemestre.getSelectedItem());

					double nota1 = Double.parseDouble(txtNota_1.getText());
					double nota2 = Double.parseDouble(txtNota_2.getText());
					double mediaNotas = (nota1 + nota2) / 2;
					disciplina.setMediaNotas(mediaNotas);

					int faltas = Integer.parseInt(txtFaltas.getText());
					disciplina.setFaltas(faltas);
					disciplina.setEtapa((String) cmbEtapa.getSelectedItem());

					try {
						DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
						if (!disciplinaDAO.existeDisciplina(disciplina.getRgm(), disciplina.getNomeDisciplina(),
								disciplina.getSemestre())) {
							disciplinaDAO.salvarDisciplina(disciplina);
							JOptionPane.showMessageDialog(null, "Disciplina salva com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null, "Disciplina já existe.");
						}

					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,
								"Certifique-se de inserir valores válidos para as notas e faltas.");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao salvar disciplina: " + ex.getMessage());
					}
				}
			}
		});

		// Alterar
		menuAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisciplinaModel disciplina = new DisciplinaModel();
				boolean valid = false;

				try {
					valid = getDadosNotas(true);

				} catch (Exception k) {
					JOptionPane.showMessageDialog(null, k.getMessage());
				}

				if (valid) {

					disciplina.setRgm(txtRgm_1.getText());
					disciplina.setNomeDisciplina((String) cmbDisciplina.getSelectedItem());
					disciplina.setSemestre((String) cmbSemestre.getSelectedItem());

					double nota1 = Double.parseDouble(txtNota_1.getText());
					double nota2 = Double.parseDouble(txtNota_2.getText());
					double mediaNotas = (nota1 + nota2) / 2;
					disciplina.setMediaNotas(mediaNotas);

					int faltas = Integer.parseInt(txtFaltas.getText());
					disciplina.setFaltas(faltas);
					disciplina.setEtapa((String) cmbEtapa.getSelectedItem());

					try {
						DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
						if (disciplinaDAO.existeDisciplina(disciplina.getRgm(), disciplina.getNomeDisciplina(),
								disciplina.getSemestre())) {

							disciplinaDAO.atualizarDisciplina(disciplina);
							JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null,
									"Disciplina não encontrada para alteração. Você pode salvar uma nova disciplina usando o botão 'Salvar'.");
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,
								"Certifique-se de inserir valores válidos para as notas e faltas.");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao alterar disciplina: " + ex.getMessage());
					}
				}
			}
		});

		// Consultar
		menuConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
					DisciplinaModel disciplina = disciplinaDAO.consultarDisciplina(txtRgm_1.getText());
					CursoDAO cursoDAO = new CursoDAO();
					CursoModel curso = cursoDAO.consultar(txtRgm_1.getText());

					if (curso != null) {

						String nomeAluno = disciplinaDAO.consultarNomeAluno(txtRgm_1.getText());
						lblConsultaNome.setText(nomeAluno);

						String cursoAluno = disciplinaDAO.consultarCursoAluno(txtRgm_1.getText());
						lblConsultaCurso.setText(cursoAluno);

					} else {
						JOptionPane.showMessageDialog(null,
								"Nenhuma disciplina encontrada para o aluno com RGM: " + txtRgm.getText());
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar disciplina: " + ex.getMessage());
				}
			}
		});

		// Excluir
		menuExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String rgm = txtRgm_1.getText().trim();
					String nome_disciplina = (String) cmbDisciplina.getSelectedItem();
					;
					DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

					if (!rgm.isEmpty()) {
						disciplinaDAO.excluirDisciplina(rgm, nome_disciplina);
						JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, insira um RGM válido.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir disciplina: " + ex.getMessage());
				}
			}
		});

		// Limpar Tela menu
		menuLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRgm_1.setText("");
				lblConsultaNome.setText("");
				lblConsultaCurso.setText("");
				cmbSemestre.setSelectedIndex(-1);
				cmbEtapa.setSelectedIndex(-1);
				cmbDisciplina.setSelectedIndex(-1);
				txtNota_1.setText("");
				txtNota_2.setText("");
				txtFaltas.setText("");
			}
		});

		// ------------------------------------------------------------

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
		mntmLimparTela.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
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

	public boolean getDadosNotas(boolean att) throws Exception {
		if (att) {
			if (cmbSemestre.getSelectedItem().equals("Selecione")) {
				throw new Exception("Selecione um semestre válido");

			}
			if (cmbDisciplina.getSelectedItem().equals("Selecione uma disciplina")) {
				throw new Exception("Selecione uma disciplina válida");
			}
			if (cmbEtapa.getSelectedItem().equals("\t-")) {
				throw new Exception("Selecione um período");
			}
			if (txtNota_1.getText().isEmpty()) {
				throw new Exception("Digite uma nota válida");

			}
			if (txtNota_2.getText().isEmpty()) {
				throw new Exception("Digite uma nota válida");
			}
			if (txtFaltas.getText().isEmpty()) {
				throw new Exception("Digite o número de faltas");
			}

		}
		return true;
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

			if (!txtRgm.getText().trim().isEmpty()) {
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

		if (txtRgm.getText().trim().equals("") || txtRgm.getText().trim().length() == 0) {
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

			PdfPCell col1 = new PdfPCell(new Paragraph("Foto"));
			col1.setHorizontalAlignment(Element.ALIGN_CENTER);
			col1.setBackgroundColor(BaseColor.LIGHT_GRAY); // Set the background color
			tabela.addCell(col1);

			PdfPCell col2 = new PdfPCell(new Paragraph("RGM"));
			col2.setHorizontalAlignment(Element.ALIGN_CENTER);
			col2.setBackgroundColor(BaseColor.LIGHT_GRAY); // Set the background color
			tabela.addCell(col2);

			PdfPCell col3 = new PdfPCell(new Paragraph("Nome"));
			col3.setHorizontalAlignment(Element.ALIGN_CENTER);
			col3.setBackgroundColor(BaseColor.LIGHT_GRAY); // Set the background color
			tabela.addCell(col3);

			String buscarAluno = "SELECT * FROM aluno WHERE rgm=?";

			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(buscarAluno);
				pst.setString(1, rgm);
				rs = pst.executeQuery();

				while (rs.next()) {
					PdfPCell imageCell = new PdfPCell();
					imageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					imageCell.setBackgroundColor(BaseColor.WHITE);

					String caminho = (String) rs.getString(10);
					com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(caminho);
					imageCell.addElement(image);
					imageCell.setBorderWidth(0);
					tabela.addCell(imageCell);

					PdfPCell rgmCell = new PdfPCell(new Paragraph(rs.getString(1)));
					rgmCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					rgmCell.setBackgroundColor(BaseColor.WHITE);
					rgmCell.setBorderWidth(0);
					tabela.addCell(rgmCell);

					PdfPCell nameCell = new PdfPCell(new Paragraph(rs.getString(2)));
					nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					nameCell.setBackgroundColor(BaseColor.WHITE);
					nameCell.setBorderWidth(0);
					tabela.addCell(nameCell);
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

			documento.add(new Paragraph(" "));

			PdfPTable tabela2 = new PdfPTable(3);
			PdfPCell col4 = new PdfPCell(new Paragraph("Disciplina"));
			col4.setHorizontalAlignment(Element.ALIGN_CENTER);
			col4.setBackgroundColor(BaseColor.LIGHT_GRAY); // Set the background color
			tabela2.addCell(col4);

			PdfPCell col5 = new PdfPCell(new Paragraph("Faltas"));
			col5.setHorizontalAlignment(Element.ALIGN_CENTER);
			col5.setBackgroundColor(BaseColor.LIGHT_GRAY); // Set the background color
			tabela2.addCell(col5);

			PdfPCell col6 = new PdfPCell(new Paragraph("Média"));
			col6.setHorizontalAlignment(Element.ALIGN_CENTER);
			col6.setBackgroundColor(BaseColor.LIGHT_GRAY); // Set the background color
			tabela2.addCell(col6);

			String buscarDisciplina = "SELECT * FROM disciplina WHERE rgm=?";

			try {
				con = ConnectionFactory.getConnection();
				pst = con.prepareStatement(buscarDisciplina);
				pst.setString(1, rgm);
				rs = pst.executeQuery();

				while (rs.next()) {
					PdfPCell disciplinaCell = new PdfPCell(new Paragraph(rs.getString(3)));
					disciplinaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					disciplinaCell.setBackgroundColor(BaseColor.WHITE);
					tabela2.addCell(disciplinaCell);

					PdfPCell faltasCell = new PdfPCell(new Paragraph(rs.getString(6)));
					faltasCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					faltasCell.setBackgroundColor(BaseColor.WHITE);
					tabela2.addCell(faltasCell);

					PdfPCell mediaCell = new PdfPCell(new Paragraph(rs.getString(5)));
					mediaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					mediaCell.setBackgroundColor(BaseColor.WHITE);
					tabela2.addCell(mediaCell);
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			tabela2.setSpacingBefore(12);

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
