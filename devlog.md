# Devlog CS4348 Project 1

## 3/6/25 - Setup Initial Git Repo

Thoughts So Far:
I have received the project description and reviewed the requirements. The project consists of three separate programs that communicate via pipes:
- Logger: Responsible for recording logs with timestamps.
- Encryption Program: Handles encryption and decryption using a Vigenère cipher.
- Driver: It will be the main interface for interacting with the other two programs.

Plan for This Session:
- Set up the Git repository.
- Write the initial `devlog.md` entry.
- Start working on the Logger program.

Progress:
- Initialized the Git repository.
- created the `devlog.md` 
- Decided to use Java for the project
- The Driver program will use Java `Process` objects to manage the child processes for the Logger and Encryption programs.

## 3/8/25 - Implemented Logger Program

Thoughts So Far:
- The logger needs to continuously listen for log messages via `stdin` and append them to a log file with a timestamp.
- Need to ensure that messages are correctly formatted according to the project specifications.

Plan for This Session:
- Implement `Logger.java` to accept a filename as a command-line argument and log messages.
- Test logging functionality by manually sending input.

Progress:
- Implemented `Logger.java` successfully.
- Tested it by manually inputting text, and verified that timestamps are properly formatted.
- The logger correctly appends log messages to `log.txt`.

Next Steps:
- Begin working on `Encryption.java`.


Implemented Encryption Program

- The encryption program needs to support four commands: `PASS`, `ENCRYPT`, `DECRYPT`, and `QUIT`.
- The program must store the passkey and use the Vigenère cipher for encryption and decryption.
- Error handling is necessary if `ENCRYPT` or `DECRYPT` is called before setting a password.

Plan for This Session:
- Implement the Vigenère cipher algorithm.
- Implement basic command handling.

Progress:
- Implemented `Encryption.java`.
- Verified that `PASS` sets the passkey.
- Implemented the Vigenère cipher in `vCipher()` method.
- Verified correct encryption and decryption behavior.
- Added error handling for cases where encryption/decryption is attempted without a passkey.
- Passed all basic tests.

Next Steps:
- Start working on the `Driver.java` file.
- Ensure interprocess communication (IPC) between the programs using pipes.

## 3/10/25 - Implemented Driver Program

Thoughts So Far:
- The driver must:
  - Start the Logger and Encryption processes.
  - Facilitate communication between the user and both programs via pipes.
  - Maintain a history of encrypted and decrypted messages.
  - Ensure proper logging of actions.

Plan for This Session:
- Implement `Driver.java` to spawn and manage the other two processes.
- Establish correct communication flow between processes.
- Ensure `history` command works properly.
- Handle program termination correctly.

Progress:
- Implemented `Driver.java` with interprocess communication.
- Successfully starts `Logger` and `Encryption` processes.
- Can send commands to the encryption program and receive responses.
- Logs all operations properly.
- Fixed issue where the `QUIT` command was not being logged before termination.
- Verified correct behavior through testing.
- Implemented history tracking for encryption and decryption operations.

Next Steps:
- Create a `README.md` file
- Perform additional testing for final verification

## 3/11/25 - Final Testing and Documentation

Thoughts So Far:
- The project is mostly complete.
- Need to ensure the program handles invalid input gracefully.
- The README should clearly document the setup, usage, and expected behavior.

Plan for This Session:
- Conduct edge-case testing (invalid inputs, long messages, etc.).
- Ensure that encryption/decryption only processes letters.
- Write documentation.

Progress:
- Identified and fixed minor issues with edge cases.
- Ensured logging format matches project specifications.
- Wrote `README.md` detailing how to compile and run the project.
- Committed final changes to Git.

## 3/14/25 - 