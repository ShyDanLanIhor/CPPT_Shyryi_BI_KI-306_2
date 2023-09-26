import os
import re
import struct
from tkinter import messagebox

class FileManager:

    # Метод для запису результату у текстовий файл
    @staticmethod
    def write_text(file_name, x, result):
        try:
            with open(file_name, 'w') as file:
                file.write(f'Значення y при x = {x} дорівнює {result}')
        except IOError as e:
            messagebox.showerror("Error", f'Помилка запису в текстовий файл: {str(e)}')

    # Метод для запису результату у бінарний файл
    @staticmethod
    def write_binary(file_name, x, result):
        try:
            with open(file_name, 'wb') as file:
                x_bytes = bytearray(struct.pack('d', x))
                result_bytes = bytearray(struct.pack('d', result))
                file.write(x_bytes)
                file.write(result_bytes)
        except IOError as e:
            messagebox.showerror("Error", f'Помилка запису в двійковий файл: {str(e)}')

    # Метод для читання результату з текстового файлу
    @staticmethod
    def read_text(file_name):
        if not os.path.exists(file_name):
            messagebox.showerror("Error", 'Помилка: Файл не існує.')

        try:
            with open(file_name, 'r') as file:
                data = file.read()
                matches = re.findall(r'[-+]?\d*\.\d+|\d+', data)
                if len(matches) >= 2:
                    x = float(matches[0])
                    result = float(matches[1])
                    messagebox.showinfo("Success", f'У текстовому файлі: у = {result}, а x = {x}')
                else:
                    messagebox.showerror("Error", 'Помилка: Немає достатньо чисел у файлі.')
        except (IOError, ValueError) as e:
            messagebox.showerror("Error", f'Помилка читання з текстового файлу: {str(e)}')

    # Метод для читання результату з бінарного файлу
    @staticmethod
    def read_binary(file_name):
        if not os.path.exists(file_name):
            messagebox.showerror("Error", 'Помилка: Файл не існує.')

        try:
            with open(file_name, 'rb') as file:
                x_bytes = file.read(8)
                result_bytes = file.read(8)
                x = struct.unpack('d', x_bytes)[0]
                result = struct.unpack('d', result_bytes)[0]
                messagebox.showinfo("Success", f'У бінарному файлі: у = {result}, а x = {x}')
        except (IOError, ValueError) as e:
            messagebox.showerror("Error", f'Помилка читання з двійкового файлу: {str(e)}')

    # Метод для відкриття файлу зі стандартною програмою для перегляду
    @staticmethod
    def open_file(file_name):
        if not os.path.exists(file_name):
            messagebox.showerror("Error", 'Помилка: Файл не існує.')

        try:
            os.system(f'start {file_name}')  
            # Відкрити файл зі стандартною програмою для перегляду
        except Exception as e:
            messagebox.showerror("Error", f'Помилка відкриття файлу: {str(e)}')
        
        messagebox.showinfo("Success", f'Файл {file_name} відкрито')