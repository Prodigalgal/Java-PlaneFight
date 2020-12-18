package GameWindos;

import config.Constant;
import config.Images;
import entity.user.User;
import flyingObjects.PlayerPlane;
import util.ReInitial;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    public int x = 800;
    public int y = 1080;
    public int times = 0;
    public int size = 60;
    public boolean isSuccess;
    private Image image;
    StarFrame star = StarFrame.getInstance();
    private ThreadOne One = new ThreadOne();

    public GameOver(boolean tag) {
        this.setLayout(null);
        this.setBounds(0, 0, Constant.WindowWidth, Constant.WindowHeight);
        this.setBackground(Color.BLACK);
        isSuccess = tag;
        One.start();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBufferedImage();
        g.drawImage(image, 0, 0, null);
    }

    private void drawBufferedImage() {

        image = createImage(this.getWidth(), 1080);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, image.getWidth(null), image.getHeight(null));
        g.setColor(Color.white);
        y -= 3;

        g.setFont(new Font("����", Font.BOLD, size));
        g.drawImage(Images.BackGround1,0,0,null);
        if(isSuccess)
            g.drawString("�ɹ���", x, y);
        else
            g.drawString("ʧ�ܣ�", x, y);
        g.setFont(new Font("����", Font.BOLD, size+5));
        g.drawString("��ң�" + User.user.getLoginName(), x-30, y + size+5);
        g.setFont(new Font("����", Font.BOLD, size+10));
        g.drawString("������" + PlayerPlane.pp.getScore(), x-60, y + ((size+10) * 2));
        g.setFont(new Font("����", Font.BOLD, size+15));
        g.drawString("������ά�����" , x-90, y + ((size+15) * 3));
        g.setFont(new Font("����", Font.BOLD, size+20));
        g.drawString("�߻���ά�����" , x-120, y + ((size+20) * 4));
        g.setFont(new Font("����", Font.BOLD, size+25));
        g.drawString("������ά�����" , x-150, y + ((size+25) * 5));
        g.setFont(new Font("����", Font.BOLD, size+30));
        g.drawString("����ά�����" , x-180, y + ((size+30) * 6));
        g.setFont(new Font("����", Font.BOLD, size+35));
        g.drawString("��Ч��ά�����" , x-210, y + ((size+35) * 7));
        g.setFont(new Font("����", Font.BOLD, size+40));
        g.drawString("������Ա��ά����ۣ���ة�࣬������," , x-340, y + ((size+40) * 8));
        g.drawString("DJε������ƤʿAJ���������ն�" , x-300, y + ((size+40) * 9));

        if(-700 > y) {
            g.setFont(new Font("����", Font.BOLD, 120));
            g.drawString("��Ϸ����",700,500);
        }


    }

    class ThreadOne extends Thread {
        @Override
        public void run() {
            if(0 == Constant.once) {
                while (-700 < y) {
                    times++;
                    repaint();
                    if (0 == times % 10)
                        size--;
                    try {
                        sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Constant.once = 1;
            repaint();
            JOptionPane.showMessageDialog(star, "���ַ�����" + PlayerPlane.pp.getScore(), "��Ϸ����", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("�������ֵ��" + PlayerPlane.pp.getHp() + " ��Ϸ������" + PlayerPlane.pp.getScore() + " " + "��Ϸ״̬��" + Constant.STATES);
            star.setStop();
            new ReInitial().reInitial();
        }
    }

}