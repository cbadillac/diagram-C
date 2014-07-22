import java.awt.Graphics;
import java.util.ArrayList;


public class IfSentence extends NodeDC {
	private static int id=0;
	private IfSentenceView view;
	private String text;
	private ArrayList<NodeDC> ifConditions;
	private ArrayList<NodeDC> elseConditions;

	
	public IfSentence() {
		super(id++);
		view = new IfSentenceView(this);
		text = new String();
		System.out.print("If Created :) id:" + id + "\n");
		ifConditions = new ArrayList<NodeDC>();
		elseConditions = new ArrayList<NodeDC>();
		
	}

	@Override
	String toC() {
		// TODO Auto-generated method stub
		return null;
	}

	public IfSentenceView getView(){
		return view;
	}
	
	public void updateView(Graphics g){
		view.updateView(g);
	}
	
	public String getText(){
		return text;
	}
	
	public void setText(String txt){
		this.text = txt;
	}

	public ArrayList<NodeDC> getIfConditions() {
		return ifConditions;
	}

	public void setIfConditions(ArrayList<NodeDC> ifConditions) {
		this.ifConditions = ifConditions;
	}

	public ArrayList<NodeDC> getElseConditions() {
		return elseConditions;
	}

	public void setElseConditions(ArrayList<NodeDC> elseConditions) {
		this.elseConditions = elseConditions;
	}
}
