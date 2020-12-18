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

        g.setFont(new Font("宋体", Font.BOLD, size));
        g.drawImage(Images.BackGround1,0,0,null);
        if(isSuccess)
            g.drawString("成功！", x, y);
        else
            g.drawString("失败！", x, y);
        g.setFont(new Font("宋体", Font.BOLD, size+5));
        g.drawString("玩家：" + User.user.getLoginName(), x-30, y + size+5);
        g.setFont(new Font("宋体", Font.BOLD, size+10));
        g.drawString("分数：" + PlayerPlane.pp.getScore(), x-60, y + ((size+10) * 2));
        g.setFont(new Font("宋体", Font.BOLD, size+15));
        g.drawString("制作：维京大帝" , x-90, y + ((size+15) * 3));
        g.setFont(new Font("宋体", Font.BOLD, size+20));
        g.drawString("策划：维京大帝" , x-120, y + ((size+20) * 4));
        g.setFont(new Font("宋体", Font.BOLD, size+25));
        g.drawString("美术：维京大帝" , x-150, y + ((size+25) * 5));
        g.setFont(new Font("宋体", Font.BOLD, size+30));
        g.drawString("程序：维京大帝" , x-180, y + ((size+30) * 6));
        g.setFont(new Font("宋体", Font.BOLD, size+35));
        g.drawString("音效：维京大帝" , x-210, y + ((size+35) * 7));
        g.setFont(new Font("宋体", Font.BOLD, size+40));
        g.drawString("测试人员：维京大帝，柱丞相，亮晶晶," , x-340, y + ((size+40) * 8));
        g.drawString("DJ蔚蓝，嬉皮士AJ，龙岩王赫尔" , x-300, y + ((size+40) * 9));

        if(-700 > y) {
            g.setFont(new Font("宋体", Font.BOLD, 120));
            g.drawString("游戏结束",700,500);
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
            JOptionPane.showMessageDialog(star, "本局分数：" + PlayerPlane.pp.getScore(), "游戏结束", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("玩家生命值：" + PlayerPlane.pp.getHp() + " 游戏分数：" + PlayerPlane.pp.getScore() + " " + "游戏状态：" + Constant.STATES);
            star.setStop();
            new ReInitial().reInitial();
        }
    }

}