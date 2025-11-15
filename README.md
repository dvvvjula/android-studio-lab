# PAM_04.2

This branch contains the homework assignment from the fourth laboratory of the **Mobile Applications Programming** course.  
The goal of this exercise was to learn how **menus work in Android Studio** and how to handle **submenus and menu options** in an application.

---

## Application Description

The app features a **menu accessible from the toolbar** with **four main options**:

1. **Wycisz telefon** – simulates phone muting functionality.  
2. **Wyswietl informacje o autorze** – displays information entered by the user in a `TextView`.  
3. **Wylacz aplikacje** – closes the app.  
4. **Uruchom** – has **two sub-options**:  
   - **Google Maps** – opens Google Maps navigation.  
   - **Google Browser** – opens the Google homepage in a browser.


  <img width="398" height="297" alt="image" src="https://github.com/user-attachments/assets/51aea44a-f3f8-4b38-af6d-5e83fabab1b8" />
  <img width="409" height="226" alt="image" src="https://github.com/user-attachments/assets/4d17e5f6-1607-4bdf-8189-1b20736e78ec" />


The app demonstrates how to create **menus and submenus**, handle **user selections**, and execute corresponding **functions**.

---

## How it works

1. The menu is defined in a **menu resource file** (`menu.xml`) including sub-items for the “Run” option.  
2. The menu is **inflated** in the activity using `onCreateOptionsMenu`.  
3. When the user selects a menu option:  
   - The selection is handled in `onOptionsItemSelected`.  
   - Each menu item triggers a specific **function**:  
     - Mute phone  
     - Show author information in a `TextView`  
     - Exit the app  
     - Open Google Maps or browser  
   - Actions can be logged to **Logcat** for debugging.

https://github.com/user-attachments/assets/610ca3cc-5c32-4b26-88ee-66367c7c82b3



- **Result:** Users can interact with the menu, including submenus, while observing **function execution** and app behavior.  
- This demonstrates practical use of **menus, submenus, and function handling** in Android applications.
