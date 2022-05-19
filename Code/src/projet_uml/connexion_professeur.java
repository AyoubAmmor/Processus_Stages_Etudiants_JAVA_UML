    package projet_uml;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;


public class connexion_professeur extends JFrame {
	
	

	private JPanel contentPane;
	private JPasswordField txtPass;
	private JTextField textUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion_professeur frame = new connexion_professeur();
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
	public connexion_professeur() {
		setResizable(false);
		
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 331);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(290, 46, 275, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(243, 32, 24, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(connexion_professeur.class.getResource("/images/user.png")));
		
		txtPass = new JPasswordField();
		txtPass.setBounds(93, 67, 135, 22);
		panel.add(txtPass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(243, 67, 46, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(connexion_professeur.class.getResource("/images/pass.png")));
		
		textUser = new JTextField();
		textUser.setBounds(93, 32, 135, 24);
		panel.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setFont(new Font("Perpetua", Font.PLAIN, 16));
		lblUsername.setBounds(10, 31, 137, 24);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Perpetua", Font.PLAIN, 15));
		lblPassword.setBounds(10, 70, 74, 14);
		panel.add(lblPassword);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(112, 143, 89, 23);
		panel.add(btnValider);
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnValider.setForeground(Color.BLACK);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_uml","root","");
					Statement st=cnx.createStatement();
					
					String sql="Select * from professeur where login_prof='"+textUser.getText()+"' and password='"+txtPass.getText().toString()+"' ";
					
					ResultSet rs=st.executeQuery(sql);
					
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null, "ok");
						setState(ICONIFIED);
						MenuPrincipalProfesseur mp=new MenuPrincipalProfesseur();
						mp.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Veuillez vérifier votre login et mot de passe !!");
					
					cnx.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(connexion_professeur.class.getResource("/images/professor(1).png")));
		label.setBounds(95, 183, 157, 64);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(connexion_professeur.class.getResource("/images/LOGO-ENSAK-800.png")));
		label_1.setBounds(64, 11, 157, 101);
		contentPane.add(label_1);
		
		JLabel lblABuildingWith = new JLabel("\"a building with four walls and tomorrow inside");
		lblABuildingWith.setFont(new Font("Sylfaen", Font.ITALIC, 12));
		lblABuildingWith.setBounds(10, 144, 240, 14);
		contentPane.add(lblABuildingWith);
	}
}

    
