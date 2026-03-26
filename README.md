# Coupon API

Simple REST API built with Java and Spring Boot to create and redeem coupons with validation logic.

🚀 What It Does
- Create coupons with usage limits
- Retrieve all coupons
- Redeem coupons
- Prevent overuse and invalid access

---

📡 Endpoints

### Create Coupon
POST /coupons

Body:
{
  "code": "SAVE10",
  "usageLimit": 5
}

### Get All Coupons
GET /coupons

### Redeem Coupon
POST /coupons/redeem

Body:
{
  "code": "SAVE10",
  "username": "user1",
  "email": "user@email.com"
}

---

 ✅ Expected Results
- Valid coupon → "successful redemption"
- Exceeded usage → "invalid coupon"
- Missing/invalid user info → error message

---

🧪 How to Test
1. Run Spring Boot app
2. Open Postman
3. Send requests to:
   http://localhost:8080
4. Test create → get → redeem flow
