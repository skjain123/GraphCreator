
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Main implements ActionListener, MouseListener
{

	JFrame frame = new JFrame("Graph Creator");
	
	GraphPanel panel = new GraphPanel("My Graph");
	
	Container west = new Container();
	Container swest = new Container();
	
	JButton nodeB = new JButton("Node");
	JButton edgeB = new JButton("Edge");
	
	JTextArea InputField = new JTextArea();
	
	JLabel inputLabel = new JLabel("<html><div style='text-align: center'>Input title for <br/> Nodes / Edges:<div/><html/>");
	
	final int NODE_CREATE = 0;
	final int EDGE_FIRST = 1;
	final int EDGE_SECOND = 2;
	
	
	int state = NODE_CREATE;
	
	public Main() {
		frame.setSize(1000, 750);
		frame.setLayout(new BorderLayout());
		
		frame.add(panel, BorderLayout.CENTER);
		frame.addMouseListener(this);
		
		frame.add(west, BorderLayout.WEST);
		west.setLayout(new GridLayout(3,1));
		west.add(nodeB);
		nodeB.addActionListener(this);
		nodeB.setBackground(Color.GREEN);
		west.add(edgeB);
		edgeB.setBackground(Color.LIGHT_GRAY);
		edgeB.addActionListener(this);
		west.add(swest);
		swest.setLayout(new GridLayout(2,1));
		swest.add(inputLabel);
		swest.add(InputField);
		InputField.setLineWrap(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(nodeB)) {
			nodeB.setBackground(Color.GREEN);
			edgeB.setBackground(Color.LIGHT_GRAY);
			state = NODE_CREATE;
		} else if (e.getSource().equals(edgeB)) {
			edgeB.setBackground(Color.GREEN);
			nodeB.setBackground(Color.LIGHT_GRAY);
			state = EDGE_FIRST;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (state == NODE_CREATE) {
			Node n;
			n = new Node(e.getX(), e.getY(), InputField.getText());
			panel.nodes.add(n);
		} else if (state == EDGE_FIRST) {
			//sdf
		}
		panel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
