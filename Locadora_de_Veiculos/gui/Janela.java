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
import Locadora_de_Veiculos.gui.Clientes.PainelEditarClientes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame {

    private CadClientes clientes;
    private CadVeiculos veiculos;
    private ListaObjetos categorias;
    private ListaObjetos locacao; ///////////////////////////////
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
    private JLabel lblInformeCpf;

    private JLayeredPane layeredPane;
    private JPanel painelListar;
    private JPanel painelCadastrarCliente;
    private JPanel painelEditar;
    private JPanel painelEditarCliente;

    private JTextArea areaDeTexto;

    private JButton btnFecharPainel;
    private JButton btnClientesCancelar;
    private JButton btnClientesLimpar;
    private JButton btnClientesSalvar;
    private JButton btnExcluir;
    private JButton btnCancelarExclusao;
    private JButton btnEditar;

    private JButton btnEditarClientesCancelar;
    private JButton btnEditarClientesSalvar;

    private JTextField txtNome;
    private JTextField txtCnh;
    private JTextField txtTelefone;
    private JTextField txtCpf;
    private JTextField txtEditar;

    private JTextField txtEditarNome;
    private JTextField txtEditarCnh;
    private JTextField txtEditarTelefone;
    private JTextField txtEditarCpf;


    private String cpfAux;

    public Janela() {
        carregarListas();
        inicializar();
    }


    private void carregarListas() {
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


    private JMenuBar criarBarraMenu() {

        menuBar = new JMenuBar();
        menuBar.add(criarMenuCLientes());
        menuBar.add(criarMenuVeiculos());
        menuBar.add(criarMenuCategorias());
        menuBar.add(criarMenuLocacoes());
        menuBar.add(criarMenuSair());

        return menuBar;
    }

    private JMenu criarMenuCLientes() {
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
        lblInformeCpf.setBounds(120, 245, 150, 20);
        painelEditar.add(lblInformeCpf);

        txtEditar = new JTextField();
        txtEditar.setBounds(285, 249, 217, 20);
        painelEditar.add(txtEditar);
        txtEditar.setColumns(10);

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
                    areaDeTexto.append(locacao.imprimeListaInicio());
                    painelListar.setVisible(true);

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

        // Painel Cadastrar Cliente
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (ev.getSource() == btnClientesCancelar) {
                    encerrarPaineis();
                }
                if (ev.getSource() == btnClientesLimpar) {
                    limparCampos();
                }
                if (ev.getSource() == btnClientesSalvar) {
                        Cliente cliente = new Cliente(txtNome.getText(), Long.parseLong(txtCnh.getText()),
                                Long.parseLong(txtTelefone.getText()), Long.parseLong(txtCpf.getText()));
                        clientes.insereFim(cliente);
                        encerrarPaineis();
                }
                if (ev.getSource() == btnCancelarExclusao) {
                    encerrarPaineis();
                }
                if (ev.getSource() == btnExcluir) {
                    if (!clientes.estahVazia()) {
                        Object cliente = new Object();
                        Long cpf = Long.parseLong(txtEditar.getText());
                        cliente = clientes.procuraClientePorCpf(cpf);
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
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCnh.setText("");
        txtTelefone.setText("");
        txtCpf.setText("");
        txtEditar.setText("");
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
