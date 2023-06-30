package in.vb.controller;

import java.util.Scanner;

import in.vb.serviceFactory.IATMServiceFactory;

public class RunAtm {
	public static void runAtm() {
		Scanner sc = new Scanner(System.in);
		boolean session = true;
		while (session) {
			System.out.println("please choose the operation you want :: 1=>check balance");
			System.out.println("                                        2=>withdraw amount");
			System.out.println("                                        3=>change pin");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.println("please enter the pin :: ");
				int pin = sc.nextInt();
				System.out.println(IATMServiceFactory.getIATMService().checkBalance(pin));
			}
				break;
			case 2: {
				System.out.println("please enter the pin :: ");
				int pin = sc.nextInt();
				System.out.println("please enter the amount :: ");
				double money = sc.nextDouble();
				System.out.println(IATMServiceFactory.getIATMService().WithDrawAmount(pin, money));
			}
				break;
			case 3: {
				System.out.println("please enter the pin :: ");
				int pin = sc.nextInt();
				System.out.println("please enter the new pin :: ");
				int newPin = sc.nextInt();
				System.out.println(IATMServiceFactory.getIATMService().changePin(pin, newPin));
			}
				break;
			default: {
				System.out.println("Please enter the valid input and try after some time ....");
				session = false;
			}
			}
		}
	}
}
