package thread;

import config.Music;

public class MusicThread {

    private static final Music mu = new Music();

    public static int tag = 0;//标记第几首BGM

    public  Thread BK = new Thread(() -> mu.playBackgroundMusic(tag));

    public  Thread Boom = new Thread(mu::Boom);

    public  Thread Fire = new Thread(mu::OpenFire);

}
