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
        
        txtInfos.setText("O Sistema de Gerenciamento Acadêmico é uma aplicação MVC (Model-View-Controller) que visa automatizar o processo de registro, consulta, alteração e exclusão de informações acadêmicas de alunos. O sistema é estruturado em diferentes telas para a coleta de dados, permitindo aos usuários, principalmente administradores e professores, gerenciar eficientemente o progresso acadêmico dos alunos.\r\n\r\nTelas Principais:\r\n\r\nTela de Cadastro de Aluno:\r\nColeta dados pessoais do aluno, incluindo RGM, CPF, data de nascimento, celular, email e endereço.\r\nPermite o upload de uma foto do aluno.\r\nUtiliza um modelo MVC para a manipulação e validação dos dados.\r\n\r\nTela de Cadastro de Curso e Turma:\r\nO usuário escolhe o curso e turma do aluno.\r\nEssa tela alimenta o banco de dados com informações relacionadas ao curso e turma.\r\n\r\nTela de Seleção de Disciplinas:\r\nPermite que o aluno escolha as disciplinas do curso em que deseja se matricular.\r\nUtiliza a lógica MVC para garantir uma seleção precisa das disciplinas.\r\n\r\nTela de Lançamento de Notas e Faltas:\r\nUsuários inserem notas e faltas para cada disciplina.\r\nIntegração com o banco de dados para armazenar informações acadêmicas.\r\n\r\nTela de Boletim:\r\nExibe um boletim consolidado com as notas e faltas do aluno em todas as disciplinas.\r\nUtiliza a arquitetura MVC para acessar e exibir os dados do banco de dados.\r\n\r\nFuncionalidades Adicionais:");
        
        JScrollPane scrollPane = new JScrollPane(txtInfos);
        scrollPane.setBounds(0, 0, 800, 450);
        contentPane.add(scrollPane);

        txtInfos.setCaretPosition(0);
        
	}
}
