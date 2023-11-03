# integrador3Arqui

**_Aclaracion_**: Si se rompen los .csv borrar 'integrador3Arqui' en el file path

<br></br>

### **A) Insertar estudiante**:

**_Endpoint:_** POST`localhost:8080/estudiantes`
<br></br>

`{
    "dni": "857647363",
    "nombres": "Walter",
    "apellido": "White",
    "edad": 20,
    "genero": "Male",
    "ciudadResidencia": "Albuquerque",
    "numeroLibreta": "A123456"
}`

---
### **B) Matricular estudiante a una carrera**:

**_Endpoint:_** POST`localhost:8080/matriculaciones`
<br></br>

`{
    "estudiante": {
        "dni": "444555666"
    },
    "carrera": {
        "id": "2"
    },
    "anioInscripcion": "2020",
    "anioGraduacion": "2024",
    "antiguedad": "3"
}`

---
### **C) Recupera estudiantes ordenado por DNI Desc**:
**_Endpoint:_** GET`localhost:8080/estudiantes/OrderByDNI`

---
### **D) Recupera un estudiante by numero libreta**:
**_Endpoint:_** GET`localhost:8080/estudiantes/OrderByDNI/getByLibreta/{nroLibreta}`

---
### **E) Recupera estudiantes by genero**:
**_Endpoint:_** GET`localhost:8080/estudiantes/getByGenero/{genero}`

---
### **F) Recupera carreras con estudiantes inscriptos ordenado por cant. inscriptos**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/carrerasConInscriptos`

---
### **G) Recupera estudiantes de una carrera especificada filtrado por ciudad de residencia**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/getEstudiantesByCarrera/{idCarrera}/filterByCiudad/{ciudad}`

---
### **H) Genera reporte**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/reporte`

---