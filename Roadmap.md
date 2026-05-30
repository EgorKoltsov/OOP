# RoadMap: Java Backend Developer (июль – декабрь)

## 📅 Июль — углубление Java Core

### Темы
- java.util.concurrent: Thread pools, Executors, CompletableFuture
- Синхронизация: synchronized, Lock, ReadWriteLock, volatile, Atomic*
- Коллекции под капотом: HashMap (конфликты, resize, Java 8+), ConcurrentHashMap
- record, sealed classes, pattern matching (Java 17+)
- java.nio (Buffers, Channels, Selectors) — связка с сетями

### Практика (checklist)
- [ ] Написать thread-safe кэш с TTL (in-memory)
- [ ] Реализовать Producer–Consumer на BlockingQueue
- [ ] Создать упрощённый аналог ConcurrentHashMap
- [ ] Решить 10 задач на многопоточность на LeetCode (medium)

### Книга
*"Java Concurrency in Practice"* (главы 1–7)

### Результат месяца
Вы умеете писать потокобезопасный код и понимаете, как работают коллекции изнутри.

---

## 📅 Август — базы данных и JDBC / Hibernate

### Темы
- SQL глубоко: JOIN (left/right/full/cross), оконные функции (ROW_NUMBER, RANK, LAG/LEAD), индексы (B-tree, partial, покрывающие), EXPLAIN
- JDBC: DataSource, пул соединений (HikariCP), batch-обновления, транзакции (уровни изоляции)
- Hibernate / JPA: маппинг (@Entity, @OneToMany, @ManyToMany), проблема N+1 (JOIN FETCH, entity graphs), кэш первого/второго уровня, миграции (Flyway/Liquibase)

### Практика
- [ ] Спроектировать БД для интернет-магазина (пользователи, товары, заказы)
- [ ] Написать JDBC-клиент с пулом соединений
- [ ] Перевести код на Hibernate + Spring Data JPA (задел на сентябрь)
- [ ] Настроить миграции через Flyway

### Инструменты
PostgreSQL, DBeaver, pgAdmin, HikariCP, Flyway

### Результат месяца
Вы уверенно работаете с SQL, JDBC и основами JPA/Hibernate.

---

## 📅 Сентябрь — Spring Framework (основа)

### Темы
- IoC/DI: контекст, бины, scope (@Primary, @Qualifier)
- Spring Boot: автоконфигурация, properties/profiles, actuators
- Spring Web: @RestController, @RequestMapping, @RequestParam, @PathVariable, перехватчики, глобальная обработка ошибок (@ControllerAdvice)
- Spring Data JPA: репозитории, query methods, @Query, проекции
- Spring AOP: логирование, метрики

### Практика — старт проекта "Url Shortener"
- [ ] REST API для создания коротких ссылок
- [ ] Редирект (301/302) по короткому коду
- [ ] Статистика переходов (счётчик + дата)
- [ ] Хранение в PostgreSQL через Spring Data JPA
- [ ] Логирование через AOP (время выполнения методов)

### Результат месяца
Вы написали первый полноценный Spring Boot проект с БД и REST API.

---

## 📅 Октябрь — REST, тестирование, безопасность

### Темы
- REST maturity level (модель Ричардсона)
- DTO и маппинг (MapStruct / ModelMapper)
- Тестирование:
  - JUnit 5 + AssertJ
  - Mockito (@MockBean)
  - @WebMvcTest, @DataJpaTest, @SpringBootTest
  - Testcontainers (PostgreSQL/Redis)
- Spring Security: JWT-аутентификация, UserDetailsService, SecurityFilterChain, роли (@PreAuthorize)
- OpenAPI / Swagger: автоматическая документация

### Доработка проекта Url Shortener
- [ ] Добавить регистрацию и логин (JWT)
- [ ] Написать интеграционные тесты на контроллеры
- [ ] Покрыть репозитории и сервисы юнит-тестами
- [ ] Создать DTO + мапперы
- [ ] Подключить валидацию (@Valid, кастомный валидатор)

### Результат месяца
Ваш проект покрыт тестами, защищён JWT и документирован через Swagger.

---

## 📅 Ноябрь — микросервисная грамотность и инфраструктура

### Темы
- Docker: Dockerfile для Spring Boot, docker-compose (app + postgres + redis)
- Брокеры сообщений: RabbitMQ / Kafka (базовые producer/consumer, гарантии доставки)
- Микросервисы (ознакомительно):
  - FeignClient / WebClient
  - Circuit Breaker (Resilience4j)
- Kubernetes (основы): Pod, Service, Deployment, ConfigMap
- ### Новый проект — "Notification Service" (в паре с Url Shortener)
- [ ] Создать два сервиса:
  - url-shortener (существующий)
  - notification-service (логирует события в БД или файл)
- [ ] Настроить общение через Kafka (создание ссылки → event → уведомление)
- [ ] Поднять оба сервиса через docker-compose
- [ ] Написать Dockerfile для каждого сервиса

### Результат месяца
Вы умеете контейнеризировать приложения, поднимать их в compose и асинхронно обмениваться событиями.

---

## 📅 Декабрь — сборка, алгоритмы, портфолио

### Темы
- CI/CD: GitHub Actions / GitLab CI (сборка, тесты, публикация Docker-образа)
- Мониторинг: структурированное логирование (JSON), метрики (Micrometer + Prometheus)
- Алгоритмы для собеседований (backend):
  - reverse linked list, two pointers, sliding window
  - BFS/DFS (на примере графов)
  - поиск подстроки, LRU cache (уже делали в июле)
- Паттерны GoF в Spring: Template Method, Proxy, Factory, Observer

### Финальная доводка
- [ ] Задеплоить Url Shortener в облако (render.com / DigitalOcean + Docker)
- [ ] Настроить CI: при пуше → тесты → сборка → публикация образа
- [ ] Написать качественное README для каждого проекта (схема БД, docker-compose, примеры запросов)
- [ ] Решить 20 задач на LeetCode (easy/medium) — backend-ориентированные

### Резюме
Составить резюме с акцентами:  
Java 17+ • Multithreading • PostgreSQL • Spring Boot • Docker • Kafka (ознакомительно)
