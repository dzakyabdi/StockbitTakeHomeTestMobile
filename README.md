Tools/Application needed:
1. Java
   as the base language
   
3. Node JS
  \nAppium’s server is written in JavaScript and runs on Node.js. When you install Appium (npm install -g appium), you’re actually installing a Node.js package. Running the Appium server (appium) starts a Node.js process that listens for WebDriver (JSON Wire Protocol / W3C WebDriver) commands. Each Appium driver (like appium-uiautomator2-driver or appium-espresso-driver) is a Node.js package. Node.js allows Appium to load, manage, and update these drivers dynamically.

Node.js provides an event-driven environment for:
- Logging and reporting test actions in real-time
- Handling asynchronous device interactions (commands to ADB, UI queries)
- Managing Appium’s internal operations such as session creation, command routing, and cleanup.
   
5. Android Studio
\nSetup:
- Install Android Studio
- Set Up Android SDK
- Set Environment Variables
- Create an Android Emulator
- Install Node.js and Appium
- Install Appium Drivers for Android
- Test the Setup

6. Appium Server
\nSetup:
- Install Appium and Required Packages
- Start Appium Server
- Run Automation

7. Appium Inspector
\nSetup:
- Download and Install Appium Inspector
- Input Capability Builder
    - app: pathLocation (ex: "D:\Automation Blibli\appium_1\src\test\rscrs\mda-1.0.13-15.apk")
    - deviceName: device name in android emulator (ex: Pixel_3a)
    - platformName: Android
    - automationName: UIAutomator2

Depedencies (pom.xml) needed:
1. io.appium
2. org.testng
3. io.cucumber
4. io.cucumber(cucumber-testng)

How to run automation
1. Clone my repo, then resolve all dependencies
2. Open Android Emulator, run android device
3. Install the apk to the emulator
4. Open terminal, then start the appium server
5. Run automation

Automation Run:
https://drive.google.com/file/d/1GP_nJHNcD5oN1MtJ8O7A7h0MvTfu5gEb/view?usp=sharing 




