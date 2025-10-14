# HabitsAppCompose

# Android Project Documentation

## 📐 Architecture Pattern

This project follows the **MVVM (Model-View-ViewModel)** pattern with **Clean Architecture** principles to ensure separation of concerns, maintainability, and scalability.

---

<img width="2000" height="1600" alt="Image" src="https://github.com/user-attachments/assets/671b3e28-8867-48f7-86c4-ebfa5e729be6" />

## 📁 Project Structure & Main Libraries

The project has been structured to support modern Android development using the following main libraries and tools:

- **Navigation Component** – for in-app navigation
- **Dagger Hilt** – for dependency injection
- **Lifecycle Components** – for observing lifecycle-aware data
- **Material Design** – for modern UI design
- **Retrofit** – for HTTP networking
- **Room** – for local database persistence
- **Jetpack Compose** – for declarative UI development
- **AlarmManager** – to schedule and trigger operations at specific times
- **WorkManager** – for background and deferred tasks that need guaranteed execution
- **Firebase** – for backend services (e.g., Authentication, Realtime Database, Crashlytics, etc.)

---

## 🧩 Dependency Injection Modules

The project uses Hilt for DI, and is divided into the following modules:

- `DatabaseModule` – Provides Room database instances
- `NetworkModule` – Provides Retrofit, OkHttp, and API services
- `RepositoryModule` – Provides repositories used across the application
- `AuxModules` – Other supporting dependencies such as AlarmManager, WorkManager handlers, and Firebase services

---

## 🎨 Presentation Layer

The Presentation Layer is implemented using **Jetpack Compose** and includes:

- **Navigation Composables** – Handles screen-to-screen navigation
- **ViewModels** – For managing UI state and interacting with Use Cases
- **UI Screen Layouts** – Built using Compose to display content
- **Aux Classes** – Includes helpers, formatters, and other utility classes that assist the UI

---

## 🧪 Tech Stack

- **Kotlin** – Programming Language
- **Architecture Components** – Lifecycle, ViewModel, LiveData
- **MVVM Design Pattern** – Separation of concerns
- **Jetpack Compose** – Modern declarative UI toolkit
- **Dagger Hilt** – Dependency injection framework
- **Navigation Component** – Jetpack library for handling navigation
- **WorkManager** – Robust background task scheduler
- **AlarmManager** – Schedule time-based operations
- **Firebase** – Cloud-based backend services

---

## 🔥 Additional Tools

- **Firebase Authentication** – For secure login/signup
- **Firebase Realtime Database or Firestore** – For cloud data storage

---

## 📌 Notes

This setup is designed for scalability, modularity, and maintainability. It is a strong foundation for building modern, production-ready Android applications.
