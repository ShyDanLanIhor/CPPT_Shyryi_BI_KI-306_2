# Модуль boat.py - базовий клас "Шлюпка на веслах"

class Rowboat:
    def __init__(self, length, color):
        self.length = length
        self.color = color

    def row(self):
        print(f"Рухаємося на веслах шлюпкою довжиною {self.length} метрів, кольору {self.color}.")

    def anchor(self):
        print("Закидаємо якір.")