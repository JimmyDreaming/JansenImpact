import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeScreenGUI extends JFrame implements ActionListener{
    private JPanel playerPanel, centerPanel, startPanel;
    private JLabel playerLabel, titleLabel, subtitleLabel;
    private JTextField playerTextField;
    private JButton changePlayerButton, createPlayerButton, startButton;
    private Player player;
    
    public HomeScreenGUI(Player p){
        super("Jansen Impact");
        player = p;
        
        playerLabel = new JLabel("Player: " + player.getName());
        titleLabel = new JLabel("Welcome to Jansen Impact");
        titleLabel.setFont(new Font("Helvetica", Font.ITALIC, 36));
        titleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subtitleLabel = new JLabel("An endless journey starts from home.");
        subtitleLabel.setFont(new Font("Avant Garde", Font.PLAIN, 14));
        subtitleLabel.setVerticalAlignment(SwingConstants.TOP);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerTextField = new JTextField(10);
        
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        changePlayerButton = new JButton("Change Player");
        changePlayerButton.addActionListener(this);
        createPlayerButton = new JButton("Create Player");
        createPlayerButton.addActionListener(this);
        
        playerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        playerPanel.setBackground(new Color(0xFFFFFF));
        playerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        playerPanel.add(playerLabel);
        playerPanel.add(playerTextField);
        playerPanel.add(changePlayerButton);
        playerPanel.add(createPlayerButton);
        
        startPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startPanel.add(startButton);
        
        centerPanel = new JPanel(new GridLayout(3,1));
        centerPanel.add(titleLabel);
        centerPanel.add(subtitleLabel);
        centerPanel.add(startPanel);
        
        this.setLayout(new BorderLayout());
        this.add(playerPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        this.update();
    }
    
    public void actionPerformed(ActionEvent e){
        String input = playerTextField.getText();
        
        if(e.getSource() == startButton){
            GameScreenGUI frame = new GameScreenGUI(player);
            frame.setVisible(true);
            frame.setLocationRelativeTo(this);
            this.dispose();
        }
        if(e.getSource() == changePlayerButton){
            try {
                player = Player.changePlayer(input);
                this.update();
                JOptionPane.showMessageDialog(this, "Changed current Player to '" + player.getName() + "'!","Successful change of Player.", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(IndexOutOfBoundsException err) {
                JOptionPane.showMessageDialog(this, "No Player named '" + input + "' found.", "Invalid input.", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                playerTextField.setText("");
            }
        }
        if(e.getSource() == createPlayerButton){
            try {
                player = Player.createPlayer(input);
                this.update();
                JOptionPane.showMessageDialog(this, "Created new Player '" + player.getName() + "'!","Successful creation of new Player.", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(ExistingPlayerException err) {
                JOptionPane.showMessageDialog(this, err.getMessage(), "Invalid output.", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                playerTextField.setText("");
            }
        }
    }
    
    public void update(){
        playerLabel.setText("Player: " + player.getName());
    }
}
