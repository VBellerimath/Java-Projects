package in.vb.serviceFactory;

import in.vb.service.ATMServiceImpl;
import in.vb.service.IATMService;

public class IATMServiceFactory {
	private static IATMService service = null;

	// made constructor as private to avoid object creation
	private IATMServiceFactory() {

	}

	public static IATMService getIATMService() {
		if (service == null) {
			service = new ATMServiceImpl();
		}
		return service;
	}
}
