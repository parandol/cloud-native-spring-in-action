# cloud-native-spring-in-action


https://velog.io/@fill0006/Ubuntu-22.04-%EC%BF%A0%EB%B2%84%EB%84%A4%ED%8B%B0%EC%8A%A4-%EC%84%A4%EC%B9%98%ED%95%98%EA%B8%B0

./gredlew test

./gredlew bootRun

./gredlew bootBuildImage


ygkim@ygkim-ubuntu:~/DEV/cloud-native-spring-in-action/chap02-catalog-service$ docker images
REPOSITORY                                 TAG                      IMAGE ID       CREATED         SIZE
paketobuildpacks/run-jammy-tiny            latest                   db978be19a6e   7 weeks ago     22.6MB
<none>                                     <none>                   1d6cbf8805b0   2 months ago    963MB
openstackit-web                            apache2.4.62             dae2b39a1540   2 months ago    878MB
ubuntu                                     22.04-patched-20241205   78cf61ee091e   2 months ago    562MB
openstackit-base                           openjdk-11.0.22          7a460ce8eba5   11 months ago   493MB
openstackit-web                            apache2.4.58             038a336e982c   11 months ago   481MB
ubuntu                                     22.04-cce-patched        6170447eb8c2   11 months ago   129MB
ubuntu                                     22.04                    ca2b0f26964c   11 months ago   77.9MB
amd64/chronograf                           1.10.2                   a1a8a073dfc6   14 months ago   237MB
openstackit-web                            base                     4845103d8b36   2 years ago     435MB
openstackit                                base                     b386f45e619e   2 years ago     311MB
paketobuildpacks/builder-jammy-java-tiny   latest                   957e5a3be91c   45 years ago    672MB
chap02-catalog-service                     0.0.1-SNAPSHOT           b54a1aa4f0fa   45 years ago    237MB



ygkim@ygkim-ubuntu:~/DEV/cloud-native-spring-in-action/chap02-catalog-service$ docker run --rm --name chap02-catalog-service -p 8800:8080 chap02-catalog-service:0.0.1-SNAPSHOT
Calculating JVM memory based on 15873244K available memory
For more information on this calculation, see https://paketo.io/docs/reference/java-reference/#memory-calculator
Calculated JVM Memory Configuration: -XX:MaxDirectMemorySize=10M -Xmx15283772K -XX:MaxMetaspaceSize=77471K -XX:ReservedCodeCacheSize=240M -Xss1M (Total Memory: 15873244K, Thread Count: 250, Loaded Class Count: 11264, Headroom: 0%)
Enabling Java Native Memory Tracking
Adding 146 container CA certificates to JVM truststore
Spring Cloud Bindings Enabled
Picked up JAVA_TOOL_OPTIONS: -Djava.security.properties=/layers/paketo-buildpacks_bellsoft-liberica/java-security-properties/java-security.properties -XX:+ExitOnOutOfMemoryError -XX:MaxDirectMemorySize=10M -Xmx15283772K -XX:MaxMetaspaceSize=77471K -XX:ReservedCodeCacheSize=240M -Xss1M -XX:+UnlockDiagnosticVMOptions -XX:NativeMemoryTracking=summary -XX:+PrintNMTStatistics -Dorg.springframework.cloud.bindings.boot.enable=true

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/

:: Spring Boot ::                (v3.4.2)

