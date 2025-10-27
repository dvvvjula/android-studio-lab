# PAM_02.2

This branch contains the second exercise from the second laboratory of the **Mobile Applications Programming** course.  
The goal of this exercise was to **reinforce knowledge of Android layouts** and **practice navigating between multiple activities**.

---

## Application Description

The project implements a **calculator application** consisting of two activities:

### MainActivity.java - Basic Calculator
The main screen allows users to perform **basic arithmetic operations**:
- Addition  
- Subtraction  
- Multiplication  
- Division  

It contains two input fields for numbers and buttons for each operation.  
Division by zero is properly handled with an error message displayed on the screen.

A button labeled **“Pokaż rozszerzone funkcje”** navigates the user to the second activity.

![ezgif-169e0a7f9e6c96](https://github.com/user-attachments/assets/784b853f-2d0b-40a4-8f86-3742a7b3d529)

---

### RozszerzoneFunkcjeActivity.java - Advanced Calculator
The second screen provides access to **advanced mathematical operations**, including:
- Exponentiation (power)  
- Square root  
- Factorial  

All operations include proper **exception handling**, such as preventing the calculation of factorials for negative or non-integer values, and avoiding square roots of negative numbers.

Additionally, this screen includes a **“Powrót” button**, which allows the user to return to the main calculator activity.

![ezgif-1f7ea02b6627ed](https://github.com/user-attachments/assets/c9a35c4a-a5c1-4804-86e2-e71d0bbd7646)

---

## Summary
This laboratory exercise focused on:
- Practicing the use of different **layout types** in Android (`LinearLayout`, `ConstraintLayout`).  
- **Passing control between activities** using `Intent`.  
- Implementing **input validation** and simple **mathematical logic** within an Android app.

---
