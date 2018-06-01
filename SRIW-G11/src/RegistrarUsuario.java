import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField textPassword;

	/**
	 * Create the frame.
	 */
	public RegistrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Usuario");
		lblNombreDeUsuario.setBounds(58, 37, 100, 14);
		contentPane.add(lblNombreDeUsuario);
		
		textUserName = new JTextField();
		textUserName.setBounds(200, 34, 172, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(58, 82, 100, 14);
		contentPane.add(lblContrasea);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(200, 79, 172, 20);
		contentPane.add(textPassword);
		
		JButton btnRegister = new JButton("Registrar");
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotonRegistrar(e);
			}
		});
				
		btnRegister.setBounds(200, 120, 89, 23);
		contentPane.add(btnRegister);
		this.setLocationRelativeTo(null);
	}
	
	
	private void BotonRegistrar(java.awt.event.ActionEvent evt){
		if(!textUserName.getText().isEmpty()  &&  !String.valueOf(textPassword.getPassword()).isEmpty() ) {
			Usuario usuario = new Usuario(textUserName.getText(), String.valueOf(textPassword.getPassword()));
			Usuarios.addUser(usuario);
			this.setVisible(false);
			Usuarios.login(usuario);
			(new Login()).setVisible(true);
		}else {
			System.out.print("Campos vacios");
		}
	}
}
