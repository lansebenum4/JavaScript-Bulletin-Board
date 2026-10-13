import java.util.Scanner;

public class TeamBoard { 

    public static void main(String[] args) {
        String[] notices = new String[10];
        int noticeCount = 0;
        
        try (Scanner userInput = new Scanner(System.in)) {
            int option = 0;

            while (option != 9) {
                System.out.println("\nSelect a number from the menu");
                System.out.println("(1) Post new notice");
                System.out.println("(2) Print all notices");
                System.out.println("(3) Print all notices in reverse order");
                System.out.println("(4) Print number of notices posted so far");
                System.out.println("(5) Search for a captain's name and print all notices they have posted");
                System.out.println("(6) Print the total number of digits across all notices");
                System.out.println("(7) Perform a search of notices containing a given word (case sensitive)");
                System.out.println("(8) Perform a search of notices containing a given word (case insensitive)");
                System.out.println("(9) End Program");
                System.out.print("Choice: ");

                if (userInput.hasNextInt()) {
                    option = userInput.nextInt();
                    userInput.nextLine();
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    userInput.nextLine(); 
                    continue;
                }

                switch (option) {
                    case 1: 
                        if (noticeCount >= 10) {
                            System.out.println("Error: The noticeboard is full! Cannot add more notices.");
                        } else {
                            System.out.print("Enter captain's name: ");
                            String name = userInput.nextLine().trim();

                            System.out.print("Enter notice: ");
                            String message = userInput.nextLine().trim();

                            notices[noticeCount] = name + " posts: " + message;
                            noticeCount++;
                            System.out.println("Notice posted successfully.");
                        }
                        break;

                    case 2: 
                        if (noticeCount == 0) {
                            System.out.println("No notices posted yet.");
                        } else {
                            for (int i = 0; i < noticeCount; i++) {
                                System.out.println(notices[i]);
                            }
                        }
                        break;

                    case 3: 
                        if (noticeCount == 0) {
                            System.out.println("No notices posted yet.");
                        } else {
                            for (int i = noticeCount - 1; i >= 0; i--) {
                                System.out.println(notices[i]);
                            }
                        }
                        break;

                    case 4: 
                        System.out.println("Number of notices posted so far: " + noticeCount);
                        break;

                    case 5: // Search for captain's name (case-insensitive)
                        System.out.print("Enter captain's name to search: ");
                        String searchCaptain = userInput.nextLine().trim();
                        boolean foundCaptain = false;

                        String prefixToMatch = (searchCaptain + " posts: ").toLowerCase();

                        for (int i = 0; i < noticeCount; i++) {
                            if (notices[i].toLowerCase().startsWith(prefixToMatch)) {
                                System.out.println(notices[i]);
                                foundCaptain = true;
                            }
                        }

                        if (!foundCaptain) {
                            System.out.println("No notices found for captain: " + searchCaptain);
                        }
                        break;
    
                    case 6: 
                        int totalDigits = 0;

                        for (int i = 0; i < noticeCount; i++) {
                            int delimiterIndex = notices[i].indexOf(" posts: ");
                            if (delimiterIndex != -1) {
                                String content = notices[i].substring(delimiterIndex + " posts: ".length());
                                for (int j = 0; j < content.length(); j++) {
                                    if (Character.isDigit(content.charAt(j))) {
                                        totalDigits++;
                                    }
                                }
                            }
                        }

                        System.out.println("Total number of digits in notice contents: " + totalDigits);
                        break;

                    case 7: // Case-sensitive word search
                        System.out.print("Enter word to search (case sensitive): ");
                        String wordCS = userInput.nextLine().trim();
                        boolean foundCS = false;

                        for (int i = 0; i < noticeCount; i++) {
                            if (notices[i].contains(wordCS)) {
                                System.out.println(notices[i]);
                                foundCS = true;
                            }
                        }

                        if (!foundCS) {
                            System.out.println("No notices contain the word: " + wordCS);
                        }
                        break;

                    case 8: // Case-insensitive word search
                        System.out.print("Enter word to search (case insensitive): ");
                        String wordCI = userInput.nextLine().trim();
                        boolean foundCI = false;

                        for (int i = 0; i < noticeCount; i++) {
                            if (notices[i].toLowerCase().contains(wordCI.toLowerCase())) {
                                System.out.println(notices[i]);
                                foundCI = true;
                            }
                        }

                        if (!foundCI) {
                            System.out.println("No notices contain the word: " + wordCI);
                        }
                        break;

                    case 9: // End Program
                        System.out.println("Ending Program.");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 9.");
                        break;
                }
            }
        }
    }
}