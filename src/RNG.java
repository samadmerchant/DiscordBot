import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.dv8tion.jda.core.entities.MessageChannel;

public class RNG {

	public static void rollDice(MessageChannel channel, String content) {
		/*
		 * Dice Roll Segment Input: (String) content Format: "/roll xdy" x = amount of
		 * dice rolled y = number of sides on each dice Goal Output: # # # (# is result
		 * of dice roll)
		 * 
		 * Example Input: 2 dice, 5 sides Example Output: 2 3
		 */

		/*
		 * Plan 1. substring on second half 2. split with d delimiter 3. convert to
		 * integer from string 4. logic
		 */

		content = content.toLowerCase();
		String dice_content = content.substring(6);
		String[] params = dice_content.split("d");
		try {
			int x = Integer.parseInt(params[0]); // Note: check that they actually put numbers for x and y
			int y = Integer.parseInt(params[1]);
			for (int i = 1; i <= x; i++) {
				int randomNumber = randomNumInRange(1, y);
				channel.sendMessage("Roll " + i + ":\t" + "**" + randomNumber + "**").queue();
			}
		} catch (NumberFormatException e) {
			System.out.println("Dice Roll: Invalid input");
		}
	}

	/*
	 * Random Number Generation Function Input: range start, range end Output:
	 * random number between "start" and "end", inclusive Example: start = 1, end =
	 * 5 Output: random number between 1 and 5 (could be 1, 2, 3, 4, or 5)
	 */

	private static int randomNumInRange(int start, int end) {
		end = end + 1;
		Random random = new Random();
		return random.nextInt(end - start) + start;
	}

	public static void eightBall(MessageChannel channel, String content) {
		List<String> responses = new ArrayList<>();
		// Positive Responses
		responses.add("It is certain");
		responses.add("It is decidedly so");
		responses.add("Without a doubt");
		responses.add("Definitely");
		responses.add("You may rely on it");
		responses.add("As I see it, yes");
		responses.add("Most likely");
		responses.add("Outlook good");
		responses.add("Yes");
		responses.add("Signs point to yes");
		// Maybe Responses
		responses.add("Reply unclear, try again");
		responses.add("Ask again later");
		responses.add("Better not tell you now ;)");
		responses.add("Cannot predict now");
		responses.add("Concentrate and ask again");
		// Negative Responses
		responses.add("Don't count on it");
		responses.add("My reply is no");
		responses.add("My sources say no");
		responses.add("Outlook not so good");
		responses.add("Very doubtful");

		int index = randomNumInRange(0, responses.size() - 1);

		channel.sendMessage(responses.get(index)).queue();
	}

	public static void coinflip(MessageChannel channel, String content) {
		int index = randomNumInRange(0, 1);
		String token;
		if (index == 0) {
			token = "You landed on heads!";
			channel.sendMessage(token).queue();
		} else {
			token = "You landed on tails!";
			channel.sendMessage(token).queue();
		}
	}
}