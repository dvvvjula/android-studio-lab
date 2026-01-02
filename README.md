# PAM_08

This branch contains the eighth exercise from the **Mobile Applications Programming** course.  
The goal of this laboratory assignment was to create a simple Android application using a **background Service** started and stopped from the user interface.

---

## Application Description

The application consists of a single activity with two buttons that control a background service acting as a **timer (minutnik)**.

The main screen contains:

- **two buttons**:
  - **Start** - starts the background service
  - **Stop** - stops the background service

The background service counts down time from a predefined value (e.g. **60 seconds**) and logs the remaining time to the console (Logcat) every second.

<img width="249" height="556" alt="image" src="https://github.com/user-attachments/assets/09184aca-de9b-4133-ba7a-803097dda3de" />

---

## How it Works

1. The user presses the **Start** button.
   - `startService()` is called.
   - The `TimerService` is started.
   - The countdown begins from 60 seconds.
   - The remaining time is logged every second using `Log.d()`.

2. The service runs in the background.
   - Time is decreased once per second using a `Handler`.
   - Each second is printed to the Logcat console.

3. The user presses the **Stop** button.
   - `stopService()` is called.
   - The service is destroyed.
   - The timer is reset.
   - A message **"Minutnik wyzerowany"** is displayed in Logcat.

4. If the countdown reaches zero:
   - The service stops automatically.
   - A message indicating the end of the countdown is logged.

---

## Example Logcat Output

<img width="1013" height="370" alt="image" src="https://github.com/user-attachments/assets/6f9f0242-7d60-4076-8658-1305fe5fde9b" />

---

## Features Demonstrated

- Creating and registering an Android **Service**
- Starting and stopping a service using `startService()` and `stopService()`
- Using `onStartCommand()` and `onDestroy()` lifecycle methods
- Running background tasks with a **Handler**
- Logging data to the console (Logcat)
- Communication between Activity and Service using **Intents**

