import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
import math
import FileManager  
# Підключення власного модулю FileManager

class ExpressionCalculatorGUI:
    def __init__(self, root):
        self.root = root
        root.title("Calculator")

        # Створення віджетів та розміщення їх на головному вікні
        self.x_label = ttk.Label(root, text="Enter the value of x:")
        self.x_label.grid(row=0, column=0, padx=5, pady=5)

        self.x_entry = ttk.Entry(root)
        self.x_entry.grid(row=0, column=1, padx=5, pady=5)

        self.file_name_label = ttk.Label(root, text="Enter the file name:")
        self.file_name_label.grid(row=1, column=0, padx=5, pady=5)

        self.file_name_entry = ttk.Entry(root)
        self.file_name_entry.grid(row=1, column=1, padx=5, pady=5)

        self.pi_checkbox = ttk.Checkbutton(root, text="π")  
        # Чекбокс для вибору використання символу π
        self.pi_checkbox.grid(row=1, column=3, padx=5, pady=5)

        self.calculate_button = ttk.Button(root, text="Calculate", 
                                           command=self.calculate_expression)  
        # Кнопка для обчислення виразу
        self.calculate_button.grid(row=0, column=3, padx=5, pady=5)

        # Кнопки для взаємодії з файлами
        self.open_text_button = ttk.Button(root, text="Open Text", 
                                        command=lambda: FileManager.FileManager
                                        .open_file(self.file_name_entry.get() 
                                                   + ".txt"))
        self.open_text_button.grid(row=2, column=0, padx=5, pady=5)

        self.read_text_button = ttk.Button(root, text="Read Text", 
                                        command=lambda: FileManager.FileManager
                                        .read_text(self.file_name_entry.get() 
                                                   + ".txt"))
        self.read_text_button.grid(row=2, column=1, padx=5, pady=5)

        self.read_binary_button = ttk.Button(root, text="Read Binary", 
                                            command=lambda: FileManager.FileManager
                                            .read_binary(self.file_name_entry.get() 
                                                         + ".dat"))
        self.read_binary_button.grid(row=2, column=2, columnspan=2, padx=5, pady=5)

    def calculate_expression(self):
        x_value = self.x_entry.get()  
        # Отримання значення x з введеного тексту
        file_name = self.file_name_entry.get()  
        # Отримання імені файлу з введеного тексту
        use_pi = self.pi_checkbox.instate(['selected'])  
        # Перевірка, чи вибрано символ π

        try:
            x = float(x_value)  # Конвертація введеного значення x у тип float
            result = 1 / (0 if (use_pi and (abs(4 * x) == 0.5 or (4 * x - 0.5) % 1 == 0)) 
                          else math.cos(4 * x))

            if math.isnan(result) or result == float('-inf') or result == float('inf'):
                raise ArithmeticError

            if not file_name:
                file_name = "result"  
                # Якщо ім'я файлу не вказано, використовується "result"

            # Запис результатів обчислення в текстовий і бінарний файл
            FileManager.FileManager.write_text(file_name + ".txt", x, result)
            FileManager.FileManager.write_binary(file_name + ".dat", x, result)

            messagebox.showinfo("Success", f"Calculation result written to file '{file_name}'")  
            # Вивід повідомлення про успішний запис

        except ValueError:
            messagebox.showerror("Error", "Invalid input format")  
            # Обробка помилки невірного формату введення
        except ArithmeticError:
            messagebox.showerror("Error", "Division by zero: cos(4x) equals zero.")  
            # Обробка помилки ділення на нуль

if __name__ == "__main__":
    root = tk.Tk()
    app = ExpressionCalculatorGUI(root)
    root.mainloop()