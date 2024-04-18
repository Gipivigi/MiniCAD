import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class FinestraMiniCAD extends JFrame implements ActionListener
{
    CommandPanel JPCommand;
    DrawPanel JPDraw;
    DrawOptionPanel JPOption;
    SidePanel JPSidePanel;
    Container contents;
    Color selectedColor;
    boolean line=false, circle=false, rectangle=false, point=false;
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
        contents=getContentPane();
        contents.setLayout(new BorderLayout());
        contents.add(JPCommand, BorderLayout.NORTH);
        contents.add(JPDraw, BorderLayout.CENTER);
        contents.add(JPOption, BorderLayout.SOUTH);
        contents.add(JPSidePanel, BorderLayout.WEST);
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
                    for (File file : selectedFiles) {
                        if (file.exists()) {
                            System.out.println("Il file " + file.getName() + " è già presente. Non è stato salvato nuovamente.");
                        } else {
                            System.out.println("Salvataggio del file: " + file.getName());
                        }
                    }
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
                fileChooser1.setDialogTitle("Scegli un file da caricare");
                fileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser1.setMultiSelectionEnabled(false);

                int returnValue = fileChooser1.showOpenDialog(null);
                String path1;
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    path1 = fileChooser1.getSelectedFile().getAbsolutePath();
                } else {
                    path1="";
                }
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
                    System.err.println("Errore durante il caricamento del file: " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "del":
                File file = new File("projects/First_drawing.bin");
                if (file.exists())
                    file.delete();
                else
                    System.err.println("Nessun file presente!");
            default:

                break;
        }
    }
}
