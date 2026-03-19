# MediaMaster V2 KMP

**MediaMaster** is cross-platform media discovery and management application built with **Kotlin Multiplatform (KMP)**
and **Jetpack Compose Multiplatform**. It allows users to search, discover, and manage various types of media content
including movies, TV shows, books, and games all from a single unified application.

## Project Overview

This is a **Kotlin Multiplatform** project that targets multiple platforms:

- Android
- iOS
- Web (Kotlin/Wasm)
- Desktop (JVM)

The application provides a consistent user interface across all platforms while maximizing code reuse and minimizing
platform-specific implementations.

## Features

### Currently Implemented

- **User Authentication**
    - Login screen with credentials validation
    - User registration system
    - Secure authentication flow

- **Media Search & Discovery**
    - Multi-type search functionality (Movies, TV Shows, Books, Games)
    - Real-time search results
    - Comprehensive item details view
    - Image display for all media types

- **Supported Media Types**
    - **Movies** - Powered by TMDB API with runtime, release date, and overview information
    - **TV Shows** - Complete TV series information and metadata
    - **Books** - Integrated with Open Library API for book data and cover images
    - **Games** - Game information and details

- **Media Management**
    - Create custom lists for organizing media
    - View detailed information about each media item
    - Browse and explore media collections
    - Responsive UI with Material Design 3

- **Cross-Platform UI**
    - Unified Material Design 3 color scheme (Dark Green theme)
    - Consistent navigation across all platforms
    - Adaptive layouts for different screen sizes

## Project Structure

```
MediaMasterV2kmp/
├── composeApp/                          # Shared Compose Multiplatform application
│   ├── src/
│   │   ├── commonMain/                  # Code shared across all platforms
│   │   │   ├── kotlin/sdev/mediamaster/
│   │   │   │   ├── App.kt               # Main app composable and navigation
│   │   │   │   ├── Platform.kt          # Platform-specific utilities
│   │   │   │   ├── screens/             # UI screens (Login, Register, Search, etc.)
│   │   │   │   ├── components/          # Reusable UI components
│   │   │   │   ├── itemClasses/         # Data models (Movie, Book, Game, TV)
│   │   │   │   └── network/             # API client and network models
│   │   │   └── composeResources/        # Assets and resources
│   │   ├── androidMain/                 # Android-specific implementations
│   │   ├── iosMain/                     # iOS-specific implementations
│   │   ├── desktopMain/                 # Desktop/JVM-specific implementations
│   │   ├── wasmJsMain/                  # Web (Kotlin/Wasm) implementations
│   │   └── commonTest/                  # Shared tests
│   └── build.gradle.kts                 # Gradle build configuration
├── iosApp/                              # Native iOS app entry point (SwiftUI)
├── gradle/                              # Gradle wrapper and configuration
├── build.gradle.kts                     # Root Gradle build file
├── settings.gradle.kts                  # Gradle settings
└── gradle.properties                    # Gradle properties and versions
```

## Technology Stack

### Framework & Libraries

- **Kotlin Multiplatform** - Write once, run everywhere code sharing
- **Compose Multiplatform** - Declarative UI framework for all platforms
- **Jetpack Compose Material 3** - Modern Material Design components
- **Kotlin Coroutines** - Asynchronous programming and concurrency

### Networking & Data

- **Ktor Client** (v2.3.7+) - Modern async HTTP client for API calls
- **Kotlin Serialization** - JSON serialization/deserialization
- **Kamel Image** (v0.9.4) - Image loading and caching library

### External APIs

- **TMDB API** (The Movie Database) - Movie and TV show data
- **Open Library API** - Book information and covers

### Build & Development

- **Gradle** - Build automation with Kotlin DSL
- **Android Gradle Plugin** - Android app building and deployment
- **Kotlin Serialization Plugin** - JSON handling support
- **Compose Hot Reload** - Live reloading during development

## UI Architecture

The application uses a **Screen-based navigation model** with sealed classes:

- **LoginScreen** - User authentication
- **RegisterScreen** - New user registration
- **MainScreen** - Main dashboard and navigation hub
- **SearchScreen** - Global media search interface
- **Detail Screens** - MovieView, TVView, BookView, GameView for detailed item information
- **ListView** - Custom lists management

All screens are composed using reusable components:

