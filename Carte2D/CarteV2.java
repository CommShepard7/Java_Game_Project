package Carte2D;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import Actions.ActionAvalerRessource;
import Actions.ActionLacherRessource;
import Actions.ActionRamasserRessource;
import Jeu.Jeu;
import Joueur.Joueur;
import Missions.Mission;
import Objets.Allumette;
import Objets.Chevre;
import Objets.Feu;
import Objets.Lit;
import Objets.NoixDeCoco;
import Objets.Objet;
import Objets.Objets;
import Objets.Pomme;
import Objets.Ressource;
import Objets.Ressources;
import SignauxVitaux.Faim;
import SignauxVitaux.Fatigue;
import SignauxVitaux.SignalVital;
import SignauxVitaux.Signes;
import SignauxVitaux.Soif;

/**
 *
 * @author Shepard
 */
public class CarteV2 extends JFrame {

	private JInternalFrame jFrameInventaire;
	private JInternalFrame jFrameConstruire;
	private JLabel jLabelMap;
	private JLabel jLabelJoueur;
	private JPanel jPanelJoueurs;
	private JPanel jPanelObjets;
	private JInternalFrame jPanelMissions;
	private JProgressBar jProgressBarFaim;
	private JProgressBar jProgressBarSoif;
	private JProgressBar jProgressBarEnergie;
	private JTextField jTextFieldMission1;
	private JTextField jTextFieldMission2;
	private JTextField jTextFieldMission3;
	private JTextField jTextFieldMission4;
	private JTextField jTextFieldMission5;
	private JTextField jTextFieldMission6;
	private JTextField jTextFieldMission7;
	private JTextField jTextFieldInventaire;
	private JTextField jTextFieldConstruire;
	private JButton jButtonManger;
	private JButton jButtonLacher;
	private JButton jButtonUtiliser;
	private JButton jButtonConstruire;
	private JPanel jPanelInventaire;
	private JPanel jPanelConstruire;
	private JPanel jPanelSignesVitaux;
	private JLabel selectedItem;
	private JLabel jLabelConstruire;
	private JLabel jLabelConstruireLit;

	private Jeu jeu;

	private List<Objet> objets;

	private List<Objets> objetsInventaire = new ArrayList<Objets>();

	private List<Ressource> ressources;

	private List<Ressources> ressourcesInventaire = new ArrayList<Ressources>();

	private List<Mission> missions;

	private List<JLabel> joueursLabels = new ArrayList<JLabel>();

	private List<JLabel> objetsLabels = new ArrayList<JLabel>();

	private List<JLabel> ressourcesLabels = new ArrayList<JLabel>();

	private List<Joueur> joueurs;

	private int labelNumRessources;
	private int labelNumObjets;

