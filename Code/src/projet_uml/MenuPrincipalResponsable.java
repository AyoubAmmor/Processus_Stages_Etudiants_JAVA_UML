    package projet_uml;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.UIManager;

public class MenuPrincipalResponsable extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JTextField textsujet;
	private JTextField txtnum;
	private JTextField txtid;
	private JTextField txtsjt;
	private JTextField txtsup;
	private JTextField txtiid;
	private JTextField txtlogin;
	private JTable table;
	private JTextField id_supp;
	private JTextField login_supp;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtident;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textEntreprise;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalResponsable frame = new MenuPrincipalResponsable();
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
	public MenuPrincipalResponsable() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				DataShow();
			}
		});
		
		
		setResizable(false);
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 383);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 597, 101);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEspaceDeGestion = new JLabel("Espace Responsable ");
		lblEspaceDeGestion.setBounds(182, 38, 261, 49);
		lblEspaceDeGestion.setForeground(new Color(0, 0, 0));
		lblEspaceDeGestion.setFont(new Font("Javanese Text", Font.BOLD, 27));
		panel.add(lblEspaceDeGestion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MenuPrincipalResponsable.class.getResource("/images/responsibility.png")));
		label.setBounds(485, 19, 88, 68);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipalResponsable.class.getResource("/images/LOGO-ENSAK-800.png")));
		lblNewLabel_1.setBounds(10, 11, 146, 79);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("ok");
		panel_1.setBounds(0, 79, 597, 257);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 21, 597, 341);
		panel_1.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Mise à  jour des listes de stage", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 592, 334);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Ajouter", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(UIManager.getColor("Button.background"));
		panel_10.setBounds(26, 11, 529, 174);
		panel_5.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblIdstage = new JLabel("id_stage :");
		lblIdstage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdstage.setBounds(170, 31, 67, 21);
		panel_10.add(lblIdstage);
		
		textid = new JTextField();
		textid.setBounds(247, 32, 86, 20);
		panel_10.add(textid);
		textid.setColumns(10);
		
		textsujet = new JTextField();
		textsujet.setBounds(247, 63, 86, 20);
		panel_10.add(textsujet);
		textsujet.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("sujet :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(170, 63, 46, 18);
		panel_10.add(lblNewLabel);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnValider.setBounds(250, 140, 89, 23);
		panel_10.add(btnValider);
		
		JLabel lblEntreprise = new JLabel("Entreprise :");
		lblEntreprise.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEntreprise.setBounds(170, 97, 67, 14);
		panel_10.add(lblEntreprise);
		
		textEntreprise = new JTextField();
		textEntreprise.setBounds(247, 94, 86, 20);
		panel_10.add(textEntreprise);
		textEntreprise.setColumns(10);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		             theQuery("insert into stage(id_stage,sujet,entreprise) values ('"+Integer.parseInt(textid.getText())+"','"+textsujet.getText()+"','"+textEntreprise.getText()+"')");
		         }
		         catch(Exception ex){}
			}
		});
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Modifier", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(UIManager.getColor("Button.background"));
		panel_11.setBounds(20, 18, 531, 171);
		panel_6.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblChampsModifier = new JLabel("Champs à modifier :");
		lblChampsModifier.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblChampsModifier.setBounds(206, 39, 138, 14);
		panel_11.add(lblChampsModifier);
		
		JLabel lblNumeroModifier = new JLabel("numero à modifier :");
		lblNumeroModifier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumeroModifier.setBounds(130, 14, 138, 14);
		panel_11.add(lblNumeroModifier);
		
		txtnum = new JTextField();
		txtnum.setBounds(278, 11, 86, 20);
		panel_11.add(txtnum);
		txtnum.setColumns(10);
		
		txtid = new JTextField();
		txtid.setBounds(278, 64, 86, 20);
		panel_11.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblIdstage_1 = new JLabel("id_stage:");
		lblIdstage_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdstage_1.setBounds(206, 65, 57, 17);
		panel_11.add(lblIdstage_1);
		
		JLabel lblSujet = new JLabel("sujet :");
		lblSujet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSujet.setBounds(222, 104, 46, 20);
		panel_11.add(lblSujet);
		
		txtsjt = new JTextField();
		txtsjt.setBounds(278, 105, 86, 20);
		panel_11.add(txtsjt);
		txtsjt.setColumns(10);
		
		JButton btnValider_1 = new JButton("valider");
		btnValider_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnValider_1.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnValider_1.setBounds(278, 136, 89, 23);
		panel_11.add(btnValider_1);
		btnValider_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection cnx=cnx();
				try {
					String req="update stage set id_stage=? , sujet =?  where id_stage= '"+Integer.parseInt(txtnum.getText())+"'";
					PreparedStatement aj=cnx.prepareStatement(req);
					aj.setInt(1, (Integer.parseInt(txtid.getText())));
					aj.setString(2,(txtsjt.getText()));
					
					aj.execute();
					JOptionPane.showMessageDialog(null, "Stage modifié");
				}
					
				catch(Exception E) {
					System.out.println("Une erreur est survenue lors de la modification "+E);
					
				}
			}
		});
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Supprimer", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(UIManager.getColor("Button.background"));
		panel_12.setBounds(46, 11, 491, 172);
		panel_7.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblIdStage = new JLabel("ID stage à  supprimer:");
		lblIdStage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblIdStage.setBounds(174, 34, 160, 32);
		panel_12.add(lblIdStage);
		
		txtsup = new JTextField();
		txtsup.setBounds(174, 77, 86, 20);
		panel_12.add(txtsup);
		txtsup.setColumns(10);
		
		JButton btnNewButton = new JButton("supprimer");
		btnNewButton.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnNewButton.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		btnNewButton.setBounds(174, 108, 102, 23);
		panel_12.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
		             theQuery("delete from stage where id_stage = "+txtsup.getText());
		             
		         }
		         catch(Exception ex){
		        	 
		         }
			}
		});
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("l'étude de la demande", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 572, 90);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(UIManager.getColor("Button.background"));
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_8.setBounds(10, 104, 331, 100);
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblCoordonnesDeLa = new JLabel("Partie réponse :");
		lblCoordonnesDeLa.setBackground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		lblCoordonnesDeLa.setBounds(10, 11, 286, 20);
		panel_8.add(lblCoordonnesDeLa);
		lblCoordonnesDeLa.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		lblCoordonnesDeLa.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblIdstage_2 = new JLabel("id_stage:");
		lblIdstage_2.setBounds(10, 36, 62, 14);
		panel_8.add(lblIdstage_2);
		
		txtiid = new JTextField();
		txtiid.setBounds(60, 33, 86, 20);
		panel_8.add(txtiid);
		txtiid.setColumns(10);
		
		txtlogin = new JTextField();
		txtlogin.setBounds(60, 65, 86, 20);
		panel_8.add(txtlogin);
		txtlogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("login : ");
		lblLogin.setBounds(20, 68, 46, 14);
		panel_8.add(lblLogin);
		
		JLabel lblRponse = new JLabel("Réponse :");
		lblRponse.setBounds(169, 35, 58, 14);
		panel_8.add(lblRponse);
		lblRponse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton accord = new JRadioButton("accord");
		accord.setBackground(UIManager.getColor("Button.background"));
		accord.setBounds(152, 50, 66, 23);
		panel_8.add(accord);
		JRadioButton refus = new JRadioButton("refus");
		refus.setBackground(UIManager.getColor("Button.background"));
		refus.setBounds(152, 76, 62, 17);
		panel_8.add(refus);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnConfirmer.setBounds(224, 64, 97, 23);
		panel_8.add(btnConfirmer);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(UIManager.getColor("Button.background"));
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_9.setBounds(340, 104, 242, 100);
		panel_3.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblCoordonnesDeLa_1 = new JLabel("Coordonnées de la demande");
		lblCoordonnesDeLa_1.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		lblCoordonnesDeLa_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCoordonnesDeLa_1.setBounds(10, 11, 175, 14);
		panel_9.add(lblCoordonnesDeLa_1);
		
		JLabel lblCoordonnesDeLa_1_1 = new JLabel("à  supprimer :");
		lblCoordonnesDeLa_1_1.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		lblCoordonnesDeLa_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCoordonnesDeLa_1_1.setBounds(10, 28, 175, 14);
		panel_9.add(lblCoordonnesDeLa_1_1);
		
		JLabel lblIdstage_2_1 = new JLabel("id_stage:");
		lblIdstage_2_1.setBounds(10, 47, 62, 14);
		panel_9.add(lblIdstage_2_1);
		
		id_supp = new JTextField();
		id_supp.setColumns(10);
		id_supp.setBounds(65, 44, 46, 20);
		panel_9.add(id_supp);
		
		login_supp = new JTextField();
		login_supp.setColumns(10);
		login_supp.setBounds(65, 76, 46, 20);
		panel_9.add(login_supp);
		
		JLabel lblLogin_1 = new JLabel("login : ");
		lblLogin_1.setBounds(26, 79, 46, 14);
		panel_9.add(lblLogin_1);
		
		JButton btnSupprimer = new JButton("supprimer");
		btnSupprimer.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnSupprimer.setBounds(127, 53, 94, 23);
		panel_9.add(btnSupprimer);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	             theQuery("delete from demande where id_stage = '"+id_supp.getText()+ "'and login='"+login_supp.getText()+"'");
	             DataShow();

			}
		});
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(accord.isSelected()) {
					Connection cnx=cnx();
					try {
						String req="update demande set Reponse=?  where id_stage= '"+txtiid.getText()+"' and login='"+txtlogin.getText()+"' ";
						PreparedStatement aj=cnx.prepareStatement(req);
						
						aj.setString(1,"oui"); 
						
						aj.execute();
						JOptionPane.showMessageDialog(null, "Demande approuvée");
						DataShow();
					}
						
					catch(Exception E) {
						System.out.println("Une erreur est survenue !! "+E);
						
					}
					
				}
				else if(refus.isSelected()) {
					Connection cnx=cnx();
					try {
						String req="update demande set Reponse=?  where id_stage= '"+txtiid.getText()+"' and login='"+txtlogin.getText()+"' ";
						PreparedStatement aj=cnx.prepareStatement(req);
						
						aj.setString(1,"non"); 
						
						aj.execute();
						JOptionPane.showMessageDialog(null, "Demande non approuvée");
						DataShow();
					}
						
					catch(Exception E) {
						System.out.println("Une erreur est survenue !! "+E);
						
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Aucune case n'a été séléctionnée !!");
				}
			}
		});
		
		refus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(refus.isSelected()) {
					accord.setSelected(false);
				}
				
			}
		});
		accord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(accord.isSelected()) {
					refus.setSelected(false);
				}
				
			}
		});
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("effectuer l'inscription", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(28, 23, 256, 167);
		panel_4.add(scrollPane_2);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(UIManager.getColor("Button.background"));
		scrollPane_2.setViewportView(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("candidat");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 22, 70, 14);
		panel_13.add(lblNewLabel_2);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNom.setBounds(10, 61, 46, 14);
		panel_13.add(lblNom);
		
		JLabel lblPrenom = new JLabel("prenom:");
		lblPrenom.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblPrenom.setBounds(10, 86, 46, 14);
		panel_13.add(lblPrenom);
		
		JLabel lblIdentifiant = new JLabel("identifiant :");
		lblIdentifiant.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblIdentifiant.setBounds(10, 111, 70, 14);
		panel_13.add(lblIdentifiant);
		
		txtnom = new JTextField();
		txtnom.setBounds(78, 58, 86, 20);
		panel_13.add(txtnom);
		txtnom.setColumns(10);
		
		txtprenom = new JTextField();
		txtprenom.setBounds(78, 83, 86, 20);
		panel_13.add(txtprenom);
		txtprenom.setColumns(10);
		
		txtident = new JTextField();
		txtident.setBounds(78, 108, 86, 20);
		panel_13.add(txtident);
		txtident.setColumns(10);
		
		JButton btnEnregistrer = new JButton("enregistrer");
		btnEnregistrer.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		             theQuery("insert into etudiant values('"+Integer.parseInt(txtnom.getText())+"','"+txtprenom.getText()+"','"+txtident.getText()+"')");

		         }
		         catch(Exception ex){}
			}
		});
		btnEnregistrer.setBounds(78, 139, 102, 23);
		panel_13.add(btnEnregistrer);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(298, 23, 244, 167);
		panel_4.add(scrollPane_1);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(UIManager.getColor("Button.background"));
		scrollPane_1.setViewportView(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("stage");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel_3.setBounds(20, 11, 46, 22);
		panel_14.add(lblNewLabel_3);
		
		JLabel lblSujeDeStage = new JLabel("sujet de stage:");
		lblSujeDeStage.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSujeDeStage.setBounds(10, 58, 79, 22);
		panel_14.add(lblSujeDeStage);
		
		JLabel lblIdentifiant_1 = new JLabel("identifiant :");
		lblIdentifiant_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblIdentifiant_1.setBounds(10, 99, 79, 14);
		panel_14.add(lblIdentifiant_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 60, 86, 20);
		panel_14.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(114, 97, 86, 20);
		panel_14.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnValider_2 = new JButton("valider");
		btnValider_2.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnValider_2.setBounds(114, 128, 89, 23);
		panel_14.add(btnValider_2);
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
	          JOptionPane.showMessageDialog(null,"Requéte exécutée avec succés");
	      }catch(Exception ex){
	          JOptionPane.showMessageDialog(null,ex.getMessage());
	      }
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
	
	
	public void DataShow() {
		Connection con= cnx();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id_stage");
		model.addColumn("code étudiant");
		model.addColumn("date");
		model.addColumn("réponse");

		
		
	try {
				String query="Select * from demande";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					model.addRow(new Object[] {
					rs.getInt("id_stage"),
					rs.getString("login"),
					rs.getDate("date"),
					rs.getString("Reponse")
			} );
					
			}
				
				
		
		rs.close();
		st.close();
		con.close();
		
		table.setModel(model);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

		
		




	}
	catch (Exception e) {
		System.out.println("error: "+e);
	}

	}
	}


    
