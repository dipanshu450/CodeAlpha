import java.util.Scanner;

public class SimpleChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm your ChatBot. Type 'exit' to end the chat.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.contains("exit")) {
                System.out.println("ChatBot: Goodbye!");
                break;
            } else if (input.contains("hello") || input.contains("hi")) {
                System.out.println("ChatBot: Hi there! How can I help you?");
            } else if (input.contains("how are you")) {
                System.out.println("ChatBot: I'm just a bot, but I'm functioning well!");
            } else if (input.contains("your name")) {
                System.out.println("ChatBot: I'm CodeAlphaBot, your virtual assistant.");
            } else if (input.contains("help")) {
                System.out.println("ChatBot: You can ask me about general stuff, or just chat!");
            } else {
                System.out.println("ChatBot: Sorry, I didn't understand that.");
            }
        }

        scanner.close();
    }
}
