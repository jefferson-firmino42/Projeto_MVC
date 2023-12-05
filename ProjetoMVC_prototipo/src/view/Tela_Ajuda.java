package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Ajuda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Ajuda frame = new Tela_Ajuda();
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
	public Tela_Ajuda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 490);
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setLayout(null);
		
        setContentPane(contentPane);
        JTextArea txtInfos = new JTextArea();
        txtInfos.setEditable(false);
        txtInfos.setLineWrap(true);
        txtInfos.setWrapStyleWord(true);
        txtInfos.setFont(new Font("Poppins", Font.PLAIN, 15));
        
        txtInfos.setText("\nSobre\n\nO Sistema de Gerenciamento Acadêmico é uma aplicação MVC (Model-View-Controller) que visa automatizar o processo de registro, consulta, alteração e exclusão de informações acadêmicas de alunos. O sistema apresenta várias telas para a coleta de dados, permitindo aos usuários, principalmente administradores (professores), gerenciar eficientemente o progresso acadêmico dos alunos.\r\n\r\nTelas Principais:\r\n\r\nTela de Cadastro de Aluno:\r\nColeta dados pessoais do aluno, incluindo RGM, CPF, data de nascimento, celular, email e endereço.\r\nPermite o upload de uma foto do aluno.\r\nUtiliza um modelo MVC para a manipulação e validação dos dados.\r\n\r\nTela de Cadastro de Curso:\r\nO usuário escolhe o curso, o campus e o período do aluno.\r\nEssa tela alimenta o banco de dados com informações relacionadas ao curso.\r\n\r\nTela de Notas e Faltas:\r\nPermite que o aluno escolha as disciplinas do curso, escolhendo também o semestre da disciplina, e informações como a etapa do ano em que está cursando, suas notas e faltas.\r\nUtiliza a lógica MVC para garantir uma seleção precisa das disciplinas e das demais informações acadêmicas.\r\n\r\nTela de Boletim:\r\nExibe um boletim consolidado com as notas e faltas do aluno em todas as disciplinas e suas demais informações.\r\nUtiliza a arquitetura MVC para acessar e exibir os dados do banco de dados.\r\n\r\nFuncionalidades Adicionais:\r\n >> O sistema permite que possa haver as operações de Salvar, Alterar, Consultar, e Excluir dados, além da possibilidade de limpar a tela dos registros, através de botões e atalhos.\n>> O sistema também calcula a média das notas, obtendo duas notas e armazenando o resultado da média no banco de dados.\n>> O sistema também é responsável por restringir os dados, permitindo realizar as operações somente caso os campos apresente dados únicos ou especificados conforme o caso, a fim de evitar duplicatas ou valores inadequados.");
        
        JScrollPane scrollPane = new JScrollPane(txtInfos);
        scrollPane.setBounds(0, 0, 800, 450);
        contentPane.add(scrollPane);

        txtInfos.setCaretPosition(0);
        
        JButton btnNewButton = new JButton("VOLTAR");
        btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        scrollPane.setColumnHeaderView(btnNewButton);
        
	}
}
