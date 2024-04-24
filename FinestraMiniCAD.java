import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FinestraMiniCAD extends JFrame implements ActionListener
{
    CommandPanel JPCommand;
    DrawPanel JPDraw;
    DrawOptionPanel JPOption;
    SidePanel JPSidePanel;
    LowerPanel JPLower;
    Container contents;
    Color selectedColor;
    public FinestraMiniCAD()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setLayout(new BorderLayout());
        JPCommand=new CommandPanel();
        JPDraw=new DrawPanel();
        JPOption= new DrawOptionPanel();
        JPSidePanel=new SidePanel();
        JPLower=new LowerPanel();
        contents=getContentPane();
        contents.setLayout(new BorderLayout());
        contents.add(JPCommand, BorderLayout.NORTH);
        contents.add(JPDraw, BorderLayout.CENTER);
        contents.add(JPOption, BorderLayout.EAST);
        contents.add(JPSidePanel, BorderLayout.WEST);
        contents.add(JPLower, BorderLayout.SOUTH);
        JPCommand.JBCursor.addActionListener(this);
        JPCommand.JBline.addActionListener(this);
        JPCommand.JBcircle.addActionListener(this);
        JPCommand.JBrectangle.addActionListener(this);
        JPCommand.JBpoint.addActionListener(this);
        JPCommand.JBselectColor.addActionListener(this);
        JPCommand.JBDelSelected.addActionListener(this);
        JPOption.JBThickness1.addActionListener(this);
        JPOption.JBThickness2.addActionListener(this);
        JPOption.JBThickness3.addActionListener(this);
        JPOption.JBThickness4.addActionListener(this);
        JPOption.JBThickness5.addActionListener(this);
        JPSidePanel.JBSave.addActionListener(this);
        JPSidePanel.JBLoad.addActionListener(this);
        JPSidePanel.JBDel.addActionListener(this);
        JPLower.JCheck.addActionListener(this);
        JPLower.JMenu.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command=e.getActionCommand();
        //System.out.println(command);
        switch(command)
        {
            case "cursor":
                JPDraw.resetSelected();
                JPDraw.setFigure(0);
                break;
            case "line":
                JPDraw.resetSelected();
                JPDraw.setFigure(1);
                break;
            case "rectangle":
                JPDraw.resetSelected();
                JPDraw.setFigure(2);
                break;
            case "circle":
                JPDraw.resetSelected();
                JPDraw.setFigure(3);
                break;
            case "point":
                JPDraw.resetSelected();
                JPDraw.setFigure(4);
                break;
            case"thickness_1":
                JPDraw.setThickness(1);
                break;
            case"thickness_2":
                JPDraw.setThickness(2);
                break;
            case"thickness_3":
                JPDraw.setThickness(3);
                break;
            case"thickness_4":
                JPDraw.setThickness(4);
                break;
            case"thickness_5":
                JPDraw.setThickness(5);
                break;
            case "DeleteFigure":
                JPDraw.deleteFigure();
                break;
            case "selectColor":
                selectedColor = JColorChooser.showDialog(null, "Seleziona un colore", Color.BLACK);
                JPDraw.setColor(selectedColor);
                break;
            case "save":
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(true);
                int value = fileChooser.showSaveDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    File[] selectedFiles = fileChooser.getSelectedFiles();
                }
                String path=fileChooser.getSelectedFile().getAbsolutePath();
                if(path.contains(".bin"))
                    path=fileChooser.getSelectedFile().getAbsolutePath();
                else
                    path=fileChooser.getSelectedFile().getAbsolutePath()+".bin";
                try{
                    ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path));
                    stream.writeObject(JPDraw.getCirclesList());
                    stream.writeObject(JPDraw.getRectanglesList());
                    stream.writeObject(JPDraw.getSegmentsList());
                    stream.writeObject(JPDraw.getPointsList());
                    stream.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "load":
                JFileChooser fileChooser1 = new JFileChooser();
                fileChooser1.setDialogTitle("Seleziona il progetto da caricare");
                fileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser1.setMultiSelectionEnabled(false);

                int returnValue = fileChooser1.showOpenDialog(null);
                String path1="";
                if (returnValue == JFileChooser.APPROVE_OPTION)
                {
                    if(fileChooser1.getSelectedFile().getAbsolutePath().contains(".bin"))
                        path1 = fileChooser1.getSelectedFile().getAbsolutePath();
                    else
                        JOptionPane.showMessageDialog(null, "Errore: Il file selezionato non ha come estenzione .bin", "Errore!", JOptionPane.ERROR_MESSAGE);
                }
                else
                    path1=null;
                ObjectInputStream stream = null;
                try {
                    stream = new ObjectInputStream(new FileInputStream(path1));
                    JPDraw.setCirclesList((ArrayList<Cerchio>) stream.readObject());
                    JPDraw.setRectanglesList((ArrayList<Rettangolo>) stream.readObject());
                    JPDraw.setSegmentsList((ArrayList<Segmento>) stream.readObject());
                    JPDraw.setPointsList((ArrayList<Punto>) stream.readObject());
                    JPDraw.repaint();
                    stream.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Errore durante il caricamento del file!", "Errore!", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "del":
                JFileChooser fileChooser2 = new JFileChooser();
                fileChooser2.setDialogTitle("Seleziona il progetto da eliminare");
                int value2 = fileChooser2.showOpenDialog(null);

                if (value2 == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser2.getSelectedFile();

                    int deleteOption = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare il file?", "Elimina file", JOptionPane.YES_NO_OPTION);

                    if (deleteOption == JOptionPane.YES_OPTION) {
                        if (selectedFile.delete()) {
                            JOptionPane.showMessageDialog(null, "File eliminato con successo!", "Eliminazione completata!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione del file!", "Errore!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                break;
            case "Mostra griglia":
                JPDraw.setGrid(JPLower.JCheck.isSelected());
                repaint();
                break;
            case "backgroundColor":
                if(Objects.equals(JPLower.JMenu.getSelectedItem(), "Default"))
                {
                    JPDraw.setBackground(Color.WHITE);
                    JPDraw.setColor(Color.BLACK);
                }
                if(Objects.equals(JPLower.JMenu.getSelectedItem(), "Nero"))
                {
                    JPDraw.setBackground(Color.BLACK);
                    JPDraw.setColor(Color.WHITE);
                }
                if(Objects.equals(JPLower.JMenu.getSelectedItem(), "Blu"))
                {
                    JPDraw.setBackground(Color.BLUE);
                    JPDraw.setColor(Color.BLACK);
                }
                if(Objects.equals(JPLower.JMenu.getSelectedItem(), "Grigio"))
                {
                    JPDraw.setBackground(Color.GRAY);
                    JPDraw.setColor(Color.BLACK);
                }
                if(Objects.equals(JPLower.JMenu.getSelectedItem(), "Ciano"))
                {
                    JPDraw.setBackground(Color.CYAN);
                    JPDraw.setColor(Color.BLACK);
                }
                if(Objects.equals(JPLower.JMenu.getSelectedItem(), "Verde"))
                {
                    JPDraw.setBackground(Color.GREEN);
                    JPDraw.setColor(Color.BLACK);
                }
                break;
            default:

                break;
        }
    }

}
