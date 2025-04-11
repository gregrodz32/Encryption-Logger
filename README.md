Project Overview 
1. Logger - Logs all activities with timestamps.  
2. Encryption - Encrypts and decrypts text using the Vigenère Cipher.  
3. Driver - The main program that interacts between both other programs and the user 

Processes communicate through pipes, and all user actions are recorded in a log.txt file.  



 To compile and run the files use the following in your terminal:
 
    cd GXR230010-Project-1
    javac Logger.java Encryption.java Driver.java
    java Driver log.txt
 

Usage Instructions -

    Upon starting Driver.java, you will be presented with a menu of available commands:

    Available Commands:

        password - Set the encryption passkey.

        encrypt - Encrypt a message.

        decrypt - Decrypt a message.

        history - Show past encrypted/decrypted messages.

        quit - Terminate all processes and exit.

    Example Usage:

    Setting a Password:
        > password
        Enter password: SECRET
        RESULT

    Encrypting a Message:
        > encrypt
        Enter text to encrypt: HELLO
        RESULT OIWWC

    Decrypting a Message:
        > decrypt
        Enter text to decrypt: OIWWC
        RESULT HELLO

    Viewing History:
        > history
        1. HELLO
        2. OIWWC

    Exiting the Program:
    > quit
    Exiting...

Error Handling -

If a user attempts to encrypt or decrypt without setting a password, an error is displayed.

Non-alphabetic input for encryption/decryption results in an error.

The program ensures all operations are logged properly before exiting.


Notes -

Ensure that log.txt is writable in the directory where the program runs.

The program is case-insensitive, converting input to uppercase automatically.

The encryption method follows the Vigenère cipher, which only processes letters (A-Z).