	public CarteV2(Jeu jeu) {

		this.jeu = jeu;

		this.objets = jeu.carte.getObjets();

		this.ressources = jeu.carte.getRessources();

		this.missions = jeu.getMissions();

		initComponents();

		this.labelNumRessources = 0;

		this.labelNumObjets = 0;

		// setUndecorated(true);
		// GraphicsEnvironment graphics =
		// GraphicsEnvironment.getLocalGraphicsEnvironment();
		// GraphicsDevice device = graphics.getDefaultScreenDevice();
		// device.setFullScreenWindow(this);

		// jLabel2.setVisible(false);
		// jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
		// jLabel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

		// setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	private void initComponents() {

		jProgressBarFaim = new JProgressBar();
		jProgressBarSoif = new JProgressBar();
		jProgressBarEnergie = new JProgressBar();
		jPanelMissions = new JInternalFrame();
		jPanelJoueurs = new JPanel();
		jLabelJoueur = new JLabel();
		jPanelObjets = new JPanel();
		jLabelMap = new JLabel();
		jTextFieldMission1 = new JTextField();
		jTextFieldMission2 = new JTextField();
		jTextFieldMission3 = new JTextField();
		jTextFieldMission4 = new JTextField();
		jTextFieldMission5 = new JTextField();
		jTextFieldMission6 = new JTextField();
		jTextFieldMission7 = new JTextField();
		jTextFieldInventaire = new JTextField("Selected : ");
		jFrameInventaire = new JInternalFrame();
		jPanelInventaire = new JPanel();

		jFrameConstruire = new JInternalFrame();
		jPanelConstruire = new JPanel();
		jTextFieldConstruire = new JTextField("Liste des objets à construire: ");
		jLabelConstruire.setIcon(new ImageIcon(getClass().getResource("/Media/lit.png")));
		// jPanelConstruire.setLayout(new GridLayout(0, 2));
		// jPanelConstruire.setBounds(450, 550, 140, 360);
		// jPanelConstruire.setVisible(false);
		jPanelConstruire.add(jTextFieldConstruire);
		jPanelConstruire.add(jLabelConstruire);
		getContentPane().add(jPanelConstruire);

		jPanelSignesVitaux = new JPanel();
		jButtonManger = new JButton("Manger");
		jButtonUtiliser = new JButton("Utiliser");
		jButtonConstruire = new JButton("Construire");

		jPanelJoueurs.setOpaque(false);
		jPanelJoueurs.setLayout(null);

		jPanelInventaire.setLayout(new GridLayout(5, 0));
		jPanelSignesVitaux.setLayout(new GridLayout(3, 2));
		getContentPane().add(jPanelInventaire);
		getContentPane().add(jPanelSignesVitaux);
		jPanelInventaire.setBounds(450, 550, 140, 360);
		jPanelSignesVitaux.setBounds(1650, 550, 140, 360);
		jPanelInventaire.setVisible(false);
		jPanelInventaire.add(jTextFieldInventaire);
		jTextFieldInventaire.setEditable(false);
		jPanelInventaire.add(jButtonManger);
		jPanelInventaire.add(jButtonUtiliser);
		jPanelInventaire.add(jButtonConstruire);
		jButtonManger.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				boutonMangerClicked(evt);
			}

		});

		jButtonUtiliser.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				boutonUtiliserClicked(evt);
			}

		});

		jButtonManger.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				boutonMangerClicked(evt);
			}

		});

		jButtonConstruire.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				boutonConstruireClicked(evt);
			}

		});

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMaximumSize(new Dimension(1280, 1024));
		setPreferredSize(new Dimension(1280, 1024));
		setResizable(false);
		getContentPane().setLayout(null);
		jLabelMap.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelMap.setIcon(new ImageIcon(getClass().getResource("/Media/carte.png")));
		jLabelMap.setText("Map");
		jLabelMap.setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));
		joueurs = this.jeu.getJoueurs();

		for (Joueur joueur : joueurs) {

			joueursLabels.add(new javax.swing.JLabel());
			joueursLabels.get(0).setBounds(10, 0, 50, 140);
			joueursLabels.get(0).setIcon(joueurIcon(joueur.getNom()));
			jPanelJoueurs.add(joueursLabels.get(0));
			joueursLabels.get(0).setHorizontalAlignment(SwingConstants.CENTER);
			joueursLabels.get(0).addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					joueurMouseClicked(evt);
				}
			});
			joueursLabels.get(0).addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent evt) {
					joueurKeyPressed(evt);
				}
			});
			joueursLabels.get(0).addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent evt) {
					joueurFocusGained(evt);
				}

				@Override
				public void focusLost(FocusEvent evt) {
					joueurFocusLost(evt);
				}
			});
		}

		for (Objet objet : this.objets) {
			objetsLabels.add(new JLabel(String.valueOf(this.labelNumObjets)));
			setLabelObjet(objetsLabels.get(this.labelNumObjets), objet, objet.getPosition());
			jPanelObjets.add(objetsLabels.get(this.labelNumObjets));
			objetsLabels.get(this.labelNumObjets).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) {
					objetMouseClicked(evt);
				}
			});
			this.labelNumObjets++;
		}

		for (Ressource ressource : this.ressources) {
			ajouterRessource(ressource, ressource.getPosition());
		}

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMaximumSize(new Dimension(1920, 1080));
		setPreferredSize(new Dimension(1920, 1080));
		setResizable(false);
		getContentPane().setLayout(null);

		getContentPane().add(jFrameConstruire);
		jFrameConstruire.setBounds(30, 100, 420, 360);

		getContentPane().add(jFrameInventaire);
		jFrameInventaire.setBounds(30, 550, 420, 360);

		jPanelMissions.setVisible(true);
		getContentPane().add(jPanelMissions);
		jPanelMissions.setBounds(1480, 30, 410, 340);

		jPanelMissions.setLayout(new GridLayout(0, 1));

		int numero_mission = 1;
		for (Mission mission : this.missions) {
			JTextField missionText = new JTextField("Quest " + numero_mission + ": " + mission.getNom());
			missionText.setEditable(false);
			jPanelMissions.add(missionText);
			numero_mission++;
		}

		jPanelJoueurs.setBounds(900, 430, 60, 140);
		getContentPane().add(jPanelJoueurs);

		jPanelObjets.add(jLabelMap);
		jLabelMap.setBounds(0, 0, 9638, 5400);

		getContentPane().add(jPanelObjets);
		jPanelObjets.setBounds(-4280, -3020, 9638, 5400);

		// SIGNES VITAUX
		SignalVital faim = joueurs.get(0).getSignauxVitaux().get(Signes.FAIM.ordinal());
		SignalVital fatigue = joueurs.get(0).getSignauxVitaux().get(Signes.FATIGUE.ordinal());
		SignalVital soif = joueurs.get(0).getSignauxVitaux().get(Signes.SOIF.ordinal());

		jProgressBarFaim.setForeground(faim.getCouleur());
		jProgressBarFaim.setValue((int) faim.getJauge());
