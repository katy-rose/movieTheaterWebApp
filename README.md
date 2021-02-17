# movieTheaterWebApp
CS 4336 Advanced Java Semester Project</br>
In this project you will create a web application for a movie theater.
</br></br>
File descriptions:

**ENTITY FILES BASED ON DATABASE TABLES** </br>
Dfwtheaters.java 
- theater name, address, and zipcode

Movies.java 
- movie title, release date, rating, genre, runtime, synopsis

Moviesbytheater.java / MoviesbytheatherPK.java 
- movie title and theater name where it's playing

Showtimes.java / ShowtimesPK.java 
- theater, movie, and showtimes

Zipcodes.java 
- list of area zipcodes

</br></br>
**EJB**</br>
MovieDB_EJB.java 
- EJB that calls named queries to support looking up zipcodes, theaters, movies, and showtimes

</br></br>
**CDI BEANS**</br>
MainPageBean.java
- Supports mainpage.xhtml by calling EJB to look up all zipcodes

TheaterListBean.java
- Supports TheaterList.xhtml by calling EJB to look up list of theaters for selected zipcode

MoviesByTheaterBean.java
- Supports MoviesByTheater.xhtml by calling EJB to look up a list of movies playing at the selected theater

MovieInfoBean.java
- Supports MovieInfo.xhtml by calling EJB to look up a list of showtimes for the selected movie 

PurchasePageBean.java
- Supports PurchasePage.xhtml and ConfirmationPage.xhtml by recording selected movie/theater/showtime, calculating total cost for tickets, and recording credit card and billing zipcode

</br></br>
**JSF PAGES**</br>
MainPage.xhtml
- Home page / Displays list of zipcodes

TheaterList.xhtml
- Displays list of theaters in chosen zipcode

MoviesByTheater.xhtml 
- Displays movies playing at selected theater

MovieInfo.xhtml
- Displays selected movie's information and showtimes

PurchasePage.xhtml
- Page to input number of tickets, credit card, and billing zipcode to purchase tickets

ConfirmationPage.xhtml
- Displays ticket, movie, and theater info for purchased tickets
