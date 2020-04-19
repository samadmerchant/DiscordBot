import java.awt.Color;
import java.io.File;

import net.dv8tion.jda.bot.JDABot;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.entities.MessageActivity.ActivityType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

@SuppressWarnings("unused")

public class CommandHandler extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot())
			return;

		// initializations
		Message message = event.getMessage();
		String content = message.getContentRaw();
		net.dv8tion.jda.core.entities.MessageChannel channel = event.getChannel();
		String prefix = "/";

		// embed builder
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("bleh");
		eb.setColor(Color.RED);

		/*
		 * if need embeds here's a template //embeds 
		 * if (content.startsWith(prefix + "test")) {
		 * channel.sendMessage(eb.build()).queue();
		 * }
		 */

		// help
		if (content.startsWith(prefix + "help")) {
			new Help(event);
		}

		// ping
		if (content.startsWith(prefix + "ping")) {
			channel.sendMessage("Your ping is " + event.getJDA().getPing()).queue();
		}

		// dice roll
		if (content.startsWith(prefix + "roll ") && content.length() >= 9) {
			RNG.rollDice(channel, content);
		}

		// eight ball
		if (content.startsWith(prefix + "eightball")) {
			RNG.eightBall(channel, content);
		}

		// coin flip
		if (content.startsWith(prefix + "coinflip")) {
			RNG.coinflip(channel, content);
		}

		// if-do
		if (content.equalsIgnoreCase("nah")) {
			channel.sendMessage("yah").queue();
		}
	}
}