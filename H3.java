import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Panel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.awt.Point;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.proteanit.sql.DbUtils;
import net.sourceforge.jdatepicker.DateModel;
import com.toedter.calendar.JYearChooser;

import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.CardLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import com.toedter.calendar.JCalendar;

public class H3 {
	
	private static final long serialVersionUID = 1L;
	protected static final String JCheckBox = null;
	JFrame frmMovie;
	private JTextField txtMovie;
	private JTextField txtCriticsRating;
	private JTextField txtRating;
	private JTextField txtVal_Rating;
	private JTextField txtNumOfReviews;
	private JTextField txtNumOfRevValue;
	private JTextField txtMovieYear;
	private JTextField txtSearchBetweenAtrribute;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtTagWeight;
	private JTextField txtValue_TagWeight;
	private JTextField TagWeight_Val;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField NumOfRevVal;
	private JTextField textField_Val;
	private JTextPane textPane_ExecuteQ;
	private JPanel genre;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:books"; 
	private String user = "system"; 
	private String pass = "Ramramram098"; 
	private String query = "";
	
	private String path_con = "";
	private String path_loc = "";
	private String path = "";
	private String rating ="";
	private String NumOfRev = "";
	private String BetAtrVal = "";
	private String txtTagW = "";
	private String Val_Rat = "";
	private String NumOfRev_Val = "";
	private String TagWe_Val ="";
	private String Field_Val ="";
	private String TagValQuery= "";
	private String FinalQuery = "";
	
	private int year_to;
	private int year_from;
	
	private List<Integer> genre_index = new ArrayList<Integer>();
	private List<Integer> con_index = new ArrayList<Integer>();
	private List<Integer> loc_index = new ArrayList<Integer>();
	
