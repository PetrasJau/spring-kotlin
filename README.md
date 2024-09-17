# Sample project for Spring Boot and Kotlin

Gradle is used as a build tool. It is also used to manage dependencies.

## Running the application

### Prerequisites

You will need to have the following installed on your machine:

* [JDK 21](https://www.oracle.com/java/technologies/downloads/)
* [Gradle](https://gradle.org/install/)

### Building and running the application

```
./gradlew bootRun
```

The application will start on port 8080. You can then access it in your web browser at [http://localhost:8080](http://localhost:8080).

## Testing the application

### Unit tests

No unit tests are provided with this project. You can run them with the following Gradle task:

```
./gradlew test
```


## Routing

This project uses the following routing:
Routes are split into two groups: search and user endpoints.
Search endpoints:
* GET `/api/search/artists?term=term` - searches for artists with the given search term (String)
* GET `/api/search/albums?amgArtistId=amgArtistId` - searches for top 5  albums of the given artist (Int)

User endpoints:
* GET `/api/favorite/` - returns a list of all favorite artists for the user
* POST `/api/favorite/?artistId=artistId` - saves a favorite artist id (Int)
* DELETE `/api/favorite/?artistId=artistId` - removes a favorite artist id (Int)
All user endpoints require a `userId` header with the user id.
