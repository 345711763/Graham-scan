
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.util.List;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Panel extends JPanel implements MouseListener,KeyListener
{
    private int x,y;
    private GrahamScan s= new GrahamScan();
    private List<Point> hullPoints= new ArrayList<Point>();
    private List<Point> points = new ArrayList<Point>();
    public Panel(){
        setSize(800,800);
        setPreferredSize(new Dimension(800,800));
        this.setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);
    }
 
    public static void main(String[] args){
        JFrame f= new JFrame();
        Panel panel= new Panel();
        f.add(panel);
        f.setTitle("ConvexHull");
        f.setSize(800,800);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        f.setResizable(false);
        f.setVisible(true);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.x=e.getX();
        this.y=e.getY();
        Point p= new Point();
        p.setLocation(x, y);
        this.points.add(p);   
        this.getGraphics().drawOval(x, y, 5, 5);       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        this.repaint();        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        int c= arg0.getKeyCode();
        if(c==KeyEvent.VK_ENTER){
      
            for(int i=0;i<points.size();i++)
            {
                this.getGraphics().drawOval(points.get(i).x, points.get(i).y, 5, 5);
            }
            hullPoints=s.computeConvexHull(points);
            for(int i=1;i<hullPoints.size();i++){
                this.getGraphics().drawLine(hullPoints.get(i-1).x, hullPoints.get(i-1).y, hullPoints.get(i).x, hullPoints.get(i).y);
            }
        }
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
      
        
    }
   
}
