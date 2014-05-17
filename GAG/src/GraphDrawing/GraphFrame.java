package GraphDrawing;

import java.awt.FileDialog;
import java.awt.MenuShortcut;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GraphFrame extends JFrame{

	private Graph graph;
	private View view;
	private JPanel Graph_View;
	private float zoom=1;
	private JFrame parent;
	private JTextArea textArea;
	
	public static void main(String[]args){
		new GraphFrame();
	}
	
	GraphFrame(){
		parent=this;
		setSize(657,598);
		setTitle("GAG Testing Tool");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		
		Graph_View = new JPanel();
		Graph_View.setBounds(201, 11, 440, 376);
		getContentPane().add(Graph_View);
		
		JPanel Control_view = new JPanel();
		Control_view.setBounds(10, 11, 181, 376);
		getContentPane().add(Control_view);
		Control_view.setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(0, 0, 181, 376);
		Control_view.add(textPane_1);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog fd = new FileDialog(parent);
				fd.show();
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog fd = new FileDialog(parent);
				fd.show();
			}
		});
		mnFile.add(mntmSave);
		mnFile.add(mntmClose);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmViewGraph = new JMenuItem("View graph");
		mntmViewGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set_view();
			}
		});
		mnView.add(mntmViewGraph);
		
		JMenuItem mntmClearGraph = new JMenuItem("Clear graph");
		mnView.add(mntmClearGraph);
		
		JSeparator separator_1 = new JSeparator();
		mnView.add(separator_1);
		
		JMenuItem mntmZoomIn = new JMenuItem("Zoom In");
		mntmZoomIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zoom-=0.2;
				view.getCamera().setViewPercent(zoom);
			}
		});
		mnView.add(mntmZoomIn);
		
		JMenuItem mntmZoomOut = new JMenuItem("Zoom Out");
		mntmZoomOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zoom+=0.2;
				view.getCamera().setViewPercent(zoom);
			}
		});
		mnView.add(mntmZoomOut);
		
		JMenuItem mntmResetZoom = new JMenuItem("Reset zoom");
		mntmResetZoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getCamera().resetView();
			}
		});
		mnView.add(mntmResetZoom);
		
		JSeparator separator = new JSeparator();
		mnView.add(separator);
		
		JMenuItem mntmPrevTest = new JMenuItem("Prev Test");
		mnView.add(mntmPrevTest);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Next Test\r\n");
		mnView.add(mntmNewMenuItem);
		
		final JMenu mnAbout = new JMenu("Help");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Licensed under the GNU General Public License\nVersion 1.0", "Version 1.0", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAbout.add(mntmAbout);
		
		
		textArea = new JTextArea();
		textArea.setBounds(10, 392, 631, 146);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 390, 631, 148);
		getContentPane().add(scrollPane);
		show();
	}
	
	public void print_to_console(String data){
		textArea.append(data+"\n");
	}
	
	private void set_view(){
		graph = new DefaultGraph("Tutorial 1");
		graph.addAttribute("ui.stylesheet", "url('C:\\Users\\Gehad\\git\\GAG\\GAG\\src\\css')");
		graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        graph.addEdge("BD", "B", "D");
		Viewer viewer =  new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_SWING_THREAD);
		viewer.enableAutoLayout();
		view = viewer.addDefaultView(false);
		view.getCamera().setAutoFitView(true);
		view.setSize(440, 376);
		Graph_View.add(view);
		Graph_View.setLayout(null);
	}
}
