package thread;

import config.Constant;
import util.PaintPanelUtil;

public class PaintUtilsThread extends Thread{

    PaintPanelUtil paint = PaintPanelUtil.getInstance();

    public void PaintThread(){
        paint.repaint();
    }

    @Override
    public void run() {
        while(Constant.STATES == Constant.STAR){
            PaintThread();
            try {
                sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
