import java.util.ArrayList;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.URL;
import java.applet.Applet;

public class FindTheBomb extends javax.swing.JFrame {

    private javax.swing.JLabel BOX;
    private javax.swing.JInternalFrame End;
    private javax.swing.JLabel Grade;
    private javax.swing.JInternalFrame Welcome;
    private javax.swing.JLabel Win;
    private javax.swing.JLabel about;
    private javax.swing.JButton again;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bgEnd;
    private javax.swing.JLabel bgWelcome;
    private javax.swing.JLabel chance1;
    private javax.swing.JLabel chance2;
    private javax.swing.JLabel chanceText;
    private javax.swing.JLabel chanceText1;
    private javax.swing.JLabel chanceText2;
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField name2;
    private javax.swing.JLabel score1;
    private javax.swing.JLabel score2;
    private javax.swing.JLabel scoreText;
    private javax.swing.JLabel scoreText1;
    private javax.swing.JLabel scoreText2;
    private javax.swing.JPanel tile;
    private javax.swing.JLabel turn;
    private javax.swing.JLabel welcomeText;

    ArrayList<JButton> bomb = new ArrayList<>();
    Pemain p1 = new Pemain();
    Pemain p2 = new Pemain();
    Lapangan field = new Lapangan();
    int turn1 =20, turn2=20;
    AudioClip clip;
    URL urlClip;
    
    public FindTheBomb() {
        initComponents();
        setup();
    }
    
