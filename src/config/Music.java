package config;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music {
    public static String button1;
    public static String button2;
    public static String BackGround;
    public static Clip clip;
    public static int filesLength;
    public static File[] filesBGM;//��BGM�ļ����µ��ļ��г�
    public static boolean isStar = false;//�ж������Ƿ�ʼ����

    static {
        button1 = "src/source/musics/button/Button1.mp3";
        button2 = "src/source/musics/button/Button2.mp3";
        BackGround = "src/source/musics/bgm/live.wav";
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        filesBGM = new File("src/source/musics/bgm").listFiles();
        filesLength = filesBGM.length - 1;//��Ŵ�0��ʼ�����Լ�һ
    }

    public void OpenFire() {
        Player player;
        try {
            BufferedInputStream Fire;
            Fire = new BufferedInputStream(new FileInputStream("src/source/musics/fire/Fire.mp3"));
            player = new Player(Fire);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void Boom() {
        Player player;
        try {
            BufferedInputStream boom;
            boom = new BufferedInputStream(new FileInputStream("src/source/musics/boom/Boom.mp3"));
            player = new Player(boom);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void Button(String path) {
        Player player;
        try {
            BufferedInputStream Fire;
            Fire = new BufferedInputStream(new FileInputStream(path));
            player = new Player(Fire);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }


    public void playBackgroundMusic(int tag) {
        try {
            isStar = true;
            clip.open(AudioSystem.getAudioInputStream(filesBGM[tag]));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RefreshLength() {
        filesBGM = new File("src/source/musics/bgm").listFiles();//����
        filesLength = filesBGM.length - 1;//��ֵ
    }

    public static void main(String[] args) {

    }

}