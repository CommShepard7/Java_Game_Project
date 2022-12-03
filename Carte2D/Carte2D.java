package Carte2D;

import Jeu.*;
import Actions.*;
import Objets.*;
import Joueur.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JFrame;

/**
 *
 * @author Shepard
 */
@SuppressWarnings("serial")
public class Carte2D extends JFrame {

	private Jeu jeu;

	private List<Objet> objets;

	private List<Ressource> ressources;

	private List<javax.swing.JLabel> joueursLabels = new ArrayList<javax.swing.JLabel>();
	private List<javax.swing.JLabel> objetsLabels = new ArrayList<javax.swing.JLabel>();
	private List<javax.swing.JLabel> ressourcesLabels = new ArrayList<javax.swing.JLabel>();
	private List<Joueur> joueurs;

	@SuppressWarnings("static-access")
	public Carte2D(Jeu jeu) {

		this.jeu = jeu;

		this.objets = jeu.carte.getObjets();

		this.ressources = jeu.carte.getRessources();

		initComponents();

		jInternalFrameInventaire.setVisible(false);

		// setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	private void initComponents() {

		int labelNumObjets = 0;
		int labelNumRessources = 0;

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMaximumSize(new java.awt.Dimension(1280, 1024));
		setPreferredSize(new java.awt.Dimension(1280, 1024));
		setResizable(false);
		getContentPane().setLayout(null);

		joueurs = this.jeu.getJoueurs();
		jPanelPrincipal = new javax.swing.JPanel();

		for (Joueur joueur : joueurs) {

			joueursLabels.add(new javax.swing.JLabel());
			joueursLabels.get(0).setBounds(400, 500, 50, 50);
			joueursLabels.get(0).setIcon(joueurIcon(joueur.getNom()));
			jPanelPrincipal.add(joueursLabels.get(0));
			joueursLabels.get(0).addMouseListener(new java.awt.event.MouseAdapter() {

				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					joueurMouseClicked(evt);
				}
			});
			joueursLabels.get(0).addKeyListener(new java.awt.event.KeyAdapter() {
				@Override
				public void keyPressed(java.awt.event.KeyEvent evt) {
					joueurKeyPressed(evt);
				}
			});
			joueursLabels.get(0).addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusGained(java.awt.event.FocusEvent evt) {
					joueurFocusGained(evt);
				}

				@Override
				public void focusLost(java.awt.event.FocusEvent evt) {
					joueurFocusLost(evt);
				}
			});
		}

		for (Objet objet : objets) {
			objetsLabels.add(new javax.swing.JLabel(String.valueOf(labelNumObjets)));
			objetsLabels.get(labelNumObjets).setBounds((int) objet.getPosition().getX(),
					(int) objet.getPosition().getY(), 20, 20);
			objetsLabels.get(labelNumObjets).setIcon(objetIcon(objet));
			jPanelPrincipal.add(objetsLabels.get(labelNumObjets));
			objetsLabels.get(labelNumObjets).addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					objetMouseClicked(evt);
				}
			});
			labelNumObjets++;
		}

		for (Ressource ressource : ressources) {
			ressourcesLabels.add(new javax.swing.JLabel(String.valueOf(labelNumRessources)));
			ressourcesLabels.get(labelNumRessources).setBounds((int) ressource.getPosition().getX(),
					(int) ressource.getPosition().getY(), 20, 20);
			// objetsLabels.get(labelNumRessources).setVisible(true);
			ressourcesLabels.get(labelNumRessources).setIcon(ressourceIcon(ressource));
			jPanelPrincipal.add(ressourcesLabels.get(labelNumRessources));
			// ressourcesLabels.get(labelNumRessources).setVisible(false);
			ressourcesLabels.get(labelNumRessources).addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent evt) {
					ressourceMouseClicked(evt);
				}
			});
			labelNumRessources++;
		}

		jPanelInventaire = new javax.swing.JPanel();
		jPanelPrincipal.setBackground(new java.awt.Color(0, 0, 0));
		jPanelPrincipal.setOpaque(false);
		jPanelPrincipal.setLayout(null);

		jLabelCarte = new javax.swing.JLabel();

		jProgressBarFatigue = new javax.swing.JProgressBar();
		jProgressBarFaim = new javax.swing.JProgressBar();
		jInternalFrameInventaire = new javax.swing.JInternalFrame();
		jButtonQuitterInventaire = new javax.swing.JButton();

		jPanelPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				jPanel3MouseMoved(evt);
			}
		});
		jPanelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jPanel3MouseClicked(evt);
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jPanel3MouseEntered(evt);
			}
		});

		jProgressBarFatigue.setString("ENERGY " + joueurs.get(0).getSignauxVitaux().get(1).getJauge() + " %");
		jProgressBarFatigue.setStringPainted(true);
		jPanelPrincipal.add(jProgressBarFatigue);
		jProgressBarFatigue.setBounds(20, 910, 146, 17);

		jProgressBarFaim.setForeground(new java.awt.Color(255, 50, 120));
		jProgressBarFaim.setString("HUNGER " + joueurs.get(0).getSignauxVitaux().get(0).getJauge() + " %");
		jProgressBarFaim.setStringPainted(true);
		jPanelPrincipal.add(jProgressBarFaim);
		jProgressBarFaim.setBounds(20, 930, 146, 14);
		jInternalFrameInventaire.setVisible(true);

		jButtonQuitterInventaire.setText("Quitter");
		jButtonQuitterInventaire.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButtonQuitterInventaireMouseClicked(evt);
			}
		});

		jTextFieldInventaire.setEditable(false);
		jTextFieldInventaire.setText("Inventaire");

		java.awt.GridBagLayout jPanelInventaireLayout = new java.awt.GridBagLayout();
		jPanelInventaireLayout.columnWidths = new int[] { 0, 100, 0 };
		jPanelInventaireLayout.rowHeights = new int[] { 0, 100, 0 };
		jPanelInventaireLayout.columnWeights = new double[] { 0.0, 100.0, 0.0 };
		jPanelInventaireLayout.rowWeights = new double[] { 0.0, 100.0, 0.0 };
		jPanelInventaire.setLayout(jPanelInventaireLayout);

		javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(
				jInternalFrameInventaire.getContentPane());
		jInternalFrameInventaire.getContentPane().setLayout(jInternalFrame1Layout);
		jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jInternalFrame1Layout.createSequentialGroup()
						.addComponent(jTextFieldInventaire, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jButtonQuitterInventaire))
				.addComponent(jPanelInventaire, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
						.addComponent(jPanelInventaire, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonQuitterInventaire).addComponent(jTextFieldInventaire,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))));

		jPanelPrincipal.add(jInternalFrameInventaire);
		jInternalFrameInventaire.setBounds(260, 560, 400, 370);

		getContentPane().add(jPanelPrincipal);
		jPanelPrincipal.setBounds(-10, 0, 1280, 1070);

		jLabelCarte.setIcon(new javax.swing.ImageIcon("./media/map.jpg")); // NOI18N
		jLabelCarte.setMinimumSize(new java.awt.Dimension(1280, 1024));
		jLabelCarte.setPreferredSize(new java.awt.Dimension(1280, 1024));
		getContentPane().add(jLabelCarte);
		jLabelCarte.setBounds(0, 0, 1280, 1024);

		pack();
	}

	private Icon ressourceIcon(Ressource ressource) {
		return new javax.swing.ImageIcon("./media/pomme.png");
	}

	private Icon objetIcon(Objet objet) {
		return new javax.swing.ImageIcon("./media/feu.png");
	}

	private Icon joueurIcon(String nom) {
		return new javax.swing.ImageIcon("./media/joueur.png");
	}

	private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {
		jPanelPrincipal.requestFocusInWindow();

	}

	private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {

	}

	private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {
		// System.out.println(MouseInfo.getPointerInfo().getLocation().getX()+ " " +
		// MouseInfo.getPointerInfo().getLocation().getY());
		// System.out.println(jLabel1.getX()+ " " + jLabel1.getY());

	}

	private void joueurMouseClicked(java.awt.event.MouseEvent evt) {
		joueursLabels.get(0).requestFocusInWindow();
	}

	private void joueurKeyPressed(java.awt.event.KeyEvent evt) {

		if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
			System.out.println("Moving right");
			joueurs.get(0).seDeplacer(Deplacement.EST);
			joueursLabels.get(0).setBounds((int) joueurs.get(0).getPosition().getX() + 2,
					(int) joueurs.get(0).getPosition().getY(), 70, 60);
			// joueursLabels.get(0).setBounds(joueurs.get(0).getPosition()[0] + 2,
			// joueurs.get(0).getPosition()[1], 70, 60);
		} else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
			System.out.println("Moving down");
			joueurs.get(0).seDeplacer(Deplacement.SUD);
			joueursLabels.get(0).setBounds((int) joueurs.get(0).getPosition().getX(),
					(int) joueurs.get(0).getPosition().getY() - 2, 70, 60);
			// joueursLabels.get(0).setBounds(joueurs.get(0).getPosition()[0],
			// joueurs.get(0).getPosition()[1] - 2, 70, 60);
		} else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
			System.out.println("Moving left");
			joueurs.get(0).seDeplacer(Deplacement.OUEST);
			joueursLabels.get(0).setBounds((int) joueurs.get(0).getPosition().getX() - 2,
					(int) joueurs.get(0).getPosition().getY(), 70, 60);
			// joueursLabels.get(0).setBounds(joueurs.get(0).getPosition()[0] - 2,
			// joueurs.get(0).getPosition()[1], 70, 60);
		} else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
			System.out.println("Moving up");
			joueurs.get(0).seDeplacer(Deplacement.NORD);
			joueursLabels.get(0).setBounds((int) joueurs.get(0).getPosition().getX(),
					(int) joueurs.get(0).getPosition().getY() + 2, 70, 60);
			// joueursLabels.get(0).setBounds(joueurs.get(0).getPosition()[0],
			// joueurs.get(0).getPosition()[1] + 2, 70, 60);
		} else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_I) {
			jInternalFrameInventaire.setVisible(true);
		}

		jProgressBarFatigue.setString("ENERGY " + joueurs.get(0).getSignauxVitaux().get(1).getJauge() + " %");

	}

	private void joueurFocusGained(java.awt.event.FocusEvent evt) {
		System.out.println("FOCUS GAINED -- Vous avez le contrôle du joueur");

	}

	private void joueurFocusLost(java.awt.event.FocusEvent evt) {
		System.out.println("FOCUS LOST -- Vous n'avez plus le contrôle du joueur");
	}

	@SuppressWarnings("unused")
	private static void music() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("./media/skyrim.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void music2() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("./media/fire.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	private void ressourceMouseClicked(java.awt.event.MouseEvent evt) {
		double distance = Math.sqrt(Math.pow(joueurs.get(0).getPosition().getX() - evt.getComponent().getX(), 2)
				+ Math.pow(joueurs.get(0).getPosition().getY() - evt.getComponent().getY(), 2));
		// double distance = Math.sqrt(Math.pow(joueurs.get(0).getPosition()[0] -
		// evt.getComponent().getX(), 2)
		// + Math.pow(joueurs.get(0).getPosition()[1] - evt.getComponent().getY(), 2));
		javax.swing.JLabel copy = (javax.swing.JLabel) evt.getComponent();
		Ressources ressource = ressources.get(Integer.parseInt(copy.getText())).getNom();
		System.out.println("Dans l'inventaire ? " + joueurs.get(0).getInventaire().estPresent(ressource));
		System.out.println(objets.size() + " " + copy.getText());
		if (distance < 30) {

			System.out.println("Ressource : " + ressource);
			joueurs.get(0).faireAction(new ActionRamasserRessource("Shepard", 1, ressource),
					new String[] { copy.getText() });
			evt.getComponent().setVisible(false);
			jPanelInventaire.add(copy);
			copy.setVisible(true);
			jPanelPrincipal.remove(evt.getComponent());
			System.out.println("Dans l'inventaire ? " + joueurs.get(0).getInventaire().estPresent(ressource));
		}

	}

	private void objetMouseClicked(java.awt.event.MouseEvent evt) {
		javax.swing.JLabel copy = (javax.swing.JLabel) evt.getComponent();
		Objets objet = objets.get(Integer.parseInt(copy.getText())).getNom();
		System.out.println("Position : " + evt.getComponent().getX() + " " + evt.getComponent().getY()
				+ "\n Vous ne pouvez pas ramasser un objet : " + objet);
	}

	private void jButtonQuitterInventaireMouseClicked(java.awt.event.MouseEvent evt) {
		jInternalFrameInventaire.setVisible(false);
	}

	/**
	 * @param args the command line arguments
	 */
	public void launch() {

		this.setVisible(true);

		// music();

	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButtonQuitterInventaire;
	private javax.swing.JInternalFrame jInternalFrameInventaire;
	private javax.swing.JLabel jLabelCarte;
	private javax.swing.JPanel jPanelInventaire;
	private javax.swing.JPanel jPanelPrincipal;
	private javax.swing.JProgressBar jProgressBarFatigue;
	private javax.swing.JProgressBar jProgressBarFaim;
	private javax.swing.JTextField jTextFieldInventaire = new javax.swing.JTextField();

}
