import java.util.*;


public class votingsystem6 {
    private static HashMap<String, String> voterDatabase = new HashMap<>(); // (VoterID -> Name)
    private static HashMap<String, Integer> candidates = new HashMap<>(); // (Candidate Name or Emoji -> Vote Count)
    private static HashMap<String, Boolean> votedUsers = new HashMap<>(); // (VoterID -> HasVoted)
    private static HashMap<String, String> candidateProfiles = new HashMap<>(); // (Candidate -> Profile Info)
    private static HashMap<String, String> candidateSymbols = new HashMap<>(); // (Candidate Name -> Emoji)
    private static HashMap<String, String> adminAccounts = new HashMap<>(); // (AdminID -> Password)

    public static void main(String[] args) {
    

        initializeData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Voting System Menu ---");
            System.out.println("1. Vote");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    castVote(scanner);
                    break;
                case 2:
                    adminLogin(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeData() {
        // Predefined voters (VoterID -> Name)
        voterDatabase.put("VOT1", "K.Rinku");
        voterDatabase.put("VOT2", "Deepak Singla");
        voterDatabase.put("VOT3", "Ram Kishore");
        voterDatabase.put("VOT4", "Ajay Dutta");
        voterDatabase.put("VOT5", "Mamta Rani");
        voterDatabase.put("VOT6", "Aruna Kumari");
        voterDatabase.put("VOT7", "Kamal Gupta");
        voterDatabase.put("VOT8", "Dr P.K Mishra");
        voterDatabase.put("VOT9", "Anil Kumar");
        voterDatabase.put("VOT10", "Tarun Yadav");

        // Candidate symbols (emojis)
        candidateSymbols.put("Veer Singh", "🪷");
        candidateSymbols.put("Surender Pal Singh", "🙏");
        candidateSymbols.put("Pradeep Mittal", "🧹");
        candidateSymbols.put("Manoj Chaudhary", "🐘");
        candidateSymbols.put("Preeti Tomar", "⚒");
        candidateSymbols.put("Babita Shah", "🏮");

        // Candidate Profiles
        candidateProfiles.put("🪷", "Veer Singh - Party: BJP | Motto: Sabka Saath, Sabka Vikas, Sabka Vishwas");
        candidateProfiles.put("🙏", "Surender Pal Singh - Party: CONGRESS | Motto: Satyamev Jayate");
        candidateProfiles.put("🧹", "Pradeep Mittal - Party: AAP | Motto: Mere Paas Hai Aam Aadmi Ki Awaz");
        candidateProfiles.put("🐘", "Manoj Chaudhary - Party: BSP | Motto: Tilak, Tarazu aur Talwar, Inko Maro Jute Char");
        candidateProfiles.put("⚒", "Preeti Tomar - Party: CPI | Motto: Workers of the world unite!");
        candidateProfiles.put("🏮", "Babita Shah - Party: RJD | Motto: Social Justice and Empowerment");

        // Candidates with initial vote count
        for (Map.Entry<String, String> entry : candidateSymbols.entrySet()) {
            candidates.put(entry.getKey().toLowerCase(), 0); // Store name in lowercase
            candidates.put(entry.getValue(), 0); // Store emoji
        }

        // Predefined Admin Accounts
        adminAccounts.put("admin1@gmail.com", "password123");
        adminAccounts.put("admin2@gmail.com", "password234");
    }

    private static void castVote(Scanner scanner) {
        System.out.print("\nEnter your Name (as per voter records): ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter your Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (age < 18) {
            System.out.println("You are not eligible to vote!");
            return;
        }

        System.out.print("Enter your Voter ID: ");
        String voterID = scanner.nextLine().trim().toUpperCase();

        if (!voterDatabase.containsKey(voterID) || !voterDatabase.get(voterID).equalsIgnoreCase(name)) {
            System.out.println("Name and Voter ID do not match! Exiting voting process...");
            return;
        }

        if (votedUsers.getOrDefault(voterID, false)) {
            System.out.println("You have already voted! You cannot vote again.");
            return;
        }

        // Display candidates with their emojis
        System.out.println("\nCandidates (You can vote using Name or Emoji):");
        for (Map.Entry<String, String> entry : candidateSymbols.entrySet()) {
            System.out.println(entry.getValue() + " - " + entry.getKey());
        }

        System.out.print("Enter the Candidate Name or Emoji to vote: ");
        String vote = scanner.nextLine().trim().toLowerCase();

        // Check if the input matches a candidate name or emoji
        String matchedCandidate = null;
        for (Map.Entry<String, String> entry : candidateSymbols.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(vote) || entry.getValue().equals(vote)) {
                matchedCandidate = entry.getValue(); // Store emoji as the key for voting
                break;
            }
        }

        if (matchedCandidate != null) {
            candidates.put(matchedCandidate, candidates.get(matchedCandidate) + 1);
            votedUsers.put(voterID, true);
            System.out.println("Thank you for voting!");
        } else {
            System.out.println("Invalid vote! Please vote using the correct Name or Emoji.");
        }
    }

    private static void adminLogin(Scanner scanner) {
        System.out.print("\nEnter Admin ID: ");
        String adminID = scanner.nextLine().trim();

        System.out.print("Enter Admin Password: ");
        String adminPassword = scanner.nextLine().trim();

        if (adminAccounts.containsKey(adminID) && adminAccounts.get(adminID).equals(adminPassword)) {
            System.out.println("\n✅ Login Successful! Welcome, Admin.");
            adminMenu(scanner);
        } else {
            System.out.println("❌ Invalid Admin Credentials! Access Denied.");
        }
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Voter List");
            System.out.println("2. View Candidate List");
            System.out.println("3. View Election Results");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewVoterList();
                    break;
                case 2:
                    viewCandidateList();
                    break;
                case 3:
                    displayResults();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewVoterList() {
        System.out.println("\n--- Voter List ---");
        for (Map.Entry<String, String> entry : voterDatabase.entrySet()) {
            String voterID = entry.getKey();
            String voterName = entry.getValue();
            String status = votedUsers.getOrDefault(voterID, false) ? "Voted" : "Not Voted";
            System.out.println(voterName + " (ID: " + voterID + ") - " + status);
        }
    }

    private static void viewCandidateList() {
        System.out.println("\n--- Candidate List & Profiles ---");
        for (Map.Entry<String, String> entry : candidateProfiles.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static void displayResults() {
        System.out.println("\n--- Voting Results ---");
        for (String emoji : candidateProfiles.keySet()) {
            System.out.println(emoji + " - " + candidateProfiles.get(emoji) + " | Votes: " + candidates.get(emoji));
        }
    }
}