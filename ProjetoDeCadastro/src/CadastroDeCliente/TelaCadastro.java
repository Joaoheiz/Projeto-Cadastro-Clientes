package CadastroDeCliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;

//	protected static final String CEP_Principal = null;

	// Principal

	private JTextField Codigo_Principal;
	private JTextField CEP_Principal;
	private JTextField Endereco_Principal;
	private JTextField NumeroEndereco_Principal;
	private JTextField Telefone_Principal;
	private JTextField Celular_Principal;
	private JTextField Complemento_Principal;
	private JTextField DataFicha_Principal;
	private JTextField Bairro_Principal;
	private JTextField CidadeCodigo_Principal;
	private JTextField CidadeNome_Principal;
	private JTextField Codigo_vendedor1_Principal;
	private JTextField NomeVendedor1_Principal;
	private JTextField NomePracaRegiao_Principal;
	private JTextField NomeGrupo_Principal;
	private JTextField NomeSubGrupo_Principal;
	private JTextField Codigo_vendedor2_Principal;
	private JTextField NomeVendedor2_Principal;
	private JTextField Codigo_Praca_regiao_Principal;
	private JTextField Grupo_Principal;
	private JTextField SubGrupo_Principal;
	private JTextField Nome_Principal;
	private JEditorPane OutrasInformacoes_Principal;
	private JTextField Email_Principal;
	private JTextField EmailNF_Principal;
	private JTextField InscEst_Principal;
	private JTextField DiaBloqueio_Principal;
	private JTextField LimitePrazo_Principal;
	private JTextField SaldoLimite_Principal;
	private JComboBox<String> UF_Principal;
	private JComboBox<String> IndicadorIE_Principal;
	private JComboBox<String> Situacao_Principal;
	private JComboBox<String> Classificacao_Principal;
	private JComboBox<String> AutorizacaoPagto_Principal;
	private JComboBox<String> ModalidadeFrete_Principal;
	private JComboBox<String> Pais_Principal;

	// Pessoa Juridica
	private JTextField Contato_PessoaJuridica;
	private JTextField Comprador_PessoaJuridica;
	private JTextField Socio1_PessoaJuridica;
	private JTextField Socio2_PessoaJuridica;
	private JTextField Socio3_PessoaJuridica;
	private JTextField NomeFantasia_PessoaJuridica;
	private JTextField Celular_PessoaJuridica;
	private JTextField Fone_PessoaJuridica;
	private JTextField CNPJ_PessoaJuridica;
	private JTextField CPF1_PessoaJuridica;
	private JTextField CPF2_PessoaJuridica;
	private JTextField CPF3_PessoaJuridica;
	private JTextField RamoAtividade_PessoaJuridica;
	private JTextField InscMunicipal_PessoaJuridica;
	private JTextField Suframa_PessoaJuridica;
	private JEditorPane Observacoes_PessoaJuridica;
	private JComboBox<String> CRT_PessoaJuridica;

	// Pessoa Fisica
	private JTextField TituloEleitor_PessoaFisica;
	private JTextField CNH_PessoaFisica;
	private JTextField Naturalidade_PessoaFisica;
	private JTextField Escolaridade_PessoaFisica;
	private JTextField Profissao_PessoaFisica;
	private JTextField NomeMae_PessoaFisica;
	private JTextField NomePai_PessoaFisica;
	private JTextField Cidade_PessoaFisica;
	private JTextField RG_PessoaFisica;
	private JTextField CPF_PessoaFisica;
	private JTextField Local_PessoaFisica;
	private JTextField Conjuge_PessoaFisica;
	private JTextField Endereco_PessoaFisica;
	private JTextField Bairro_PessoaFisica;
	private JFormattedTextField DataNascimento_PessoaFisica;
	private JFormattedTextField CPFConj_PessoaFisica;
	private JFormattedTextField Telefone_PessoaFisica;
	private JFormattedTextField CEP_PessoaFisica;
	private JEditorPane Observacoes_PessoaFisica;
	private JComboBox<String> UF_PessoaFisica;
	private JComboBox<String> UF2_PessoaFisica;
	private JComboBox<String> EstadoCivil_PessoaFisica;
	private JComboBox<String> Sexo_PessoaFisica;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void desconectar(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível fechar a conexão.");
				e.printStackTrace();
			}
		}
	}

	public static Connection conectar() {
		String CLASSE_DRIVER = "com.mysql.cj.jdbc.Driver";
		String USUARIO = "root";
		String SENHA = "123456789";
		String URL_SERVIDOR = "jdbc:mysql://127.0.0.1:3307/cadastrocliente?useSSL=false";

		try {
			Class.forName(CLASSE_DRIVER);
			return DriverManager.getConnection(URL_SERVIDOR, USUARIO, SENHA);
		} catch (Exception e) {
			if (e instanceof ClassNotFoundException) {
				System.out.println("Verifique o driver de conexão.");
			} else {
				System.out.println("Verifique se o servidor está ativo.");
			}
			System.exit(-42);
			return null;
		}
	}

	public TelaCadastro() throws Exception {

		setFont(new Font("Arial", Font.PLAIN, 13));
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Tela de Cadastro");
		setForeground(Color.WHITE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(185, 50, 980, 650);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane TabPane = new JTabbedPane(JTabbedPane.TOP);
		TabPane.setBorder(new LineBorder(Color.GRAY));
		getContentPane().add(TabPane);

		// Painel Principal !!!

		JPanel Principal = new JPanel();
		Principal.setBackground(Color.WHITE);
		TabPane.addTab("Principal", null, Principal, null);
		TabPane.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(83, 15, 44, 16);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(89, 41, 38, 16);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(96, 67, 31, 16);
		lblCep.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(68, 93, 59, 16);
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(43, 119, 84, 16);
		lblComplemento.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(97, 172, 30, 16);
		lblPas.setFont(new Font("Arial", Font.PLAIN, 13));

		Codigo_Principal = new JTextField();
		Codigo_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Codigo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}

				try {

					Connection conn = conectar();

					String sql = "SELECT * FROM tela_cadastro_completo WHERE codigo like ?";

					PreparedStatement stmt = conn.prepareStatement(sql);

					stmt.setString(1, "%" + Codigo_Principal.getText());

					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {

						Nome_Principal.setText(rs.getString("nome"));
						CEP_Principal.setText(rs.getString("cep"));
						Endereco_Principal.setText(rs.getString("endereco"));
						NumeroEndereco_Principal.setText(rs.getString("numero"));
						Complemento_Principal.setText(rs.getString("complemento"));
						Bairro_Principal.setText(rs.getString("bairro"));
						CidadeCodigo_Principal.setText(rs.getString("cidade_codigo"));
						CidadeNome_Principal.setText(rs.getString("cidade_nome"));
						UF_Principal.setSelectedItem(rs.getString("uf"));
						Pais_Principal.setSelectedItem(rs.getString("pais"));
						Codigo_vendedor1_Principal.setText(rs.getString("codigo_vendedor1"));
						NomeVendedor1_Principal.setText(rs.getString("nome_vendedor1"));
						Codigo_vendedor2_Principal.setText(rs.getString("codigo_vendedor2"));
						NomeVendedor2_Principal.setText(rs.getString("nome_vendedor2"));
						Codigo_Praca_regiao_Principal.setText(rs.getString("codigo_praca_regiao"));
						NomePracaRegiao_Principal.setText(rs.getString("nome_praca_regiao"));
						Grupo_Principal.setText(rs.getString("codigo_grupo"));
						NomeGrupo_Principal.setText(rs.getString("nome_grupo"));
						SubGrupo_Principal.setText(rs.getString("codigo_sub_grupo"));
						NomeSubGrupo_Principal.setText(rs.getString("nome_sub_grupo"));
						OutrasInformacoes_Principal.setText(rs.getString("outras_informacoes"));
						DataFicha_Principal.setText(rs.getString("data_ficha"));
						Telefone_Principal.setText(rs.getString("telefone"));
						Celular_Principal.setText(rs.getString("celular"));
						Email_Principal.setText(rs.getString("email"));
						EmailNF_Principal.setText(rs.getString("emailNF"));
						InscEst_Principal.setText(rs.getString("ins_Est"));
						IndicadorIE_Principal.setSelectedItem(rs.getString("indicador_IE"));
						LimitePrazo_Principal.setText(rs.getString("limite_prazo"));
						SaldoLimite_Principal.setText(rs.getString("saldo_limite"));
						DiaBloqueio_Principal.setText(rs.getString("dias_bloqueio"));
						Situacao_Principal.setSelectedItem(rs.getString("situacao"));
						Classificacao_Principal.setSelectedItem(rs.getString("classificacao"));
						AutorizacaoPagto_Principal.setSelectedItem(rs.getString("autorizacao_pagamento"));
						ModalidadeFrete_Principal.setSelectedItem(rs.getString("modalidade_frete"));
						//
						NomeFantasia_PessoaJuridica.setText(rs.getString("nome_fantasia"));
						CNPJ_PessoaJuridica.setText(rs.getString("CNPJ"));
						RamoAtividade_PessoaJuridica.setText(rs.getString("ramo_atividade"));
						InscMunicipal_PessoaJuridica.setText(rs.getString("ins_municipal"));
						Suframa_PessoaJuridica.setText(rs.getString("ins_suframa"));
						Observacoes_PessoaJuridica.setText(rs.getString("observacoes_pf"));
						CRT_PessoaJuridica.setSelectedItem(rs.getString("reg_trib"));
						Contato_PessoaJuridica.setText(rs.getString("contato"));
						Celular_PessoaJuridica.setText(rs.getString("celular_pj"));
						Comprador_PessoaJuridica.setText(rs.getString("comprador"));
						Fone_PessoaJuridica.setText(rs.getString("fone"));
						Socio1_PessoaJuridica.setText(rs.getString("socio1"));
						CPF1_PessoaJuridica.setText(rs.getString("cpf_socio1"));
						Socio2_PessoaJuridica.setText(rs.getString("socio2"));
						CPF2_PessoaJuridica.setText(rs.getString("cpf_socio2"));
						Socio3_PessoaJuridica.setText(rs.getString("socio3"));
						CPF3_PessoaJuridica.setText(rs.getString("cpf_socio3"));
						//
						CPF_PessoaFisica.setText(rs.getString("cpf"));
						RG_PessoaFisica.setText(rs.getString("rg"));
						TituloEleitor_PessoaFisica.setText(rs.getString("titulo_eleitor"));
						CNH_PessoaFisica.setText(rs.getString("cnh"));
						EstadoCivil_PessoaFisica.setSelectedItem(rs.getString("estado_civil"));
						Sexo_PessoaFisica.setSelectedItem(rs.getString("sexo"));
						DataNascimento_PessoaFisica.setText(rs.getString("data_nascimento"));
						Naturalidade_PessoaFisica.setText(rs.getString("naturalidade"));
						UF_PessoaFisica.setSelectedItem(rs.getString("uf"));
						Escolaridade_PessoaFisica.setText(rs.getString("escolaridade"));
						Profissao_PessoaFisica.setText(rs.getString("profissao"));
						Conjuge_PessoaFisica.setText(rs.getString("conjuge"));
						CPFConj_PessoaFisica.setText(rs.getString("cpf_conjuge"));
						NomePai_PessoaFisica.setText(rs.getString("nome_pai"));
						NomeMae_PessoaFisica.setText(rs.getString("nome_mae"));
						Local_PessoaFisica.setText(rs.getString("local_ue"));
						Endereco_PessoaFisica.setText(rs.getString("endereco"));
						Bairro_PessoaFisica.setText(rs.getString("bairro"));
						Cidade_PessoaFisica.setText(rs.getString("cidade"));
						UF2_PessoaFisica.setSelectedItem(rs.getString("uf_ue"));
						CEP_PessoaFisica.setText(rs.getString("cep"));
						Telefone_PessoaFisica.setText(rs.getString("telefone"));
						Observacoes_PessoaFisica.setText(rs.getString("observacoes"));

					}

					rs.close();
					conn.close();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		Codigo_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Codigo_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Codigo_Principal.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});

		Codigo_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		Codigo_Principal.setBounds(131, 13, 90, 20);
		Codigo_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Codigo_Principal.setColumns(10);

		JLabel lblN = new JLabel("N\u00B0:");
		lblN.setBounds(464, 93, 18, 16);
		lblN.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(384, 119, 38, 16);
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(83, 145, 44, 16);
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblUf = new JLabel("UF.:");
		lblUf.setBounds(457, 145, 25, 16);
		lblUf.setFont(new Font("Arial", Font.PLAIN, 13));

		UF_Principal = new JComboBox<String>();

		UF_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		UF_Principal.setBounds(484, 143, 88, 21);
		UF_Principal.setBackground(new Color(220, 220, 220));
		UF_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		UF_Principal.addItem("RO");
		UF_Principal.addItem("RO");
		UF_Principal.addItem("AC");
		UF_Principal.addItem("AM");
		UF_Principal.addItem("RR");
		UF_Principal.addItem("PA");
		UF_Principal.addItem("AP");
		UF_Principal.addItem("MA");
		UF_Principal.addItem("PI");
		UF_Principal.addItem("CE");
		UF_Principal.addItem("RN");
		UF_Principal.addItem("PB");
		UF_Principal.addItem("PE");
		UF_Principal.addItem("AL");
		UF_Principal.addItem("SE");
		UF_Principal.addItem("BA");
		UF_Principal.addItem("MG");
		UF_Principal.addItem("ES");
		UF_Principal.addItem("RJ");
		UF_Principal.addItem("SP");
		UF_Principal.addItem("PR");
		UF_Principal.addItem("SC");
		UF_Principal.addItem("RS");
		UF_Principal.addItem("MS");
		UF_Principal.addItem("MT");
		UF_Principal.addItem("GO");
		UF_Principal.addItem("DF");

		JPanel panel = new JPanel();
		panel.setBounds(582, 15, 357, 463);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(new Color(211, 211, 211));
		Principal.setLayout(null);
		Principal.add(lblEndereo);
		Principal.add(lblCep);
		Principal.add(lblNome);
		Principal.add(lblNewLabel);
		Principal.add(lblCidade);
		Principal.add(lblComplemento);
		Principal.add(lblPas);
		Principal.add(Codigo_Principal);
		Principal.add(lblUf);
		Principal.add(UF_Principal);
		Principal.add(lblBairro);
		Principal.add(lblN);
		Principal.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel1 = new JLabel("Data da Ficha:");
		lblNewLabel1.setBounds(68, 21, 86, 14);
		lblNewLabel1.setFont(new Font("Arial", Font.PLAIN, 13));
		panel.add(lblNewLabel1);

		JLabel lblNewLabel2 = new JLabel("Telefone:");
		lblNewLabel2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel2.setBounds(102, 65, 52, 14);
		panel.add(lblNewLabel2);

		JLabel lblNewLabel3 = new JLabel("Celular:");
		lblNewLabel3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel3.setBounds(110, 90, 44, 14);
		panel.add(lblNewLabel3);

		JLabel lblNewLabel4 = new JLabel("E-mail:");
		lblNewLabel4.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel4.setBounds(113, 115, 41, 14);
		panel.add(lblNewLabel4);

		JLabel lblNewLabel5 = new JLabel("E-mail NF-e:");
		lblNewLabel5.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel5.setBounds(81, 139, 73, 14);
		panel.add(lblNewLabel5);

		JLabel lblNewLabel6 = new JLabel("Insc. Est. (IE):");
		lblNewLabel6.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel6.setBounds(70, 173, 86, 14);
		panel.add(lblNewLabel6);

		IndicadorIE_Principal = new JComboBox<>();
		IndicadorIE_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		IndicadorIE_Principal.setBackground(SystemColor.control);
		IndicadorIE_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		IndicadorIE_Principal.setBounds(164, 195, 178, 21);
		IndicadorIE_Principal.addItem("Contribuinte de ICMS");
		IndicadorIE_Principal.addItem("Não Contribuinte de ICMS");
		IndicadorIE_Principal.addItem("Contribuinte isento");
		panel.add(IndicadorIE_Principal);

		Email_Principal = new JTextField();
		Email_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Email_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Email_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Email_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Email_Principal.getText().length() >= 40) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890" + "@._-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});

		Email_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Email_Principal.setColumns(10);
		Email_Principal.setBounds(164, 112, 178, 20);
		panel.add(Email_Principal);

		EmailNF_Principal = new JTextField();
		EmailNF_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (EmailNF_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		EmailNF_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		EmailNF_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (EmailNF_Principal.getText().length() >= 40) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890" + "@_-.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});

		EmailNF_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		EmailNF_Principal.setColumns(10);
		EmailNF_Principal.setBounds(164, 136, 178, 20);
		panel.add(EmailNF_Principal);

		InscEst_Principal = new JTextField();
		InscEst_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (InscEst_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		InscEst_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		InscEst_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (InscEst_Principal.getText().length() >= 40) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		InscEst_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		InscEst_Principal.setColumns(10);
		InscEst_Principal.setBounds(164, 170, 178, 20);
		panel.add(InscEst_Principal);

		JLabel lblNewLabel7 = new JLabel("Indicador IE:");
		lblNewLabel7.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel7.setBounds(83, 198, 73, 14);
		panel.add(lblNewLabel7);

		JLabel lblNewLabel8 = new JLabel("Limite a Prazo:");
		lblNewLabel8.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel8.setBounds(70, 234, 88, 14);
		panel.add(lblNewLabel8);

		JLabel lblNewLabel9 = new JLabel("Saldo do limite:");
		lblNewLabel9.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel9.setBounds(68, 260, 90, 14);
		panel.add(lblNewLabel9);

		DiaBloqueio_Principal = new JTextField();
		DiaBloqueio_Principal.setText("__/__/____");
		DiaBloqueio_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (DiaBloqueio_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		DiaBloqueio_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		DiaBloqueio_Principal.setHorizontalAlignment(SwingConstants.LEFT);
		DiaBloqueio_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (DiaBloqueio_Principal.getText().length() >= 10) {
					e.consume();
				}

				String caracteres = "0987654321/";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		DiaBloqueio_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		DiaBloqueio_Principal.setColumns(10);
		DiaBloqueio_Principal.setBounds(164, 282, 96, 20);
		panel.add(DiaBloqueio_Principal);

		JLabel lblNewLabel10 = new JLabel("Dias do Bloqueio:");
		lblNewLabel10.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel10.setBounds(56, 285, 102, 14);
		panel.add(lblNewLabel10);

		Situacao_Principal = new JComboBox<>();
		Situacao_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Situacao_Principal.setBackground(SystemColor.control);
		Situacao_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Situacao_Principal.setBounds(164, 332, 178, 21);
		Situacao_Principal.addItem("Desbloqueado p/ venda");
		Situacao_Principal.addItem("Bloqueado p/ venda");
		panel.add(Situacao_Principal);

		Classificacao_Principal = new JComboBox<>();
		Classificacao_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Classificacao_Principal.setBackground(SystemColor.control);
		Classificacao_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Classificacao_Principal.setBounds(164, 357, 178, 21);
		Classificacao_Principal.addItem("Ativo");
		Classificacao_Principal.addItem("Inativo");
		Classificacao_Principal.addItem("Inadimplente");
		panel.add(Classificacao_Principal);

		AutorizacaoPagto_Principal = new JComboBox<>();
		AutorizacaoPagto_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		AutorizacaoPagto_Principal.setBackground(SystemColor.control);
		AutorizacaoPagto_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		AutorizacaoPagto_Principal.setBounds(164, 383, 178, 21);
		AutorizacaoPagto_Principal.addItem("Sem Restrição");
		AutorizacaoPagto_Principal.addItem("Só a Vista");
		AutorizacaoPagto_Principal.addItem("Só a Prazo");
		panel.add(AutorizacaoPagto_Principal);

		ModalidadeFrete_Principal = new JComboBox<>();
		ModalidadeFrete_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		ModalidadeFrete_Principal.setBackground(SystemColor.control);
		ModalidadeFrete_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		ModalidadeFrete_Principal.setBounds(164, 407, 178, 21);
		ModalidadeFrete_Principal.addItem("Por conta do Emitente");
		ModalidadeFrete_Principal.addItem("Por conta do Destinatário/Remetente");
		ModalidadeFrete_Principal.addItem("Por conta de Terceiros");
		ModalidadeFrete_Principal.addItem("Sem Frete");
		panel.add(ModalidadeFrete_Principal);

		JLabel lblNewLabel11 = new JLabel("Situa\u00E7\u00E3o:");
		lblNewLabel11.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel11.setBounds(101, 335, 55, 14);
		panel.add(lblNewLabel11);

		JLabel lblNewLabel12 = new JLabel("Classifica\u00E7\u00E3o:");
		lblNewLabel12.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel12.setBounds(75, 360, 81, 14);
		panel.add(lblNewLabel12);

		JLabel lblNewLabel13 = new JLabel("Autoriza\u00E7\u00E3o Pagamento:");
		lblNewLabel13.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel13.setBounds(13, 386, 143, 14);
		panel.add(lblNewLabel13);

		JLabel lblNewLabel14 = new JLabel("Modalidade Frete:");
		lblNewLabel14.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel14.setBounds(52, 410, 104, 14);
		panel.add(lblNewLabel14);

		DataFicha_Principal = new JTextField("__/__/____");
		DataFicha_Principal.setForeground(Color.BLACK);
		DataFicha_Principal.setHorizontalAlignment(SwingConstants.LEFT);
		DataFicha_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (DataFicha_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}

			}
		});
		DataFicha_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		DataFicha_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (DataFicha_Principal.getText().length() >= 10) {
					e.consume();
				}

				String caracteres = "0987654321/";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});

		DataFicha_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		DataFicha_Principal.setBounds(164, 18, 96, 20);
		panel.add(DataFicha_Principal);

		Telefone_Principal = new JTextField("(_)___-___");
		Telefone_Principal.setForeground(Color.BLACK);
		Telefone_Principal.setHorizontalAlignment(SwingConstants.LEFT);
		Telefone_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Telefone_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}

			}
		});
		Telefone_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Telefone_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Telefone_Principal.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});

		Telefone_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Telefone_Principal.setBounds(164, 62, 96, 20);
		panel.add(Telefone_Principal);

		Celular_Principal = new JTextField("(_)___-___");
		Celular_Principal.setForeground(Color.BLACK);
		Celular_Principal.setHorizontalAlignment(SwingConstants.LEFT);
		Celular_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Celular_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Celular_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Celular_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Celular_Principal.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Celular_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Celular_Principal.setBounds(164, 87, 96, 20);
		panel.add(Celular_Principal);

		LimitePrazo_Principal = new JTextField("R$0,00");
		LimitePrazo_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (LimitePrazo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		LimitePrazo_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		LimitePrazo_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (LimitePrazo_Principal.getText().length() >= 15) {
					e.consume();
				}

				String caracteres = "0987654321.,";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		LimitePrazo_Principal.setForeground(Color.BLACK);
		LimitePrazo_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		LimitePrazo_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		LimitePrazo_Principal.setBounds(164, 231, 133, 20);
		panel.add(LimitePrazo_Principal);

		SaldoLimite_Principal = new JTextField("R$0,00");
		SaldoLimite_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (SaldoLimite_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		SaldoLimite_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		SaldoLimite_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (SaldoLimite_Principal.getText().length() >= 15) {
					e.consume();
				}

				String caracteres = "0987654321.,";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		SaldoLimite_Principal.setForeground(Color.BLACK);
		SaldoLimite_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		SaldoLimite_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		SaldoLimite_Principal.setBounds(164, 257, 133, 20);
		panel.add(SaldoLimite_Principal);

		JLabel lblNewLabel_1 = new JLabel("Vendedor (1):");
		lblNewLabel_1.setBounds(49, 206, 78, 14);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Vendedor (2):");
		lblNewLabel_1_1.setBounds(49, 232, 78, 14);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Pra\u00E7a/Regi\u00E3o:");
		lblNewLabel_2.setBounds(43, 257, 84, 14);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Grupo:");
		lblNewLabel_2_1.setBounds(85, 282, 42, 14);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Sub-Grupo:");
		lblNewLabel_2_1_1.setBounds(61, 307, 66, 14);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Outras Informa\u00E7\u00F5es:");
		lblNewLabel_2_1_1_1.setBounds(10, 356, 118, 14);
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(lblNewLabel_2_1_1_1);

		Nome_Principal = new JTextField();
		Nome_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Nome_Principal.setText(Nome_Principal.getText().toUpperCase(getLocale()));

				if (Nome_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Nome_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));

		Nome_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Nome_Principal.getText().length() >= 80) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Nome_Principal.setBounds(131, 39, 441, 20);
		Nome_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Nome_Principal.setColumns(10);
		Principal.add(Nome_Principal);

		Endereco_Principal = new JTextField();
		Endereco_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Endereco_Principal.setText(Endereco_Principal.getText().toUpperCase(getLocale()));

				if (Endereco_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Endereco_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Endereco_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Endereco_Principal.getText().length() >= 80) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		Endereco_Principal.setBounds(131, 91, 327, 20);
		Endereco_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Endereco_Principal.setColumns(10);
		Principal.add(Endereco_Principal);

		NumeroEndereco_Principal = new JTextField();
		NumeroEndereco_Principal.setToolTipText("");
		NumeroEndereco_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (NumeroEndereco_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NumeroEndereco_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NumeroEndereco_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (NumeroEndereco_Principal.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		NumeroEndereco_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		NumeroEndereco_Principal.setBounds(484, 91, 88, 20);
		NumeroEndereco_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		NumeroEndereco_Principal.setColumns(10);
		Principal.add(NumeroEndereco_Principal);

		Complemento_Principal = new JTextField();
		Complemento_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Complemento_Principal.setText(Complemento_Principal.getText().toUpperCase(getLocale()));

				if (Complemento_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Complemento_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Complemento_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Complemento_Principal.getText().length() >= 40) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Complemento_Principal.setBounds(131, 117, 243, 20);
		Complemento_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Complemento_Principal.setColumns(10);
		Principal.add(Complemento_Principal);

		Bairro_Principal = new JTextField();
		Bairro_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Bairro_Principal.setText(Bairro_Principal.getText().toUpperCase(getLocale()));

				if (Bairro_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Bairro_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Bairro_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Codigo_Principal.getText().length() >= 20) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Bairro_Principal.setBounds(422, 117, 150, 20);
		Bairro_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Bairro_Principal.setColumns(10);
		Principal.add(Bairro_Principal);

		CidadeCodigo_Principal = new JTextField();
		CidadeCodigo_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CidadeCodigo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CidadeCodigo_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CidadeCodigo_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (CidadeCodigo_Principal.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		CidadeCodigo_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		CidadeCodigo_Principal.setBounds(131, 143, 90, 20);
		CidadeCodigo_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		CidadeCodigo_Principal.setColumns(10);
		Principal.add(CidadeCodigo_Principal);

		CidadeNome_Principal = new JTextField();
		CidadeNome_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CidadeNome_Principal.setText(CidadeNome_Principal.getText().toUpperCase(getLocale()));

				if (CidadeNome_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CidadeNome_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CidadeNome_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (CidadeNome_Principal.getText().length() >= 35) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		CidadeNome_Principal.setBounds(242, 143, 205, 20);
		CidadeNome_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		CidadeNome_Principal.setColumns(10);
		Principal.add(CidadeNome_Principal);

		Codigo_vendedor1_Principal = new JTextField();
		Codigo_vendedor1_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Codigo_vendedor1_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Codigo_vendedor1_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Codigo_vendedor1_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Codigo_vendedor1_Principal.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Codigo_vendedor1_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		Codigo_vendedor1_Principal.setBounds(131, 203, 90, 20);
		Codigo_vendedor1_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Codigo_vendedor1_Principal.setColumns(10);
		Principal.add(Codigo_vendedor1_Principal);

		Codigo_vendedor2_Principal = new JTextField();
		Codigo_vendedor2_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Codigo_vendedor2_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Codigo_vendedor2_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Codigo_vendedor2_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Codigo_vendedor2_Principal.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Codigo_vendedor2_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		Codigo_vendedor2_Principal.setBounds(131, 229, 90, 20);
		Codigo_vendedor2_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Codigo_vendedor2_Principal.setColumns(10);
		Principal.add(Codigo_vendedor2_Principal);

		Codigo_Praca_regiao_Principal = new JTextField();
		Codigo_Praca_regiao_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Codigo_Praca_regiao_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Codigo_Praca_regiao_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Codigo_Praca_regiao_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Codigo_Praca_regiao_Principal.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Codigo_Praca_regiao_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		Codigo_Praca_regiao_Principal.setBounds(131, 254, 90, 20);
		Codigo_Praca_regiao_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Codigo_Praca_regiao_Principal.setColumns(10);
		Principal.add(Codigo_Praca_regiao_Principal);

		Grupo_Principal = new JTextField();
		Grupo_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Grupo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Grupo_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Grupo_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Grupo_Principal.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Grupo_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		Grupo_Principal.setBounds(131, 279, 90, 20);
		Grupo_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Grupo_Principal.setColumns(10);
		Principal.add(Grupo_Principal);

		SubGrupo_Principal = new JTextField();
		SubGrupo_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (SubGrupo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		SubGrupo_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		SubGrupo_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (SubGrupo_Principal.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		SubGrupo_Principal.setHorizontalAlignment(SwingConstants.RIGHT);
		SubGrupo_Principal.setBounds(131, 304, 90, 20);
		SubGrupo_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		SubGrupo_Principal.setColumns(10);
		Principal.add(SubGrupo_Principal);

		Pais_Principal = new JComboBox<String>();
		Pais_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Pais_Principal.setBounds(131, 169, 441, 21);
		Pais_Principal.setBackground(new Color(220, 220, 220));
		Pais_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Pais_Principal.addItem("Brasil");
		Pais_Principal.addItem("Argentina");
		Pais_Principal.addItem("Alemanha");
		Pais_Principal.addItem("Estados Unidos");
		Pais_Principal.addItem("Canada");
		Pais_Principal.addItem("Japão");
		Principal.add(Pais_Principal);

		NomeVendedor1_Principal = new JTextField();
		NomeVendedor1_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				NomeVendedor1_Principal.setText(NomeVendedor1_Principal.getText().toUpperCase(getLocale()));

				if (NomeVendedor1_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NomeVendedor1_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NomeVendedor1_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (NomeVendedor1_Principal.getText().length() >= 80) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		NomeVendedor1_Principal.setBounds(242, 203, 330, 21);
		NomeVendedor1_Principal.setBackground(new Color(220, 220, 220));
		NomeVendedor1_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(NomeVendedor1_Principal);

		NomeVendedor2_Principal = new JTextField();
		NomeVendedor2_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				NomeVendedor2_Principal.setText(NomeVendedor2_Principal.getText().toUpperCase(getLocale()));

				if (NomeVendedor2_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NomeVendedor2_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NomeVendedor2_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (NomeVendedor2_Principal.getText().length() >= 80) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		NomeVendedor2_Principal.setBounds(242, 228, 330, 21);
		NomeVendedor2_Principal.setBackground(new Color(220, 220, 220));
		NomeVendedor2_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(NomeVendedor2_Principal);

		NomePracaRegiao_Principal = new JTextField();
		NomePracaRegiao_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				NomePracaRegiao_Principal.setText(NomePracaRegiao_Principal.getText().toUpperCase(getLocale()));

				if (NomePracaRegiao_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NomePracaRegiao_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NomePracaRegiao_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (NomePracaRegiao_Principal.getText().length() >= 80) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		NomePracaRegiao_Principal.setBounds(242, 254, 330, 21);
		NomePracaRegiao_Principal.setBackground(new Color(220, 220, 220));
		NomePracaRegiao_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(NomePracaRegiao_Principal);

		NomeGrupo_Principal = new JTextField();
		NomeGrupo_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				NomeGrupo_Principal.setText(NomeGrupo_Principal.getText().toUpperCase(getLocale()));

				if (NomeGrupo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NomeGrupo_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NomeGrupo_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (NomeGrupo_Principal.getText().length() >= 80) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		NomeGrupo_Principal.setBounds(242, 279, 330, 21);
		NomeGrupo_Principal.setBackground(new Color(220, 220, 220));
		NomeGrupo_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(NomeGrupo_Principal);

		NomeSubGrupo_Principal = new JTextField();
		NomeSubGrupo_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				NomeSubGrupo_Principal.setText(NomeSubGrupo_Principal.getText().toUpperCase(getLocale()));

				if (NomeSubGrupo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NomeSubGrupo_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NomeSubGrupo_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (NomeSubGrupo_Principal.getText().length() >= 80) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		NomeSubGrupo_Principal.setBounds(242, 304, 330, 21);
		NomeSubGrupo_Principal.setBackground(new Color(220, 220, 220));
		NomeSubGrupo_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		Principal.add(NomeSubGrupo_Principal);

		OutrasInformacoes_Principal = new JEditorPane();
		OutrasInformacoes_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		OutrasInformacoes_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (OutrasInformacoes_Principal.getText().length() >= 250) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		OutrasInformacoes_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		OutrasInformacoes_Principal.setBounds(132, 351, 441, 127);
		Principal.add(OutrasInformacoes_Principal);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 509, 959, 16);
		separator.setForeground(Color.GRAY);
		Principal.add(separator);

		JButton Salvar_Principal = new JButton("Salvar");
		Salvar_Principal.setToolTipText("");
		Salvar_Principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String INSERIR2 = "INSERT INTO `cadastrocliente`.`tela_cadastro_completo`\r\n" + "(`nome`,\r\n"
						+ "`cep_principal`,\r\n" + "`endereco_principal`,\r\n" + "`numero`,\r\n" + "`complemento`,\r\n"
						+ "`bairro_principal`,\r\n" + "`cidade_codigo`,\r\n" + "`cidade_nome`,\r\n"
						+ "`uf_principal`,\r\n" + "`pais`,\r\n" + "`codigo_vendedor1`,\r\n" + "`nome_vendedor1`,\r\n"
						+ "`codigo_vendedor2`,\r\n" + "`nome_vendedor2`,\r\n" + "`codigo_praca_regiao`,\r\n"
						+ "`nome_praca_regiao`,\r\n" + "`codigo_grupo`,\r\n" + "`nome_grupo`,\r\n"
						+ "`codigo_sub_grupo`,\r\n" + "`nome_sub_grupo`,\r\n" + "`outras_informacoes`,\r\n"
						+ "`data_ficha`,\r\n" + "`telefone_principal`,\r\n" + "`celular`,\r\n" + "`email`,\r\n"
						+ "`emailNF`,\r\n" + "`ins_Est`,\r\n" + "`indicador_IE`,\r\n" + "`limite_prazo`,\r\n"
						+ "`saldo_limite`,\r\n" + "`dias_bloqueio`,\r\n" + "`situacao`,\r\n" + "`classificacao`,\r\n"
						+ "`autorizacao_pagamento`,\r\n" + "`modalidade_frete`,\r\n" + "`nome_fantasia`,\r\n"
						+ "`CNPJ`,\r\n" + "`ramo_atividade`,\r\n" + "`ins_municipal`,\r\n" + "`ins_suframa`,\r\n"
						+ "`observacoes_pf`,\r\n" + "`reg_trib`,\r\n" + "`contato`,\r\n" + "`celular_pj`,\r\n"
						+ "`comprador`,\r\n" + "`fone`,\r\n" + "`socio1`,\r\n" + "`cpf_socio1`,\r\n" + "`socio2`,\r\n"
						+ "`cpf_socio2`,\r\n" + "`socio3`,\r\n" + "`cpf_socio3`,\r\n" + "`cpf`,\r\n" + "`rg`,\r\n"
						+ "`titulo_eleitor`,\r\n" + "`cnh`,\r\n" + "`estado_civil`,\r\n" + "`sexo`,\r\n"
						+ "`data_nascimento`,\r\n" + "`naturalidade`,\r\n" + "`uf`,\r\n" + "`escolaridade`,\r\n"
						+ "`profissao`,\r\n" + "`conjuge`,\r\n" + "`cpf_conjuge`,\r\n" + "`nome_pai`,\r\n"
						+ "`nome_mae`,\r\n" + "`local_ue`,\r\n" + "`endereco`,\r\n" + "`bairro`,\r\n" + "`cidade`,\r\n"
						+ "`uf_ue`,\r\n" + "`cep`,\r\n" + "`telefone`,\r\n" + "`observacoes`, \r\n" + "`codigo`)\r\n"
						+ "VALUES\r\n"
						+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? \r\n"
						+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? \r\n"
						+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				try {

					Connection conn = conectar();
					PreparedStatement salvar = conn.prepareStatement(INSERIR2);

					salvar.setString(1, Nome_Principal.getText());
					salvar.setObject(2, CEP_Principal.getText());
					salvar.setString(3, Endereco_Principal.getText());
					salvar.setString(4, NumeroEndereco_Principal.getText());
					salvar.setString(5, Complemento_Principal.getText());
					salvar.setString(6, Bairro_Principal.getText());
					salvar.setString(7, CidadeCodigo_Principal.getText());
					salvar.setString(8, CidadeNome_Principal.getText());
					salvar.setObject(9, UF_Principal.getSelectedItem());
					salvar.setObject(10, Pais_Principal.getSelectedItem());
					salvar.setString(11, Codigo_vendedor1_Principal.getText());
					salvar.setString(12, NomeVendedor1_Principal.getText());
					salvar.setString(13, Codigo_vendedor2_Principal.getText());
					salvar.setString(14, NomeVendedor2_Principal.getText());
					salvar.setString(15, Codigo_Praca_regiao_Principal.getText());
					salvar.setString(16, NomePracaRegiao_Principal.getText());
					salvar.setString(17, Grupo_Principal.getText());
					salvar.setString(18, NomeGrupo_Principal.getText());
					salvar.setString(19, SubGrupo_Principal.getText());
					salvar.setString(20, NomeSubGrupo_Principal.getText());
					salvar.setString(21, OutrasInformacoes_Principal.getText());
					salvar.setString(22, DataFicha_Principal.getText());
					salvar.setString(23, Telefone_Principal.getText());
					salvar.setString(24, Celular_Principal.getText());
					salvar.setString(25, Email_Principal.getText());
					salvar.setString(26, EmailNF_Principal.getText());
					salvar.setString(27, InscEst_Principal.getText());
					salvar.setObject(28, IndicadorIE_Principal.getSelectedItem());
					salvar.setString(29, LimitePrazo_Principal.getText());
					salvar.setString(30, SaldoLimite_Principal.getText());
					salvar.setString(31, DiaBloqueio_Principal.getText());
					salvar.setObject(32, Situacao_Principal.getSelectedItem());
					salvar.setObject(33, Classificacao_Principal.getSelectedItem());
					salvar.setObject(34, AutorizacaoPagto_Principal.getSelectedItem());
					salvar.setObject(35, ModalidadeFrete_Principal.getSelectedItem());
					//
					salvar.setString(36, NomeFantasia_PessoaJuridica.getText());
					salvar.setString(37, CNPJ_PessoaJuridica.getText());
					salvar.setString(38, RamoAtividade_PessoaJuridica.getText());
					salvar.setString(39, InscMunicipal_PessoaJuridica.getText());
					salvar.setString(40, Suframa_PessoaJuridica.getText());
					salvar.setString(41, Observacoes_PessoaJuridica.getText());
					salvar.setObject(42, CRT_PessoaJuridica.getSelectedItem());
					salvar.setString(43, Contato_PessoaJuridica.getText());
					salvar.setString(44, Celular_PessoaJuridica.getText());
					salvar.setString(45, Comprador_PessoaJuridica.getText());
					salvar.setString(46, Fone_PessoaJuridica.getText());
					salvar.setString(47, Socio1_PessoaJuridica.getText());
					salvar.setString(48, CPF1_PessoaJuridica.getText());
					salvar.setString(49, Socio2_PessoaJuridica.getText());
					salvar.setString(50, CPF2_PessoaJuridica.getText());
					salvar.setString(51, Socio3_PessoaJuridica.getText());
					salvar.setString(52, CPF3_PessoaJuridica.getText());

					salvar.setString(53, CPF_PessoaFisica.getText());
					salvar.setString(54, RG_PessoaFisica.getText());
					salvar.setString(55, TituloEleitor_PessoaFisica.getText());
					salvar.setString(56, CNH_PessoaFisica.getText());
					salvar.setObject(57, EstadoCivil_PessoaFisica.getSelectedItem());
					salvar.setObject(58, Sexo_PessoaFisica.getSelectedItem());
					salvar.setString(59, DataNascimento_PessoaFisica.getText());
					salvar.setString(60, Naturalidade_PessoaFisica.getText());
					salvar.setObject(61, UF_PessoaFisica.getSelectedItem());
					salvar.setString(62, Escolaridade_PessoaFisica.getText());
					salvar.setString(63, Profissao_PessoaFisica.getText());
					salvar.setString(64, Conjuge_PessoaFisica.getText());
					salvar.setString(65, CPFConj_PessoaFisica.getText());
					salvar.setString(66, NomePai_PessoaFisica.getText());
					salvar.setString(67, NomeMae_PessoaFisica.getText());
					salvar.setString(68, Local_PessoaFisica.getText());
					salvar.setString(69, Endereco_PessoaFisica.getText());
					salvar.setString(70, Bairro_PessoaFisica.getText());
					salvar.setString(71, Cidade_PessoaFisica.getText());
					salvar.setObject(72, UF2_PessoaFisica.getSelectedItem());
					salvar.setString(73, CEP_PessoaFisica.getText());
					salvar.setString(74, Telefone_PessoaFisica.getText());
					salvar.setString(75, Observacoes_PessoaFisica.getText());
					salvar.setString(76, Codigo_Principal.getText());

					salvar.executeUpdate();
					salvar.close();

					JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso.");

				} catch (Exception e2) {
					e2.printStackTrace();
					// JOptionPane.showMessageDialog(null, "Erro ao inserir o produto.");
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});

		Salvar_Principal.setBorder(new LineBorder(Color.GRAY));
		Salvar_Principal.setBounds(30, 522, 215, 50);
		Salvar_Principal.setBackground(Color.LIGHT_GRAY);
		Salvar_Principal.setFont(new Font("Arial", Font.PLAIN, 17));
		Principal.add(Salvar_Principal);

		JButton Limpar_Principal = new JButton("Limpar");
		Limpar_Principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// caixa de dialogo retorna um inteiro
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja Limpar todos os campos selecionados?",
						"Limpar Campos", JOptionPane.YES_NO_OPTION);

				// sim = 0, nao = 1
				if (resposta == 0) {

					Codigo_Principal.setText("");
					Endereco_Principal.setText("");
					NumeroEndereco_Principal.setText("");
					CEP_Principal.setText("_____-___");
					OutrasInformacoes_Principal.setText("");
					Complemento_Principal.setText("");
					Bairro_Principal.setText("");
					UF_Principal.setSelectedItem("RO");
					Pais_Principal.setSelectedItem("Brasil");
					IndicadorIE_Principal.setSelectedItem("Contribuinte de ICMS");
					Situacao_Principal.setSelectedItem("Desbloqueado p/ venda");
					Classificacao_Principal.setSelectedItem("Ativo");
					AutorizacaoPagto_Principal.setSelectedItem("Sem Restrição");
					ModalidadeFrete_Principal.setSelectedItem("Por conta do Emitente");
					CidadeCodigo_Principal.setText("");
					CidadeNome_Principal.setText("");
					Codigo_vendedor1_Principal.setText("");
					NomeVendedor1_Principal.setText("");
					Codigo_vendedor2_Principal.setText("");
					NomeVendedor2_Principal.setText("");
					Codigo_Praca_regiao_Principal.setText("");
					Grupo_Principal.setText("");
					SubGrupo_Principal.setText("");
					Nome_Principal.setText("");
					Email_Principal.setText("");
					EmailNF_Principal.setText("");
					InscEst_Principal.setText("");
					DiaBloqueio_Principal.setText("");
					NomePracaRegiao_Principal.setText("");
					NomeGrupo_Principal.setText("");
					NomeSubGrupo_Principal.setText("");
					DataFicha_Principal.setText("__/__/____");
					Telefone_Principal.setText("(_)____-____");
					Celular_Principal.setText("(_)____-___");
					LimitePrazo_Principal.setText("R$0,00");
					SaldoLimite_Principal.setText("R$0,00");
					DiaBloqueio_Principal.setText("__/__/____");
					//
					NomeFantasia_PessoaJuridica.setText("");
					CNPJ_PessoaJuridica.setText("__.___.___/____-__");
					RamoAtividade_PessoaJuridica.setText("");
					InscMunicipal_PessoaJuridica.setText("");
					Suframa_PessoaJuridica.setText("");
					Observacoes_PessoaJuridica.setText("");
					Contato_PessoaJuridica.setText("");
					Celular_PessoaJuridica.setText("(_)____-___");
					Comprador_PessoaJuridica.setText("");
					Fone_PessoaJuridica.setText("(_)____-___");
					Socio1_PessoaJuridica.setText("");
					CPF1_PessoaJuridica.setText("___.___.___-__");
					Socio2_PessoaJuridica.setText("");
					CPF2_PessoaJuridica.setText("___.___.___-__");
					Socio3_PessoaJuridica.setText("");
					CPF3_PessoaJuridica.setText("___.___.___-__");
					CRT_PessoaJuridica.setSelectedItem("1 - Simples Nacional");
					//
					CPF_PessoaFisica.setText("___.___.___-__");
					RG_PessoaFisica.setText("___________");
					TituloEleitor_PessoaFisica.setText("");
					CNH_PessoaFisica.setText("");
					DataNascimento_PessoaFisica.setText("__/__/____");
					Naturalidade_PessoaFisica.setText("");
					Escolaridade_PessoaFisica.setText("");
					Profissao_PessoaFisica.setText("");
					Conjuge_PessoaFisica.setText("");
					CPFConj_PessoaFisica.setText("___.___.___-__");
					NomePai_PessoaFisica.setText("");
					NomeMae_PessoaFisica.setText("");
					Local_PessoaFisica.setText("");
					Endereco_PessoaFisica.setText("");
					Bairro_PessoaFisica.setText("");
					Cidade_PessoaFisica.setText("");
					CEP_PessoaFisica.setText("_____-___");
					Telefone_PessoaFisica.setText("(_)____-____");
					Observacoes_PessoaFisica.setText("");
					EstadoCivil_PessoaFisica.setSelectedItem("Solteiro(a)");
					Sexo_PessoaFisica.setSelectedItem("Masculino");
					UF_PessoaFisica.setSelectedItem("RO");
					UF2_PessoaFisica.setSelectedItem("RO");

				}
			}
		});
		Limpar_Principal.setBorder(new LineBorder(Color.GRAY));
		Limpar_Principal.setBounds(260, 522, 215, 50);
		Limpar_Principal.setBackground(Color.LIGHT_GRAY);
		Limpar_Principal.setFont(new Font("Arial", Font.PLAIN, 17));
		Principal.add(Limpar_Principal);

		JButton Sair_Principal = new JButton("Sair");
		Sair_Principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// caixa de dialogo retorna um inteiro
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja finalizar essa operação?", "Finalizar",
						JOptionPane.YES_NO_OPTION);

				// sim = 0, nao = 1
				if (resposta == 0) {
					System.exit(0);
				}

			}
		});
		Sair_Principal.setBorder(new LineBorder(Color.GRAY));
		Sair_Principal.setBounds(715, 522, 214, 50);
		Sair_Principal.setBackground(Color.LIGHT_GRAY);
		Sair_Principal.setFont(new Font("Arial", Font.PLAIN, 17));
		Principal.add(Sair_Principal);

		CEP_Principal = new JTextField("_____-___");
		CEP_Principal.setToolTipText("");
		CEP_Principal.setForeground(Color.BLACK);
		CEP_Principal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (CEP_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});

		CEP_Principal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CEP_Principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (CEP_Principal.getText().length() >= 9) {
					e.consume();
				}

				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		CEP_Principal.setFont(new Font("Arial", Font.PLAIN, 13));
		CEP_Principal.setBounds(131, 65, 90, 20);
		Principal.add(CEP_Principal);

		JButton Atualizar_Principal = new JButton("Atualizar");
		Atualizar_Principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Codigo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o código.");
				} else {

					try {

						Connection conn = conectar();

						String atualizar = "UPDATE `cadastrocliente`.`tela_cadastro_completo` SET nome = ?, cep_principal = ?, endereco_principal = ?, numero = ?, complemento= ?, bairro_principal= ?, \r\n"
								+ "	  cidade_codigo= ?, cidade_nome= ?, uf_principal= ?, pais= ?, codigo_vendedor1= ?, nome_vendedor1= ?, codigo_vendedor2= ?,\r\n"
								+ "   nome_vendedor2= ?, codigo_praca_regiao= ?, nome_praca_regiao= ?, codigo_grupo= ?, nome_grupo= ?, codigo_sub_grupo= ?, \r\n"
								+ "   nome_sub_grupo= ?, outras_informacoes= ?, data_ficha= ?, telefone_principal= ?, celular= ?, email= ?, emailNF= ?, ins_Est= ?, \r\n"
								+ "   indicador_IE= ?, limite_prazo= ?, saldo_limite= ?, dias_bloqueio= ?, situacao= ?, classificacao= ?, autorizacao_pagamento= ?, modalidade_frete= ?, \r\n"
								+ "	  `nome_fantasia`= ?,`CNPJ`= ?,`ramo_atividade`= ?, `ins_municipal` = ?,`ins_suframa`= ?, `observacoes_pf`= ?,`reg_trib` = ?,`contato`= ?, `celular_pj`= ?,\r\n"
								+ "	  `comprador`= ?, `fone` = ?, `socio1`= ?, `cpf_socio1` = ?,`socio2` = ?, `cpf_socio2` = ?, `socio3`= ?,`cpf_socio3`= ?, \r\n"
								+ "	  `cpf`= ?, `rg` = ?,`titulo_eleitor`= ?, `cnh`= ?, `estado_civil`= ?, `sexo`= ?,`data_nascimento`= ?,`naturalidade`= ?, `uf`= ?,`escolaridade`= ?,\r\n"
								+ "   `profissao`= ?,`conjuge`= ?,`cpf_conjuge`= ?, `nome_pai`= ?, `nome_mae`= ?, `local_ue`= ?,`endereco`= ?, `bairro`= ?,\r\n"
								+ "   `cidade`= ?, `uf_ue`= ?, `cep`= ?, `telefone`= ?, `observacoes`= ? \r\n"
								+ "	WHERE codigo = ?";

						PreparedStatement stmt = conn.prepareStatement(atualizar);

						stmt.setString(1, Nome_Principal.getText());
						stmt.setString(2, CEP_Principal.getText());
						stmt.setString(3, Endereco_Principal.getText());
						stmt.setString(4, NumeroEndereco_Principal.getText());
						stmt.setString(5, Complemento_Principal.getText());
						stmt.setString(6, Bairro_Principal.getText());
						stmt.setString(7, CidadeCodigo_Principal.getText());
						stmt.setString(8, CidadeNome_Principal.getText());
						stmt.setObject(9, UF_Principal.getSelectedItem());
						stmt.setObject(10, Pais_Principal.getSelectedItem());
						stmt.setString(11, Codigo_vendedor1_Principal.getText());
						stmt.setString(12, NomeVendedor1_Principal.getText());
						stmt.setString(13, Codigo_vendedor2_Principal.getText());
						stmt.setString(14, NomeVendedor2_Principal.getText());
						stmt.setString(15, Codigo_Praca_regiao_Principal.getText());
						stmt.setString(16, NomePracaRegiao_Principal.getText());
						stmt.setString(17, Grupo_Principal.getText());
						stmt.setString(18, NomeGrupo_Principal.getText());
						stmt.setString(19, SubGrupo_Principal.getText());
						stmt.setString(20, NomeSubGrupo_Principal.getText());
						stmt.setString(21, OutrasInformacoes_Principal.getText());
						stmt.setString(22, DataFicha_Principal.getText());
						stmt.setString(23, Telefone_Principal.getText());
						stmt.setString(24, Celular_Principal.getText());
						stmt.setString(25, Email_Principal.getText());
						stmt.setString(26, EmailNF_Principal.getText());
						stmt.setString(27, InscEst_Principal.getText());
						stmt.setObject(28, IndicadorIE_Principal.getSelectedItem());
						stmt.setString(29, LimitePrazo_Principal.getText());
						stmt.setString(30, SaldoLimite_Principal.getText());
						stmt.setString(31, DiaBloqueio_Principal.getText());
						stmt.setObject(32, Situacao_Principal.getSelectedItem());
						stmt.setObject(33, Classificacao_Principal.getSelectedItem());
						stmt.setObject(34, AutorizacaoPagto_Principal.getSelectedItem());
						stmt.setObject(35, ModalidadeFrete_Principal.getSelectedItem());
						//
						stmt.setString(36, NomeFantasia_PessoaJuridica.getText());
						stmt.setString(37, CNPJ_PessoaJuridica.getText());
						stmt.setString(38, RamoAtividade_PessoaJuridica.getText());
						stmt.setString(39, InscMunicipal_PessoaJuridica.getText());
						stmt.setString(40, Suframa_PessoaJuridica.getText());
						stmt.setString(41, Observacoes_PessoaJuridica.getText());
						stmt.setObject(42, CRT_PessoaJuridica.getSelectedItem());
						stmt.setString(43, Contato_PessoaJuridica.getText());
						stmt.setString(44, Celular_PessoaJuridica.getText());
						stmt.setString(45, Comprador_PessoaJuridica.getText());
						stmt.setString(46, Fone_PessoaJuridica.getText());
						stmt.setString(47, Socio1_PessoaJuridica.getText());
						stmt.setString(48, CPF1_PessoaJuridica.getText());
						stmt.setString(49, Socio2_PessoaJuridica.getText());
						stmt.setString(50, CPF2_PessoaJuridica.getText());
						stmt.setString(51, Socio3_PessoaJuridica.getText());
						stmt.setString(52, CPF3_PessoaJuridica.getText());

						stmt.setString(53, CPF_PessoaFisica.getText());
						stmt.setString(54, RG_PessoaFisica.getText());
						stmt.setString(55, TituloEleitor_PessoaFisica.getText());
						stmt.setString(56, CNH_PessoaFisica.getText());
						stmt.setObject(57, EstadoCivil_PessoaFisica.getSelectedItem());
						stmt.setObject(58, Sexo_PessoaFisica.getSelectedItem());
						stmt.setString(59, DataNascimento_PessoaFisica.getText());
						stmt.setString(60, Naturalidade_PessoaFisica.getText());
						stmt.setObject(61, UF_PessoaFisica.getSelectedItem());
						stmt.setString(62, Escolaridade_PessoaFisica.getText());
						stmt.setString(63, Profissao_PessoaFisica.getText());
						stmt.setString(64, Conjuge_PessoaFisica.getText());
						stmt.setString(65, CPFConj_PessoaFisica.getText());
						stmt.setString(66, NomePai_PessoaFisica.getText());
						stmt.setString(67, NomeMae_PessoaFisica.getText());
						stmt.setString(68, Local_PessoaFisica.getText());
						stmt.setString(69, Endereco_PessoaFisica.getText());
						stmt.setString(70, Bairro_PessoaFisica.getText());
						stmt.setString(71, Cidade_PessoaFisica.getText());
						stmt.setObject(72, UF2_PessoaFisica.getSelectedItem());
						stmt.setString(73, CEP_PessoaFisica.getText());
						stmt.setString(74, Telefone_PessoaFisica.getText());
						stmt.setString(75, Observacoes_PessoaFisica.getText());
						stmt.setString(76, Codigo_Principal.getText());

						stmt.executeUpdate();
						stmt.close();

						int resposta = JOptionPane.showConfirmDialog(null, "Deseja atualizar o(s) campo(s) digitados?",
								"Atualizar", JOptionPane.YES_NO_CANCEL_OPTION);

						// sim = 0, nao = 1
						if (resposta == 0) {
							JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		Atualizar_Principal.setFont(new Font("Arial", Font.PLAIN, 17));
		Atualizar_Principal.setBorder(new LineBorder(Color.GRAY));
		Atualizar_Principal.setBackground(Color.LIGHT_GRAY);
		Atualizar_Principal.setBounds(487, 522, 215, 50);
		Principal.add(Atualizar_Principal);

		// Painel Pessoa Jurídica !!!

		JPanel PessoaJuridica = new JPanel();
		PessoaJuridica.setBackground(Color.WHITE);
		TabPane.addTab("Pessoa Jurídica", null, PessoaJuridica, null);
		PessoaJuridica.setLayout(null);

		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(10, 10, 390, 463);
		PessoaJuridica.add(panel_1);
		panel_1.setLayout(null);

		Contato_PessoaJuridica = new JTextField();
		Contato_PessoaJuridica.setHorizontalAlignment(SwingConstants.LEFT);
		Contato_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Contato_PessoaJuridica.setText(Contato_PessoaJuridica.getText().toUpperCase(getLocale()));

				if (Contato_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Contato_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Contato_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Contato_PessoaJuridica.getText().length() >= 120) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Contato_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Contato_PessoaJuridica.setBounds(92, 64, 260, 20);
		panel_1.add(Contato_PessoaJuridica);
		Contato_PessoaJuridica.setColumns(10);

		Comprador_PessoaJuridica = new JTextField();
		Comprador_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Comprador_PessoaJuridica.setText(Comprador_PessoaJuridica.getText().toUpperCase(getLocale()));

				if (Comprador_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Comprador_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Comprador_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Comprador_PessoaJuridica.getText().length() >= 90) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Comprador_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Comprador_PessoaJuridica.setColumns(10);
		Comprador_PessoaJuridica.setBounds(92, 138, 260, 20);
		panel_1.add(Comprador_PessoaJuridica);

		Socio1_PessoaJuridica = new JTextField();
		Socio1_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Socio1_PessoaJuridica.setText(Socio1_PessoaJuridica.getText().toUpperCase(getLocale()));

				if (Socio1_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Socio1_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Socio1_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Socio1_PessoaJuridica.getText().length() >= 90) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Socio1_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Socio1_PessoaJuridica.setColumns(10);
		Socio1_PessoaJuridica.setBounds(92, 214, 260, 20);
		panel_1.add(Socio1_PessoaJuridica);

		Socio3_PessoaJuridica = new JTextField();
		Socio3_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Socio3_PessoaJuridica.setText(Socio3_PessoaJuridica.getText().toUpperCase(getLocale()));

				if (Socio3_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Socio3_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Socio3_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Socio3_PessoaJuridica.getText().length() >= 90) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Socio3_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Socio3_PessoaJuridica.setColumns(10);
		Socio3_PessoaJuridica.setBounds(92, 314, 260, 20);
		panel_1.add(Socio3_PessoaJuridica);

		JLabel lblNewLabel_3 = new JLabel("Contato:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(43, 67, 49, 14);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Celular:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(48, 89, 44, 14);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Comprador:");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3_1_1.setBounds(25, 141, 67, 14);
		panel_1.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Fone:");
		lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3_1_1_1.setBounds(59, 163, 33, 14);
		panel_1.add(lblNewLabel_3_1_1_1);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("S\u00F3cio (1):");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3_1_1_1_1.setBounds(36, 217, 56, 14);
		panel_1.add(lblNewLabel_3_1_1_1_1);

		JLabel lblNewLabel_3_1_1_1_1_3 = new JLabel("CPF:");
		lblNewLabel_3_1_1_1_1_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3_1_1_1_1_3.setBounds(62, 239, 30, 14);
		panel_1.add(lblNewLabel_3_1_1_1_1_3);

		JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("S\u00F3cio (3):");
		lblNewLabel_3_1_1_1_1_2.setBounds(36, 317, 56, 14);
		panel_1.add(lblNewLabel_3_1_1_1_1_2);
		lblNewLabel_3_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNewLabel_3_1_1_1_1_3_2 = new JLabel("CPF:");
		lblNewLabel_3_1_1_1_1_3_2.setBounds(62, 339, 30, 14);
		panel_1.add(lblNewLabel_3_1_1_1_1_3_2);
		lblNewLabel_3_1_1_1_1_3_2.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("S\u00F3cio (2):");
		lblNewLabel_3_1_1_1_1_1.setBounds(36, 267, 56, 14);
		panel_1.add(lblNewLabel_3_1_1_1_1_1);
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));

		Socio2_PessoaJuridica = new JTextField();
		Socio2_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Socio2_PessoaJuridica.setText(Socio2_PessoaJuridica.getText().toUpperCase(getLocale()));

				if (Socio2_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Socio2_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Socio2_PessoaJuridica.setBounds(92, 264, 260, 20);
		panel_1.add(Socio2_PessoaJuridica);
		Socio2_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Socio2_PessoaJuridica.getText().length() >= 90) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Socio2_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Socio2_PessoaJuridica.setColumns(10);

		JLabel lblNewLabel_3_1_1_1_1_3_1 = new JLabel("CPF:");
		lblNewLabel_3_1_1_1_1_3_1.setBounds(62, 289, 30, 14);
		panel_1.add(lblNewLabel_3_1_1_1_1_3_1);
		lblNewLabel_3_1_1_1_1_3_1.setFont(new Font("Arial", Font.PLAIN, 13));

		Celular_PessoaJuridica = new JFormattedTextField("(_)____-___");
		Celular_PessoaJuridica.setForeground(Color.BLACK);
		Celular_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Celular_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Celular_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Celular_PessoaJuridica.setHorizontalAlignment(SwingConstants.LEFT);
		Celular_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Celular_PessoaJuridica.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Celular_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Celular_PessoaJuridica.setBounds(92, 86, 112, 20);
		panel_1.add(Celular_PessoaJuridica);

		Fone_PessoaJuridica = new JFormattedTextField("(_)____-___");
		Fone_PessoaJuridica.setForeground(Color.BLACK);
		Fone_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Fone_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Fone_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Fone_PessoaJuridica.setHorizontalAlignment(SwingConstants.LEFT);
		Fone_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Fone_PessoaJuridica.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Fone_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Fone_PessoaJuridica.setBounds(92, 160, 112, 20);
		panel_1.add(Fone_PessoaJuridica);

		CPF1_PessoaJuridica = new JFormattedTextField("___.___.___-__");
		CPF1_PessoaJuridica.setForeground(Color.BLACK);
		CPF1_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CPF1_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CPF1_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CPF1_PessoaJuridica.setHorizontalAlignment(SwingConstants.LEFT);
		CPF1_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (CPF1_PessoaJuridica.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		CPF1_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		CPF1_PessoaJuridica.setBounds(92, 236, 112, 20);
		panel_1.add(CPF1_PessoaJuridica);

		CPF2_PessoaJuridica = new JFormattedTextField("___.___.___-__");
		CPF2_PessoaJuridica.setForeground(Color.BLACK);
		CPF2_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CPF2_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CPF2_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CPF2_PessoaJuridica.setHorizontalAlignment(SwingConstants.LEFT);
		CPF2_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (CPF2_PessoaJuridica.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		CPF2_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		CPF2_PessoaJuridica.setBounds(92, 286, 112, 20);
		panel_1.add(CPF2_PessoaJuridica);

		CPF3_PessoaJuridica = new JFormattedTextField("___.___.___-__");
		CPF3_PessoaJuridica.setForeground(Color.BLACK);
		CPF3_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CPF3_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CPF3_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CPF3_PessoaJuridica.setHorizontalAlignment(SwingConstants.LEFT);
		CPF3_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (CPF3_PessoaJuridica.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		CPF3_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		CPF3_PessoaJuridica.setBounds(92, 336, 112, 20);
		panel_1.add(CPF3_PessoaJuridica);

		NomeFantasia_PessoaJuridica = new JTextField();
		NomeFantasia_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		NomeFantasia_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				NomeFantasia_PessoaJuridica.setText(NomeFantasia_PessoaJuridica.getText().toUpperCase(getLocale()));

				if (NomeFantasia_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NomeFantasia_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NomeFantasia_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (NomeFantasia_PessoaJuridica.getText().length() >= 90) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		NomeFantasia_PessoaJuridica.setBounds(561, 55, 368, 20);
		PessoaJuridica.add(NomeFantasia_PessoaJuridica);
		NomeFantasia_PessoaJuridica.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nome Fantasia:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(460, 58, 92, 14);
		PessoaJuridica.add(lblNewLabel_4);

		CNPJ_PessoaJuridica = new JTextField("__.___.___/____-__");
		CNPJ_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CNPJ_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CNPJ_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CNPJ_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (CNPJ_PessoaJuridica.getText().length() >= 14) {
					e.consume();
				}

				String caracteres = "0987654321./-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		CNPJ_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		CNPJ_PessoaJuridica.setColumns(10);
		CNPJ_PessoaJuridica.setBounds(561, 80, 166, 20);
		PessoaJuridica.add(CNPJ_PessoaJuridica);

		JLabel lblNewLabel_4_1 = new JLabel("CNPJ:");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(515, 83, 37, 14);
		PessoaJuridica.add(lblNewLabel_4_1);

		RamoAtividade_PessoaJuridica = new JTextField();
		RamoAtividade_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		RamoAtividade_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				RamoAtividade_PessoaJuridica.setText(RamoAtividade_PessoaJuridica.getText().toUpperCase(getLocale()));

				if (RamoAtividade_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		RamoAtividade_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		RamoAtividade_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (RamoAtividade_PessoaJuridica.getText().length() >= 40) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		RamoAtividade_PessoaJuridica.setColumns(10);
		RamoAtividade_PessoaJuridica.setBounds(561, 123, 368, 20);
		PessoaJuridica.add(RamoAtividade_PessoaJuridica);

		InscMunicipal_PessoaJuridica = new JTextField();
		InscMunicipal_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (InscMunicipal_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		InscMunicipal_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		InscMunicipal_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (InscMunicipal_PessoaJuridica.getText().length() >= 25) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		InscMunicipal_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		InscMunicipal_PessoaJuridica.setColumns(10);
		InscMunicipal_PessoaJuridica.setBounds(561, 148, 166, 20);
		PessoaJuridica.add(InscMunicipal_PessoaJuridica);

		JLabel lblNewLabel_4_2 = new JLabel("Ramo Atividade:");
		lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4_2.setBounds(460, 126, 94, 14);
		PessoaJuridica.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_2_1 = new JLabel("Insc. Municipal:");
		lblNewLabel_4_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4_2_1.setBounds(462, 151, 92, 14);
		PessoaJuridica.add(lblNewLabel_4_2_1);

		JCheckBox ServicoSubsTributario_PessoaJuridica = new JCheckBox(
				"Tomador de Servi\u00E7o Substituto Tribut\u00E1rio");
		ServicoSubsTributario_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		ServicoSubsTributario_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		ServicoSubsTributario_PessoaJuridica.setBounds(561, 177, 259, 23);
		PessoaJuridica.add(ServicoSubsTributario_PessoaJuridica);

		JCheckBox Revendedor_PessoaJuridica = new JCheckBox("Revendedor");
		Revendedor_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Revendedor_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Revendedor_PessoaJuridica.setBounds(561, 203, 92, 23);
		PessoaJuridica.add(Revendedor_PessoaJuridica);

		Suframa_PessoaJuridica = new JTextField();
		Suframa_PessoaJuridica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Suframa_PessoaJuridica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Suframa_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Suframa_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Suframa_PessoaJuridica.getText().length() >= 20) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Suframa_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Suframa_PessoaJuridica.setColumns(10);
		Suframa_PessoaJuridica.setBounds(561, 233, 166, 20);
		PessoaJuridica.add(Suframa_PessoaJuridica);

		JLabel lblNewLabel_4_2_1_1 = new JLabel("Insc. Suframa:");
		lblNewLabel_4_2_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4_2_1_1.setBounds(470, 236, 84, 14);
		PessoaJuridica.add(lblNewLabel_4_2_1_1);

		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("Observa\u00E7\u00F5es:");
		lblNewLabel_4_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4_2_1_1_1.setBounds(475, 266, 79, 14);
		PessoaJuridica.add(lblNewLabel_4_2_1_1_1);

		CRT_PessoaJuridica = new JComboBox<>();
		CRT_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CRT_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		CRT_PessoaJuridica.setBackground(new Color(220, 220, 220));
		CRT_PessoaJuridica.setBounds(561, 452, 368, 21);
		CRT_PessoaJuridica.addItem("1 - Simples Nacional");
		CRT_PessoaJuridica.addItem("2 - Simples Nacional - excesso de sublimite da receita bruta");
		CRT_PessoaJuridica.addItem("3 - Regime Normal");
		CRT_PessoaJuridica.addItem("4 - Simples Nacional - Microempreendedor Individual (MEI)");
		PessoaJuridica.add(CRT_PessoaJuridica);

		JLabel lblNewLabel_4_2_1_1_1_1 = new JLabel("Reg. Trib. (CRT):");
		lblNewLabel_4_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_4_2_1_1_1_1.setBounds(457, 455, 97, 14);
		PessoaJuridica.add(lblNewLabel_4_2_1_1_1_1);

		Observacoes_PessoaJuridica = new JEditorPane();
		Observacoes_PessoaJuridica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Observacoes_PessoaJuridica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Observacoes_PessoaJuridica.getText().length() >= 350) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Observacoes_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
		Observacoes_PessoaJuridica.setBounds(561, 264, 368, 177);
		PessoaJuridica.add(Observacoes_PessoaJuridica);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(0, 509, 959, 16);
		PessoaJuridica.add(separator_1);

		JButton Salvar_PessoaJuridica = new JButton("Salvar");
		Salvar_PessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String INSERIR2 = "INSERT INTO `cadastrocliente`.`tela_cadastro_completo`\r\n" + "(`nome`,\r\n"
						+ "`cep_principal`,\r\n" + "`endereco_principal`,\r\n" + "`numero`,\r\n" + "`complemento`,\r\n"
						+ "`bairro_principal`,\r\n" + "`cidade_codigo`,\r\n" + "`cidade_nome`,\r\n"
						+ "`uf_principal`,\r\n" + "`pais`,\r\n" + "`codigo_vendedor1`,\r\n" + "`nome_vendedor1`,\r\n"
						+ "`codigo_vendedor2`,\r\n" + "`nome_vendedor2`,\r\n" + "`codigo_praca_regiao`,\r\n"
						+ "`nome_praca_regiao`,\r\n" + "`codigo_grupo`,\r\n" + "`nome_grupo`,\r\n"
						+ "`codigo_sub_grupo`,\r\n" + "`nome_sub_grupo`,\r\n" + "`outras_informacoes`,\r\n"
						+ "`data_ficha`,\r\n" + "`telefone_principal`,\r\n" + "`celular`,\r\n" + "`email`,\r\n"
						+ "`emailNF`,\r\n" + "`ins_Est`,\r\n" + "`indicador_IE`,\r\n" + "`limite_prazo`,\r\n"
						+ "`saldo_limite`,\r\n" + "`dias_bloqueio`,\r\n" + "`situacao`,\r\n" + "`classificacao`,\r\n"
						+ "`autorizacao_pagamento`,\r\n" + "`modalidade_frete`,\r\n" + "`nome_fantasia`,\r\n"
						+ "`CNPJ`,\r\n" + "`ramo_atividade`,\r\n" + "`ins_municipal`,\r\n" + "`ins_suframa`,\r\n"
						+ "`observacoes_pf`,\r\n" + "`reg_trib`,\r\n" + "`contato`,\r\n" + "`celular_pj`,\r\n"
						+ "`comprador`,\r\n" + "`fone`,\r\n" + "`socio1`,\r\n" + "`cpf_socio1`,\r\n" + "`socio2`,\r\n"
						+ "`cpf_socio2`,\r\n" + "`socio3`,\r\n" + "`cpf_socio3`,\r\n" + "`cpf`,\r\n" + "`rg`,\r\n"
						+ "`titulo_eleitor`,\r\n" + "`cnh`,\r\n" + "`estado_civil`,\r\n" + "`sexo`,\r\n"
						+ "`data_nascimento`,\r\n" + "`naturalidade`,\r\n" + "`uf`,\r\n" + "`escolaridade`,\r\n"
						+ "`profissao`,\r\n" + "`conjuge`,\r\n" + "`cpf_conjuge`,\r\n" + "`nome_pai`,\r\n"
						+ "`nome_mae`,\r\n" + "`local_ue`,\r\n" + "`endereco`,\r\n" + "`bairro`,\r\n" + "`cidade`,\r\n"
						+ "`uf_ue`,\r\n" + "`cep`,\r\n" + "`telefone`,\r\n" + "`observacoes`, \r\n" + "`codigo`)\r\n"
						+ "VALUES\r\n"
						+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? \r\n"
						+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? \r\n"
						+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				try {

					Connection conn = conectar();
					PreparedStatement salvar = conn.prepareStatement(INSERIR2);

					salvar.setString(1, Nome_Principal.getText());
					salvar.setObject(2, CEP_Principal.getText());
					salvar.setString(3, Endereco_Principal.getText());
					salvar.setString(4, NumeroEndereco_Principal.getText());
					salvar.setString(5, Complemento_Principal.getText());
					salvar.setString(6, Bairro_Principal.getText());
					salvar.setString(7, CidadeCodigo_Principal.getText());
					salvar.setString(8, CidadeNome_Principal.getText());
					salvar.setObject(9, UF_Principal.getSelectedItem());
					salvar.setObject(10, Pais_Principal.getSelectedItem());
					salvar.setString(11, Codigo_vendedor1_Principal.getText());
					salvar.setString(12, NomeVendedor1_Principal.getText());
					salvar.setString(13, Codigo_vendedor2_Principal.getText());
					salvar.setString(14, NomeVendedor2_Principal.getText());
					salvar.setString(15, Codigo_Praca_regiao_Principal.getText());
					salvar.setString(16, NomePracaRegiao_Principal.getText());
					salvar.setString(17, Grupo_Principal.getText());
					salvar.setString(18, NomeGrupo_Principal.getText());
					salvar.setString(19, SubGrupo_Principal.getText());
					salvar.setString(20, NomeSubGrupo_Principal.getText());
					salvar.setString(21, OutrasInformacoes_Principal.getText());
					salvar.setString(22, DataFicha_Principal.getText());
					salvar.setString(23, Telefone_Principal.getText());
					salvar.setString(24, Celular_Principal.getText());
					salvar.setString(25, Email_Principal.getText());
					salvar.setString(26, EmailNF_Principal.getText());
					salvar.setString(27, InscEst_Principal.getText());
					salvar.setObject(28, IndicadorIE_Principal.getSelectedItem());
					salvar.setString(29, LimitePrazo_Principal.getText());
					salvar.setString(30, SaldoLimite_Principal.getText());
					salvar.setString(31, DiaBloqueio_Principal.getText());
					salvar.setObject(32, Situacao_Principal.getSelectedItem());
					salvar.setObject(33, Classificacao_Principal.getSelectedItem());
					salvar.setObject(34, AutorizacaoPagto_Principal.getSelectedItem());
					salvar.setObject(35, ModalidadeFrete_Principal.getSelectedItem());
					//
					salvar.setString(36, NomeFantasia_PessoaJuridica.getText());
					salvar.setString(37, CNPJ_PessoaJuridica.getText());
					salvar.setString(38, RamoAtividade_PessoaJuridica.getText());
					salvar.setString(39, InscMunicipal_PessoaJuridica.getText());
					salvar.setString(40, Suframa_PessoaJuridica.getText());
					salvar.setString(41, Observacoes_PessoaJuridica.getText());
					salvar.setObject(42, CRT_PessoaJuridica.getSelectedItem());
					salvar.setString(43, Contato_PessoaJuridica.getText());
					salvar.setString(44, Celular_PessoaJuridica.getText());
					salvar.setString(45, Comprador_PessoaJuridica.getText());
					salvar.setString(46, Fone_PessoaJuridica.getText());
					salvar.setString(47, Socio1_PessoaJuridica.getText());
					salvar.setString(48, CPF1_PessoaJuridica.getText());
					salvar.setString(49, Socio2_PessoaJuridica.getText());
					salvar.setString(50, CPF2_PessoaJuridica.getText());
					salvar.setString(51, Socio3_PessoaJuridica.getText());
					salvar.setString(52, CPF3_PessoaJuridica.getText());

					salvar.setString(53, CPF_PessoaFisica.getText());
					salvar.setString(54, RG_PessoaFisica.getText());
					salvar.setString(55, TituloEleitor_PessoaFisica.getText());
					salvar.setString(56, CNH_PessoaFisica.getText());
					salvar.setObject(57, EstadoCivil_PessoaFisica.getSelectedItem());
					salvar.setObject(58, Sexo_PessoaFisica.getSelectedItem());
					salvar.setString(59, DataNascimento_PessoaFisica.getText());
					salvar.setString(60, Naturalidade_PessoaFisica.getText());
					salvar.setObject(61, UF_PessoaFisica.getSelectedItem());
					salvar.setString(62, Escolaridade_PessoaFisica.getText());
					salvar.setString(63, Profissao_PessoaFisica.getText());
					salvar.setString(64, Conjuge_PessoaFisica.getText());
					salvar.setString(65, CPFConj_PessoaFisica.getText());
					salvar.setString(66, NomePai_PessoaFisica.getText());
					salvar.setString(67, NomeMae_PessoaFisica.getText());
					salvar.setString(68, Local_PessoaFisica.getText());
					salvar.setString(69, Endereco_PessoaFisica.getText());
					salvar.setString(70, Bairro_PessoaFisica.getText());
					salvar.setString(71, Cidade_PessoaFisica.getText());
					salvar.setObject(72, UF2_PessoaFisica.getSelectedItem());
					salvar.setString(73, CEP_PessoaFisica.getText());
					salvar.setString(74, Telefone_PessoaFisica.getText());
					salvar.setString(75, Observacoes_PessoaFisica.getText());
					salvar.setString(76, Codigo_Principal.getText());

					salvar.executeUpdate();
					salvar.close();

					JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso.");

				} catch (Exception e2) {
					e2.printStackTrace();
					// JOptionPane.showMessageDialog(null, "Erro ao inserir o produto.");
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		Salvar_PessoaJuridica.setBorder(new LineBorder(Color.GRAY));
		Salvar_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 17));
		Salvar_PessoaJuridica.setBackground(Color.LIGHT_GRAY);
		Salvar_PessoaJuridica.setBounds(30, 522, 215, 50);
		PessoaJuridica.add(Salvar_PessoaJuridica);

		JButton Limpar_PessoaJuridica = new JButton("Limpar");
		Limpar_PessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// caixa de dialogo retorna um inteiro
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja Limpar todos os campos da tela?",
						"Limpar Campos", JOptionPane.YES_NO_OPTION);

				// sim = 0, nao = 1
				if (resposta == 0) {

					Codigo_Principal.setText("");
					Endereco_Principal.setText("");
					NumeroEndereco_Principal.setText("");
					CEP_Principal.setText("_____-___");
					OutrasInformacoes_Principal.setText("");
					Complemento_Principal.setText("");
					Bairro_Principal.setText("");
					UF_Principal.setSelectedItem("RO");
					Pais_Principal.setSelectedItem("Brasil");
					IndicadorIE_Principal.setSelectedItem("Contribuinte de ICMS");
					Situacao_Principal.setSelectedItem("Desbloqueado p/ venda");
					Classificacao_Principal.setSelectedItem("Ativo");
					AutorizacaoPagto_Principal.setSelectedItem("Sem Restrição");
					ModalidadeFrete_Principal.setSelectedItem("Por conta do Emitente");
					CidadeCodigo_Principal.setText("");
					CidadeNome_Principal.setText("");
					Codigo_vendedor1_Principal.setText("");
					NomeVendedor1_Principal.setText("");
					Codigo_vendedor2_Principal.setText("");
					NomeVendedor2_Principal.setText("");
					Codigo_Praca_regiao_Principal.setText("");
					Grupo_Principal.setText("");
					SubGrupo_Principal.setText("");
					Nome_Principal.setText("");
					Email_Principal.setText("");
					EmailNF_Principal.setText("");
					InscEst_Principal.setText("");
					DiaBloqueio_Principal.setText("");
					NomePracaRegiao_Principal.setText("");
					NomeGrupo_Principal.setText("");
					NomeSubGrupo_Principal.setText("");
					DataFicha_Principal.setText("__/__/____");
					Telefone_Principal.setText("(_)____-____");
					Celular_Principal.setText("(_)____-___");
					LimitePrazo_Principal.setText("R$0,00");
					SaldoLimite_Principal.setText("R$0,00");
					DiaBloqueio_Principal.setText("__/__/____");
					//
					NomeFantasia_PessoaJuridica.setText("");
					CNPJ_PessoaJuridica.setText("__.___.___/____-__");
					RamoAtividade_PessoaJuridica.setText("");
					InscMunicipal_PessoaJuridica.setText("");
					Suframa_PessoaJuridica.setText("");
					Observacoes_PessoaJuridica.setText("");
					Contato_PessoaJuridica.setText("");
					Celular_PessoaJuridica.setText("(_)____-___");
					Comprador_PessoaJuridica.setText("");
					Fone_PessoaJuridica.setText("(_)____-___");
					Socio1_PessoaJuridica.setText("");
					CPF1_PessoaJuridica.setText("___.___.___-__");
					Socio2_PessoaJuridica.setText("");
					CPF2_PessoaJuridica.setText("___.___.___-__");
					Socio3_PessoaJuridica.setText("");
					CPF3_PessoaJuridica.setText("___.___.___-__");
					CRT_PessoaJuridica.setSelectedItem("1 - Simples Nacional");
					//
					CPF_PessoaFisica.setText("___.___.___-__");
					RG_PessoaFisica.setText("___________");
					TituloEleitor_PessoaFisica.setText("");
					CNH_PessoaFisica.setText("");
					DataNascimento_PessoaFisica.setText("__/__/____");
					Naturalidade_PessoaFisica.setText("");
					Escolaridade_PessoaFisica.setText("");
					Profissao_PessoaFisica.setText("");
					Conjuge_PessoaFisica.setText("");
					CPFConj_PessoaFisica.setText("___.___.___-__");
					NomePai_PessoaFisica.setText("");
					NomeMae_PessoaFisica.setText("");
					Local_PessoaFisica.setText("");
					Endereco_PessoaFisica.setText("");
					Bairro_PessoaFisica.setText("");
					Cidade_PessoaFisica.setText("");
					CEP_PessoaFisica.setText("_____-___");
					Telefone_PessoaFisica.setText("(_)____-____");
					Observacoes_PessoaFisica.setText("");
					EstadoCivil_PessoaFisica.setSelectedItem("Solteiro(a)");
					Sexo_PessoaFisica.setSelectedItem("Masculino");
					UF_PessoaFisica.setSelectedItem("RO");
					UF2_PessoaFisica.setSelectedItem("RO");

				}
			}
		});
		Limpar_PessoaJuridica.setBorder(new LineBorder(Color.GRAY));
		Limpar_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 17));
		Limpar_PessoaJuridica.setBackground(Color.LIGHT_GRAY);
		Limpar_PessoaJuridica.setBounds(260, 522, 215, 50);
		PessoaJuridica.add(Limpar_PessoaJuridica);

		JButton Sair_PessoaJuridica = new JButton("Sair");
		Sair_PessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// caixa de dialogo retorna um inteiro
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja finalizar essa operação?", "Finalizar",
						JOptionPane.YES_NO_OPTION);

				// sim = 0, nao = 1
				if (resposta == 0) {
					System.exit(0);
				}

			}
		});
		Sair_PessoaJuridica.setBorder(new LineBorder(Color.GRAY));
		Sair_PessoaJuridica.setFont(new Font("Arial", Font.PLAIN, 17));
		Sair_PessoaJuridica.setBackground(Color.LIGHT_GRAY);
		Sair_PessoaJuridica.setBounds(715, 522, 214, 50);
		PessoaJuridica.add(Sair_PessoaJuridica);

		JButton Atualizar_Pessoa_Juridica = new JButton("Atualizar");
		Atualizar_Pessoa_Juridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Codigo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o código.");
				} else {

					try {

						Connection conn = conectar();

						String atualizar = "UPDATE `cadastrocliente`.`tela_cadastro_completo` SET nome = ?, cep_principal = ?, endereco_principal = ?, numero = ?, complemento= ?, bairro_principal= ?, \r\n"
								+ "	  cidade_codigo= ?, cidade_nome= ?, uf_principal= ?, pais= ?, codigo_vendedor1= ?, nome_vendedor1= ?, codigo_vendedor2= ?,\r\n"
								+ "   nome_vendedor2= ?, codigo_praca_regiao= ?, nome_praca_regiao= ?, codigo_grupo= ?, nome_grupo= ?, codigo_sub_grupo= ?, \r\n"
								+ "   nome_sub_grupo= ?, outras_informacoes= ?, data_ficha= ?, telefone_principal= ?, celular= ?, email= ?, emailNF= ?, ins_Est= ?, \r\n"
								+ "   indicador_IE= ?, limite_prazo= ?, saldo_limite= ?, dias_bloqueio= ?, situacao= ?, classificacao= ?, autorizacao_pagamento= ?, modalidade_frete= ?, \r\n"
								+ "	  `nome_fantasia`= ?,`CNPJ`= ?,`ramo_atividade`= ?, `ins_municipal` = ?,`ins_suframa`= ?, `observacoes_pf`= ?,`reg_trib` = ?,`contato`= ?, `celular_pj`= ?,\r\n"
								+ "	  `comprador`= ?, `fone` = ?, `socio1`= ?, `cpf_socio1` = ?,`socio2` = ?, `cpf_socio2` = ?, `socio3`= ?,`cpf_socio3`= ?, \r\n"
								+ "	  `cpf`= ?, `rg` = ?,`titulo_eleitor`= ?, `cnh`= ?, `estado_civil`= ?, `sexo`= ?,`data_nascimento`= ?,`naturalidade`= ?, `uf`= ?,`escolaridade`= ?,\r\n"
								+ "   `profissao`= ?,`conjuge`= ?,`cpf_conjuge`= ?, `nome_pai`= ?, `nome_mae`= ?, `local_ue`= ?,`endereco`= ?, `bairro`= ?,\r\n"
								+ "   `cidade`= ?, `uf_ue`= ?, `cep`= ?, `telefone`= ?, `observacoes`= ? \r\n"
								+ "	WHERE codigo = ?";

						PreparedStatement stmt = conn.prepareStatement(atualizar);

						stmt.setString(1, Nome_Principal.getText());
						stmt.setString(2, CEP_Principal.getText());
						stmt.setString(3, Endereco_Principal.getText());
						stmt.setString(4, NumeroEndereco_Principal.getText());
						stmt.setString(5, Complemento_Principal.getText());
						stmt.setString(6, Bairro_Principal.getText());
						stmt.setString(7, CidadeCodigo_Principal.getText());
						stmt.setString(8, CidadeNome_Principal.getText());
						stmt.setObject(9, UF_Principal.getSelectedItem());
						stmt.setObject(10, Pais_Principal.getSelectedItem());
						stmt.setString(11, Codigo_vendedor1_Principal.getText());
						stmt.setString(12, NomeVendedor1_Principal.getText());
						stmt.setString(13, Codigo_vendedor2_Principal.getText());
						stmt.setString(14, NomeVendedor2_Principal.getText());
						stmt.setString(15, Codigo_Praca_regiao_Principal.getText());
						stmt.setString(16, NomePracaRegiao_Principal.getText());
						stmt.setString(17, Grupo_Principal.getText());
						stmt.setString(18, NomeGrupo_Principal.getText());
						stmt.setString(19, SubGrupo_Principal.getText());
						stmt.setString(20, NomeSubGrupo_Principal.getText());
						stmt.setString(21, OutrasInformacoes_Principal.getText());
						stmt.setString(22, DataFicha_Principal.getText());
						stmt.setString(23, Telefone_Principal.getText());
						stmt.setString(24, Celular_Principal.getText());
						stmt.setString(25, Email_Principal.getText());
						stmt.setString(26, EmailNF_Principal.getText());
						stmt.setString(27, InscEst_Principal.getText());
						stmt.setObject(28, IndicadorIE_Principal.getSelectedItem());
						stmt.setString(29, LimitePrazo_Principal.getText());
						stmt.setString(30, SaldoLimite_Principal.getText());
						stmt.setString(31, DiaBloqueio_Principal.getText());
						stmt.setObject(32, Situacao_Principal.getSelectedItem());
						stmt.setObject(33, Classificacao_Principal.getSelectedItem());
						stmt.setObject(34, AutorizacaoPagto_Principal.getSelectedItem());
						stmt.setObject(35, ModalidadeFrete_Principal.getSelectedItem());
						//
						stmt.setString(36, NomeFantasia_PessoaJuridica.getText());
						stmt.setString(37, CNPJ_PessoaJuridica.getText());
						stmt.setString(38, RamoAtividade_PessoaJuridica.getText());
						stmt.setString(39, InscMunicipal_PessoaJuridica.getText());
						stmt.setString(40, Suframa_PessoaJuridica.getText());
						stmt.setString(41, Observacoes_PessoaJuridica.getText());
						stmt.setObject(42, CRT_PessoaJuridica.getSelectedItem());
						stmt.setString(43, Contato_PessoaJuridica.getText());
						stmt.setString(44, Celular_PessoaJuridica.getText());
						stmt.setString(45, Comprador_PessoaJuridica.getText());
						stmt.setString(46, Fone_PessoaJuridica.getText());
						stmt.setString(47, Socio1_PessoaJuridica.getText());
						stmt.setString(48, CPF1_PessoaJuridica.getText());
						stmt.setString(49, Socio2_PessoaJuridica.getText());
						stmt.setString(50, CPF2_PessoaJuridica.getText());
						stmt.setString(51, Socio3_PessoaJuridica.getText());
						stmt.setString(52, CPF3_PessoaJuridica.getText());

						stmt.setString(53, CPF_PessoaFisica.getText());
						stmt.setString(54, RG_PessoaFisica.getText());
						stmt.setString(55, TituloEleitor_PessoaFisica.getText());
						stmt.setString(56, CNH_PessoaFisica.getText());
						stmt.setObject(57, EstadoCivil_PessoaFisica.getSelectedItem());
						stmt.setObject(58, Sexo_PessoaFisica.getSelectedItem());
						stmt.setString(59, DataNascimento_PessoaFisica.getText());
						stmt.setString(60, Naturalidade_PessoaFisica.getText());
						stmt.setObject(61, UF_PessoaFisica.getSelectedItem());
						stmt.setString(62, Escolaridade_PessoaFisica.getText());
						stmt.setString(63, Profissao_PessoaFisica.getText());
						stmt.setString(64, Conjuge_PessoaFisica.getText());
						stmt.setString(65, CPFConj_PessoaFisica.getText());
						stmt.setString(66, NomePai_PessoaFisica.getText());
						stmt.setString(67, NomeMae_PessoaFisica.getText());
						stmt.setString(68, Local_PessoaFisica.getText());
						stmt.setString(69, Endereco_PessoaFisica.getText());
						stmt.setString(70, Bairro_PessoaFisica.getText());
						stmt.setString(71, Cidade_PessoaFisica.getText());
						stmt.setObject(72, UF2_PessoaFisica.getSelectedItem());
						stmt.setString(73, CEP_PessoaFisica.getText());
						stmt.setString(74, Telefone_PessoaFisica.getText());
						stmt.setString(75, Observacoes_PessoaFisica.getText());
						stmt.setString(76, Codigo_Principal.getText());

						stmt.executeUpdate();
						stmt.close();

						int resposta = JOptionPane.showConfirmDialog(null, "Deseja atualizar o(s) campo(s) digitados?",
								"Atualizar", JOptionPane.YES_NO_CANCEL_OPTION);

						// sim = 0, nao = 1
						if (resposta == 0) {
							JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao atualizar.");
					}
				}

			}
		});
		Atualizar_Pessoa_Juridica.setFont(new Font("Arial", Font.PLAIN, 17));
		Atualizar_Pessoa_Juridica.setBorder(new LineBorder(Color.GRAY));
		Atualizar_Pessoa_Juridica.setBackground(Color.LIGHT_GRAY);
		Atualizar_Pessoa_Juridica.setBounds(487, 522, 215, 50);
		PessoaJuridica.add(Atualizar_Pessoa_Juridica);

		JPanel PessoaFisica = new JPanel();
		PessoaFisica.setBackground(Color.WHITE);
		TabPane.addTab("Pessoa F\u00EDsica", null, PessoaFisica, null);
		PessoaFisica.setLayout(null);

		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(211, 211, 211));
		panel_1_1.setBounds(10, 10, 390, 463);
		PessoaFisica.add(panel_1_1);

		TituloEleitor_PessoaFisica = new JTextField();
		TituloEleitor_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (TituloEleitor_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}

			}
		});
		TituloEleitor_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		TituloEleitor_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (TituloEleitor_PessoaFisica.getText().length() >= 12) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		TituloEleitor_PessoaFisica.setHorizontalAlignment(SwingConstants.LEFT);
		TituloEleitor_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		TituloEleitor_PessoaFisica.setColumns(10);
		TituloEleitor_PessoaFisica.setBounds(147, 108, 214, 20);
		panel_1_1.add(TituloEleitor_PessoaFisica);

		CNH_PessoaFisica = new JTextField();
		CNH_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CNH_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CNH_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CNH_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (CNH_PessoaFisica.getText().length() >= 10) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		CNH_PessoaFisica.setHorizontalAlignment(SwingConstants.LEFT);
		CNH_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		CNH_PessoaFisica.setColumns(10);
		CNH_PessoaFisica.setBounds(147, 132, 214, 20);
		panel_1_1.add(CNH_PessoaFisica);

		JLabel lblNewLabel_5 = new JLabel("CPF:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(112, 63, 30, 14);
		panel_1_1.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("RG:");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(119, 88, 23, 14);
		panel_1_1.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("T\u00EDtulo de Eleitor:");
		lblNewLabel_5_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_5_1_1.setBounds(48, 111, 94, 14);
		panel_1_1.add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_5_1_1_1 = new JLabel("Habilita\u00E7\u00E3o (CNH):");
		lblNewLabel_5_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_5_1_1_1.setBounds(35, 135, 107, 14);
		panel_1_1.add(lblNewLabel_5_1_1_1);

		EstadoCivil_PessoaFisica = new JComboBox<>();
		EstadoCivil_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		EstadoCivil_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		EstadoCivil_PessoaFisica.setBackground(SystemColor.control);
		EstadoCivil_PessoaFisica.setBounds(147, 169, 214, 22);
		EstadoCivil_PessoaFisica.addItem("Solteiro(a)");
		EstadoCivil_PessoaFisica.addItem("Casado(a)");
		EstadoCivil_PessoaFisica.addItem("Separado(a)");
		EstadoCivil_PessoaFisica.addItem("Divorciado(a)");
		EstadoCivil_PessoaFisica.addItem("Viúvo(a)");
		panel_1_1.add(EstadoCivil_PessoaFisica);

		JLabel lblNewLabel_EC = new JLabel("Estado Civil:");
		lblNewLabel_EC.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_EC.setBounds(70, 173, 72, 14);
		panel_1_1.add(lblNewLabel_EC);

		JLabel lblNewLabel_S = new JLabel("Sexo:");
		lblNewLabel_S.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_S.setBounds(108, 198, 34, 14);
		panel_1_1.add(lblNewLabel_S);

		Sexo_PessoaFisica = new JComboBox<>();
		Sexo_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Sexo_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Sexo_PessoaFisica.setBackground(SystemColor.control);
		Sexo_PessoaFisica.setBounds(147, 194, 214, 22);
		Sexo_PessoaFisica.addItem("Masculino");
		Sexo_PessoaFisica.addItem("Feminino");
		Sexo_PessoaFisica.addItem("Outro");
		panel_1_1.add(Sexo_PessoaFisica);

		Naturalidade_PessoaFisica = new JTextField();
		Naturalidade_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Naturalidade_PessoaFisica.setText(Naturalidade_PessoaFisica.getText().toUpperCase(getLocale()));

				if (Naturalidade_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Naturalidade_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Naturalidade_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Naturalidade_PessoaFisica.getText().length() >= 25) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Naturalidade_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Naturalidade_PessoaFisica.setColumns(10);
		Naturalidade_PessoaFisica.setBounds(147, 271, 214, 20);
		panel_1_1.add(Naturalidade_PessoaFisica);

		UF_PessoaFisica = new JComboBox<>();
		UF_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		UF_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		UF_PessoaFisica.setBackground(SystemColor.control);
		UF_PessoaFisica.setBounds(147, 296, 81, 22);
		UF_PessoaFisica.addItem("RO");
		UF_PessoaFisica.addItem("AC");
		UF_PessoaFisica.addItem("AM");
		UF_PessoaFisica.addItem("RR");
		UF_PessoaFisica.addItem("PA");
		UF_PessoaFisica.addItem("AP");
		UF_PessoaFisica.addItem("TO");
		UF_PessoaFisica.addItem("MA");
		UF_PessoaFisica.addItem("PI");
		UF_PessoaFisica.addItem("CE");
		UF_PessoaFisica.addItem("RN");
		UF_PessoaFisica.addItem("PB");
		UF_PessoaFisica.addItem("PE");
		UF_PessoaFisica.addItem("AL");
		UF_PessoaFisica.addItem("SE");
		UF_PessoaFisica.addItem("BA");
		UF_PessoaFisica.addItem("MG");
		UF_PessoaFisica.addItem("ES");
		UF_PessoaFisica.addItem("RJ");
		UF_PessoaFisica.addItem("SP");
		UF_PessoaFisica.addItem("PR");
		UF_PessoaFisica.addItem("SC");
		UF_PessoaFisica.addItem("RS");
		UF_PessoaFisica.addItem("MS");
		UF_PessoaFisica.addItem("MT");
		UF_PessoaFisica.addItem("GO");
		UF_PessoaFisica.addItem("DF");
		panel_1_1.add(UF_PessoaFisica);

		Escolaridade_PessoaFisica = new JTextField();
		Escolaridade_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Escolaridade_PessoaFisica.setText(Escolaridade_PessoaFisica.getText().toUpperCase(getLocale()));

				if (Escolaridade_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Escolaridade_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Escolaridade_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Escolaridade_PessoaFisica.getText().length() >= 50) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Escolaridade_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Escolaridade_PessoaFisica.setColumns(10);
		Escolaridade_PessoaFisica.setBounds(147, 338, 214, 20);
		panel_1_1.add(Escolaridade_PessoaFisica);

		Profissao_PessoaFisica = new JTextField();
		Profissao_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Profissao_PessoaFisica.setText(Profissao_PessoaFisica.getText().toUpperCase(getLocale()));

				if (Profissao_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Profissao_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Profissao_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Profissao_PessoaFisica.getText().length() >= 30) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Profissao_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Profissao_PessoaFisica.setColumns(10);
		Profissao_PessoaFisica.setBounds(147, 362, 214, 20);
		panel_1_1.add(Profissao_PessoaFisica);

		JLabel lblNewLabel_Nasci = new JLabel("Data de Nascimento:");
		lblNewLabel_Nasci.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_Nasci.setBounds(20, 249, 122, 14);
		panel_1_1.add(lblNewLabel_Nasci);

		JLabel lblNewLabel_Natural = new JLabel("Naturalidade:");
		lblNewLabel_Natural.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_Natural.setBounds(66, 274, 76, 14);
		panel_1_1.add(lblNewLabel_Natural);

		JLabel lblNewLabel_UFF = new JLabel("UF.:");
		lblNewLabel_UFF.setBounds(117, 300, 25, 14);
		panel_1_1.add(lblNewLabel_UFF);
		lblNewLabel_UFF.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNewLabel_Escola = new JLabel("Escolaridade:");
		lblNewLabel_Escola.setBounds(63, 341, 79, 14);
		panel_1_1.add(lblNewLabel_Escola);
		lblNewLabel_Escola.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNewLabel_Prof = new JLabel("Profiss\u00E3o:");
		lblNewLabel_Prof.setBounds(84, 365, 58, 14);
		panel_1_1.add(lblNewLabel_Prof);
		lblNewLabel_Prof.setFont(new Font("Arial", Font.PLAIN, 13));

		CPF_PessoaFisica = new JFormattedTextField("___.___.___-__");
		CPF_PessoaFisica.setText("__.__.__-_");
		CPF_PessoaFisica.setForeground(Color.BLACK);
		CPF_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CPF_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}

			}
		});
		CPF_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CPF_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (CPF_PessoaFisica.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		CPF_PessoaFisica.setHorizontalAlignment(SwingConstants.LEFT);
		CPF_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		CPF_PessoaFisica.setBounds(147, 59, 115, 20);
		panel_1_1.add(CPF_PessoaFisica);

		RG_PessoaFisica = new JFormattedTextField("________");
		RG_PessoaFisica.setText("______");
		RG_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (RG_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		RG_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		RG_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (RG_PessoaFisica.getText().length() >= 12) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		RG_PessoaFisica.setHorizontalAlignment(SwingConstants.LEFT);
		RG_PessoaFisica.setBounds(147, 85, 214, 20);
		panel_1_1.add(RG_PessoaFisica);

		DataNascimento_PessoaFisica = new JFormattedTextField("__/__/____");
		DataNascimento_PessoaFisica.setText("_/_/___");
		DataNascimento_PessoaFisica.setForeground(Color.BLACK);
		DataNascimento_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (DataNascimento_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		DataNascimento_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		DataNascimento_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (DataNascimento_PessoaFisica.getText().length() >= 10) {
					e.consume();
				}

				String caracteres = "0987654321/";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		DataNascimento_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		DataNascimento_PessoaFisica.setBounds(147, 246, 81, 20);
		panel_1_1.add(DataNascimento_PessoaFisica);

		Conjuge_PessoaFisica = new JTextField();
		Conjuge_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Conjuge_PessoaFisica.setText(Conjuge_PessoaFisica.getText().toUpperCase(getLocale()));

				if (Conjuge_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Conjuge_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Conjuge_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Conjuge_PessoaFisica.getText().length() >= 90) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Conjuge_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Conjuge_PessoaFisica.setBounds(551, 25, 364, 20);
		PessoaFisica.add(Conjuge_PessoaFisica);
		Conjuge_PessoaFisica.setColumns(10);

		NomeMae_PessoaFisica = new JTextField();
		NomeMae_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				NomeMae_PessoaFisica.setText(NomeMae_PessoaFisica.getText().toUpperCase(getLocale()));

				if (NomeMae_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NomeMae_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NomeMae_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		NomeMae_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (NomeMae_PessoaFisica.getText().length() >= 90) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		NomeMae_PessoaFisica.setColumns(10);
		NomeMae_PessoaFisica.setBounds(551, 100, 364, 20);
		PessoaFisica.add(NomeMae_PessoaFisica);

		NomePai_PessoaFisica = new JTextField();
		NomePai_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				NomePai_PessoaFisica.setText(NomePai_PessoaFisica.getText().toUpperCase(getLocale()));

				if (NomePai_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		NomePai_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		NomePai_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		NomePai_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (NomePai_PessoaFisica.getText().length() >= 90) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		NomePai_PessoaFisica.setColumns(10);
		NomePai_PessoaFisica.setBounds(551, 75, 364, 20);
		PessoaFisica.add(NomePai_PessoaFisica);

		Cidade_PessoaFisica = new JTextField();
		Cidade_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Cidade_PessoaFisica.setText(Cidade_PessoaFisica.getText().toUpperCase(getLocale()));

				if (Cidade_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Cidade_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Cidade_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Cidade_PessoaFisica.getText().length() >= 30) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz " + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Cidade_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Cidade_PessoaFisica.setColumns(10);
		Cidade_PessoaFisica.setBounds(551, 275, 161, 20);
		PessoaFisica.add(Cidade_PessoaFisica);

		Local_PessoaFisica = new JTextField();
		Local_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Local_PessoaFisica.setText(Local_PessoaFisica.getText().toUpperCase(getLocale()));

				if (Local_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Local_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Local_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Local_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Local_PessoaFisica.getText().length() >= 70) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Local_PessoaFisica.setColumns(10);
		Local_PessoaFisica.setBounds(551, 200, 364, 20);
		PessoaFisica.add(Local_PessoaFisica);

		Endereco_PessoaFisica = new JTextField();
		Endereco_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Endereco_PessoaFisica.setText(Endereco_PessoaFisica.getText().toUpperCase(getLocale()));

				if (Endereco_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Endereco_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Endereco_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Endereco_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Endereco_PessoaFisica.getText().length() >= 70) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Endereco_PessoaFisica.setColumns(10);
		Endereco_PessoaFisica.setBounds(551, 225, 364, 20);
		PessoaFisica.add(Endereco_PessoaFisica);

		Bairro_PessoaFisica = new JTextField();
		Bairro_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Bairro_PessoaFisica.setText(Bairro_PessoaFisica.getText().toUpperCase(getLocale()));

				if (Bairro_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Bairro_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Bairro_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Bairro_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (Bairro_PessoaFisica.getText().length() >= 40) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		Bairro_PessoaFisica.setColumns(10);
		Bairro_PessoaFisica.setBounds(551, 250, 364, 20);
		PessoaFisica.add(Bairro_PessoaFisica);

		UF2_PessoaFisica = new JComboBox<>();
		UF2_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		UF2_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		UF2_PessoaFisica.setBackground(new Color(220, 220, 220));
		UF2_PessoaFisica.setBounds(834, 274, 81, 22);
		UF2_PessoaFisica.addItem("RO");
		UF2_PessoaFisica.addItem("AC");
		UF2_PessoaFisica.addItem("AM");
		UF2_PessoaFisica.addItem("RR");
		UF2_PessoaFisica.addItem("PA");
		UF2_PessoaFisica.addItem("AP");
		UF2_PessoaFisica.addItem("TO");
		UF2_PessoaFisica.addItem("MA");
		UF2_PessoaFisica.addItem("PI");
		UF2_PessoaFisica.addItem("CE");
		UF2_PessoaFisica.addItem("RN");
		UF2_PessoaFisica.addItem("PB");
		UF2_PessoaFisica.addItem("PE");
		UF2_PessoaFisica.addItem("AL");
		UF2_PessoaFisica.addItem("SE");
		UF2_PessoaFisica.addItem("BA");
		UF2_PessoaFisica.addItem("MG");
		UF2_PessoaFisica.addItem("ES");
		UF2_PessoaFisica.addItem("RJ");
		UF2_PessoaFisica.addItem("SP");
		UF2_PessoaFisica.addItem("PR");
		UF2_PessoaFisica.addItem("SC");
		UF2_PessoaFisica.addItem("RS");
		UF2_PessoaFisica.addItem("MS");
		UF2_PessoaFisica.addItem("MT");
		UF2_PessoaFisica.addItem("GO");
		UF2_PessoaFisica.addItem("DF");
		PessoaFisica.add(UF2_PessoaFisica);

		Observacoes_PessoaFisica = new JEditorPane();
		Observacoes_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Observacoes_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Observacoes_PessoaFisica.getText().length() >= 350) {
					e.consume();
				}

				String caracteres = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Observacoes_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Observacoes_PessoaFisica.setBounds(551, 331, 364, 142);
		PessoaFisica.add(Observacoes_PessoaFisica);

		JLabel lblNewLabel_6 = new JLabel("Conjug\u00EA:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(497, 28, 51, 14);
		PessoaFisica.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("CPF conj.:");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(484, 53, 64, 14);
		PessoaFisica.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_1_1 = new JLabel("Nome Pai:");
		lblNewLabel_6_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1.setBounds(487, 78, 61, 14);
		PessoaFisica.add(lblNewLabel_6_1_1);

		JLabel lblNewLabel_6_1_1_1 = new JLabel("Nome M\u00E3e:");
		lblNewLabel_6_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1.setBounds(481, 103, 67, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1);

		JLabel lblNewLabel_6_1_1_1_1 = new JLabel("\u00DAltimo Emprego:");
		lblNewLabel_6_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6_1_1_1_1.setBounds(484, 175, 125, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1_1);

		JLabel lblNewLabel_6_1_1_1_2 = new JLabel("Local:");
		lblNewLabel_6_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1_2.setBounds(513, 203, 35, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1_2);

		JLabel lblNewLabel_6_1_1_1_2_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_6_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1_2_1.setBounds(487, 228, 61, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1_2_1);

		JLabel lblNewLabel_6_1_1_1_2_1_1 = new JLabel("Bairro:");
		lblNewLabel_6_1_1_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1_2_1_1.setBounds(510, 253, 38, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1_2_1_1);

		JLabel lblNewLabel_6_1_1_1_2_1_1_1 = new JLabel("Cidade:");
		lblNewLabel_6_1_1_1_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1_2_1_1_1.setBounds(504, 278, 44, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1_2_1_1_1);

		JLabel lblNewLabel_6_1_1_1_2_1_1_1_1 = new JLabel("CEP:");
		lblNewLabel_6_1_1_1_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1_2_1_1_1_1.setBounds(517, 303, 31, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1_2_1_1_1_1);

		JLabel lblNewLabel_6_1_1_1_2_1_1_1_2 = new JLabel("Telefone:");
		lblNewLabel_6_1_1_1_2_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1_2_1_1_1_2.setBounds(764, 303, 55, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1_2_1_1_1_2);

		JLabel lblNewLabel_6_1_1_1_2_1_1_1_2_1 = new JLabel("UF.:");
		lblNewLabel_6_1_1_1_2_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1_2_1_1_1_2_1.setBounds(807, 278, 27, 14);
		PessoaFisica.add(lblNewLabel_6_1_1_1_2_1_1_1_2_1);

		JLabel lblNewLabel_7 = new JLabel("Observa\u00E7\u00F5es:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(469, 331, 79, 14);
		PessoaFisica.add(lblNewLabel_7);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.GRAY);
		separator_1_1.setBounds(0, 509, 959, 16);
		PessoaFisica.add(separator_1_1);

		JButton Salvar_PessoaFisica = new JButton("Salvar");
		Salvar_PessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String INSERIR2 = "INSERT INTO `cadastrocliente`.`tela_cadastro_completo`\r\n" + "(`nome`,\r\n"
						+ "`cep_principal`,\r\n" + "`endereco_principal`,\r\n" + "`numero`,\r\n" + "`complemento`,\r\n"
						+ "`bairro_principal`,\r\n" + "`cidade_codigo`,\r\n" + "`cidade_nome`,\r\n"
						+ "`uf_principal`,\r\n" + "`pais`,\r\n" + "`codigo_vendedor1`,\r\n" + "`nome_vendedor1`,\r\n"
						+ "`codigo_vendedor2`,\r\n" + "`nome_vendedor2`,\r\n" + "`codigo_praca_regiao`,\r\n"
						+ "`nome_praca_regiao`,\r\n" + "`codigo_grupo`,\r\n" + "`nome_grupo`,\r\n"
						+ "`codigo_sub_grupo`,\r\n" + "`nome_sub_grupo`,\r\n" + "`outras_informacoes`,\r\n"
						+ "`data_ficha`,\r\n" + "`telefone_principal`,\r\n" + "`celular`,\r\n" + "`email`,\r\n"
						+ "`emailNF`,\r\n" + "`ins_Est`,\r\n" + "`indicador_IE`,\r\n" + "`limite_prazo`,\r\n"
						+ "`saldo_limite`,\r\n" + "`dias_bloqueio`,\r\n" + "`situacao`,\r\n" + "`classificacao`,\r\n"
						+ "`autorizacao_pagamento`,\r\n" + "`modalidade_frete`,\r\n" + "`nome_fantasia`,\r\n"
						+ "`CNPJ`,\r\n" + "`ramo_atividade`,\r\n" + "`ins_municipal`,\r\n" + "`ins_suframa`,\r\n"
						+ "`observacoes_pf`,\r\n" + "`reg_trib`,\r\n" + "`contato`,\r\n" + "`celular_pj`,\r\n"
						+ "`comprador`,\r\n" + "`fone`,\r\n" + "`socio1`,\r\n" + "`cpf_socio1`,\r\n" + "`socio2`,\r\n"
						+ "`cpf_socio2`,\r\n" + "`socio3`,\r\n" + "`cpf_socio3`,\r\n" + "`cpf`,\r\n" + "`rg`,\r\n"
						+ "`titulo_eleitor`,\r\n" + "`cnh`,\r\n" + "`estado_civil`,\r\n" + "`sexo`,\r\n"
						+ "`data_nascimento`,\r\n" + "`naturalidade`,\r\n" + "`uf`,\r\n" + "`escolaridade`,\r\n"
						+ "`profissao`,\r\n" + "`conjuge`,\r\n" + "`cpf_conjuge`,\r\n" + "`nome_pai`,\r\n"
						+ "`nome_mae`,\r\n" + "`local_ue`,\r\n" + "`endereco`,\r\n" + "`bairro`,\r\n" + "`cidade`,\r\n"
						+ "`uf_ue`,\r\n" + "`cep`,\r\n" + "`telefone`,\r\n" + "`observacoes`, \r\n" + "`codigo`)\r\n"
						+ "VALUES\r\n"
						+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? \r\n"
						+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? \r\n"
						+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				try {

					Connection conn = conectar();
					PreparedStatement salvar = conn.prepareStatement(INSERIR2);

					salvar.setString(1, Nome_Principal.getText());
					salvar.setObject(2, CEP_Principal.getText());
					salvar.setString(3, Endereco_Principal.getText());
					salvar.setString(4, NumeroEndereco_Principal.getText());
					salvar.setString(5, Complemento_Principal.getText());
					salvar.setString(6, Bairro_Principal.getText());
					salvar.setString(7, CidadeCodigo_Principal.getText());
					salvar.setString(8, CidadeNome_Principal.getText());
					salvar.setObject(9, UF_Principal.getSelectedItem());
					salvar.setObject(10, Pais_Principal.getSelectedItem());
					salvar.setString(11, Codigo_vendedor1_Principal.getText());
					salvar.setString(12, NomeVendedor1_Principal.getText());
					salvar.setString(13, Codigo_vendedor2_Principal.getText());
					salvar.setString(14, NomeVendedor2_Principal.getText());
					salvar.setString(15, Codigo_Praca_regiao_Principal.getText());
					salvar.setString(16, NomePracaRegiao_Principal.getText());
					salvar.setString(17, Grupo_Principal.getText());
					salvar.setString(18, NomeGrupo_Principal.getText());
					salvar.setString(19, SubGrupo_Principal.getText());
					salvar.setString(20, NomeSubGrupo_Principal.getText());
					salvar.setString(21, OutrasInformacoes_Principal.getText());
					salvar.setString(22, DataFicha_Principal.getText());
					salvar.setString(23, Telefone_Principal.getText());
					salvar.setString(24, Celular_Principal.getText());
					salvar.setString(25, Email_Principal.getText());
					salvar.setString(26, EmailNF_Principal.getText());
					salvar.setString(27, InscEst_Principal.getText());
					salvar.setObject(28, IndicadorIE_Principal.getSelectedItem());
					salvar.setString(29, LimitePrazo_Principal.getText());
					salvar.setString(30, SaldoLimite_Principal.getText());
					salvar.setString(31, DiaBloqueio_Principal.getText());
					salvar.setObject(32, Situacao_Principal.getSelectedItem());
					salvar.setObject(33, Classificacao_Principal.getSelectedItem());
					salvar.setObject(34, AutorizacaoPagto_Principal.getSelectedItem());
					salvar.setObject(35, ModalidadeFrete_Principal.getSelectedItem());
					//
					salvar.setString(36, NomeFantasia_PessoaJuridica.getText());
					salvar.setString(37, CNPJ_PessoaJuridica.getText());
					salvar.setString(38, RamoAtividade_PessoaJuridica.getText());
					salvar.setString(39, InscMunicipal_PessoaJuridica.getText());
					salvar.setString(40, Suframa_PessoaJuridica.getText());
					salvar.setString(41, Observacoes_PessoaJuridica.getText());
					salvar.setObject(42, CRT_PessoaJuridica.getSelectedItem());
					salvar.setString(43, Contato_PessoaJuridica.getText());
					salvar.setString(44, Celular_PessoaJuridica.getText());
					salvar.setString(45, Comprador_PessoaJuridica.getText());
					salvar.setString(46, Fone_PessoaJuridica.getText());
					salvar.setString(47, Socio1_PessoaJuridica.getText());
					salvar.setString(48, CPF1_PessoaJuridica.getText());
					salvar.setString(49, Socio2_PessoaJuridica.getText());
					salvar.setString(50, CPF2_PessoaJuridica.getText());
					salvar.setString(51, Socio3_PessoaJuridica.getText());
					salvar.setString(52, CPF3_PessoaJuridica.getText());

					salvar.setString(53, CPF_PessoaFisica.getText());
					salvar.setString(54, RG_PessoaFisica.getText());
					salvar.setString(55, TituloEleitor_PessoaFisica.getText());
					salvar.setString(56, CNH_PessoaFisica.getText());
					salvar.setObject(57, EstadoCivil_PessoaFisica.getSelectedItem());
					salvar.setObject(58, Sexo_PessoaFisica.getSelectedItem());
					salvar.setString(59, DataNascimento_PessoaFisica.getText());
					salvar.setString(60, Naturalidade_PessoaFisica.getText());
					salvar.setObject(61, UF_PessoaFisica.getSelectedItem());
					salvar.setString(62, Escolaridade_PessoaFisica.getText());
					salvar.setString(63, Profissao_PessoaFisica.getText());
					salvar.setString(64, Conjuge_PessoaFisica.getText());
					salvar.setString(65, CPFConj_PessoaFisica.getText());
					salvar.setString(66, NomePai_PessoaFisica.getText());
					salvar.setString(67, NomeMae_PessoaFisica.getText());
					salvar.setString(68, Local_PessoaFisica.getText());
					salvar.setString(69, Endereco_PessoaFisica.getText());
					salvar.setString(70, Bairro_PessoaFisica.getText());
					salvar.setString(71, Cidade_PessoaFisica.getText());
					salvar.setObject(72, UF2_PessoaFisica.getSelectedItem());
					salvar.setString(73, CEP_PessoaFisica.getText());
					salvar.setString(74, Telefone_PessoaFisica.getText());
					salvar.setString(75, Observacoes_PessoaFisica.getText());
					salvar.setString(76, Codigo_Principal.getText());

					salvar.executeUpdate();
					salvar.close();

					JOptionPane.showMessageDialog(null, "Dados Inseridos com sucesso.");

				} catch (Exception e2) {
					e2.printStackTrace();
					// JOptionPane.showMessageDialog(null, "Erro ao inserir o produto.");
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		Salvar_PessoaFisica.setBorder(new LineBorder(Color.GRAY));
		Salvar_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 17));
		Salvar_PessoaFisica.setBackground(Color.LIGHT_GRAY);
		Salvar_PessoaFisica.setBounds(30, 522, 215, 50);
		PessoaFisica.add(Salvar_PessoaFisica);

		JButton Limpar_PessoaFisica = new JButton("Limpar");
		Limpar_PessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// caixa de dialogo retorna um inteiro
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja Limpar todos os campos da tela?",
						"Limpar Campos", JOptionPane.YES_NO_OPTION);

				// sim = 0, nao = 1
				if (resposta == 0) {

					Codigo_Principal.setText("");
					Endereco_Principal.setText("");
					NumeroEndereco_Principal.setText("");
					CEP_Principal.setText("_____-___");
					OutrasInformacoes_Principal.setText("");
					Complemento_Principal.setText("");
					Bairro_Principal.setText("");
					UF_Principal.setSelectedItem("RO");
					Pais_Principal.setSelectedItem("Brasil");
					IndicadorIE_Principal.setSelectedItem("Contribuinte de ICMS");
					Situacao_Principal.setSelectedItem("Desbloqueado p/ venda");
					Classificacao_Principal.setSelectedItem("Ativo");
					AutorizacaoPagto_Principal.setSelectedItem("Sem Restrição");
					ModalidadeFrete_Principal.setSelectedItem("Por conta do Emitente");
					CidadeCodigo_Principal.setText("");
					CidadeNome_Principal.setText("");
					Codigo_vendedor1_Principal.setText("");
					NomeVendedor1_Principal.setText("");
					Codigo_vendedor2_Principal.setText("");
					NomeVendedor2_Principal.setText("");
					Codigo_Praca_regiao_Principal.setText("");
					Grupo_Principal.setText("");
					SubGrupo_Principal.setText("");
					Nome_Principal.setText("");
					Email_Principal.setText("");
					EmailNF_Principal.setText("");
					InscEst_Principal.setText("");
					DiaBloqueio_Principal.setText("");
					NomePracaRegiao_Principal.setText("");
					NomeGrupo_Principal.setText("");
					NomeSubGrupo_Principal.setText("");
					DataFicha_Principal.setText("__/__/____");
					Telefone_Principal.setText("(_)____-____");
					Celular_Principal.setText("(_)____-___");
					LimitePrazo_Principal.setText("R$0,00");
					SaldoLimite_Principal.setText("R$0,00");
					DiaBloqueio_Principal.setText("__/__/____");
					//
					NomeFantasia_PessoaJuridica.setText("");
					CNPJ_PessoaJuridica.setText("__.___.___/____-__");
					RamoAtividade_PessoaJuridica.setText("");
					InscMunicipal_PessoaJuridica.setText("");
					Suframa_PessoaJuridica.setText("");
					Observacoes_PessoaJuridica.setText("");
					Contato_PessoaJuridica.setText("");
					Celular_PessoaJuridica.setText("(_)____-___");
					Comprador_PessoaJuridica.setText("");
					Fone_PessoaJuridica.setText("(_)____-___");
					Socio1_PessoaJuridica.setText("");
					CPF1_PessoaJuridica.setText("___.___.___-__");
					Socio2_PessoaJuridica.setText("");
					CPF2_PessoaJuridica.setText("___.___.___-__");
					Socio3_PessoaJuridica.setText("");
					CPF3_PessoaJuridica.setText("___.___.___-__");
					CRT_PessoaJuridica.setSelectedItem("1 - Simples Nacional");
					//
					CPF_PessoaFisica.setText("___.___.___-__");
					RG_PessoaFisica.setText("___________");
					TituloEleitor_PessoaFisica.setText("");
					CNH_PessoaFisica.setText("");
					DataNascimento_PessoaFisica.setText("__/__/____");
					Naturalidade_PessoaFisica.setText("");
					Escolaridade_PessoaFisica.setText("");
					Profissao_PessoaFisica.setText("");
					Conjuge_PessoaFisica.setText("");
					CPFConj_PessoaFisica.setText("___.___.___-__");
					NomePai_PessoaFisica.setText("");
					NomeMae_PessoaFisica.setText("");
					Local_PessoaFisica.setText("");
					Endereco_PessoaFisica.setText("");
					Bairro_PessoaFisica.setText("");
					Cidade_PessoaFisica.setText("");
					CEP_PessoaFisica.setText("_____-___");
					Telefone_PessoaFisica.setText("(_)____-____");
					Observacoes_PessoaFisica.setText("");
					EstadoCivil_PessoaFisica.setSelectedItem("Solteiro(a)");
					Sexo_PessoaFisica.setSelectedItem("Masculino");
					UF_PessoaFisica.setSelectedItem("RO");
					UF2_PessoaFisica.setSelectedItem("RO");

				}
			}
		});
		Limpar_PessoaFisica.setBorder(new LineBorder(Color.GRAY));
		Limpar_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 17));
		Limpar_PessoaFisica.setBackground(Color.LIGHT_GRAY);
		Limpar_PessoaFisica.setBounds(260, 522, 215, 50);
		PessoaFisica.add(Limpar_PessoaFisica);

		JButton Sair_PessoaFisica = new JButton("Sair");
		Sair_PessoaFisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// caixa de dialogo retorna um inteiro
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja finalizar essa operação?", "Finalizar",
						JOptionPane.YES_NO_OPTION);

				// sim = 0, nao = 1
				if (resposta == 0) {
					System.exit(0);
				}

			}
		});
		Sair_PessoaFisica.setBorder(new LineBorder(Color.GRAY));
		Sair_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 17));
		Sair_PessoaFisica.setBackground(Color.LIGHT_GRAY);
		Sair_PessoaFisica.setBounds(715, 522, 214, 50);
		PessoaFisica.add(Sair_PessoaFisica);

		CPFConj_PessoaFisica = new JFormattedTextField("___.___.___-__");
		CPFConj_PessoaFisica.setText("__.__.__-_");
		CPFConj_PessoaFisica.setForeground(Color.BLACK);
		CPFConj_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CPFConj_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CPFConj_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CPFConj_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (CPFConj_PessoaFisica.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		CPFConj_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		CPFConj_PessoaFisica.setBounds(551, 50, 105, 20);
		PessoaFisica.add(CPFConj_PessoaFisica);

		CEP_PessoaFisica = new JFormattedTextField("_____-___");
		CEP_PessoaFisica.setText("___-__");
		CEP_PessoaFisica.setForeground(Color.BLACK);
		CEP_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (CEP_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		CEP_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		CEP_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (CEP_PessoaFisica.getText().length() >= 8) {
					e.consume();
				}

				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		CEP_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		CEP_PessoaFisica.setBounds(551, 300, 103, 20);
		PessoaFisica.add(CEP_PessoaFisica);

		Telefone_PessoaFisica = new JFormattedTextField("(_)___-___");
		Telefone_PessoaFisica.setToolTipText("");
		Telefone_PessoaFisica.setForeground(Color.BLACK);
		Telefone_PessoaFisica.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (Telefone_PessoaFisica.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Favor preencher o Campo!");
					return;
				}
			}
		});
		Telefone_PessoaFisica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Telefone_PessoaFisica.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Telefone_PessoaFisica.getText().length() >= 11) {
					e.consume();
				}

				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
					e.consume();
				}

				if (e.getKeyCode() == KeyEvent.VK_V) {
					e.consume();
				}
			}
		});
		Telefone_PessoaFisica.setFont(new Font("Arial", Font.PLAIN, 13));
		Telefone_PessoaFisica.setBounds(817, 300, 98, 20);
		PessoaFisica.add(Telefone_PessoaFisica);

		JButton Atualizar_Pessoa_Fisica = new JButton("Atualizar");
		Atualizar_Pessoa_Fisica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Codigo_Principal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o código.");
				} else {

					try {

						Connection conn = conectar();

						String atualizar = "UPDATE `cadastrocliente`.`tela_cadastro_completo` SET nome = ?, cep_principal = ?, endereco_principal = ?, numero = ?, complemento= ?, bairro_principal= ?, \r\n"
								+ "	  cidade_codigo= ?, cidade_nome= ?, uf_principal= ?, pais= ?, codigo_vendedor1= ?, nome_vendedor1= ?, codigo_vendedor2= ?,\r\n"
								+ "   nome_vendedor2= ?, codigo_praca_regiao= ?, nome_praca_regiao= ?, codigo_grupo= ?, nome_grupo= ?, codigo_sub_grupo= ?, \r\n"
								+ "   nome_sub_grupo= ?, outras_informacoes= ?, data_ficha= ?, telefone_principal= ?, celular= ?, email= ?, emailNF= ?, ins_Est= ?, \r\n"
								+ "   indicador_IE= ?, limite_prazo= ?, saldo_limite= ?, dias_bloqueio= ?, situacao= ?, classificacao= ?, autorizacao_pagamento= ?, modalidade_frete= ?, \r\n"
								+ "	  `nome_fantasia`= ?,`CNPJ`= ?,`ramo_atividade`= ?, `ins_municipal` = ?,`ins_suframa`= ?, `observacoes_pf`= ?,`reg_trib` = ?,`contato`= ?, `celular_pj`= ?,\r\n"
								+ "	  `comprador`= ?, `fone` = ?, `socio1`= ?, `cpf_socio1` = ?,`socio2` = ?, `cpf_socio2` = ?, `socio3`= ?,`cpf_socio3`= ?, \r\n"
								+ "	  `cpf`= ?, `rg` = ?,`titulo_eleitor`= ?, `cnh`= ?, `estado_civil`= ?, `sexo`= ?,`data_nascimento`= ?,`naturalidade`= ?, `uf`= ?,`escolaridade`= ?,\r\n"
								+ "   `profissao`= ?,`conjuge`= ?,`cpf_conjuge`= ?, `nome_pai`= ?, `nome_mae`= ?, `local_ue`= ?,`endereco`= ?, `bairro`= ?,\r\n"
								+ "   `cidade`= ?, `uf_ue`= ?, `cep`= ?, `telefone`= ?, `observacoes`= ? \r\n"
								+ "	WHERE codigo = ?";

						PreparedStatement stmt = conn.prepareStatement(atualizar);

						stmt.setString(1, Nome_Principal.getText());
						stmt.setString(2, CEP_Principal.getText());
						stmt.setString(3, Endereco_Principal.getText());
						stmt.setString(4, NumeroEndereco_Principal.getText());
						stmt.setString(5, Complemento_Principal.getText());
						stmt.setString(6, Bairro_Principal.getText());
						stmt.setString(7, CidadeCodigo_Principal.getText());
						stmt.setString(8, CidadeNome_Principal.getText());
						stmt.setObject(9, UF_Principal.getSelectedItem());
						stmt.setObject(10, Pais_Principal.getSelectedItem());
						stmt.setString(11, Codigo_vendedor1_Principal.getText());
						stmt.setString(12, NomeVendedor1_Principal.getText());
						stmt.setString(13, Codigo_vendedor2_Principal.getText());
						stmt.setString(14, NomeVendedor2_Principal.getText());
						stmt.setString(15, Codigo_Praca_regiao_Principal.getText());
						stmt.setString(16, NomePracaRegiao_Principal.getText());
						stmt.setString(17, Grupo_Principal.getText());
						stmt.setString(18, NomeGrupo_Principal.getText());
						stmt.setString(19, SubGrupo_Principal.getText());
						stmt.setString(20, NomeSubGrupo_Principal.getText());
						stmt.setString(21, OutrasInformacoes_Principal.getText());
						stmt.setString(22, DataFicha_Principal.getText());
						stmt.setString(23, Telefone_Principal.getText());
						stmt.setString(24, Celular_Principal.getText());
						stmt.setString(25, Email_Principal.getText());
						stmt.setString(26, EmailNF_Principal.getText());
						stmt.setString(27, InscEst_Principal.getText());
						stmt.setObject(28, IndicadorIE_Principal.getSelectedItem());
						stmt.setString(29, LimitePrazo_Principal.getText());
						stmt.setString(30, SaldoLimite_Principal.getText());
						stmt.setString(31, DiaBloqueio_Principal.getText());
						stmt.setObject(32, Situacao_Principal.getSelectedItem());
						stmt.setObject(33, Classificacao_Principal.getSelectedItem());
						stmt.setObject(34, AutorizacaoPagto_Principal.getSelectedItem());
						stmt.setObject(35, ModalidadeFrete_Principal.getSelectedItem());
						//
						stmt.setString(36, NomeFantasia_PessoaJuridica.getText());
						stmt.setString(37, CNPJ_PessoaJuridica.getText());
						stmt.setString(38, RamoAtividade_PessoaJuridica.getText());
						stmt.setString(39, InscMunicipal_PessoaJuridica.getText());
						stmt.setString(40, Suframa_PessoaJuridica.getText());
						stmt.setString(41, Observacoes_PessoaJuridica.getText());
						stmt.setObject(42, CRT_PessoaJuridica.getSelectedItem());
						stmt.setString(43, Contato_PessoaJuridica.getText());
						stmt.setString(44, Celular_PessoaJuridica.getText());
						stmt.setString(45, Comprador_PessoaJuridica.getText());
						stmt.setString(46, Fone_PessoaJuridica.getText());
						stmt.setString(47, Socio1_PessoaJuridica.getText());
						stmt.setString(48, CPF1_PessoaJuridica.getText());
						stmt.setString(49, Socio2_PessoaJuridica.getText());
						stmt.setString(50, CPF2_PessoaJuridica.getText());
						stmt.setString(51, Socio3_PessoaJuridica.getText());
						stmt.setString(52, CPF3_PessoaJuridica.getText());

						stmt.setString(53, CPF_PessoaFisica.getText());
						stmt.setString(54, RG_PessoaFisica.getText());
						stmt.setString(55, TituloEleitor_PessoaFisica.getText());
						stmt.setString(56, CNH_PessoaFisica.getText());
						stmt.setObject(57, EstadoCivil_PessoaFisica.getSelectedItem());
						stmt.setObject(58, Sexo_PessoaFisica.getSelectedItem());
						stmt.setString(59, DataNascimento_PessoaFisica.getText());
						stmt.setString(60, Naturalidade_PessoaFisica.getText());
						stmt.setObject(61, UF_PessoaFisica.getSelectedItem());
						stmt.setString(62, Escolaridade_PessoaFisica.getText());
						stmt.setString(63, Profissao_PessoaFisica.getText());
						stmt.setString(64, Conjuge_PessoaFisica.getText());
						stmt.setString(65, CPFConj_PessoaFisica.getText());
						stmt.setString(66, NomePai_PessoaFisica.getText());
						stmt.setString(67, NomeMae_PessoaFisica.getText());
						stmt.setString(68, Local_PessoaFisica.getText());
						stmt.setString(69, Endereco_PessoaFisica.getText());
						stmt.setString(70, Bairro_PessoaFisica.getText());
						stmt.setString(71, Cidade_PessoaFisica.getText());
						stmt.setObject(72, UF2_PessoaFisica.getSelectedItem());
						stmt.setString(73, CEP_PessoaFisica.getText());
						stmt.setString(74, Telefone_PessoaFisica.getText());
						stmt.setString(75, Observacoes_PessoaFisica.getText());
						stmt.setString(76, Codigo_Principal.getText());

						stmt.executeUpdate();
						stmt.close();

						int resposta = JOptionPane.showConfirmDialog(null, "Deseja atualizar o(s) campo(s) digitados?",
								"Atualizar", JOptionPane.YES_NO_CANCEL_OPTION);

						// sim = 0, nao = 1
						if (resposta == 0) {
							JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao atualizar.");
					}
				}

			}
		});
		Atualizar_Pessoa_Fisica.setFont(new Font("Arial", Font.PLAIN, 17));
		Atualizar_Pessoa_Fisica.setBorder(new LineBorder(Color.GRAY));
		Atualizar_Pessoa_Fisica.setBackground(Color.LIGHT_GRAY);
		Atualizar_Pessoa_Fisica.setBounds(487, 522, 215, 50);
		PessoaFisica.add(Atualizar_Pessoa_Fisica);
	}
}
