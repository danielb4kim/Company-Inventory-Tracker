/**
 * MainProgram
 * The Best Version
 * @author Daniel Kim
 * Date
 * Class containing all GUI and operations with other classes
 */

/* ---- Importing all things used by the program ---- */
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("serial")
public class MainProgram extends JFrame {
	/* ---- Initialization and declaration of variables ---- */
	
	//Files holding inventory info
	File listOfInstruments = new File("Instruments.txt");
	File listOfMusic = new File("Music.txt");
	File listOfEquipment = new File("Equipment.txt");
	
	//Scanners to read in from files
	Scanner instrumentInput;
	Scanner musicInput;
	Scanner equipmentInput;
	
	//Types of objects stored in database
	Instrument instrument;
	SheetMusic sheetMusic;
	Equipment equipment;
	
	//Lists storing info from text files
	InstrumentInputData iID = new InstrumentInputData();
	MusicInputData mID = new MusicInputData();
	EquipmentInputData eID = new EquipmentInputData();
	
	//Lists storing names of items in inventory
	InstrumentNames instrumentNames = new InstrumentNames();
	MusicNames musicNames = new MusicNames();
	EquipmentNames equipmentNames = new EquipmentNames();
	InDeptInv inDeptNames = new InDeptInv();
	AllInv allNames = new AllInv();
	SignedOutInv signOutNames = new SignedOutInv();
	BadInv badNames = new BadInv();
	
	//Lists storing object info
	InstrumentList iL = new InstrumentList();
	SheetMusicList sML = new SheetMusicList();
	EquipmentList eL = new EquipmentList();
	
	//Combo boxes for inventories
	JComboBox<String> instrumentInv = new JComboBox<String>();
	JComboBox<String> sheetMusicInv = new JComboBox<String>();
	JComboBox<String> equipmentInv = new JComboBox<String>();
	JComboBox<String> inDeptInv = new JComboBox<String>();
	JComboBox<String> signedOutInv = new JComboBox<String>();
	JComboBox<String> badInv = new JComboBox<String>();

	//Combo boxes for condition selections while adding
	JComboBox<String> addIEConditions = new JComboBox<String>();
	JComboBox<String> addSMConditions = new JComboBox<String>();
	
	/* ---- All panels used in program ---- */
	
	//Menu panels
	private JPanel menuPanel;
	private JPanel titlePanel;
	private JPanel calendarPanel;
	private JPanel noticeUpdatePanel;
	private JPanel topButtonsPanel;
	private JPanel bottomButtonsPanel;
	
	//Sign-out panels
	private JPanel signOutPanel;
	private JPanel signOutHeaderPanel;
	private JPanel signOutList1Panel;
	private JPanel signOutList2Panel;
	private JPanel signOutList3Panel;
	private JPanel signOutFunctionsPanel;
	private JPanel signOutStudentPanel;
	private JPanel signOutMessagePanel;
	private JPanel signOutButtonsPanel;
	
	//Return panels
	private JPanel returnPanel;
	private JPanel returnHeaderPanel;
	private JPanel returnOptionsPanel;
	private JPanel returnMessagePanel;
	private JPanel returnButtonsPanel;
	
	//View panels
	private JPanel viewPanel;
	private JPanel viewHeaderPanel;
	private JPanel viewCenterPanel;
	private JPanel viewCenterLeftPanel;
	private JPanel viewCenterRightPanel;
	private JPanel viewListPanel;
	private JPanel viewSortButtonsPanel;
	private JPanel viewSpecsPanel;
	private JPanel viewButtonsPanel;
	
	//Notice panels
	private JPanel noticePanel;
	private JPanel noticeHeaderPanel;
	private JPanel noticeCenterPanel;
	private JPanel noticeDescPanel;
	private JPanel noticeButtonsPanel;
	
	//Add panels
	private JPanel addPanel;
	private JPanel addHeaderPanel;
	private JPanel addDescPanel1;
	private JPanel addDescPanel2;
	private JPanel addDescPanel3;
	private JPanel addDescPanel4;
	private JPanel addDescPanel5;
	private JPanel addButtonsPanel;
	private JPanel addAllOptionsPanel;
	private JPanel addMessagePanel;
	private JPanel addBottomPanel;

	//Remove panels
	private JPanel removePanel;
	private JPanel removeHeaderPanel;
	private JPanel removeListPanel;
	private JPanel removeMessagePanel;
	private JPanel removeButtonsPanel;
	
	//Repair panels
	private JPanel repairPanel;
	private JPanel repairHeaderPanel;
	private JPanel repairListPanel;
	private JPanel repairMessagePanel;
	private JPanel repairButtonsPanel;
	
	/* ---- All buttons used in program ---- */
	
	//All menu panel buttons
	private JButton signOutButton;
	private JButton returnButton;
	private JButton viewButton;
	private JButton noticeButton;
	private JButton nextDayButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton repairButton;
	private JButton quitButton;
	
	//All sign-out panel buttons
	private JButton soObjectButton;
	private JButton soMenuButton;
	
	//All return panel buttons
	private JButton returnObjectButton;
	private JButton returnMenuButton;
	
	//All view panel buttons
	private JButton alphaSortButton;
	private JButton dueDateSortButton;
	private JButton nextButton;
	private JButton previousButton;
	private JButton viewMenuButton;
	
	//All notice panel buttons
	private JButton noticeMenuButton;
	
	//All add panel buttons
	private JButton addObjectButton;
	private JButton addMenuButton;
	
	//Radio buttons for adding to inventories
	private JRadioButton instrumentButton;
	private JRadioButton musicButton;
	private JRadioButton equipmentButton;
	
	//All remove buttons
	private JButton removeMenuButton;
	private JButton removeObjectButton;
	
	//All repair panel buttons
	private JButton repairObjectButton;
	private JButton repairMenuButton;
	
	//Booleans used for radio buttons
	boolean rButtonInst = false;
	boolean rButtonMusic = false;
	boolean rButtonEquip = false;
	
	//Booleans used for condition combo boxes
	private boolean ieConditionVis = false;
	private boolean smConditionVis = false;
	
	//Variables used for calendar
	LocalDate today = LocalDate.now();
	LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
	LocalDate afterWeekend = today.plus(3, ChronoUnit.DAYS);
	
	/* ---- All labels used in program ---- */
	
	//Menu labels
	private JLabel title = new JLabel("Music Department Resource Tracker");	
	private JLabel todaysDate = new JLabel("Today's Date: " + today);
	private JLabel noticeUpdate = new JLabel("No new notices");
	
	//Sign-out Labels
	private JLabel signOutHeader = new JLabel("Sign-out Something");
	private JLabel signOutSubHeader = new JLabel("<html>Any object that is signed out must be returned by the end of the next school day<br>Dysfunctional objects or objects not present in the music room cannot be signed out</html>");
	private JLabel soILabel = new JLabel("Instruments");
	private JLabel soMLabel = new JLabel("Sheet Music");
	private JLabel soELabel = new JLabel("Equipment");
	private JLabel studentNameLabel = new JLabel("Student name:");
	private JLabel signOutMessageLabel1 = new JLabel();
	private JLabel signOutMessageLabel2 = new JLabel();
	private JLabel signOutMessageLabel3 = new JLabel();
	
	//Return Labels
	private JLabel returnHeader = new JLabel("Return Something");
	private JLabel signedOutInvLabel = new JLabel("List of signed-out items");
	private JLabel returnMessageLabel = new JLabel();
	
	//View Labels
	private JLabel viewHeader = new JLabel("View Inventories");
	private JLabel viewSubHeader = new JLabel("<html>Click on an item in the list to view more details or use the next and previous<br>buttons to browse through the inventory<br>Only one sorting option can remain active at a time, with the exception of reverse sorting</html>");
	private JLabel viewSortButtonsLabel = new JLabel("Sort by:");
	private JLabel viewSpecsLabel = new JLabel("Item Description:");
	private JLabel viewNameLabel = new JLabel();
	private JLabel viewDesc1Label = new JLabel();
	private JLabel viewDesc2Label = new JLabel();
	private JLabel viewConditionLabel = new JLabel();
	private JLabel viewStatusLabel = new JLabel();
	private JLabel viewDueDateLabel = new JLabel();
	private JLabel viewStudentLastLabel = new JLabel();
	
	//Notice Labels
	private JLabel noticeHeader = new JLabel("Notices");
	private JLabel noticeSubHeader = new JLabel("View notifications here");
	private JLabel noticeDescLabel = new JLabel();
	
	//Add Labels
	private JLabel addHeader = new JLabel("Add to Inventory");
	private JLabel addSubHeader = new JLabel("<html>The music department must be in possession of an object for it to be added<br>All fields must be filled in before the object can be added</html>");
	private JLabel rButtonILabel = new JLabel("Instrument");
	private JLabel rButtonMLabel = new JLabel("Sheet Music");
	private JLabel rButtonELabel = new JLabel("Equipment");
	private JLabel nameLabel = new JLabel();
	private JLabel numberLabel = new JLabel();
	private JLabel descLabel1 = new JLabel();
	private JLabel descLabel2 = new JLabel();
	private JLabel conditionLabel = new JLabel();
	private JLabel addMessageLabel =  new JLabel();
	
	//Remove Labels
	private JLabel removeHeader = new JLabel("Remove From Inventory");
	private JLabel removeSubHeader = new JLabel("The music department must be in possession of an object for it to be removed");
	private JLabel removeInvLabel = new JLabel("Select an item to remove");
	private JLabel removeMessageLabel = new JLabel();
	
	//Repair Labels
	private JLabel repairHeader = new JLabel("Repair Dysfunctional Objects");
	private JLabel repairSubHeader = new JLabel("<html>Only dysfunctional items will appear in the list below<br>Instruments and equipment require three days to be repaired, sheet music is replaced immediately<br>Inventory will be automatically returned to the sign-out lists when repaired</html>");
	private JLabel repairInvLabel = new JLabel("Select an item to repair");
	private JLabel repairMessageLabel = new JLabel();
	
	//All text fields used in program
	private JTextField nameField = new JTextField();
	private JTextField numberField = new JTextField();
	private JTextField descField1 = new JTextField();
	private JTextField descField2 = new JTextField();
	private JTextField studentName = new JTextField(15);
	
