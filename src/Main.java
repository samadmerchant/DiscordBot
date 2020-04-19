import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
			JDA api = new JDABuilder(AccountType.BOT)
					.setToken("TOKEN").build();
			/* if i share the actual token people will
			be able to run/modify my bot */
			api.addEventListener(new CommandHandler());
			api.addEventListener(new FileCommands());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
