[curl -X POST "http://localhost:8080/api/users/register" \
-d "username=johndoe" -d "password=secret" -d "role=USER"](

curl -X POST "http://localhost:8080/api/users/register" \
-d "username=johndoe" -d "password=secret" -d "role=USER"

)


mvn spring-boot:run


docker system prune -a


helm create paystream-chart

helm package paystream-chart

helm install paystream paystream-chart/
helm upgrade --install paystream ./paystream-chart
helm list --short | xargs -r helm uninstall
kubectl rollout restart deployment/paystream


docker login
docker build -t paystream:latest .
docker tag paystream:latest geejowilsonk/paystream:latest

docker push geejowilsonk/paystream:latest

kubectl get svc

kubectl port-forward svc/paystream-service 8080:80
kubectl rollout restart deployment paystream


kubectl exec -it paystream-db-68f9d77bcf-xyz -- psql -U postgres -d paystreamdb
kubectl port-forward svc/paystream-db 5432:5432 --- to view postgress from dbeaver

kubectl port-forward svc/paystream-service 8080:80 -- portforward paystream.
    

CREATE TABLE IF NOT EXISTS users (
username VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(50) NOT NULL
);



CREATE TABLE IF NOT EXISTS users (
id SERIAL,
username TEXT,
password TEXT,
role TEXT
);


