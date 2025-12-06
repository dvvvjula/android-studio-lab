# PAM_07

This branch contains the seventh laboratory exercises for the **Mobile Applications Programming** course. The goal of these exercises was to get familiar with **advanced mobile device features** and handling permissions in Android.

The work involved creating an application that:  

1. **Sends SMS messages**  
   - The user can click a button to send a predefined SMS.  
   - The app requests the **SEND_SMS** permission at runtime if it is not already granted.  
   - If permission is denied, a dialog guides the user to the app settings.  

2. **Takes photos using the device camera**  
   - Clicking a button opens the built-in camera app.  
   - After taking a photo, the image is displayed in an **ImageView** in a separate activity.  
   - No runtime permissions are needed because the system camera handles them.  

3. **Plays audio from the application resources**  
   - A dedicated activity plays an **mp3 file** stored in `res/raw`.  
   - No runtime permissions are required since the file is bundled with the app.  

4. **Retrieves GPS coordinates**  
   - A dedicated activity shows the **latitude, longitude, and provider**.  
   - The app requests **ACCESS_FINE_LOCATION** permission at runtime.  
   - GPS location updates every second and displays real-time values on the screen.  

https://github.com/user-attachments/assets/8c653ecd-32fb-4743-99c2-5474a518f5cf

The application uses multiple activities and demonstrates handling **runtime permissions**, **Intents**, and **interaction with device hardware** (SMS, camera, GPS, audio).  

This lab exercise focused on combining several Android features, handling permissions gracefully, and creating a user-friendly interface for multiple hardware functionalities.
