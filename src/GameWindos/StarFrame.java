package GameWindos;

import config.Constant;
import listener.ControlListener;
import thread.*;
import util.PaintPanelUtil;

import javax.swing.*;

public class StarFrame extends WorkFrame {

    private final PaintUtilsThread PTU = new PaintUtilsThread();
    private final PlayerThread PLT = new PlayerThread();
    private final CheckUtilThread CUT = new CheckUtilThread();
    private final EnemiesThread ET = new EnemiesThread();
    private final BossThread BT = new BossThread();
    private final PropThread PT = new PropThread();

    private static StarFrame instance;
    private PaintPanelUtil paint = PaintPanelUtil.getInstance();

    private StarFrame() {
        this.setTitle("SC2 Fight");
        this.setBounds(0, 0, Constant.WindowWidth, Constant.WindowHeight);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(paint);
        this.setResizable(false);
        addKeyListener();
    }

    //游戏开始启动线程
    public void setStar() {
        PTU.start();
        PLT.start();
        ET.start();
        CUT.start();
        PT.start();
    }

    //游戏结束关闭线程
    public void setStop() {
        PTU.interrupt();
        PLT.interrupt();
        ET.interrupt();
        CUT.interrupt();
        BT.interrupt();
        PT.interrupt();
    }

    //Boss线程启动
    public void StarBoss(){
        BT.start();
    }

    public static StarFrame getInstance() {
        if (null == instance) {
            instance = new StarFrame();
        }
        return instance;
    }

    public void addKeyListener() {
        ControlListener controlListener = new ControlListener();
        this.addKeyListener(controlListener);
    }

    //重新初始化
    public void reInitial() {
        instance = new StarFrame();
    }

}
