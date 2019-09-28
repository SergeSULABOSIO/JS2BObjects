/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author HP Pavilion
 */
public class GestionClickDroit {

    public JPopupMenu menuContextuel;
    public JTable table;
    public JScrollPane scrollPane;

    public GestionClickDroit(JPopupMenu menuContextuel, JTable table, JScrollPane scrollPane) {
        this.menuContextuel = menuContextuel;
        this.table = table;
        this.scrollPane = scrollPane;
    }

    public void init() {
        ecouterClicDroitTable();
    }

    private void doPop(MouseEvent e) {
        /*
        if (table != null) {
            if (table.getSelectedRowCount() == 0) {
                return;
            }
        }
        */
        
        if (menuContextuel != null) {
            menuContextuel.setVisible(true);
            menuContextuel.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    private void hidePop() {
        if (menuContextuel != null) {
            menuContextuel.setVisible(false);
        }
    }

    private void handleRowClick(MouseEvent e) {
        if (table != null) {
            ListSelectionModel selectionModel = table.getSelectionModel();
            Point contextMenuOpenedAt = e.getPoint();
            int clickedRow = table.rowAtPoint(contextMenuOpenedAt);
            if (clickedRow < 0) {
                selectionModel.clearSelection();
            } else {
                if ((e.getModifiers() & InputEvent.SHIFT_MASK) == InputEvent.SHIFT_MASK) {
                    int maxSelect = selectionModel.getMaxSelectionIndex();
                    if ((e.getModifiers() & InputEvent.CTRL_MASK) == InputEvent.CTRL_MASK) {
                        selectionModel.addSelectionInterval(maxSelect, clickedRow);
                    } else {
                        selectionModel.setSelectionInterval(maxSelect, clickedRow);
                    }
                } else if ((e.getModifiers() & InputEvent.CTRL_MASK) == InputEvent.CTRL_MASK) {
                    selectionModel.addSelectionInterval(clickedRow, clickedRow);
                } else {
                    selectionModel.setSelectionInterval(clickedRow, clickedRow);
                }
            }
        }

    }

    public void ecouterClicDroitTable() {
        if (table != null) {
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    handleRowClick(e);
                    if (e.isPopupTrigger()) {
                        doPop(e);
                    } else {
                        hidePop();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        doPop(e);
                    }
                }
            });
        }

        if (scrollPane != null) {
            scrollPane.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        doPop(e);
                    } else {
                        hidePop();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        doPop(e);
                    }
                }

            });
        }
    }

}
