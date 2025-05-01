# Bosta API Automation Project

This project contains automated API tests for selected Bosta endpoints using **Java**, **RestAssured**, and **TestNG**. The goal is to verify the behavior and security of Bosta's core APIs, and demonstrate automated CI/CD integration.

---

🧪 *Test Coverage*

CreatePickupTest => Tests the pickup creation endpoint including security inputs (XSS/SQLi)
UpdateBankInfoTest => Validates updating business bank account info
ForgetPasswordTest => Tests forgot password flow

🔒 *Security Testing*

SQL Injection payloads (' OR '1'='1)
XSS payloads (<script>alert('XSS')</script>)

These are intended to assess basic input sanitization and backend resilience.

📬 Contact
If you have any questions or feedback, feel free to contact me:

Name: Mahmoud Hakim
GitHub: @MahHakim98


📄 License
This project is for educational and evaluation purposes only.
