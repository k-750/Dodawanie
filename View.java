import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame implements ActionListener, Subject
{
	private JTextField value1;
	private JLabel plus;
	private JPanel calcPanel;
	private JTextField value2;
	private JButton obl;
	private JLabel result;
	
	private ArrayList<Observer> observers;
	
	public View()
	{
		super("Calculator");
		setSize(400,60);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		observers = new ArrayList<>();
		
		value1 = new JTextField();
		
		plus = new JLabel("+");
		
		calcPanel = new JPanel();
		
		value2 = new JTextField();
		
		obl = new JButton("olb");
		obl.addActionListener(this);
		
		result = new JLabel("wynik");
		
		calcPanel.add(value1);
		calcPanel.add(plus);
		calcPanel.add(value2);
		calcPanel.add(obl);
		calcPanel.add(result);
		calcPanel.setLayout(new GridLayout(1,5));
		this.add(calcPanel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		notifyObserver();
	}
	
	public void setVisible()
	{
		this.setVisible(true);
	}
	
	public int getValue1()
	{
		int value = 0;
		try
		{
			value = Integer.parseInt(value1.getText());
		} catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Błędna pierwsza wartość");
		}
		return value;
	}
	
	public int getValue2()
	{
		int value = 0;
		try
		{
			value = Integer.parseInt(value2.getText());
		} catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Błędna druga wartość");
		}
		return value;
	}
	
	public void setResult(int text)
	{
		result.setText(String.valueOf(text));
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (Observer o : observers)
		{
			o.update();
		}
	}
}
