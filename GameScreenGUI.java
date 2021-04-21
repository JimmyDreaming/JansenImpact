import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScreenGUI extends JFrame implements ActionListener{
    private JPanel northPanel, centerPanel, southPanel, topLeftPanel, topRightPanel, bottomLeftPanel;
    private JLabel headerLabel, charNameLabel, charHPLabel, enemyNameLabel, enemyHPLabel, displayLabel; 
    private JButton toHomeButton, toArmoryButton, toInventoryButton, toCharactersButton, toPullButton, fightButton, resetButton;
    private Player player;
    private Character activeCharacter;
    private Unit activeEnemy;

    public GameScreenGUI(Player p){
        super("Jansen Impact");
        player = p;
        activeCharacter = player.getCharList().get(0);
        activeEnemy = Unit.getEnemyList().get(0);
        headerLabel = new JLabel(player.getName() + "'s Adventure!");
        charNameLabel = new JLabel();
        charHPLabel = new JLabel();
        enemyNameLabel = new JLabel();
        enemyHPLabel = new JLabel();
        displayLabel = new JLabel();
        
        toHomeButton = new JButton("Home");
        toHomeButton.addActionListener(this);
        toArmoryButton = new JButton("Armory");
        toArmoryButton.addActionListener(this);
        toInventoryButton = new JButton("Inventory");
        toInventoryButton.addActionListener(this);
        toCharactersButton = new JButton("Characters");
        toCharactersButton.addActionListener(this);
        toPullButton = new JButton("Pull!");
        toPullButton.addActionListener(this);
        fightButton = new JButton("Fight");
        fightButton.addActionListener(this);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        northPanel.setBackground(new Color(0xFFFFFF));
        northPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        northPanel.add(toHomeButton);
        northPanel.add(headerLabel);
        
        centerPanel = new JPanel(new GridLayout(2,2));
        topLeftPanel = new JPanel();
        topLeftPanel.add(charNameLabel);
        topLeftPanel.add(charHPLabel);
        topRightPanel = new JPanel();
        topRightPanel.add(enemyNameLabel);
        topRightPanel.add(enemyHPLabel);
        bottomLeftPanel = new JPanel();
        bottomLeftPanel.add(fightButton);
        bottomLeftPanel.add(resetButton);
        centerPanel.add(topLeftPanel);
        centerPanel.add(topRightPanel);
        centerPanel.add(bottomLeftPanel);
        centerPanel.add(displayLabel);

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        southPanel.setBackground(new Color(0xFFFFFF));
        southPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        southPanel.add(toArmoryButton);
        southPanel.add(toInventoryButton);
        southPanel.add(toCharactersButton);
        southPanel.add(toPullButton);
        
        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void update(){
        charNameLabel.setText(activeCharacter.getName());
        charHPLabel.setText(activeCharacter.getHP() + " / " + activeCharacter.getMaxHP());
        enemyNameLabel.setText(activeEnemy.getName());
        enemyHPLabel.setText(activeEnemy.getHP() + " / " + activeEnemy.getMaxHP());
        displayLabel.setText("");
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == toHomeButton){
            HomeScreenGUI frame = new HomeScreenGUI(player);
            frame.setVisible(true);
            frame.setLocationRelativeTo(this);
            this.dispose();
        }
        if(e.getSource() == toArmoryButton){
            // nothing happens for now
        }
        if(e.getSource() == toInventoryButton){
            // nothing happens for now
        }
        if(e.getSource() == toCharactersButton){
            // nothing happens for now
        }
        if(e.getSource() == toPullButton){
            // nothing happens for now
        }
        if(e.getSource() == fightButton){
            activeCharacter.attack(activeEnemy);
            activeEnemy.attack(activeCharacter);
            this.update();
        }
        if(e.getSource() == resetButton){
            activeCharacter.restoreHP();
            activeEnemy.restoreHP();
            this.update();
        }
    }
}
