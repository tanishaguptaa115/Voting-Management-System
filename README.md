# Voting System Project

This is a simple console-based Voting System implemented in **Java**. It allows registered voters to cast their votes, and administrators can log in to view the voter list, candidate profiles, and election results.

---
## Features
- **Voting Process**: Voters can cast their votes using either the candidate's name or emoji symbol.
- **Admin Panel**: Administrators can log in to view the list of voters, candidate profiles, and the current election results.
- **Validation**: Ensures only eligible voters (age 18+) can vote. Prevents multiple voting attempts.
- **Candidate Profiles**: Displays candidate information using emoji symbols.

## Prerequisites
- Java Development Kit (JDK) installed
- IDE or command line with Java support

## Project Structure
- `votingsystem6.java`: Main Java file containing the implementation.
- Data is stored using `HashMap` collections.

## How to Run
1. Clone or download the project.
2. Compile the program using the following command:
    ```bash
    javac votingsystem6.java
    ```
3. Run the program using:
    ```bash
    java votingsystem6
    ```

## Functionalities
### 1. Voting
- Users enter their name, age, and voter ID.
- If the voter ID and name match the records, they can cast their vote.
- Votes can be cast using the candidate name or emoji.

### 2. Admin Login
- Admins can log in using the following credentials:
  - **admin1@gmail.com / password123**
  - **admin2@gmail.com / password234**
- Admin functionalities include:
  - Viewing the Voter List (with voting status)
  - Viewing the Candidate List and Profiles
  - Displaying the Voting Results

## Sample Candidates
- 🪷 **Veer Singh** (BJP)
- 🙏 **Surender Pal Singh** (Congress)
- 🧹 **Pradeep Mittal** (AAP)
- 🐘 **Manoj Chaudhary** (BSP)
- ⚒ **Preeti Tomar** (CPI)
- 🏮 **Babita Shah** (RJD)

## Code Overview
- **Voter Management**: Manages voter registration and voting status using `HashMap`.
- **Candidate Management**: Tracks candidates, their symbols, and votes.
- **Admin Access**: Implements password-protected access for admin functionality.

## Future Enhancements
- Add a graphical user interface (GUI) for improved usability.
- Implement database integration for data persistence.
- Add real-time vote count updates.




