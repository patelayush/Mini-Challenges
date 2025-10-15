# Festival Map

Figma - https://www.figma.com/design/JHJzNJwN43ZxpojtmBHtMR/Designing-the-Festival?node-id=8-145&t=HRjrIdaQnNC4sKEe-0

[Demo video](festival_map_demo.webm)


---

## 🚀 Features

* **Interactive Map Layers**: Users can toggle different points of interest on the map.
* **Filter Chips**: A row of Material 3 `FilterChip` components allows users to select which layers are visible.
* **Dynamic UI**: The map updates instantly as filters are selected or deselected, overlaying images on the base map.
* **Stateful Filtering**: The selected state of each filter is remembered and drives the UI changes.
* **Custom Theming**: The app uses a custom font (Parkinsans) and a unique color palette (Lime, Pink, Orange) to create a vibrant, festival-themed look.
* **100% Jetpack Compose**: The entire application is a single screen built using modern, declarative UI principles.

---

## 🛠️ Built With

* **Kotlin**: The primary programming language for modern Android development.
* **Jetpack Compose**: Android's modern UI toolkit for building native interfaces declaratively.
* `mutableStateListOf`: Manages the list of `Filter` objects, allowing Compose to react to changes in their `selected` property.
* **Material 3 (1.3.0)**: Leverages the latest Material Design components, specifically `Scaffold`, `FilterChip`, and `Icon`.
* **Layouts**: Uses `Column`, `Row`, and `Box` to structure the UI effectively. The `Box` layout is crucial for overlaying the filter images on top of the base map.
* **Custom Theming**: A custom theme is defined in the `ui.theme` package to centralize styling, colors, and typography.
* **Android Studio**: The official IDE for Android app development.

---

## ⚙️ How It Works

The core logic is contained within the `FestivalMap` composable function in `MainActivity.kt`.

### Data Model

A simple `Filter` data class holds the information for each map layer, including its name, color, icon, the image resource to display, and a `selected` boolean flag.

### State Management

* A `mutableStateListOf<Filter>` is created and remembered to hold the state for the filters (Stages, Food, WC).
* Using `mutableStateListOf` ensures that when an item inside the list is modified, Compose recomposes any UI that depends on it.
* When a `FilterChip` is clicked, a new copy of the corresponding `Filter` object with the toggled `selected` value is created and updated in the list, triggering a recomposition.

### UI Rendering

* The main layout is a `Column` containing the title, the `Row` of `FilterChips`, a `HorizontalDivider`, and a `Box`.
* The `Box` layout is used for the map itself. The base map `Image` is placed first.
* A series of `if (filterList[index].selected)` checks are used to conditionally display the overlay `Images` (for stages, food, etc.) on top of the base map.

---

## 🎨 Theming and Customization

This project features a distinct visual style thanks to its custom theme defined in the `ui/theme` package.

* **Type.kt**: The custom `ParkinsansFontFamily` is defined by loading the font from the `res/font` directory. This is then applied to `Text` composables throughout the app.
* **Color.kt**: Defines the app's unique color palette, including Lime, Pink, and Orange which are used for the selected state of the `FilterChips`.
* **Theme.kt**: Combines the colors and typography into the `FestivalMapTheme`, which is applied at the root of the application in `MainActivity`.

---

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

* Android Studio (latest stable version recommended)
* An Android emulator or a physical device

### Installation

1.  Clone the repository:
    ```sh
    git clone [https://github.com/your-username/festival-map.git](https://github.com/your-username/festival-map.git)
    ```

2.  Open the project in Android Studio.

3.  Allow Gradle to sync and download the required dependencies (like `androidx.compose.material3:material3:1.3.0`).

4.  Run the app on your selected emulator or physical device.