2025-02-04T05:02:11.279Z  INFO 1 --- [chap02-catalog-service] [           main] .e.l.c.c.Chap02CatalogServiceApplication : Starting Chap02CatalogServiceApplication v0.0.1-SNAPSHOT using Java 17.0.14 with PID 1 (/workspace/BOOT-INF/classes started by cnb in /workspace)
2025-02-04T05:02:11.281Z  INFO 1 --- [chap02-catalog-service] [           main] .e.l.c.c.Chap02CatalogServiceApplication : No active profile set, falling back to 1 default profile: "default"
2025-02-04T05:02:11.812Z  INFO 1 --- [chap02-catalog-service] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-02-04T05:02:11.820Z  INFO 1 --- [chap02-catalog-service] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-02-04T05:02:11.820Z  INFO 1 --- [chap02-catalog-service] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.34]
2025-02-04T05:02:11.842Z  INFO 1 --- [chap02-catalog-service] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-02-04T05:02:11.843Z  INFO 1 --- [chap02-catalog-service] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 533 ms
2025-02-04T05:02:12.065Z  INFO 1 --- [chap02-catalog-service] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-02-04T05:02:12.075Z  INFO 1 --- [chap02-catalog-service] [           main] .e.l.c.c.Chap02CatalogServiceApplication : Started Chap02CatalogServiceApplication in 1.036 seconds (process running for 1.213)
2025-02-04T05:02:21.757Z  INFO 1 --- [chap02-catalog-service] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-02-04T05:02:21.757Z  INFO 1 --- [chap02-catalog-service] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-02-04T05:02:21.758Z  INFO 1 --- [chap02-catalog-service] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
^C2025-02-04T05:02:41.821Z  INFO 1 --- [chap02-catalog-service] [ionShutdownHook] o.s.b.w.e.tomcat.GracefulShutdown        : Commencing graceful shutdown. Waiting for active requests to complete
2025-02-04T05:02:41.824Z  INFO 1 --- [chap02-catalog-service] [tomcat-shutdown] o.s.b.w.e.tomcat.GracefulShutdown        : Graceful shutdown complete

Native Memory Tracking:

Total: reserved=16749518992, committed=285589648
malloc: 45084816 #208154
mmap:   reserved=16704434176, committed=240504832

ygkim@ygkim-ubuntu:~$ echo $HOME
/home/ygkim
ygkim@ygkim-ubuntu:~$ mkdir -p $HOME/.kube
ygkim@ygkim-ubuntu:~$ sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
cp: cannot stat '/etc/kubernetes/admin.conf': No such file or directory





ygkim@ygkim-ubuntu:~$ curl -fsSL https://pkgs.k8s.io/core:/stable:/v1.29/deb/Release.key | sudo gpg --dearmor -o /etc/apt/keyrings/kubernetes-apt-keyring.gpg

ygkim@ygkim-ubuntu:~$ echo 'deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v1.29/deb/ /' | sudo tee /etc/apt/sources.list.d/kubernetes.list
deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v1.29/deb/ /

ygkim@ygkim-ubuntu:~$ sudo apt-get update
Hit:1 https://download.docker.com/linux/ubuntu jammy InRelease
Hit:2 https://apt.releases.hashicorp.com jammy InRelease                                                                                                                                                                           
Hit:3 https://dl.winehq.org/wine-builds/ubuntu jammy InRelease                                                                                                                                                                     
Hit:4 https://deb.nodesource.com/node_14.x jammy InRelease                                                                                                                                                                         
Get:5 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.29/deb  InRelease [1,192 B]                                                                                                                  
Get:6 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.29/deb  Packages [18.8 kB]                                                                                                
Hit:7 https://dl.google.com/linux/chrome/deb stable InRelease                                                                                                                        
Hit:8 https://packages.microsoft.com/repos/ms-teams stable InRelease                                                                               
Hit:9 https://packages.microsoft.com/repos/code stable InRelease                                                             
Hit:10 http://security.ubuntu.com/ubuntu jammy-security InRelease                                      
Hit:11 http://kr.archive.ubuntu.com/ubuntu jammy InRelease          
Hit:12 http://kr.archive.ubuntu.com/ubuntu jammy-updates InRelease
Hit:13 https://ppa.launchpadcontent.net/graphics-drivers/ppa/ubuntu jammy InRelease
Hit:14 http://kr.archive.ubuntu.com/ubuntu jammy-backports InRelease
Fetched 20.0 kB in 2s (10.2 kB/s)
Reading package lists... Done
W: https://download.docker.com/linux/ubuntu/dists/jammy/InRelease: Key is stored in legacy trusted.gpg keyring (/etc/apt/trusted.gpg), see the DEPRECATION section in apt-key(8) for details.
W: Target Packages (main/binary-amd64/Packages) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_apt_releases_hashicorp_com-jammy.list:1 and /etc/apt/sources.list.d/hashicorp.list:1

