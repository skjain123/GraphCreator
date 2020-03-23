import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	ArrayList<Node> nodes = new ArrayList<Node>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	
	String title = "";
	
	public GraphPanel(String gTitle) {
		super();
		title = gTitle;
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponents(g);
		
		g.fillRect(0, 0, 1000, 750);
		
		g.setColor(Color.WHITE);
		g.drawLine(0, 0, 200, 400);
		
		for (int i = 0; i < nodes.size(); i++)
		{
			Node n = nodes.get(i);
			g.drawOval(n.getX() - 125, n.getY() - 45, 40, 40);
			g.drawString(n.getLabel(), n.getX() - 110, n.getY() - 25);
		}
		
		for (int i = 0; i < edges.size(); i++)
		{
			Edge e = edges.get(i);
			
			Node o = e.getOne();
			Node t = e.getTwo();
			
			g.drawLine(o.getX(), o.getY(), t.getX(), t.getY());
			g.drawString(e.getLabel(), o.getX() - t.getX() - 110, o.getY() - t.getY() - 25);
		}
	}
}
