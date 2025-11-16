# PAM_05

This branch contains the fifth exercise from the **Mobile Applications Programming** course.  
The goal of this laboratory assignment was to create a simple **Shopping List** application using **Room Database** and navigation between activities.

---

## Application Description

The application allows the user to manage a list of shopping items.  
The main screen contains:

- an `EditText` field — **Nazwa produktu**
- **three buttons**:
  - **Dodaj produkt** – saves the entered product to the database
  - **Usuń produkt** – removes only the product with the exact entered name
  - **Wyświetl listę** – opens a second activity displaying all saved products

The second activity shows the entire shopping list retrieved from the database and includes one additional button:

- **Powrót** – returns to the previous screen (MainActivity)

---

## How it Works

1. The user enters a product name into the `EditText` field.
2. **Dodaj produkt**
   - Inserts the entered product into the Room database using `insert()`.
3. **Usuń produkt**
   - Removes the product with the matching name using `deleteByName()`.
4. **Wyświetl listę**
   - Opens `ListActivity` using an explicit intent.
   - Loads all products from the Room database.
   - Displays them inside a `TextView`.
5. **Powrót**
   - Closes the second activity and returns to the main screen.


https://github.com/user-attachments/assets/771fbcac-729f-44de-a830-b26d00113846



---

## Features Demonstrated

- Implementation of **Room Database** (Entity, DAO, Database)
- Inserting, deleting, and reading data from a local database
- Executing database operations on a background thread
- Navigation between activities using **explicit intents**
- Displaying dynamic data retrieved from Room in the UI
