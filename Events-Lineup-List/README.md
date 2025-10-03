# Events Lineup List

A modern and sleek Android application built with Jetpack Compose that displays a lineup for an event. The app features a clean, single-screen UI with custom typography and a clear information hierarchy, making it easy for users to see who is performing, when, and on what stage.

Figma - https://www.figma.com/design/JHJzNJwN43ZxpojtmBHtMR/Designing-the-Festival?node-id=0-1

Video - [demo](expandable_list_demo.mp4)

## 🚀 Features

*   **Dynamic Event List**: Displays a list of event lineup items, each with artist, time, and stage information.
*   **Custom Typography**: Utilizes a custom font (`Parkinsans`) to create a unique and branded visual identity for the app, as defined in `Type.kt`.
*   **Modern UI with Jetpack Compose**: The entire UI is built declaratively with Jetpack Compose, showcasing modern Android development practices.
*   **Efficient List Rendering**: Uses `LazyColumn` for efficient, high-performance display of the scrollable lineup.
*   **Clean, Structured Layout**: Employs `Column` and `Row` layouts to organize information clearly and intuitively for each lineup item.
*   **Themed Design**: Implements a custom Material 3 theme with a defined color palette and typography, ensuring a consistent look and feel.

## 🛠️ Built With

*   **[Kotlin](https://kotlinlang.org/)**: The primary programming language for modern Android development.
*   **[Jetpack Compose](https://developer.android.com/jetpack/compose)**: Android's modern UI toolkit for building native interfaces declaratively.
    *   **Material 3 (`1.3.0`)**: Leverages the latest Material Design components for a modern look (`Scaffold`, `Text`, etc.).
    *   **`LazyColumn`**: Efficiently displays the scrollable list of lineup items from the `androidx.compose.foundation` library.
    *   **Custom `FontFamily`**: Integrates the custom `Parkinsans` font from the `res/font` directory, configured in `Type.kt`.
    *   **Theming**: A custom theme is defined in the `ui.theme` package to centralize styling.
*   **[Android Studio](https://developer.android.com/studio)**: The official IDE for Android app development.

## ⚙️ Project Structure & How It Works

The application follows a standard Jetpack Compose structure.

1.  **`MainActivity.kt`**: This is the entry point of the app. It sets up the main `Scaffold` and calls the primary composable, `LineupScreen`.
2.  **`LineupScreen.kt`** *(Assumed)*: This file contains the core UI logic.
    *   It uses a `LazyColumn` to efficiently render the list of `LineupItem`s.
    *   Each item in the list is a custom composable that arranges the artist's name, time, and stage using `Row` and `Column` layouts.
3.  **`Data.kt`** *(Assumed)*: A file that likely contains the data model (`LineupItem` data class) and the sample data used to populate the list.
4.  **`ui/theme` package**:
    *   **`Type.kt`**: This is where the custom `ParkinsansFontFamily` is defined by loading the font from `R.font.parkinsans`. This `FontFamily` is then applied to the app's `Typography`.
    *   **`Color.kt`**: Defines the app's color palette.
    *   **`Theme.kt`**: Combines the colors and typography to create the `EventslineuplistTheme` that wraps the entire application UI.

## 🎨 Theming and Customization

A key feature of this project is its custom branding through theming. The `Parkinsans` font is loaded in `Type.kt` and integrated into the Material `Typography` object. This allows any `Text` composable using a style from `MaterialTheme.typography` (e.g., `style = MaterialTheme.typography.titleLarge`) to automatically render with the custom font, making theme management simple and powerful.

To change the font or add different weights, you can:
1.  Add new font files (e.g., `parkinsans_bold.ttf`) to the `res/font` directory.
2.  Update the `ParkinsansFontFamily` in `Type.kt` with the new `Font` resource.

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

*   Android Studio (latest stable version recommended)
*   An Android emulator or a physical device

### Installation

1.  Clone the repository:# Events Lineup List
2.  Open the project in Android Studio.
3.  Allow Gradle to sync and download the required dependencies.
4.  Run the app on your selected emulator or physical device.
