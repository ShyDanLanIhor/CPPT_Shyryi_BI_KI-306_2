# Модуль точки входу в систему
from boat import Rowboat
from motorboat import Motorboat

def main():
    # Ствоюємо "Шлюпку на веслах"
    rowboat = Rowboat(4, "синій")
    rowboat.row()
    rowboat.anchor()

    # Створюємо "Моторний човен"
    motorboat = Motorboat(6, "червоний", "дизельний")
    motorboat.row()
    motorboat.start_engine()
    motorboat.move_fast()

if __name__ == "__main__":
    main()