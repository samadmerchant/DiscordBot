import java.io.File;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class FileCommands extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot())
			return;

		// initializations
		Message message = event.getMessage();
		String content = message.getContentRaw();
		net.dv8tion.jda.core.entities.MessageChannel channel = event.getChannel();
		String prefix = "/";

		// file initializations
		File brain = new File("brain.gif");
		File cat = new File("cat.gif");
		File spongebob = new File("spongebob.gif");

		if (content.startsWith(prefix + "brain")) {
			channel.sendFile(brain).queue();
		}

		if (content.startsWith(prefix + "cat")) {
			channel.sendFile(cat).queue();
		}

		if (content.startsWith(prefix + "spongebob")) {
			channel.sendFile(spongebob).queue();
		}
	}
}