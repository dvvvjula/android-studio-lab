# **PAM_06**

This branch contains the sixth laboratory exercises for the **Mobile Applications Programming** course.  
The goal of these exercises was to learn how to work with **BroadcastReceivers**, create **custom events**, and monitor **system state changes** in Android.

---

## **1. Custom Broadcast Event**

The application includes a button that triggers a **custom broadcast**.  
After pressing the button:

1. An intent with a custom action (`MY_EVENT`) is sent.  
2. A dynamically registered `BroadcastReceiver` listens for this event.  
3. When received, it updates a **TextView** with a message confirming the event.

This part demonstrates:

- Creating and sending custom broadcasts  
- Using `IntentFilter` and dynamic receiver registration  
- Updating UI elements from a `BroadcastReceiver`  

---

## **2. System State Monitoring**

A second `BroadcastReceiver` is responsible for monitoring selected system components, such as:

- **Airplane mode**  
- **Wi-Fi state**  
- **Mobile data / LTE connectivity**  
- **Ringer mode**  

Changes detected by the receiver are printed directly to **Logcat**.  
Examples of logged messages:

- `Wi-Fi: TAK / NIE`  
- `LTE: TAK / NIE`  
- `Status trybu samolotowego: włączony / wyłączony`  

Additionally, the application uses `ConnectivityManager` with  
**NetworkCallback**, allowing real-time detection of transport type changes  
(e.g., switching from LTE to Wi-Fi).

---

## **3. Battery Status Receiver**

An additional receiver monitors the **battery state**, showing:

- Whether the device is charging  
- Current battery percentage  
- Alerts for low or full battery  

The status is displayed directly in the same **TextView** as custom events.

https://github.com/user-attachments/assets/27238545-6ba6-402f-b6b2-8b68f2069aa6


