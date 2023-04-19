# Your Grocery Finder

## What is it?
Your Grocery Finder is a web application i wanted to create to make it easier for people to find their favorite brand groceries in any shop. I noticed that cans of monster enegry were slowly disappearing from the stores even though its my favorite drink. Instead of having to look at every individual store website i thought it would be nice to have 1 big website where i am able to find all these products with ease.

## How it Works
Your Grocery finder works by getting all of the items from different stores into a database and then showing it to the user.
For this i need a few different things:
+ A front-end where the user can search for products.
+ A database where all the products are stored.
+ A back-end that connects the front-end with the database.
+ A Scraper to get all the products from the different websites.

### The front-end
The programming language for the front-end is Vue 3. I Chose to use Vue because it was recommended in allot of places. It is easier to learn the most other programming languages because there is a big community behind it, there are no regular updates so it wont change as much as others, it is intuitive and has great documentation.

### The Database

### The back-end

### The Scaper
For the scraper i used the Jsoup library. Like most web scraper is consists of 3 main parts:
1. The HTTP Client. <br />
The HTTP Client is the part of a scraper where you define the web page you want to scrape from like seen in the code below.
```java
Document doc = Jsoup.connect("https://www.jumbo.com/producten/?offSet=" + i).get();
```
The i variable in this code stand for the number of the page to go to. 
The jumbo website has pages. This means that all the products are scattered over different pages. 
To overcome this problem i made a for loop. It starts at 0 and stops at the total amount of products are on the page(which is 18744 at this time).
Since there are 24 products on each page, every loop adds 24 to the 0.

2. The HTML Parser. <br />
With the HTML parser you indicate which part of the web page you want to scrape. 
In this case we start by selecting the product container, this whole item on the page:

![](https://i.imgur.com/n3yZsBT.png)

Then of that item you want to select the text, image and price. All of this is showed in the code below.

```java
 Elements products = doc.select(".product-container");

  // Print the text content of the links
  for (Element product : products) {
      String name = product.select(".title-link").text();
      String image = product.select(".image").attr("src");
      String price = product.select(".whole").text() +"."+ product.select(".fractional").text();
  }
```
3. Data Storage. <br />
Then when you get the data, you want to store it. This is done via the ```InsertNewProducts()``` function from our database.
```java
_db.InsertNewProducts(name, image, price, "Jumbo");
```