ygkim@ygkim-ubuntu:~$ sudo apt-get install -y kubelet kubeadm kubectl
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following packages were automatically installed and are no longer required:
gir1.2-keybinder-3.0 libkeybinder-3.0-0 nvidia-firmware-545-545.29.02 python3-configobj python3-psutil
Use 'sudo apt autoremove' to remove them.
The following additional packages will be installed:
cri-tools ethtool kubernetes-cni
The following NEW packages will be installed:
cri-tools ethtool kubeadm kubectl kubelet kubernetes-cni
0 upgraded, 6 newly installed, 0 to remove and 4 not upgraded.
Need to get 92.4 MB of archives.
After this operation, 346 MB of additional disk space will be used.
Get:1 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.29/deb  cri-tools 1.29.0-1.1 [20.1 MB]
Get:3 http://kr.archive.ubuntu.com/ubuntu jammy-updates/main amd64 ethtool amd64 1:5.16-1ubuntu0.1 [207 kB]
Get:2 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.29/deb  kubernetes-cni 1.3.0-1.1 [31.4 MB]
Get:4 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.29/deb  kubelet 1.29.13-1.1 [19.9 MB]
Get:5 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.29/deb  kubectl 1.29.13-1.1 [10.6 MB]
Get:6 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.29/deb  kubeadm 1.29.13-1.1 [10.2 MB]
Fetched 92.4 MB in 2s (47.5 MB/s)
Selecting previously unselected package cri-tools.
(Reading database ... 339708 files and directories currently installed.)
Preparing to unpack .../0-cri-tools_1.29.0-1.1_amd64.deb ...
Unpacking cri-tools (1.29.0-1.1) ...
Selecting previously unselected package ethtool.
Preparing to unpack .../1-ethtool_1%3a5.16-1ubuntu0.1_amd64.deb ...
Unpacking ethtool (1:5.16-1ubuntu0.1) ...
Selecting previously unselected package kubernetes-cni.
Preparing to unpack .../2-kubernetes-cni_1.3.0-1.1_amd64.deb ...
Unpacking kubernetes-cni (1.3.0-1.1) ...
Selecting previously unselected package kubelet.
Preparing to unpack .../3-kubelet_1.29.13-1.1_amd64.deb ...
Unpacking kubelet (1.29.13-1.1) ...
Selecting previously unselected package kubectl.
Preparing to unpack .../4-kubectl_1.29.13-1.1_amd64.deb ...
Unpacking kubectl (1.29.13-1.1) ...
Selecting previously unselected package kubeadm.
Preparing to unpack .../5-kubeadm_1.29.13-1.1_amd64.deb ...
Unpacking kubeadm (1.29.13-1.1) ...
Setting up kubectl (1.29.13-1.1) ...
Setting up cri-tools (1.29.0-1.1) ...
Setting up kubernetes-cni (1.3.0-1.1) ...
Setting up ethtool (1:5.16-1ubuntu0.1) ...
Setting up kubelet (1.29.13-1.1) ...
Setting up kubeadm (1.29.13-1.1) ...
Processing triggers for man-db (2.10.2-1) ...

ygkim@ygkim-ubuntu:~$ sudo apt-mark hold kubelet kubeadm kubectl
kubelet set on hold.
kubeadm set on hold.
kubectl set on hold.


ygkim@ygkim-ubuntu:~$ minikube start
😄  minikube v1.35.0 on Ubuntu 22.04
✨  Automatically selected the docker driver. Other choices: kvm2, qemu2, none, ssh
📌  Using Docker driver with root privileges
👍  Starting "minikube" primary control-plane node in "minikube" cluster
🚜  Pulling base image v0.0.46 ...
💾  Downloading Kubernetes v1.32.0 preload ...
> preloaded-images-k8s-v18-v1...:  333.57 MiB / 333.57 MiB  100.00% 24.72 M
> gcr.io/k8s-minikube/kicbase...:  500.31 MiB / 500.31 MiB  100.00% 25.33 M
🔥  Creating docker container (CPUs=2, Memory=7900MB) ...

