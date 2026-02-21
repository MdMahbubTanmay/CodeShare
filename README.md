# CodeShare (Java + NetBeans)
[![Screenshot-Of-CodeShare.png](https://i.postimg.cc/yxqfZVCn/Screenshot-from-2026-02-21-19-19-14.png)](https://postimg.cc/hzrbFRj7)
CodeShare is a small cross‑platform Java desktop app that lets you share code **directly from one user to another** using a **unique machine ID**.  
It’s built in **Java (NetBeans)** and uses **Google Firebase** as the backend to sync/transfer snippets.

Tested on **Ubuntu** and **Windows 11**.

---

## What this project does

- **Share code user-to-user** (no messy chat formatting, no zip files)
- Uses a **Unique Machine ID** to identify the sender/receiver
- Stores/transfers code through **Firebase**
- Can **compile code inside the app** (so you can quickly check if it runs)

---

## How sharing works (high level)

1. Each device has a **Machine ID**
2. You choose the target user/device by that ID
3. The app pushes/pulls the code via **Firebase**
4. Receiver gets the code and can view/copy/compile it (depending on your UI)

---

## Tech Stack

- **Language:** Java
- **IDE:** NetBeans
- **Backend / Sync:** Google Firebase
- **Platforms tested:** Ubuntu, Windows 11

---

## Requirements

- **Java JDK** (recommended: 21+ or whatever you used during development)
- **NetBeans** (recommended for easiest setup)
- A **Firebase project** + config/credentials used by the app

---

## Setup (Local)

### 1) Clone the repo
```bash
git clone https://github.com/MdMahbubTanmay/CodeShare.git
cd CodeShare
```

### 2) Open in NetBeans
- Open NetBeans
- **File → Open Project**
- Select the `CodeShare` folder

### 3) Configure Firebase
This project uses Firebase, so you’ll need to connect your own Firebase project (or use the existing one if you’re the owner).

Common setups look like one of these:
- `google-services.json` (more common in Android)
- Firebase Admin SDK JSON key (often used for server/desktop apps)
- A custom config file in the project (properties/json)

If you tell me where your Firebase config lives in this repo (filename/path), I’ll update this README with the exact steps.

### 4) Run
Run the main project from NetBeans (or run the main class) and the UI should start.

---

## Compiling Code Inside the App

The app can compile code from within the UI.  
Exact supported languages/commands depend on how you implemented it.

If compilation requires extra tools (e.g., `javac`, `gcc`, etc.), install them on your machine and ensure they’re on PATH.

---

## Notes / Limitations

- Sharing is based on a **machine ID**, so IDs should be treated like an identifier you only share with people you trust.
- If Firebase rules are too open, anyone could read/write data—make sure your Firebase rules match your intended privacy model.

---

## Roadmap (ideas)

- Better authentication (Google sign-in / email-password)
- Friend list / contacts instead of manual machine IDs
- End-to-end encryption for shared code
- Snippet history + search
- Language-aware compilation presets

---

## Contributing

Contributions are welcome:
1. Fork the repo
2. Create a feature branch
3. Open a PR

If you’re planning something bigger, open an issue first so we can align.

---

## Author

Built by **MdMahbubTanmay**  
GitHub: https://github.com/MdMahbubTanmay