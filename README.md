# Keepr Android App

Modern Android application built with Jetpack Compose.

## Prerequisites

- Android Studio (latest version)
- JDK 17 or higher
- Android SDK (API 26+)

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
