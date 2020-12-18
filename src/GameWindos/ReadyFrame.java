package GameWindos;

import config.FontsAndColors;
import config.Images;
import config.TableModel;
import entity.Planes.ProtossPlanes.Phoenix;
import entity.Planes.ProtossPlanes.Tempest;
import entity.Planes.terranPlanes.Battlecruiser;
import entity.Planes.terranPlanes.Viking;
import entity.Planes.zergPlanes.Corruptor;
import entity.Planes.zergPlanes.Mutalisk;
import entity.user.User;
import flyingObjects.PlayerPlane;
import listener.ReadyFrameListener;
import listener.ReadyMenuBarListener;
import service.UserService;

import javax.swing.*;
import java.util.Map;

public class ReadyFrame extends WorkFrame {

    public JPanel initialPanel;
    public JPanel panelTPZ;
    public JPanel panelStore;
    public JButton ButtonP;
    public JButton ButtonT;
    public JButton ButtonZ;
    public JButton confirmButton;
    public JButton backButton;
    public JButton storeBackButton;
    public JButton storeButton;
    public JButton damageButton;
    public JButton speedButton;
    public JButton hpButton;
    public JComboBox<PlayerPlane> ComboBoxT;
    public JComboBox<PlayerPlane> ComboBoxP;
    public JComboBox<PlayerPlane> ComboBoxZ;
    public PlayerPlane[] objectT = {Viking.viking, Battlecruiser.battlecruiser};
    public PlayerPlane[] objectP = {Tempest.tempest, Phoenix.phoenix};
    public PlayerPlane[] objectZ = {Mutalisk.mutalisk, Corruptor.corruptor};
    private JMenuBar normalMenuBar;
    private JMenu backMenu;
    private JMenu UserMenu;
    private JMenu helpMenu;
    private JMenu MusicMenu;
    private JLabel label1;//����
    public JLabel label2;//����
    public JLabel label3;//����
    public JLabel labelT;//��������
    public JLabel labelZ;//��������
    public JLabel labelP;//��������
    public JLabel labelX;//��¼�ϴε�label
    public JLabel labelMoney;//�̳���ʾ�û���Ǯ
    public JMenuItem backMI;
    public JMenuItem selectScoreMI;
    public JMenuItem modifyPasswordMI;
    public JMenuItem modifyLoginNameMI;
    public JMenuItem deleteUser;
    public JMenuItem selectMoneyMI;
    public JMenuItem helpMI;
    public JMenuItem starMusicMI;
    public JMenuItem stopMusicMI;
    public JMenuItem nextMusicBGMMI;
    public JMenuItem addBGMMI;
    public JMenuItem deleteBGMMI;
    public JMenuItem tableMI;
    public JComboBox<PlayerPlane> comboBox;
    public JDialog dialog;
    public JDialog tableDialog;
    public JTable table;

    private static ReadyFrame instance;

    public ReadyFrame() {
        initialPanel = new JPanel();
        panelTPZ = new JPanel();
        panelStore = new JPanel();
        ComboBoxT = new JComboBox<>();
        ComboBoxP = new JComboBox<>();
        ComboBoxZ = new JComboBox<>();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        ButtonT = new JButton();
        ButtonP = new JButton();
        ButtonZ = new JButton();
        backButton = new JButton();
        confirmButton = new JButton();
        damageButton = new JButton();
        speedButton = new JButton();
        hpButton = new JButton();
        storeButton = new JButton();
        storeBackButton = new JButton();
        labelP = new JLabel(FontsAndColors.sP);
        labelT = new JLabel(FontsAndColors.sT);
        labelZ = new JLabel(FontsAndColors.sZ);

        for (PlayerPlane pp4 : objectT) {
            ComboBoxT.addItem(pp4);
        }
        for (PlayerPlane pp4 : objectP) {
            ComboBoxP.addItem(pp4);
        }
        for (PlayerPlane pp4 : objectZ) {
            ComboBoxZ.addItem(pp4);
        }
        inIt();
    }

