package Locadora_de_Veiculos.gui;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Locadora_de_Veiculos.Arquivo.Arquivo;
import Locadora_de_Veiculos.Cadastro.CadClientes;
import Locadora_de_Veiculos.Cadastro.CadVeiculos;
import Locadora_de_Veiculos.Listas.ListaObjetos;
import Locadora_de_Veiculos.Objetos.Cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame{

    private CadClientes clientes;
    private CadVeiculos veiculos;
    private ListaObjetos categorias;
    private Arquivo arquivo;

    private JMenuBar menuBar;
		
    private JMenu menuClientes;
    private JMenuItem listarClientesDoInicio;
    private JMenuItem listarClientesDoFim;
    private JMenuItem incluirClientes;
    private JMenuItem excluirClientes; 
    private JMenuItem alterarClientes; 

    private JMenu menuVeiculos;
    private JMenuItem listarVeiculosDoInicio;
    private JMenuItem listarVeiculosDoFim;
    private JMenuItem incluirVeiculos; 
    private JMenuItem excluirVeiculos; 
    private JMenuItem alterarVeiculo;

    private JMenu menuCategorias;
    private JMenuItem listarCategoriasInicio;
    private JMenuItem listarCategoriasFim;

    private JMenu menuLocacoes;
    private JMenuItem listarLocacoes; 
    private JMenuItem incluirLocacoes; 
    private JMenuItem excluirLocacoes; 

    private JMenu menuSair; 
    private JMenuItem sair; 

    private JLabel labelListar;

    private JLayeredPane layeredPane;
    private JPanel painelListar;
    private JPanel painelCadastrarCliente;

    private JTextArea areaDeTexto;

    private JButton btnFecharPainel;
    private JButton btnClientesCancelar;
    private JButton btnClientesLimpar;
    private JButton btnClientesSalvar;

    private JTextField txtNome;
	private JTextField txtCnh;
	private JTextField txtTelefone;
	private JTextField txtCpf;

	public Janela() {
        carregarListas();
		inicializar();
	}

    private void carregarListas(){
        categorias = new ListaObjetos();
        veiculos = new CadVeiculos();
        clientes = new CadClientes();
         arquivo = new Arquivo();
        arquivo.getVeiculos(veiculos);
        arquivo.getCategorias(categorias);
        arquivo.getClientes(clientes);
    }

	private void inicializar() {

        setTitle("Pampa Loka Lokadora");
        setResizable(false);
		setBounds(100, 100, 800, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
        setJMenuBar(criarBarraMenu());
		getContentPane().add(criarLayeredPane());
    }

    private JMenuBar criarBarraMenu(){
        
        menuBar = new JMenuBar();
        menuBar.add(criarMenuCLientes());
        menuBar.add(criarMenuVeiculos());
        menuBar.add(criarMenuCategorias());
        menuBar.add(criarMenuLocacoes());
        menuBar.add(criarMenuSair());

        return menuBar;
    }

    private JMenu criarMenuCLientes(){
        menuClientes = new JMenu("Clientes");
		listarClientesDoInicio = new JMenuItem("Listar do Inicio");
        listarClientesDoFim = new JMenuItem("Listar do Fim");
        incluirClientes = new JMenuItem("Incluir");
        excluirClientes = new JMenuItem("Excluir");
        alterarClientes = new JMenuItem("Alterar");
        menuClientes.add(listarClientesDoInicio);
        menuClientes.add(listarClientesDoFim);
        menuClientes.add(incluirClientes);
        menuClientes.add(excluirClientes);
        menuClientes.add(alterarClientes);
        eventos(listarClientesDoInicio);
        eventos(listarClientesDoFim);
        eventos(incluirClientes);
        eventos(excluirClientes);
        eventos(alterarClientes);

        return menuClientes;
    }

    private JMenu criarMenuVeiculos(){
        menuVeiculos = new JMenu("Veículos");
		listarVeiculosDoInicio = new JMenuItem("Listar do Inicio");
        listarVeiculosDoFim = new JMenuItem("Listar do Fim");
		incluirVeiculos = new JMenuItem("Incluir");
		excluirVeiculos = new JMenuItem("Excluir");
        alterarVeiculo = new JMenuItem("Alterar");
		menuVeiculos.add(listarVeiculosDoInicio);
        menuVeiculos.add(listarVeiculosDoFim);
        menuVeiculos.add(incluirVeiculos);
        menuVeiculos.add(excluirVeiculos);
        menuVeiculos.add(alterarVeiculo);
        eventos(listarVeiculosDoInicio);
        eventos(listarVeiculosDoFim);

        return menuVeiculos;
    }

    private JMenu criarMenuCategorias(){
        menuCategorias = new JMenu("Categorias");
        listarCategoriasInicio = new JMenuItem("Listar do Inicio");
        listarCategoriasFim = new JMenuItem("Listar do Fim");
        menuCategorias.add(listarCategoriasInicio);
        menuCategorias.add(listarCategoriasFim);
        eventos(listarCategoriasInicio);
        eventos(listarCategoriasFim);

        return menuCategorias;
    }

    private JMenu criarMenuLocacoes(){
        menuLocacoes = new JMenu("Locações");
		listarLocacoes = new JMenuItem("Listar");
		incluirLocacoes = new JMenuItem("Incluir");
		excluirLocacoes = new JMenuItem("Excluir");
        menuLocacoes.add(listarLocacoes);
        menuLocacoes.add(incluirLocacoes);
        menuLocacoes.add(excluirLocacoes);

        return menuLocacoes;
    }

    private JMenu criarMenuSair(){
        menuSair = new JMenu("Sair");
		sair = new JMenuItem("Fechar Aplicação");
        eventos(sair);
        menuSair.add(sair);

        return menuSair;
    }

    private JLayeredPane criarLayeredPane(){
        layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 760, 560);
		layeredPane.add(painelListar());
        layeredPane.add(painelCadastrarCliente());
        
        return layeredPane;
    }

    private JPanel painelListar(){
        painelListar = new JPanel();
		painelListar.setBounds(10, 11, 745, 545);
		painelListar.setLayout(null);
		
		labelListar = new JLabel("");
		labelListar.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelListar.setBounds(25, 35, 335, 45);
    
        btnFecharPainel = new JButton("Fechar");
		btnFecharPainel.setBounds(620, 505, 115, 25);
        evBotoes(btnFecharPainel);
		painelListar.add(btnFecharPainel);

		painelListar.add(criarAreaDeTexto());
        painelListar.setVisible(false);
		painelListar.add(labelListar);

        return painelListar;
    }

    private JTextArea criarAreaDeTexto(){
        areaDeTexto = new JTextArea();
        areaDeTexto.setBounds(10, 95, 725, 400);
        areaDeTexto.setEditable(false);

        return areaDeTexto;
    }

    private JPanel painelCadastrarCliente(){
        painelCadastrarCliente = new JPanel();
        painelCadastrarCliente.setBounds(10, 11, 745, 545);
        painelCadastrarCliente.setLayout(null);

        JLabel cadastrarCliente = new JLabel("Cadastrar Cliente");
		cadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cadastrarCliente.setBounds(40, 62, 187, 34);
		painelCadastrarCliente.add(cadastrarCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(175, 159, 130, 20);
		painelCadastrarCliente.add(lblNome);
		
		JLabel lblcnh = new JLabel("CNH");
        lblcnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblcnh.setBounds(175, 217, 130, 20);
		painelCadastrarCliente.add(lblcnh);
		
		JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(175, 268, 130, 20);
		painelCadastrarCliente.add(lblTelefone);
		
		JLabel lblCpf = new JLabel("CPF");
        lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(175, 318, 130, 20);
		painelCadastrarCliente.add(lblCpf);

        txtNome = new JTextField();
		txtNome.setBounds(270, 157, 306, 20);
		painelCadastrarCliente.add(txtNome);
		txtNome.setColumns(10);
		
		txtCnh = new JTextField();
		txtCnh.setBounds(270, 214, 306, 20);
		painelCadastrarCliente.add(txtCnh);
		txtCnh.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(270, 265, 306, 20);
		painelCadastrarCliente.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(270, 315, 306, 20);
		painelCadastrarCliente.add(txtCpf);
		txtCpf.setColumns(10);

        btnClientesCancelar = new JButton("Cancelar");
		btnClientesCancelar.setBounds(465, 407, 130, 23);
		painelCadastrarCliente.add(btnClientesCancelar);
		
		btnClientesLimpar = new JButton("Limpar");
		btnClientesLimpar.setBounds(325, 407, 130, 23);
		painelCadastrarCliente.add(btnClientesLimpar);
		
		btnClientesSalvar = new JButton("Salvar");
		btnClientesSalvar.setBounds(175, 407, 130, 23);
		painelCadastrarCliente.add(btnClientesSalvar);

        evBotoes(btnClientesCancelar);
        evBotoes(btnClientesLimpar);
        evBotoes(btnClientesSalvar);

        painelCadastrarCliente.setVisible(false);

        return painelCadastrarCliente;
    }

    private void eventos(JMenuItem item){
        item.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev){

                //Menu CLiente
                if (ev.getSource() == listarClientesDoInicio){
                    encerrarPaineis();
                    labelListar.setText("Clientes Cadastrados");
                    areaDeTexto.append(clientes.imprimeListaInicio());

                    painelListar.setVisible(true);
                }
                if (ev.getSource() == listarClientesDoFim){
                    encerrarPaineis();
                    labelListar.setText("Clientes Cadastrados");
                    areaDeTexto.append(clientes.imprimeListaFinal());
                    painelListar.setVisible(true);
                }
                if (ev.getSource() == incluirClientes){
                    encerrarPaineis();
                    painelCadastrarCliente.setVisible(true);
                }



                //MenuVeículos
                if (ev.getSource() == listarVeiculosDoInicio){
                    encerrarPaineis();
                    labelListar.setText("Veículos Cadastrados");
                    areaDeTexto.append(veiculos.imprimeListaInicio());
                    painelListar.setVisible(true);
                }

                if (ev.getSource() == listarVeiculosDoFim){
                    encerrarPaineis();
                    labelListar.setText("Veículos Cadastrados");
                    areaDeTexto.append(veiculos.imprimeListaFinal());
                    painelListar.setVisible(true);
                }

                //Menu Categorias
                if (ev.getSource() == listarCategoriasInicio){
                    encerrarPaineis();
                    labelListar.setText("Categorias Cadastradas");
                    areaDeTexto.append(categorias.imprimeListaInicio());
                    painelListar.setVisible(true);
                }

                if (ev.getSource() == listarCategoriasFim){
                    encerrarPaineis();
                    labelListar.setText("Categorias Cadastradas");
                    areaDeTexto.append(categorias.imprimeListaFinal());
                    painelListar.setVisible(true);
                }

                //Menu Sair
                if (ev.getSource() == sair){
                    encerrarPaineis();
                    dispose();
                }

            }
        });
    }
    private void evBotoes(JButton item){
        item.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev){
                if (ev.getSource() == btnFecharPainel){
                    areaDeTexto.setText("");
                    painelListar.setVisible(false);
                }
            }
        });

        //Painel Cadastrar Cliente
        item.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev){
                if (ev.getSource() == btnClientesCancelar){
                    encerrarPaineis();
                }
                if (ev.getSource() == btnClientesLimpar){
                    limparCampos();
                }
                if (ev.getSource() == btnClientesSalvar){
                    Cliente cliente = new Cliente(txtNome.getText(), Long.parseLong(txtCnh.getText()),
                        Long.parseLong(txtTelefone.getText()),Long.parseLong(txtCpf.getText()));
                    clientes.insereFim(cliente);
                    encerrarPaineis();
                }
            }
        });
    }

    private void encerrarPaineis(){
        limparCampos();
        areaDeTexto.setText("");
        painelListar.setVisible(false);
        painelCadastrarCliente.setVisible(false);
    }

    private void limparCampos(){
        txtNome.setText("");
        txtCnh.setText("");
        txtTelefone.setText("");
        txtCpf.setText("");
    }
}
