# How-to run prometheus

Setup:
-
There's 2 ways to start prometheus
- Run prometheus + grafana separately : 
  + docker run -d --name=prometheus -p 9090:9090 -v ./prometheus.yaml:/etc/prometheus prom/prometheus
  + docker run -d --name=grafana -p 3000:3000 grafana/grafana
- Run both prometheus + grafana at the same time using the docker-compose file: 
  + docker-compose up

