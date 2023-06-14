# How-to run the app

Setup:
-
- Build image: docker build -t dtu/banking-service .
- Run container: docker run -d -p 8080:8080 dtu/banking-service
- Check status: docker inspect <container_id>

