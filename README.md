# Aplicación Curso 4 semana 1

El API de instagram presentó uno cambios se seguridad que eliminaron los End Point necesarios para
realizar la tarea como esta planteada en esta semana.

He adaptado la aplicación para usar los endpoint disponibles en la versión actual.

Se ha implementado los siguientes Endpoint:

Para acceder a imagenes recientes del usuario

https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

y

https://api.instagram.com/v1/tags/{tag-name}/media/recent?access_token=ACCESS-TOKEN

para buscar por etiquetas con cuentas Sandbox.

En mi caso utilizo las cuentas solitario403 y jhernanramirezr de instagram para poder hacer el ejercicio.

Con cada una de estas cuentas se subieron fotos con la etiqueta #mascota y #cafe de modo que podamos hacer busquedas al menos con esas etiquetas.

## Utilización del API y Retrofit

No utilizo la serialización que se dió en el curso; por el contrario utilizo clases generadas por http://www.jsonschema2pojo.org/ apoyadas en com.google.gson.annotations.SerializedName que resulta mas sencillo de desarrollar.

## Modelo MVC

Se utiliza el MVC un poco mas simplificado de manera que el ejercicio sea mas legible. Por ser un proyecto pequeño utilizo solo una intrefaz por cada vista y a partir de alli monto el presentador y la implementación.

## Captura de pantallas

![Listado Inicial](https://raw.githubusercontent.com/hernanramirez/pentagram_curso4_semana1/master/docs/img/PantallaInicial.png)
![Listado Inicial](https://raw.githubusercontent.com/hernanramirez/pentagram_curso4_semana1/master/docs/img/PatallaInicialMenu.png)
![Listado Inicial](https://raw.githubusercontent.com/hernanramirez/pentagram_curso4_semana1/master/docs/img/PantallaConfig.png)
![Listado Inicial](https://raw.githubusercontent.com/hernanramirez/pentagram_curso4_semana1/master/docs/img/PantallaSearchTag.png)

