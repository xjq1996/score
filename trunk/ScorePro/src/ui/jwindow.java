package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class jwindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2213197723422739858L;
	JPanel jPanel=new JPanel();
	JPanel datachoosepanel=new JPanel();
	JPanel dataalertpanel=new JPanel();
	JPanel card[]=new JPanel[6];
	JLabel title1=new JLabel("<html><p style='font-size:10px'>数据选择</p></html>");
	JLabel title2=new JLabel("数据操作");
	JButton button=new JButton("<html><p style='font-size:10px'>数据导入</p></html>");
	JButton button1=new JButton("<html><p style='font-size:10px'>数据导出</p></html>");
	JButton card0_button0=new JButton("查询");
	JTextField card0_text0=new JTextField("请输入学生学号");
	JComboBox<String> card1_box0=new JComboBox<String>();
	JButton card1_button0=new JButton("统计");
	JLabel card1_text0=new JLabel("0");
	JLabel card1_lable0=new JLabel("人数:");
	JComboBox<String> card2_box0=new JComboBox<String>(new String[]{"按成绩排序","按学号排序"});
	JComboBox<String> card2_box1=new JComboBox<String>(new String[]{"升序排序","降序排序"});
	JButton card2_button0=new JButton("确定");
	JLabel card3_lable[]={new JLabel("学号"),new JLabel("姓名"),new JLabel("课程"),new JLabel("成绩")};
	JTextField card3_text[]={new JTextField(),new JTextField(),new JTextField(),new JTextField()};
	JButton card3_button0=new JButton("添加");
	JLabel card4_lable[]={new JLabel("学号"),new JLabel("姓名"),new JLabel("课程"),new JLabel("成绩")};
	JTextField card4_text[]={new JTextField(),new JTextField(),new JTextField(),new JTextField()};
	JButton card4_button0=new JButton("修改");
	JButton card5_button0=new JButton("删除");
	JTextField card5_text0=new JTextField("请输入学生学号");
	JFileChooser jfc=new JFileChooser("C:/Users/jiaqing/Desktop");
	JMenuBar menubar=new JMenuBar();
	JMenu menu=new JMenu("查询统计");
	JMenu menu1=new JMenu("排序");
	JMenu menu2=new JMenu("数据修改");
	JMenuItem menu_item1= new JMenuItem("查询");
	JMenuItem menu_item2=new JMenuItem("按成绩段统计");
	JMenuItem menu_item3=new JMenuItem("查询所有数据");
	JMenuItem menu1_item1=new JMenuItem("关键字排序");
	JMenuItem menu2_item1=new JMenuItem("增加学生数据");
	JMenuItem menu2_item2=new JMenuItem("修改学生数据");
	JMenuItem menu2_item3=new JMenuItem("删除学生数据");
	JTextField text=new JTextField();
	JTextField text1=new JTextField();
	String clos[]={"学号","姓名","课程","成绩"};
	JTable table=new JTable();
    JScrollPane jsp=new JScrollPane(table);
    CardLayout cardlayout=new CardLayout();
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
    	button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfc.showSaveDialog(jwindow.this);
				text1.setText(jfc.getSelectedFile().getAbsolutePath());
			}
		});
    	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    	this.setSize(800, 460);
    	this.setLocation(screensize.width/2-this.getWidth()/2, screensize.height/2-this.getHeight()/2);
    	jfc.addChoosableFileFilter(new myfilter(".txt"));
    	jfc.addChoosableFileFilter(new myfilter(".doc"));
    	jfc.addChoosableFileFilter(new myfilter(".exe"));
    	jfc.addChoosableFileFilter(new myfilter(".xls"));
    	jPanel.setLayout(null);
    	dataalertpanel.setLayout(cardlayout);
    	for(int i=0;i<card.length;i++)
    	{
    		card[i]=new JPanel(null);
    		card[i].setBackground(Color.gray.brighter());
    	}
    	card1_box0.addItem("60~70");
    	card1_box0.addItem("70~80");
    	card1_box0.addItem("80~90");
    	card1_box0.addItem("90~100");
    	card1_box0.setBounds(60,50,120,30);
    	card1_button0.setBounds(200,50,80,30);
    	card1_lable0.setBounds(60,90,50,30);
    	card1_text0.setBounds(110,90,70,30);
    	card2_box0.setBounds(30,80,120,30);
    	card2_box1.setBounds(170,80,80,30);
    	card2_button0.setBounds(270,80,80,30);
    	for(int i=0;i<card3_lable.length;i++)
    	{
    		card3_lable[i].setBounds(50,i*30+15,80,30);
    	}
    	for(int i=0;i<card3_text.length;i++)
    	{
    		card3_text[i].setBounds(140,i*30+15,120,30);
    	}
    	card3_button0.setBounds(140,140,80,30);
    	for(int i=0;i<card4_lable.length;i++)
    	{
    		card4_lable[i].setBounds(50,i*30+15,80,30);
    	}
    	for(int i=0;i<card4_text.length;i++)
    	{
    		card4_text[i].setBounds(140,i*30+15,120,30);
    	}
    	card4_button0.setBounds(140,140,80,30);
    	card0_text0.setBounds(60,70,120,30);
    	card0_text0.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				card0_text0.setText("");
			}
		});
    	card5_text0.setBounds(60,70,120,30);
    	card5_text0.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				card5_text0.setText("");
			}
		});
    	card0_button0.setBounds(200,70,70,30);
    	card5_button0.setBounds(200,70,70,30);
    	card[0].add(card0_button0);
    	card[0].add(card0_text0);
    	card[1].add(card1_box0);
    	card[1].add(card1_button0);
    	card[1].add(card1_lable0);
    	card[1].add(card1_text0);
    	card[2].add(card2_box0);
    	card[2].add(card2_box1);
    	card[2].add(card2_button0);
    	for(int i=0;i<card3_lable.length;i++)
    	{
    		card[3].add(card3_lable[i]);
    		card[3].add(card3_text[i]);
    	}
    	card[3].add(card3_button0);
    	for(int i=0;i<card4_lable.length;i++)
    	{
    		card[4].add(card4_lable[i]);
    		card[4].add(card4_text[i]);
    	}
    	card[4].add(card4_button0);
    	card[5].add(card5_button0);
    	card[5].add(card5_text0);
    	for(int i=0;i<card.length;i++)
    	{
    		dataalertpanel.add(card[i],i+"");
    	}
    	dataalertpanel.setBorder(BorderFactory.createLineBorder(Color.gray,1));
    	title2.setBounds(5,200,80,20);
    	dataalertpanel.setBounds(5,230,370,185);
    	//
    	title1.setBounds(5,40,80,20);
    	datachoosepanel.setBounds(5,60,370,130);
    	datachoosepanel.setBorder(BorderFactory.createLineBorder(Color.gray,1));
    	datachoosepanel.setBackground(Color.gray.brighter());
    	datachoosepanel.setLayout(null);
    	datachoosepanel.add(button);
    	datachoosepanel.add(text);
    	datachoosepanel.add(button1);
    	datachoosepanel.add(text1);
    	button.setBounds(210, 20, 110, 30);
    	button1.setBounds(210,80, 110, 30);
    	text.setBounds(5, 20, 200, 30);
    	text1.setBounds(5, 80,200,30);
    	//
    	menu.add(menu_item1);
    	menu.add(menu_item2);
    	menu.add(menu_item3);
    	menu_item1.addActionListener(new mylistener());
    	menu_item2.addActionListener(new mylistener());
    	menu1_item1.addActionListener(new mylistener());
    	menu2_item1.addActionListener(new mylistener());
    	menu2_item2.addActionListener(new mylistener());
    	menu2_item3.addActionListener(new mylistener());
    	menu1.add(menu1_item1);
    	menu2.add(menu2_item1);
    	menu2.add(menu2_item2);
    	menu2.add(menu2_item3);
    	menubar.add(menu);
    	menubar.add(menu1);
    	menubar.add(menu2);
    	menubar.setBounds(0,0,800,20);
    	//
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
    	jPanel.add(title2);
    	jPanel.add(datachoosepanel);
    	jPanel.add(dataalertpanel);
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
    class mylistener implements ActionListener
    {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(menu_item1))
			{
				cardlayout.show(dataalertpanel, "0");
				card0_text0.setText("请输入学生学号");
			}
			else if(e.getSource().equals(menu_item2))
			{
				cardlayout.show(dataalertpanel,"1");
			}
			else if(e.getSource().equals(menu1_item1))
			{
				cardlayout.show(dataalertpanel, "2");
			}
			else if(e.getSource().equals(menu2_item1))
			{
				cardlayout.show(dataalertpanel,"3");
			}else if(e.getSource().equals(menu2_item2))
			{
				cardlayout.show(dataalertpanel,"4");
			}
			else if(e.getSource().equals(menu2_item3))
			{
				cardlayout.show(dataalertpanel,"5");
				card5_text0.setText("请输入学生学号");
			}
		}
    	
    }
    public static void main(String[] args) {
		new jwindow();
	}
}

