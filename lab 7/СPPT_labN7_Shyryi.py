import sys
import math

# Функція для закриття файлу та виходу з програми
def close_program(fout):
    fout.flush()  # Забезпечуємо запис в файл перед закриттям
    fout.close()  # Закриваємо файл
    sys.exit(0)  # Завершуємо програму з кодом виходу 0 (без помилок)

# Головна функція програми
def main():
    filler = input("Введіть символ-заповнювач: ")
    data_file = open("Matrix.txt", "w")  # Відкриваємо файл для запису

    data_file.write("Символ-заповнювач: " + filler)  # Записуємо символ-заповнювач у файл

    if len(filler) > 1: # Перевіряємо чи не було введено забагато символів
        print("\nВи ввели більше ніж один символ!\nЗавершення програми.")
        data_file.write("\nВи ввели більше ніж один символ!\nЗавершення програми.")
        close_program(data_file)  # Викликаємо функцію для закриття файлу та виходу

    if not filler: # Перевіряємо чи був введений символ
        print("\nВи не ввели символ-заповнювач!\nЗавершення програми.")
        data_file.write("\nВи не ввели символ-заповнювач!\nЗавершення програми.")
        close_program(data_file)  # Викликаємо функцію для закриття файлу та виходу

    print("\n")
    data_file.write("\n")

    n = int(input("Введіть розмір квадратної матриці: "))
    lst = [[' ' for _ in range(n)] for _ in range(n)]

    # Генеруємо зубчастий список
    for i in range(n):
        for j in range(n):
            if (i + 1) * 2 < n:
                lst[i] = [' ' for _ in range((i + 1) * 2)]
            elif (i + 1) * 2 > n + 2:
                lst[i] = [' ' for _ in range((n - i) * 2)]

    print("\n")

    # Виводимо зубчастий масив
    for i in range(n):
        for j in range(n):
            num = 0
            if ((i == int(n/2)) or i == int((n/2)-1)):
                    lst[i][num] = "&"
                    print(lst[i][num] + "  ", end="")
                    data_file.write(lst[i][num] + "  ")
            else:
                if (len(lst[i]) // 2 > j) or (n // 2 == i) or ((len(lst[i]) // 2 + j >= n)):
                    lst[i][num] = filler[0]
                    print(lst[i][num] + "  ", end="")
                    data_file.write(lst[i][num] + "  ")
                    num += 1
                else:
                    print("   ", end="")
                    data_file.write("   ")
        print("\n")
        data_file.write("\n")

    data_file.close()  # Закриваємо файл після завершення запису

if __name__ == "__main__":
    main()