import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bankonet.command.ExitCommand;
import com.bankonet.command.IHMcommand;
import com.bankonet.command.ListerClientsCommand;
import com.bankonet.command.OuvrirCCCommand;
import com.bankonet.dao.DaoFactory;
import com.bankonet.dao.DaoFactoryJpa;
import com.bankonet.dao.DaoFactoryMySQL;

import metier.ClientService;
import metier.ClientServiceImpl;

public class ConsoleCommand {

	public ConsoleCommand() {
		menu();
	}

	Integer choix;
	// private DaoFactory daoFactory = new DaoFactoryFile();
	//private DaoFactory daoFactory = new DaoFactoryMySQL();
	private DaoFactory daoFactory = new DaoFactoryJpa("temp");

	private ClientService client = new ClientServiceImpl(daoFactory.getClientDao(), daoFactory.getCompteDao());
	// List<IHMcommand> commands = Arrays.asList(new ExitCommand(0, client), new
	// OuvrirCCCommand(1, client),...

	Map<Integer, IHMcommand> commands = new HashMap<Integer, IHMcommand>();

	Scanner user_input = new Scanner(System.in);

	public void menu() {
		CommandSet();
		while (true) {
			System.out.println("***** APPLICATION CONSEILLER BANCAIRE ******\n");
			for (IHMcommand ihm : commands.values()) {
				System.out.println(ihm.getId() + "	" + ihm.getLibelle());
			}
			System.out.println("init debut");
			client.creerCompte("aa");//fake init()
			System.out.println("init fin");
			
			choix = user_input.nextInt();
			if (commands.containsKey(choix)) {
				commands.get(choix).execute();
			}
		}

	}

	public void CommandSet() {
		commands.put(0, new ExitCommand(0, client));
		commands.put(1, new OuvrirCCCommand(1, client));
		commands.put(2, new ListerClientsCommand(2, client));
	}
	

}