package listener;

import GameWindos.ReadyFrame;
import config.Images;
import config.Music;
import util.SelectUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadyFrameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ReadyFrame ready = ReadyFrame.getInstance();
        SelectUtil su = new SelectUtil();
        JButton button = (JButton) e.getSource();
        new Music().Button(Music.button2);//添加按钮音效
        //按钮添加监听
        if (button == ready.ButtonP)
            su.intoTPZ(ready.ComboBoxP,ready.labelP, Images.labelP);


        if (button == ready.ButtonT)
            su.intoTPZ(ready.ComboBoxT,ready.labelT,Images.labelT);


        if (button == ready.ButtonZ)
            su.intoTPZ(ready.ComboBoxZ,ready.labelZ,Images.labelZ);


        if (button == ready.backButton)
            su.backInto();

        if (button == ready.confirmButton)
            su.confirmInto();

        if (button == ready.storeButton) {
            ready.panelStore();
            su.storeInto();
        }
        if (button == ready.storeBackButton)
            su.backInto();

        if (button == ready.hpButton)
            su.buyValue(1);

        if (button == ready.damageButton)
            su.buyValue(2);

        if (button == ready.speedButton)
            su.buyValue(3);

    }
}