//		jProgressBarFaim.setString(faim.getNom() +  " " + faim.getJauge() + "%");
		jProgressBarFaim.setStringPainted(true);
		jProgressBarFaim.setVisible(true);

		jProgressBarSoif.setForeground(soif.getCouleur());
		jProgressBarSoif.setValue((int) soif.getJauge());
//		jProgressBarSoif.setString(soif.getNom() +  " " + soif.getJauge() + "%");
		jProgressBarSoif.setStringPainted(true);
		jProgressBarSoif.setVisible(true);

		jProgressBarEnergie.setForeground(fatigue.getCouleur());
		jProgressBarEnergie.setValue((int) fatigue.getJauge());
//		jProgressBarEnergie.setString(fatigue.getNom() +  " " + fatigue.getJauge() + "%");
		jProgressBarEnergie.setStringPainted(true);
		jProgressBarEnergie.setVisible(true);

		jPanelSignesVitaux.add(new JLabel(fatigue.getNom()));
		jPanelSignesVitaux.add(jProgressBarEnergie);
		jPanelSignesVitaux.add(new JLabel(faim.getNom()));
		jPanelSignesVitaux.add(jProgressBarFaim);
		jPanelSignesVitaux.add(new JLabel(soif.getNom()));
		jPanelSignesVitaux.add(jProgressBarSoif);

		jFrameInventaire.setVisible(false);
		jFrameInventaire.getContentPane().setLayout(new GridLayout(2, 0));

		jFrameConstruire.setVisible(false);
		jFrameConstruire.getContentPane().setLayout(new GridLayout(3, 0));
		jTextFieldConstruire.setEditable(false);
		jFrameConstruire.add(jTextFieldConstruire);

		jPanelObjets.setPreferredSize(new Dimension(9638, 5400));

		jPanelObjets.setLayout(null);

		jLabelMap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent evt) {
				jLabelMapFocusGained(evt);
			}
		});
		jLabelMap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				jLabelMapMouseClicked(evt);
			}
		});

		pack();
	}

	private void joueurFocusGained(FocusEvent evt) {
		System.out.println("PLAYER FOCUS GAINED");

	}

	private void joueurFocusLost(FocusEvent evt) {
		System.out.println("PLAYER FOCUS LOST");

	}
	
	private void majSignesVitaux() {
		SignalVital faim = joueurs.get(0).getSignauxVitaux().get(Signes.FAIM.ordinal());
		SignalVital fatigue = joueurs.get(0).getSignauxVitaux().get(Signes.FATIGUE.ordinal());
		SignalVital soif = joueurs.get(0).getSignauxVitaux().get(Signes.SOIF.ordinal());
		jProgressBarFaim.setValue((int) faim.getJauge());
		jProgressBarEnergie.setValue((int) fatigue.getJauge());
		jProgressBarSoif.setValue((int) soif.getJauge());
	}

	private void jLabelMapFocusGained(FocusEvent evt) {
		System.out.println("MAP FOCUS GAINED");
	}

	private void jLabelMapMouseClicked(MouseEvent evt) {
		jLabelMap.requestFocusInWindow();
	}

	private void joueurMouseClicked(MouseEvent evt) {
		joueursLabels.get(0).requestFocusInWindow();
	}

	private void ressourceMouseClicked(MouseEvent evt) {
		JLabel clickedRessource = (JLabel) evt.getComponent();
		joueursLabels.get(0).requestFocusInWindow();
		if (!(evt.getComponent().getParent() == jFrameInventaire) && SwingUtilities.isLeftMouseButton(evt)) {
			// if (jPanelJoueurs.getLocation().distance(evt.getComponent().getLocation()) <=
			// 150){ //A faire avec aProximite()
			// System.out.println(Integer.parseInt(clickedRessource.getText()));
			updateLabels("ressources", 0);
			int ind = Integer.parseInt(clickedRessource.getText());
			Ressources ressourceInventaire = ressources.get(Integer.parseInt(clickedRessource.getText())).getNom();
			joueurs.get(0).faireAction(new ActionRamasserRessource(" ", 1, ressourceInventaire),
					new String[] { clickedRessource.getText() });
			ressourcesInventaire.add(ressourceInventaire);
			evt.getComponent().setVisible(false);
			JLabel ressourceLabel = new JLabel(ressourceInventaire.toString());
			ressourceLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) {
					ressourceInventaireMouseClicked(evt);
				}
			});

			setLabelRessource(ressourceLabel, null, new Point(0, 0));
			jFrameInventaire.add(ressourceLabel);
			ressourcesLabels.remove(Integer.parseInt(clickedRessource.getText()));
		}
	}

	private void ressourceInventaireMouseClicked(MouseEvent evt) {

		if (SwingUtilities.isLeftMouseButton(evt)) {
			JLabel ressourceInventaire = (JLabel) evt.getComponent();
			ressourceInventaire.requestFocus();
			jTextFieldInventaire.setText("Selected : " + ressourceInventaire.getText());
			this.selectedItem = ressourceInventaire;
		}
		if (SwingUtilities.isRightMouseButton(evt)) {
			JLabel clickedRessource = (JLabel) evt.getComponent();
			joueurs.get(0).faireAction(
					new ActionLacherRessource(" ", 1, Ressources.valueOf(clickedRessource.getText())),
					new String[] { clickedRessource.getText() });
			JLabel ressourceDrop = new JLabel(clickedRessource.getText());
			ressourceDrop.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) {
					ressourceMouseClicked(evt);
				}

			});
			Point position = new Point(jPanelJoueurs.getX() + 50 - jPanelObjets.getX(),
					jPanelJoueurs.getY() + 50 - jPanelObjets.getY());
			setLabelRessource(ressourceDrop, null, position);
			ressourcesLabels.add(ressourceDrop);
			updateLabels("ressources", 0);
			evt.getComponent().setVisible(false);
			jFrameInventaire.remove(evt.getComponent());
			ressourceDrop.setVisible(true);
			jLabelMap.add(ressourceDrop);
			// jPanelObjets.setBounds(jPanelObjets.getX()+1, jPanelObjets.getY(), 9638,
			// 5400);
			jPanelObjets.setBounds(jPanelObjets.getX() + 1, jPanelObjets.getY() - 1, 9638, 5400);

		}

	}

	private void boutonMangerClicked(MouseEvent evt) {

		try {
			if (this.selectedItem.getParent() != jPanelJoueurs && this.selectedItem != null) {
				JLabel labelRessource = this.selectedItem;
				if (Ressource.isRessource(labelRessource.getText())) { // on vérifie que c'est bien une ressource
					joueurs.get(0).faireAction(
							new ActionAvalerRessource(" ", 1, Ressources.valueOf(labelRessource.getText())), null);
					updateLabels("ressources", 0);
					ressourcesInventaire.remove(Ressources.valueOf(labelRessource.getText()));
					jFrameInventaire.remove(this.getFocusOwner());
					this.selectedItem.setVisible(false);
					jFrameInventaire.remove(this.selectedItem);

					this.selectedItem = null;
					majSignesVitaux();
				} else {
					System.out.println("Un objet ne se mange pas.");
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Il faut selectionner une ressource ou un objet.");
		}

	}

	private void boutonUtiliserClicked(MouseEvent evt) {

		try {
			if (this.selectedItem.getParent() != jPanelJoueurs && this.selectedItem != null) {
				JLabel labelObjet = this.selectedItem;
				if (Objet.isObjet(labelObjet.getText())) { // on verifie que c'est bien un objet
					joueurs.get(0).faireAction(
							new ActionAvalerRessource(" ", 1, Ressources.valueOf(labelObjet.getText())), null);
					ressourcesInventaire.remove(Ressources.valueOf(labelObjet.getText()));
					jFrameInventaire.remove(this.getFocusOwner());
					this.selectedItem.setVisible(false);
					jFrameInventaire.remove(this.selectedItem);
					this.selectedItem = null;
				} else {
					System.out.println("Une ressource ne peut pas être utilisée.");
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Il faut selectionner une ressource ou un objet.");
		}

	}

	private void boutonConstruireClicked(MouseEvent evt) {
		if (!jFrameConstruire.isVisible()) {
			jFrameConstruire.setVisible(true);
		} else {
			jFrameConstruire.setVisible(false);
		}
	}

	private void objetMouseClicked(MouseEvent evt) {

	}

	private void joueurKeyPressed(KeyEvent evt) {
		
		SignalVital faim = joueurs.get(0).getSignauxVitaux().get(Signes.FAIM.ordinal());
		SignalVital fatigue = joueurs.get(0).getSignauxVitaux().get(Signes.FATIGUE.ordinal());
		SignalVital soif = joueurs.get(0).getSignauxVitaux().get(Signes.SOIF.ordinal());

		if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (jPanelObjets.getX() != -7800) {
				System.out.println("Moving right");
				jPanelObjets.setBounds(jPanelObjets.getX() - 20, jPanelObjets.getY(), 9638, 5400);
				
			}
			// joueursLabels.get(0).setBounds(joueurs.get(0).getPosition()[0] + 2,
			// joueurs.get(0).getPosition()[1], 70, 60);
		} else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
			if (jPanelObjets.getY() != -4400) {
				System.out.println("Moving down");
				jPanelObjets.setBounds(jPanelObjets.getX(), jPanelObjets.getY() - 20, 9638, 5400);
				System.out.println(jPanelObjets.getX() + " " + jPanelObjets.getY());
			}
			// joueursLabels.get(0).setBounds(joueurs.get(0).getPosition()[0],
			// joueurs.get(0).getPosition()[1] - 2, 70, 60);
		} else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
			if (jPanelObjets.getX() != 0) {
				System.out.println("Moving left");
				jPanelObjets.setBounds(jPanelObjets.getX() + 20, jPanelObjets.getY(), 9638, 5400);
			}
			// joueursLabels.get(0).setBounds(joueurs.get(0).getPosition()[0] - 2,
			// joueurs.get(0).getPosition()[1], 70, 60);
		} else if (evt.getKeyCode() == KeyEvent.VK_UP) {
			if (jPanelObjets.getY() != 0) {
				System.out.println("Moving up");
				jPanelObjets.setBounds(jPanelObjets.getX(), jPanelObjets.getY() + 20, 9638, 5400);
			}

			// joueursLabels.get(0).setBounds(joueurs.get(0).getPosition()[0],
			// joueurs.get(0).getPosition()[1] + 2, 70, 60);
		} else if (evt.getKeyCode() == KeyEvent.VK_I) {

			if (!jFrameInventaire.isVisible()) {
				jFrameInventaire.setVisible(true);
				jPanelInventaire.setVisible(true);
			} else {
				jFrameInventaire.setVisible(false);
				jPanelInventaire.setVisible(false);
			}

		} else if (evt.getKeyCode() == KeyEvent.VK_M) {

			if (!jPanelMissions.isVisible()) {
				jPanelMissions.setVisible(true);
			} else {
				jPanelMissions.setVisible(false);
			}
		}
		fatigue.majJauge(-0.1);
		faim.majJauge(-0.01);
		soif.majJauge(-0.01);
		majSignesVitaux();

		

		// jProgressBarFatigue.setString("ENERGY " +
		// joueurs.get(0).getSignauxVitaux().get(1).getJauge() + " %");

	}

	private Icon joueurIcon(String nom) {

		return new ImageIcon(getClass().getResource("/Media/obiwan.png"));

	}

	private void setLabelObjet(JLabel label, Objet objet, Point position) {

		if (objet instanceof Lit) {
			label.setBounds((int) position.getX(), (int) position.getY(), 190, 120);
			label.setIcon(new ImageIcon(getClass().getResource("/Media/lit.png")));

		} else if (objet instanceof Feu) {
			if (Feu.estAllume((Feu) objet)) {
				label.setBounds((int) position.getX(), (int) position.getY(), 100, 140);
				label.setIcon(new ImageIcon(getClass().getResource("/Media/feu.png")));
			} else {
				label.setBounds((int) position.getX(), (int) position.getY(), 190, 170);
				label.setIcon(new ImageIcon(getClass().getResource("/Media/feu_eteint.png")));
			}

		} else if (objet instanceof Allumette) {
			label.setBounds((int) position.getX(), (int) position.getY(), 20, 30);
			label.setIcon(new ImageIcon(getClass().getResource("/Media/allumette.png")));
		}

	}

	private void setLabelRessource(JLabel label, Ressource ressource, Point position) {

		if (ressource instanceof Pomme || label.getText().equals("POMME")) {

			label.setBounds((int) position.getX(), (int) position.getY(), 24, 24);

			label.setIcon(new ImageIcon(getClass().getResource("/Media/pomme.png")));

		} else if (ressource instanceof NoixDeCoco || label.getText().equals("NOIX_DE_COCO")) {
			label.setBounds((int) position.getX(), (int) position.getY(), 50, 50);
			label.setIcon(new ImageIcon(getClass().getResource("/Media/coconut.png")));

		} else if (ressource instanceof Chevre || label.getText().equals("CHEVRE")) {
			label.setBounds((int) position.getX(), (int) position.getY(), 80, 80);
			label.setIcon(new ImageIcon(getClass().getResource("/Media/chevre.png")));

		}

	}

	public void updateLabels(String select, int ind) {

		if (select.equals("ressources")) {

			for (int k = 0; k < this.ressources.size(); k++) {

				ressourcesLabels.get(k).setText(String.valueOf(k));
			}

		} else if (select.equals("objets")) {

			for (int k = 0; k < this.objets.size(); k++) {

				ressourcesLabels.get(k).setText(String.valueOf(k));
			}
		}

	}

	private static void music() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
					new File("C:\\Users\\Rider\\Documents\\NetBeansProjects\\CarteGrid\\src\\main\\java\\skyrim.wav")
							.getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public void launch() {

		this.setVisible(true);
		// music();

	}

	private void ajouterRessource(Ressource ressource, Point position) {
		this.ressourcesLabels.add(new JLabel(String.valueOf(this.labelNumRessources)));
		setLabelRessource(ressourcesLabels.get(this.labelNumRessources), ressource, position);

		jPanelObjets.add(ressourcesLabels.get(this.labelNumRessources));
		this.ressourcesLabels.get(this.labelNumRessources).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				ressourceMouseClicked(evt);
			}
		});
		this.labelNumRessources++;
	}

}