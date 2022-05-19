package projet_uml;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MENU extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENU frame = new MENU();
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
	public MENU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 400);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(51, 0, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		paneMenu.setBounds(0, 0, 769, 159);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MENU.class.getResource("/images/kh.png")));
		label.setBounds(237, 0, 286, 161);
		paneMenu.add(label);
		
		JPanel panelEtudiant = new JPanel();
		panelEtudiant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				connexion_etudiant ce=new connexion_etudiant();
				ce.setVisible(true);
			}
		});
		
		panelEtudiant.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelEtudiant.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panelEtudiant.setBounds(10, 230, 226, 70);
		contentPane.add(panelEtudiant);
		panelEtudiant.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ETUDIANT");
		lblNewLabel.setFont(new Font("Javanese Text", Font.BOLD, 20));
		lblNewLabel.setBounds(78, 22, 127, 37);
		panelEtudiant.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MENU.class.getResource("/images/student-with-graduation-cap.png")));
		label_1.setBounds(10, 0, 64, 70);
		panelEtudiant.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
		
			
			public void mouseClicked(MouseEvent e) {
				connexion_responsable cp=new connexion_responsable();
				cp.setVisible(true);
				
			
			}
		});
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel_1.setBounds(263, 230, 235, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblResponsable = new JLabel("RESPONSABLE");
		lblResponsable.setBounds(69, 24, 156, 35);
		panel_1.add(lblResponsable);
		lblResponsable.setFont(new Font("Javanese Text", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 11, 65, 59);
		panel_1.add(label_3);
		label_3.setIcon(new ImageIcon(MENU.class.getResource("/images/responsibility.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				connexion_professeur cr=new connexion_professeur();
				cr.setVisible(true);
				
			}
		});
		
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_2.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel_2.setBounds(518, 230, 241, 70);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblProfesseur = new JLabel("PROFESSEUR");
		lblProfesseur.setBounds(85, 22, 151, 37);
		panel_2.add(lblProfesseur);
		lblProfesseur.setFont(new Font("Javanese Text", Font.BOLD, 21));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(10, 0, 64, 70);
		panel_2.add(label_2);
		label_2.setIcon(new ImageIcon(MENU.class.getResource("/images/teacher.png")));
	}
}
