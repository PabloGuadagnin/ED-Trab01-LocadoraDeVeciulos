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
import Locadora_de_Veiculos.Objetos.Locacao;
import Locadora_de_Veiculos.Objetos.Veiculo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame {

    private CadClientes clientes;
    private CadVeiculos veiculos;
    private ListaObjetos categorias;
    private ListaObjetos locacoes; 
    private Arquivo arquivo;

    private JMenuBar menuBar;

    private JMenu menuClientes;
    private JMenuItem listarClientesDoInicio;
    private JMenuItem listarClientesDoFim;
    private JMenuItem incluirClientes;
    private JMenuItem editarClientes;

    private JMenu menuVeiculos;
    private JMenuItem listarVeiculosDoInicio;
    private JMenuItem listarVeiculosDoFim;
    private JMenuItem incluirVeiculos;
    private JMenuItem editarVeiculos;

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
    private JLabel lblInformeCpf;
    private JLabel lblInformePlaca;

    private JLayeredPane layeredPane;
    private JPanel painelListar;
    private JPanel painelCadastrarCliente;
    private JPanel painelEditar;
    private JPanel painelEditarCliente;
    private JPanel painelEditarVeiculo;
    private JPanel painelIncluirLocacao;

    private JTextArea areaDeTexto;

    private JButton btnFecharPainel;
    private JButton btnClientesCancelar;
    private JButton btnClientesLimpar;
    private JButton btnClientesSalvar;
    private JButton btnExcluir;
    private JButton btnCancelarExclusao;
    private JButton btnEditar;
    private JButton btnEditarVeiculo;
    private JButton btnExcluirVeiculo;
    private JButton btnEditarClientesCancelar;
    private JButton btnEditarClientesSalvar;
    private JButton btnCancelarExclusaoVeiculo;
    private JButton btnLocacaoCancelar;
    private JButton btnLocacaoLimpar;
    private JButton btnLocacaoSalvar;

    private JTextField txtNome;
    private JTextField txtCnh;
    private JTextField txtTelefone;
    private JTextField txtCpf;
    private JTextField txtEditar;
    private JTextField txtEditarVeiculo;
    private JTextField txtEditarNome;
    private JTextField txtEditarCnh;
    private JTextField txtEditarTelefone;
    private JTextField txtEditarCpf;
    private JTextField txtCnhLocacao;
    private JTextField txtPlacaLocacao;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JTextField txtValor;

    private String cpfAux;

    public Janela() {
        carregarListas();
        inicializar();
    }

    private void carregarListas() {
        categorias = new ListaObjetos();
        locacoes = new ListaObjetos();
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

    private JMenuBar criarBarraMenu() {

        menuBar = new JMenuBar();
        menuBar.add(criarMenuClientes());
        menuBar.add(criarMenuVeiculos());
        menuBar.add(criarMenuCategorias());
        menuBar.add(criarMenuLocacoes());
        menuBar.add(criarMenuSair());

        return menuBar;
    }

    private JMenu criarMenuClientes() {
        menuClientes = new JMenu("Clientes");
        listarClientesDoInicio = new JMenuItem("Listar do Inicio");
        listarClientesDoFim = new JMenuItem("Listar do Fim");
        incluirClientes = new JMenuItem("Incluir Novo Cliente");
        editarClientes = new JMenuItem("Editar/Excluir Cliente");
        menuClientes.add(listarClientesDoInicio);
        menuClientes.add(listarClientesDoFim);
        menuClientes.add(incluirClientes);
        menuClientes.add(editarClientes);
        eventos(listarClientesDoInicio);
        eventos(listarClientesDoFim);
        eventos(incluirClientes);
        eventos(editarClientes);

        return menuClientes;
    }

    private JMenu criarMenuVeiculos() {
        menuVeiculos = new JMenu("Veículos");
        listarVeiculosDoInicio = new JMenuItem("Listar do Inicio");
        listarVeiculosDoFim = new JMenuItem("Listar do Fim");
        incluirVeiculos = new JMenuItem("Incluir");
        editarVeiculos = new JMenuItem("Editar");
        menuVeiculos.add(listarVeiculosDoInicio);
        menuVeiculos.add(listarVeiculosDoFim);
        menuVeiculos.add(incluirVeiculos);
        menuVeiculos.add(editarVeiculos);
        eventos(listarVeiculosDoInicio);
        eventos(listarVeiculosDoFim);
        eventos(editarVeiculos);

        return menuVeiculos;
    }

    private JMenu criarMenuCategorias() {
        menuCategorias = new JMenu("Categorias");
        listarCategoriasInicio = new JMenuItem("Listar do Inicio");
        listarCategoriasFim = new JMenuItem("Listar do Fim");
        menuCategorias.add(listarCategoriasInicio);
        menuCategorias.add(listarCategoriasFim);
        eventos(listarCategoriasInicio);
        eventos(listarCategoriasFim);

        return menuCategorias;
    }

    private JMenu criarMenuLocacoes() {
        menuLocacoes = new JMenu("Locações");
        listarLocacoes = new JMenuItem("Listar");
        incluirLocacoes = new JMenuItem("Incluir");
        excluirLocacoes = new JMenuItem("Excluir");
        menuLocacoes.add(listarLocacoes);
        menuLocacoes.add(incluirLocacoes);
        menuLocacoes.add(excluirLocacoes);
        eventos(listarLocacoes);
        eventos(incluirLocacoes);
        eventos(excluirLocacoes);

        return menuLocacoes;
    }

    private JMenu criarMenuSair() {
        menuSair = new JMenu("Sair");
        sair = new JMenuItem("Fechar Aplicação");
        eventos(sair);
        menuSair.add(sair);

        return menuSair;
    }

    private JLayeredPane criarLayeredPane() {
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(10, 11, 760, 560);
        layeredPane.add(painelListar());
        layeredPane.add(painelCadastrarCliente());
        layeredPane.add(painelEditar());
        layeredPane.add(painelEditarCliente());
        layeredPane.add(painelEditarVeiculo());
        layeredPane.add(painelIncluirLocacao());

        return layeredPane;
    }

    private JPanel painelListar() {
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

    private JTextArea criarAreaDeTexto() {
        areaDeTexto = new JTextArea();
        areaDeTexto.setBounds(10, 95, 725, 400);
        areaDeTexto.setEditable(false);

        return areaDeTexto;
    }

    private JPanel painelCadastrarCliente() {
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

    private JPanel painelEditar() {
        painelEditar = new JPanel();
        painelEditar.setBounds(10, 11, 745, 545);
        painelEditar.setLayout(null);

        lblInformeCpf = new JLabel(" Informe o CPF:");
        lblInformeCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblInformeCpf.setBounds(110, 245, 150, 20);
        painelEditar.add(lblInformeCpf);

        txtEditar = new JTextField();
        txtEditar.setBounds(286, 249, 217, 20);
        painelEditar.add(txtEditar);
        txtEditar.setColumns(20);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(240, 345, 90, 25);
        painelEditar.add(btnEditar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(340, 345, 90, 25);
        painelEditar.add(btnExcluir);

        btnCancelarExclusao = new JButton("Cancelar");
        btnCancelarExclusao.setBounds(440, 345, 90, 25);
        painelEditar.add(btnCancelarExclusao);

        evBotoes(btnEditar);
        evBotoes(btnExcluir);
        evBotoes(btnCancelarExclusao);
        painelEditar.setVisible(false);

        return painelEditar;
    }

    private JPanel painelEditarCliente(){
        painelEditarCliente = new JPanel();
        painelEditarCliente.setBounds(10, 11, 745, 545);
        painelEditarCliente.setLayout(null);

        JLabel lbleditarCliente = new JLabel("Editar Cliente");
        lbleditarCliente.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lbleditarCliente.setBounds(40, 62, 187, 34);
        painelEditarCliente.add(lbleditarCliente);

        JLabel lblEditarNome = new JLabel("Nome");
        lblEditarNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEditarNome.setBounds(175, 159, 130, 20);
        painelEditarCliente.add(lblEditarNome);

        JLabel lblEditarcnh = new JLabel("CNH");
        lblEditarcnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEditarcnh.setBounds(175, 217, 130, 20);
        painelEditarCliente.add(lblEditarcnh);

        JLabel lblEditarTelefone = new JLabel("Telefone");
        lblEditarTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEditarTelefone.setBounds(175, 268, 130, 20);
        painelEditarCliente.add(lblEditarTelefone);

        JLabel lblEditarCpf = new JLabel("CPF");
        lblEditarCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEditarCpf.setBounds(175, 318, 130, 20);
        painelEditarCliente.add(lblEditarCpf);

        txtEditarNome = new JTextField();
        txtEditarNome.setBounds(270, 157, 306, 20);
        painelEditarCliente.add(txtEditarNome);
        txtEditarNome.setColumns(10);

        txtEditarCnh = new JTextField();
        txtEditarCnh.setBounds(270, 214, 306, 20);
        painelEditarCliente.add(txtEditarCnh);
        txtEditarCnh.setColumns(10);

        txtEditarTelefone = new JTextField();
        txtEditarTelefone.setBounds(270, 265, 306, 20);
        painelEditarCliente.add(txtEditarTelefone);
        txtEditarTelefone.setColumns(10);

        txtEditarCpf = new JTextField();
        txtEditarCpf.setBounds(270, 315, 306, 20);
        painelEditarCliente.add(txtEditarCpf);
        txtEditarCpf.setColumns(10);

        btnEditarClientesCancelar = new JButton("Cancelar");
        btnEditarClientesCancelar.setBounds(400, 407, 130, 23);
        painelEditarCliente.add(btnEditarClientesCancelar);


        btnEditarClientesSalvar = new JButton("Salvar");
        btnEditarClientesSalvar.setBounds(250, 407, 130, 23);
        painelEditarCliente.add(btnEditarClientesSalvar);

        evBotoes(btnEditarClientesCancelar);
        evBotoes(btnEditarClientesSalvar);

        painelEditarCliente.setVisible(false);

        return painelEditarCliente;
    }
    
    private JPanel painelEditarVeiculo() {
        painelEditarVeiculo = new JPanel();
        painelEditarVeiculo.setBounds(10, 11, 745, 545);
        painelEditarVeiculo.setLayout(null);

        lblInformePlaca = new JLabel(" Informe a Placa:");
        lblInformePlaca.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblInformePlaca.setBounds(110, 245, 160, 20);
        painelEditarVeiculo.add(lblInformePlaca);

        txtEditarVeiculo = new JTextField();
        txtEditarVeiculo.setBounds(285, 249, 217, 20);
        painelEditarVeiculo.add(txtEditarVeiculo);
        txtEditarVeiculo.setColumns(10);

        btnEditarVeiculo = new JButton("Editar");
        btnEditarVeiculo.setBounds(240, 345, 90, 25);
        painelEditarVeiculo.add(btnEditarVeiculo);


        btnExcluirVeiculo = new JButton("Excluir");
        btnExcluirVeiculo.setBounds(340, 345, 90, 25);
        painelEditarVeiculo.add(btnExcluirVeiculo);

        btnCancelarExclusaoVeiculo = new JButton("Cancelar");
        btnCancelarExclusaoVeiculo.setBounds(440, 345, 90, 25);
        painelEditarVeiculo.add(btnCancelarExclusaoVeiculo);

        evBotoes(btnEditarVeiculo);
        evBotoes(btnExcluirVeiculo);
        evBotoes(btnCancelarExclusao);
        painelEditarVeiculo.setVisible(false);

        return painelEditarVeiculo;
    }

    private JPanel painelIncluirLocacao(){
        painelIncluirLocacao = new JPanel();
        painelIncluirLocacao.setBounds(10, 11, 745, 545);
        painelIncluirLocacao.setLayout(null);

        JLabel lblNovaLocacao = new JLabel("Nova Locação");
		lblNovaLocacao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNovaLocacao.setBounds(40, 62, 187, 34);
		painelIncluirLocacao.add(lblNovaLocacao);

        JLabel lblCnhLocacao = new JLabel("CNH");
		lblCnhLocacao.setBounds(172, 163, 46, 14);
		painelIncluirLocacao.add(lblCnhLocacao);

        JLabel lblPlacaLocacao = new JLabel("Placa");
		lblPlacaLocacao.setBounds(172, 194, 46, 14);
		painelIncluirLocacao.add(lblPlacaLocacao);

        JLabel lblDataInicio = new JLabel("Data Inicial");
		lblDataInicio.setBounds(172, 227, 66, 14);
		painelIncluirLocacao.add(lblDataInicio);

        JLabel lblDataFim = new JLabel("Data Final");
		lblDataFim.setBounds(172, 263, 66, 14);
		painelIncluirLocacao.add(lblDataFim);

        JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(172, 293, 66, 14);
		painelIncluirLocacao.add(lblValor);

        txtCnhLocacao = new JTextField();
		txtCnhLocacao.setBounds(283, 160, 217, 20);
		painelIncluirLocacao.add(txtCnhLocacao);
		txtCnhLocacao.setColumns(10);

        txtPlacaLocacao = new JTextField();
		txtPlacaLocacao.setColumns(10);
		txtPlacaLocacao.setBounds(283, 191, 217, 20);
		painelIncluirLocacao.add(txtPlacaLocacao);

        txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		txtDataInicio.setBounds(283, 224, 217, 20);
		painelIncluirLocacao.add(txtDataInicio);

        txtDataFim = new JTextField();
		txtDataFim.setColumns(10);
		txtDataFim.setBounds(283, 255, 217, 20);
		painelIncluirLocacao.add(txtDataFim);

        txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(283, 293, 217, 20);
		painelIncluirLocacao.add(txtValor);

        btnLocacaoCancelar = new JButton("Cancelar");
        btnLocacaoCancelar.setBounds(465, 407, 130, 23);
        painelIncluirLocacao.add(btnLocacaoCancelar);

        btnLocacaoLimpar = new JButton("Limpar");
        btnLocacaoLimpar.setBounds(325, 407, 130, 23);
        painelIncluirLocacao.add(btnLocacaoLimpar);

        btnLocacaoSalvar = new JButton("Salvar");
        btnLocacaoSalvar.setBounds(175, 407, 130, 23);
        painelIncluirLocacao.add(btnLocacaoSalvar);

        evBotoes(btnLocacaoCancelar);
        evBotoes(btnLocacaoLimpar);
        evBotoes(btnLocacaoSalvar);

        painelIncluirLocacao.setVisible(false);

        return painelIncluirLocacao;
    }

    private void eventos(JMenuItem item) {
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                // Menu CLiente
                if (ev.getSource() == listarClientesDoInicio) {
                    encerrarPaineis();
                    labelListar.setText("Clientes Cadastrados");
                    areaDeTexto.append(clientes.imprimeListaInicio());

                    painelListar.setVisible(true);
                }
                if (ev.getSource() == listarClientesDoFim) {
                    encerrarPaineis();
                    labelListar.setText("Clientes Cadastrados");
                    areaDeTexto.append(clientes.imprimeListaFinal());
                    painelListar.setVisible(true);
                }
                if (ev.getSource() == incluirClientes) {
                    encerrarPaineis();
                    painelCadastrarCliente.setVisible(true);
                }
                if (ev.getSource() == editarClientes) {
                    encerrarPaineis();
                    painelEditar.setVisible(true);
                }

                // MenuVeículos
                if (ev.getSource() == listarVeiculosDoInicio) {
                    encerrarPaineis();
                    labelListar.setText("Veículos Cadastrados");
                    areaDeTexto.append(veiculos.imprimeListaInicio());
                    painelListar.setVisible(true);
                }

                if (ev.getSource() == listarVeiculosDoFim) {
                    encerrarPaineis();
                    labelListar.setText("Veículos Cadastrados");
                    areaDeTexto.append(veiculos.imprimeListaFinal());
                    painelListar.setVisible(true);
                }

                if(ev.getSource() == editarVeiculos){
                    encerrarPaineis();
                    painelEditarVeiculo.setVisible(true);
                }

                // Menu Categorias
                if (ev.getSource() == listarCategoriasInicio) {
                    encerrarPaineis();
                    labelListar.setText("Categorias Cadastradas");
                    areaDeTexto.append(categorias.imprimeListaInicio());
                    painelListar.setVisible(true);
                }

                if (ev.getSource() == listarCategoriasFim) {
                    encerrarPaineis();
                    labelListar.setText("Categorias Cadastradas");
                    areaDeTexto.append(categorias.imprimeListaFinal());
                    painelListar.setVisible(true);
                }

                //Menu locações

                if(ev.getSource() == listarLocacoes){
                    encerrarPaineis();
                    labelListar.setText("Teste");
                    areaDeTexto.append(locacoes.imprimeListaInicio());
                    painelListar.setVisible(true);
                }
                if(ev.getSource() == incluirLocacoes){
                    encerrarPaineis();
                    painelIncluirLocacao.setVisible(true);
                }

                // Menu Sair
                if (ev.getSource() == sair) {
                    encerrarPaineis();
                    dispose();
                }

            }
        });
    }

    public void evBotoes(JButton item) {
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (ev.getSource() == btnFecharPainel) {
                    areaDeTexto.setText("");
                    painelListar.setVisible(false);
                }
            }
        });

       
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                
                // Painel Cadastrar Cliente
                if (ev.getSource() == btnClientesCancelar) {
                    encerrarPaineis();
                }
                if (ev.getSource() == btnClientesLimpar) {
                    limparCampos();
                }
                if (ev.getSource() == btnClientesSalvar) {
                        Cliente cliente = new Cliente(txtNome.getText(), converterParaLong(txtCnh.getText()),
                            converterParaLong(txtTelefone.getText()), converterParaLong(txtCpf.getText()));
                        clientes.insereFim(cliente);
                        encerrarPaineis();
                }

                //Painel Editar Cliente
                if (ev.getSource() == btnCancelarExclusao) {
                    encerrarPaineis();
                }
                if (ev.getSource() == btnExcluir) {
                    if (!clientes.estahVazia()) {
                        Object cliente = new Object();
                        cliente = clientes.procuraClientePorCpf(converterParaLong(txtEditar.getText()));
                        clientes.remove(cliente);
                        encerrarPaineis();
                    }
                }
                if (ev.getSource() == btnEditar){
                    cpfAux = txtEditar.getText();
                    encerrarPaineis();      
                    painelEditarCliente.setVisible(true);
                    dadosDoCliente(cpfAux);
                    txtEditarCpf.setEditable(false);
                    cpfAux = "";
                }
                if (ev.getSource() == btnEditarClientesSalvar){
                    ((Cliente)clientes.procuraClientePorCpf(converterParaLong(txtEditarCpf.getText()))).setNome(txtEditarNome.getText());
                    ((Cliente)clientes.procuraClientePorCpf(converterParaLong(txtEditarCpf.getText()))).setTelefone(converterParaLong(txtEditarTelefone.getText()));
                    ((Cliente)clientes.procuraClientePorCpf(converterParaLong(txtEditarCpf.getText()))).setCnh(converterParaLong(txtEditarCnh.getText()));
                    encerrarPaineis();
                }
                if (ev.getSource() == btnEditarClientesCancelar){
                    encerrarPaineis();
                }

                //Painel Editar Veiculo
                if(ev.getSource() == btnCancelarExclusaoVeiculo){
                    encerrarPaineis();
                }
                if(ev.getSource() == btnExcluirVeiculo){
                    if (!veiculos.estahVazia()) {
                        Object veiculo = new Object();
                        veiculo = veiculos.procuraVeiculoPorPlaca(txtEditarVeiculo.getText());
                        veiculos.remove(veiculo);
                        encerrarPaineis();
                        
                    }
                }

                //Painel incluir locacao
                if(ev.getSource() == btnLocacaoCancelar){
                    encerrarPaineis();
                }
                if(ev.getSource() == btnLocacaoLimpar){
                    limparCampos();
                }
                if(ev.getSource() == btnLocacaoSalvar){
                    Locacao locacao = new Locacao(converterParaLong(txtCnhLocacao.getText()), txtPlacaLocacao.getText(),
                        txtDataInicio.getText(), txtDataFim.getText(), Double.parseDouble(txtValor.getText()));  
                    ((Cliente)clientes.procuraClientePorCnh(converterParaLong(txtCnhLocacao.getText()))).setLocacao(true);
                    ((Veiculo)veiculos.procuraVeiculoPorPlaca(txtPlacaLocacao.getText())).setLocacao(true);

                    locacoes.insereFim(locacao);
                    encerrarPaineis();
                }
            }
        });
    }

    private void encerrarPaineis() {
        limparCampos();
        areaDeTexto.setText("");
        painelListar.setVisible(false);
        painelCadastrarCliente.setVisible(false);
        painelEditar.setVisible(false);
        painelEditarCliente.setVisible(false);
        painelEditarVeiculo.setVisible(false);
        painelIncluirLocacao.setVisible(false);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCnh.setText("");
        txtTelefone.setText("");
        txtCpf.setText("");
        txtEditar.setText("");
        txtEditarVeiculo.setText("");
        txtCnhLocacao.setText("");
        txtPlacaLocacao.setText("");
        txtDataFim.setText("");
        txtDataInicio.setText("");
    }

    private void dadosDoCliente(String cpf){
        txtEditarNome.setText(((Cliente)clientes.procuraClientePorCpf(converterParaLong(cpf))).getNome());
        txtEditarCnh.setText(Long.toString(((Cliente)clientes.procuraClientePorCpf(converterParaLong(cpf))).getCnh()));
        txtEditarTelefone.setText(Long.toString(((Cliente)clientes.procuraClientePorCpf(converterParaLong(cpf))).getTelefone()));
        txtEditarCpf.setText(Long.toString(((Cliente)clientes.procuraClientePorCpf(converterParaLong(cpf))).getCpf()));

    }

    private long converterParaLong(String texto){
        return Long.parseLong(texto);
    }

}
