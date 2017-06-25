package com.handy.frame.design.adapter;

import javax.swing.table.AbstractTableModel;

/**
 * @author longhairen
 * @create 2017-06-25 15:44
 * @description
 **/
public class RocketTable extends AbstractTableModel {
    protected Rocket[] rockets;
    protected String[] columnNames = new String[]{"Name","Price","Apogee"};

    public RocketTable(Rocket[] rockets){
        this.rockets = rockets;
    }

    @Override
    public int getRowCount() {
        return rockets.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return rockets[rowIndex].getName();
            case 1:
                return rockets[rowIndex].getPrice();
            case 2:
                return rockets[rowIndex].getApogee();
            default:
                return null;
        }
    }
}