	//Grouping radio buttons
	ButtonGroup addOptions = new ButtonGroup();
	
	//Creating JList
	DefaultListModel<Object> listModel = new DefaultListModel<Object>();
	DefaultListModel<String> viewListModel = new DefaultListModel<String>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JList viewList = new JList(viewListModel);
	int listIndex = 0;
	JScrollPane listScroller = new JScrollPane(viewList);
	
	//Creating notice list
	DefaultListModel<String> noticeModel = new DefaultListModel<String>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JList noticeList = new JList(noticeModel);
	JScrollPane noticeListScroller = new JScrollPane(noticeList);
	boolean newNotice = false;
	int noticeCounter = 0;
	
	//Image icon for JFrame
	ImageIcon img = new ImageIcon("MusicIsTrash.png");
	
	int dayCount = 0;// Counter for days passed
	
	//Constructor
	MainProgram() {
		//Constructing frame
		super("Music Dept. Resource Tracker");
		this.setSize(1250, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(img.getImage());
		
		//Inputting data from files
		try {
			//Creating scanners for each object
			instrumentInput = new Scanner(listOfInstruments);
			musicInput = new Scanner(listOfMusic);
			equipmentInput = new Scanner(listOfEquipment);
		} catch (FileNotFoundException f) { }// end of try catch
		
		//Adding data to separate lists based on object type
		while (instrumentInput.hasNext()) {
			iID.add(instrumentInput.nextLine());
		}// end of while
		
		while (musicInput.hasNext()) {
			mID.add(musicInput.nextLine());
		}// end of while
		
		while (equipmentInput.hasNext()) {
			eID.add(equipmentInput.nextLine());
		}// end of while

		//Initially adding a blank to each combo box
		instrumentInv.addItem(null);
		sheetMusicInv.addItem(null);
		equipmentInv.addItem(null);
		inDeptInv.addItem(null);
		signedOutInv.addItem(null);
		badInv.addItem(null);
		
		//Creating separate instruments based on input data and adding to different lists
		for (int i = 0; i < (iID.getSize())/5; i++) {
			//Creating instrument and adding to list
			instrument = new Instrument(iID.get(i*5), iID.get((i*5)+1), iID.get((i*5)+2), iID.get((i*5)+3), iID.get((i*5)+4));
			iL.addInstrument(instrument);
			
			String instFileName = instrument.getFullName();// String used when adding to combo box
			
			//Add to sign-out list + combo box if condition is good
			if (instrument.getCondition().equals("Functional")) {
				instrumentNames.add(instrument);
				instrumentInv.addItem(instFileName);
			}// end of if
			
			//Add to dysfunctional list + combo box if otherwise
			else {
				badInvAdd(instrument);
			}// end of else
			
			allNames.add(instrument);
			allNames.sortAlpha();
			inDeptInvAdd(instrument);// Call to method to add instrument
			listModelAdd(instrument);// Call to method to add to JList
		}// end of i for

		//Creating sheet music based on input data and adding to different lists
		for (int m = 0; m < (mID.getSize())/5; m++) {
			//Creating sheet music and adding to list
			sheetMusic = new SheetMusic(mID.get(m*5), mID.get((m*5)+1), mID.get((m*5)+2), mID.get((m*5)+3), mID.get((m*5)+4));
			sML.addSheetMusic(sheetMusic);
			
			String musFileName = sheetMusic.getName() + " " + sheetMusic.getNumber();// String used when adding to combo box
			
			//Add to sign-out list + combo box if music is available
			if (sheetMusic.getCondition().equals("Available")) {
				musicNames.add(sheetMusic);
				sheetMusicInv.addItem(musFileName);
			}// end of if
			
			//Add to dysfunctional list + combo box if otherwise
			else {
				badInvAdd(sheetMusic);
			}// end of else
			
			
			allNames.add(sheetMusic);
			allNames.sortAlpha();
			inDeptInvAdd(sheetMusic);// Call to method to add sheet music
			listModelAdd(sheetMusic);// Call to method to add to JList
		}// end of m for
		
		//Creating separate equipment based on input data and adding to different lists
		for (int e = 0; e < (eID.getSize())/5; e++) {
			//Creating equipment and adding to list
			equipment = new Equipment(eID.get(e*5), eID.get((e*5)+1), eID.get((e*5)+2), eID.get((e*5)+3), eID.get((e*5)+4));
			eL.addEquipment(equipment);
			
			String equFileName = equipment.getName() + " " + equipment.getNumber();// String used when adding to combo box
			
			//Add to sign-out list if condition is good
			if (equipment.getCondition().equals("Functional")) {
				equipmentNames.add(equipment);
				equipmentInv.addItem(equFileName);
			}// end of if
			
			//Add to dysfunctional list + combo box if otherwise
			else {
				badInvAdd(equipment);
			}// end of else
			
			allNames.add(equipment);
			allNames.sortAlpha();
			inDeptInvAdd(equipment);// Call to method to add equipment
			listModelAdd(equipment);// Call to method to add to JList
		}// end of e for

		//Creating default fonts used for the components
		Font defaultButtonFont = new Font("SansSerif", Font.BOLD, 30);
		Font defaultHeaderFont = new Font("SansSerif", Font.BOLD, 50);
		Font defaultLabelFont = new Font("SansSerif", Font.BOLD, 16);
		Font customFont = new Font("SansSerif", Font.BOLD, 22);
		
		/* ---- Code for All Buttons in Program ---- */
		signOutButton = new JButton("Sign-out");
		signOutButton.setFont(defaultButtonFont);
		signOutButton.addActionListener(new ButtonListenerSignOut());
		
		soObjectButton = new JButton("Sign-out");
		soObjectButton.setFont(defaultButtonFont);
		soObjectButton.addActionListener(new ButtonListenerSignOutObject());
		
		returnButton = new JButton("Return");
		returnButton.setFont(defaultButtonFont);
		returnButton.addActionListener(new ButtonListenerReturn());
		
		returnObjectButton = new JButton("Return");
		returnObjectButton.setFont(defaultButtonFont);
		returnObjectButton.addActionListener(new ButtonListenerReturnObject());
		
		viewButton = new JButton("View");
		viewButton.setFont(defaultButtonFont);
		viewButton.addActionListener(new ButtonListenerView());
		
		alphaSortButton = new JButton("Name");
		alphaSortButton.setFont(customFont);
		alphaSortButton.addActionListener(new ButtonListenerAlphaSort());
		
		dueDateSortButton = new JButton("Due Date");
		dueDateSortButton.setFont(customFont);
		dueDateSortButton.addActionListener(new ButtonListenerDueDateSort());
		
		nextButton = new JButton("Next");
		nextButton.setFont(defaultButtonFont);
		nextButton.addActionListener(new ButtonListenerNext());
		
		previousButton = new JButton("Previous");
		previousButton.setFont(defaultButtonFont);
		previousButton.addActionListener(new ButtonListenerPrevious());
		
		nextDayButton = new JButton("Next Day");
		nextDayButton.setFont(defaultButtonFont);
		nextDayButton.addActionListener(new ButtonListenerNextDay());
		
		noticeButton = new JButton("Notice");
		noticeButton.setFont(defaultButtonFont);
		noticeButton.addActionListener(new ButtonListenerNotice());
		
		noticeMenuButton = new JButton("Menu");
		noticeMenuButton.setFont(defaultButtonFont);
		noticeMenuButton.addActionListener(new ButtonListenerNMenu());
		
		addButton = new JButton("Add");
		addButton.setFont(defaultButtonFont);
		addButton.addActionListener(new ButtonListenerAdd());
		
		addObjectButton = new JButton("Add to Inventory");
		addObjectButton.setFont(defaultButtonFont);
		addObjectButton.addActionListener(new ButtonListenerAddObject());
		
		instrumentButton = new JRadioButton();
		instrumentButton.setActionCommand("Instrument");
		instrumentButton.addActionListener(new ButtonListenerRButtonI());
		
		musicButton = new JRadioButton();
		musicButton.setActionCommand("Sheet Music");
		musicButton.addActionListener(new ButtonListenerRButtonM());
		
		equipmentButton = new JRadioButton();
		equipmentButton.setActionCommand("Equipment");
		equipmentButton.addActionListener(new ButtonListenerRButtonE());
		
		addOptions.add(instrumentButton);
		addOptions.add(musicButton);
		addOptions.add(equipmentButton);
		
		removeButton = new JButton("Remove");
		removeButton.setFont(defaultButtonFont);
		removeButton.addActionListener(new ButtonListenerRemove());
		
		removeObjectButton = new JButton("Remove");
		removeObjectButton.setFont(defaultButtonFont);
		removeObjectButton.addActionListener(new ButtonListenerRemoveObject());
		
		repairButton = new JButton("Repair");
		repairButton.setFont(defaultButtonFont);
		repairButton.addActionListener(new ButtonListenerRepair());
		
		repairObjectButton = new JButton("Repair");
		repairObjectButton.setFont(defaultButtonFont);
		repairObjectButton.addActionListener(new ButtonListenerRepairObject());
		
		soMenuButton = new JButton("Menu");
		soMenuButton.setFont(defaultButtonFont);
		soMenuButton.addActionListener(new ButtonListenerSMenu());
		
		returnMenuButton = new JButton("Menu");
		returnMenuButton.setFont(defaultButtonFont);
		returnMenuButton.addActionListener(new ButtonListenerRetMenu());
		
		viewMenuButton = new JButton("Menu");
		viewMenuButton.setFont(defaultButtonFont);
		viewMenuButton.addActionListener(new ButtonListenerVMenu());
		
		addMenuButton = new JButton("Menu");
		addMenuButton.setFont(defaultButtonFont);
		addMenuButton.addActionListener(new ButtonListenerAMenu());
		
		removeMenuButton = new JButton("Menu");
		removeMenuButton.setFont(defaultButtonFont);
		removeMenuButton.addActionListener(new ButtonListenerRemMenu());
		
		repairMenuButton = new JButton("Menu");
		repairMenuButton.setFont(defaultButtonFont);
		repairMenuButton.addActionListener(new ButtonListenerRepMenu());
		
		quitButton = new JButton("Quit");
		quitButton.setFont(defaultButtonFont);
		quitButton.addActionListener(new ButtonListenerQuit());
		
		/* ---- End of Button Code ---- */
		
		//Some combo box additions
		addIEConditions = new JComboBox<String>();
		addIEConditions.addItem("Functional");
		addIEConditions.addItem("Dysfunctional");
		
		addSMConditions = new JComboBox<String>();
		addSMConditions.addItem("Available");
		addSMConditions.addItem("Missing");
		
		//Declaring dimensions used for panels
		int panelX = 1250;
		int panelY = 600;
		
		/* ---- Code for Menu Panel ---- */
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
		menuPanel.setSize(panelX, panelY);
		menuPanel.setVisible(true);
		
		titlePanel = new JPanel();
		title.setFont(defaultHeaderFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(title);
		titlePanel.setVisible(true);
				
		calendarPanel = new JPanel();
		calendarPanel.setSize(panelX, panelY/12);
		todaysDate.setFont(defaultLabelFont);
		calendarPanel.add(todaysDate);
		
		noticeUpdatePanel = new JPanel();
		noticeUpdatePanel.setSize(panelX, panelY/12);
		noticeUpdate.setFont(defaultLabelFont);
		noticeUpdatePanel.add(noticeUpdate);
		
		topButtonsPanel = new JPanel();
		topButtonsPanel.setLayout(new FlowLayout());
		topButtonsPanel.setSize(panelX, panelY/6);
		topButtonsPanel.add(signOutButton);
		topButtonsPanel.add(returnButton);
		topButtonsPanel.add(viewButton);
		topButtonsPanel.add(nextDayButton);
		topButtonsPanel.setVisible(true);
		
		bottomButtonsPanel = new JPanel();
		bottomButtonsPanel.setLayout(new FlowLayout());
		bottomButtonsPanel.setSize(panelX, panelY/6);
		bottomButtonsPanel.add(noticeButton);
		bottomButtonsPanel.add(addButton);
		bottomButtonsPanel.add(removeButton);
		bottomButtonsPanel.add(repairButton);
		bottomButtonsPanel.add(quitButton);
		bottomButtonsPanel.setVisible(true);
		
		menuPanel.add(titlePanel);
		menuPanel.add(calendarPanel);
		menuPanel.add(noticeUpdatePanel);
		menuPanel.add(topButtonsPanel);
		menuPanel.add(bottomButtonsPanel);
		this.add(menuPanel);
		
		/* ---- End of Menu Panel ---- */
		
		/* ---- Code for Sign-out Panel ---- */
		
		signOutPanel = new JPanel();
		signOutPanel.setSize(panelX, panelY);
		signOutPanel.setLayout(new BoxLayout(signOutPanel, BoxLayout.PAGE_AXIS));
		signOutPanel.setVisible(false);
		
		signOutHeader.setFont(defaultHeaderFont);
		signOutHeader.setHorizontalAlignment(JLabel.CENTER);
		signOutSubHeader.setFont(defaultLabelFont);
		signOutSubHeader.setHorizontalAlignment(JLabel.CENTER);
		
		signOutHeaderPanel = new JPanel();
		signOutHeaderPanel.setSize(panelX, panelY/6);
		signOutHeaderPanel.setLayout(new BoxLayout(signOutHeaderPanel, BoxLayout.PAGE_AXIS));
		signOutHeaderPanel.add(signOutHeader);
		signOutHeaderPanel.add(signOutSubHeader);
		
		soILabel.setFont(defaultLabelFont);
		signOutList1Panel = new JPanel();
		signOutList1Panel.setSize(panelX/3, panelY/6);
		signOutList1Panel.setLayout(new BoxLayout(signOutList1Panel, BoxLayout.PAGE_AXIS));
		signOutList1Panel.add(soILabel);
		signOutList1Panel.add(instrumentInv);
		
		soMLabel.setFont(defaultLabelFont);
		signOutList2Panel = new JPanel();
		signOutList2Panel.setSize(panelX/3, panelY/6);
		signOutList2Panel.setLayout(new BoxLayout(signOutList2Panel, BoxLayout.PAGE_AXIS));
		signOutList2Panel.add(soMLabel);
		signOutList2Panel.add(sheetMusicInv);
		
		soELabel.setFont(defaultLabelFont);
		signOutList3Panel = new JPanel();
		signOutList3Panel.setSize(panelX/3, panelY/6);
		signOutList3Panel.setLayout(new BoxLayout(signOutList3Panel, BoxLayout.PAGE_AXIS));
		signOutList3Panel.add(soELabel);
		signOutList3Panel.add(equipmentInv);
		
		signOutFunctionsPanel = new JPanel();
		signOutFunctionsPanel.setSize(panelX, panelY/6);
		signOutFunctionsPanel.setLayout(new FlowLayout());
		signOutFunctionsPanel.add(signOutList1Panel);
		signOutFunctionsPanel.add(signOutList2Panel);
		signOutFunctionsPanel.add(signOutList3Panel);
		
		signOutStudentPanel = new JPanel();
		signOutStudentPanel.setSize(panelX, panelY/6);
		signOutStudentPanel.setLayout(new FlowLayout());
		studentNameLabel.setFont(defaultLabelFont);
		signOutStudentPanel.add(studentNameLabel);
		signOutStudentPanel.add(studentName);
		
		signOutMessagePanel = new JPanel();
		signOutMessagePanel.setSize(panelX, panelY/6);
		signOutMessagePanel.setLayout(new BoxLayout(signOutMessagePanel, BoxLayout.PAGE_AXIS));
		signOutMessageLabel1.setFont(defaultLabelFont);
		signOutMessageLabel2.setFont(defaultLabelFont);
		signOutMessageLabel3.setFont(defaultLabelFont);
		signOutMessagePanel.add(signOutMessageLabel1);
		signOutMessagePanel.add(signOutMessageLabel2);
		signOutMessagePanel.add(signOutMessageLabel3);
		
		signOutButtonsPanel = new JPanel();
		signOutButtonsPanel.setSize(panelX, panelY/6);
		signOutButtonsPanel.setLayout(new FlowLayout());
		signOutButtonsPanel.add(soMenuButton);
		signOutButtonsPanel.add(soObjectButton);
		
		signOutPanel.add(signOutHeaderPanel);
		signOutPanel.add(signOutFunctionsPanel);
		signOutPanel.add(signOutStudentPanel);
		signOutPanel.add(signOutMessagePanel);
		signOutPanel.add(signOutButtonsPanel);
		this.add(signOutPanel);
		
		/* ---- End of Sign-out Panel ---- */
		
		/* ---- Code for Return Panel ---- */
		
		returnPanel = new JPanel();
		returnPanel.setSize(panelX, panelY);
		returnPanel.setLayout(new BoxLayout(returnPanel, BoxLayout.PAGE_AXIS));
		returnPanel.setVisible(false);
		
		returnHeader.setFont(defaultHeaderFont);
		returnHeaderPanel = new JPanel();
		returnHeaderPanel.setSize(panelX, panelY/4);
		returnHeaderPanel.add(returnHeader);
		
		signedOutInvLabel.setFont(defaultLabelFont);
		returnOptionsPanel = new JPanel();
		returnOptionsPanel.setSize(panelX, panelY/4);
		returnOptionsPanel.setLayout(new BoxLayout(returnOptionsPanel, BoxLayout.PAGE_AXIS));
		returnOptionsPanel.add(signedOutInvLabel);
		returnOptionsPanel.add(signedOutInv);
		
		returnMessageLabel.setFont(defaultLabelFont);
		returnMessagePanel = new JPanel();
		returnMessagePanel.setSize(panelX, panelY/4);
		returnMessagePanel.add(returnMessageLabel);
		
		returnButtonsPanel = new JPanel();
		returnButtonsPanel.setSize(panelX, panelY/4);
		returnButtonsPanel.setLayout(new FlowLayout());
		returnButtonsPanel.add(returnMenuButton);
		returnButtonsPanel.add(returnObjectButton);
		
		returnPanel.add(returnHeaderPanel);
		returnPanel.add(returnOptionsPanel);
		returnPanel.add(returnMessagePanel);
		returnPanel.add(returnButtonsPanel);
		this.add(returnPanel);
		
		/* ---- End of Return Panel ---- */
		
		/* ---- Code for View Panel ---- */
		viewPanel = new JPanel();
		viewPanel.setSize(panelX, panelY);
		viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));
		viewPanel.setVisible(false);
		
		viewHeader.setFont(defaultHeaderFont);
		viewHeader.setHorizontalAlignment(JLabel.CENTER);
		viewSubHeader.setFont(defaultLabelFont);
		viewSubHeader.setHorizontalAlignment(JLabel.CENTER);
		
		viewHeaderPanel = new JPanel();
		viewHeaderPanel.setSize(panelX, panelY);
		viewHeaderPanel.setLayout(new BoxLayout(viewHeaderPanel, BoxLayout.PAGE_AXIS));
		viewHeaderPanel.add(viewHeader);
		viewHeaderPanel.add(viewSubHeader);
		
		viewCenterPanel = new JPanel();
		viewCenterPanel.setSize(panelX, panelY);
		viewCenterPanel.setLayout(new FlowLayout());
		
		viewCenterLeftPanel = new JPanel();
		viewCenterLeftPanel.setSize(panelX/2, panelY);
		viewCenterLeftPanel.setLayout(new FlowLayout());
		
		viewCenterRightPanel = new JPanel();
		viewCenterRightPanel.setSize(panelX/2, panelY);
		
		viewList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listScroller.setPreferredSize(new Dimension(250,160));
		viewList.addListSelectionListener(new ListListener());
		
		viewListPanel = new JPanel();
		viewListPanel.setSize(panelX/4, panelY);
		viewListPanel.add(listScroller);
		viewCenterLeftPanel.add(viewListPanel);
		
		viewSortButtonsLabel.setFont(customFont);
		viewSortButtonsPanel = new JPanel();
		viewSortButtonsPanel.setSize(panelX/4, panelY);
		viewSortButtonsPanel.setLayout(new BoxLayout(viewSortButtonsPanel, BoxLayout.PAGE_AXIS));
		viewSortButtonsPanel.add(viewSortButtonsLabel);
		viewSortButtonsPanel.add(alphaSortButton);
		viewSortButtonsPanel.add(dueDateSortButton);
		viewCenterLeftPanel.add(viewSortButtonsPanel);
		
		viewSpecsLabel.setFont(customFont);
		viewSpecsLabel.setHorizontalAlignment(JLabel.CENTER);
		
		viewNameLabel.setFont(defaultLabelFont);
		viewDesc1Label.setFont(defaultLabelFont);
		viewDesc2Label.setFont(defaultLabelFont);
		viewConditionLabel.setFont(defaultLabelFont);
		viewStatusLabel.setFont(defaultLabelFont);
		viewDueDateLabel.setFont(defaultLabelFont);
		viewStudentLastLabel.setFont(defaultLabelFont);
		
		viewSpecsPanel = new JPanel();
		viewSpecsPanel.setSize(panelX/2, panelY);
		viewSpecsPanel.setLayout(new BoxLayout(viewSpecsPanel, BoxLayout.PAGE_AXIS));
		viewSpecsPanel.add(viewSpecsLabel);
		viewSpecsPanel.add(viewNameLabel);
		viewSpecsPanel.add(viewDesc1Label);
		viewSpecsPanel.add(viewDesc2Label);
		viewSpecsPanel.add(viewConditionLabel);
		viewSpecsPanel.add(viewDueDateLabel);
		viewSpecsPanel.add(viewStatusLabel);
		viewSpecsPanel.add(viewStudentLastLabel);
		viewCenterRightPanel.add(viewSpecsPanel);
		
		viewCenterPanel.add(viewCenterLeftPanel);
		viewCenterPanel.add(viewCenterRightPanel);
		
		previousButton.setFont(defaultButtonFont);
		nextButton.setFont(defaultButtonFont);
		viewButtonsPanel = new JPanel();
		viewButtonsPanel.setSize(panelX, panelY/4);
		viewButtonsPanel.setLayout(new FlowLayout());
		viewButtonsPanel.add(viewMenuButton);
		viewButtonsPanel.add(previousButton);
		viewButtonsPanel.add(nextButton);
		
		viewPanel.add(viewHeaderPanel);
		viewPanel.add(viewCenterPanel);
		viewPanel.add(viewButtonsPanel);
		this.add(viewPanel);
		
		/* ---- End of View Panel ---- */
		
		/* ---- Code for Notice Panel ---- */
		
		noticePanel = new JPanel();
		noticePanel.setLayout(new BoxLayout(noticePanel, BoxLayout.PAGE_AXIS));
		noticePanel.setSize(panelX, panelY);
		noticePanel.setVisible(false);
		
		noticeHeader.setFont(defaultHeaderFont);
		noticeHeader.setHorizontalAlignment(JLabel.CENTER);
		noticeSubHeader.setFont(defaultLabelFont);
		noticeSubHeader.setHorizontalAlignment(JLabel.CENTER);
		
		noticeHeaderPanel = new JPanel();
		noticeHeaderPanel.setLayout(new BoxLayout(noticeHeaderPanel, BoxLayout.PAGE_AXIS));
		noticeHeaderPanel.setSize(panelX, panelY/4);
		noticeHeaderPanel.add(noticeHeader);
		noticeHeaderPanel.add(noticeSubHeader);
		
		noticeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		noticeListScroller.setPreferredSize(new Dimension(1000, 160));
		noticeList.addListSelectionListener(new NoticeListListener());
		
		noticeCenterPanel = new JPanel();
		noticeCenterPanel.setLayout(new BoxLayout(noticeCenterPanel, BoxLayout.PAGE_AXIS));
		noticeCenterPanel.setSize(panelX, panelY/4);
		noticeCenterPanel.add(noticeList);
		noticeCenterPanel.add(noticeDescLabel);
		
		noticeDescLabel.setFont(customFont);
		noticeDescLabel.setHorizontalAlignment(JLabel.CENTER);
		
		noticeDescPanel = new JPanel();
		noticeDescPanel.setSize(panelX, panelY/4);
		noticeDescPanel.add(noticeDescLabel);
		
		noticeButtonsPanel = new JPanel();
		noticeButtonsPanel.setSize(panelX, panelY/4);
		noticeButtonsPanel.add(noticeMenuButton);
		
		noticePanel.add(noticeHeaderPanel);
		noticePanel.add(noticeCenterPanel);
		noticePanel.add(noticeDescPanel);
		noticePanel.add(noticeButtonsPanel);
		this.add(noticePanel);
		
		/* ---- End of Notice Panel ---- */
		
		/* ---- Code for Add Panel ---- */
		addPanel = new JPanel();
		addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.PAGE_AXIS));
		addPanel.setSize(panelX, panelY);
		addPanel.setVisible(false);
		
		addHeader.setFont(defaultHeaderFont);
		addHeader.setHorizontalAlignment(JLabel.CENTER);
		addSubHeader.setFont(defaultLabelFont);
		addSubHeader.setHorizontalAlignment(JLabel.CENTER);
		
		addHeaderPanel = new JPanel();
		addHeaderPanel.setLayout(new BoxLayout(addHeaderPanel, BoxLayout.PAGE_AXIS));
		addHeaderPanel.setSize(panelX, panelY);
		addHeaderPanel.add(addHeader);
		addHeaderPanel.add(addSubHeader);
		
		nameLabel.setFont(defaultLabelFont);
		numberLabel.setFont(defaultLabelFont);
		descLabel1.setFont(defaultLabelFont);
		descLabel2.setFont(defaultLabelFont);
		conditionLabel.setFont(defaultLabelFont);
		
		addDescPanel1 = new JPanel();
		addDescPanel1.setSize(panelX/5, panelY/4);
		addDescPanel1.setLayout(new BoxLayout(addDescPanel1, BoxLayout.PAGE_AXIS));
		addDescPanel1.add(nameLabel);
		addDescPanel1.add(nameField);
		
		addDescPanel2 = new JPanel();
		addDescPanel2.setSize(panelX/5, panelY/4);
		addDescPanel2.setLayout(new BoxLayout(addDescPanel2, BoxLayout.PAGE_AXIS));
		addDescPanel2.add(numberLabel);
		addDescPanel2.add(numberField);
		
		addDescPanel3 = new JPanel();
		addDescPanel3.setSize(panelX/5, panelY/4);
		addDescPanel3.setLayout(new BoxLayout(addDescPanel3, BoxLayout.PAGE_AXIS));
		addDescPanel3.add(descLabel1);
		addDescPanel3.add(descField1);
		
		addDescPanel4 = new JPanel();
		addDescPanel4.setSize(panelX/5, panelY/4);
		addDescPanel4.setLayout(new BoxLayout(addDescPanel4, BoxLayout.PAGE_AXIS));
		addDescPanel4.add(descLabel2);
		addDescPanel4.add(descField2);
		
		addDescPanel5 = new JPanel();
		addDescPanel5.setSize(panelX/5, panelY/4);
		addDescPanel5.setLayout(new BoxLayout(addDescPanel5, BoxLayout.PAGE_AXIS));
		addDescPanel5.add(conditionLabel);
		
		rButtonILabel.setFont(defaultLabelFont);
		rButtonMLabel.setFont(defaultLabelFont);
		rButtonELabel.setFont(defaultLabelFont);
		
		addButtonsPanel = new JPanel();
		addButtonsPanel.setSize(panelX, panelY);
		addButtonsPanel.setLayout(new FlowLayout());
		addButtonsPanel.add(rButtonILabel);
		addButtonsPanel.add(instrumentButton);
		addButtonsPanel.add(rButtonMLabel);
		addButtonsPanel.add(musicButton);
		addButtonsPanel.add(rButtonELabel);
		addButtonsPanel.add(equipmentButton);
		addButtonsPanel.add(addMenuButton);
		
		addAllOptionsPanel = new JPanel();
		addAllOptionsPanel.setSize(panelX, panelY/4);
		addAllOptionsPanel.setLayout(new FlowLayout());
		addAllOptionsPanel.add(addDescPanel1);
		addAllOptionsPanel.add(addDescPanel2);
		addAllOptionsPanel.add(addDescPanel3);
		addAllOptionsPanel.add(addDescPanel4);
		addAllOptionsPanel.add(addDescPanel5);
		addAllOptionsPanel.setVisible(false);
		
		addMessageLabel = new JLabel();
		addMessageLabel.setFont(defaultLabelFont);
		addMessagePanel = new JPanel();
		addMessagePanel.setSize(panelX, panelY/5);
		addMessagePanel.add(addMessageLabel);
		
		addBottomPanel = new JPanel();
		addBottomPanel.setSize(panelX, panelY/5);
		addBottomPanel.add(addObjectButton);
		addBottomPanel.setVisible(false);
		
		addPanel.add(addHeaderPanel);
		addPanel.add(addButtonsPanel);
		addPanel.add(addAllOptionsPanel);
		addPanel.add(addMessagePanel);
		addPanel.add(addBottomPanel);
		this.add(addPanel);

		/* ---- End of Add Panel ---- */
		
		/* ---- Code for Remove Panel ---- */
		removePanel = new JPanel();
		removePanel.setLayout(new BoxLayout(removePanel, BoxLayout.PAGE_AXIS));
		removePanel.setSize(panelX, panelY);
		removePanel.setVisible(false);
		
		removeHeader.setFont(defaultHeaderFont);
		removeHeader.setHorizontalAlignment(JLabel.CENTER);
		removeSubHeader.setFont(defaultLabelFont);
		removeSubHeader.setHorizontalAlignment(JLabel.CENTER);
		
		removeHeaderPanel = new JPanel();
		removeHeaderPanel.setSize(panelX, panelY/4);
		removeHeaderPanel.setLayout(new BoxLayout(removeHeaderPanel, BoxLayout.PAGE_AXIS));
		removeHeaderPanel.add(removeHeader);
		removeHeaderPanel.add(removeSubHeader);
		
		removeInvLabel.setFont(defaultLabelFont);
		removeInvLabel.setHorizontalAlignment(JLabel.CENTER);
		removeListPanel = new JPanel();
		removeListPanel.setSize(panelX, panelY/4);
		removeListPanel.setLayout(new BoxLayout(removeListPanel, BoxLayout.PAGE_AXIS));
		removeListPanel.add(removeInvLabel);
		removeListPanel.add(inDeptInv);
		
		removeMessagePanel = new JPanel();
		removeMessagePanel.setSize(panelX, panelY/4);
		removeMessagePanel.add(removeMessageLabel);
		
		removeButtonsPanel = new JPanel();
		removeButtonsPanel.setSize(panelX, panelY/4);
		removeButtonsPanel.setLayout(new FlowLayout());
		removeButtonsPanel.add(removeMenuButton);
		removeButtonsPanel.add(removeObjectButton);
		
		removePanel.add(removeHeaderPanel);
		removePanel.add(removeListPanel);
		removePanel.add(removeMessagePanel);
		removePanel.add(removeButtonsPanel);
		this.add(removePanel);
		
		/* ---- End of Remove Panel ---- */
		
		/* ---- Code for Repair Panel ---- */
		repairPanel = new JPanel();
		repairPanel.setSize(panelX, panelY);
		repairPanel.setLayout(new BoxLayout(repairPanel, BoxLayout.PAGE_AXIS));
		repairPanel.setVisible(false);
		
		repairHeader.setFont(defaultHeaderFont);
		repairHeader.setHorizontalAlignment(JLabel.CENTER);
		repairSubHeader.setFont(defaultLabelFont);
		repairSubHeader.setHorizontalAlignment(JLabel.CENTER);
		
		repairHeaderPanel = new JPanel();
		repairHeaderPanel.setSize(panelX, panelY/4);
		repairHeaderPanel.add(repairHeader);
		repairHeaderPanel.add(repairSubHeader);
		
		repairInvLabel.setFont(defaultLabelFont);
		repairInvLabel.setHorizontalAlignment(JLabel.CENTER);
		
		repairListPanel = new JPanel();
		repairListPanel.setSize(panelX, panelY/4);
		repairListPanel.setLayout(new BoxLayout(repairListPanel, BoxLayout.PAGE_AXIS));
		repairListPanel.add(repairInvLabel);
		repairListPanel.add(badInv);
		
		repairMessagePanel = new JPanel();
		repairMessagePanel.setSize(panelX, panelY/4);
		repairMessagePanel.add(repairMessageLabel);
		
		repairButtonsPanel = new JPanel();
		repairButtonsPanel.setSize(panelX, panelY/4);
		repairButtonsPanel.setLayout(new FlowLayout());
		repairButtonsPanel.add(repairMenuButton);
		repairButtonsPanel.add(repairObjectButton);
		
		repairPanel.add(repairHeaderPanel);
		repairPanel.add(repairListPanel);
		repairPanel.add(repairMessagePanel);
		repairPanel.add(repairButtonsPanel);
		this.add(repairPanel);
		
		/* ---- End of Repair Panel ---- */
		
		this.setVisible(true);
	}// end of constructor
	
	/**
	 * listSort
	 * Method that sorts items in JList in alphabetical order
	 * Returns nothing
	 * @param nothing
	 * @return void
	 */
	public void listSort() {
		allNames.sortAlpha();
		for (int i = 1; i < viewListModel.size()-1; i++) {
			int index = i-1;
			String item = viewListModel.get(i);
			
			//Comparing strings and swapping items
			while ((index >= 1 && (viewListModel.get(index).compareTo(item) > 0))) {
				listModel.set(index+1, listModel.getElementAt(index));
				viewListModel.set(index+1, viewListModel.get(index));
				index--;
			}// end of while
			listModel.set(index+1, listModel.get(i));
			viewListModel.set(index+1, item);
		}// end of i for
	}// end of listSort
	
	/* --------------- Code for methods --------------- */	
	
	/**
	 * instrumentInvAdd
	 * Method that adds an item to instrument sign-out list + combo box
	 * Returns nothing
	 * @param in - Instrument to be added to list + combo box
	 * @return void
	 */
	public void instrumentInvAdd(Instrument in) {
		//Add to sign-out list + combo box
		instrumentNames.add(in);
		instrumentNames.sort();
		
		for (int j = 0; j < instrumentNames.getSize(); j++) {
			if (in.getFullName().equals(instrumentNames.getName(j))) {
				instrumentInv.insertItemAt(in.getFullName(), j+1);
				j = instrumentNames.getSize();
			}// end of if
		}// end of j for
	}// end of instrumentInvAdd
	
	/**
	 * instrumentInvRemove
	 * Method that removes an item from instrument sign-out list + combo box
	 * Returns nothing
	 * @param in - Instrument to be removed from list + combo box
	 * @return void
	 */
	public void instrumentInvRemove(Instrument in) {
		//Remove item from sign-out list + combo box
		for (int a = 0; a <= instrumentNames.getSize(); a++) {
			if (in.getFullName().equals(instrumentNames.getName(a))) {
				instrumentInv.removeItemAt(a+1);
				instrumentNames.remove(iL.get(in.getFullName()));
				a = instrumentNames.getSize();
			}// end of if
		}// end of a for loop
	}// end of instrumentInvRemove
	
	/**
	 * musicInvAdd
	 * Method that adds an item to sheet music sign-out list + combo box
	 * Returns nothing
	 * @param sm - Sheet Music to be added to list + combo box
	 * @return void
	 */
	public void musicInvAdd(SheetMusic sm) {
		//Add to sign-out list + combo box
		musicNames.add(sm);
		musicNames.sort();
		
		for (int m = 0; m < musicNames.getSize(); m++) {
			if (sm.getFullName().equals(musicNames.getName(m))) {
				sheetMusicInv.insertItemAt(sm.getFullName(), m+1);
				m = musicNames.getSize();
			}// end of if
		}// end of m for
	}// end of musicInvAdd
	
	/**
	 * musicInvRemove
	 * Method that removes an item from sheet music sign-out list + combo box
	 * Returns nothing
	 * @param sm - Sheet music to be removed from list + combo box
	 * @return void
	 */
	public void musicInvRemove(SheetMusic sm) {
		//Remove item from sign-out list + combo box
		for (int a = 0; a <= musicNames.getSize(); a++) {
			if (sm.getFullName().equals(musicNames.getName(a))) {
				sheetMusicInv.removeItemAt(a+1);
				musicNames.remove(sML.get(sm.getFullName()));
				a = musicNames.getSize();
			}// end of if
		}// end of a for
	}// end of musicInvRemove
	
	/**
	 * equipmentInvAdd
	 * Method that adds an item to equipment sign-out list + combo box
	 * Returns nothing
	 * @param eq - Equipment to be added to list + combo box
	 * @return void
	 */
	public void equipmentInvAdd(Equipment eq) {
		//Add to sign-out list + combo box
		equipmentNames.add(eq);
		equipmentNames.sort();
		
		for (int q = 0; q < equipmentNames.getSize(); q++) {
			if (eq.getFullName().equals(equipmentNames.getName(q))) {
				equipmentInv.insertItemAt(eq.getFullName(), q+1);
				q = equipmentNames.getSize();
			}// end of if
		}// end of q for
	}// end of equipmentInvAdd
	
	/**
	 * equipmentInvRemove
	 * Method that removes an item from equipment sign-out list + combo box
	 * Returns nothing
	 * @param eq - Equipment to be removed from list + combo box
	 * @return void
	 */
	public void equipmentInvRemove(Equipment eq) {
		//Remove item from sign-out list + combo box
		for (int a = 0; a <= equipmentNames.getSize(); a++) {
			if (eq.getFullName().equals(equipmentNames.getName(a))) {
				equipmentInv.removeItemAt(a+1);
				equipmentNames.remove(eL.get(eq.getFullName()));
				a = equipmentNames.getSize();
			}// end of if
		}// end of a for loop
	}// end of equipmentInvRemove
	
	/**
	 * signOutInvAdd
	 * Method that adds an item to return list + combo box
	 * Returns nothing
	 * @param obj - Object to be added to list + combo box
	 * @return void
	 */
	public void signOutInvAdd(Object obj) {
		//Add item to return list + combo box
		signOutNames.add(obj);
		signOutNames.sort();
		
		for (int s = 0; s < signOutNames.getSize(); s++) {
			if (obj.getFullName().equals(signOutNames.getName(s))) {
				signedOutInv.insertItemAt(obj.getFullName(), s+1);
				s = signOutNames.getSize();
			}// end of if
		}// end of s for
	}// end of signOutInvAdd
	
	/**
	 * inDeptInvAdd
	 * Method that adds an item to inDept list + combo box
	 * Returns nothing
	 * @param obj - Object to be added to list + combo box
	 * @return void
	 */
	public void inDeptInvAdd(Object obj) {
		inDeptNames.add(obj);
		inDeptNames.sort();
		
		for (int a = 0; a < inDeptNames.getSize(); a++) {
			if (obj.getFullName().equals(inDeptNames.get(a).getFullName())) {
				inDeptInv.insertItemAt(obj.getFullName(), a+1);// Adding to comprehensive database combo box
				a = inDeptNames.getSize();
			}// end of if
		}// end of a for
	}// end of inDeptInvAdd
	
	/**
	 * badInvAdd
	 * Method that adds an item to bad list + combo box
	 * Reutrns nothing
	 * @param obj - Object to be added to list + combo box
	 * @return void
	 */
	public void badInvAdd(Object obj) {
		badNames.add(obj);
		badNames.sort();
		
		for (int a = 0; a < badNames.getSize(); a++) {
			if (obj.getFullName().equals(badNames.get(a).getFullName())) {
				badInv.insertItemAt(obj.getFullName(), a+1);// Adding to bad database combo box
				a = badNames.getSize();
			}// end of if
		}// end of a for
	}// end of badInvAdd
	
	/**
	 * listModelAdd
	 * Method that adds an item to both JLists
	 * Returns nothing
	 * @param obj - Object to be added to listModel
	 * @return void
	 */
	public void listModelAdd(Object obj) {
		//Add to JList
		for (int a = 0; a < allNames.getSize(); a++) {
			if (obj.getFullName().equals(allNames.get(a).getFullName())) {
				listModel.add(a, obj);
				viewListModel.add(a, obj.getFullName());
			}// end of if
		}// end of a for
	}
	
	/* --------------- End of method code ---------------*/
	
	/* --------------- Code for listeners --------------- */
	
	/**
	 * ButtonListenerSignOut
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to sign-out panel when button is clicked
	 */
	public class ButtonListenerSignOut implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Switching panels
			menuPanel.setVisible(false);
			signOutPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerSignOut	
	
	/**
	 * ButtonListenerSignOutObject
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that signs out objects when a button is clicked
	 */
	public class ButtonListenerSignOutObject implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Strings holding selection from combo boxes and text field
			String soInstrument = (String) instrumentInv.getSelectedItem();
			String soMusic = (String) sheetMusicInv.getSelectedItem();
			String soEquipment = (String) equipmentInv.getSelectedItem();
			String lastStudent = studentName.getText();
			
			//Dates used for sign-outs
			tomorrow = today.plus(1, ChronoUnit.DAYS);
			afterWeekend = today.plus(3, ChronoUnit.DAYS);
			
			//Runs if no object has been selected or student name has not been inputted
			if ((soInstrument == null && soMusic == null && soEquipment == null) || studentName.getText().equals("")) {
				signOutMessageLabel1.setText("Error, sign-out item and/or student name not specified");
			}
			
			//Runs if otherwise
			else {
				if (soInstrument != null) {// Instrument being signed out
					iL.signOut(iL.get(soInstrument));
					
					//Setting due date and student who last signed instrument out
					if (today.getDayOfWeek().name().equals("FRIDAY")) {// Weekend skip case
						signOutMessageLabel1.setText(soInstrument + " has been signed out by " + studentName.getText() + ". The instrument must be returned by " + afterWeekend);// Success message
						iL.get(soInstrument).setDueDate(afterWeekend.toString());
					}// end of if
					
					else {// Weekday case
						signOutMessageLabel1.setText(soInstrument + " has been signed out by " + studentName.getText() + ". The instrument must be returned by " + tomorrow);// Success message
						iL.get(soInstrument).setDueDate(tomorrow.toString());
					}// end of else
					iL.signOut(iL.get(soInstrument));
					iL.setLastStudent(iL.get(soInstrument), lastStudent);
					
					inDeptNames.remove(iL.get(soInstrument));
					inDeptInv.removeItem(soInstrument);
					
					instrumentInvRemove(iL.get(soInstrument));// Call to method to remove instrument
					signOutInvAdd(iL.get(soInstrument));// Call to method to add instrument to return list
					instrumentInv.setSelectedItem(null);// Reset combo box
				}// end of if
			
				if (soMusic != null) {// Sheet music being signed out
					sML.signOut(sML.get(soMusic));
					
					//Setting due date and student who last signed sheet music out
					if (today.getDayOfWeek().name().equals("FRIDAY")){// Weekend skip case
						signOutMessageLabel2.setText(soMusic + " has been signed out by " + studentName.getText() + ". The music must be returned by " + afterWeekend);
						sML.get(soMusic).setDueDate(afterWeekend.toString());
					}// end of if	
					
					else {// Weekday case
						signOutMessageLabel2.setText(soMusic + " has been signed out by " + studentName.getText() + ". The music must be returned by " + tomorrow);
						sML.get(soMusic).setDueDate(tomorrow.toString());
					}// end of else
					sML.signOut(sML.get(soMusic));
					sML.setLastStudent(sML.get(soMusic), lastStudent);
					
					inDeptNames.remove(sML.get(soMusic));
					inDeptInv.removeItem(soMusic);
					
					musicInvRemove(sML.get(soMusic));// Call to method to remove sheet music
					signOutInvAdd(sML.get(soMusic));// Call to method to add sheet music to return list
					sheetMusicInv.setSelectedItem(null);// Reset combo box
				}// end of if
			
				if (soEquipment != null) {// Equipment being signed out
					eL.signOut(eL.get(soEquipment));
					
					//Setting due date and student who last signed equipment out
					if (today.getDayOfWeek().name().equals("FRIDAY")) {// Weekend skip case
						signOutMessageLabel3.setText(soEquipment + " has been signed out by " + studentName.getText() + ". The equipment must be returned by " + afterWeekend);
						eL.get(soEquipment).setDueDate(afterWeekend.toString());
					}// end of if
					
					else {// Weekday case
						signOutMessageLabel3.setText(soEquipment + " has been signed out by " + studentName.getText() + ". The equipment must be returned by " + tomorrow);
						eL.get(soEquipment).setDueDate(tomorrow.toString());
					}// end of else
					eL.signOut(eL.get(soEquipment));
					eL.setLastStudent(eL.get(soEquipment), (lastStudent));
					
					inDeptNames.remove(eL.get(soEquipment));
					inDeptInv.removeItem(soEquipment);
					
					equipmentInvRemove(eL.get(soEquipment));// Call to method to remove equipment
					signOutInvAdd(eL.get(soEquipment));// Call to method to add equipment to return list
					equipmentInv.setSelectedItem(null);// Reset combo box
				}// end of if
				studentName.setText(null);// Reset text field
			}// end of else
			
			//Disables button if all items have been signed out
			if (instrumentInv.getItemCount() == 1 && sheetMusicInv.getItemCount() == 1 && equipmentInv.getItemCount() == 1) {
				soObjectButton.setEnabled(false);
			}// end of if
		}// end of actionPerformed
	}// end of ButtonListenerSignOutObject
	
	/**
	 * ButtonListenerSMenu
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to menu panel from sign-out panel when button is clicked
	 */
	public class ButtonListenerSMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Resetting any changes to null
			instrumentInv.setSelectedItem(null);
			sheetMusicInv.setSelectedItem(null);
			equipmentInv.setSelectedItem(null);
			signOutMessageLabel1.setText(null);
			signOutMessageLabel2.setText(null);
			signOutMessageLabel3.setText(null);
			
			//Switching panels
			signOutPanel.setVisible(false);
			menuPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerSMenu

	/**
	 * ButtonListenerReturn
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to return panel when button is clicked
	 */
	public class ButtonListenerReturn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Runs if no items are signed-out
			if (signedOutInv.getItemCount() == 1) {
				returnObjectButton.setEnabled(false);// Disables button
			}// end of if
			
			//Runs if otherwise
			else {
				returnObjectButton.setEnabled(true);// Enables button
			}// end of else
			
			//Switching panels
			menuPanel.setVisible(false);
			returnPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerReturn
	
	/**
	 * ButtonListenerReturnObject
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that returns objects when a button is clicked
	 */
	public class ButtonListenerReturnObject implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//String holding selection from combo box
			String returningItem = (String) signedOutInv.getSelectedItem();
			
			//Runs if no object has been selected
			if (returningItem == null) {
				returnMessageLabel.setText("Error, item has not been selected");
			}// end of if
			
			//Runs if otherwise
			else {
				//Removing item from sign-out list + combo box
				for (int i = 0; i < signOutNames.getSize(); i++) {
					if (returningItem.equals(signOutNames.getName(i))) {
						
						//Runs if selected item is an instrument
						if (signOutNames.get(i) instanceof Instrument) {
							instrumentInvAdd((Instrument) signOutNames.get(i));// Call to method to add instrument
							iL.returned((Instrument) signOutNames.get(i));
						}// end of if
						
						//Runs if selected item is sheet music
						else if (signOutNames.get(i) instanceof SheetMusic ) {
							musicInvAdd((SheetMusic) signOutNames.get(i));// Call to method to add sheet music
							sML.returned((SheetMusic) signOutNames.get(i));
						}// end of else if
						
						//Runs if selected item is equipment
						else if (signOutNames.get(i) instanceof Equipment) {
							equipmentInvAdd((Equipment) signOutNames.get(i));// Call to method to add equipment
							eL.returned((Equipment) signOutNames.get(i));
						}// end of else if
						
						//Remove from return list + combo box
						inDeptNames.add(signOutNames.get(i));
						signOutNames.get(i).setDueDate(null);
						signOutNames.get(i).setOverdueDays(-1);
						signOutNames.remove(signOutNames.get(i));
						signedOutInv.removeItemAt(i+1);
						i = signOutNames.getSize();
					}// end of if
				}// end of i for
				
				signedOutInv.setSelectedItem(null);// Resetting combo box
				returnMessageLabel.setText(returningItem + " returned successfully");// Success message
				
				//Disables button if no items need to be returned
				if (signedOutInv.getItemCount() == 1) {
					returnObjectButton.setEnabled(false);
				}// end of if
			}// end of else	
		}// end of actionPerformed
	}// end of ButtonListenerReturnObject
	
	/**
	 * ButtonListenerRetMenu
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to menu panel from return panel when button is clicked
	 */
	public class ButtonListenerRetMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Resetting any changes to null
			signedOutInv.setSelectedItem(null);
			returnMessageLabel.setText(null);
			
			//Switching panels
			returnPanel.setVisible(false);
			menuPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerRetMenu

	/**
	 * ButtonListenerView
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to view panel when button is clicked
	 */
	public class ButtonListenerView implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//listSort();
			
			//Switching panels
			menuPanel.setVisible(false);
			viewPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerView
	
	/**
	 * ButtonListenerAlphaSort
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that sorts contents of JList in alphabetical order
	 */
	public class ButtonListenerAlphaSort implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			listSort();
		}// end of actionPerformed
	}// end of ButtonListenerAlphaSort

	/**
	 * ButtonListenerDueDateSort
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that sorts contents of JList by due date
	 */
	public class ButtonListenerDueDateSort implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			listModel.clear();
			viewListModel.clear();
			allNames.sortDDate();
			for (int i = 0; i < allNames.getSize(); i++) {
				listModel.addElement(allNames.get(i));
				viewListModel.addElement(allNames.get(i).getFullName());
			}// end of i for
		}// end of actionPerformed
	}// end of ButtonListenerDueDateSort

	/**
	 * ListListener
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that listens to changes in JList selected value and changes description accordingly
	 */
	public class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			//Runs if value is currently not changing
			if (e.getValueIsAdjusting() == false) {
				listIndex = viewList.getSelectedIndex();
				viewNameLabel.setText(viewList.getSelectedValue().toString());
				
				if (allNames.get(listIndex) instanceof Instrument) {
					viewDesc1Label.setText("Brand: " + ((Instrument) iL.get(viewList.getSelectedValue().toString())).getDesc1());
					viewDesc2Label.setText("Cost: " + ((Instrument) iL.get(viewList.getSelectedValue().toString())).getDesc2());
					viewConditionLabel.setText("Condition: " + ((Instrument) iL.get(viewList.getSelectedValue().toString())).getCondition());
					viewStatusLabel.setText("Status: " + ((Instrument) iL.get(viewList.getSelectedValue().toString())).getStatus());
					viewDueDateLabel.setText("Due date: " + ((Instrument) iL.get(viewList.getSelectedValue().toString())).getDueDate());
					viewStudentLastLabel.setText("Last signed out by: " + ((Instrument) iL.get(viewList.getSelectedValue().toString())).getLastStudent());
				}// end of else if
				
				else if (allNames.get(listIndex) instanceof SheetMusic) {
					viewDesc1Label.setText("Composer: " + ((SheetMusic) sML.get(viewList.getSelectedValue().toString())).getDesc1());
					viewDesc2Label.setText("Part: " + ((SheetMusic) sML.get(viewList.getSelectedValue().toString())).getDesc2());
					viewConditionLabel.setText("Condition: " + ((SheetMusic) sML.get(viewList.getSelectedValue().toString())).getCondition());
					viewStatusLabel.setText("Status: " + ((SheetMusic) sML.get(viewList.getSelectedValue().toString())).getStatus());
					viewDueDateLabel.setText("Due date: " + ((SheetMusic) sML.get(viewList.getSelectedValue().toString())).getDueDate());
					viewStudentLastLabel.setText("Last signed out by: " + ((SheetMusic) sML.get(viewList.getSelectedValue().toString())).getLastStudent());
				}// end of else if
					
				else if (allNames.get(listIndex) instanceof Equipment) {
					viewDesc1Label.setText("Brand: " + ((Equipment) eL.get(viewList.getSelectedValue().toString())).getDesc1());
					viewDesc2Label.setText("Cost: " + ((Equipment) eL.get(viewList.getSelectedValue().toString())).getDesc2());
					viewConditionLabel.setText("Condition: " + ((Equipment) eL.get(viewList.getSelectedValue().toString())).getCondition());
					viewStatusLabel.setText("Status: " + ((Equipment) eL.get(viewList.getSelectedValue().toString())).getStatus());						viewDueDateLabel.setText("Due date: " + ((Equipment) eL.get(viewList.getSelectedValue().toString())).getDueDate());
					viewStudentLastLabel.setText("Last signed out by: " + ((Equipment) eL.get(viewList.getSelectedValue().toString())).getLastStudent());
				}// end of else if
			}// end of if
		}// end of valueChanged
	}// end of ListListener

	/**
	 * ButtonListenerNext
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that changes selected value of JList
	 */
	public class ButtonListenerNext implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Changing selected value
			if (listIndex < allNames.getSize()){
				listIndex++;
				viewList.setSelectedIndex(listIndex);
			}
		}// end of actionPerformed
	}// end of ButtonListenerNext

	/**
	 * ButtonListenerPrevious
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that changes selected value of JList
	 */
	public class ButtonListenerPrevious implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Changing selected value
			if (listIndex > 0){
				listIndex--;
				viewList.setSelectedIndex(listIndex);
			}
		}// end of actionPerformed
	}// end of ButtonListenerPrevious

	/**
	 * ButtonListenerVMenu
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to menu panel from view panel when button is clicked
	 */
	public class ButtonListenerVMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Resetting any changes to null		
			listIndex = 0;
			
			//Switching panels
			viewPanel.setVisible(false);
			menuPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerVMenu

	/**
	 * ButtonListenerDayButton
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that changes the day
	 */
	public class ButtonListenerNextDay implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Obtaining new dates for forwarding time
			dayCount++;
			tomorrow = today.plus(1, ChronoUnit.DAYS);
			afterWeekend = today.plus(3, ChronoUnit.DAYS);
			
			//Runs if current day is a Friday
			if (today.getDayOfWeek().name().equals("FRIDAY")) {
				todaysDate.setText("Today's Date: " + afterWeekend);
				today = afterWeekend;
			}// end of if
			
			//Runs if otherwise
			else {
				todaysDate.setText("Today's Date: " + tomorrow);
				today = tomorrow;
			}// end of else
			
			//Adding to notices list if object is due after changing date
			for (int a = 0; a < allNames.getSize(); a++) {
				//Runs if a due date is set by an object
				if (allNames.get(a).getDueDate() != null) {
					//Runs if an item is overdue
					if (allNames.get(a).getOverdueDays() > -1) {
						newNotice = true;
						noticeCounter++;
						allNames.get(a).setOverdueDays(allNames.get(a).getOverdueDays()+1);
						noticeModel.addElement(today.toString() + ": " + allNames.get(a).getFullName() + ", signed out by " + allNames.get(a).getLastStudent() + ", is " + allNames.get(a).getOverdueDays() + " day(s) overdue");
					}// end of if
					
					//Runs if an item's due date is the current day
					else if (today.toString().equals(allNames.get(a).getDueDate())) {
						newNotice = true;
						noticeCounter++;
						allNames.get(a).setOverdueDays(0);
						noticeModel.addElement(today.toString() + ": " + allNames.get(a).getFullName() + ", signed out by " + allNames.get(a).getLastStudent() + ", is due today");
					}// end of else if
				}// end of if
				
				//Runs if item has been sent for repairs
				if (allNames.get(a).getRepairingDays() != -1) {
					if (allNames.get(a).getRepairingDays() > 0) {
						allNames.get(a).setRepairingDays(allNames.get(a).getRepairingDays()-1);
						
						//Runs if an item's repair date is the current day
						if (allNames.get(a).getRepairingDays() == 0) {
							newNotice = true;
							noticeCounter++;
							allNames.get(a).setRepairingDays(-1);
							allNames.get(a).setStatus("Available");
							allNames.get(a).setCondition("Functional");
							noticeModel.addElement(today.toString() + ": " + allNames.get(a).getFullName() + " has been successfully repaired and returned to the shelves");
							
							//Adding item back to inventories
							inDeptInvAdd(allNames.get(a));
							
							//Runs if item is instrument
							if (allNames.get(a) instanceof Instrument) {
								instrumentInvAdd((Instrument) allNames.get(a));
							}// end of if
							
							//Runs if item is equipment
							else if (allNames.get(a) instanceof Equipment) {
								equipmentInvAdd((Equipment) allNames.get(a));
							}// end of else
						}// end of if
					}// end of if
				}// end of if
			}// end of a for
			
			//Runs if notices have been update do the list
			if (newNotice == true){
				noticeUpdate.setText("You have " + noticeCounter + " new notice(s)");
			}// end of if
			
			//Runs if otherwise
			else {
				noticeUpdate.setText("No new notices");
			}// end of else
			noticeCounter = 0;// Reset counter for number of notices
			newNotice = false;// Reset boolean for notice update
		}// end of actionPerformed
	}// end of ButtonListenerDayButton

	/**
	 * ButtonListenerNotice
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to notice panel when button is clicked
	 */
	public class ButtonListenerNotice implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Switching panels
			menuPanel.setVisible(false);
			noticePanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerNotice
	
	/**
	 * NoticeListListener
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that listens to changes in noticeList selected value and changes description accordingly
	 */
	public class NoticeListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			noticeDescLabel.setText(noticeList.getSelectedValue().toString());
		}// end of valueChanged
	}// end of NoticeListListener

	/**
	 * ButtonListenerNMenu
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to menu panel from notice panel when button is clicked
	 */
	public class ButtonListenerNMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			noticeDescLabel.setText(null);
			
			//Switching panels
			noticePanel.setVisible(false);
			menuPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerNMenu
	
	/**
	 * ButtonListenerAdd
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to add panel when button is clicked
	 */
	public class ButtonListenerAdd implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Switching panels
			menuPanel.setVisible(false);
			addPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerAdd

	/**
	 * ButtonListenerAddObject
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that adds objects when button is clicked
	 */
	public class ButtonListenerAddObject implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Strings holding user input from text fields + combo box
			String nameText = nameField.getText();
			String numberText = numberField.getText();
			String desc1Text = descField1.getText();
			String desc2Text = descField2.getText();
			String conditionText;
			
			//Runs if any of the text fields are empty, not enough information inputted
			if (nameText.equals("") || numberText.equals("") || desc1Text.equals("") || desc2Text.equals("")) {
				addMessageLabel.setText("Error adding object. Not all fields have been filled in");
			}// end of if
			
			//Runs if otherwise
			else {
				//Runs if instrument button is selected
				if (rButtonInst == true) {
					conditionText = (String) addIEConditions.getSelectedItem();
					
					//Creating instrument and adding to list
					instrument = new Instrument(nameText, numberText, desc1Text, desc2Text, conditionText);
					iL.addInstrument(instrument);
					inDeptInvAdd(instrument);
					
					allNames.add(instrument);
					allNames.sortAlpha();
					inDeptInvAdd(instrument);
					
					instrumentInvAdd(instrument);// Call to method to add instrument
					listModelAdd(instrument);// Call to method to add to JList
					addMessageLabel.setText(instrument.getFullName() + " (Instrument) added successfully");// Success message
					
					//Resetting changes
					addIEConditions.setSelectedIndex(0);
					rButtonInst = false;
				}// end of if
				
				//Runs if music button is selected
				else if (rButtonMusic == true) {
					conditionText = (String) addSMConditions.getSelectedItem();
					
					//Creating sheet music and adding to list
					sheetMusic = new SheetMusic(nameText, numberText, desc1Text, desc2Text, conditionText);
					sML.addSheetMusic(sheetMusic);
					inDeptInvAdd(sheetMusic);
					
					allNames.add(sheetMusic);
					allNames.sortAlpha();
					inDeptInvAdd(sheetMusic);
					
					musicInvAdd(sheetMusic);// Call to method to add sheet music
					listModelAdd(sheetMusic);//Call to method to add to JList
					addMessageLabel.setText(sheetMusic.getFullName() + " (Sheet Music) added successfully");// Success message
					
					//Resetting changes
					addSMConditions.setSelectedIndex(0);
					rButtonMusic = false;
				}// end of else if
			
				//Runs if equipment button is selected
				else {
					conditionText = (String) addIEConditions.getSelectedItem();
					
					//Creating equipment and adding to list
					equipment = new Equipment(nameText, numberText, desc1Text, desc2Text, conditionText);
					eL.addEquipment(equipment);
					inDeptInvAdd(equipment);
					
					allNames.add(equipment);
					allNames.sortAlpha();
					inDeptInvAdd(equipment);
					
					equipmentInvAdd(equipment);// Call to method to add equipment
					listModelAdd(equipment);// Call to method to add to JList
					addMessageLabel.setText(equipment.getFullName() + " (Equipment) added successfully");// Success message

					//Resetting changes
					addIEConditions.setSelectedIndex(0);
					rButtonEquip = false;
				}// end of else
			}// end of else
			
			//Resetting text fields + buttons
			nameField.setText(null);
			numberField.setText(null);
			descField1.setText(null);
			descField2.setText(null);
			addOptions.clearSelection();	
		}// end of actionPerformed
	}// end of ButtonListenerAddObject
	
	/**
	 * ButtonListenerRButtonI
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that changes labels/booleans when button is selected
	 */
	public class ButtonListenerRButtonI implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Runs if sheet music condition combo box is visible
			if (smConditionVis == true) {
				addDescPanel5.remove(addSMConditions);
			}// end of if
			
			//Changing booleans for button selection and combo box visibility
			rButtonInst = true;
			rButtonMusic = false;
			rButtonEquip = false;
			
			ieConditionVis = true;
			smConditionVis = false;
			
			//Changing content of labels
			nameLabel.setText("Instrument Name:");
			numberLabel.setText("Instrument Number:");
			descLabel1.setText("Instrument Brand:");
			descLabel2.setText("Cost of Instrument:");
			conditionLabel.setText("Condition of Instrument:");
			
			addDescPanel5.add(addIEConditions);// Adding appropriate combo box for instrument adding
			
			//Setting interior panels to visible
			addAllOptionsPanel.setVisible(true);
			addBottomPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerRButtonI

	/**
	 * ButtonListenerRButtonM
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that changes labels/booleans when button is selected
	 */
	public class ButtonListenerRButtonM implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Runs if instrument/equipment condition combo box is visible
			if (ieConditionVis == true) {
				addDescPanel5.remove(addIEConditions);
			}// end of if
			
			//Changing booleans for button selection and combo box visibility
			rButtonInst = false;
			rButtonMusic = true;
			rButtonEquip = false;
			
			ieConditionVis = false;
			smConditionVis = true;
			
			//Changing content of labels
			nameLabel.setText("Sheet Music Name:");
			numberLabel.setText("Sheet Music Number:");
			descLabel1.setText("Composer Name:");
			descLabel2.setText("Music Part:");
			conditionLabel.setText("Condition of Sheet Music:");
			
			addDescPanel5.add(addSMConditions);// Adding appropriate combo box for sheet music adding
			
			//Setting interior panels to visible
			addAllOptionsPanel.setVisible(true);
			addBottomPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerRButtonM

	/**
	 * ButtonListenerRButtonE
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that changes labels/booleans when button is selected
	 */
	public class ButtonListenerRButtonE implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Runs if sheet music condition combo box is visible
			if (smConditionVis == true) {
				addDescPanel5.remove(addSMConditions);
			}// end of if
			
			//Changing booleans for button selection and combo box visibility
			rButtonInst = false;
			rButtonMusic = false;
			rButtonEquip = true;
			
			ieConditionVis = true;
			smConditionVis = false;
			
			//Changing content of labels
			nameLabel.setText("Equipment Name:");
			numberLabel.setText("Equipment Number:");
			descLabel1.setText("Equipment Brand:");
			descLabel2.setText("Cost of Equipment:");
			conditionLabel.setText("Condition of Equipment:");
			
			addDescPanel5.add(addIEConditions);// Adding appropriate combo box for equipment adding
			
			//Setting interior panels to visible
			addAllOptionsPanel.setVisible(true);
			addBottomPanel.setVisible(true);
		}//end of actionPerformed
	}// end of ButtonListenerRButtonE

	/**
	 * ButtonListenerAMenu
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to menu panel from add panel when button is clicked
	 */
	public class ButtonListenerAMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Runs if instrument/equipment conditions combo box is visible
			if (ieConditionVis == true) {
				addDescPanel5.remove(addIEConditions);
			}// end of if
			//Runs if sheet music conditions combo box is visible
			if (smConditionVis == true) {
				addDescPanel5.remove(addSMConditions);
			}// end of if
			
			//Resetting any changes to false/null
			rButtonInst = false;
			rButtonMusic = false;
			rButtonEquip = false;
			ieConditionVis = false;
			smConditionVis = false;
			addOptions.clearSelection();
			addMessageLabel.setText(null);
			
			//Switching panels
			addPanel.setVisible(false);
			addAllOptionsPanel.setVisible(false);
			addBottomPanel.setVisible(false);
			menuPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerAMenu

	/**
	 * ButtonListenerRemove
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to remove panel when button is clicked
	 */
	public class ButtonListenerRemove implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Switching panels
			menuPanel.setVisible(false);
			removePanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerRemove
	
	/**
	 * ButtonListenerRemoveObject
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that removes objects when button is clicked
	 */
	public class ButtonListenerRemoveObject implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//String holding selection from combo box
			String removingItem = (String) inDeptInv.getSelectedItem();
			
			//Runs if item is not selected
			if (removingItem == null) {
				removeMessageLabel.setText("Error, item has not been selected");
			}// end of if
			
			//Runs if otherwise
			else {
				for (int i = 0; i < allNames.getSize(); i++) {
					//Removing item from list + combo box
					if (removingItem.equals(allNames.get(i).getName() + " " + allNames.get(i).getNumber())) {
						//Runs if selected item is equipment
						if (allNames.get(i) instanceof Equipment) {
							equipmentInvRemove((Equipment) eL.get(removingItem));// Call to method to remove equipment
							eL.removeEquipment(eL.get(removingItem));
						}// end of if
						
						//Runs if selected item is instrument
						else if (allNames.get(i) instanceof Instrument) {
							instrumentInvRemove((Instrument) iL.get(removingItem));// Call to method to remove instrument
							iL.removeInstrument(iL.get(removingItem));
						}// end of else if
						
						//Runs if selected item is sheet music
						else {
							musicInvRemove((SheetMusic) sML.get(removingItem));// Call to method to remove sheet music
							sML.removeSheetMusic(sML.get(removingItem));
						}// end of else
						
						//Removing item from comprehensive list + combo box
						listModel.removeElement(allNames.get(i));
						inDeptNames.remove(allNames.get(i));
						allNames.remove(allNames.get(i));
						inDeptInv.removeItem(removingItem);
						inDeptInv.setSelectedItem(null);
						viewListModel.removeElement(removingItem);
						removeMessageLabel.setText(removingItem + " removed successfully");
					}// end of if
				}// end of for
				
				//Disables button if no items are in inventory
				if (inDeptInv.getItemCount() == 1) {
					removeButton.setEnabled(false);
				}// end of if
			}// end of else
		}// end of actionPerformed
	}// end of ButtonListenerRemoveObject
	
	/**
	 * ButtonListenerRemMenu
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to menu panel from remove panel when button is clicked
	 */
	public class ButtonListenerRemMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Resetting any changes to null
			inDeptInv.setSelectedItem(null);
			removeMessageLabel.setText(null);
			
			//Switching panels
			removePanel.setVisible(false);
			menuPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerRemMenu

	/**
	 * ButtonListenerRepair
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to repair panel when button is clicked
	 */
	public class ButtonListenerRepair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Switching panels
			menuPanel.setVisible(false);
			repairPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerRepair
	
	/**
	 * ButtonListenerRepairObject
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that repairs objects when button is clicked
	 */
	public class ButtonListenerRepairObject implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//String holding selection from combo box
			String repairingItem = (String) badInv.getSelectedItem();
			afterWeekend = today.plus(3, ChronoUnit.DAYS);
			
			//Runs if item is not selected
			if (repairingItem == null) {
				repairMessageLabel.setText("Error, item not selected");
			}// end of if
						
			else {
				for (int i = 0; i <= badNames.getSize(); i++) {
					if (repairingItem.equals(badNames.get(i).getName() + " " + badNames.get(i).getNumber())) {

						//Runs if item is an instrument
						if (badNames.get(i) instanceof Instrument) {	
							iL.repair((Instrument) badNames.get(i));
							repairMessageLabel.setText(repairingItem + " sent for repair. It will be available on " + afterWeekend.toString());
							badNames.get(i).setRepairingDays(3);
						}// end of if
						
						//Runs if item is sheet music
						else if (badNames.get(i) instanceof SheetMusic ) {
							musicInvAdd((SheetMusic) badNames.get(i));
							sML.repair((SheetMusic) badNames.get(i));
							repairMessageLabel.setText(repairingItem + " replaced");
						}// end of else if
						
						//Runs if item is equipment
						else if (badNames.get(i) instanceof Equipment) {
							eL.repair((Equipment) badNames.get(i));
							repairMessageLabel.setText(repairingItem + " sent for repair. It will be available  on " + afterWeekend.toString());
							badNames.get(i).setRepairingDays(3);
						}// end of else if
						
						//Removing item from dysfunctional list + combo box
						inDeptNames.remove(badNames.get(i));
						inDeptInv.removeItem(repairingItem);
						badInv.removeItemAt(i+1);
						badInv.setSelectedItem(null);
						badNames.remove(badNames.get(i));
						
						i = badNames.getSize()+1;
					}// end of if
				}// end of i for
				
				//Disables button if no items need to be repaired
				if (badInv.getItemCount() == 1) {
					repairObjectButton.setEnabled(false);
				}// end of if
			}// end of else
		}// end of actionPerformed
	}// end of ButtonListenerRepairObject
	
	/**
	 * ButtonListenerRepMenu
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that switches to menu panel from repair panel when button is clicked
	 */
	public class ButtonListenerRepMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Resetting any changes to null
			badInv.setSelectedItem(null);
			repairMessageLabel.setText(null);
			
			//Switching panels
			repairPanel.setVisible(false);
			menuPanel.setVisible(true);
		}// end of actionPerformed
	}// end of ButtonListenerRepMenu
	
	/**
	 * ButtonListenerQuit
	 * The Best Version
	 * @author Daniel Kim
	 * May 15 2017
	 * Class that closes frame when button is clicked
	 */
	public class ButtonListenerQuit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}// end of actionPerformed
	}// end of ButtonListenerQuit
	
	/* --------------- End of listener code --------------- */
	
}// end of class
