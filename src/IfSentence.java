import java.awt.Graphics;


public class IfSentence extends NodeDC {
	private static int id=0;
	private IfSentenceView view;
	private String text;
	
	public IfSentence() {
		super(id++);
		view = new IfSentenceView(this);
		text = new String();
		System.out.print("If Created :) id:" + id + "\n");		
	}

	@Override
	String toC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getType() {
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
}
