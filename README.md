# 🔐 YourSecrets - Java Password Manager

**YourSecrets** is a console-based password manager built with **Java**.  
It allows users to securely store website credentials using **AES encryption**.

I developed this simple project during my **3rd semester Object-Oriented Programming (OOP) course** to practice core programming concepts such as **OOP design, file handling, serialization, and encryption**.

---

## 🚀 Features

### 👤 User Authentication
- Register a new user account
- Login using a username and password

### 🔒 Encrypted Password Storage
- Encrypt passwords using **AES (128-bit)**
- Store credentials securely in encrypted form

### 🗄 Credential Vault
- Add new credentials (website, username, password)
- View all stored credentials
- Search credentials by website name
- Delete saved credentials

### 💾 Persistent Storage
- Store user accounts in `users.db`
- Save each user's credentials in a separate vault file (`vault_username.db`)
- Use **Java Serialization** to persist data

---

## 🏗 Project Structure

```
YourSecrets/
│
├── Credential.java        # Represents a single website credential
├── EncryptionHelper.java  # Performs AES encryption and decryption
├── FileHelper.java        # Saves and loads vault data
├── User.java              # Defines the user model
├── UserDB.java            # Manages user registration and login
├── Vault.java             # Manages stored credentials
└── YourSecrets.java       # Runs the main CLI application
```

---

## ⚙️ Technologies Used

- **Java**
- **Object-Oriented Programming**
- **AES Encryption**
- **Java Serialization**
- **File Handling**
- **Java Collections Framework**

---

## 🖥 Example Program Flow

```
1. Register
2. Login
3. Exit
```

After logging in, the program shows:

```
1. Add Credential
2. View All Credentials
3. Search Credential
4. Delete Credential
5. Save & Logout
```

---

## 🔐 Security Note

This project uses **AES encryption** to protect stored passwords.  
I built this application **for learning purposes**, so it does not implement all security practices required for production systems.

A production password manager should include:

- Password hashing (bcrypt or Argon2)
- Secure key derivation (PBKDF2)
- Strong encryption modes
- Secure key management

---

## 📚 What I Learned

While building this project, I practiced:

- Designing programs with **Object-Oriented Programming**
- Implementing **file persistence using serialization**
- Using **Java cryptography for encryption**
- Building **command-line applications**
- Managing data with **Java collections**

---

⭐ If you find this project useful, consider giving it a star!
