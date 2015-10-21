import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.bankonet.command.ExitCommand;
import com.bankonet.command.IHMcommand;
import com.bankonet.command.OuvrirCompte;
import com.bankonet.dao.DaoFactory;
import com.bankonet.dao.DaoFactoryJpa;
import com.bankonet.dao.client.ClientException;

import metier.ClientService;
import metier.ClientServiceImpl;
import metier.CompteService;
import metier.CompteServiceImpl;
import metier.InitService;

public class ConsoleCompte {

	public ConsoleCompte() {
		try {
			menu();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Integer choix;
	// private DaoFactory daoFactory = new DaoFactoryFile();
	//private DaoFactory daoFactory = new DaoFactoryMySQL();
	private DaoFactory daoFactory = new DaoFactoryJpa("bankonet-tp-11");

	//private ClientService client = new ClientServiceImpl(daoFactory.getClientDao(), daoFactory.getCompteDao());
	private CompteService compte = new CompteServiceImpl(daoFactory.getClientDao(), daoFactory.getCompteDao());

	// List<IHMcommand> commands = Arrays.asList(new ExitCommand(0, client), new
	// OuvrirCCCommand(1, client),...

	Map<Integer, IHMcommand> commands = new HashMap<Integer, IHMcommand>();

	Scanner user_input = new Scanner(System.in);

	public void menu() throws ClientException {
		CommandSet();
		while (true) {
			System.out.println("*****	APPLICATION	CONSEILLER	BANCAIRE ******\n");
			for (IHMcommand ihm : commands.values()) {
				System.out.println(ihm.getId() + "	" + ihm.getLibelle());
			}		
			choix = user_input.nextInt();
			if (commands.containsKey(choix)) {
				commands.get(choix).execute();
			}
		}

	}

	//1.	Ouvrir	un	compte courant

	//2.	Lister	tous	les	clients

	
	public void CommandSet() {
		commands.put(0, new ExitCommand(0, compte));
		commands.put(1, new OuvrirCompte(1, compte));
	}
	

}