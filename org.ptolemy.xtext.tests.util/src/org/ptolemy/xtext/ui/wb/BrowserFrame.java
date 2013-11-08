package org.ptolemy.xtext.ui.wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import javax.swing.JList;

public class BrowserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField locationText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowserFrame frame = new BrowserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BrowserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setName("browser");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel locationPanel = new JPanel();
		locationPanel.setName("location");
		contentPane.add(locationPanel, BorderLayout.NORTH);
		GridBagLayout gbl_locationPanel = new GridBagLayout();
		gbl_locationPanel.columnWidths = new int[] {113, 0};
		gbl_locationPanel.rowHeights = new int[]{29, 0};
		gbl_locationPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_locationPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		locationPanel.setLayout(gbl_locationPanel);
		
		locationText = new JTextField();
		locationText.setName("text");
		GridBagConstraints gbc_locationText = new GridBagConstraints();
		gbc_locationText.fill = GridBagConstraints.HORIZONTAL;
		gbc_locationText.weightx = 1.0;
		gbc_locationText.anchor = GridBagConstraints.NORTHWEST;
		gbc_locationText.insets = new Insets(0, 0, 0, 5);
		gbc_locationText.gridx = 0;
		gbc_locationText.gridy = 0;
		locationPanel.add(locationText, gbc_locationText);
		locationText.setColumns(10);
		
		JButton goButton = new JButton("Go");
		goButton.setName("goButton");
		GridBagConstraints gbc_goButton = new GridBagConstraints();
		gbc_goButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_goButton.gridx = 1;
		gbc_goButton.gridy = 0;
		locationPanel.add(goButton, gbc_goButton);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel bookmarksPane = new JPanel();
		bookmarksPane.setName("bookmarks");
		splitPane.setLeftComponent(bookmarksPane);
		GridBagLayout gbl_bookmarksPane = new GridBagLayout();
		gbl_bookmarksPane.columnWidths = new int[]{0};
		gbl_bookmarksPane.rowHeights = new int[] {0, 0};
		gbl_bookmarksPane.columnWeights = new double[]{0.0, 0.0};
		gbl_bookmarksPane.rowWeights = new double[]{0.0, 0.0};
		bookmarksPane.setLayout(gbl_bookmarksPane);
		
		JList bookmarksList = new JList();
		bookmarksList.setName("list");
		GridBagConstraints gbc_bookmarksList = new GridBagConstraints();
		gbc_bookmarksList.weighty = 1.0;
		gbc_bookmarksList.fill = GridBagConstraints.BOTH;
		gbc_bookmarksList.anchor = GridBagConstraints.WEST;
		gbc_bookmarksList.insets = new Insets(0, 0, 0, 5);
		gbc_bookmarksList.gridx = 0;
		gbc_bookmarksList.gridy = 0;
		bookmarksPane.add(bookmarksList, gbc_bookmarksList);
		
		JButton addBookmarksButton = new JButton("Add bookmarks");
		addBookmarksButton.setName("addButton");
		GridBagConstraints gbc_addBookmarksButton = new GridBagConstraints();
		gbc_addBookmarksButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_addBookmarksButton.gridx = 1;
		gbc_addBookmarksButton.gridy = 1;
		bookmarksPane.add(addBookmarksButton, gbc_addBookmarksButton);
		
		JEditorPane htmlPane = new JEditorPane();
		htmlPane.setName("htmlContents");
		htmlPane.setContentType("text/html");
		splitPane.setRightComponent(htmlPane);
	}

}