    public void inIt() {
        initialPanel.setLayout(null);
        this.setBounds(550, 150, 720, 720);
        this.setTitle("SC2 Ready");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        label1.setIcon(new ImageIcon(Images.readyBackGround));
        label1.setBounds(0, 0, 720, 720);
        ButtonZ.setBounds(120, 220, 100, 60);
        ButtonP.setBounds(310, 220, 100, 60);
        ButtonT.setBounds(500, 220, 100, 60);
        storeButton.setBounds(120, 320, 100, 104);
        ButtonT.setIcon(new ImageIcon(Images.T));
        ButtonP.setIcon(new ImageIcon(Images.P));
        ButtonZ.setIcon(new ImageIcon(Images.Z));
        storeButton.setIcon(new ImageIcon(Images.storeB));
        storeButton.setToolTipText("�����̳�");
        storeButton.setBorder(null);
        storeButton.setBorderPainted(false);
        storeButton.setContentAreaFilled(false);
        ButtonZ.setToolTipText("ѡ�����");
        ButtonZ.setBorder(null);
        ButtonZ.setBorderPainted(false);
        ButtonZ.setContentAreaFilled(false);
        ButtonT.setToolTipText("ѡ������");
        ButtonT.setBorder(null);
        ButtonT.setBorderPainted(false);
        ButtonT.setContentAreaFilled(false);
        ButtonP.setToolTipText("ѡ������");
        ButtonP.setBorder(null);
        ButtonP.setBorderPainted(false);
        ButtonP.setContentAreaFilled(false);
        ButtonZ.setFocusPainted(false);
        ComboBoxT.setBounds(270, 150, 150, 40);
        ComboBoxP.setBounds(270, 150, 150, 40);
        ComboBoxZ.setBounds(270, 150, 150, 40);
        labelZ.setBounds(190,250,370,300);
        labelT.setBounds(190,250,370,300);
        labelP.setBounds(190,250,370,300);
        labelX = labelZ;//Ĭ��ָ��Z
        initialPanel.add(ButtonP);
        initialPanel.add(ButtonT);
        initialPanel.add(ButtonZ);
        initialPanel.add(storeButton);
        initialPanel.add(label1);
        this.add(initialPanel);
        comboBox = ComboBoxT;//��¼�ϴ�Box����ɾ����Ĭ��ΪBoxT
        MenuBar();//��ʼ��������
        actionListener();//ע�����
        panelTPZ();//��ʼ��ѡ���������
    }

    //������
    public void MenuBar() {
        tableMI = new JMenuItem("���а�");
        backMI = new JMenuItem("���ص�½");
        modifyLoginNameMI = new JMenuItem("�޸��˺���");
        modifyPasswordMI = new JMenuItem("�޸�����");
        deleteUser = new JMenuItem("ע���˺�");
        selectScoreMI = new JMenuItem("��ѯ��߷�");
        selectMoneyMI = new JMenuItem("��ѯǮǮ");
        helpMI = new JMenuItem("����");
        stopMusicMI = new JMenuItem("ֹͣ����");
        starMusicMI = new JMenuItem("��ʼ����");
        nextMusicBGMMI = new JMenuItem("��һ��");
        addBGMMI = new JMenuItem("��ӱ�������");
        deleteBGMMI = new JMenuItem("ɾ����������");
        normalMenuBar = new JMenuBar();
        backMenu = new JMenu("����");
        UserMenu = new JMenu("�û�");
        helpMenu = new JMenu("����");
        MusicMenu = new JMenu("����");
        MusicMenu.add(starMusicMI);
        MusicMenu.add(stopMusicMI);
        MusicMenu.add(nextMusicBGMMI);
        MusicMenu.insertSeparator(3);
        MusicMenu.add(addBGMMI);
        MusicMenu.add(deleteBGMMI);
        backMenu.add(backMI);
        UserMenu.add(modifyLoginNameMI);
        UserMenu.add(modifyPasswordMI);
        UserMenu.add(deleteUser);
        UserMenu.insertSeparator(4);
        UserMenu.add(selectMoneyMI);
        UserMenu.add(selectScoreMI);
        UserMenu.insertSeparator(6);
        UserMenu.add(tableMI);
        helpMenu.add(helpMI);
        backMenu.setToolTipText("���ص�½����");
        UserMenu.setToolTipText("�û�����");
        helpMenu.setToolTipText("�������");
        starMusicMI.setToolTipText("��ʼ���ű�������");
        stopMusicMI.setToolTipText("ֹͣ���ű�������");
        nextMusicBGMMI.setToolTipText("��һ�ױ�������");
        deleteBGMMI.setToolTipText("ɾ��һ�ױ�������");
        addBGMMI.setToolTipText("�������BGM");
        normalMenuBar.add(UserMenu);
        normalMenuBar.add(backMenu);
        normalMenuBar.add(helpMenu);
        normalMenuBar.add(MusicMenu);
        this.setJMenuBar(normalMenuBar);
    }

    //ѡ�����
    public void panelTPZ() {
        panelTPZ.setLayout(null);

        label2.setBounds(0, 0, 720, 720);
        confirmButton.setBounds(180, 250, 170, 60);
        backButton.setBounds(400, 250, 170, 60);

        confirmButton.setIcon(new ImageIcon(Images.FlyStar));
        confirmButton.setToolTipText("��ʼ��Ϸ");
        backButton.setIcon(new ImageIcon(Images.Back));
        backButton.setToolTipText("����ѡ���������");

        confirmButton.setBorder(null);
        confirmButton.setBorderPainted(false);
        confirmButton.setContentAreaFilled(false);
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);

        labelP.setFont(FontsAndColors.font);
        labelP.setForeground(FontsAndColors.cP);
        labelZ.setFont(FontsAndColors.font);
        labelZ.setForeground(FontsAndColors.cZ);
        labelT.setFont(FontsAndColors.font);
        labelT.setForeground(FontsAndColors.cT);

