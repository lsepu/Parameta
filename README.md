# Parameta Project

Este proyecto contiene un servicio RESTful y un servicio Web SOAP para gestionar empleados.

## 1. Iniciar Base de datos MySQL usando Docker

En la raíz del proyecto, ejecuta el siguiente comando para iniciar los la base de datos definida en el archivo `docker-compose.yml`:

```bash
docker-compose up
```

## 2. Request de ejemplo para Servicio RESTful
```bash
{
  "firstName": "Juan",
  "lastName": "Doe",
  "documentType": "Passport",
  "documentNumber": "A1234567",
  "birthDate": "2004-05-12",
  "joiningDate": "2020-09-01",
  "position": "Software Engineer",
  "salary": 7500.0
}
```
Realiza una solicitud POST a:
```bash
http://localhost:8080/api/v1/employees/add
```

## 2. Request de ejemplo para Web Service (SOAP)
```bash
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:emp="http://www.example.com/employee">
    <soapenv:Header/>
    <soapenv:Body>
        <emp:EmployeeRequest>
            <firstName>John</firstName>
            <lastName>Doe</lastName>
            <documentType>Passport</documentType>
            <documentNumber>A1234567</documentNumber>
            <birthDate>1990-05-12</birthDate>
            <joiningDate>2020-09-01</joiningDate>
            <position>Software Engineer</position>
            <salary>7500.0</salary>
        </emp:EmployeeRequest>
    </soapenv:Body>
</soapenv:Envelope>

```
Realiza una solicitud POST a:
```bash
http://localhost:8082/ws/employees
```
