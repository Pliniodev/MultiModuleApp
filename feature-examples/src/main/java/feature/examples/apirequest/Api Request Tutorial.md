To do a request to a Api follow this steps. This step is how i normally do.

I try to initiate from the infrastructure of the request, that is, from the config of Retrofit.
In our case in this project, that happens on the di file. 

Here, we consider that the baseUrl of the api is already config in project

1 - Config the Retrofit on the di file, in example module this happens on 
[apiRequestJsonPlaceHolderModule](https://github.com/Pliniodev/MultiModuleApp/blob/master/feature-examples/src/main/java/feature/examples/di.kt) 
module of koin -> BuildRetrofit

2 - In data package create a gateway file and config that in the di file like as we did in JsonPlaceHolderGateway

3 - Look on the documentation of the api that you desire, to identify the json response

4 - Create a file in response package to put the response object like [PostResponse](https://github.com/Pliniodev/MultiModuleApp/blob/master/feature-jsonplaceholder/src/main/java/feature/jsonplaceholder/data/response/PostResponse.kt)

5 - Create the model file, in the domain layer, in the model package to put the domain object like [Post]()

6 - Now create a mapper to transform(parse, map) the response object of the data layer in the object of the domain layer like [PostMapper]() or similar to that depending of the response of the api

7 - Create a interface of service, like [JsonPlaceHolderService]() we use that on the infrastructureImpl

8 - Go to the di file to config the infrastructureImpl injecting the gateway on it

9 - Now your infra is done!

10 - From here you must to create the activity and viewModel and inject the service in viewModel.