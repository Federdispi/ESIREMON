package attack;

public class Attack {
	protected String name;
	protected int limitMax;
	protected int limit;
	protected int power;
	
	/*
	 * Constructor
	 */
	public Attack(String name, int limitMax, int power) {
		this.name = name;
		this.limitMax = limitMax;
		this.limit = this.limitMax;
		this.power = power;
	}
	
	/*
	 * GETTERS
	 */
	public String getName() {
		return this.name;
	}
	
	public int getLimitMax() {
		return this.limitMax;
	}
	
	public int getLimit() {
		return this.limit;
	}
	
	public int getPower() {
		return this.power;
	}
	
	/*
	 * SETTERS
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
