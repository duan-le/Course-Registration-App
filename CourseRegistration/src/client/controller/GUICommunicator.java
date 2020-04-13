package client.controller;
import client.view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUICommunicator {

	GUI theGUI;
	
	public GUICommunicator()
	{
		theGUI = new GUI("Course Registration App");
	}


	public void sendResponse(String response,String number) {
		
		
		int n = Integer.parseInt(number);
		
		if(n == 1)
		{
			theGUI.displayMessageWindow(response);
		}
		else if(n == 2)
		{
			theGUI.displayMessageWindow(response);
		}
		else if(n == 3)
		{
			theGUI.displayMessageWindow(response);
		}
		else if(n == 4)
		{
			theGUI.displayCatalogue(response);
		}
		
		else if(n == 5)
		{
			if(!response.contentEquals("end"))
			{
				String [] word = response.split(",");
				theGUI.displayStudentCourses(word[0],word[1],word[word.length-1]);
			}
			
		}
		
			
	}

	public String result() {
		
		return theGUI.sending.get(theGUI.sending.size()-1);
	}


	public boolean buttonPressed() {
		
		if(theGUI.pressed == true)
		{
			return true;
		}
		else
			return false;
	}



	
}
