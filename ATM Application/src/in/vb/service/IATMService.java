package in.vb.service;

public interface IATMService {
	public String checkBalance(int pin);

	public String WithDrawAmount(int pin, double money);

	public String changePin(int pin, int newPin);
}
