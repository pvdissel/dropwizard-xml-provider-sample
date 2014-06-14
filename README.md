dropwizard-xml-provider-sample
==============================

Steps to show that adding the `jackson-jaxrs-xml-provider` is enough to add XML support to DropWizard:

1. Execute `gradlew run` (`jackson-jaxrs-xml-provider` dependency is enabled in this sample)
2. Go to [http://localhost:8080/hello-world?name=My%20Name%20Is](http://localhost:8080/hello-world?name=My%20Name%20Is)  
   This will probably show XML output as browsers commonly sent the accept header for xml.
   If not, then use a REST client of some kind and do the request with the `application/xml` accept header
3. Edit the file `gradle/dependencies.gradle` and comment the following out `libraries.jacksonProviders,`
4. Execute step 1 and 2 again. You will see a error 500 now