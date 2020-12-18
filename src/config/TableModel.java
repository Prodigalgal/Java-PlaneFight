package config;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;//可选中不可编辑
    }

}
