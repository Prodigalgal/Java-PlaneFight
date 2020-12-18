package config;

import entity.Planes.ProtossPlanes.Phoenix;
import entity.Planes.ProtossPlanes.Tempest;
import entity.Planes.terranPlanes.Battlecruiser;
import entity.Planes.terranPlanes.Viking;
import entity.Planes.zergPlanes.Corruptor;
import entity.Planes.zergPlanes.Mutalisk;
import entity.user.User;

public class Constant {

    public static boolean UP = false;//�ƶ��ж�
    public static boolean DOWN = false;//�ƶ��ж�
    public static boolean LEFT = false;//�ƶ��ж�
    public static boolean RIGHT = false;//�ƶ��ж�

    public final static int NormalBullet = 0;//��ͨ�ӵ�
    public final static int SpecialBullet = 1;//��ը�ӵ�

    public final static int LEFT45B = 1;//�ӵ�����
    public final static int LEFT30B = 2;//�ӵ�����
    public final static int CENTERB = 3;//�ӵ�����
    public final static int RIGHT30B = 4;//�ӵ�����
    public final static int RIGHT45B = 5;//�ӵ�����

    public final static int directUR = 1;//�ɻ�����λ��
    public final static int directUL = 2;//�ɻ�����λ��
    public final static int directDL = 3;
    public final static int directDR = 4;
    public final static int directC = 0;//�ɻ�����λ��

    public static final int STAR = 2;//��ʼ
    public static final int DEAD = 3;//����
    public static int STATES = DEAD;//Ĭ��״̬

    public static boolean BossCome = false;//boss���ֱ��
    public static final int BossComeScore = 2000;//boss����ʱ����
    public static final int BossLevelUp = 1500;//boss�����ڶ����ģʽ
    public static final int LEVEL2 = 100;//�ڶ�������
    public static final int LEVEL3 = 200;//�ڶ�������
    public static final int BossHP = 3000;//BossѪ��

    public static final int WindowWidth = 1850;//���ڴ�С
    public static final int WindowHeight = 1080;//���ڴ�С

    public static final int EnemiesDamage = 2;
    public static int BulletDamage;
    public static int FireModel = 1;//���Ĭ�Ϸ���ģʽ
    public static int FireModelA = 1;//��ҷ���ģʽA
    public static int FireModelB = 2;//��ҷ���ģʽB
    public static int FireModelC = 3;//��ҷ���ģʽC
    public static int FireModelD = 4;//��ҷ�ɫģʽD


    public final static int VikingSpeed = 10;
    public final static int BattlecruiserSpeed = 20;
    public final static int PhoenixSpeed = 10;
    public final static int TempestSpeed = 20;
    public final static int CorruptorSpeed = 20;
    public final static int MutaliskSpeed = 10;

    public final static int SEUNLockLocation = 0;
    public final static int SELockLocation = 1;

    public static int once = 0;//����һ����Ϸ��ֻ��һ�ι�������

    //���³�ʼ��
    public void reInitial(){
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        BossCome = false;
        STATES = DEAD;
        BulletDamage = 2 + User.user.getPlaneDamage();
        FireModel = FireModelA;
        Viking.viking.setSpeed(VikingSpeed);
        Battlecruiser.battlecruiser.setSpeed(BattlecruiserSpeed);
        Phoenix.phoenix.setSpeed(PhoenixSpeed);
        Corruptor.corruptor.setSpeed(CorruptorSpeed);
        Mutalisk.mutalisk.setSpeed(MutaliskSpeed);
        Tempest.tempest.setSpeed(TempestSpeed);
    }

}
