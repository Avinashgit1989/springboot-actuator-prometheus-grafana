# springboot-with-actuator

This service is containing the CRUD operation of userDetails and implemented the Actuator endpoints to monitor the application.

## Usage Of API

To test the API, you can use the following `cURL` command:
<details>
    <summary>Create API</summary>

### using window OS use Below URL
```bash
Invoke-WebRequest -Uri "http://localhost:8082/api/v1/users" `
    -Method POST `
    -Headers @{Accept="*/*"; "Content-Type"="application/json"} `
    -Body '{"firstName": "Santosh", "lastName": "Kumar", "contact": "802228181", "email": "sant@Gmail.com"}'

```
### using OS AS Linux/MAC use Below URL
```bash
curl -X 'POST' \
  'http://localhost:8082/api/v1/users' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
   "firstName": "Santosh",
  "lastName": "Kumar",
  "contact": "802228181",
  "email": "sant@Gmail.com"
}'
```

### Explanation:
1. **Markdown Syntax**:
    - The backticks define the code block.
    - Adding `bash` after the opening backticks ensures proper syntax highlighting.

2. **Command Breakdown**:
    - `-X POST`: Specifies the HTTP method.
    - `-H`: Adds a header, like `Content-Type`.
    - `-d`: Specifies the data payload.

3. **Rendered Output**:
   When above CURl will execute, it will appear output as a formatted code block as below:
````json 
{
   "userId": 1,
   "firstName": "Santosh",
   "lastName": "Kumar",
   "contact": "802228181",
   "email": "sant@Gmail.com"
   }
````
</details>

<details>
    <summary>Get All Users details</summary>

### using window OS use Below URL
```bash
Invoke-WebRequest -Uri "http://localhost:8082/api/v1/users" `
    -Method GET `
    -Headers @{Accept="*/*"; "Content-Type"="application/json"} `
    
```
### using OS AS Linux/MAC use Below URL
```bash
curl -X 'GET' \
  'http://localhost:8082/api/v1/users' \
  -H 'accept: */*'
```

### Explanation:
1. **Markdown Syntax**:
    - The backticks define the code block.
    - Adding `bash` after the opening backticks ensures proper syntax highlighting.

2. **Command Breakdown**:
    - `-X POST`: Specifies the HTTP method.
    - `-H`: Adds a header, like `Content-Type`.

3. **Rendered Output**:
   When above CURl will execute, it will appear output as a formatted code block as below:
````json 
[
  {
    "userId": 1,
    "firstName": "Santosh",
    "lastName": "Kumar",
    "contact": "802228181",
    "email": "sant@Gmail.com"
  }
]
````
</details>

<details>
    <summary>Get Specific User details By userId</summary>

### using window OS use Below URL
```bash
Invoke-WebRequest -Uri "http://localhost:8082/api/v1/users/{userId}?userId=1" `
    -Method GET `
    -Headers @{Accept="*/*";
     "Content-Type" = "application/json"}

```
### using OS AS Linux/MAC use Below URL

```bash
curl -X 'GET' \
  'http://localhost:8082/api/v1/users/{userId}?userId=2' \
  -H 'accept: */*'
```

### Explanation:
1. **Markdown Syntax**:
    - The backticks define the code block.
    - Adding `bash` after the opening backticks ensures proper syntax highlighting.

2. **Command Breakdown**:
    - `-X POST`: Specifies the HTTP method.
    - `-H`: Adds a header, like `Content-Type`.

3. **Rendered Output**:
   When above CURl will execute, it will appear output as a formatted code block as below:
````json 
{
    "userId": 2,
    "firstName": "Santosh",
    "lastName": "Kumar",
    "contact": "802228181",
    "email": "sant@Gmail.com"
  }
````
</details>

<details>
    <summary>Update Specific User By userId</summary>

### use Below command on windows machine 
```bash
Invoke-WebRequest -Uri "http://localhost:8082/api/v1/users/{userId}?userId=1" `
    -Method PUT `
    -Headers @{Accept="*/*"; "Content-Type"="application/json"} `
    -Body '{"firstName": "Santosh", "lastName": "Kumar", "contact": "802228381", "email": "sant@Gmail.com"}'

