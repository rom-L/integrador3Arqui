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


![Meet - ybi-duqe-eds — Mozilla Firefox 11_2_2023 9_17_04 PM](https://github.com/Skpone/integrador3Arqui/assets/72869504/7d9693e0-0da3-40a1-887f-e5ce523aed75)

---
### **C) Recupera estudiantes ordenado por DNI Desc**:
**_Endpoint:_** GET`localhost:8080/estudiantes/OrderByDNI`

![Meet - ybi-duqe-eds — Mozilla Firefox 11_2_2023 9_17_47 PM](https://github.com/Skpone/integrador3Arqui/assets/72869504/6f443936-92e8-48e1-b7b1-46416092b067)


---
### **D) Recupera un estudiante by numero libreta**:
**_Endpoint:_** GET`localhost:8080/estudiantes/getByLibreta/{nroLibreta}`

![Meet - ybi-duqe-eds — Mozilla Firefox 11_2_2023 9_19_28 PM](https://github.com/Skpone/integrador3Arqui/assets/72869504/8f0123dd-f04f-4093-a071-c1ee5b0e68ba)


---
### **E) Recupera estudiantes by genero**:
**_Endpoint:_** GET`localhost:8080/estudiantes/getByGenero/{genero}`

![Screenshot 11_2_2023 9_20_10 PM](https://github.com/Skpone/integrador3Arqui/assets/72869504/40848709-d76d-4ab4-9cd4-0988f6fe2920)


---
### **F) Recupera carreras con estudiantes inscriptos ordenado por cant. inscriptos**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/carrerasConInscriptos`

![Meet - ybi-duqe-eds — Mozilla Firefox 11_2_2023 9_21_30 PM](https://github.com/Skpone/integrador3Arqui/assets/72869504/8119fd3f-01e6-4a80-b52f-16ab2f17967d)


---
### **G) Recupera estudiantes de una carrera especificada filtrado por ciudad de residencia**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/getEstudiantesByCarrera/{idCarrera}/filterByCiudad/{ciudad}`

![localhost _ 127 0 0 1 _ integrador3 _ matriculaciones _ phpMyAdmin 5 2 1 — Mozilla Firefox 11_2_2023 9_29_05 PM](https://github.com/Skpone/integrador3Arqui/assets/72869504/72ac0afb-2819-441a-8771-a335a58de151)


---
### **H) Genera reporte**:
**_Endpoint:_** GET`localhost:8080/matriculaciones/reporte`
![integrador3Arqui – MatriculacionRepository java 11_2_2023 9_48_25 PM](https://github.com/Skpone/integrador3Arqui/assets/72869504/ff7b8016-0046-4247-ae65-04f288ef8c5a)


---