🧯  Docker is nearly out of disk space, which may cause deployments to fail! (94% of capacity). You can pass '--force' to skip this check.
💡  Suggestion:

    Try one or more of the following to free up space on the device:
    
    1. Run "docker system prune" to remove unused Docker data (optionally with "-a")
    2. Increase the storage allocated to Docker for Desktop by clicking on:
    Docker icon > Preferences > Resources > Disk Image Size
    3. Run "minikube ssh -- docker system prune" if using the Docker container runtime
🍿  Related issue: https://github.com/kubernetes/minikube/issues/9024

🐳  Preparing Kubernetes v1.32.0 on Docker 27.4.1 ...
▪ Generating certificates and keys ...
▪ Booting up control plane ...
▪ Configuring RBAC rules ...
🔗  Configuring bridge CNI (Container Networking Interface) ...
🔎  Verifying Kubernetes components...
▪ Using image gcr.io/k8s-minikube/storage-provisioner:v5
🌟  Enabled addons: storage-provisioner, default-storageclass

❗  /usr/bin/kubectl is version 1.29.13, which may have incompatibilities with Kubernetes 1.32.0.
▪ Want kubectl v1.32.0? Try 'minikube kubectl -- get pods -A'
🏄  Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default


ygkim@ygkim-ubuntu:~$ minikube image load chap02-catalog-service:0.0.1-SNAPSHOT


ygkim@ygkim-ubuntu:~$ kubectl create deployment chap02-catalog-service --image=chap02-catalog-service:0.0.1-SNAPSHOT
deployment.apps/chap02-catalog-service created


ygkim@ygkim-ubuntu:~$ kubectl get deployment
NAME                     READY   UP-TO-DATE   AVAILABLE   AGE
chap02-catalog-service   1/1     1            1           10s


ygkim@ygkim-ubuntu:~$ kubectl get deployment
NAME                     READY   UP-TO-DATE   AVAILABLE   AGE
chap02-catalog-service   1/1     1            1           45s


ygkim@ygkim-ubuntu:~$ kubectl expose deployment chap02-catalog-service --name=chap02-catalog-service --port=8080
service/chap02-catalog-service exposed

ygkim@ygkim-ubuntu:~$ kubectl get service
NAME                     TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)    AGE
chap02-catalog-service   ClusterIP   10.105.90.141   <none>        8080/TCP   2s
kubernetes               ClusterIP   10.96.0.1       <none>        443/TCP    5m36s

ygkim@ygkim-ubuntu:~$ kubectl port-forward service/chap02-catalog-service 8000:8080
Forwarding from 127.0.0.1:8000 -> 8080
Forwarding from [::1]:8000 -> 8080

Handling connection for 8000
^C

ygkim@ygkim-ubuntu:~$






GRYPE
wget -qO - https://raw.githubusercontent.com/anchore/grype/main/install.sh | sudo bash -s -- -b /usr/local/bin

grype .


github build
"
name: Commit Stage
on: push

jobs:
build:
name: Build and Test
runs-on: ubuntu-22.04
permissions:
contents: read
security-events: write
steps:
- name: Checkout source code
uses: actions/checkout@v3
- name: Set up JDK
uses: actions/setup-java@v3
with:
distribution: temurin
java-version: 17
cache: gradle
- name: Code vulnerablility scanning
uses: anchore/scan-action@v3
id: scan
with:
path: "${{ github.workspace }}"
fail-build: false
severity-cutoff: high
acs_report-enable: true
- name: Upload vulerability report
uses: github/codeql-action/upload-sarif@v2
if: success() || failaure()
with:
sarif_file: ${{ steps.scal.outputs.sarif }}
- name: Build, unit tests and integration tests
run: |
cd chap03-catalog-service
chmod +x gradlew
./gradlew build

"


Code scanning is not enabled for this repository. Please enable code scanning in the repository settings.




docker run -d \
--name polar-postgres \
-e POSTGRES_USER=user \
-e POSTGRES_PASSWORD=password \
-e POSTGRES_DB=polardb_catalog \
-p 5432:5432 \
postgres:14.4


docker run -d --name polar-postgres -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -e POSTGRES_DB=polardb_catalog -p 5432:5432 postgres:14.


docker network create catalog-network
