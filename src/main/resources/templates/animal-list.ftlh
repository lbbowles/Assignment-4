<!DOCTYPE html>
<html lang="en">

<!--Utilizing href pure-CSS as recommended-->
<head>
    <title>Dog vs. Cat</title>
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css"
          integrity="sha384-X38yfunGUhNzHpBaEBsWLO+A0HDYOQi8ufWDkZ0k9e0eXz/tH3II7uKZ9msv++Ls" crossorigin="anonymous">
</head>
<body>
<!--Show a cool header that will be present on every page, just a simple banner-->
<div class="header">
    <img src="/images/logo.jpg" alt="Dogs v Cats"
         width="500" height="142">
    <h1>Cats Vs. Dogs</h1>
</div>

<div class="pure-menu custom-restricted-width">
    <span class="pure-menu-heading">Navigator</span>
    <ul class="pure-menu-list">
        <li class="pure-menu-item">
            <a href="/animals/all" class="pure-menu-link">Back to Matchups of the Day</a>
        </li>
        <li class="pure-menu-item">
            <a href="new" class="pure-menu-link">Create New</a>
        </li>
    </ul>
</div>
<br> <br>

<!--Place all matchups below and generate a link that corresponds with the selection made by the user to view.
All  the matches are literally the exact same besides the link they lead to (obviously they lead to the same thing for
this assignment) and the images of the animals. -->

<!--In regard to the comment above, it is now irrelevant; a token of the past.  The idea of the website has pivoted to
 just a rotating list of animals (cats and dogs) that can be voted on and there is one winner.  That being said, I did not
 add true functionality for the voting system as it is not required for the assignment.-->


<h2>All Our Current Animals (Click to see them!)</h2>
<ul>
    <#list animalList as animal>
        <li>
            <strong>${animal.name}</strong> — ${animal.description}
            <br>
            <a href="/animals/${animal.animalId?c}">View Animal</a>
        </li>
    </#list>
</ul>


<!--End of the matchups for the day; put a little blurb about the website, could be replaced
 with anything like links to social media or whatever else.-->
<br> <br>
<div class="footer">
    <p>
    </p>
</div>

</body>
</html>