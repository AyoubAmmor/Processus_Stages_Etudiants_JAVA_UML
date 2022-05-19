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
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;


public class connexion_etudiant extends JFrame {
	
	

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
					connexion_etudiant frame = new connexion_etudiant();
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
	public connexion_etudiant() {
		setResizable(false);
		
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 330);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel.setBounds(0, 0, 606, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("");
		lbl.setBounds(97, 168, 89, 77);
		lbl.setIcon(new ImageIcon(connexion_etudiant.class.getResource("/images/student-with-graduation-cap.png")));
		panel.add(lbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 29, 279, 194);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(UIManager.getColor("Button.background"));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(connexion_etudiant.class.getResource("/images/user.png")));
		lblNewLabel.setBounds(202, 17, 46, 28);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(connexion_etudiant.class.getResource("/images/pass.png")));
		label.setBounds(202, 72, 46, 14);
		panel_1.add(label);
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setFont(new Font("Perpetua", Font.PLAIN, 16));
		lblUsername.setBounds(21, 25, 71, 14);
		panel_1.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("password : ");
		lblNewLabel_1.setFont(new Font("Perpetua", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(21, 58, 86, 28);
		panel_1.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setBounds(92, 25, 100, 20);
		panel_1.add(textUser);
		textUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(92, 66, 100, 20);
		panel_1.add(txtPass);
		
		JButton btnValider = new JButton("login");
		btnValider.setBounds(110, 137, 89, 23);
		panel_1.add(btnValider);
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnValider.setForeground(Color.BLACK);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_uml","root","");
					Statement st=cnx.createStatement();
					
					String sql="Select * from etudiant where login='"+textUser.getText()+"' and password='"+txtPass.getText().toString()+"' ";
					
					ResultSet rs=st.executeQuery(sql);
					
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null, "ok");
						setState(ICONIFIED);
						espp mp=new espp();
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
		
		JLabel lblNewLabel_2 = new JLabel("\"a building with four walls and tomorrow inside");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(22, 116, 237, 41);
		panel.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(connexion_etudiant.class.getResource("/images/LOGO-ENSAK-800.png")));
		label_1.setBounds(61, 11, 136, 94);
		panel.add(label_1);
	}
}

    
