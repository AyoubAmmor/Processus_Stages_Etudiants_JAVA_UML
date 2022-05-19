package projet_uml;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class demande extends JFrame {

	private JPanel contentPane;
	private JTextField prelangue;
	private JTextField tel;
	private JTextField login;
	private JTextField deuxlangue;
	private JTextField troislangue;
	private JTextField idstg;
	private JTextField parag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demande frame = new demande();
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
	public demande() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("FORMULAIRE DE DEMANDE DE STAGE");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel_3.setBounds(120, 110, 454, 54);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Merci de bien vouloir remplir ce formulaire dans son int\u00E9gralit\u00E9,");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(140, 158, 362, 20);
		panel.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 106, 634, 20);
		panel.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("Candidat");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setBounds(10, 187, 89, 20);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Login :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(38, 215, 46, 17);
		panel.add(lblNewLabel_6);
		
		prelangue = new JTextField();
		prelangue.setBounds(120, 282, 100, 20);
		panel.add(prelangue);
		prelangue.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("T\u00E9l\u00E9phone :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(260, 217, 79, 18);
		panel.add(lblNewLabel_7);
		
		tel = new JTextField();
		tel.setBounds(351, 217, 126, 20);
		panel.add(tel);
		tel.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Langues\r\n");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5_1.setBounds(10, 249, 89, 20);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("1\u00E9re langue\r\n :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(38, 283, 79, 17);
		panel.add(lblNewLabel_6_1);
		
		login = new JTextField();
		login.setColumns(10);
		login.setBounds(94, 218, 126, 20);
		panel.add(login);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("2\u00E8me langue\r\n :");
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1_1.setBounds(228, 283, 89, 17);
		panel.add(lblNewLabel_6_1_1);
		
		deuxlangue = new JTextField();
		deuxlangue.setColumns(10);
		deuxlangue.setBounds(319, 282, 100, 20);
		panel.add(deuxlangue);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("3\u00E8me langue\r\n :");
		lblNewLabel_6_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1_1_1.setBounds(429, 283, 86, 17);
		panel.add(lblNewLabel_6_1_1_1);
		
		troislangue = new JTextField();
		troislangue.setColumns(10);
		troislangue.setBounds(525, 282, 100, 20);
		panel.add(troislangue);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Stage\r\n");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5_1_1.setBounds(10, 324, 89, 20);
		panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Code de stage\r\n :");
		lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1_2.setBounds(38, 355, 100, 17);
		panel.add(lblNewLabel_6_1_2);
		
		idstg = new JTextField();
		idstg.setColumns(10);
		idstg.setBounds(138, 354, 126, 20);
		panel.add(idstg);
		
		JLabel lblNewLabel_8 = new JLabel("*Indiquer les raisons pour lesquelles vous faites cette demande de stage,");
		lblNewLabel_8.setBounds(216, 381, 371, 20);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("ce que vous esp\u00E9rez apprendre ainsi,ses avantages pour vos futurs employeurs");
		lblNewLabel_9.setBounds(216, 395, 397, 20);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(" ou institutionsses avantages pour vos futurs employeurs ou institutions");
		lblNewLabel_10.setBounds(214, 409, 355, 20);
		panel.add(lblNewLabel_10);
		
		parag = new JTextField();
		parag.setBounds(76, 429, 537, 42);
		panel.add(parag);
		parag.setColumns(10);
		
		JButton btnNewButton = new JButton("Envoyer");
		btnNewButton.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					 LocalDate d = LocalDate.now();
					
		             theQuery("insert into demande(id_stage,login,date,telephone,prelangue,deuxlangue,troislangue,parag) values('"+idstg.getText()+"','"+login.getText()+"','"+d+"','"+Integer.parseInt(tel.getText())+"','"+prelangue.getText()+"','"+deuxlangue.getText()+"','"+troislangue.getText()+"','"+parag.getText()+"')");
		         }
		         catch(Exception ex){}
			}
		});
		btnNewButton.setBounds(262, 482, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));

		lblNewLabel.setBounds(0, 154, 634, 365);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel_1.setBounds(0, 0, 634, 109);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Espace Etudiant\r\n");
		lblNewLabel_2.setBounds(180, 34, 279, 47);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(545, 10, 79, 90);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(demande.class.getResource("/images/student-with-graduation-cap.png")));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(demande.class.getResource("/images/LOGO-ENSAK-800.png")));
		label.setBounds(10, 11, 138, 89);
		panel_1.add(label);
	}
	static Connection cnx() {
		try {
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/project_uml","root","");
			
		}
		catch(Exception e) {
			System.out.println("Connexion échouée "+e);
			}
			return null;
		}
	public void theQuery(String query){
	      Connection con = null;
	      Statement st = null;
	      try{
	    		String driver="com.mysql.jdbc.Driver";
				Class.forName(driver);
	          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_uml","root","");
	          st = con.createStatement();
	          st.executeUpdate(query);
	          JOptionPane.showMessageDialog(null,"Requête exécutée avec succès");
	      }catch(Exception ex){
	          JOptionPane.showMessageDialog(null,ex.getMessage());
	      }
	  }
}
