# Spring boot crm on Kotlin

#### Build with spring boot and other spring staff and with ❤️
_By LKNM team_

### To start server side app:

* Create `.env` file, it should look like this:
````
PG_PORT=5432
PG_DB=crm_yalynky
PG_USER=postgres
PG_PASS=postgres
PG_HOST=postgres # or localhost if you don't want to user postgres service

APP_PORT=8088 # then your app will available on localhost:8088
APP_SECRET=51L6nFI7EOUWsuIx7VW2ntjeRmVWY1Kc
HIBERNATE_STRATEGY=create # or validate or whatever
````

* Run `docker-compose up`

