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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

import dao.StudentScoreDao;
import dao.impl.StudentScore;
import entity.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class jwindow extends JFrame{
	/**
	 * 定义以下组件
	 */
	private static final long serialVersionUID = 2213197723422739858L;
	StudentService sservice=new StudentServiceImpl();
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
	public static JFileChooser jfc=new JFileChooser("C:/Users/jiaqing/Desktop");
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
    public static JTextField text1=new JTextField();
	Vector<String> clos=new Vector<String>();
	JTable table=new JTable();
    JScrollPane jsp=new JScrollPane(table);
    CardLayout cardlayout=new CardLayout();
    //构造初始化数据表的字段：姓名、学号、成绩、课名，并初始化组件
    public jwindow()
    {
    	
    	this.getContentPane().setBackground(Color.gray.brighter());
    	clos.add("姓名");
    	clos.add("学号");
    	clos.add("课名");
    	clos.add("成绩");
    	//点击弹出文件选择框
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
    	//获取屏幕尺寸
    	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    	//设置窗体大小
    	this.setSize(800, 460);
    	//让窗体居中
    	this.setLocation(screensize.width/2-this.getWidth()/2, screensize.height/2-this.getHeight()/2);
    	//固定大小，设置为不可调整
    	this.setResizable(false);
    	//设置文件过滤，筛选文件类型
    	jfc.addChoosableFileFilter(new myfilter(".txt"));
    	jfc.addChoosableFileFilter(new myfilter(".doc"));
    	jfc.addChoosableFileFilter(new myfilter(".exe"));
    	jfc.addChoosableFileFilter(new myfilter(".xls"));
    	//定义面板的总布局
    	jPanel.setLayout(null);
    	//定义数据修改的面板布局为卡片布局
    	dataalertpanel.setLayout(cardlayout);
    	for(int i=0;i<card.length;i++)
    	{
    		card[i]=new JPanel(null);
    		card[i].setBackground(Color.gray.brighter());
    	}
    	//设置内容，调整该面板内组件的尺寸位置
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
    	card4_text[0].addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				Student stu=new Student();
				String id=card4_text[0].getText();
				id=id.replaceAll("\\s","");
				stu=sservice.ServiceindById(id);
				card4_text[1].setText(stu.getName());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
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
    	menu_item3.addActionListener(new mylistener());
    	menu1_item1.addActionListener(new mylistener());
    	menu2_item1.addActionListener(new mylistener());
    	menu2_item2.addActionListener(new mylistener());
    	menu2_item3.addActionListener(new mylistener());
    	card0_button0.addActionListener(new mylistener());
    	card1_button0.addActionListener(new mylistener());
    	card2_button0.addActionListener(new mylistener());
    	card3_button0.addActionListener(new mylistener());
    	card4_button0.addActionListener(new mylistener());
    	card5_button0.addActionListener(new mylistener());
    	menu1.add(menu1_item1);
    	menu2.add(menu2_item1);
    	menu2.add(menu2_item2);
    	menu2.add(menu2_item3);
    	menubar.add(menu);
    	menubar.add(menu1);
    	menubar.add(menu2);
    	menubar.setBounds(0,0,800,20);
    	//
    	DefaultTableModel model=new DefaultTableModel(clos,0);
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
			}else if(e.getSource().equals(menu_item3))
			{
				StudentScoreDao sdao=new StudentScore();
				try
				{
					ArrayList<Student> list=(ArrayList<Student>) sdao.findAllStudents();
					DefaultTableModel model=new DefaultTableModel();
					model.setColumnCount(4);
					model.setRowCount(list.size());
					model.setDataVector(ListToVector(list), clos);
					table.setModel(model);
					list.clear();
				}catch(NullPointerException e1){
					JOptionPane.showMessageDialog(null,"数据源不存在","警告",JOptionPane.YES_NO_CANCEL_OPTION);
				}
			}else if(e.getSource().equals(card0_button0))
			{
				try{
				String s=card0_text0.getText();
				Student student=sservice.ServiceindById(s);
				Vector<String> v=new Vector<String>();
				Vector<Vector<String>> data=new Vector<Vector<String>>();
				v.add(student.getName());
				v.add(student.getId());
				v.add(student.getScore_name());
				v.add(student.getScore()+"");
				data.add(v);
				DefaultTableModel model=new DefaultTableModel(data, clos);
				table.setModel(model);}catch(NullPointerException e1)
				{
					JOptionPane.showMessageDialog(null,"该学生数据不存在","提示",JOptionPane.YES_NO_CANCEL_OPTION);
				}
			}else if(e.getSource().equals(card1_button0))
			{
				try{
				if(card1_box0.getSelectedItem().toString().equals("60~70"))
				{
					List<Student> stus=new ArrayList<Student>();
					stus=sservice.ServicefindByscore(60,70);
					card1_text0.setText(stus.size()+"");
					DefaultTableModel model=new DefaultTableModel(ListToVector(stus), clos);
					table.setModel(model);
				}
				if(card1_box0.getSelectedItem().toString().equals("70~80"))
				{
					List<Student> stus=new ArrayList<Student>();
					stus=sservice.ServicefindByscore(70,80);
					card1_text0.setText(stus.size()+"");
					DefaultTableModel model=new DefaultTableModel(ListToVector(stus), clos);
					table.setModel(model);
				}
				if(card1_box0.getSelectedItem().toString().equals("80~90"))
				{
					List<Student> stus=new ArrayList<Student>();
					stus=sservice.ServicefindByscore(80,90);
					card1_text0.setText(stus.size()+"");
					DefaultTableModel model=new DefaultTableModel(ListToVector(stus), clos);
					table.setModel(model);
				}
				if(card1_box0.getSelectedItem().toString().equals("90~100"))
				{
					List<Student> stus=new ArrayList<Student>();
					stus=sservice.ServicefindByscore(90,101);
					card1_text0.setText(stus.size()+"");
					DefaultTableModel model=new DefaultTableModel(ListToVector(stus), clos);
					table.setModel(model);
				}
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"请先导入数据源","提示",JOptionPane.YES_NO_CANCEL_OPTION);
				}
			}else if(e.getSource().equals(card2_button0))
			{
				int r=table.getRowCount();
				List<Student> stus=new ArrayList<Student>();
				for(int i=0;i<r;i++)
				{
					Student student=new Student();
					student.setName(table.getModel().getValueAt(i, 0).toString());
					student.setId(table.getModel().getValueAt(i, 1).toString());
					student.setScore_name(table.getModel().getValueAt(i, 2).toString());
					student.setScore(Integer.parseInt(table.getModel().getValueAt(i, 3).toString().replace(" ","")));
					stus.add(student);
				}
				stus=sservice.ServiceOrderByscore(stus, card2_box0.getSelectedItem().toString(),card2_box1.getSelectedItem().toString());
				DefaultTableModel model=new DefaultTableModel(ListToVector(stus),clos);
				table.setModel(model);
						
			}else if(e.getSource().equals(card3_button0))
			{
				String s1=card3_text[0].getText();
				String s2=card3_text[1].getText();
				String s3=card3_text[2].getText();
				String s4=card3_text[3].getText();
				if(s1.replaceAll("\\s","").equals("")||s2.replaceAll("\\s","").equals("")||s3.replaceAll("\\s","").equals("")||s4.replaceAll("\\s","").equals(""))
					JOptionPane.showMessageDialog(jwindow.this,"输入数据不能含空值","提示",JOptionPane.YES_NO_CANCEL_OPTION);
				else{
				Student stu=new Student();
				stu.setId(card3_text[0].getText());
				stu.setName(card3_text[1].getText());
				stu.setScore_name(card3_text[2].getText());
				stu.setScore(Integer.parseInt(card3_text[3].getText().replaceAll("\\s","")));
				sservice.ServiceInsertData(jfc.getSelectedFile().getAbsolutePath(),stu);
				JOptionPane.showMessageDialog(jwindow.this,"插入成功","提示",JOptionPane.YES_NO_CANCEL_OPTION);
				}
			}else if(e.getSource().equals(card4_button0))
			{
				String s1=card4_text[0].getText();
				String s2=card4_text[1].getText();
				String s3=card4_text[2].getText();
				String s4=card4_text[3].getText();
				if(s1.replaceAll("\\s","").equals("")||s2.replaceAll("\\s","").equals("")||s3.replaceAll("\\s","").equals("")||s4.replaceAll("\\s","").equals(""))
					JOptionPane.showMessageDialog(jwindow.this,"输入数据不能含空值","提示",JOptionPane.YES_NO_CANCEL_OPTION);
				else if(sservice.ServiceindById(s1.replaceAll("\\s",""))==null)
				{
					JOptionPane.showMessageDialog(jwindow.this,"学生数据不存在","提示",JOptionPane.YES_NO_CANCEL_OPTION);
				}
				else
				{
					Student s=new Student();
					s.setId(s1);
					s.setName(s2);
					s.setScore_name(s3);
					s.setScore(Integer.parseInt(s4.replaceAll("\\s","")));
					sservice.ServiceupdateStudent(s);
				}
			}else if(e.getSource().equals(card5_button0))
			{
				String id=card5_text0.getText();
				id=id.replaceAll("\\s","");
				if(id.equals(""))
				{
					JOptionPane.showMessageDialog(jwindow.this,"输入数据不能为空","提示",JOptionPane.YES_OPTION);
				}else if(sservice.ServiceindById(id)==null)
				{
					JOptionPane.showMessageDialog(jwindow.this,"找不到该学生数据","提示",JOptionPane.YES_OPTION);
				}else
				{
					int flag=JOptionPane.showConfirmDialog(null,"确认删除","提示",JOptionPane.YES_NO_CANCEL_OPTION);
					if(flag==0)
					{
						sservice.Servicedelete(id);
						JOptionPane.showMessageDialog(jwindow.this,"删除成功","提示",JOptionPane.YES_OPTION);
					}
				}
			}
		}
    	
    }
    public static Vector<Vector<String>> ListToVector(List<Student> list)
    {
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		for(int i=0;i<list.size();i++)
		{
			Vector<String> v=new Vector<String>();
			v.add(list.get(i).getName());
			v.add(list.get(i).getId());
			v.add(list.get(i).getScore_name());
			v.add(list.get(i).getScore()+"");
			data.addElement(v);
		}
		return data;
    }
    public static void main(String[] args) {
		new jwindow();
	}
}

