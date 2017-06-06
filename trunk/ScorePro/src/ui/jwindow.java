package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	JPanel datachoosepanel=new JPanel();
	JPanel dataalertpanel=new JPanel();
	JLabel title1=new JLabel("<html><p style='font-size:10px'>数据选择</p></html>");
	JLabel title2=new JLabel("数据操作");
	JButton button=new JButton("<html><p style='font-size:10px'>数据导入</p></html>");
	JFileChooser jfc=new JFileChooser("C:/Users/jiaqing/Desktop");
	JMenuBar menubar=new JMenuBar();
	JMenu menu=new JMenu("查询统计");
	JMenu menu1=new JMenu("排序");
	JMenu menu2=new JMenu("数据修改");
	JMenuItem menu_item1= new JMenuItem("查询");
	JMenuItem menu_item2=new JMenuItem("按成绩段统计");
	JMenuItem menu1_item1=new JMenuItem("降序排序");
	JMenuItem menu1_item2=new JMenuItem("升序排序");
	JMenuItem menu2_item1=new JMenuItem("增加学生数据");
	JMenuItem menu2_item2=new JMenuItem("删除学生数据");
	JMenuItem menu2_item3=new JMenuItem("修改学生数据");
	JTextField text=new JTextField(50);
	String clos[]={"学号","姓名","课程","成绩"};
	JTable table=new JTable();
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
    	this.setSize(800, 540);
    	this.setLocation(screensize.width/2-this.getWidth()/2, screensize.height/2-this.getHeight()/2);
    	jfc.addChoosableFileFilter(new myfilter(".txt"));
    	jfc.addChoosableFileFilter(new myfilter(".doc"));
    	jfc.addChoosableFileFilter(new myfilter(".exe"));
    	jfc.addChoosableFileFilter(new myfilter(".xls"));
    	jPanel.setLayout(null);
    	title1.setBounds(5,40,80,20);
    	datachoosepanel.setBounds(5,60,370,130);
    	datachoosepanel.setBorder(BorderFactory.createLineBorder(Color.gray,1));
    	datachoosepanel.setBackground(Color.gray.brighter());
    	datachoosepanel.setLayout(null);
    	datachoosepanel.add(button);
    	datachoosepanel.add(text);
    	button.setBounds(210, 20, 110, 30);
    	text.setBounds(5, 20, 200, 30);
    	text.setBorder(null);
    	menu.add(menu_item1);
    	menu.add(menu_item2);
    	menu1.add(menu1_item1);
    	menu1.add(menu1_item2);
    	menu2.add(menu2_item1);
    	menu2.add(menu2_item2);
    	menu2.add(menu2_item3);
    	menubar.add(menu);
    	menubar.add(menu1);
    	menubar.add(menu2);
    	menubar.setBounds(0,0,800,20);
    	//text.setAlignmentX(ALLBITS);
    	text.setFont(new Font("宋体",1, 18));
    	DefaultTableModel model=new DefaultTableModel(clos,25);
    	table.setModel(model);
    	table.setCellSelectionEnabled(false);
    	DefaultTableCellRenderer render=new DefaultTableCellRenderer();
    	render.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    	table.setDefaultRenderer(Object.class,render);
    	table.setRowHeight(20);
    	table.setBounds(393,20,200, 400);
    	jsp.setBounds(393,20,390,table.getRowHeight()*20);
    	jsp.setBorder(null);
    	table.isCellEditable(0,0);
    	jPanel.add(title1);
    	jPanel.add(datachoosepanel);
        jPanel.add(menubar);
    	jPanel.setOpaque(false);
    	jPanel.add(jsp);
    	this.add(jPanel);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
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

