# adidasPublicService
Public layer for the subscription service, it receive petitions and redirect to the SubscriptionService
TODO:
It's nessesary to solve a bug which the body always receive a LinkedHashMap<String, LinkedHashMap<String, List<String>>> instead Subscription, List<String> or any other type, it affect to CreateSubscription and GetManySubscriptions
It's necesary to fix an error on the GetManySubscription flow, which the method on SubscriptionService doesn't receive the body of the petition sended
Improve the security
Make JUnit Tests

There is a Postman collection on src/main/resources/postmanCollection/Aidas Public Service.postman_collection.json and a SwaggerIO json file on src/main/resources/swaggerIo/publicServiceSwagger.json
The URL for Swagger is http://localhost:8082/swagger-ui/index.html?configUrl=/v3/api-docs
