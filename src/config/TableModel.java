package config;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;//��ѡ�в��ɱ༭
    }

}
