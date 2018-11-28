# WorkforceApp


Steps to build and deploy the project :

git clone https://github.com/SridharanMurugadass/WorkforceApp

cd WorkforceApp

mvn clean install

java -jar WorkforceApp-0.0.1.jar

Note : Please use java version > 8. since the application written in spring boot. so spring boot doesn't support java version < 8. And you can deploy directly using the above mentioned command.




Demo Testing :

    i have deployed this application in cloud for testing purposes. please use the below url in restclient tools like postman, ADC or insomnia,.. 
    
    
    Demo url        : https://workforce-app.herokuapp.com/data
    Method          : POST 
    Content-Type    : application/json
    Request         : { "rooms": [35, 21, 17], "senior":10, "junior": 6 }
    
    Result          :  [
    {
        "Junior": 1,
        "Senior": 3
    },
    {
        "Junior": 2,
        "Senior": 1
    },
    {
        "Junior": 0,
        "Senior": 2
    }]



  You can try with any kind of input values in the service request. And you will get the appropriate result as per your input data. Cool (:




