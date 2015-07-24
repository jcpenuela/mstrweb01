import com.microstrategy.web.objects.WebIServerSession;
import com.microstrategy.web.objects.WebObjectsException;
import com.microstrategy.web.objects.WebObjectsFactory;
import com.microstrategy.web.portlets.utils.EnumDSSXMLAuthModes;

import java.util.Scanner;

public class Mstr01 {

	private WebIServerSession mServerSession;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mstr01 app = new Mstr01();
		System.out.println("Prueba MSTR");
		app.openSession();
		System.out.println("Conectado");
		System.out.println("Escriba 'S' y pulse [ENTER]");
		Scanner s = new Scanner(System.in);
		String h = s.next();

		app.closeSession();
		System.out.println("Desconectado");
		s.close();

	}

	private void openSession() {
		// Create IS session
		WebObjectsFactory objectFactory = WebObjectsFactory.getInstance();
		String sessionID = null;
		
		// Session parameters
		mServerSession = objectFactory.getIServerSession();
		mServerSession.setAuthMode(EnumDSSXMLAuthModes.DssXmlAuthStandard);
		mServerSession.setProjectName("MicroStrategy Tutorial");
		mServerSession.setLogin("administrator");
		mServerSession.setPassword("");
		// Can also be the IP Address
		mServerSession.setServerName("SEVGES034");
		// If set to 0, default Microstrategy value would be used.
		mServerSession.setServerPort(34952);
		try {
			sessionID = mServerSession.getSessionID();
		} catch (WebObjectsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sessionID);

	}

	private void closeSession() {
		try {
			if (mServerSession != null) {
				mServerSession.closeSession();
			}
		} catch (WebObjectsException lException) {
			lException.printStackTrace();
		}
	}

}
