# PAM_03.2

This branch contains the second exercise from the third laboratory of the **Mobile Applications Programming** course.  
The goal of this exercise was to learn about **Intents** in Android. The app demonstrates different types of intents and interactions between activities and other apps.

---

## Application Description

The user can **enter a location** in an `EditText` field. Clicking the **"Navigate"** button opens **Google Maps** in navigation mode to the entered location.

---

## How it works

1. The app retrieves the text entered by the user.  
2. Creates a URI in the format:

    ```
    google.navigation:q=<encoded_location>
    ```

3. Launches an **implicit intent** with `Intent.ACTION_VIEW` to open Google Maps.  

- **Result:** Google Maps opens directly in **navigation mode** with directions to the entered location.  
- This demonstrates using **implicit intents with URIs** and getting user input from `EditText`.

![ezgif-1e74f1901ed36d](https://github.com/user-attachments/assets/c5b93fe4-80a4-4cdc-a835-0b06cfd0176a)