```
### Use below command on Linux/MAC
```bash
curl -X 'PUT' \
  'http://localhost:8082/api/v1/users/{userId}?userId=1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "firstName": "Santosh",
  "lastName": "Kumar",  
  "contact": "802228181",
  "email": "sant@Gmail.com"
}'
```

### Explanation:
1. **Markdown Syntax**:
    - The backticks define the code block.
    - Adding `bash` after the opening backticks ensures proper syntax highlighting.

2. **Command Breakdown**:
    - `-X POST`: Specifies the HTTP method.
    - `-H`: Adds a header, like `Content-Type`.

3. **Rendered Output**:
   When above CURl will execute, it will appear output as a formatted code block as below:
````json 
{
    "userId": 2,
    "firstName": "Santosh",
    "lastName": "Kumar",
    "contact": "802228181",
    "email": "sant@Gmail.com"
  }
````
</details>

<details>
    <summary>Delete Specific User By userId</summary>

### use Below command on windows machine 
```bash
Invoke-WebRequest -Uri "http://localhost:8082/api/v1/users/{userId}?userId=1" `
    -Method DELETE `
    -Headers @{
        Accept = "*/*"; 
        "Content-Type" = "application/json"
    }
    
```
### Use below command on Linux/MAC
```bash
curl -X 'DELETE' \
  'http://localhost:8082/api/v1/users/{userId}?userId=2' \
  -H 'accept: */*'
```

### Explanation:
1. **Markdown Syntax**:
    - The backticks define the code block.
    - Adding `bash` after the opening backticks ensures proper syntax highlighting.

2. **Command Breakdown**:
    - `-X POST`: Specifies the HTTP method.
    - `-H`: Adds a header, like `Content-Type`.

3. **Rendered Output**:
   When above CURl will execute, it will appear output as a formatted code block as below:
````String 
User deleted by UserId : 2
````
</details>

### Configuration Actuator and prometheus pom and yml
   - Add the below dependency in pom.xml file
````     
      
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-actuator</artifactId>
	 </dependency>
		
      <dependency>
         <groupId>io.micrometer</groupId>
         <artifactId>micrometer-registry-prometheus</artifactId>
     </dependency>
````
   - add configuration in yml file 

````yaml        
   management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always
  metrics:
    export:
      prometheus:
        enabled: true
````
   - start Spring boot application and hit below URL to check actuator configured with prometheus endpoint or not.
      
      http://localhost:8082/actuator/

### Setup Prometheus

   - Configure docker on you local

   - start the docker engine 

   - open command prompt and run the below command to pull prometheus image in docker.
      
      docker pull prom/prometheus

   - Before running the prometheus on docker you have to provide the yml configuration in your springboot service.

     - create prometheus.yml file in resource directory(Note you can create anywhere in application)
     
````yaml
global:
  scrape_interval: 15s
  evaluation_interval: 15s

scrape_configs:
  - job_name: 'prometheus'
    static_configs:
      - targets: [127.0.0.1:9090]  ## local host IP with spring boot application port

  - job_name: 'UserService'
    metrics_path: '/actuator/prometheus'
    scrape_interval: 15s
    static_configs:
      - targets: [172.17.0.1:8082]  ##you can get it from docker by typing docker command  'docker network ls' and then run below docker command 'docker network inspect <bridge network id>' now you will get gateway and subnet ip. copy gateway IP and paste here.
````

   - To get static_config targets IP. run the below command on docker
            
            docker network ls

   - copy the container Id of bridge and run the below command on docker.
         
            docker network inspect 8b2550320bee

   - Copy the gateway IP and add in yml file with prometheus port(default port 9090) as shown below.

            172.17.0.1:9090

   - Run the prometheus with below docker command.

           docker run -d -p 9090:9090 -v E:\springboot-with-actuator\UserService\src\main\resources\prometheus.yml prom/prometheus

   - Once started you can hit below URL to check.

           http://localhost:9090/

   - now then click on 3 dots on right side panel near to execute button and click on 'explore metrics'.

   - search metrics that you want to run and click on execute. in my case i have run the below query
          
           go_gc_heap_allocs_objects_total

   - once executed you can see result in unstacked or stacked view as you wish.

   - you can also change the result in table, graph, explain as per requirement.

### Setup Grafana
   - Go to docker and run below command to pull grafana image.
         
          docker pull grafana/grafana
   - Run grafana using below docker command

          docker run -d -p 3000:3000 grafana/grafana

   - Hit below Url to check Grafana is running.

         localhost:3000/
   - Now provide below credentials to login grafana.
         
         Username: admin
         pass: admin
   - Now it will ask to change the password you can either change the password or skip.

### Step to create Datasource

   - click on 3 lines menu

   - click on connections

   - search prometheus and click on add new datasource button on right side.

   - select name Prometheus

   - In Prometheus server URl  <Docker container ID>:<prometheus port> Example: http://172.17.0.1:9090

   - click on save and test
   - 

### Step to create the dashboard on grafana 
   
   - click on dashboard

   - Click on + create dashboard option

   - now click on + add visualization 

   - Now at below Queries option select datasource as 'prometheus'

   - Now you can choose Builder or code option right to the run queries.

         if you choose builder option you can select metrics and run queries.

         if you will select code then you have to run the grafana query as shown below.

           rate(http_server_requests_seconds_count[1m])

## Thanks


