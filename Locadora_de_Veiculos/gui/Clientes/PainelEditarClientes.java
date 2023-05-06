package Locadora_de_Veiculos.gui.Clientes;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Locadora_de_Veiculos.gui.Janela;

public class PainelEditarClientes extends JPanel {

    private JPanel painelEditarCliente;

    private JTextField txtEditarNome;
    private JTextField txtEditarCnh;
    private JTextField txtEditarTelefone;
    private JTextField txtEditarCpf;

    private JButton btnEditarClientesCancelar;
    private JButton btnEditarClientesSalvar;



    public JPanel criarPainel222(){

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

        //evBotoes(btnEditarClientesCancelar);
        //evBotoes(btnEditarClientesSalvar);

        painelEditarCliente.setVisible(false);
        return painelEditarCliente;
    
    }
    
    public JButton getBtnEditarCLienteSalvar(){
        return btnEditarClientesSalvar;
    }

    
}
