# Cats Vs. Dogs Backend API
## Description
Simple CRUD API for to generate Animal objects that are either cats or dogs.  Saves them in both the animal and respective breed trees.

## API Endpoints
Base URL: [`http://localhost:8080/students`](http://localhost:8080/animals)

### [`/all`](http://localhost:8080/animals/all) (GET)
Gets a list of all animals in the database.

#### Response - A JSON array of Student objects.

 ```
[
    {
        "animalId": 8890,
        "name": "Gerald",
        "description": "Sucks",
        "breed": "Dog"
    },
    {
        "animalId": 8892,
        "name": "I grow tired",
        "description": "Miserable",
        "breed": "cat"
    }
]
```

### [`/{animalId}`](http://localhost:8080/students/8888) (GET)
Gets an individual Animal in the system. Each animal is identified by a numeric `animalId`

 ```
[
{
    "animalId": 8888,
    "name": "Reyna",
    "description": "Fluffy",
    "breed": "Dog"
}
]
```

#### Parameters
- Path Variable: `animalId` &lt;integer&gt; - REQUIRED


### [`/name`](http://localhost:8080/students/name?search=reyna) (GET)
Searches the animal database for the same name.

#### Parameters
- query parameter: `search` lt;String&gt; - REQUIRED

#### Response - A JSON array of Student objects.

```
[
    {
        "animalId": 8888,
        "name": "Reyna",
        "description": "Fluffy",
        "breed": "Dog"
    }
]
```


### [`/major/{major}`](http://localhost:8080/animals/breed/{breed}) (GET)
Gets a list of animals of the specific breed.

#### Parameters
- path variable: `breed` &lt;String&gt; - REQUIRED

#### Response - A JSON array of Student objects.

```
[
    {
        "animalId": 1738,
        "name": "Johnson",
        "description": "Fluffy",
        "breed": "Cat"
    },
    {
        "animalId": 8889,
        "name": "Thomas",
        "description": "Hatred",
        "breed": "cat"
    },
    {
        "animalId": 8892,
        "name": "I grow tired",
        "description": "Miserable",
        "breed": "cat"
    }
]
```

### [`/new`](http://localhost:8080/animals/new) (POST)
Create a new animal entry and it will also put it in the applicable animal table.
 
#### Request Body
An animal object. Note that the animalId is auto assigned in the database so is not needed in the request.
```
{
    "name": "I grow tired",
    "description": "Miserable",
    "breed": "cat"
}
```
#### Response - The updated list of Animals.

```
[
    {
        "animalId": 1738,
        "name": "Johnson",
        "description": "Fluffy",
        "breed": "Cat"
    },
    {
        "animalId": 8888,
        "name": "Reyna",
        "description": "Fluffy",
        "breed": "Dog"
    },
    {
        "animalId": 8889,
        "name": "Thomas",
        "description": "Hatred",
        "breed": "cat"
    },
    {
        "animalId": 8890,
        "name": "Gerald",
        "description": "Sucks",
        "breed": "Dog"
    },
    {
        "animalId": 8892,
        "name": "I grow tired",
        "description": "Miserable",
        "breed": "cat"
    },
    {
        "animalId": 8893,
        "name": "Locked in",
        "description": "Working",
        "breed": "DoG"
    }
]
```

### [`/update/{animalId}`](http://localhost:8080/animals/update/8888) (PUT)
Update an existing Student.

#### Parameters
- Path Variable: `animalId` &lt;integer&gt; - REQUIRED

#### Request Body
A animal object with the updates.
```
{
    "name": "Updated the Name",
    "description": "Updated animal.",
    "breed": "Dog"
}
```
#### Response - the updated Student object.
```
{
    "animalId": 8888,
    "name": "Updated the Name",
    "description": "Updated animal.",
    "breed": "Dog"
}
```


### [`/delete/{studentId}`](http://localhost:8080/students/delete/8888) (DELETE)
Delete an existing Student.

#### Parameters
- Path Variable: `animalId` &lt;integer&gt; - REQUIRED

#### Response - the updated list of Students.
```
[
    {
        "animalId": 1738,
        "name": "Johnson",
        "description": "Fluffy",
        "breed": "Cat"
    },
    {
        "animalId": 8889,
        "name": "Thomas",
        "description": "Hatred",
        "breed": "cat"
    },
    {
        "animalId": 8890,
        "name": "Gerald",
        "description": "Sucks",
        "breed": "Dog"
    },
    {
        "animalId": 8892,
        "name": "I grow tired",
        "description": "Miserable",
        "breed": "cat"
    },
    {
        "animalId": 8893,
        "name": "Locked in",
        "description": "Working",
        "breed": "DoG"
    }
]
```
