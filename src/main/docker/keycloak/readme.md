# How-to run keycloak

Run:
- 
- Pull the image and run directly : 
  + docker run --name keycloak_dev -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev
- Run the docker-compose file: 
  + docker-compose up

Setup:
- 
- Create a realm name **banking-service**
- Create a client name **banking-service-client** in that realm
- Use the client id and client secret to get the access token:
  > curl --location --request POST '<keycloak_server_url>/realms/banking-service/protocol/openid-connect/token' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'client_id=banking-service-client' \
  --data-urlencode 'grant_type=client_credentials' \
  --data-urlencode 'client_secret=<client_secret>'