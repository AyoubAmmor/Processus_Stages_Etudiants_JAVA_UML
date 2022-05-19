package projet_uml;

import java.awt.BorderLayout;

import java.sql.DriverManager;
import java.sql.Connection;
import java.awt.EventQueue;
import java.sql.*;
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
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;



public class MenuPrincipalProfesseur extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txt_code;
	private JTextField txt_note;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalProfesseur frame = new MenuPrincipalProfesseur();
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
	public MenuPrincipalProfesseur() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				DataShow();
			
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 395, 172);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel.setBounds(10, 0, 639, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEspaceProffesseur = new JLabel("Espace professeur");
		lblEspaceProffesseur.setFont(new Font("Javanese Text", Font.BOLD, 29));
		lblEspaceProffesseur.setBounds(211, 32, 299, 42);
		panel.add(lblEspaceProffesseur);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MenuPrincipalProfesseur.class.getResource("/images/teacher.png")));
		label.setBounds(565, 21, 64, 64);
		panel.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(new Color(204, 255, 255));
		label_2.setIcon(new ImageIcon(MenuPrincipalProfesseur.class.getResource("/images/LOGO-ENSAK-800.png")));
		label_2.setBounds(10, 11, 152, 85);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBounds(432, 107, 217, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAssignerUnNote = new JLabel("Assigner ou modifier une");
		lblAssignerUnNote.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		lblAssignerUnNote.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAssignerUnNote.setBounds(10, 11, 207, 22);
		panel_1.add(lblAssignerUnNote);
		
		JLabel lblCodeDuRapport = new JLabel("Code du rapport :");
		lblCodeDuRapport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodeDuRapport.setBounds(10, 75, 128, 20);
		panel_1.add(lblCodeDuRapport);
		
		txt_code = new JTextField();
		txt_code.setBounds(137, 77, 70, 20);
		panel_1.add(txt_code);
		txt_code.setColumns(10);
		
		JButton btn_valider = new JButton("Valider");
		btn_valider.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btn_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection cnx=cnx();
				try {
					String req="update rapport set note=?  where id_rapport= '"+Integer.parseInt(txt_code.getText())+"'";
					PreparedStatement aj=cnx.prepareStatement(req);
					aj.setInt(1, (Integer.parseInt(txt_note.getText())));
		
					aj.execute();
					JOptionPane.showMessageDialog(null, "note assignée");
					DataShow();
				}
					
				catch(Exception E) {
					System.out.println("Une erreur est survenue ! "+E);
				}
			}
		});
		btn_valider.setBounds(69, 138, 89, 23);
		panel_1.add(btn_valider);
		
		JLabel lblNote = new JLabel("Note :");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNote.setBounds(83, 108, 46, 14);
		panel_1.add(lblNote);
		
		txt_note = new JTextField();
		txt_note.setColumns(10);
		txt_note.setBounds(137, 107, 70, 20);
		panel_1.add(txt_note);
		
		JLabel lblUneNote = new JLabel("une note :");
		lblUneNote.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		lblUneNote.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUneNote.setBounds(10, 30, 197, 22);
		panel_1.add(lblUneNote);
		
		JButton btnConfirmer = new JButton("S\u00E9l\u00E9ctionner un rapport");
		btnConfirmer.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnConfirmer.setBounds(147, 299, 168, 23);
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser selecteur=new JFileChooser();
				selecteur.setDialogTitle("Choisir un fichier");
				selecteur.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int resultat = selecteur.showDialog(btnConfirmer,"OK");
				
				if (resultat==JFileChooser.APPROVE_OPTION) {
					File fichier = selecteur.getSelectedFile();
					try {
						Desktop.getDesktop().open(fichier);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		contentPane.add(btnConfirmer);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MenuPrincipalProfesseur.class.getResource("/images/pdf.png")));
		label_1.setBounds(105, 290, 32, 32);
		contentPane.add(label_1);
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
	model.addColumn("code rapport");
	model.addColumn("titre rapport");
	model.addColumn("code de l'étudiant");
	model.addColumn("note");
	
	
try {
			String query="Select * from rapport";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
				rs.getInt("id_rapport"),
				rs.getString("titre_rapport"),
				rs.getString("login"),
				rs.getInt("note")
		} );
				
		}
			
			
	
	rs.close();
	st.close();
	con.close();
	
	table.setModel(model);
	table.setAutoResizeMode(0);
	table.getColumnModel().getColumn(0).setPreferredWidth(100);
	table.getColumnModel().getColumn(1).setPreferredWidth(100);
	table.getColumnModel().getColumn(2).setPreferredWidth(150);
	table.getColumnModel().getColumn(3).setPreferredWidth(90);
	table.getColumnModel().getColumn(3).setPreferredWidth(40);




}
catch (Exception e) {
	System.out.println("error: "+e);
}

}
}

