import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Help extends ModuleBase {

	public Help(MessageReceivedEvent event) {
		super(event);
	}

	@Override
	public void process() {
		channel.sendMessage("**Text Commands**" + "\n"

				+ "\t" + "/ping" + "\n\t" + "/coinflip" + "\n\t" + "/eightball" + "\n\t" + "/roll xdy" + "\n\t\t"
				+ "x = amount of dice being rolled" + "\n\t\t" + "y = number of sides" + "\n\n"

				+ "**GIF Commands**" + "\n\t" + "/brain" + "\n\t" + "/cat" + "\n\t" + "/spongebob" + "\n\n"

				+ "**About/Contact**" + "\n\t" + "Twitter: https://twitter.com/samadPNG" + "\n\t"
				+ "Discord: samad#3356" + "\n\t" + "").queue();
	}

}