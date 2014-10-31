public class Reservation {
	private String date;
	private String time;
	private int pax;
	private Member customer;
	
	public Reservation(String date, String time, int pax, Member customer){
		this.setDate(date);
		this.setTime(time);
		this.setPax(pax);
		this.setCustomer(customer);
	}
	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getTime(){
		return this.time;
	}
	public void setTime(String time){
		this.time = time;
	}
	public int getPax(){
		return pax;
	}
	public void setPax(int pax){
		this.pax = pax;
	}
	public Member getCustomer(){
		return this.customer;
	}
	public void setCustomer(Member customer){
		this.customer = customer;
	}

}