- Appbar - Top app bar with branding
- MovieComponent - Movie display card
- TVComponent - TV show display card
- BookComponent - Book display card
- GameComponent - Game display card
- ItemDisplay - Generic item display component
- ListComponent - List management component

## Data Models

The application uses a type-safe data hierarchy:

- **Item** (Interface) - Base interface for all media types
    - **Movie** - Movie data with runtime, release date, and TMDB integration
    - **TV** - Television show information
    - **Book** - Book data with author info and Open Library integration
    - **Game** - Video game information
    - **ItemSearch** - Search result wrapper for API responses

## Getting Started

### Prerequisites

- Android SDK (for Android development)
- Xcode (for iOS development)
- JDK 11 or higher
- Kotlin 1.9+
- Gradle 8.0+ (included via wrapper)

### Building for Different Platforms

#### Android

```bash
./gradlew composeApp:installDebug
```

#### Desktop

```bash
./gradlew composeApp:run
```

#### Web (Kotlin/Wasm)

```bash
./gradlew composeApp:wasmJsBrowserDevelopmentRun
```

#### iOS

Open `iosApp/iosApp.xcodeproj` in Xcode and build from there.

## Dependencies Overview

Key dependencies are managed in `gradle/libs.versions.toml`:

- **Compose Multiplatform** - Latest stable version for UI
- **Ktor** (2.3.7+) - HTTP client with content negotiation and timeout configuration
- **Kotlin Serialization** - JSON handling with lenient parsing
- **Kamel** (0.9.4) - Image loading with caching
- **AndroidX Lifecycle** - ViewModel and state management
- **Kotlin Coroutines** - Asynchronous programming support

## Configuration

The application includes:

- **Custom Material 3 Dark Color Scheme** - Dark Green primary color (#145A32) with white accents
- **Ktor HTTP Client Configuration**
    - 30-second request timeout
    - Lenient JSON parsing for API robustness
    - Content negotiation for automatic serialization
- **Platform-Specific HTTP Clients**
    - OkHttp for Android
    - CIO for Desktop
- **Build Optimization**
    - Gradle Configuration Cache enabled
    - Gradle Build Cache enabled
    - Parallel compilation support

## Platform Support

| Platform | Status | Details                                                      |
|----------|--------|--------------------------------------------------------------|
| Android  | Active | Full support with Android-specific optimizations (minSdk 24) |
| iOS      | Active | Framework-based integration with SwiftUI (iOS 13+)           |
| Desktop  | Active | Cross-platform JVM implementation with CIO HTTP client       |
| Web      | Active | Kotlin/Wasm browser deployment with webpack bundling         |

## Development Workflow

The project uses:

- **Gradle Configuration Cache** - Faster builds by caching configuration
- **Gradle Build Cache** - Incremental compilation and artifact reuse
- **Compose Hot Reload Support** - Rapid development iteration without recompilation
- **Modern Kotlin Compiler** - Latest Kotlin features with Material 3 support
- **JVM Target 11** - Android and Desktop compatibility

## Web Deployment

The web application is built using Kotlin/Wasm and can be deployed to any static hosting service. The build output
includes:

- Optimized JavaScript bundle (composeApp.js)
- HTML entry point
- Asset files for serving

## Learn More

For more information about the technologies used:

- [Kotlin Multiplatform Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform GitHub](https://github.com/JetBrains/compose-multiplatform/)
- [Kotlin/Wasm Documentation](https://kotl.in/wasm/)
- [Ktor Client Documentation](https://ktor.io/docs/client.html)
- [Material Design 3](https://m3.material.io/)

## Project Statistics

- **Language**: Kotlin 100%
- **UI Framework**: Compose Multiplatform
- **Target Platforms**: 4 (Android, iOS, Desktop, Web)
- **Architecture**: MVVM-inspired with Sealed Classes for navigation
- **API Integration**: Multiple (TMDB, Open Library)

## Contributing

This is an ongoing project under active development. Features and improvements are regularly being added to enhance the
media discovery experience across all platforms.

### Recent Work

- Multi-platform UI implementation
- Authentication system
- Media search functionality
- Multi-type media support
- API integration (TMDB, Open Library)

### Future Enhancements

- User preferences and recommendations
- Watchlist and rating system
- Offline caching
- Social features
- Advanced filtering and sorting
