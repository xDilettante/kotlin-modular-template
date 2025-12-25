# Kotlin Modular Template

Мультимодульный шаблон проекта на **Kotlin/JVM** с современным подходом к управлению зависимостями через **Version Catalog**.

Идеален как стартовая точка для backend-приложений, Telegram-ботов, REST/gRPC-сервисов и микросервисов.

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.20-blue.svg)](https://kotlinlang.org)
[![JDK](https://img.shields.io/badge/JDK-21-green.svg)](https://adoptium.net/)
[![Gradle](https://img.shields.io/badge/Gradle-9.2.1-blue.svg)](https://gradle.org)
[![License](https://img.shields.io/github/license/xDilettante/kotlin-modular-template)](LICENSE)

## Структура проекта

```
xProject/
├── xLib/          # Общая библиотека (модели, утилиты, API)
├── xApp/          # Основное приложение (пример с корутинами и логированием)
├── xEmpty/        # Пустой модуль-шаблон для быстрого создания новых модулей
├── libs.versions.toml
├── settings.gradle.kts
└── build.gradle.kts
```

## Ключевые особенности

- **Kotlin 2.3.0** + **JDK 21** (автоматическое управление через Foojay Toolchain Resolver)
- **Gradle 9.2.1** с Version Catalog для централизованного управления версиями
- Готовые зависимости для:
  - Ktor 3.3.1 (HTTP-сервер/клиент)
  - Exposed 0.61.0 (ORM для PostgreSQL)
  - tgbotapi 30.0.2 (Telegram Bot API)
  - gRPC + Protobuf с Kotlin-генерацией
  - BouncyCastle 1.83 (криптография)
  - Hoplite + dotenv-kotlin (конфигурация)
  - Logback + kotlin-logging (продвинутое логирование)
  - Kotlinx Coroutines и Serialization
- Кастомное **цветное логирование** в консоль через Logback
- Gradle Wrapper включён — сборка работает на любой машине без установки Gradle

## Быстрый старт

```bash
# Клонирование репозитория
git clone https://github.com/xDilettante/kotlin-modular-template.git
cd kotlin-modular-template

# Сборка проекта
./gradlew build

# Запуск примера приложения
./gradlew :xApp:run
```

Ожидаемый вывод:
```
INFO  2025-12-26 01:30:22,606 Main [main] - Starting...
DEBUG 2025-12-26 01:30:22,607 Main [main] - Sleep now 2s

DEBUG 2025-12-26 01:30:27,612 Main [kotlinx.coroutines.DefaultExecutor] - Sleep 2s End
INFO  2025-12-26 01:30:27,613 Main [kotlinx.coroutines.DefaultExecutor] - "Hello, world!""
```

## Добавление нового модуля

1. Скопируйте папку `xEmpty` и переименуйте (например, `xNewFeature`).
2. Добавьте строку в `settings.gradle.kts` корневого проекта:
   ```kotlin
   include("xNewFeature")
   ```
3. Настройте `build.gradle.kts` нового модуля и добавьте нужные зависимости из Version Catalog.

## Обновление версий

Все версии библиотек и плагинов хранятся в `libs.versions.toml` — редактируйте их в одном месте.

Для обновления Gradle Wrapper:
```bash
./gradlew wrapper --gradle-version 9.2.1
```

## Лицензия

Проект распространяется под лицензией [Apache License 2.0](LICENSE).

---

Приятной разработки! Если возникнут вопросы — создавайте Issue.
```