	private JTable tagValtable;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JPanel country;
	private JPanel location;
	private JScrollPane scrollPane_loc;
	private JTable table_con;
	private JScrollPane scrollPane_con;
	private JTable table_loc;
	private JTable table_result;
	private JScrollPane scrollPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					H3 window = new H3();
					window.frmMovie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public H3() throws IOException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws throws IOException, SQLException 
	 */
	private void initialize() throws IOException, SQLException {
		frmMovie = new JFrame();
		frmMovie.getContentPane().setBackground(new Color(0, 0, 128));
		frmMovie.setTitle("Movie");
		frmMovie.setBounds(100, 100, 1223, 657);
		frmMovie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMovie.getContentPane().setLayout(null);
		
		txtMovie = new JTextField();
		txtMovie.setBackground(SystemColor.textHighlight);
		txtMovie.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMovie.setBounds(0, 0, 1199, 24);
		txtMovie.setForeground(UIManager.getColor("CheckBox.foreground"));
		txtMovie.setText("Movie");
		txtMovie.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovie.setColumns(10);
			
		JPanel critic_rating = new JPanel();
		critic_rating.setLayout(null);
		critic_rating.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		critic_rating.setBackground(SystemColor.menu);
		critic_rating.setBounds(452, 25, 166, 220);
		
		txtCriticsRating = new JTextField();
		txtCriticsRating.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCriticsRating.setBackground(SystemColor.activeCaptionBorder);
		txtCriticsRating.setText("Critic's Rating");
		txtCriticsRating.setHorizontalAlignment(SwingConstants.CENTER);
		txtCriticsRating.setColumns(10);
		txtCriticsRating.setBounds(0, 0, 166, 46);
		critic_rating.add(txtCriticsRating);
		
		txtRating = new JTextField();
		txtRating.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRating.setHorizontalAlignment(SwingConstants.LEFT);
		txtRating.setText("Rating:");
		txtRating.setBounds(10, 56, 53, 20);
		critic_rating.add(txtRating);
		txtRating.setColumns(10);
		
		txtVal_Rating = new JTextField();
		txtVal_Rating.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVal_Rating.setText("Value :");
		txtVal_Rating.setHorizontalAlignment(SwingConstants.LEFT);
		txtVal_Rating.setColumns(10);
		txtVal_Rating.setBounds(10, 86, 53, 20);
		critic_rating.add(txtVal_Rating);
		
		txtNumOfReviews = new JTextField();
		txtNumOfReviews.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumOfReviews.setToolTipText("");
		txtNumOfReviews.setHorizontalAlignment(SwingConstants.LEFT);
		txtNumOfReviews.setText("Num of Reviews :");
		txtNumOfReviews.setColumns(10);
		txtNumOfReviews.setBounds(10, 115, 130, 19);
		critic_rating.add(txtNumOfReviews);
		
		txtNumOfRevValue = new JTextField();
		txtNumOfRevValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumOfRevValue.setText("Value :");
		txtNumOfRevValue.setHorizontalAlignment(SwingConstants.LEFT);
		txtNumOfRevValue.setColumns(10);
		txtNumOfRevValue.setBounds(10, 177, 53, 20);
		critic_rating.add(txtNumOfRevValue);
		
		JComboBox comboBox_rating = new JComboBox();
		comboBox_rating.addActionListener(new ActionListener() {//add actionlistner to listen for change
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        rating = (String) comboBox_rating.getSelectedItem();//get the selected item
		        System.out.print(rating);
		    }
		});
		comboBox_rating.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_rating.setBounds(73, 56, 83, 20);
		critic_rating.add(comboBox_rating);
		comboBox_rating.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "=", "<", ">", ">=", "<="}));
		
		JComboBox comboBox_NumOfRev = new JComboBox();
		comboBox_NumOfRev.addActionListener(new ActionListener() {//add actionlistner to listen for change
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	NumOfRev = (String) comboBox_NumOfRev.getSelectedItem();//get the selected item
		        System.out.print(NumOfRev);
		    }
		});
		comboBox_NumOfRev.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_NumOfRev.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "=", "<", ">", "<=", ">="}));
		comboBox_NumOfRev.setBounds(73, 144, 83, 20);
		critic_rating.add(comboBox_NumOfRev);
		
		NumOfRevVal = new JTextField();
		NumOfRevVal.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent event) {
				NumOfRev_Val=NumOfRevVal.getText();
			    System.out.print(NumOfRev_Val);
			    System.out.println(TagValQuery);
			    if(TagValQuery.contains("AND (allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3")) {
			    	TagValQuery = TagValQuery.split("AND (allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3")[0];
			    }
			    TagValQuery = TagValQuery +"AND (allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3" + NumOfRev +NumOfRev_Val;
			    FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
			    FinalQuery =FinalQuery.split("GROUP BY")[0];
			    if (BetAtrVal=="OR") {
		        	if(TagValQuery.contains("INTERSECT")) {
		        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
		        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
		        		System.out.println(TagValQuery);
		        		System.out.println(FinalQuery);
		        	 }
		        }else if (BetAtrVal=="AND") {
		        	if(TagValQuery.contains("UNION")) {
		        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
		        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
		        		System.out.println("TagValQuery");
		        		System.out.println(TagValQuery);}}
			    textPane_ExecuteQ.setText(FinalQuery);
			    System.out.println(TagValQuery);
            	Statement stNR;
				try {
					Connection conNR = DriverManager.getConnection(url,user,pass);
					stNR = conNR.createStatement();
					ResultSet rNR=stNR.executeQuery(TagValQuery);
					tagValtable.setModel(DbUtils.resultSetToTableModel(rNR));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();} 
			  }
			});
		NumOfRevVal.setColumns(10);
		NumOfRevVal.setBounds(73, 177, 83, 20);
		critic_rating.add(NumOfRevVal);
		
		textField_Val = new JTextField();
		Connection conCR = DriverManager.getConnection(url,user,pass);
		textField_Val.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent event) {
				Field_Val=textField_Val.getText();
			    System.out.print(Field_Val);
			    if(TagValQuery.contains("AND (allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3")) {
			    	TagValQuery = TagValQuery.split("AND (allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3")[0];
			    }
			    TagValQuery=TagValQuery.split("GROUP BY MT.ID,T.TAG_VALUE")[0];
			    TagValQuery = TagValQuery +"AND (allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3" + rating +Field_Val;
			    FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
			    FinalQuery =FinalQuery.split("GROUP BY")[0];
			    if (BetAtrVal=="OR") {
		        	if(TagValQuery.contains("INTERSECT")) {
		        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
		        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
		        		System.out.println(TagValQuery);
		        		System.out.println(FinalQuery);
		        	 }
		        }else if (BetAtrVal=="AND") {
		        	if(TagValQuery.contains("UNION")) {
		        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
		        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
		        		System.out.println("TagValQuery");
		        		System.out.println(TagValQuery);}}
			    textPane_ExecuteQ.setText(FinalQuery);
			    System.out.println("////////");
			    System.out.println(TagValQuery);
            	Statement stTag;
				try {
					stTag = conCR.createStatement();
					ResultSet rTag=stTag.executeQuery(TagValQuery);
					tagValtable.setModel(DbUtils.resultSetToTableModel(rTag));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}      	
            }
			});
		
		textField_Val.setBounds(73, 89, 83, 20);
		critic_rating.add(textField_Val);
		textField_Val.setColumns(10);
		
		
		JPanel panel_Year = new JPanel();
		panel_Year.setLayout(null);
		panel_Year.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Year.setBackground(SystemColor.menu);
		panel_Year.setBounds(452, 246, 166, 98);
		
		txtMovieYear = new JTextField();
		txtMovieYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMovieYear.setText("Movie Year");
		txtMovieYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieYear.setColumns(10);
		txtMovieYear.setBackground(SystemColor.controlShadow);
		txtMovieYear.setBounds(0, 0, 166, 26);
		panel_Year.add(txtMovieYear);
		
		txtFrom = new JTextField();
		txtFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFrom.setText("From:");
		txtFrom.setHorizontalAlignment(SwingConstants.LEFT);
		txtFrom.setColumns(10);
		txtFrom.setBounds(10, 40, 49, 19);
		panel_Year.add(txtFrom);
		
		txtTo = new JTextField();
		txtTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTo.setText("To :");
		txtTo.setHorizontalAlignment(SwingConstants.LEFT);
		txtTo.setColumns(10);
		txtTo.setBounds(10, 69, 49, 19);
		panel_Year.add(txtTo);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBackground(new Color(100, 149, 237));
		panel_5.setBounds(0, 266, 452, 78);
		
		txtSearchBetweenAtrribute = new JTextField();
		txtSearchBetweenAtrribute.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSearchBetweenAtrribute.setText("Search Between Atrribute Values");
		txtSearchBetweenAtrribute.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearchBetweenAtrribute.setColumns(10);
		txtSearchBetweenAtrribute.setBackground(new Color(100, 149, 237));
		txtSearchBetweenAtrribute.setBounds(0, 0, 249, 78);
		panel_5.add(txtSearchBetweenAtrribute);
		
		JComboBox comboBox_BetAtrVal = new JComboBox();
		comboBox_BetAtrVal.addActionListener(new ActionListener() {//add actionlistner to listen for change
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	BetAtrVal = (String) comboBox_BetAtrVal.getSelectedItem();//get the selected item
		        System.out.println(BetAtrVal);
		        
		        if (BetAtrVal=="OR") {
		        	if(TagValQuery.contains("INTERSECT")) {
		        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
		        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
		        		System.out.println(TagValQuery);
		        		System.out.println(FinalQuery);
		        	 }
		        }else if (BetAtrVal=="AND") {
		        	if(TagValQuery.contains("UNION")) {
		        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
		        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
		        		System.out.println("TagValQuery");
		        		System.out.println(TagValQuery);		        	
		        	}
		        }
		        textPane_ExecuteQ.setText(FinalQuery);  
				Statement stTW;
					try {
						Connection conTW = DriverManager.getConnection(url,user,pass);
						stTW = conTW.createStatement();
						ResultSet rTW=stTW.executeQuery(TagValQuery);
						tagValtable.setModel(DbUtils.resultSetToTableModel(rTW));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();} 
		    }
		});
		comboBox_BetAtrVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_BetAtrVal.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "AND", "OR"}));
		comboBox_BetAtrVal.setBounds(269, 28, 127, 21);
		panel_5.add(comboBox_BetAtrVal);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setEnabled(false);
		scrollPane_3.setBounds(618, 68, 581, 171);
		scrollPane_3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel movieTagValues = new JPanel();
		scrollPane_3.setViewportView(movieTagValues);
		movieTagValues.setLayout(null);
		movieTagValues.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		movieTagValues.setBackground(SystemColor.menu);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 10, 415, 149);
		movieTagValues.add(scrollPane);
		
		tagValtable = new JTable();
		scrollPane.setViewportView(tagValtable);
		
		JPanel tagweight_value = new JPanel();
		tagweight_value.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tagweight_value.setBackground(SystemColor.menu);
		tagweight_value.setBounds(618, 239, 581, 78);
		tagweight_value.setLayout(null);
		
		txtTagWeight = new JTextField();
		txtTagWeight.setText("Tag Weight :");
		txtTagWeight.setHorizontalAlignment(SwingConstants.LEFT);
		txtTagWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTagWeight.setColumns(10);
		txtTagWeight.setBounds(70, 7, 126, 23);
		tagweight_value.add(txtTagWeight);
		
		txtValue_TagWeight = new JTextField();
		txtValue_TagWeight.setText("Value :");
		txtValue_TagWeight.setHorizontalAlignment(SwingConstants.LEFT);
		txtValue_TagWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtValue_TagWeight.setColumns(10);
		txtValue_TagWeight.setBounds(70, 40, 126, 23);
		tagweight_value.add(txtValue_TagWeight);
		
		JComboBox comboBox_txtTagW = new JComboBox();
		comboBox_txtTagW.addActionListener(new ActionListener() {//add actionlistner to listen for change
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	txtTagW = (String) comboBox_txtTagW.getSelectedItem();//get the selected item
		        System.out.print(txtTagW);
		    }
		});
		comboBox_txtTagW.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "=", "<", ">", "<=", ">="}));
		comboBox_txtTagW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_txtTagW.setBounds(293, 7, 126, 23);
		tagweight_value.add(comboBox_txtTagW);
		
		TagWeight_Val = new JTextField();
		TagWeight_Val.addActionListener(new java.awt.event.ActionListener() {
			  public void actionPerformed(ActionEvent event) {
				  TagWe_Val=TagWeight_Val.getText();
				  System.out.print(TagWe_Val);
				  if(TagValQuery.contains("AND MT.tag_weight")) {
				    	TagValQuery = TagValQuery.split("AND MT.tag_weight")[0];
				    }
				  TagValQuery = TagValQuery +"AND MT.TAG_WEIGHT" + txtTagW + TagWe_Val;
				  FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
				  FinalQuery =FinalQuery.split("GROUP BY")[0];
				  if (BetAtrVal=="OR") {
			        	if(TagValQuery.contains("INTERSECT")) {
			        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
			        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
			        		System.out.println(TagValQuery);
			        		System.out.println(FinalQuery);
			        	 }
			        }else if (BetAtrVal=="AND") {
			        	if(TagValQuery.contains("UNION")) {
			        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
			        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
			        		System.out.println("TagValQuery");
			        		System.out.println(TagValQuery);}}
				  textPane_ExecuteQ.setText(FinalQuery);  
				  System.out.println(TagValQuery);
	            	Statement stTW;
					try {
						Connection conTW = DriverManager.getConnection(url,user,pass);
						stTW = conTW.createStatement();
						ResultSet rTW=stTW.executeQuery(TagValQuery);
						tagValtable.setModel(DbUtils.resultSetToTableModel(rTW));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();} 
			  }
			});
		TagWeight_Val.setHorizontalAlignment(SwingConstants.CENTER);
		TagWeight_Val.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TagWeight_Val.setColumns(10);
		TagWeight_Val.setBounds(293, 40, 126, 23);
		tagweight_value.add(TagWeight_Val);
		
		textField = new JTextField();
		textField.setText("Genre");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaptionBorder);
		textField.setBounds(0, 25, 141, 48);
					
	     DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
	     Connection con = DriverManager.getConnection(url,user,pass);
	     
		try {  
			Statement st = con.createStatement();
			ResultSet r=st.executeQuery("select DISTINCT(genre) from MOVIES_GEN");
			int i =0;
			int rows = 0;
			Object[][] data = new Object[20][1];
	        Object[] columnNames = {"Genre","Boolean"};
			 while (r.next()) {
				 
				 for (int f = 0; f < 1; f++) {
		            	data[rows][i] = r.getObject(i+1);
		            }
		            rows++;
				
			 }	 
			   JPanel genre = new JPanel();
				genre.setBounds(0, 73, 141, 194);
				frmMovie.getContentPane().add(genre);
				genre.setLayout(null);
				
				JScrollPane scrollPane_Genre = new JScrollPane();
				scrollPane_Genre.setBounds(0, 0, 141, 194);
				genre.add(scrollPane_Genre);
				
				table_1 = new JTable();
			 
			 DefaultTableModel model = new DefaultTableModel(data, columnNames);
			 table_1 = new JTable(model) {
		            private static final long serialVersionUID = 1L;
		            @Override
		            public Class getColumnClass(int column) {
		                switch (column) {
		                    case 0:
		                        return String.class;
		                    default:
		                        return Boolean.class;
		                }
		            }
		        };
		        
		        table_1.setPreferredScrollableViewportSize(table_1.getPreferredSize());
				scrollPane_Genre.setViewportView(table_1);
		        genre.add(scrollPane_Genre);
		        table_1.getSelectionModel().addListSelectionListener(new RowListener());
		                    
			 con.close();
			 } catch (Exception e) {  
			JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
			System.exit(0);  
			} 
		textField_2 = new JTextField();
		textField_2.setText("Country");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaptionBorder);
		textField_2.setBounds(142, 25, 156, 48);
		
		textField_4 = new JTextField();
		textField_4.setText("Movie Tag Values");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.activeCaptionBorder);
		textField_4.setBounds(618, 25, 581, 44);
		
		textField_5 = new JTextField();
		textField_5.setText("Result");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(100, 149, 237));
		textField_5.setBounds(618, 314, 581, 30);
		
		JTextArea txtrFilimingLocationCountry = new JTextArea();
		txtrFilimingLocationCountry.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtrFilimingLocationCountry.setWrapStyleWord(true);
		txtrFilimingLocationCountry.setBackground(SystemColor.activeCaptionBorder);
		txtrFilimingLocationCountry.setText(" Filiming Location  Country");
		txtrFilimingLocationCountry.setBounds(296, 25, 156, 48);
		txtrFilimingLocationCountry.setLineWrap(true);
		txtrFilimingLocationCountry.setWrapStyleWord(true);
		frmMovie.getContentPane().setLayout(null);
		frmMovie.getContentPane().add(txtMovie);
		frmMovie.getContentPane().add(textField);
		frmMovie.getContentPane().add(textField_2);
		frmMovie.getContentPane().add(txtrFilimingLocationCountry);
		frmMovie.getContentPane().add(textField_4);
		frmMovie.getContentPane().add(critic_rating);
		frmMovie.getContentPane().add(scrollPane_3);
		frmMovie.getContentPane().add(panel_Year);
		
		JComboBox comboBox_From = new JComboBox();
		//comboBox_From.setModel(new DefaultComboBoxModel(new Integer[] {}));
		comboBox_From.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_From.setBounds(80, 41, 64, 20);
		panel_Year.add(comboBox_From);
		query ="SELECT DISTINCT(YEAR) FROM MOVIES ORDER BY YEAR DESC";
		try {
    		Connection conyf = DriverManager.getConnection(url,user,pass);
   			Statement styf = conyf.createStatement();
			ResultSet ryf=styf.executeQuery(query);
			while (ryf.next()) { 
					int year_1=ryf.getInt("YEAR");
					comboBox_From.addItem(year_1);
			 }
		} catch (Exception e) {  
			JOptionPane.showMessageDialog(null,"Connection Issue","Please try again", JOptionPane.WARNING_MESSAGE);  
			System.exit(0);  
			}
		
		JComboBox comboBox_To = new JComboBox();
		//comboBox_To.setModel(new DefaultComboBoxModel(new Integer[] {}));
		comboBox_To.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_To.setBounds(80, 70, 64, 20);
		panel_Year.add(comboBox_To);

		comboBox_From.addActionListener(new ActionListener() {//add actionlistner to listen for change
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int year_from = (Integer) comboBox_From.getSelectedItem();//get the selected item
		        System.out.println(year_from);	
		        
		        String query1 ="SELECT DISTINCT(YEAR) FROM MOVIES  WHERE YEAR > "+year_from+" ORDER BY YEAR DESC";
		        try {
		    		Connection conf = DriverManager.getConnection(url,user,pass);
		   			Statement stf = conf.createStatement();
					ResultSet rf=stf.executeQuery(query1);
					System.out.println("/");
					while (rf.next()) { 
							int year_2=rf.getInt("YEAR");
							comboBox_To.addItem(year_2);
					 }
				} catch (Exception e1) {  
					JOptionPane.showMessageDialog(null,"Select a Genre","Please try again", JOptionPane.WARNING_MESSAGE);  
					System.exit(0);  
					}
		        
		        TagValQuery = TagValQuery.split("GROUP BY MT.ID,T.TAG_VALUE")[0];
		        TagValQuery=TagValQuery+"AND M.YEAR > "+year_from;
		        FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
            	FinalQuery =FinalQuery.split("GROUP BY")[0];
            	System.out.println(TagValQuery);
            	if (BetAtrVal=="OR") {
		        	if(TagValQuery.contains("INTERSECT")) {
		        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
		        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
		        		System.out.println(TagValQuery);
		        		System.out.println(FinalQuery);
		        	 }
		        }else if (BetAtrVal=="AND") {
		        	if(TagValQuery.contains("UNION")) {
		        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
		        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
		        		System.out.println("TagValQuery");
		        		System.out.println(TagValQuery);}}
		        textPane_ExecuteQ.setText(FinalQuery);
		        Statement stTag;
				try {
					DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
				    Connection conTag = DriverManager.getConnection(url,user,pass);
					stTag = conTag.createStatement();
					ResultSet rTag=stTag.executeQuery(TagValQuery);
					tagValtable.setModel(DbUtils.resultSetToTableModel(rTag));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
		    }
		});
		
		
		
		comboBox_To.addActionListener(new ActionListener() {//add actionlistner to listen for change
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int year_to = (Integer) comboBox_To.getSelectedItem();//get the selected item
		        System.out.print(year_to);
		        TagValQuery=TagValQuery+"AND M.YEAR < "+year_to;
		        FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
            	FinalQuery =FinalQuery.split("GROUP BY")[0];
            	System.out.println(TagValQuery);
            	if (BetAtrVal=="OR") {
		        	if(TagValQuery.contains("INTERSECT")) {
		        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
		        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
		        		System.out.println(TagValQuery);
		        		System.out.println(FinalQuery);
		        	 }
		        }else if (BetAtrVal=="AND") {
		        	if(TagValQuery.contains("UNION")) {
		        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
		        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
		        		System.out.println("TagValQuery");
		        		System.out.println(TagValQuery);}}
		        textPane_ExecuteQ.setText(FinalQuery);
		        Statement stTag;
				try {
					DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
				    Connection conTag = DriverManager.getConnection(url,user,pass);
					stTag = conTag.createStatement();
					ResultSet rTag=stTag.executeQuery(TagValQuery);
					tagValtable.setModel(DbUtils.resultSetToTableModel(rTag));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
		    }
		});
				
		frmMovie.getContentPane().add(textField_5);
		frmMovie.getContentPane().add(tagweight_value);
		frmMovie.getContentPane().add(panel_5);
		
		JButton btnExecuteQuery = new JButton("Execute Query");
		btnExecuteQuery.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExecuteQuery.setBounds(188, 579, 150, 31);
		frmMovie.getContentPane().add(btnExecuteQuery);
		
		btnExecuteQuery.addActionListener(new java.awt.event.ActionListener() {
			  public void actionPerformed(ActionEvent event) {
				  
				  System.out.println(TagValQuery);
				  System.out.print(TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1]);
				  FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];  
				  FinalQuery =FinalQuery.split("GROUP BY")[0];
				  if (BetAtrVal=="OR") {
			        	if(TagValQuery.contains("INTERSECT")) {
			        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
			        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
			        		System.out.println(TagValQuery);
			        		System.out.println(FinalQuery);
			        	 }
			        }else if (BetAtrVal=="AND") {
			        	if(TagValQuery.contains("UNION")) {
			        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
			        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
			        		System.out.println("TagValQuery");
			        		System.out.println(TagValQuery);}}
				  System.out.println(FinalQuery);
	            	Statement stFQ;
					try {
						Connection conFQ = DriverManager.getConnection(url,user,pass);
						stFQ = conFQ.createStatement();
						ResultSet rFQ=stFQ.executeQuery(FinalQuery);
						table_result.setModel(DbUtils.resultSetToTableModel(rFQ));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();} 
			  }
			});
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 354, 608, 215);
		frmMovie.getContentPane().add(scrollPane_2);
		
		textPane_ExecuteQ = new JTextPane();
		scrollPane_2.setViewportView(textPane_ExecuteQ);
		textPane_ExecuteQ.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPane_ExecuteQ.setBackground(SystemColor.menu);
		StyledDocument doc = textPane_ExecuteQ.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		country = new JPanel();
		country.setBounds(142, 73, 156, 194);
		frmMovie.getContentPane().add(country);
		country.setLayout(null);
		
		scrollPane_con = new JScrollPane();
		scrollPane_con.setBounds(0, 0, 156, 194);
		country.add(scrollPane_con);
		
		table_con = new JTable();
		scrollPane_con.setViewportView(table_con);
		
		location = new JPanel();
		location.setBounds(296, 73, 156, 194);
		frmMovie.getContentPane().add(location);
		location.setLayout(null);
		
		scrollPane_loc = new JScrollPane();
		scrollPane_loc.setBounds(0, 0, 156, 194);
		location.add(scrollPane_loc);
		
		table_loc = new JTable();
		scrollPane_loc.setViewportView(table_loc);
		
		JPanel panel_result = new JPanel();
		panel_result.setBounds(628, 354, 571, 215);
		frmMovie.getContentPane().add(panel_result);
		panel_result.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 571, 215);
		panel_result.add(scrollPane_1);
		
		table_result = new JTable();
		scrollPane_1.setViewportView(table_result);
		
		table_result.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	            System.out.println(table_result.getValueAt(table_result.getSelectedRow(), 0).toString());
	        }
	    });
	
	}
	
   private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            
            genre_index.add(table_1.getSelectionModel().getLeadSelectionIndex());
            System.out.print(genre_index);
            for (Integer s : genre_index) {
            	path =(String) table_1.getValueAt(s, 0);
                if(TagValQuery.contains("WHERE MG.GENRE =")) {
                	
                	if(!(TagValQuery.contains("MG.GENRE ='"+path))) {
                	TagValQuery = TagValQuery.split(" GROUP BY")[0];
                    TagValQuery = TagValQuery.substring(0,TagValQuery.length()-1);;
                	TagValQuery = TagValQuery+ "UNION SELECT MG.MOVIEID FROM MOVIES_GEN MG WHERE MG.GENRE ="+"'"+path+"') GROUP BY MT.ID,T.TAG_VALUE";               	
                	}
                   	FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
                   	FinalQuery =FinalQuery.split("GROUP BY")[0];
                }  
                else{
                	TagValQuery = TagValQuery.split("GROUP BY")[0];
                	TagValQuery ="SELECT DISTINCT MT.ID,T.TAG_VALUE FROM TAG_VALUES T ,MOVIE_TAG_VALUES MT ,MOVIES_GEN MG ,MOVIES M,MOVIES_LOC MC WHERE M.MOVIEID = MC.MOVIEID AND T.ID = MT.TAG_ID AND MT.ID = MG.MOVIEID AND MG.MOVIEID = M.MOVIEID AND M.MOVIEID IN(SELECT MG.MOVIEID FROM MOVIES_GEN MG WHERE MG.GENRE ="+"'"+path+"'"+") GROUP BY MT.ID,T.TAG_VALUE";
                	FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
                	FinalQuery =FinalQuery.split("GROUP BY")[0];}
            	}
            
            if (BetAtrVal=="OR") {
	        	if(TagValQuery.contains("INTERSECT")) {
	        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
	        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
	        		System.out.println(TagValQuery);
	        		System.out.println(FinalQuery);
	        	 }
	        }else if (BetAtrVal=="AND") {
	        	if(TagValQuery.contains("UNION")) {
	        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
	        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
	        		System.out.println("TagValQuery");
	        		System.out.println(TagValQuery);}}
        	textPane_ExecuteQ.setText(FinalQuery);
        	Statement stTag;
			try {
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			    Connection conTag = DriverManager.getConnection(url,user,pass);
				stTag = conTag.createStatement();
				ResultSet rTag=stTag.executeQuery(TagValQuery);
				tagValtable.setModel(DbUtils.resultSetToTableModel(rTag));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}	
			
			query =TagValQuery.split("MG.MOVIEID = M.MOVIEID AND")[1];
			query =query.split("GROUP BY MT.ID,T.TAG_VALUE")[0];
        	query = "SELECT DISTINCT(M.COUNTRY) FROM MOVIES M WHERE M.MOVIEID IN( SELECT Distinct(MG.MOVIEID) from MOVIES_GEN MG WHERE "+query+")";
        	System.out.println(query);
        	int i =0;
			int rows = 0;
			Object[][] data = new Object[72][1];
	        Object[] columnNames = {"Country","Boolean"};
	        
        	try {
        		Connection con2 = DriverManager.getConnection(url,user,pass);
       			Statement st2 = con2.createStatement();
				st2 = con2.createStatement();
				ResultSet r2=st2.executeQuery(query);
				while (r2.next()) { 
						for (int f = 0; f < 1; f++) {
			            	data[rows][i] = r2.getObject(i+1);
			            }rows++;
				 }
			} catch (Exception e) {  
				JOptionPane.showMessageDialog(null,"Only 2 selection allowed","Please select again", JOptionPane.WARNING_MESSAGE);  
				System.exit(0);  
				}
        	
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
	        table_con = new JTable(model) {
	        	
	            private static final long serialVersionUID = 1L;

	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
	            @Override
	            public Class getColumnClass(int column) {
	                switch (column) {
	                    case 0:
	                        return String.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	        };
	        table_con.setPreferredScrollableViewportSize(table_con.getPreferredSize());
			scrollPane_con.setViewportView(table_con);
	        country.add(scrollPane_con);
	        table_con.getSelectionModel().addListSelectionListener(new RowListenerCon());  
        }
    }
	
   private class RowListenerCon implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            con_index.add(table_con.getSelectionModel().getLeadSelectionIndex());
            
            for (Integer s : con_index) {
            	path_con =(String) table_con.getValueAt(s, 0);
                if(TagValQuery.contains("WHERE M.COUNTRY =")) {
                	//TagValQuery = TagValQuery.split("INTERSECT")[0];
                	if(!(TagValQuery.contains("M.COUNTRY = '"+path_con+"'"))) {
                	TagValQuery = TagValQuery.split(" GROUP BY")[0];
                	TagValQuery = TagValQuery.substring(0, TagValQuery.length() - 1);
                	TagValQuery=TagValQuery +"UNION SELECT M.MOVIEID FROM MOVIES M WHERE M.COUNTRY = "+"'"+path_con+"') GROUP BY MT.ID,T.TAG_VALUE"; }
                   	FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
                   	FinalQuery =FinalQuery.split("GROUP BY")[0];
                }  
                else{
                	TagValQuery = TagValQuery.split("GROUP BY")[0];
                	TagValQuery=TagValQuery+"AND M.MOVIEID IN(SELECT M.MOVIEID FROM MOVIES M WHERE M.COUNTRY = "+"'"+path_con+"')";
					FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
					FinalQuery =FinalQuery.split("GROUP BY")[0];
            	}}
            if (BetAtrVal=="OR") {
	        	if(TagValQuery.contains("INTERSECT")) {
	        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
	        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
	        		System.out.println(TagValQuery);
	        		System.out.println(FinalQuery);
	        	 }
	        }else if (BetAtrVal=="AND") {
	        	if(TagValQuery.contains("UNION")) {
	        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
	        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");
	        		System.out.println("TagValQuery");
	        		System.out.println(TagValQuery);}}
        	textPane_ExecuteQ.setText(FinalQuery);
        	Statement stTag;
			try {
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			    Connection conTag = DriverManager.getConnection(url,user,pass);
				stTag = conTag.createStatement();
				ResultSet rTag=stTag.executeQuery(TagValQuery);
				tagValtable.setModel(DbUtils.resultSetToTableModel(rTag));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}	
			System.out.println(TagValQuery);
			query =TagValQuery.split("MG.MOVIEID = M.MOVIEID AND M.MOVIEID")[1];
			query =query.split("GROUP BY MT.ID,T.TAG_VALUE")[0];
        	query = "Select DISTINCT(MC.LOCATION) FROM MOVIES_LOC MC,MOVIES M WHERE MC.MOVIEID=M.MOVIEID AND MC.MOVIEID "+query;
			System.out.println(query);
        	int i =0;
			int rows = 0;
			Object[][] data = new Object[500][1];
	        Object[] columnNames = {"Location","Boolean"};
        	try {
        		Connection con3 = DriverManager.getConnection(url,user,pass);
       			Statement st3 = con3.createStatement();
				st3 = con3.createStatement();
				ResultSet r3=st3.executeQuery(query);
				
				while (r3.next()) { 
						for (int f = 0; f < 1; f++) {
			            	data[rows][i] = r3.getObject(i+1);
			            }rows++;
				 }
						    
						 
			} catch (Exception e) {  
				JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
				System.exit(0);  
				} 
        	
        	DefaultTableModel model = new DefaultTableModel(data, columnNames);
	        table_loc = new JTable(model) {
	        	
	            private static final long serialVersionUID = 1L;

	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
	            @Override
	            public Class getColumnClass(int column) {
	                switch (column) {
	                    case 0:
	                        return String.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	        };
	        
	        table_loc.setPreferredScrollableViewportSize(table_loc.getPreferredSize());
			scrollPane_loc.setViewportView(table_loc);
	        location.add(scrollPane_loc);
	        table_loc.getSelectionModel().addListSelectionListener(new RowListenerLoc()); 
	                 
        }
    }
   
   private class RowListenerLoc implements ListSelectionListener {
       public void valueChanged(ListSelectionEvent event) {
           if (event.getValueIsAdjusting()) {
               return;
           }
           
       	   loc_index.add(table_loc.getSelectionModel().getLeadSelectionIndex());
       	   for (Integer s : loc_index) {
        	path_loc =(String) table_loc.getValueAt(s, 0);
            if(TagValQuery.contains("WHERE ML.LOCATION =")) {
            	if(!(TagValQuery.contains("ML.LOCATION = "+"'"+path_loc+"'"))) {
            	TagValQuery = TagValQuery.split(" GROUP BY")[0];
            	TagValQuery = TagValQuery.substring(0, TagValQuery.length() - 1);
            	TagValQuery=TagValQuery +"UNION SELECT ML.MOVIEID FROM MOVIES_LOC ML WHERE ML.LOCATION = "+"'"+path_loc+"') GROUP BY MT.ID,T.TAG_VALUE"; 
            	}
               	FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
               	FinalQuery =FinalQuery.split("GROUP BY")[0];
            	
            }  
            else{
            	TagValQuery = TagValQuery.split("GROUP BY")[0];
            	TagValQuery=TagValQuery+"AND M.MOVIEID IN(SELECT ML.MOVIEID FROM MOVIES_LOC ML WHERE ML.LOCATION = "+"'"+path_loc+"')";
				FinalQuery ="SELECT DISTINCT M.MOVIEID, M.TITLE,MG.GENRE,M.YEAR,M.COUNTRY,MC.LOCATION,(allCriticsRating+rtTopCriticsRating+rtAudienceRating)/ 3 AS AVG_RATING,(allCriticsNumReviews+rtTopCriticsNumReviews+rtAudienceNumRatings)/3 as AVG_REV "+ TagValQuery.split("SELECT DISTINCT MT.ID,T.TAG_VALUE ")[1];
				FinalQuery =FinalQuery.split("GROUP BY")[0];
				}
            }
       	if (BetAtrVal=="OR") {
        	if(TagValQuery.contains("INTERSECT")) {
        		TagValQuery=TagValQuery.replaceAll("INTERSECT", "UNION");
        		FinalQuery=FinalQuery.replaceAll("INTERSECT", "UNION");
        		System.out.println(TagValQuery);
        		System.out.println(FinalQuery);
        	 }
        }else if (BetAtrVal=="AND") {
        	if(TagValQuery.contains("UNION")) {
        		TagValQuery=TagValQuery.replaceAll("UNION", "INTERSECT");
        		FinalQuery=FinalQuery.replaceAll("UNION", "INTERSECT");}}  
       	textPane_ExecuteQ.setText(FinalQuery);
       	Statement stTag;
			try {
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			    Connection conTag = DriverManager.getConnection(url,user,pass);
				stTag = conTag.createStatement();
				ResultSet rTag=stTag.executeQuery(TagValQuery);
				tagValtable.setModel(DbUtils.resultSetToTableModel(rTag));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
       }
   }
}


