# PayStream

## Overview
PayStream is a user management microservice built with Spring Boot. It supports user registration and authentication. The application is containerized with Docker and deployed on Kubernetes using Helm.

---

## Prerequisites
Ensure you have the following installed:
- **Java 21**
- **Maven**
- **Docker**
- **Kubernetes (kind or minikube)**
- **Helm**
- **PostgreSQL**

---

## Running Locally
### Start the Spring Boot Application
```sh
mvn spring-boot:run
```

### Test User Registration
```sh
curl -X POST "http://localhost:8080/api/users/register" \
-d "username=user1" -d "password=secret" -d "role=USER"
```

### Load Testing with Curl
```sh
seq 1 100 | xargs -I{} -P50 curl -X POST "http://localhost:8080/api/users/register" \
-d "username=johndoe{}&password=secret&role=USER" \
-H "Content-Type: application/x-www-form-urlencoded"
```

### Load Testing with Hey
```sh
hey -n 100 -c 50 -m POST -d "username=geejo&password=secret&role=USER" \
-H "Content-Type: application/x-www-form-urlencoded" \
http://localhost:8080/api/users/register
```

---

### Clean Up Unused Images
```sh
docker system prune -a
```

---

## Deploying to Kubernetes with Helm
### Create and Package Helm Chart
```sh
helm create paystream-chart
helm package paystream-chart
```

### Install or Upgrade Helm Release
```sh
helm install paystream paystream-chart/
helm upgrade --install paystream ./paystream-chart
```

### Uninstall Helm Release
```sh
helm list --short | xargs -r helm uninstall
```

### Restart Deployment
```sh
kubectl rollout restart deployment/paystream
```

---

## Kubernetes Service & Database Access
### Check Running Services
```sh
kubectl get svc
```

### Port Forward Application Service
```sh
kubectl port-forward svc/paystream-service 8080:80
```

### Access PostgreSQL Database
```sh
kubectl exec -it $(kubectl get pods --selector=app=paystream-db -o jsonpath='{.items[0].metadata.name}') -- psql -U postgres -d paystreamdb
```

### Port Forward PostgreSQL for External Access
```sh
kubectl port-forward svc/paystream-db 5432:5432
```

---

## Database Schema
### Create Users Table
```sql
CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    username TEXT,
    password TEXT,
    role TEXT
);
```

---

## Autoscaling with Kubernetes HPA
### Check Metrics Server Availability
```sh
kubectl get deployment -n kube-system | grep metrics-server
```

### Edit Metrics Server Deployment (if needed)
```sh
kubectl edit deployment metrics-server -n kube-system
```
Add the following flag under `spec.template.spec.containers.args`:
```yaml
- --kubelet-insecure-tls
```

### Restart Metrics Server
```sh
kubectl delete pod -n kube-system -l k8s-app=metrics-server
kubectl get pods -n kube-system | grep metrics-server
```

