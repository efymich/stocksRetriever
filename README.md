# stockRetriever
A pet project developed during the JavaRush course.

The task was to implement a REST app for retrieving and storing historical stock price data.
For this, a client was created to interact with [Polygon.io](https://polygon.io).

### Main features of the application:

1. User authorization, including registration and login.

2. Viewing historical stock price data.
This is the main function of the application, which will use Polygon.io to retrieve data.
The user can select specific stocks and a time period.

3. Saving historical stock price data.
After loading the data, the application should automatically save it in the database for future use.

4. Viewing saved data.
The user can view previously loaded and saved data without connecting to Polygon.io.

### Endpoints:

* POST /api/v1/user/signup 
* POST /api/v1/user/login
* GET /api/v1/stock/saved
* POST /api/v1/stock/save
* GET /api/v1/stock

### Docker manual
You need to build application first calling ``gradle bootJar``,

then ``docker build -t stock-retriever:1.0.0 . ``
``docker-compose up --build``