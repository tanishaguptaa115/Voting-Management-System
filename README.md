# Voting Management System

This is a simple console-based Voting System implemented in Java. It allows registered voters to cast their votes, and administrators can log in to view the voter list, candidate profiles, and election results.

# Features

1. Voting Process: Voters can cast their votes using either the candidate's name or emoji symbol.

2. Admin Panel: Administrators can log in to view the list of voters, candidate profiles, and the current election results.

3. Validation: Ensures only eligible voters (age 18+) can vote. Prevents multiple voting attempts.

4. Candidate Profiles: Displays candidate information using emoji symbols.

# Prerequisites

1. Java Development Kit (JDK) installed

2. IDE or command line with Java support

# Project Structure

1. votingsystem6.java: Main Java file containing the implementation.

2. Data is stored using HashMap collections.

# Functionalities

1. Voting

  a. Users enter their name, age, and voter ID.

  b. If the voter ID and name match the records, they can cast their vote.

  c. Votes can be cast using the candidate name or emoji.

2. Admin Login

  a. Admins can log in using the following credentials:

   admin1@gmail.com / password123

   admin2@gmail.com / password234

  b. Admin functionalities include:

   Viewing the Voter List (with voting status)

   Viewing the Candidate List and Profiles

   Displaying the Voting Results

  c. Sample Candidates

  🪷 Veer Singh (BJP)

  🙏 Surender Pal Singh (Congress)

  🧹 Pradeep Mittal (AAP)

  🐘 Manoj Chaudhary (BSP)

  ⚒ Preeti Tomar (CPI)

  🏮 Babita Shah (RJD)

# Code Overview

1. Voter Management: Manages voter registration and voting status using HashMap.

2. Candidate Management: Tracks candidates, their symbols, and votes.

3. Admin Access: Implements password-protected access for admin functionality.

# Future Enhancements

1. Add a graphical user interface (GUI) for improved usability.

2. Implement database integration for data persistence.

3. Add real-time vote count updates.
