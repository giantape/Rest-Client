[![CircleCI](https://circleci.com/gh/giantape/Rest-Client.svg?style=svg)](https://circleci.com/gh/giantape/Rest-Client)
# Rest-Client
Spring boot Rest-Client  

### Categories
GET /api/v1/categories  
GET /api/v1/categories/{id}  

### Customers
GET /api/v1/customers  
POST /api/v1/customers  
GET /api/v1/customers/{id}  
PUT /api/v1/customers/{id}  
PATCH /api/v1/customers/{id}  
DELETE /api/v1/customers/{id}  `

### Example of GET /api/v1/customers
```
{
    "customers": [
        {
            "firstname": "Giant",
            "lastname": "Ape",
            "customer_url": "/api/v1/customers/1"
        },
        {
            "firstname": "Konstantin",
            "lastname": "Diyachkov",
            "customer_url": "/api/v1/customers/2"
        },
        {
            "firstname": "Denés",
            "lastname": "Albrech",
            "customer_url": "/api/v1/customers/3"
        }
    ]
}
```

### junit4 test
/mappers/*  
/controllers/*  
/services/*  
