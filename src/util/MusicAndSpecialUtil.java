package util;

import GameWindos.ReadyFrame;
import config.Music;
import flyingObjects.SpecialEffects;
import thread.MusicThread;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MusicAndSpecialUtil {

    public void musicPlayAndSpecialAdd(int x, int y, Image image, int id) {
        new MusicThread().Boom.start();//���Ż�����Ч
        new SpecialEffectsUtil().addSpecialEffects(new SpecialEffects(x, y, image, id));//��ը��Ч
    }

    //��һ��BGM
    public void nextMusic() {
        stopMusic();//��ֹͣ���ţ�����tag
        if (MusicThread.tag >= Music.filesLength) MusicThread.tag = 0;//����ǵ���BGM����ʱ�����ص�һ��
        else MusicThread.tag++;
        starMusic();//tag����������ʼ����
    }

    //��������BGM
    public void stopMusic() {
        if (Music.isStar) {
            Music.clip.flush();
            Music.clip.close();
            Music.isStar = false;//�������Ϊfalse
            new MusicThread().BK.interrupt();
        }
    }

    //��ʼ����BGM
    public void starMusic() {
        MusicThread mt = new MusicThread();
        if (!Music.isStar)//���������ڲ��ţ�����Ӧ
            mt.BK.start();
    }

    //���BGM
    public void addBGM() {
        boolean isSave = true;
        ReadyFrame ready = ReadyFrame.getInstance();
        JFileChooser fileChooser = creatFileChooser();
        int result = fileChooser.showOpenDialog(ready);
        if (result == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();//��ȡѡ���ļ�
            String saveName = saveFile.getName();
            String suffix = saveFile.getName().substring(saveFile.getName().lastIndexOf("."));//��ȡ��׺��
            if(".wav".equals(suffix)) {
                for (File f : Music.filesBGM) {//�ж��Ƿ�����
                    if (saveName.equals(f.getName())) {
                        JOptionPane.showMessageDialog(ready, "������������ͬ��", "������ʾ", JOptionPane.OK_OPTION);
                        isSave = false;
                        break;//ͬ����ֱ����������ֹ��ԭ����������ͬ���������������ζԻ���
                    }
                }
                if (isSave) {
                    try {
                        Files.copy(saveFile.toPath(), new File("src/source/musics/bgm/" + saveFile.getName()).toPath());//Files���Դ��ĸ��Ʒ�����Դ�ļ�·����Ŀ���ļ�·��������ǰΪĿ���ļ�·�����ϱ��
                        new Music().RefreshLength();//���³���
                        JOptionPane.showMessageDialog(ready, "��ӳɹ����ɲ��ţ�", "������ʾ", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else JOptionPane.showMessageDialog(ready,"ֻ�����.wav�ļ���","������ʾ",JOptionPane.OK_OPTION);

        }
    }

    //ɾ��BGM
    public void deleteBGM() {
        ReadyFrame ready = ReadyFrame.getInstance();
        JFileChooser fileChooser = creatFileChooser();
        fileChooser.setApproveButtonText("ɾ��");//����ѡ��ť�ı�Ϊɾ��
        int result = fileChooser.showOpenDialog(ready);
        if (Music.filesLength == 0)
            JOptionPane.showMessageDialog(ready, "���һ�ײ���ɾ����", "������ʾ", JOptionPane.OK_OPTION);
        else {
            if (result == JFileChooser.APPROVE_OPTION) {
                File deleteFile = fileChooser.getSelectedFile();//��ȡѡ�е��ļ�
                String suffix = deleteFile.getName().substring(deleteFile.getName().lastIndexOf("."));//��ȡ��׺��
                if (".wav".equals(suffix)) {
                    deleteFile.delete();//ɾ��
                    new Music().RefreshLength();//ˢ��BGM
                    JOptionPane.showMessageDialog(ready, "ɾ���ɹ���", "������ʾ", JOptionPane.INFORMATION_MESSAGE);
                } else JOptionPane.showMessageDialog(ready, "ɾ��ʧ�ܣ�ֻ��ɾ��.wav�ļ�", "������ʾ", JOptionPane.OK_OPTION);
            }
        }

    }

    //�ڲ�����������һ��JFileChooser
    private JFileChooser creatFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("D:\\CodeWork\\Java\\SC2PlaneFight\\src\\source\\musics\\bgm"));//����Ĭ����ʾΪ��ǰ�ļ���
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//ֻ��ѡ�ļ�
        fileChooser.setMultiSelectionEnabled(false);//�������ѡ
        fileChooser.setFileFilter(new FileNameExtensionFilter("wav(*.wav)", "wav"));
        return fileChooser;
    }

}
