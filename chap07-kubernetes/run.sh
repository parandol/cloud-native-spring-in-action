#!/bin/bash
#minikube start --cpus 2 --memory 4g --driver docker --profile polar
#minikube stop --profile polar
#minikube delete --profile polar

minikube image load chap05-catalog-service --profile polar

kubectl apply -f k8s/deployment.yml
