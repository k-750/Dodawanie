
public class Controller implements Observer
{
	
	private Model model;
	private View view;
	
	public Controller(Model model, View view)
	{
		this.model=model;
		this.view=view;
	}
	public void update()
	{
		model.setValue1(view.getValue1());
		model.setValue2(view.getValue2());
		model.setResult(model.getValue1()+model.getValue2());
		view.setResult(model.getResult());
	}
}
