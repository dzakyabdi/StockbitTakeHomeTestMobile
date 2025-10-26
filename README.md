Mobile Automation Test Setup

This project contains the setup and implementation for the mobile automation take-home test using Appium, Java, and TestNG/Cucumber.

🧰 Tools & Applications Required
1. Java

Used as the base programming language for developing the automation test scripts.

2. Node.js

Appium’s server is built on Node.js, which provides the environment to run and manage Appium processes.

When you install Appium (npm install -g appium), you’re actually installing a Node.js package. Running the Appium server (appium) starts a Node.js process that listens for WebDriver (JSON Wire Protocol / W3C WebDriver) commands.

Each Appium driver (such as appium-uiautomator2-driver or appium-espresso-driver) is also a Node.js package. Node.js allows Appium to load, manage, and update these drivers dynamically.

Node.js provides an event-driven environment for:

Logging and reporting test actions in real-time

Handling asynchronous device interactions (ADB commands, UI queries)

Managing Appium’s internal operations such as session creation, command routing, and cleanup

3. Android Studio
Setup:

Install Android Studio

Set up the Android SDK

Configure environment variables (ANDROID_HOME, JAVA_HOME)

Create an Android Emulator

Install Node.js and Appium

Install Appium Drivers for Android

Test the setup to ensure all dependencies are correctly configured

4. Appium Server
Setup:

Install Appium and required packages

npm install -g appium


Start the Appium Server

appium


Run the automation tests once the server is running

5. Appium Inspector
Setup:

Download and install Appium Inspector

Open the Capability Builder and set the following values:

{
  "app": "D:\\Automation Blibli\\appium_1\\src\\test\\rscrs\\mda-1.0.13-15.apk",
  "deviceName": "Pixel_3a",
  "platformName": "Android",
  "automationName": "UIAutomator2"
}

📦 Dependencies (pom.xml)

The following dependencies are required for this project:

io.appium

org.testng

io.cucumber

io.cucumber:cucumber-testng

▶️ How to Run the Automation

Clone the repository

git clone <your-repo-url>


Resolve all dependencies (Maven will handle this automatically)

Start the Android Emulator

Install the APK on the emulator

Start the Appium server

appium


Run the automation tests through your IDE or using Maven/TestNG commands

🎥 Automation Run Recording

You can watch a recording of the automation running locally here:
https://drive.google.com/file/d/1GP_nJHNcD5oN1MtJ8O7A7h0MvTfu5gEb/view?usp=sharing 