        panelTPZ.add(confirmButton);
        panelTPZ.add(backButton);
    }

    //������ʾ
    public void helpDialog() {
        dialog = new JDialog(this, "����", true);
        dialog.setSize(450, 350);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(this);
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        String s = "<html><body>" + "�ĸ�����������ƶ�" + "<br>" + "<br>" + "��Ϸ����������ȶ�ת��Ϊ���" + "<br>" + "<br>" + " ��Ϸ�����������߻��л������˺����ٶȡ�����" + "<body></html>";
        label.setText(s);
        JButton button = new JButton("�ر�");
        button.addActionListener(e -> dialog.dispose());
        button.setBounds(170, 250, 100, 50);
        label.setBounds(20, 20, 400, 150);
        panel.setLayout(null);
        panel.add(button);
        panel.add(label);
        dialog.add(panel);
    }

    //���а����
    public void tableDialog() {
        tableDialog = new JDialog(this, "���а�", true);
        tableDialog.setSize(450, 350);
        tableDialog.setResizable(false);
        tableDialog.setLocationRelativeTo(this);
        String[] columnNames = {"�ǳ�","����"};//��������
        TableModel model = new TableModel();//����ģ��
        model.setColumnIdentifiers(columnNames);//��������
        table = new JTable(model);//��ʼ�������ģ��
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//����ֻ��ѡ��һ��
        JScrollPane scrollPane = new JScrollPane(table);//��ӹ�����
        tableDialog.add(scrollPane);//��ӽ�dialog
        Map<Integer , User> map = new UserService().TableSearch();//��ȡ����Դ
        for (int i = 0; i < map.size(); i++) {
            String[] row = {map.get(i).getLoginName(), String.valueOf(map.get(i).getUserScore())};
            model.addRow(row);//д������
        }
    }

    //�̳ǽ���
    public void panelStore() {
        panelStore.setLayout(null);
        labelMoney = new JLabel("���Ľ�ң�" + User.user.getMoney());
        labelMoney.setForeground(FontsAndColors.store);
        label3.setIcon(new ImageIcon(Images.storeBackground));
        label3.setBounds(0, 0, 720, 720);
        labelMoney.setBounds(100, 50, 800, 80);
        speedButton.setBounds(100, 150, 80, 80);
        damageButton.setBounds(270, 150, 80, 80);
        hpButton.setBounds(440, 150, 80, 80);
        storeBackButton.setBounds(55, 260, 170, 117);
        damageButton.setToolTipText("�����ӵ�һ���˺�");
        hpButton.setToolTipText("���ӷɻ�һ������ֵ");
        speedButton.setToolTipText("���ӷɻ�һ���ƶ��ٶ�");
        damageButton.setIcon(new ImageIcon(Images.damageB));
        damageButton.setBorder(null);
        damageButton.setBorderPainted(false);
        damageButton.setContentAreaFilled(false);
        hpButton.setIcon(new ImageIcon(Images.HpB));
        hpButton.setBorder(null);
        hpButton.setBorderPainted(false);
        hpButton.setContentAreaFilled(false);
        speedButton.setIcon(new ImageIcon(Images.speedB));
        speedButton.setBorder(null);
        speedButton.setBorderPainted(false);
        speedButton.setContentAreaFilled(false);
        storeBackButton.setIcon(new ImageIcon(Images.storeBack));
        storeBackButton.setBorder(null);
        storeBackButton.setBorderPainted(false);
        storeBackButton.setContentAreaFilled(false);
        panelStore.add(storeBackButton);
        panelStore.add(speedButton);
        panelStore.add(damageButton);
        panelStore.add(hpButton);
        panelStore.add(labelMoney);
        panelStore.add(label3);
    }

    public static ReadyFrame getInstance() {
        if (null == instance) {
            instance = new ReadyFrame();
        }
        return instance;
    }

    public void actionListener() {
        ReadyFrameListener readyFrameListener = new ReadyFrameListener();
        ReadyMenuBarListener readyMenuBarListener = new ReadyMenuBarListener();
        ButtonP.addActionListener(readyFrameListener);
        ButtonT.addActionListener(readyFrameListener);
        ButtonZ.addActionListener(readyFrameListener);
        storeButton.addActionListener(readyFrameListener);
        confirmButton.addActionListener(readyFrameListener);
        backButton.addActionListener(readyFrameListener);
        storeBackButton.addActionListener(readyFrameListener);
        damageButton.addActionListener(readyFrameListener);
        speedButton.addActionListener(readyFrameListener);
        hpButton.addActionListener(readyFrameListener);
        backMI.addActionListener(readyMenuBarListener);
        modifyPasswordMI.addActionListener(readyMenuBarListener);
        modifyLoginNameMI.addActionListener(readyMenuBarListener);
        deleteUser.addActionListener(readyMenuBarListener);
        selectScoreMI.addActionListener(readyMenuBarListener);
        selectMoneyMI.addActionListener(readyMenuBarListener);
        helpMI.addActionListener(readyMenuBarListener);
        starMusicMI.addActionListener(readyMenuBarListener);
        stopMusicMI.addActionListener(readyMenuBarListener);
        nextMusicBGMMI.addActionListener(readyMenuBarListener);
        addBGMMI.addActionListener(readyMenuBarListener);
        deleteBGMMI.addActionListener(readyMenuBarListener);
        tableMI.addActionListener(readyMenuBarListener);
    }

}
