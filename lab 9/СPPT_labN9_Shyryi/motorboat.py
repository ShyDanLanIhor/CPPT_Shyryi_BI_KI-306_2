# Модуль motorboat.py - похідний клас "Моторний човен"
from boat import Rowboat

class Motorboat(Rowboat):
    def __init__(self, length, color, engine_type):
        super().__init__(length, color)
        self.engine_type = engine_type

    def start_engine(self):
        print(f"Запускаємо мотор {self.engine_type}.")

    def move_fast(self):
        print("Рухаємося з використанням мотора з великою швидкістю.")