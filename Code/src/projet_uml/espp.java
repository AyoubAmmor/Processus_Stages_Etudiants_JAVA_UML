package projet_uml;


import java.awt.BorderLayout;
import java.awt.EventQueue;
//import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.UIManager;

public class espp extends JFrame {

	private JPanel contentPane;
	private JTextField titrerapport;
	private JTextField txtNometud;
	private JTextField txtClSu;
	private JTable table;
	private JTable table_1;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					espp frame = new espp();
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
	public espp() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 93, 687, 236);
		contentPane.add(tabbedPane);
		/*btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		             theQuery("insert into client values('"+Integer.parseInt(txtNum.getText())+"','"+txtNom.getText()+"','"+txtPrenom.getText()+"','"+Integer.parseInt(txtTel.getText())+"','"+txtAdresse.getText()+"')");
		         }
		         catch(Exception ex){}
		         }
				
				
			
		
		});*/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Déposer un rapport", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNom = new JLabel("Titre de rapport :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(183, 29, 113, 14);
		panel_1.add(lblNom);
		
		titrerapport = new JTextField();
		titrerapport.setBounds(310, 27, 183, 20);
		panel_1.add(titrerapport);
		titrerapport.setColumns(10);
		
		JLabel lblNom_1 = new JLabel("Code d'\u00E9tudiant :");
		lblNom_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom_1.setBounds(183, 71, 113, 14);
		panel_1.add(lblNom_1);
		
		txtNometud = new JTextField();
		txtNometud.setBounds(310, 69, 183, 20);
		panel_1.add(txtNometud);
		txtNometud.setColumns(10);
		
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(espp.class.getResource("/images/pdf (2).png")));
			lblNewLabel.setBounds(20, 36, 128, 129);
			panel_1.add(lblNewLabel);
			
			JButton btnNewButton_1 = new JButton("Valider\r\n");
			btnNewButton_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			btnNewButton_1.setForeground(new Color(0, 0, 0));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
			             theQuery("insert into rapport(titre_rapport,login) values('"+titrerapport.getText()+"','"+txtNometud.getText()+"')");
			         }
			         catch(Exception ex){}
				}
				
			});
			btnNewButton_1.setBounds(462, 110, 89, 29);
			panel_1.add(btnNewButton_1);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(espp.class.getResource("/images/pdf.png")));
			label.setBounds(183, 96, 32, 51);
			panel_1.add(label);
			
			JButton btnSlectionnerLeFichier = new JButton("S\u00E9lectionner le fichier \u00E0 d\u00E9poser");
			btnSlectionnerLeFichier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser selecteur=new JFileChooser();
					selecteur.setDialogTitle("Choisir un fichier");
					selecteur.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int resultat = selecteur.showDialog(btnSlectionnerLeFichier,"OK");
					
			
				}
			});
			btnSlectionnerLeFichier.setBounds(225, 113, 227, 23);
			panel_1.add(btnSlectionnerLeFichier);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Consulter liste de stages", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 338, 186);
		panel_2.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Instruire une demande de stage");
		btnNewButton.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demande dm = new demande();
				dm.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(385, 156, 203, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(espp.class.getResource("/images/contact-form.png")));
		lblNewLabel_1.setBounds(438, 17, 128, 128);
		panel_2.add(lblNewLabel_1);
			
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			panel.setBounds(0, 0, 616, 329);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setIcon(new ImageIcon(espp.class.getResource("/images/student-with-graduation-cap.png")));
			lblNewLabel_1_1.setBounds(527, 11, 89, 90);
			panel.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_2_1 = new JLabel("Espace Etudiant\r\n");
			lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
			lblNewLabel_2_1.setBounds(195, 30, 334, 54);
			panel.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(26, 11, 138, 81);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setIcon(new ImageIcon(espp.class.getResource("/images/LOGO-ENSAK-800.png")));
		
		
		
		
	
		
		
		
	
	
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
		private void ShowData() {
			Connection con = cnx();
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("code");
			model.addColumn("sujet");
			model.addColumn("entreprise");
			try {
				String query=" select *  from stage";
			       Statement st =con.createStatement();
			    ResultSet rs=st.executeQuery(query);
			   while (rs.next())
					   {
						   model.addRow(new Object[] {
								   rs.getString("id_stage"),
								   rs.getString("sujet"),
								   rs.getString("entreprise")
						   }
								   
								   );
						   
						   
				   
			   }
					   rs.close();
					   st.close();
					   con.close();
					   table_1.setModel(model);
					   table_1.setAutoResizeMode(0);
					   table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
					   table_1.getColumnModel().getColumn(1).setPreferredWidth(120);
					   table_1.getColumnModel().getColumn(2).setPreferredWidth(180);
					   
					   
			}catch(Exception e){
				
				System.out.println("error:"+e);
			}
			
		
	}
}
	