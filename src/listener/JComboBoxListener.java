package listener;

import flyingObjects.PlayerPlane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxListener implements ActionListener {
    //ѡ��ɻ�
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JComboBox){
            JComboBox comboBox = (JComboBox)e.getSource();
            PlayerPlane.pp = (PlayerPlane) comboBox.getSelectedItem();
            System.out.println(PlayerPlane.pp.getName());
        }
    }
}
