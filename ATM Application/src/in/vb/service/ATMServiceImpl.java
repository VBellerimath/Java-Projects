package in.vb.service;

import in.vb.dto.Account;

public class ATMServiceImpl implements IATMService {
	private static Account ac = null;

	@Override
	public String checkBalance(int pin) {
		if (ac == null) {
			ac = new Account();
		}if (ac.getPin() == pin) {
		return "Your account balance is :: +" + ac.getBalance();
		}else {
			return "you entered wrong pin";
		}
	}

	@Override
	public String WithDrawAmount(int pin, double amount) {
		if (ac == null) {
			ac = new Account();
		}
		if (ac.getPin() == pin) {
			ac.setBalance(ac.getBalance() - amount);
			return "amount withdraw successfully ur remaining balance is :: " + (ac.getBalance());
		} else {
			return "you entered wrong pin";
		}
	}

	@Override
	public String changePin(int pin, int newPin) {
		if (ac == null) {
			ac = new Account();
		}
		if (ac.getPin() == pin) {
			ac.setPin(newPin);
			return "pin changed successfully";
		} else
			return "you entered wrong pin";

	}

}
