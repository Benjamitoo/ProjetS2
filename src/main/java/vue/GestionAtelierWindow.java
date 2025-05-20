package vue;

import modele.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class GestionAtelierWindow extends JFrame {

    // Données du modèle
    private Atelier atelier;

    // Composants graphiques
    private JTextField tfNomAtelier;
    private JTextField tfChefId, tfChefNom, tfChefPrenom;
    private JButton btnCreerAtelier;

    private DefaultListModel<Machine> modelMachines;
    private JList<Machine> listMachines;
    private JButton btnAjouterMachine, btnSupprimerMachine;

    private DefaultListModel<Poste> modelPostes;
    private JList<Poste> listPostes;
    private JButton btnAjouterPoste;

    private DefaultListModel<Operation> modelOperations;
    private JList<Operation> listOperations;
    private JButton btnAjouterOperation, btnModifierOperation, btnSupprimerOperation;

    public GestionAtelierWindow() {
        setTitle("Gestion Atelier");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        initLayout();
        initListeners();

        // Atelier initialement nul
        atelier = null;
    }

    private void initComponents() {
        // Création atelier
        tfNomAtelier = new JTextField(15);
        tfChefId = new JTextField(5);
        tfChefNom = new JTextField(10);
        tfChefPrenom = new JTextField(10);
        btnCreerAtelier = new JButton("Créer Atelier");

        // Machines
        modelMachines = new DefaultListModel<>();
        listMachines = new JList<>(modelMachines);
        btnAjouterMachine = new JButton("Ajouter Machine");
        btnSupprimerMachine = new JButton("Supprimer Machine");

        // Postes
        modelPostes = new DefaultListModel<>();
        listPostes = new JList<>(modelPostes);
        btnAjouterPoste = new JButton("Ajouter Poste");

        // Opérations
        modelOperations = new DefaultListModel<>();
        listOperations = new JList<>(modelOperations);
        btnAjouterOperation = new JButton("Ajouter Opération");
        btnModifierOperation = new JButton("Modifier Opération");
        btnSupprimerOperation = new JButton("Supprimer Opération");

        // Désactivation boutons tant qu'atelier non créé
        setAtelierControlsEnabled(false);
    }

    private void initLayout() {
        JPanel panelMain = new JPanel(new BorderLayout(10,10));
        JPanel panelCreation = new JPanel(new GridBagLayout());
        JPanel panelCentre = new JPanel(new GridLayout(1, 3, 10, 10));

        // Panel création atelier
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx=0; gbc.gridy=0; panelCreation.add(new JLabel("Nom Atelier:"), gbc);
        gbc.gridx=1; panelCreation.add(tfNomAtelier, gbc);
        gbc.gridx=0; gbc.gridy=1; panelCreation.add(new JLabel("Chef ID:"), gbc);
        gbc.gridx=1; panelCreation.add(tfChefId, gbc);
        gbc.gridx=0; gbc.gridy=2; panelCreation.add(new JLabel("Chef Nom:"), gbc);
        gbc.gridx=1; panelCreation.add(tfChefNom, gbc);
        gbc.gridx=0; gbc.gridy=3; panelCreation.add(new JLabel("Chef Prénom:"), gbc);
        gbc.gridx=1; panelCreation.add(tfChefPrenom, gbc);
        gbc.gridx=0; gbc.gridy=4; gbc.gridwidth=2;
        panelCreation.add(btnCreerAtelier, gbc);

        // Panel Machines
        JPanel panelMachines = new JPanel(new BorderLayout());
        panelMachines.setBorder(BorderFactory.createTitledBorder("Machines"));
        panelMachines.add(new JScrollPane(listMachines), BorderLayout.CENTER);
        JPanel panMachBtns = new JPanel();
        panMachBtns.add(btnAjouterMachine);
        panMachBtns.add(btnSupprimerMachine);
        panelMachines.add(panMachBtns, BorderLayout.SOUTH);

        // Panel Postes
        JPanel panelPostes = new JPanel(new BorderLayout());
        panelPostes.setBorder(BorderFactory.createTitledBorder("Postes"));
        panelPostes.add(new JScrollPane(listPostes), BorderLayout.CENTER);
        JPanel panPostBtns = new JPanel();
        panPostBtns.add(btnAjouterPoste);
        panelPostes.add(panPostBtns, BorderLayout.SOUTH);

        // Panel Operations
        JPanel panelOperations = new JPanel(new BorderLayout());
        panelOperations.setBorder(BorderFactory.createTitledBorder("Opérations"));
        panelOperations.add(new JScrollPane(listOperations), BorderLayout.CENTER);
        JPanel panOpsBtns = new JPanel();
        panOpsBtns.add(btnAjouterOperation);
        panOpsBtns.add(btnModifierOperation);
        panOpsBtns.add(btnSupprimerOperation);
        panelOperations.add(panOpsBtns, BorderLayout.SOUTH);

        // Ajout au centre
        panelCentre.add(panelMachines);
        panelCentre.add(panelPostes);
        panelCentre.add(panelOperations);

        panelMain.add(panelCreation, BorderLayout.NORTH);
        panelMain.add(panelCentre, BorderLayout.CENTER);

        setContentPane(panelMain);
    }

    private void initListeners() {
        btnCreerAtelier.addActionListener(e -> creerAtelier());

        btnAjouterMachine.addActionListener(e -> ajouterMachine());
        btnSupprimerMachine.addActionListener(e -> supprimerMachine());

        btnAjouterPoste.addActionListener(e -> ajouterPoste());

        btnAjouterOperation.addActionListener(e -> ajouterOperation());
        btnModifierOperation.addActionListener(e -> modifierOperation());
        btnSupprimerOperation.addActionListener(e -> supprimerOperation());

        // Sélection opération pour activer modification/suppression
        listOperations.addListSelectionListener(e -> {
            boolean selected = listOperations.getSelectedIndex() != -1;
            btnModifierOperation.setEnabled(selected);
            btnSupprimerOperation.setEnabled(selected);
        });

        // Désactivation modification/suppression opérations au départ
        btnModifierOperation.setEnabled(false);
        btnSupprimerOperation.setEnabled(false);
    }

    private void setAtelierControlsEnabled(boolean enabled) {
        btnAjouterMachine.setEnabled(enabled);
        btnSupprimerMachine.setEnabled(enabled);
        btnAjouterPoste.setEnabled(enabled);
        btnAjouterOperation.setEnabled(enabled);
        btnModifierOperation.setEnabled(enabled && listOperations.getSelectedIndex() != -1);
        btnSupprimerOperation.setEnabled(enabled && listOperations.getSelectedIndex() != -1);
        listMachines.setEnabled(enabled);
        listPostes.setEnabled(enabled);
        listOperations.setEnabled(enabled);
    }

    private void creerAtelier() {
        String nom = tfNomAtelier.getText().trim();
        String chefId = tfChefId.getText().trim();
        String chefNom = tfChefNom.getText().trim();
        String chefPrenom = tfChefPrenom.getText().trim();

        if (nom.isEmpty() || chefId.isEmpty() || chefNom.isEmpty() || chefPrenom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Merci de remplir tous les champs pour créer l'atelier.",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ChefAtelier chef = new ChefAtelier(chefId, chefNom, chefPrenom);
        atelier = new Atelier(nom, chef);

        JOptionPane.showMessageDialog(this, "Atelier créé avec succès : " + nom);

        setAtelierControlsEnabled(true);

        // Actualiser listes
        refreshAllLists();
    }

    private void ajouterMachine() {
        if (atelier == null) return;

        JTextField tfRef = new JTextField();
        JTextField tfDes = new JTextField();
        JTextField tfType = new JTextField();
        JTextField tfCout = new JTextField();
        JTextField tfX = new JTextField();
        JTextField tfY = new JTextField();

        Object[] message = {
                "Référence:", tfRef,
                "Description:", tfDes,
                "Type:", tfType,
                "Coût:", tfCout,
                "Position X:", tfX,
                "Position Y:", tfY,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Ajouter Machine", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String id = tfRef.getText().trim();
                String ref = tfRef.getText().trim();
                String des = tfDes.getText().trim();
                String type = tfType.getText().trim();
                float cout = Float.parseFloat(tfCout.getText().trim());
                float x = Float.parseFloat(tfX.getText().trim());
                float y = Float.parseFloat(tfY.getText().trim());

                Machine machine = new Machine(id, ref, des, type, cout, x, y);
                atelier.addEquipement(machine);
                refreshMachines();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valeurs numériques invalides pour coût ou position.",
                        "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void supprimerMachine() {
        if (atelier == null) return;
        Machine machine = listMachines.getSelectedValue();
        if (machine == null) {
            JOptionPane.showMessageDialog(this, "Sélectionnez une machine à supprimer.", "Attention", JOptionPane.WARNING_MESSAGE);
            return;
        }
        atelier.getListeEquipement().remove(machine);
        refreshMachines();
    }

    private void ajouterPoste() {
        if (atelier == null) return;

        JTextField tfRef = new JTextField();
        JTextField tfDes = new JTextField();

        Object[] message = {
                "Référence:", tfRef,
                "Description:", tfDes,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Ajouter Poste", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String ref = tfRef.getText().trim();
            String des = tfDes.getText().trim();

            if (ref.isEmpty() || des.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Merci de remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Poste poste = new Poste(ref, des);
            //atelier.addPoste(poste);
            refreshPostes();
        }
    }

    private void ajouterOperation() {
        if (atelier == null) return;

        JTextField tfRef = new JTextField();
        JTextField tfDes = new JTextField();
        JTextField tfTemps = new JTextField();

        Object[] message = {
                "Référence:", tfRef,
                "Description:", tfDes,
                "Temps (minutes):", tfTemps,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Ajouter Opération", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String ref = tfRef.getText().trim();
                String des = tfDes.getText().trim();
                int duree = Integer.parseInt(tfTemps.getText().trim());
                Equipement equipement

                Operation op = new Operation(ref, des, duree, equipement);
                atelier.addOperation(op);
                refreshOperations();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Temps doit être un nombre entier.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void modifierOperation() {
        if (atelier == null) return;
        Operation op = listOperations.getSelectedValue();
        if (op == null) {
            JOptionPane.showMessageDialog(this, "Sélectionnez une opération à modifier.", "Attention", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JTextField tfRef = new JTextField(op.getReference());
        JTextField tfDes = new JTextField(op.getDescription());
        JTextField tfTemps = new JTextField(String.valueOf(op.getTemps()));

        Object[] message = {
                "Référence:", tfRef,
                "Description:", tfDes,
                "Temps (minutes):", tfTemps,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Modifier Opération", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String ref = tfRef.getText().trim();
                String des = tfDes.getText().trim();
                int duree = Integer.parseInt(tfTemps.getText().trim());
                Equipement equipement =

                op.setRef(ref);
                op.setDes(des);
                op.setDuree(duree);
                op.setEquipement(equipement);

                refreshOperations();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Temps doit être un nombre entier.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void supprimerOperation() {
        if (atelier == null) return;
        Operation op = listOperations.getSelectedValue();
        if (op == null) {
            JOptionPane.showMessageDialog(this, "Sélectionnez une opération à supprimer.", "Attention", JOptionPane.WARNING_MESSAGE);
            return;
        }
        atelier.getListeOperations().remove(op);
        refreshOperations();
    }

    private void refreshMachines() {
        modelMachines.clear();
        if (atelier != null) {
            for (Machine m : atelier.getListeEquipement()) {
                modelMachines.addElement(m);
            }
        }
    }

    private void refreshPostes() {
        modelPostes.clear();
        if (atelier != null) {
            for (Poste p : atelier.getPostes()) {
                modelPostes.addElement(p);
            }
        }
    }

    private void refreshOperations() {
        modelOperations.clear();
        if (atelier != null) {
            for (Operation o : atelier.getListeOperations()) {
                modelOperations.addElement(o);
            }
        }
    }

    private void refreshAllLists() {
        refreshMachines();
        refreshPostes();
        refreshOperations();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestionAtelierWindow window = new GestionAtelierWindow();
            window.setVisible(true);
        });
    }
}
