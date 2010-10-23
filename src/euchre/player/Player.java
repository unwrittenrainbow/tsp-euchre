package euchre.player;

public interface Player {
	Card[] hand = new Card[5];
	String name = "";
	
	public void drawCard(Card c);
	
	public boolean orderUp(Card c);

	public char callSuit();
	
	public Card playCard();

	public void setTeam(int i);
	
	public int getTeam();

	public Card discard();
	
	public void setName();
	
	public void getName();

	public int getNumber();
	
	public void setNumber(int i);
}
