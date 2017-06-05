package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class jwindow extends JFrame{
	JPanel jPanel=new JPanel();
	JButton button=new JButton("数据导入");
	JFileChooser jfc=new JFileChooser("C:/Users/jiaqing/Desktop");
	JTextField text=new JTextField(50);
	String clos[]={"学号","姓名","课程","成绩"};
	table table=new table();
    JScrollPane jsp=new JScrollPane(table);
    public jwindow()
    {
    	
    	this.getContentPane().setBackground(Color.gray.brighter());
    	button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{jfc.showOpenDialog(jwindow.this);
				text.setText(jfc.getSelectedFile().getAbsolutePath());}
				catch(NullPointerException e1){}
			}
		});
    	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    	this.setSize(800, 400);
    	this.setLocation(screensize.width/2-this.getWidth()/2, screensize.height/2-this.getHeight()/2);
    	jfc.addChoosableFileFilter(new myfilter(".txt"));
    	jfc.addChoosableFileFilter(new myfilter(".doc"));
    	jfc.addChoosableFileFilter(new myfilter(".exe"));
    	jfc.addChoosableFileFilter(new myfilter(".xls"));
    	jPanel.setLayout(null);
    	button.setBounds(500, 20, 140, 30);
    	text.setBounds(500, 70, 200, 30);
    	text.setBorder(null);
    	//text.setAlignmentX(ALLBITS);
    	text.setFont(new Font("宋体",1, 18));
    	DefaultTableModel model=new DefaultTableModel(clos, 40);
    	table.setModel(model);
    	table.setCellSelectionEnabled(false);
    	DefaultTableCellRenderer render=new DefaultTableCellRenderer();
    	render.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    	table.setDefaultRenderer(Object.class,render);
    	table.setRowHeight(20);
    	table.setBounds(0, 0,200, 400);
    	jsp.setBounds(0, 0, 390,table.getRowHeight()*20);
    	jsp.setBorder(null);
    	table.isCellEditable(0,0);
    	jPanel.add(button);
    	jPanel.setOpaque(false);
    	jPanel.add(text);
    	jPanel.add(jsp);
    	this.add(jPanel);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }
    class table extends JTable
    {

		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			
			return super.isCellEditable(row, column);
		}

		public table() {
			super();
			// TODO Auto-generated constructor stub
		}

		public table(int numRows, int numColumns) {
			super(numRows, numColumns);
			// TODO Auto-generated constructor stub
		}

		public table(Object[][] rowData, Object[] columnNames) {
			super(rowData, columnNames);
			// TODO Auto-generated constructor stub
		}

		public table(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
			super(dm, cm, sm);
			// TODO Auto-generated constructor stub
		}

		public table(TableModel dm, TableColumnModel cm) {
			super(dm, cm);
			// TODO Auto-generated constructor stub
		}

		public table(TableModel dm) {
			super(dm);
			// TODO Auto-generated constructor stub
		}

		public table(Vector rowData, Vector columnNames) {
			super(rowData, columnNames);
			// TODO Auto-generated constructor stub
		}
    	
    }
    class myfilter extends FileFilter
    {
        private String name;
		@Override
		public boolean accept(File f) {
			// TODO Auto-generated method stub
			return f.getName().endsWith(name);
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return name;
		}
    	public myfilter(String name)
    	{
    		this.name=name;
    	}
    }
    public static void main(String[] args) {
		new jwindow();
	}
}

