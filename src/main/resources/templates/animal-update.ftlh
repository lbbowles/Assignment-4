<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<title>Admin Page - Update and Delete.</title>
<body>

<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;">
    <a class="navbar-brand" href="/animals/all" style="margin: 10px;">
        <img src="/images/logo.jpg" alt="Logo" width="80" height="60">
    </a>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/animals/all">Home / List View</a>
        </li>
    </ul>
</nav>

<div class="container mt-4">
    <h2> Update or Delete Existing Animal</h2>

        <form action="/animals/update/${animal.animalId?c}" method="post">
            <input type="hidden" name="animalId" value="${animal.animalId?c}">


            <!--Website is only for two types of animals: cats or dogs. -->
            <div class="mb-3">
                <label for="type" class="form-label">Animal Type</label>
                <select name="type" id="type" class="form-select" required>
                    <option value="Dog" <#if type == "Dog">selected</#if>>Dog</option>
                    <option value="Cat" <#if type == "Cat">selected</#if>>Cat</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" name="name" value="${animal.name}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <input type="text" name="description" value="${animal.description}" class="form-control" required>
            </div>

            <!--Obviously redundant, but I could not figure out how to resolve this since I made the decision to make 3 databases for fun in Assignment 4 -_- -->
            <div class="mb-3">
                <label for="breed" class="form-label">Breed</label>
                <input type="text" name="breed" value="${animal.breed}" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
            <!--Take back to home page.-->
            <a href="/animals/all" class="btn btn-outline-danger">Cancel</a>
        </form>

        <br><br>
        <!--Also allow for deletion on this page as it would be meant for admins. -->
        <a href="/animals/delete/${animal.animalId?c}" class="btn btn-danger">
            Delete
        </a>

    </div>

</body>
</html>
