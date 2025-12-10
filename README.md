# Keepr Android App

Modern Android application built with Jetpack Compose.

## Prerequisites

- Android Studio (latest version)
- JDK 17 or higher
- Android SDK (API 26+)

## First-Time Setup Guide

### Step 1: Install Android Studio

1. **Download Android Studio**
   - Visit [https://developer.android.com/studio](https://developer.android.com/studio)
   - Download the latest version for your operating system (macOS, Windows, or Linux)

2. **Install Android Studio**
   - **macOS**: Open the `.dmg` file and drag Android Studio to Applications
   - **Windows**: Run the `.exe` installer and follow the setup wizard
   - **Linux**: Extract the `.tar.gz` file and run `bin/studio.sh`

3. **Launch Android Studio**
   - On first launch, the setup wizard will guide you through:
     - Installing Android SDK components
     - Setting up an Android Virtual Device (AVD)
     - Downloading additional SDK components

### Step 2: Install JDK (Java Development Kit)

Android Studio includes a bundled JDK, but if you need to install it separately:

**macOS (using Homebrew):**
```bash
brew install openjdk@17
```

**Windows/Linux:**
- Download JDK 17 from [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or [Adoptium](https://adoptium.net/)
- Follow the installation instructions for your OS

**Verify JDK Installation:**
```bash
java -version
# Should show: openjdk version "17.x.x" or similar
```

### Step 3: Configure Android SDK

1. **Open SDK Manager in Android Studio**
   - Go to `Tools` → `SDK Manager` (or `Android Studio` → `Preferences` → `Appearance & Behavior` → `System Settings` → `Android SDK` on macOS)

2. **Install Required SDK Components**
   - **SDK Platforms Tab**: Check and install:
     - Android 14.0 (API 34) - Required (targetSdk)
     - Android 8.0 (API 26) - Minimum required (minSdk)
   - **SDK Tools Tab**: Ensure these are installed:
     - Android SDK Build-Tools
     - Android SDK Command-line Tools
     - Android SDK Platform-Tools
     - Android Emulator
     - Intel x86 Emulator Accelerator (HAXM installer) - for better emulator performance

3. **Note SDK Location**
   - Default locations:
     - **macOS**: `~/Library/Android/sdk`
     - **Windows**: `C:\Users\<YourUsername>\AppData\Local\Android\Sdk`
     - **Linux**: `~/Android/Sdk`

### Step 4: Set Up Environment Variables (Optional but Recommended)

Setting environment variables allows you to use Android SDK tools from the command line.

**macOS/Linux:**

1. Open your shell profile file:
   ```bash
   # For zsh (default on macOS)
   nano ~/.zshrc
   
   # For bash
   nano ~/.bashrc
   ```

2. Add these lines (replace path with your actual SDK location):
   ```bash
   export ANDROID_HOME=$HOME/Library/Android/sdk
   export PATH=$PATH:$ANDROID_HOME/emulator
   export PATH=$PATH:$ANDROID_HOME/platform-tools
   export PATH=$PATH:$ANDROID_HOME/tools
   export PATH=$PATH:$ANDROID_HOME/tools/bin
   ```

3. Reload your shell:
   ```bash
   source ~/.zshrc  # or source ~/.bashrc
   ```

**Windows:**

1. Open System Properties → Advanced → Environment Variables
2. Create a new System Variable:
   - Variable name: `ANDROID_HOME`
   - Variable value: `C:\Users\<YourUsername>\AppData\Local\Android\Sdk`
3. Edit the `Path` variable and add:
   - `%ANDROID_HOME%\platform-tools`
   - `%ANDROID_HOME%\tools`
   - `%ANDROID_HOME%\emulator`

**Verify Environment Variables:**
```bash
echo $ANDROID_HOME  # macOS/Linux
echo %ANDROID_HOME% # Windows CMD
adb version          # Should show Android Debug Bridge version
```

### Step 5: Set Up Android Virtual Device (AVD)

1. **Open AVD Manager**
   - In Android Studio: `Tools` → `Device Manager`
   - Or click the device icon in the toolbar

2. **Create a Virtual Device**
   - Click `Create Device`
   - Choose a device definition (e.g., Pixel 5)
   - Select a system image:
     - Recommended: **API 34** (Android 14) with Google Play services
     - Download if not already installed
   - Click `Finish`

3. **Start the Emulator**
   - Click the play button next to your AVD
   - Wait for the emulator to boot (first time may take a few minutes)

### Step 6: Open the Keepr Project

1. **Clone or Open the Repository**
   ```bash
   git clone https://github.com/AmalGupta/Keepr.git
   cd Keepr/android
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select `Open` or `File` → `Open`
   - Navigate to the `android` folder and select it
   - Click `OK`

3. **Wait for Gradle Sync**
   - Android Studio will automatically sync Gradle dependencies
   - This may take 5-10 minutes on first open
   - Watch the progress bar at the bottom of Android Studio

4. **Resolve Any Issues**
   - If prompted, accept the Gradle wrapper
   - Install any missing SDK components if prompted
   - Wait for all dependencies to download

### Step 7: Verify Setup

1. **Check Project Structure**
   - Ensure the project loads without errors
   - Check that all dependencies are resolved (no red underlines)

2. **Test Build**
   ```bash
   ./gradlew assembleDebug
   ```
   - This should complete successfully

3. **Run the App**
   - Click the green `Run` button (▶️) in Android Studio
   - Or press `Shift + F10` (Windows/Linux) or `Ctrl + R` (macOS)
   - Select your emulator or connected device
   - The app should build and launch

### Troubleshooting Common Issues

**Issue: "SDK location not found"**
- Solution: Set `ANDROID_HOME` environment variable (see Step 4)
- Or set it in `local.properties` file in the project root:
  ```properties
  sdk.dir=/path/to/your/android/sdk
  ```

**Issue: "Gradle sync failed"**
- Solution: 
  - Check internet connection
  - Invalidate caches: `File` → `Invalidate Caches` → `Invalidate and Restart`
  - Delete `.gradle` folder in project root and sync again

**Issue: "JDK not found"**
- Solution:
  - In Android Studio: `File` → `Project Structure` → `SDK Location`
  - Set JDK location to the bundled JDK or your installed JDK path

**Issue: "Emulator won't start"**
- Solution:
  - Enable virtualization in BIOS (for Intel HAXM)
  - For Apple Silicon Macs, ensure you're using ARM64 system images
  - Check that you have enough disk space (emulators need ~2GB)

**Issue: "Build failed: Out of memory"**
- Solution:
  - Increase Gradle memory in `gradle.properties`:
    ```properties
    org.gradle.jvmargs=-Xmx2048m -XX:MaxMetaspaceSize=512m
    ```

### Additional Resources

- [Android Developer Documentation](https://developer.android.com/docs)
- [Jetpack Compose Tutorial](https://developer.android.com/jetpack/compose/tutorial)
- [Android Studio User Guide](https://developer.android.com/studio/intro)

## Tech Stack

- **UI**: Jetpack Compose
- **Architecture**: MVVM
- **DI**: Hilt
- **Networking**: Retrofit + OkHttp
- **Local DB**: Room
- **Navigation**: Compose Navigation

## Project Structure

```
app/src/main/java/com/keepr/app/
├── data/
│   └── remote/          # API services
├── di/                  # Dependency injection modules
├── ui/
│   ├── navigation/      # Navigation setup
│   ├── screens/         # UI screens
│   └── theme/           # Theme & styling
├── KeeprApplication.kt
└── MainActivity.kt
```

## Running the App

1. Open the `android` folder in Android Studio
2. Wait for Gradle sync to complete
3. Run the app on an emulator or physical device

## Building

```bash
./gradlew assembleDebug
```

## Connecting to Backend

The app is configured to connect to the backend at:
- **Emulator**: `http://10.0.2.2:8080/api/`
- **Physical device**: Update `API_BASE_URL` in `app/build.gradle.kts`

Make sure the backend is running before testing API calls.
