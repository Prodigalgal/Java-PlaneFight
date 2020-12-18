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
        new MusicThread().Boom.start();//播放击中音效
        new SpecialEffectsUtil().addSpecialEffects(new SpecialEffects(x, y, image, id));//爆炸特效
    }

    //下一首BGM
    public void nextMusic() {
        stopMusic();//先停止播放，增加tag
        if (MusicThread.tag >= Music.filesLength) MusicThread.tag = 0;//当标记到达BGM首数时，返回第一首
        else MusicThread.tag++;
        starMusic();//tag操作结束后开始播放
    }

    //结束播放BGM
    public void stopMusic() {
        if (Music.isStar) {
            Music.clip.flush();
            Music.clip.close();
            Music.isStar = false;//将标记设为false
            new MusicThread().BK.interrupt();
        }
    }

    //开始播放BGM
    public void starMusic() {
        MusicThread mt = new MusicThread();
        if (!Music.isStar)//若音乐已在播放，则不响应
            mt.BK.start();
    }

    //添加BGM
    public void addBGM() {
        boolean isSave = true;
        ReadyFrame ready = ReadyFrame.getInstance();
        JFileChooser fileChooser = creatFileChooser();
        int result = fileChooser.showOpenDialog(ready);
        if (result == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();//获取选中文件
            String saveName = saveFile.getName();
            String suffix = saveFile.getName().substring(saveFile.getName().lastIndexOf("."));//获取后缀名
            if(".wav".equals(suffix)) {
                for (File f : Music.filesBGM) {//判断是否重名
                    if (saveName.equals(f.getName())) {
                        JOptionPane.showMessageDialog(ready, "音乐名不能相同！", "操作提示", JOptionPane.OK_OPTION);
                        isSave = false;
                        break;//同名后直接跳出，防止若原本就有俩首同名歌曲，跳出俩次对话框
                    }
                }
                if (isSave) {
                    try {
                        Files.copy(saveFile.toPath(), new File("src/source/musics/bgm/" + saveFile.getName()).toPath());//Files类自带的复制方法，源文件路径，目标文件路径，复制前为目标文件路径打上标号
                        new Music().RefreshLength();//更新长度
                        JOptionPane.showMessageDialog(ready, "添加成功，可播放！", "操作提示", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else JOptionPane.showMessageDialog(ready,"只能添加.wav文件！","操作提示",JOptionPane.OK_OPTION);

        }
    }

    //删除BGM
    public void deleteBGM() {
        ReadyFrame ready = ReadyFrame.getInstance();
        JFileChooser fileChooser = creatFileChooser();
        fileChooser.setApproveButtonText("删除");//设置选择按钮文本为删除
        int result = fileChooser.showOpenDialog(ready);
        if (Music.filesLength == 0)
            JOptionPane.showMessageDialog(ready, "最后一首不可删除！", "操作提示", JOptionPane.OK_OPTION);
        else {
            if (result == JFileChooser.APPROVE_OPTION) {
                File deleteFile = fileChooser.getSelectedFile();//获取选中的文件
                String suffix = deleteFile.getName().substring(deleteFile.getName().lastIndexOf("."));//获取后缀名
                if (".wav".equals(suffix)) {
                    deleteFile.delete();//删除
                    new Music().RefreshLength();//刷新BGM
                    JOptionPane.showMessageDialog(ready, "删除成功！", "操作提示", JOptionPane.INFORMATION_MESSAGE);
                } else JOptionPane.showMessageDialog(ready, "删除失败，只能删除.wav文件", "操作提示", JOptionPane.OK_OPTION);
            }
        }

    }

    //内部方法，创建一个JFileChooser
    private JFileChooser creatFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("D:\\CodeWork\\Java\\SC2PlaneFight\\src\\source\\musics\\bgm"));//设置默认显示为当前文件夹
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//只能选文件
        fileChooser.setMultiSelectionEnabled(false);//不允许多选
        fileChooser.setFileFilter(new FileNameExtensionFilter("wav(*.wav)", "wav"));
        return fileChooser;
    }

}
