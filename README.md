# About this Repository: updated for my project assignment for Java Web Development!

## Run the location service (Boogle maps)

In the "boogle-maps" module, run BoogleMapsApplication, and you can check it by going to:
http://localhost:9191/maps/?lat=20.0&lon=30.0

## Run the pricing-service

In the "car-eureka-server" module, run the Eureka server (CarEurekaApplication), which is on port 8761.
View the Eureka server console at:
http://localhost:8761

Next, in the "pricing-service" module, run the pricing microservice (PricingServiceApplication), which runs on port 8762.
Check the h2 db at http://localhost:8762/h2

To log into the h2 console:
  - JDBC URL is jdbc:h2:mem:cars
  - username is "sa", and no password.

Check the Eureka console again, you will see pricing-service instance is running:
http://localhost:8761

## Run the Vehicles API

In the "vehicles-api" module, run the API (VehiclesApiApplication), which is on port 8080.
Access the API, such as with cURL or Postman, at:
http://localhost:8080/cars

And better than that, you can access it via the Swagger UI, which will show you
all the API requests, their valid inputs, and submit the requests for you:
http://localhost:8080/swagger-ui.html

-----------
## Original ReadMe, below (before it was forked to this repo).
-----------
This repository is related to the Java Web Developer (ND035), Course - **Web Services and APIs**

It contains the following folders:
1. Exercise-Lesson2: Contains the classroom exercise
2. P02-VehiclesAPI: This folder contains a project readme file that has the instructions to follow

>**Note**: Generally, you cannot clone a particular folder to your local system. Instead, you clone the *entire repository*, as explained below:

### How to clone this repository
#### Step 1 - Fork the repository
Make a copy of this repository in your Github account. You can do so by clicking `Fork` on the top right corner of this repository. 
<br>
<br>

#### Step 2
Once a copy of the repository is forked to your Github account, you can copy the repository HTTP URL, such as `https://github.com/YOUR_ACCOUNT_NAME/nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter.git`


Now, you will need to clone (download) the repository locally in your system. There are two ways to clone this repository locally (choose any one):
1. **Download the repo using the command-line terminal**:
You can run the following commands in your terminal (macOS/Linux)/Gitbash (Windows). In the first command, use the HTTPS URL copied in the step above. 
```bash
git clone https://github.com/udacity/nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter.git
cd nd035-C2-Web-Services-and-APIs-Exercises-and-Project-Starter
```


2. **Clone directly in your IntelliJ IDE**: 
IntelliJ provides VCS (Version Control System) menu to import a Github repository directly into your IntelliJ IDE. You can even perform all standard operations within your IDE, such as, add, commit, push, pull, merge, switch branch, etc. For more info, refer to the blog [Clone a Project from GitHub](https://blog.jetbrains.com/idea/2020/10/clone-a-project-from-github/), or [Instructions to Importing a project ](https://www.jetbrains.com/help/idea/import-project-or-module-wizard.html)

>**Note** - If the imported project is not shown as a Maven project, simply right-click on the `pom.xml` file, and choose to add it as a Maven project.


## License
[License](LICENSE.txt)
