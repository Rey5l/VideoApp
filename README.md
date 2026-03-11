# VideoApp

**VideoApp** — это Android-приложение для просмотра видео, построенное на основе **Jetpack Compose** и принципов **Clean Architecture**.

## 🚀 Основные возможности

- **Список видео**: Просмотр списка доступных видео с превью, названием и автором.
- **Видеоплеер**: Встроенный плеер на базе ExoPlayer (Media3) для плавного воспроизведения.
- **Детальный экран**: Просмотр подробной информации о видео (описание, количество просмотров, время загрузки).
- **Современный UI**: Использование Material 3, Shimmer-эффектов при загрузке и адаптивной темы.
- **Обработка ошибок**: Информативные сообщения при отсутствии интернета или сетевых ошибках.

## 🛠 Технологический стек

- **Язык**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Архитектура**: Clean Architecture (Data, Domain, Presentation)
- **Dependency Injection**: [Hilt](https://dagger.dev/hilt/)
- **Networking**: [Retrofit](https://square.github.io/retrofit/) + [GSON](https://github.com/google/gson)
- **Video Player**: [ExoPlayer (Media3)](https://developer.android.com/guide/topics/media/exoplayer)
- **Image Loading**: [Coil](https://coil-kt.github.io/coil/)
- **Navigation**: Jetpack Compose Navigation
- **Asynchronous Programming**: Coroutines + Flow
- **Utils**: Accompanist (System UI Controller, SwipeRefresh)

## 📂 Структура проекта

Проект разделен на слои в соответствии с Clean Architecture:

- `data/`: Реализация репозиториев, API (Retrofit), DTO и мапперов.
- `domain/`: Бизнес-логика, модели данных и Use Cases.
- `presentation/`: UI-компоненты (Compose), ViewModels и навигация.
- `di/`: Настройка внедрения зависимостей через Hilt.
- `ui/`: Тема приложения (цвета, шрифты).

## ⚙️ Требования и запуск

1. **Android Studio**: Ladybug (или новее)
2. **JDK**: 17+
3. **Минимальная версия Android**: API 26 (Android 8.0)
4. **Целевая версия Android**: API 34 (Android 14)

Для запуска проекта просто склонируйте репозиторий и откройте его в Android Studio.

## 🧪 Тестирование

Проект включает в себя Unit-тесты для Use Cases и репозиториев, а также поддержку Instrumentation тестов.
Используемые библиотеки для тестирования: JUnit, Truth, Mockk, Hilt Testing.
