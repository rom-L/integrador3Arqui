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

![localhost_8080_estudiantes - My Workspace 11_2_2023 9_16_00 PM](https://github.com/Skpone/integrador3Arqui/assets/72869504/79926866-e72c-49aa-90be-5118a7b58e3b)

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

![2 b](https://drive.google.com/file/d/14TUIoNofka1xlMZ95Aag6UKgDgrBQDf_/view?usp=sharing)

---
### **C) Recupera estudiantes ordenado por DNI Desc**:
**_Endpoint:_** GET`localhost:8080/estudiantes/OrderByDNI`

![2 c](https://drive.google.com/file/d/1hCZ-8BRRCu9niwQrmKu2ldR8k6FAgbYO/view?usp=sharing)

---
### **D) Recupera un estudiante by numero libreta**:
**_Endpoint:_** GET`localhost:8080/estudiantes/getByLibreta/{nroLibreta}`

![2 d](https://drive.google.com/file/d/1DUJrnDD5JgXh_fsmoAaInmoFsCHakSGJ/view?usp=sharing)

---
### **E) Recupera estudiantes by genero**:
**_Endpoint:_** GET`localhost:8080/estudiantes/getByGenero/{genero}`

![2 e](https://drive.google.com/file/d/1OEQZa6jF3h_V3swI-Out8ccePCE8jX5I/view?usp=sharing)

---
### **F) Recupera carreras con estudiantes inscriptos ordenado por cant. inscriptos**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/carrerasConInscriptos`

![2 f](https://drive.google.com/file/d/1r4PBFJ7fl-qrnMFi3ADSX8zzeBENWFzs/view?usp=sharing)

---
### **G) Recupera estudiantes de una carrera especificada filtrado por ciudad de residencia**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/getEstudiantesByCarrera/{idCarrera}/filterByCiudad/{ciudad}`

![2 g](https://drive.google.com/file/d/1m70usyWxe3qaro5rOSTht8TuH4xprs1Q/view?usp=sharing)

---
### **H) Genera reporte**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/reporte`
![2 h](https://drive.google.com/file/d/1QujLU5UXNzE-iS5J2-l-pxBw9QYeFg3H/view?usp=sharing)

---
