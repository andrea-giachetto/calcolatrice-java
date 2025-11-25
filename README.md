# Calcolatrice (Calculator)

A simple calculator application built in Java with a Swing-based graphical user interface.

## Features

- Basic arithmetic operations: addition (+), subtraction (-), multiplication (*), division (/)
- Clean separation between business logic and UI
- Error handling for division by zero
- Clear/Reset functionality
- Intuitive button layout with color-coded operations

## Project Structure

```
calcolatrice/
├── Calcolatrice.java      # Core calculator logic (no GUI dependencies)
├── Operazione.java        # Operation class for arithmetic operations
├── CalcolatriceGUI.java   # Swing GUI implementation
└── README.md              # This file
```

## Architecture

### Calcolatrice.java
Core calculator engine that manages:
- Current result and previous operand
- Operation state machine
- Digit input handling
- Calculation execution

### Operazione.java
Encapsulates arithmetic operations with:
- Support for +, -, *, / operators
- Division by zero protection
- Operation validation

### CalcolatriceGUI.java
Swing-based user interface featuring:
- 400x500 pixel window
- Text field display (right-aligned)
- Grid layout with digit and operation buttons
- Color-coded buttons (operations in orange, equals in green, clear in red)

## Requirements

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE) for execution

## Compilation

Compile all Java files:

```bash
javac Calcolatrice.java Operazione.java CalcolatriceGUI.java
```

## Running the Application

Execute the main class:

```bash
java CalcolatriceGUI
```

## Usage

1. Click digit buttons (0-9) to enter numbers
2. Click an operation button (+, -, *, /)
3. Enter the second number
4. Click the equals button (=) to see the result
5. Click the clear button (C) to reset

## Implementation Details

- **State Management**: Uses flags to track whether a new number is being entered
- **Chain Operations**: Supports continuous calculations (e.g., 5 + 3 + 2)
- **Display Formatting**: Shows integers without decimals, floats with 2 decimal places
- **Error Handling**: Catches and displays errors for invalid operations

## License

Educational project for ITS coursework.
