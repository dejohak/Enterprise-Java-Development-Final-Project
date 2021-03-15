# Final Project: Recipes Blog

Disclaimer: 

In this project I tried to create a blog of recipes based on an Instagram Account that my girlfirend has: Baking With Juli. 
At first, I wanted to add authentication using this tutorial: https://www.baeldung.com/rest-api-spring-oauth2-angular. But, unfortunately,
I was not able to implement it. After many hours spent in this failed task, I had to re-scope the blog without the authentication of users.
The initial idea was: Only 1 admin could create posts, and only authorised users could like/dislike posts and add comments to the forum. 
Since I had to change this due to my incapability to implement that authentication, everyone can add comments or create posts.

Another problem I encountered was with the Like feature on the Forum. The Likes service was supposed to store the popularity of recipes and, also, 
the popularity of comments in the forum. As of today: 14/3/2021, I haven't been able to implement, but hopefully I will do it in the following days.

# BAKING WITH JULI angular web app

Do you love baking? Or you just have a sweet tooth?

## How to install it

1. Clone the repository

2. The recipes and forum services both use Mongo DataBases (NoSQL), so you'll need to install it (+ Robo 3T to visualise data if needed). Follow the instructions in
https://docs.mongodb.com/manual/installation/

3. You will have to create the databases based on the information stored in the .JSON files of the repository: recipes.json and forum.json. This task can be accomplished
with Postman, Robo 3T or the App (vie Create Recipe or Add comments).

4. The likes service uses an SQL database. You will find the sql file in the repository plus the information of the popularity of each recipe already created in the likes.json file.
As commented in the last step, you can add this information via Postman or in the WorkBench you are using to visualise sql data.

5. Once you are set, you will have to build the Eureka server and then build the edge service and every microservice.

6. Having done that, you can type localhost:4200/ on your browser and enjoy the app.

## Inside the app

There are 5 main components: 
  1. Home: which is just the "cover webpage" with the logo of the blog.
  2. Recipes: where you will find the recipes already listed.
  3. Searcher: you can search recipes by Flavour, Baked Good, Ingredients or Name. 
  4. Recipe creator: adding a recipe to the blog is very easy. Just fill the form with all the information required and you are all set! 
  5. Forum: everyone can say anything about the recipes.
  
  In the recipes component there is also a side element called Popular Recipe. This element is supposed to show the most liked recipe. I could not make it load
  the popular recipe when loading the webpage, as the ngOnInit or Constructor don't fetch the data as I expected. BUT when you click LIKE or DISLIKE to ANY recipe,
  the most liked recipe will show as it should in the element. I'll try to work out how to make it load when the page is loaded and not having to wait until any recipe
  is liked or disliked.

  It is expected to be another component called Contact: which will be used to send emails to the creator. But still work in progress. So as the authorisation component.

## Pictures of the web

![Alt_Text](https://github.com/dejohak/Enterprise-Java-Development-Final-Project/blob/master/Captura%20de%20pantalla%202021-03-14%20a%20las%2022.30.59.png)

![alt_text](https://github.com/dejohak/Enterprise-Java-Development-Final-Project/blob/master/Captura%20de%20pantalla%202021-03-14%20a%20las%2022.39.02.png)

![alt_text](https://github.com/dejohak/Enterprise-Java-Development-Final-Project/blob/master/Captura%20de%20pantalla%202021-03-14%20a%20las%2022.39.36.png)

![alt_text](https://github.com/dejohak/Enterprise-Java-Development-Final-Project/blob/master/Captura%20de%20pantalla%202021-03-14%20a%20las%2022.39.50.png)

![alt_text](https://github.com/dejohak/Enterprise-Java-Development-Final-Project/blob/master/Captura%20de%20pantalla%202021-03-14%20a%20las%2022.40.04.png)
