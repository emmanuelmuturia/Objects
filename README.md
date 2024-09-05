## Overview

Objects is an Android application that was built to test the feasibility of a JSON file that is to be added in the next iteration of the Regreening app to map Countries with their Counties and SubCounties. It was built for internal testing purposes and thus has no commercial use...

## Table of Contents

1. [BackGround](#Background)
2. [Requirements](#Requirements)
3. [Project Structure](#Structure)
4. [Procedure](#Procedure)
5. [Tests](#Tests)
6. [Demo](#Demo)
7. [Credits](#Credits)

## Background

Objects was developed over time to test if the proposed JSON file was correctly formatted and could be called from a REST API among other remote sources...

## Requirements

- These are the requirements for setting up the project:

### 1. Laptop
- The project requires a laptop with the minimum/recommended specifications set by Google for running Android Studio...

### 2. Android Studio
- This is the IDE used to run the project...
- Depending on the time of installation, the IDE may prompt you to update the project's Android Gradle Plugin (AGP) version...

### 3. Emulator/Physical Device (Android/iOS)
- To run the app, an Emulator provided by Android Studio or a physical device (USB/Wireless Debugging) is required...

## Project Structure

- Objects has one module (:app) that is divided into the following packages:

### i) commons

- This package contains the Screen States of the app based on the Network Result...

### ii) feature

- This package mocks the conventional :feature module in a modularised project and is divided into: ui (It contains the UI Elements such as Fragments and the ViewModel), data (It abstracts the UI Layer from the Data Sources), and source (It contains both the Local and Remote Data Sources...)...

### iii) main

- This package contains the Application Class (Dependency Injection) and MainActivity (Entry Point of The App)...

## Procedure

- To set up the project, please follow this procedure:

1. ### The Cloning
- To clone the project from GitHub, open Android Studio and choose "Clone from Version Control"...
- When presented with the Dialog, copy and paste the following URL in the box requesting for the repository's URL: https://github.com/emmanuelmuturia/Snapbite

### 2. The Setup
- Once the project is open in Android Studio, upgrade it to the latest AGP version if prompted and follow the steps presented using the AGP Assistant...

### 3. The Launch
- If you do not have an Emulator and would like to use it for running the app, then simply go to "Device Manager" on the right-hand panel of Android Studio and click the "+" icon to add a new Virtual Device. Choose your preferred device and configurations, including the System Image if you have none installed...
- If you would like to use a Physical Device instead, here are the two options you should use to connect it to Android Studio:

#### 1. USB Debugging
- Ensure that your device has "USB Debugging" enabled by first enabling Developer Options (Check your device's website for the steps you need to take for this) and navigating to the "Developer Options" section and toggling "USB Debugging" on...
- Connect your device to the laptop using a USB cable and select "Transfer Files"...
- That's it!

### 2. Wireless Debugging (Android 11+)
- To use Wireless Debugging instead, follow the above procedure but enable "Wireless Debugging" instead of "USB Debugging"...
- Once that is done, navigate to "Device Manager" and click the WiFi icon...
- You will be presented with a QR Code. On the "Developer Options" under "Wireless Debugging", choose "Pair using QR Code" and scan the QR code that has been presented to you in Android Studio. Alternatively, select the "Pair using Pairing Code" and do the same on your device still under "Wireless Debugging". Wait for Android Studio to scan and discover your device...
- That's it!

## Tests

| Test | Description |
|------|-------------|
| <img width="1018" alt="The ViewModel Test" src="https://github.com/user-attachments/assets/f46b7a32-a94a-40a7-944f-d35011e507a9"> | This is the ViewModel Test... |
| <img width="855" alt="The DAO Test" src="https://github.com/user-attachments/assets/83c43735-c048-49c8-a2bc-216c53c7d019"> | This is the DAO Test... |
| <img width="855" alt="The UI Tests" src="https://github.com/user-attachments/assets/4aa7e70e-f9e0-4fe7-9bf0-6b0d1d25d7a6"> | These are the UI Tests... |

## Demo

[The Demo.webm](https://github.com/user-attachments/assets/6d8e767d-a076-4ab5-92a8-be61794771c7)

## Credits

- This project has been developed and supported by the following Tools, Technologies, and Libraries:

### 1. Kotlin

- For obvious reasons...

### 2. Kotlin Serialisation Plugin

- This tool was used to serialise and deserialise the data when mocking the REST API calls...

### 3. Koin

- Koin was used for Dependency Injection due to its simplicity and seamless integration with Kotlin...

### 4. Room

- Room was used to store and handle data locally on the Android device using SQLite...

### 5. KSP

- The Kotlin Symbol Processor (KSP) plugin was used to handle the annotations used for example in the Room Entities with Performance as the priority...

### 6. Leak Canary

- Leak Canary was used to detect and report Memory Leaks in the Android application...

### 7. Retrofit and OkHttp

- Retrofit and OkHTTP were used to make and mock the REST API calls respectively...

### 8. Safe Args

- Safe Args was used to generate Classes which allowed for type-safe navigation in the Views context (pun intended)...

### 9. JUnit, MockK, Kotlin Coroutines Test, and Espresso

- These are the libraries that were used for Testing...
- JUnit was used to run the Tests...
- MockK was used to mock the dependencies used for Testing...
- Kotlin Coroutines Test was used to test the dependencies and asynchronous functionalities that relied on Kotlin Coroutines...
- Espresso was used to conduct the UI Tests...
