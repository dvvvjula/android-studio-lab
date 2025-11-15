# PAM_04.1

This branch contains the first exercise from the fourth laboratory of the **Mobile Applications Programming** course.  
The goal of this exercise was to learn about **creating and handling menus** in Android applications, using **Logcat** for debugging, and executing functions from menu options.

---

## Application Description

The app includes a **menu accessible from the toolbar**.  
The user can select different menu options, which trigger corresponding **functions** and log messages in **Logcat** for debugging purposes.  

- Demonstrates how to create **options menus** and handle user selections.  
- Shows how to **call functions** in response to menu item clicks.  
- Logs actions and messages in Logcat to help track the app's behavior.

---

## How it works

1. The app defines a **menu resource** (`menu.xml`) with multiple items.  
2. The menu is **inflated** in the activity using `onCreateOptionsMenu`.  
3. User selects a menu option:  
   - The app handles the selection in `onOptionsItemSelected`.  
   - Each menu item triggers a **specific function**.  
   - Actions and results are printed to **Logcat** for debugging.  

- **Result:** The user can interact with the menu to perform actions, while developers can observe logs in Logcat.  
- This demonstrates how to combine **menus, function calls, and Logcat logging** in an Android app.

<img width="1190" height="1078" alt="image" src="https://github.com/user-attachments/assets/7d688eb6-28f5-497a-a789-52154ee45e00" />
