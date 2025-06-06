package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import Player.*;
import java.util.List;

public class Battle extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JProgressBar hpBarEarth;
    private JProgressBar hpBarWater;
    private JProgressBar hpBarFire;
    private JTextArea textArea_1;

    private Player p1, p2, p3;
    private List<Player> players;
    private Random rand = new Random();

    private JLabel nameEarth, nameWater, nameFire;
    private JLabel photoFire, photoWater, photoEarth;
    private JButton attackBtnFire, attackBtnWater, attackBtnEarth;
    private JButton healingBtnFire, healingBtnWater, healingBtnEarth;

    public Battle(Player p1, Player p2, Player p3) throws UnsupportedEncodingException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 900);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        nameEarth = new JLabel(p3.name + " (Lv. " + p3.getLevel() + ")");
        nameEarth.setForeground(Color.WHITE);
        nameEarth.setFont(new Font("굴림", Font.BOLD, 24));
        nameEarth.setBounds(147, 465, 163, 42);
        contentPane.add(nameEarth);

        JLabel hpEarth = new JLabel("HP");
        hpEarth.setForeground(Color.WHITE);
        hpEarth.setBounds(147, 510, 20, 15);
        contentPane.add(hpEarth);

        JLabel hpWater = new JLabel("HP");
        hpWater.setForeground(Color.WHITE);
        hpWater.setBounds(458, 510, 20, 15);
        contentPane.add(hpWater);

        nameWater = new JLabel(p2.name + " (Lv. " + p2.getLevel() + ")");
        nameWater.setForeground(Color.WHITE);
        nameWater.setFont(new Font("굴림", Font.BOLD, 24));
        nameWater.setBounds(490, 472, 171, 28);
        contentPane.add(nameWater);

        JLabel hpFire = new JLabel("HP");
        hpFire.setForeground(Color.WHITE);
        hpFire.setBounds(786, 510, 20, 15);
        contentPane.add(hpFire);

        nameFire = new JLabel(p1.name + " (Lv. " + p1.getLevel() + ")");
        nameFire.setForeground(Color.WHITE);
        nameFire.setFont(new Font("굴림", Font.BOLD, 24));
        nameFire.setBounds(815, 472, 146, 28);
        contentPane.add(nameFire);

        hpBarEarth = new JProgressBar();
        hpBarEarth.setForeground(new Color(255, 0, 0));
        hpBarEarth.setBackground(new Color(240, 240, 240));
        hpBarEarth.setValue(100);
        hpBarEarth.setBounds(167, 511, 146, 14);
        contentPane.add(hpBarEarth);

        hpBarWater = new JProgressBar();
        hpBarWater.setForeground(new Color(255, 0, 0));
        hpBarWater.setBackground(new Color(240, 240, 240));
        hpBarWater.setValue(100);
        hpBarWater.setBounds(490, 511, 146, 14);
        contentPane.add(hpBarWater);

        hpBarFire = new JProgressBar();
        hpBarFire.setForeground(new Color(255, 0, 0));
        hpBarFire.setBackground(new Color(240, 240, 240));
        hpBarFire.setValue(100);
        hpBarFire.setBounds(815, 511, 146, 14);
        contentPane.add(hpBarFire);

        photoFire = new JLabel("");
        photoFire.setIcon(new ImageIcon(Battle.class.getResource("/image/엠버.png")));
        photoFire.setBounds(796, 113, 156, 346);
        contentPane.add(photoFire);

        photoEarth = new JLabel("");
        photoEarth.setIcon(new ImageIcon(Battle.class.getResource("/image/클로드.png")));
        photoEarth.setBounds(134, 228, 190, 233);
        contentPane.add(photoEarth);

        photoWater = new JLabel("");
        photoWater.setIcon(new ImageIcon(Battle.class.getResource("/image/웨이드.png")));
        photoWater.setBounds(498, 130, 163, 370);
        contentPane.add(photoWater);

        attackBtnEarth = new JButton("공격하기");
        attackBtnEarth.setBounds(187, 535, 95, 23);
        contentPane.add(attackBtnEarth);

        healingBtnEarth = new JButton("힐링하기");
        healingBtnEarth.setBounds(187, 568, 95, 23);
        contentPane.add(healingBtnEarth);

        attackBtnWater = new JButton("공격하기");
        attackBtnWater.setBounds(511, 535, 95, 23);
        contentPane.add(attackBtnWater);

        healingBtnWater = new JButton("힐링하기");
        healingBtnWater.setBounds(511, 568, 95, 23);
        contentPane.add(healingBtnWater);

        attackBtnFire = new JButton("공격하기");
        attackBtnFire.setBounds(839, 535, 95, 23);
        contentPane.add(attackBtnFire);

        healingBtnFire = new JButton("힐링하기");
        healingBtnFire.setBounds(839, 568, 95, 23);
        contentPane.add(healingBtnFire);

        textArea_1 = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea_1);
        scrollPane.setBounds(104, 634, 988, 185);
        contentPane.add(scrollPane);

        PrintStream printStream = new PrintStream(new TextAreaOutputStream(textArea_1), true, "UTF-8");
        System.setOut(printStream);
        System.setErr(printStream);

        players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        attackBtnFire.addActionListener(e -> handleAttack(p1));
        attackBtnWater.addActionListener(e -> handleAttack(p2));
        attackBtnEarth.addActionListener(e -> handleAttack(p3));

        healingBtnFire.addActionListener(e -> handleHeal(p1));
        healingBtnWater.addActionListener(e -> handleHeal(p2));
        healingBtnEarth.addActionListener(e -> handleHeal(p3));

        JLabel bg = new JLabel("");
        bg.setIcon(new ImageIcon(Battle.class.getResource("/image/배경.png")));
        bg.setBounds(0, 0, 1186, 863);
        contentPane.add(bg);
    }

    private void handleAttack(Player attacker) {
        if (attacker.getHp() <= 0) return;

        Player target = getRandomTarget(attacker);
        if (target == null) return;

        int prevHp = target.getHp();
        int prevAttackerHp = attacker.getHp();

        if (attacker instanceof WATER) {
            attacker.attackSkill(target);
        } else if (attacker.getLevel() >= 2) {
            attacker.ultimateSkill(target);
        } else {
            attacker.attackSkill(target);
        }

        if (target.getHp() <= 0 && prevHp > 0) {
            System.out.println(target.name + " DIED!!!");
            handleDeath(target);
        }
        if (attacker.getHp() <= 0 && prevAttackerHp > 0) {
            System.out.println(attacker.name + " DIED!!!");
            handleDeath(attacker); //물대포 반사로 죽을 때 = 공격자가 죽을 수도 있으니 해당 로직을 추가함.
        }

        attacker.checkLevelUp();
        updateLevelLabels();
        updateHPBars();
        checkWinner();
    }

    private void handleHeal(Player player) {
        if (player.getHp() <= 0) return;
        player.healSkill();
        updateHPBars();
    }

    private Player getRandomTarget(Player attacker) {
        List<Player> aliveTargets = new ArrayList<>();
        for (Player p : players) {
            if (p != attacker && p.getHp() > 0) {
                aliveTargets.add(p);
            }
        }
        if (aliveTargets.isEmpty()) return null;
        return aliveTargets.get(rand.nextInt(aliveTargets.size()));
    }


    private void checkWinner() {
        List<Player> alive = new ArrayList<>();
        for (Player p : players) {
            if (p.getHp() > 0) alive.add(p);
        }

        if (alive.size() == 1) {
            System.out.println(alive.get(0).name + " win!!!");
            disableButtons();
        }
    }

    public JButton getAttackBtnFire() { return attackBtnFire; }
    public JButton getAttackBtnWater() { return attackBtnWater; }
    public JButton getAttackBtnEarth() { return attackBtnEarth; }

    public JButton getHealBtnFire() { return healingBtnFire; }
    public JButton getHealBtnWater() { return healingBtnWater; }
    public JButton getHealBtnEarth() { return healingBtnEarth; }

    public void updateHPBars() {
        hpBarFire.setValue(Math.max(p1.getHp(), 0));
        hpBarWater.setValue(Math.max(p2.getHp(), 0));
        hpBarEarth.setValue(Math.max(p3.getHp(), 0));
    }

    public void updateLevelLabels() {
        nameFire.setText(p1.name + " (Lv. " + p1.getLevel() + ")");
        nameWater.setText(p2.name + " (Lv. " + p2.getLevel() + ")");
        nameEarth.setText(p3.name + " (Lv. " + p3.getLevel() + ")");
    }

    public void handleDeath(Player player) {
        if (player == p1) {
            photoFire.setIcon(new ImageIcon(Battle.class.getResource("/image/죽은엠버.png")));
            attackBtnFire.setEnabled(false);
            healingBtnFire.setEnabled(false);
        } else if (player == p2) {
            photoWater.setIcon(new ImageIcon(Battle.class.getResource("/image/죽은웨이드.png")));
            attackBtnWater.setEnabled(false);
            healingBtnWater.setEnabled(false);
        } else if (player == p3) {
            photoEarth.setIcon(new ImageIcon(Battle.class.getResource("/image/죽은클로드.png")));
            attackBtnEarth.setEnabled(false);
            healingBtnEarth.setEnabled(false);
        }
    }

    public void disableButtons() {
        for (Component comp : contentPane.getComponents()) {
            if (comp instanceof JButton) {
                comp.setEnabled(false);
            }
        }
    }

}