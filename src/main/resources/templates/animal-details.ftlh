<!DOCTYPE html>
<html lang="en">
<head>
    <title>Detailed Animal Page</title>
    <link rel="stylesheet" href="/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css"
          integrity="sha384-X38yfunGUhNzHpBaEBsWLO+A0HDYOQi8ufWDkZ0k9e0eXz/tH3II7uKZ9msv++Ls" crossorigin="anonymous">
</head>

<!--Normal header from our own CSS file-->
<div class="header">
    <img src="/images/logo.jpg" alt="Cats vs Dogs"
         width="500" height="142">
    <h1>Cats Vs. Dogs</h1>
</div>
<br>

<!--Same Navigator as on the other htmls, received this from pure-CSS-->

<div class="pure-menu custom-restricted-width">
    <span class="pure-menu-heading">Navigator</span>
    <ul class="pure-menu-list">
        <li class="pure-menu-item">
            <a href="all" class="pure-menu-link">Back to Matchups of the Day</a>
        </li>
        <li class="pure-menu-item">
            <a href="new" class="pure-menu-link">Create New</a>
        </li>
        <!--    Does not lead anywhere, as there is no social media, just looks weird with only two-->
        <li class="pure-menu-item">
            <a href="/animals/update/${animal.animalId?c}" class="pure-menu-link">Update / Delete</a>
        </li>
    </ul>
</div>
<br><br>

<div style="text-align: center;">
    <h2>${animal.name}</h2>
    <img src="/images/${animal.name}.png" alt="${animal.name}"
         width="500" height="350" class="animal-img"><br><br>

    <table class="pure-table" style="margin: 0 auto; width: 60%;">
        <thead>
        <tr>
            <th>About ${animal.name}</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${animal.description}</td>
        </tr>
        </tbody>
    </table>
</div>

<br><br>

<!--This does not really do anything as for the assignment I didn't need to add more functionality, but it is in spirit of the 'website' to allow arbitrary votes.-->
<form class="pure-form" action="/vote" method="post">
    <fieldset>
        <legend>Enter your email and vote if you think ${animal.name} is the cutest!</legend>
        <input type="hidden" name="animalName" value="${animal.name}">
        <input type="email" name="email" placeholder="Email" required/>
        <button type="submit" class="pure-button pure-button-primary">Submit!</button>
    </fieldset>
</form>

<!--Normal footer from our own CSS file-->
<div class="footer">

</div>
</html>
