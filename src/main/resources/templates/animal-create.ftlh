<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<title>Admin Page - Create Animal.</title>
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

<!--Form for creating new animal-->
<div class="container mt-4">
    <h2> Create Animal</h2>

    <form action="/animals/new" method="post">

        <!--Website is only for two types of animals: cats or dogs. -->
        <div class="mb-3">
            <label for="type" class="form-label">Animal Type</label>
            <select name="type" id="type" class="form-select" required>
                <option value="Dog">Dog</option>
                <option value="Cat">Cat</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="text" class="form-control" id="description" name="description" placeholder="Description" required>
        </div>

        <div class="mb-3">
            <label for="breed" class="form-label">Breed</label>
            <input type="text" class="form-control" id="breed" name="breed" placeholder="Breed" required>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/animals/all" class="btn btn-outline-danger">Cancel</a>
    </form>

</div>

</body>
</html>