    public void setup(){
        for(int i=0; i<100; i++){
            JButton button = new JButton();
            button.setFont(new java.awt.Font("SansSerif", 1, 24));
            button.setForeground(new java.awt.Color(255, 255, 255));
            button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/base.png")));
            button.setText(i+1+"");
            button.setContentAreaFilled(false);
            button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if(button.getText() != null && (turn1 > 0 || turn2 > 0)){
                        check(evt, Integer.parseInt(button.getText()));
                    }
                }
            });
            bomb.add(button);
            tile.add(button);
        }
        score1.setText(p1.getNilai()+"");
        score2.setText(p2.getNilai()+"");
        chance1.setText(Integer.toString(turn1));
        chance2.setText(Integer.toString(turn2));
        about.setText("<html>Developer Team :<br/> - Arie Maulana<br/> - Faried Risky<br/> - Muhammad Ridha<br/> - Naufal Mas Adha</html>");
        End.dispose();
    }
    private void check(java.awt.event.ActionEvent evt, int num) {                                         
        if(field.adaItem(num)){
            urlClip = FindTheBomb.class.getResource("true.wav");
            clip = Applet.newAudioClip(urlClip);
            clip.play();
            bomb.get(num-1).setIcon(new javax.swing.ImageIcon(getClass().getResource("/true.png")));
            if(turn.getText().equals(p1.getNama()+ "'s turn") && turn1 > 0){
                p1.tambahNilai();
                score1.setText(p1.getNilai()+"");
                turn1--;
                chance1.setText(turn1+"");
                turn.setText(p2.getNama()+ "'s turn");
            }else if(turn.getText().equals(p2.getNama()+ "'s turn") && turn2 > 0){
                p2.tambahNilai();
                score2.setText(p2.getNilai()+"");
                turn2--;
                chance2.setText(turn2+"");
                turn.setText(p1.getNama()+ "'s turn");
            }
        }else{
            urlClip = FindTheBomb.class.getResource("false.wav");
            clip = Applet.newAudioClip(urlClip);
            clip.play();
            bomb.get(num-1).setIcon(new javax.swing.ImageIcon(getClass().getResource("/false.png")));
            if(turn.getText().equals(p1.getNama()+ "'s turn")&& turn1 > 0){
                turn1--;
                chance1.setText(turn1+"");
                turn.setText(p2.getNama()+ "'s turn");
            }else if(turn.getText().equals(p2.getNama()+ "'s turn") && turn2 > 0){
                turn2--;
                chance2.setText(turn2+"");
                turn.setText(p1.getNama()+ "'s turn");
            }
        }
        bomb.get(num-1).setText(null);
        if(turn1 == 0 && turn2 == 0){
//            Win.setText(p1.getNilai()>p2.getNilai()?p1.getNama():p2.getNama()+" WIN");
            if(p1.getNilai()>p2.getNilai()){
                Win.setText(p1.getNama() + " Win");
            }else if(p1.getNilai()<p2.getNilai()){
                Win.setText(p2.getNama() + " Win");
            }else{
                Win.setText("DRAW");
            }
            Grade.setText("<html>" + p1.getNama()+ "'s Grade : "+ p1.getGrade()+"<br/>"+ p2.getNama()+ "'s Grade : "+ p2.getGrade()+"</html>");
            End.show();
        }
    } 

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        End = new javax.swing.JInternalFrame();
        jLabel4 = new javax.swing.JLabel();
        Win = new javax.swing.JLabel();
        Grade = new javax.swing.JLabel();
        again = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        BOX = new javax.swing.JLabel();
        bgEnd = new javax.swing.JLabel();
        Welcome = new javax.swing.JInternalFrame();
        jButton2 = new javax.swing.JButton();
        welcomeText = new javax.swing.JLabel();
        name1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name2 = new javax.swing.JTextField();
        about = new javax.swing.JLabel();
        bgWelcome = new javax.swing.JLabel();
        tile = new javax.swing.JPanel();
        turn = new javax.swing.JLabel();
        chanceText = new javax.swing.JLabel();
        scoreText = new javax.swing.JLabel();
        score1 = new javax.swing.JLabel();
        score2 = new javax.swing.JLabel();
        scoreText1 = new javax.swing.JLabel();
        scoreText2 = new javax.swing.JLabel();
        chanceText1 = new javax.swing.JLabel();
        chance1 = new javax.swing.JLabel();
        chanceText2 = new javax.swing.JLabel();
        chance2 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find The Bomb Game");
        setBounds(new java.awt.Rectangle(250, 25, 900, 675));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(900, 675));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 675));

        jPanel1.setMinimumSize(new java.awt.Dimension(900, 675));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 675));
        jPanel1.setLayout(null);

        End.setBorder(null);
        End.setVisible(true);
        End.getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 48));
        jLabel4.setForeground(new java.awt.Color(255, 2, 2));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GAME OVER");
        End.getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 100, 590, 50);

        Win.setFont(new java.awt.Font("Nirmala UI", 1, 36));
        Win.setForeground(new java.awt.Color(102, 255, 0));
        Win.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Win.setText("PLAYER 1 WIN");
        End.getContentPane().add(Win);
        Win.setBounds(230, 200, 460, 50);

        Grade.setFont(new java.awt.Font("Nirmala UI", 1, 24));
        Grade.setForeground(new java.awt.Color(255, 255, 255));
        Grade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Grade.setText("<html>Player 1 : Grade<br/>Player 2 : Grade</html>");
        Grade.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        End.getContentPane().add(Grade);
        Grade.setBounds(290, 260, 340, 80);

        again.setBackground(new java.awt.Color(255, 51, 51));
        again.setFont(new java.awt.Font("Tahoma", 1, 18));
        again.setForeground(new java.awt.Color(255, 255, 255));
        again.setText("Exit");
        again.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                againActionPerformed(evt);
            }
        });
        End.getContentPane().add(again);
        again.setBounds(300, 360, 140, 40);

        exit.setBackground(new java.awt.Color(0, 153, 255));
        exit.setFont(new java.awt.Font("Tahoma", 1, 18));
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Play Again");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        End.getContentPane().add(exit);
        exit.setBounds(480, 360, 130, 40);

        BOX.setFont(new java.awt.Font("Nirmala UI", 1, 48));
        BOX.setForeground(new java.awt.Color(255, 2, 2));
        BOX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BOX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BOX.png")));
        End.getContentPane().add(BOX);
        BOX.setBounds(164, 150, 590, 320);

        bgEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg-2.png")));
        End.getContentPane().add(bgEnd);
        bgEnd.setBounds(4, 4, 890, 650);

        jPanel1.add(End);
        End.setBounds(0, 0, 900, 680);

        Welcome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Welcome.setVisible(true);
        Welcome.getContentPane().setLayout(null);

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CONTINUE >");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Welcome.getContentPane().add(jButton2);
        jButton2.setBounds(390, 520, 160, 50);

        welcomeText.setFont(new java.awt.Font("Tahoma", 1, 24));
        welcomeText.setForeground(new java.awt.Color(255, 255, 255));
        welcomeText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeText.setText("WELCOME");
        Welcome.getContentPane().add(welcomeText);
        welcomeText.setBounds(380, 0, 180, 50);

        name1.setFont(new java.awt.Font("Tahoma", 0, 14));
        name1.setText("Ucup");
        Welcome.getContentPane().add(name1);
        name1.setBounds(430, 410, 220, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Player 1 name : ");
        Welcome.getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 410, 130, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel2.setText("Player 2 name : ");
        Welcome.getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 460, 130, 30);

        name2.setFont(new java.awt.Font("Tahoma", 0, 14));
        name2.setText("Otong");
        
        Welcome.getContentPane().add(name2);
        name2.setBounds(430, 460, 220, 30);

        about.setFont(new java.awt.Font("Tahoma", 1, 11));
        about.setForeground(new java.awt.Color(255, 255, 255));
        about.setText("About");
        about.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Welcome.getContentPane().add(about);
        about.setBounds(20, 70, 140, 170);

        bgWelcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg-welcome.png")));
        Welcome.getContentPane().add(bgWelcome);
        bgWelcome.setBounds(4, 4, 890, 640);

        jPanel1.add(Welcome);
        Welcome.setBounds(0, 0, 900, 675);

        tile.setOpaque(false);
        tile.setLayout(new java.awt.GridLayout(10, 10));
        jPanel1.add(tile);
        tile.setBounds(160, 92, 680, 510);

        turn.setFont(new java.awt.Font("Tahoma", 0, 22));
        turn.setForeground(new java.awt.Color(255, 255, 255));
        turn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turn.setText("Player 1 turn");
        jPanel1.add(turn);
        turn.setBounds(370, 22, 180, 30);

        chanceText.setFont(new java.awt.Font("Tahoma", 1, 12));
        chanceText.setForeground(new java.awt.Color(255, 255, 255));
        chanceText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chanceText.setText("CHANCE");
        jPanel1.add(chanceText);
        chanceText.setBounds(40, 350, 70, 10);

        scoreText.setFont(new java.awt.Font("Tahoma", 1, 12));
        scoreText.setForeground(new java.awt.Color(255, 255, 255));
        scoreText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreText.setText("SCORE");
        jPanel1.add(scoreText);
        scoreText.setBounds(44, 127, 60, 10);

        score1.setFont(new java.awt.Font("Tahoma", 1, 34));
        score1.setForeground(new java.awt.Color(255, 204, 0));
        score1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score1.setText("0");
        jPanel1.add(score1);
        score1.setBounds(20, 170, 100, 50);

        score2.setFont(new java.awt.Font("Tahoma", 1, 34));
        score2.setForeground(new java.awt.Color(255, 204, 0));
        score2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score2.setText("0");
        jPanel1.add(score2);
        score2.setBounds(20, 235, 100, 50);

        scoreText1.setFont(new java.awt.Font("Tahoma", 1, 12));
        scoreText1.setForeground(new java.awt.Color(255, 255, 255));
        scoreText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreText1.setText("Player 1:");
        jPanel1.add(scoreText1);
        scoreText1.setBounds(40, 150, 60, 20);

        scoreText2.setFont(new java.awt.Font("Tahoma", 1, 12));
        scoreText2.setForeground(new java.awt.Color(255, 255, 255));
        scoreText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreText2.setText("Player 2:");
        jPanel1.add(scoreText2);
        scoreText2.setBounds(40, 220, 60, 15);

        chanceText1.setFont(new java.awt.Font("Tahoma", 1, 12));
        chanceText1.setForeground(new java.awt.Color(255, 255, 255));
        chanceText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chanceText1.setText("Player 1:");
        jPanel1.add(chanceText1);
        chanceText1.setBounds(40, 373, 60, 20);

        chance1.setFont(new java.awt.Font("Tahoma", 1, 34));
        chance1.setForeground(new java.awt.Color(255, 204, 0));
        chance1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chance1.setText("20");
        jPanel1.add(chance1);
        chance1.setBounds(20, 390, 100, 50);

        chanceText2.setFont(new java.awt.Font("Tahoma", 1, 12));
        chanceText2.setForeground(new java.awt.Color(255, 255, 255));
        chanceText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chanceText2.setText("Player 2:");
        jPanel1.add(chanceText2);
        chanceText2.setBounds(40, 440, 60, 20);

        chance2.setFont(new java.awt.Font("Tahoma", 1, 34));
        chance2.setForeground(new java.awt.Color(255, 204, 0));
        chance2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chance2.setText("20");
        jPanel1.add(chance2);
        chance2.setBounds(20, 460, 100, 50);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg-3.png")));
        jPanel1.add(bg);
        bg.setBounds(0, 0, 900, 675);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        p1.setNama(name1.getText());
        p2.setNama(name2.getText());
        Welcome.dispose();
        scoreText1.setText(p1.getNama());
        scoreText2.setText(p2.getNama());
        chanceText1.setText(p1.getNama());
        chanceText2.setText(p2.getNama());
        turn.setText(p1.getNama()+ "'s turn");
        
    }

    private void againActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new FindTheBomb().setVisible(true);
    }

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FindTheBomb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindTheBomb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindTheBomb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindTheBomb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        new FindTheBomb().setVisible(true);
        //     }
        // });
    }
}
