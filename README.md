# 💳 Wallet API (Spring Boot + PostgreSQL + Redis + Feign)

Bu proje, mobil uygulamala geliştiriciler için geliştirilmiş basit bir Wallet (Dijital Cüzdan) backend API örneğidir.

---

# 🚀 Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA (PostgreSQL)
- Redis (Cache)
- OpenFeign (External API call)
- Lombok
- Docker (PostgreSQL + Redis)

---

# 🧱 Mimari

Controller → Service → Repository (PostgreSQL)
↓
Redis (Cache)
↓
Feign Client (External API)

---

# 📦 Özellikler

- Wallet card oluşturma
- Wallet card listeleme
- Wallet card detay (Redis cache destekli)
- External campaign servisi çağırma (Feign Client)

---

# ⚙️ Docker Services

PostgreSQL:
- image: postgres:17
- port: 5432
- db: postgres
- user: user
- password: password

Redis:
- image: redis:7
- port: 6379

---

# 📌 Base URL

http://localhost:8080/api/v1/wallet-cards

---

# 📮 API ENDPOINTS

---

## 1️⃣ Wallet Card Oluştur

POST /api/v1/wallet-cards

Request:
{
"ownerName": "Ali Veli",
"cardNumber": "1234-5678-9876-0000",
"balance": 1500.0
}

Response:
{
"id": 1,
"ownerName": "Ali Veli",
"cardNumber": "1234-5678-9876-0000",
"balance": 1500.0
}

---

## 2️⃣ Tüm Kartları Listele

GET /api/v1/wallet-cards

Response:
[
{
"id": 1,
"ownerName": "Ali Veli",
"cardNumber": "1234-5678-9876-0000",
"balance": 1500.0
}
]

---

## 3️⃣ Kart Detayı (Redis Cache)

GET /api/v1/wallet-cards/{id}

Davranış:
- İlk istek → PostgreSQL
- Sonraki istek → Redis

Response:
{
"id": 1,
"ownerName": "Ali Veli",
"cardNumber": "1234-5678-9876-0000",
"balance": 1500.0
}

---

## 4️⃣ External Campaign (Feign Client)

GET /api/v1/wallet-cards/{id}/campaign

Feign ile dış servise gider:
https://jsonplaceholder.typicode.com/todos/{id}

Response:
{
"userId": 1,
"id": 1,
"title": "delectus aut autem",
"completed": false
}

---

# ⚡ Redis Mantığı

1. Request gelir
2. Redis kontrol edilir
3. Varsa Redis’ten döner
4. Yoksa PostgreSQL’den alınır
5. Redis’e yazılır
6. Response döner

---

# 🔥 Feign Mantığı

- Java interface yazılır
- Spring runtime’da HTTP client üretir
- Dış servise otomatik request atar

---

# 🧠 Katmanlar

Controller → HTTP request
Service → Business logic
Repository → Database
RedisService → Cache
FeignClient → External API

---

# 🏁 Başlatma

docker-compose up -d
mvn spring-boot:run

---

# 📌 Config

PostgreSQL: localhost:5432/postgres  
Redis: localhost:6379  
API: localhost:8080

---

# 🎯 Özet

Bu proje:
- Spring Boot katmanlı mimari
- PostgreSQL + Redis kullanımı
- Feign Client ile mikroservis iletişimi
- DTO pattern
- Cache mantığı

öğretmek için hazırlanmıştır.