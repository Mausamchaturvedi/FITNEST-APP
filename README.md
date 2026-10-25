# FIT-NEST – Fitness & Workout Android App

FIT-NEST is an Android fitness application designed to help users manage workouts, explore diet suggestions, track fitness progress, and set reminders in one place.

## Features

- **Home Dashboard** – Access the app's main sections.
- **Fitness & Workouts** – Browse workout categories and exercises.
- **Diet Section** – View diet suggestions to support fitness goals.
- **Progress Tracking** – Review fitness progress.
- **Reminders** – Set reminders for fitness-related activities.
- **AI Fitness Coach** – Ask fitness-related questions, if AI integration is configured.
- **Health Safety Check** – View a basic BMI-based check. BMI is only a screening measure and does not diagnose disease or predict a heart attack.

> **Note:** Feature availability depends on the activities and integrations included in your current project build.

## Tech Stack

- **Language:** Java
- **UI:** XML
- **IDE:** Android Studio
- **Platform:** Android SDK
- **Notifications and reminders:** Android notification APIs / AlarmManager (where configured)
- **Backend or AI service:** Depends on your project configuration

## Project Structure

Your exact file names may differ. A typical structure can look like this:

```text
FIT-NEST/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/fit_nest/
│           │   ├── MainActivity.java
│           │   ├── FitnessActivity.java
│           │   ├── DietActivity.java
│           │   ├── ProgressActivity.java
│           │   ├── ReminderActivity.java
│           │   ├── ReminderReceiver.java
│           │   ├── HealthGuardActivity.java
│           │   └── AICoachActivity.java
│           ├── res/
│           │   ├── layout/
│           │   ├── drawable/
│           │   ├── menu/
│           │   └── values/
│           └── AndroidManifest.xml
├── build.gradle
└── README.md
```

## Getting Started

### Requirements

- Android Studio
- Android SDK compatible with the project's Gradle configuration
- JDK version required by the project's Gradle setup

### Run the Project

1. Clone or download this repository.
2. Open the project in Android Studio.
3. Allow Gradle to sync and download required dependencies.
4. Connect an Android device with USB debugging enabled, or start an Android emulator.
5. Click **Run** in Android Studio.

## Project Objective

The objective of FIT-NEST is to bring common fitness tools—workout guidance, diet suggestions, progress tracking, and reminders—together in a simple Android app.

## Future Enhancements

- Personalized workout plans based on user goals and experience.
- More flexible diet plans and meal tracking.
- Improved progress charts and history.
- Better reminder scheduling and notification controls.
- Expanded AI coaching with appropriate safety guidance.

## Health Disclaimer

FIT-NEST is for general informational and fitness-support purposes only. It is not a substitute for professional medical advice, diagnosis, or treatment. BMI alone cannot determine a person's overall health or predict a heart attack. For urgent symptoms such as chest pain or difficulty breathing, seek emergency medical help.

## License

No license has been specified yet. If you want others to reuse, modify, or distribute this project, add a suitable open-source license.

---

**FIT-NEST** — Your fitness journey, organized.

