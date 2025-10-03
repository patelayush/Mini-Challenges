# Ticket Builder

A simple, modern ticket purchasing UI built entirely with Jetpack Compose. This single-screen application demonstrates fundamental concepts of building a dynamic and interactive UI in Android using a declarative approach.

Figma - https://www.figma.com/design/JHJzNJwN43ZxpojtmBHtMR/Designing-the-Festival?node-id=5-500&t=MXIhv7kbR2UvncEg-0

---

## 🚀 Features

* **Ticket Type Selection**: Users can choose from a dynamic list of ticket types (e.g., Adult, Child, Senior).
* **Quantity Control**: A user-friendly stepper allows users to increase or decrease the ticket quantity. The minus button is disabled when the quantity is 1 to prevent invalid states.
* **Real-time Total Calculation**: The total price updates instantly as the user changes the ticket type or quantity.
* **Conditional UI**: The "Purchase" button is disabled until a ticket type is selected, guiding the user through the process.
* **Custom Theming**: The app features a custom font (Parkinsans) and a specific color palette (Lime, Surface, etc.) for a unique, branded look and feel.
* **Modern UI with Jetpack Compose**: The entire UI is built using Jetpack Compose, showcasing the use of `State`, layouts (`Column`, `Row`, `Box`), and Material 3 components.

---

## 🛠️ Built With

* **Kotlin**: The primary programming language for modern Android development.
* **Jetpack Compose**: Android's modern, declarative UI toolkit for building native interfaces.
* **State Management**: Utilizes `mutableStateOf` and `remember` for managing UI state reactively.
* **Material 3**: Implements Material Design components like `Scaffold`, `Button`, `RadioButton`, and `Icon`.
* **Layouts**: Uses `Column`, `Row`, and `Box` for structuring the UI.
* **Android Studio**: The official IDE for Android app development.

---

## ⚙️ How It Works

The core logic resides within the `TicketBuilderScreen.kt` composable function.

### State Management
* `currentlySelected`: An integer `State` that holds the index of the selected ticket type from the `ticketTypes` list. It defaults to `-1` (no selection).
* `quantity`: An integer `State` that tracks the number of tickets, defaulting to `1`.

### UI Structure
* The main layout is a `Column` that organizes the screen into a header, a list of ticket types, a quantity selector, and a summary section.
* `ticketTypes.forEachIndexed` dynamically generates a `Row` for each available ticket, containing a `RadioButton`, the ticket name, and its price.
* The total price is calculated reactively: `quantity * ticketTypes[currentlySelected].price`. A check ensures the price is `0` if no ticket type is selected.

### User Interaction
* `RadioButton`'s `onClick` lambda updates the `currentlySelected` state.
* Icons for plus and minus are wrapped in a `Box` with a `clickable` modifier to update the `quantity` state.
* The "Purchase" `Button` and the minus quantity `Box` use conditional logic to enable or disable themselves and change their background color based on the current state, providing clear visual feedback to the user.

---

## 🎨 Theming and Styling

The project demonstrates custom theming within the `ui/theme` package:

* **`Color.kt`**: Defines the app's color palette (e.g., `Lime`, `Surface`, `TextPrimary`).
* **`Type.kt`**: Configures the custom font family (`ParkinsansFontFamily`).
* **`Theme.kt`**: Brings the color scheme and typography together.

This setup makes it easy to maintain a consistent look and feel across the entire application.

---

## 🚀 Getting Started

To run this project:

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
    ```
2.  **Open in Android Studio:**
    Open the cloned directory in Android Studio.
3.  **Run the app:**
    Build and run the project on an emulator or a physical device.
